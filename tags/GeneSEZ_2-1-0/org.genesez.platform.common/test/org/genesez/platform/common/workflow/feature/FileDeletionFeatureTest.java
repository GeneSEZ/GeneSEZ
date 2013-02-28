package org.genesez.platform.common.workflow.feature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
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

import org.genesez.platform.common.NotPreparedException;
import org.genesez.platform.common.workflow.feature.FileDeletionFeature;
import org.genesez.platform.common.workflow.feature.FileTreeWalkerFeature;
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
	private static FileTreeWalkerFeature walker;

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
		if (System.getProperty("java.version").charAt(2) < 7) {
			throw new UnsupportedOperationException(
					"Java Version below 7, Tests should fail");
		}
	}

	@Before
	public void setUp() throws IOException {
		startPath = Files.createTempDirectory("testDir");
		firstPath = startPath.resolve("org/genesez/testclasses/");
		secondPath = startPath.resolve("org/genesez/output/");
		prop.setProperty("outputDir", startPath.toString());
		prop.setProperty("deleteOldFiles", "true");

		walker = new FileTreeWalkerFeature();
		deletor = new FileDeletionFeature();
		deletor.setProperties(prop);
		walker.setProperties(prop);
		walker.addObserver(deletor);
		walker.checkConfiguration();
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
		walker.invokePre();
		assertEquals(4, deletor.getOldFileCount());
	}

	@Test
	public void testDeleteEverything() throws IOException {
		walker.invokePre();
		assertEquals("checks if every file was deleted", 4, deletor.delete()
				.size());
	}

	@Test
	public void testDelete2Files() throws IOException {
		walker.invokePre();
		test1.toFile().setLastModified(1);
		test2.toFile().setLastModified(1);
		assertEquals("checks if 2 files were deleted", 2, deletor.delete()
				.size());
	}

	@Test
	public void testDeleteNothing() throws IOException {
		walker.invokePre();
		test1.toFile().setLastModified(1);
		test2.toFile().setLastModified(1);
		test3.toFile().setLastModified(5);
		test4.toFile().setLastModified(10);
		assertTrue("checks if nothing was deleted", deletor.delete().isEmpty());
	}

	@Test
	public void testSetOneIncludedFileExtension() throws IOException {
//		deletor.checkRepository(startPath.toString());
		deletor.setIncludedFileExtensions("4");
		walker.invokePre();
		assertEquals(1, deletor.getOldFileCount());
		assertEquals(1, deletor.delete().size());
	}

	@Test
	public void testSetMoreIncludedFileExtensions() throws IOException {
		deletor.setIncludedFileExtensions("est4;test3,2");
		walker.invokePre();
		assertEquals(3, deletor.getOldFileCount());
		assertEquals(3, deletor.delete().size());
	}

	@Test
	public void testSetOneExcludedFileExtension() throws IOException {
		deletor.setExcludedFileExtensions("test2");
		walker.invokePre();
		assertEquals(3, deletor.getOldFileCount());
		assertEquals(3, deletor.delete().size());
	}

	@Test
	public void testSetMoreExcludedFileExtensions() throws IOException {
		deletor.setExcludedFileExtensions("test2,4;est1");
		walker.invokePre();
		assertEquals(1, deletor.getOldFileCount());
		assertEquals(1, deletor.delete().size());
	}

	@Test
	public void testSetOneExcludedPath() throws IOException {
		deletor.setExcludedRelativePaths(startPath.resolve("org/genesez/output")
				.toString());
		Files.walkFileTree(startPath, walker);
		assertEquals(3, deletor.getOldFileCount());
	}

	@Test
	public void testSetMoreExcludedPaths() throws IOException {
		Path test = Files.createFile(startPath.resolve("test.test"));
		deletor.setExcludedRelativePaths(startPath.resolve("org/genesez/output")
				.toString() + ";" + startPath.resolve("org/genesez/testclasses"));
		walker.invokePre();
		assertEquals(1, deletor.getOldFileCount());
		//assertTrue(test.endsWith(deletor.delete().get(0)));
	}

	@Test
	public void testSetOneExcludedDirectoryName() throws IOException {
		Path test = Files.createFile(Files.createDirectory(
				startPath.resolve(".svn")).resolve("tester"));

		deletor.setExcludedDirectoryNames(".svn");
		walker.invokePre();
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
		walker.invokePre();
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

		deletor.setExcludedFileExtensions("test2");
		deletor.setIncludedFileExtensions("2;3");
		deletor.setExcludedRelativePaths("/testDir/org/genesez/output");
		deletor.setExcludedDirectoryNames(".svn; en");
		walker.invokePre();
		assertEquals(1, deletor.getOldFileCount());
		//assertTrue(test3.endsWith(deletor.delete().get(0)));
	}
}
