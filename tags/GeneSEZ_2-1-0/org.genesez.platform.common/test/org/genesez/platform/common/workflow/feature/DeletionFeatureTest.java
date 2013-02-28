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

import org.genesez.platform.common.workflow.feature.FileDeletionFeature;
import org.genesez.platform.common.workflow.feature.FileTreeWalkerFeature;
import org.genesez.platform.common.workflow.feature.FolderDeletionFeature;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DeletionFeatureTest {

	private static Path startPath;
	private static Path firstPath;
	private static Path secondPath;
	private static FileDeletionFeature fileDeletor;
	private static FolderDeletionFeature folderDeletor;
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
		walker = new FileTreeWalkerFeature();
		startPath = Files.createTempDirectory("testDir");
		firstPath = startPath.resolve("org/genesez/testclasses/");
		secondPath = startPath.resolve("org/genesez/output/");
		prop.setProperty("outputDir", startPath.toString());

		folderDeletor = new FolderDeletionFeature();
		fileDeletor = new FileDeletionFeature();
		folderDeletor.setProperties(prop);
		fileDeletor.setProperties(prop);
		walker.setProperties(prop);
		walker.addObserver(fileDeletor);
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
	
	@Test
	public void testComplete() throws IOException {
		Path dir1 = Files.createDirectories(startPath
				.resolve("org/genesez/java/.svn/props/polerte/"));
		Path test = Files.createFile(startPath
				.resolve("org/genesez/java/.svn/props/testing"));
		Path dir2 = Files.createDirectories(startPath
				.resolve("org/genesez/workflow/common/deletor/"));
		Path dir3 = Files.createDirectories(startPath
				.resolve("org/genesez/en/java/generator/"));
		Path dir4 = Files.createDirectories(startPath.resolve("org/genesez/la/li/lu/"));
		
		Properties properties = new Properties();
		properties.setProperty("excludedRelativePaths", secondPath.toString());
		properties.setProperty("excludedFiles", "test2");
		properties.setProperty("includedFiles", "est1, testing, 2, 3");
		properties.setProperty("excludedDirectoryNames", "en" );
		properties.setProperty("outputDir", startPath.toString());
		
		fileDeletor.setProperties(properties);
		folderDeletor.setProperties(properties);
		fileDeletor.checkConfiguration();

		walker.invokePre();
		test1.toFile().setLastModified(1);
		fileDeletor.invokePost();
		walker.addObserver(folderDeletor);
		walker.invokePost();
		folderDeletor.invokePost();
		
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

	@Test
	public void testCheckRepositoryNoRepository() throws IOException {
		walker.invokePre();
		assertTrue(fileDeletor.getRevisionSystems().isEmpty());
	}

	@Test
	public void testCheckRepositorySVN() throws IOException {
		Files.createDirectory(startPath.resolve("org/genesez/.svn/"));
		walker.invokePre();
		assertEquals("[Subversion]", fileDeletor.getRevisionSystems().toString());
	}

	@Test
	public void testCheckRepositoryDefault() throws IOException {
		Files.createDirectory(startPath.resolve("org/genesez/testclasses/.cvs"));
		walker.invokePre();
		assertTrue(fileDeletor.getRevisionSystems().isEmpty());
	}

	@Test
	public void testCheckRepositoryGit() throws IOException {
		Path git = startPath.toRealPath().getParent().getParent().resolve(".git");
		if(!Files.exists(git)){
			Files.createDirectory(git);
		}
		walker.invokePre();
		Files.deleteIfExists(git);
		assertEquals("[Git]", fileDeletor.getRevisionSystems().toString());
	}
}