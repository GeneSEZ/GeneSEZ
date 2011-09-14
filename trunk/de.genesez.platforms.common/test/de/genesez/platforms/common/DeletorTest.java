package de.genesez.platforms.common;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Testclass for the FileDeletor
 * 
 * This test runs only under Java7 or above
 * 
 * @author Dominik Wetzel
 * @date 2011-09-14
 */
public class DeletorTest {
	private static Path startPath = Paths.get("./testDir/");
	private static Path firstPath = Paths
			.get("./testDir/de/genesez/testclasses/");
	private static Path secondPath = Paths.get("./testDir/de/genesez/output/");
	private static Deletor deletor;
	private static Path test1;
	private static Path test2;
	private static Path test3;
	private static Path test4;

	private static class Delete extends SimpleFileVisitor<Path> {

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
				throws IOException {
			Files.delete(file);
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc)
				throws IOException {
			Files.delete(dir);
			return FileVisitResult.CONTINUE;
		}
	}
	
	@BeforeClass
	public static void checkBeforeClass(){
		if(System.getProperty("java.version").charAt(2) < 7){
			throw new UnsupportedOperationException("Java Version below 7, Tests should fail");
		}
	}

	@Before
	public void setUp() throws IOException {
		try {
			Files.createDirectories(firstPath);
		} catch (FileAlreadyExistsException e) {
		}
		try {
			Files.createDirectories(secondPath);
		} catch (FileAlreadyExistsException e) {
		}
		try {
			test1 = Files.createFile(firstPath.resolve("test1"));
			test2 = Files.createFile(firstPath.resolve("test2"));
			test3 = Files.createFile(firstPath.resolve("test3"));
			test4 = Files.createFile(secondPath.resolve("test4"));
		} catch (FileAlreadyExistsException e) {
			System.err
					.println("At least 1 File already exists. Some tests may fail. Start again.");
		}
	}

	@After
	public void tearDown() throws IOException {
		Files.walkFileTree(startPath, new Delete());
	}

	// // BEGIN OF TESTS

	@Test
	/**
	 * Test if the test can start
	 */
	public void startTest() {
		if (!Files.exists(firstPath.resolve("test1"))) {
			fail("Something is wrong on the fileSystem. Test can't run proberly");
		}
		assertTrue(test1.equals(Paths
				.get("./testDir/de/genesez/testclasses/test1")));
	}

	@Test(expected = (Deletor.NotPreparedException.class))
	public void testNotPreparedException() {
		deletor = new Deletor(false);
		deletor.delete();
		assertTrue(Files.exists(test1));
		assertTrue(Files.exists(test2));
		assertTrue(Files.exists(test3));
		assertTrue(Files.exists(test4));
	}

	// // TESTS BEFORE JAVA 7

	@Test
	public void testPrepare() {
		deletor = new Deletor(true);
		assertEquals("Right amount of files read", 4,
				deletor.prepare(startPath.toString()));
	}

	@Test
	public void testDeleteEverything() {
		deletor = new Deletor(true);
		deletor.prepare(startPath.toString());
		assertEquals("checks if every file was deleted", 4, deletor.delete()
				.size());
	}

	@Test
	public void testDelete2Files() {
		deletor = new Deletor(true);
		deletor.prepare(startPath.toString());
		test1.toFile().setLastModified(1);
		test2.toFile().setLastModified(1);
		assertEquals("checks if 2 files were deleted", 2, deletor.delete()
				.size());
	}

	@Test
	public void testDeleteNothing() {
		deletor = new Deletor(true);
		deletor.prepare(startPath.toString());
		test1.toFile().setLastModified(1);
		test2.toFile().setLastModified(1);
		test3.toFile().setLastModified(5);
		test4.toFile().setLastModified(10);
		assertTrue("checks if nothing was deleted", deletor.delete().isEmpty());
	}

	@Test
	public void testSetOneIncludedFileExtension() {
		deletor = new Deletor(true);
		deletor.setIncludedFiles("4");
		assertEquals(1, deletor.prepare(startPath.toString()));
		assertEquals(1, deletor.delete().size());
	}

	@Test
	public void testSetMoreIncludedFileExtensions() {
		deletor = new Deletor(true);
		deletor.setIncludedFiles("est4;test3,2");
		assertEquals(3, deletor.prepare(startPath.toString()));
		assertEquals(3, deletor.delete().size());
	}

	@Test
	public void testSetOneExcludedFileExtension() {
		deletor = new Deletor(true);
		deletor.setExcludedFiles("test2");
		assertEquals(3, deletor.prepare(startPath.toString()));
		assertEquals(3, deletor.delete().size());
	}

	@Test
	public void testSetMoreExcludedFileExtensions() {
		deletor = new Deletor(true);
		deletor.setExcludedFiles("test2,4;est1");
		assertEquals(1, deletor.prepare(startPath.toString()));
		assertEquals(1, deletor.delete().size());
	}

	@Test
	public void testSetOneExcludedPath() {
		deletor = new Deletor(true);
		deletor.setExcludedRelativePaths("testDir/de/genesez/output");
		assertEquals(3, deletor.prepare(startPath.toString()));
	}

