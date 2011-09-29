package de.genesez.platforms.common.workflow.feature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.genesez.platforms.common.FileTreeWalker;

/**
 * Testclass for the FileDeletor
 * 
 * This test runs only under Java7 or above
 * 
 * @author Dominik Wetzel
 * @date 2011-09-14
 */
public class FileDeletionFeatureTest {
	private static Path startPath;
	private static Path firstPath;
	private static Path secondPath;
	private static FileDeletionFeature deletor;
	private static Path test1;
	private static Path test2;
	private static Path test3;
	private static Path test4;
	private static Properties prop = new Properties();
	private static FileTreeWalker walker;
//	private static PrintStream oldOut = System.out;
	private static PrintStream oldErr = System.err;
	private static ByteArrayOutputStream testOut = new ByteArrayOutputStream();

	private static class Delete extends SimpleFileVisitor<Path> {

		@Override
		public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
				throws IOException {
			alterPermission(file);
			Files.delete(file);
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException exc)
				throws IOException {
			alterPermission(dir);
			Files.delete(dir);
			return FileVisitResult.CONTINUE;
		}

		private boolean alterPermission(Path file) throws IOException,
				UnsupportedOperationException {
			PosixFileAttributeView POSIXattr = Files.getFileAttributeView(file,
					PosixFileAttributeView.class);
			// checks if its a POSIX System
			if (POSIXattr != null) {
				Set<PosixFilePermission> perms = PosixFilePermissions
						.fromString("rwxrwxrwx");
				// sets file permissions
				Files.setPosixFilePermissions(file, perms);
				return true;
			} else {
				// try if its a DOS-like
				// System
				DosFileAttributeView DOSattr = Files.getFileAttributeView(file,
						DosFileAttributeView.class);
				// sets file permission
				DOSattr.setReadOnly(false);
				return true;
			}
		}
	}

	@BeforeClass
	public static void checkBeforeClass() {
//		System.setOut(new PrintStream(testOut));
		System.setErr(new PrintStream(testOut));
		if (System.getProperty("java.version").charAt(2) < 7) {
			throw new UnsupportedOperationException(
					"Java Version below 7, Tests should fail");
		}
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
//		System.setOut(oldOut);
		System.setErr(oldErr);
	}

