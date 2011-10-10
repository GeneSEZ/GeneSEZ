package de.genesez.platforms.common.workflow.feature;

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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.genesez.platforms.common.Prioritizable;

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
		walker = new FileTreeWalkerFeature();
	}

	@Before
	public void setUp() throws IOException {
		startPath = Files.createTempDirectory("testDir");
		firstPath = startPath.resolve("de/genesez/testclasses/");
		secondPath = startPath.resolve("de/genesez/output/");
		prop.setProperty("outputDir", startPath.toString());

		folderDeletor = new FolderDeletionFeature();
		fileDeletor = new FileDeletionFeature();
		folderDeletor.setProperties(prop);
		fileDeletor.setProperties(prop);
		walker.setProperties(prop);
		walker.registerObserver(fileDeletor);
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
		properties.setProperty("outputDir", startPath.toString());
		
		fileDeletor.setProperties(properties);
		folderDeletor.setProperties(properties);
		fileDeletor.checkConfiguration();

		walker.pre();
		test1.toFile().setLastModified(1);
		fileDeletor.post();
		walker.post();
		walker.registerObserver(folderDeletor);
		walker.post();
		folderDeletor.post();
		
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
		Files.walkFileTree(startPath, walker);
		assertTrue(fileDeletor.getRevisionSystems().isEmpty());
	}

	@Test
	public void testCheckRepositorySVN() throws IOException {
		Files.createDirectory(startPath.resolve("de/genesez/.svn/"));
		Files.walkFileTree(startPath, walker);
		assertEquals(fileDeletor.getRevisionSystems().toString(), "[Subversion]");
	}

	@Test
	public void testCheckRepositoryDefault() throws IOException {
		Files.createDirectory(startPath.resolve("de/genesez/testclasses/.cvs"));
		Files.walkFileTree(startPath, walker);
		assertTrue(fileDeletor.getRevisionSystems().isEmpty());
	}

	@Test
	public void testCheckRepositoryGit() throws IOException {
		Path git = Files.createDirectory(startPath.toRealPath().getParent()
				.getParent().resolve(".git"));
		Files.walkFileTree(startPath, walker);
		Files.deleteIfExists(git);
		assertEquals(fileDeletor.getRevisionSystems().toString(), "[Git]");
	}
	
	@Test
	public void checkConfigurationTest(){
		List<Prioritizable> list = new ArrayList<Prioritizable>();
		// list.add(walker);
		// list.add(new FileTreeWalkerFeature());
		list.add(fileDeletor);
		list.add(walker);
		list.add(folderDeletor);
		list.add(new FileTreeWalkerFeature());
		Collections.sort(list, new PriorityComparator(false));

		// Collections.sort(list, new PriorityComparator(false));
		assertEquals(list.get(0).getClass(),fileDeletor.getClass());
		assertEquals(list.get(1).getClass(),walker.getClass());
		assertEquals(list.get(2).getClass(),folderDeletor.getClass());
		assertEquals(list.get(3).getClass(),FileTreeWalkerFeature.class);
	}
}