	@Test
	public void testSetMoreExcludedPaths() throws IOException {
		deletor = new Deletor(true);
		Path test = Files.createFile(startPath.resolve("test.test"));
		deletor.setExcludedRelativePaths("testDir/de/genesez/output; /testDir/de/genesez/testclasses");
		assertEquals(1, deletor.prepare(startPath.toString()));
		assertTrue(test.endsWith(deletor.delete().get(0)));
	}

	@Test
	public void testSetOneExcludedDirectoryName() throws IOException {
		Path test = Files.createFile(Files.createDirectory(
				startPath.resolve(".svn")).resolve("tester"));
		deletor = new Deletor(true);
		deletor.setExcludedDirectoryNames(".svn");
		assertEquals(4, deletor.prepare(startPath.toString()));
		test.toFile().setLastModified(1);
		assertEquals(4, deletor.delete().size());
	}

	@Test
	public void testSetMoreExcludedDirectoryNames() throws IOException {
		Path test = Files.createFile(Files.createDirectory(
				startPath.resolve(".svn")).resolve("tester"));
		Files.createFile(Files.createDirectory(startPath.resolve("en"))
				.resolve("tester"));
		Files.createFile(startPath.resolve("de").resolve("tester"));
		deletor = new Deletor(true);
		deletor.setExcludedDirectoryNames(".svn; tester;en");
		assertEquals(5, deletor.prepare(startPath.toString()));
		test.toFile().setLastModified(1);
		assertEquals(5, deletor.delete().size());
	}

	@Test
	public void testSetAllInAndExcluded() throws IOException {
		Files.createFile(Files.createDirectory(startPath.resolve(".svn"))
				.resolve("test3"));
		Files.createFile(Files.createDirectory(startPath.resolve("en"))
				.resolve("est2"));
		Files.createFile(startPath.resolve("de").resolve("tester"));
		deletor = new Deletor(true);
		deletor.setExcludedFiles("test2");
		deletor.setIncludedFiles("2;3");
		deletor.setExcludedRelativePaths("/testDir/de/genesez/output");
		deletor.setExcludedDirectoryNames(".svn; en");
		assertEquals(1, deletor.prepare(startPath.toString()));
		assertTrue(test3.endsWith(deletor.delete().get(0)));
	}

	// // TESTS WITH AT LEAST JAVA 7

	@Test
	public void testPrepare7() {
		deletor = new Deletor(false);
		assertEquals("Right amount of files read with Java 7", 4,
				deletor.prepare(startPath.toString()));
	}

	@Test
	public void testDeleteEverything7() {
		deletor = new Deletor(false);
		deletor.prepare(startPath.toString());
		assertEquals("checks if every file was deleted", 4, deletor.delete()
				.size());
		assertFalse(Files.exists(test1));
		assertFalse(Files.exists(test2));
		assertFalse(Files.exists(test3));
		assertFalse(Files.exists(test4));
	}

	@Test
	public void testDelete2Files7() {
		deletor = new Deletor(false);
		deletor.prepare(startPath.toString());
		test1.toFile().setLastModified(1);
		test2.toFile().setLastModified(1);
		assertEquals("checks if 2 files were deleted", 2, deletor.delete()
				.size());
		assertTrue(Files.exists(test1));
		assertTrue(Files.exists(test2));
		assertFalse(Files.exists(test3));
		assertFalse(Files.exists(test4));
	}

	@Test
	public void testDeleteNothing7() {
		deletor = new Deletor(false);
		deletor.prepare(startPath.toString());
		test1.toFile().setLastModified(1);
		test2.toFile().setLastModified(1);
		test3.toFile().setLastModified(5);
		test4.toFile().setLastModified(10);
		assertTrue("checks if nothing was deleted", deletor.delete().isEmpty());
		assertTrue(Files.exists(test1));
		assertTrue(Files.exists(test2));
		assertTrue(Files.exists(test3));
		assertTrue(Files.exists(test4));
	}

	@Test
	public void testSetOneIncludedExtensions7() {
		deletor = new Deletor(false);
		deletor.setIncludedFiles("4");
		assertEquals(1, deletor.prepare(startPath.toString()));
		assertEquals(1, deletor.delete().size());
	}

	@Test
	public void testSetMoreIncludedExtensions7() {
		deletor = new Deletor(false);
		deletor.setIncludedFiles("est4;test3,2");
		assertEquals(3, deletor.prepare(startPath.toString()));
		assertEquals(3, deletor.delete().size());
	}

	@Test
	public void testSetOneExcludedExtensions7() {
		deletor = new Deletor(false);
		deletor.setExcludedFiles("test2");
		assertEquals(3, deletor.prepare(startPath.toString()));
		assertEquals(3, deletor.delete().size());
	}

	@Test
	public void testSetMoreExcludedExtensions7() {
		deletor = new Deletor(false);
		deletor.setExcludedFiles("test2,4;est1");
		assertEquals(1, deletor.prepare(startPath.toString()));
		assertEquals(1, deletor.delete().size());
	}