	@Before
	public void setUp() throws IOException {
		startPath = Files.createTempDirectory("testDir");
		firstPath = startPath.resolve("de/genesez/testclasses/");
		secondPath = startPath.resolve("de/genesez/output/");
		prop.setProperty("outputDir", startPath.toString());
		prop.setProperty("deleteOldFiles", "true");

		walker = new FileTreeWalker();
		deletor = new FileDeletionFeature();
		deletor.setProperties(prop);
		walker.registerObserver(deletor);
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
					.println("At least 1 File already exists. Some tests may fail. Start over.");
		}
	}

	@After
	public void tearDown() throws IOException {
		Files.walkFileTree(startPath, new Delete());
	}

	// // BEGIN OF TESTS

	@Test(expected = (NotPreparedException.class))
	public void testNotPreparedException() {
		deletor.delete();
		assertTrue(Files.exists(test1));
		assertTrue(Files.exists(test2));
		assertTrue(Files.exists(test3));
		assertTrue(Files.exists(test4));
	}

	@Test
	public void testPrepare() throws IOException{
		Files.walkFileTree(startPath, walker);
		assertEquals(4, deletor.getOldFileCount());
	}

	@Test
	public void testDeleteEverything() throws IOException {
		Files.walkFileTree(startPath, walker);
		assertEquals("checks if every file was deleted", 4, deletor.delete()
				.size());
	}

	@Test
	public void testDelete2Files() throws IOException {
		Files.walkFileTree(startPath, walker);
		test1.toFile().setLastModified(1);
		test2.toFile().setLastModified(1);
		assertEquals("checks if 2 files were deleted", 2, deletor.delete()
				.size());
	}

	@Test
	public void testDeleteNothing() throws IOException {
		Files.walkFileTree(startPath, walker);
		test1.toFile().setLastModified(1);
		test2.toFile().setLastModified(1);
		test3.toFile().setLastModified(5);
		test4.toFile().setLastModified(10);
		assertTrue("checks if nothing was deleted", deletor.delete().isEmpty());
	}

	@Test
	public void testSetOneIncludedFileExtension() throws IOException {
		// deletor.checkRepository(startPath.toString());
		deletor.setIncludedFiles("4");
		Files.walkFileTree(startPath, walker);
		assertEquals(1, deletor.getOldFileCount());
		assertEquals(1, deletor.delete().size());
	}

	@Test
	public void testSetMoreIncludedFileExtensions() throws IOException {
		deletor.setIncludedFiles("est4;test3,2");
		Files.walkFileTree(startPath, walker);
		assertEquals(3, deletor.getOldFileCount());
		assertEquals(3, deletor.delete().size());
	}

	@Test
	public void testSetOneExcludedFileExtension() throws IOException {
		deletor.setExcludedFiles("test2");
		Files.walkFileTree(startPath, walker);
		assertEquals(3, deletor.getOldFileCount());
		assertEquals(3, deletor.delete().size());
	}

	@Test
	public void testSetMoreExcludedFileExtensions() throws IOException {
		deletor.setExcludedFiles("test2,4;est1");
		Files.walkFileTree(startPath, walker);
		assertEquals(1, deletor.getOldFileCount());
		assertEquals(1, deletor.delete().size());
	}

	@Test
	public void testSetOneExcludedPath() throws IOException {
		deletor.setExcludedRelativePaths(startPath.resolve("de/genesez/output")
				.toString());
		Files.walkFileTree(startPath, walker);
		assertEquals(3, deletor.getOldFileCount());
	}

	@Test
	public void testSetMoreExcludedPaths() throws IOException {
		Path test = Files.createFile(startPath.resolve("test.test"));
		deletor.setExcludedRelativePaths(startPath.resolve("de/genesez/output")
				.toString() + ";" + startPath.resolve("de/genesez/testclasses"));
		Files.walkFileTree(startPath, walker);
		assertEquals(1, deletor.getOldFileCount());
		assertTrue(test.endsWith(deletor.delete().get(0)));
	}

	@Test
	public void testSetOneExcludedDirectoryName() throws IOException {
		Path test = Files.createFile(Files.createDirectory(
				startPath.resolve(".svn")).resolve("tester"));

		deletor.setExcludedDirectoryNames(".svn");
		Files.walkFileTree(startPath, walker);
		assertEquals(4, deletor.getOldFileCount());
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

		deletor.setExcludedDirectoryNames(".svn; tester;en");
		Files.walkFileTree(startPath, walker);
		assertEquals(5, deletor.getOldFileCount());
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

		deletor.setExcludedFiles("test2");
		deletor.setIncludedFiles("2;3");
		deletor.setExcludedRelativePaths("/testDir/de/genesez/output");
		deletor.setExcludedDirectoryNames(".svn; en");
		Files.walkFileTree(startPath, walker);
		assertEquals(1, deletor.getOldFileCount());
		assertTrue(test3.endsWith(deletor.delete().get(0)));
	}

	@Test
	public void testDeletePackagesWithExclusion() throws IOException {
		Files.createDirectories(startPath.resolve(".svn/props/polerte/"));
		Files.createFile(startPath.resolve(".svn/props/testing"));
		Files.createDirectories(startPath
				.resolve("en/genesez/workflow/common/deletor/"));
		Files.createDirectories(startPath
				.resolve("en/genesez/workflow/java/generator/"));
		prop.setProperty("deleteEmptyFolders", "true");
		deletor.setProperties(prop);
		deletor.setExcludedRelativePaths("/common");
		deletor.setExcludedDirectoryNames("deletor");
		Files.walkFileTree(startPath, walker);
		Files.walkFileTree(startPath, walker);
		assertEquals(2, deletor.deleteEmptyPackages()
					.size());
	}

	@Test
	public void testDeletePackages() throws IOException,
			UnsupportedOperationException {
		// create testEnvironment
		Files.createDirectories(startPath
				.resolve("en/genesez/java/.svn/props/polerte/"));
		Path test = Files.createFile(startPath
				.resolve("en/genesez/java/.svn/props/testing"));
		Files.createDirectories(startPath
				.resolve("en/genesez/workflow/common/deletor/"));
		Files.createDirectories(startPath
				.resolve("en/genesez/workflow/java/generator/"));

		// prepares a file
		PosixFileAttributeView check = Files.getFileAttributeView(test,
				PosixFileAttributeView.class);
		if (check != null) {
			Set<PosixFilePermission> perm = PosixFilePermissions
					.fromString("r--r--r--");
			Files.setPosixFilePermissions(test, perm);
		} else {
			DosFileAttributeView attr = Files.getFileAttributeView(test,
					DosFileAttributeView.class);
			attr.setReadOnly(true);
		}

		prop.setProperty("deleteEmptyFolders", "true");
		deletor.setProperties(prop);
		Files.walkFileTree(startPath, walker);
		test4.toFile().setLastModified(1);
		deletor.delete();
		Files.walkFileTree(startPath, walker);

		// the Test
		assertEquals(9, deletor.deleteEmptyPackages()
			.size());
		
		assertTrue(Files.exists(test4));
		assertFalse(Files.exists(firstPath));
		assertTrue(Files.exists(secondPath.getParent()));
	}

	@Test
	public void testCheckRepositoryNoRepository() throws IOException {
		Files.walkFileTree(startPath, walker);
		System.out.println(testOut.toString());
		StringTokenizer st = new StringTokenizer(testOut.toString(), System.lineSeparator());
		String s = null;
		while(st.hasMoreTokens()){
			s = st.nextToken();
		}
		if(s != null){
			assertEquals("Information: No supported revision control system found. Default will be used.", s);
		} else {
			fail("no Token found");
		}
	}

	@Test
	public void testCheckRepositorySVN() throws IOException {
		Files.createDirectory(startPath.resolve("de/genesez/.svn/"));
		Files.walkFileTree(startPath, walker);
		System.out.println(testOut.toString());
		StringTokenizer st = new StringTokenizer(testOut.toString(), System.lineSeparator());
		String s = null;
		while(st.hasMoreTokens()){
			s = st.nextToken();
			System.out.println(s);
		}
		if(s != null){
			assertEquals("Information: Revision control system(s) found: [Subversion]", s);
		}
	}

	@Test
	public void testCheckRepositoryDefault() throws IOException {
		Files.createDirectory(startPath.resolve("de/genesez/testclasses/.cvs"));
		Files.walkFileTree(startPath, walker);
		System.out.println(testOut.toString());
		StringTokenizer st = new StringTokenizer(testOut.toString(), System.lineSeparator());
		String s = null;
		while(st.hasMoreTokens()){
			s = st.nextToken();
		}
		if(s != null){
			assertEquals("Information: No supported revision control system found. Default will be used.", s);
		} else {
			fail("no Token found");
		}
	}

	@Test
	public void testCheckRepositoryGit() throws IOException {
		Path git = Files.createDirectory(startPath.toRealPath().getParent()
				.getParent().resolve(".git"));
		deletor.checkConfiguration();
		Files.deleteIfExists(git);
		Files.walkFileTree(startPath, walker);
		System.out.println(testOut.toString());
		StringTokenizer st = new StringTokenizer(testOut.toString(), System.lineSeparator());
		String s = null;
		while(st.hasMoreTokens()){
			s = st.nextToken();
		}
		if(s != null){
			assertEquals("Information: Revision control system(s) found: [Git]", s);
		} else {
			fail("no Token found");
		}
	}
	
	@Test
	public void testComplete() throws IOException {
		Path dir1 = Files.createDirectories(startPath
				.resolve("de/genesez/java/.svn/props/polerte/"));
		Path test = Files.createFile(startPath
				.resolve("de/genesez/java/.svn/props/testing"));
		Path dir2 = Files.createDirectories(startPath
				.resolve("en/genesez/workflow/common/deletor/"));
		Path dir3 = Files.createDirectories(startPath
				.resolve("de/genesez/en/java/generator/"));
		Path dir4 = Files.createDirectories(startPath.resolve("de/genesez/la/li/lu/"));
		
		Properties properties = new Properties();
		properties.setProperty("excludedRelativePaths", secondPath.toString());
		properties.setProperty("excludedFiles", "test2");
		properties.setProperty("includedFiles", "est1, testing, 2, 3");
		properties.setProperty("excludedDirectoryNames", "en" );
		properties.setProperty("deleteOldFiles", "true");
		properties.setProperty("deleteEmptyFolders", "true");
		properties.setProperty("outputDir", startPath.toString());
		
		deletor.setProperties(properties);
		deletor.checkConfiguration();
		Files.walkFileTree(startPath, walker);
		test1.toFile().setLastModified(1);
		test2.toFile().setLastModified(1);
		
		deletor.afterGeneration();
		Files.walkFileTree(startPath, walker);
		deletor.afterSecondFileWalk();
		
		assertTrue(Files.exists(test1));
		assertTrue(Files.exists(test2));
		
		assertFalse(Files.exists(test3));
		
		assertTrue(Files.exists(test4));
		assertTrue(Files.exists(dir1));
		assertTrue(Files.exists(test));
		assertTrue(Files.exists(dir2));
		assertTrue(Files.exists(dir3));
		assertFalse(Files.exists(dir4));
		
		assertFalse(Files.exists(dir4.getParent().getParent()));
	}
}
