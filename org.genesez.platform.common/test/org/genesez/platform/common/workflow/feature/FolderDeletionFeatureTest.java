package org.genesez.platform.common.workflow.feature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

import org.genesez.platform.common.workflow.feature.FileTreeWalkerFeature;
import org.genesez.platform.common.workflow.feature.FolderDeletionFeature;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FolderDeletionFeatureTest {
	private static Path startPath;
	private static Path firstPath;
	private static Path secondPath;
	private static FolderDeletionFeature deletor;
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
		prop.setProperty("deleteEmptyFolders", "true");

		walker = new FileTreeWalkerFeature();
		deletor = new FolderDeletionFeature();
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
			Files.createFile(firstPath.resolve("test1"));
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

	@Test
	public void testDeletePackagesWithExclusion() throws IOException {
		Files.createDirectories(startPath.resolve(".svn/props/polerte/"));
		Files.createFile(startPath.resolve(".svn/props/testing"));
		Files.createDirectories(startPath
				.resolve("en/genesez/workflow/common/deletor/"));
		Files.createDirectories(startPath
				.resolve("en/genesez/workflow/java/generator/"));
		deletor.setExcludedRelativePaths("/common");
		deletor.setExcludedDirectoryNames("deletor");
		walker.invokePre();
		assertEquals(2, deletor.deleteEmptyPackages()
					.size());
	}

	@Test
	public void testDeletePackages() throws IOException,
			UnsupportedOperationException {
		// create testEnvironment
		Files.createDirectories(startPath
				.resolve("en/genesez/java/.svn/props/polerte/"));
		Files.createFile(startPath
				.resolve("en/genesez/java/.svn/props/testing"));
		Files.createDirectories(startPath
				.resolve("en/genesez/workflow/common/deletor/"));
		Path test = Files.createDirectories(startPath
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
		walker.invokePre();

		// the Test
		assertEquals(8, deletor.deleteEmptyPackages()
			.size());
		
		assertTrue(Files.exists(test4));
		assertTrue(Files.exists(firstPath));
		assertTrue(Files.exists(secondPath.getParent()));
		assertFalse(Files.exists(test));
		assertTrue(Files.exists(startPath.resolve("en/genesez/java/.svn/props/testing")));
	}

}