	@Test
	public void testSetInAndExcludedExtensions7() {
		deletor = new Deletor(false);
		deletor.setExcludedFiles("test2");
		deletor.setIncludedFiles("2;4");
		assertEquals(1, deletor.prepare(startPath.toString()));
		assertEquals(1, deletor.delete().size());
	}

	@Test
	public void testSetOneExcludedFolderPaths7() {
		deletor = new Deletor(false);
		deletor.setExcludedRelativePaths("testDir/de/genesez/output");
		assertEquals(3, deletor.prepare(startPath.toString()));
	}

	@Test
	public void testSetMoreExcludedFolderPaths7() throws IOException {
		deletor = new Deletor(false);
		Path test = Files.createFile(startPath.resolve("test.test"));
		deletor.setExcludedRelativePaths("testDir/de/genesez/output; /testDir/de/genesez/testclasses");
		assertEquals(1, deletor.prepare(startPath.toString()));
		assertTrue(test.endsWith(deletor.delete().get(0)));
	}

	@Test
	public void testSetOneExcludedDirectoryName7() throws IOException {
		Path test = Files.createFile(Files.createDirectory(
				startPath.resolve(".svn")).resolve("tester"));
		deletor = new Deletor(false);
		deletor.setExcludedDirectoryNames(".svn");
		assertEquals(4, deletor.prepare(startPath.toString()));
		test.toFile().setLastModified(1);
		assertEquals(4, deletor.delete().size());
	}

	@Test
	public void testSetMoreExcludedDirectoryNames7() throws IOException {
		Path test = Files.createFile(Files.createDirectory(
				startPath.resolve(".svn")).resolve("tester"));
		Files.createFile(Files.createDirectory(startPath.resolve("en"))
				.resolve("tester"));
		Files.createFile(startPath.resolve("de").resolve("tester"));
		deletor = new Deletor(false);
		deletor.setExcludedDirectoryNames(".svn; tester;en");
		assertEquals(5, deletor.prepare(startPath.toString()));
		test.toFile().setLastModified(1);
		assertEquals(5, deletor.delete().size());
	}

	@Test
	public void testSetAllInAndExcluded7() throws IOException {
		Files.createFile(Files.createDirectory(startPath.resolve(".svn"))
				.resolve("test3"));
		Files.createFile(Files.createDirectory(startPath.resolve("en"))
				.resolve("est2"));
		Files.createFile(startPath.resolve("de").resolve("tester"));
		deletor = new Deletor(false);
		deletor.setExcludedFiles("test2");
		deletor.setIncludedFiles("2;3");
		deletor.setExcludedRelativePaths("/testDir/de/genesez/output");
		deletor.setExcludedDirectoryNames(".svn; en");
		assertEquals(1, deletor.prepare(startPath.toString()));
		assertTrue(test3.endsWith(deletor.delete().get(0)));
	}

	@Test
	public void testDeletePackagesWithExclusion() throws IOException {
		Files.createDirectories(startPath.resolve(".svn/props/polerte/"));
		Files.createFile(startPath.resolve(".svn/props/testing"));
		Files.createDirectories(startPath.resolve("en/genesez/workflow/common/deletor/"));
		Files.createDirectories(startPath.resolve("en/genesez/workflow/java/generator/"));
		Deletor deletor = new Deletor(false);
		deletor.setExcludedRelativePaths("/common");
		deletor.setExcludedDirectoryNames("deletor");
		try{
		assertEquals(3, deletor.deleteEmptyPackages(startPath.toString()).size());
		} catch (UnsupportedOperationException e){
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void testDeletePackages() throws IOException, UnsupportedOperationException {
		// create testenvironment
		Files.createDirectories(startPath.resolve("en/genesez/java/.svn/props/polerte/"));
		Path test = Files.createFile(startPath.resolve("en/genesez/java/.svn/props/testing"));
		Files.createDirectories(startPath.resolve("en/genesez/workflow/common/deletor/"));
		Files.createDirectories(startPath.resolve("en/genesez/workflow/java/generator/"));
		
		// prepares a file
		PosixFileAttributeView check = Files.getFileAttributeView(test, PosixFileAttributeView.class);
		if(check != null){
			Set<PosixFilePermission> perm = PosixFilePermissions.fromString("r--r--r--");
			Files.setPosixFilePermissions(test, perm);
		} else {
			DosFileAttributeView attr = Files.getFileAttributeView(test, DosFileAttributeView.class);
			attr.setReadOnly(true);
		}
		
		// prepare Deletor
		Deletor deletor = new Deletor(false);
		deletor.setRepositoryFolderName(".svn");
		deletor.setExcludedDirectoryNames(".svn");
		deletor.prepare(startPath.toString());
		test4.toFile().setLastModified(1);
		deletor.delete();
		
		// the Test
		assertEquals(10,deletor.deleteEmptyPackages(startPath.toString()).size());
		assertTrue(Files.exists(test4));
		assertFalse(Files.exists(firstPath));
		assertTrue(Files.exists(secondPath.getParent()));
	}
}
