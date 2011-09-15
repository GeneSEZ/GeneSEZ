package de.genesez.platforms.common.revisioncontrol;

import java.io.IOException;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DefaultImpl implements
		RevisionControlSystem {
	private List<String> metadataFolderNames;

	public DefaultImpl() {
		metadataFolderNames = new LinkedList<String>();
		metadataFolderNames.add(".cvs");
	}

	public void delete(String file) {
		try {
			Files.walkFileTree(Paths.get(file), new SimpleFileVisitor<Path>(){
				/**
				 * Sets the permissions and deletes the given file
				 * 
				 * @param file
				 *            file that will be deleted
				 * @param attrs
				 *            basic attributes of the file
				 * @return CONTINUE
				 * @throws IOException
				 *             if an IO-Error occurs
				 */
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
						throws IOException {
					// changes the permissions
					alterPermission(file);
					// deletes the file
					Files.deleteIfExists(file);
					return FileVisitResult.CONTINUE;
				}

				/**
				 * Deletes the given folder
				 * 
				 * @param dir
				 *            the directory that will be deleted
				 * @param exc
				 *            null if the iteration of the directory completes without an
				 *            error; otherwise the I/O exception that caused the iteration
				 *            of the directory to complete prematurely
				 * @throws IOException
				 *             if IO-Error occurs
				 * @return CONTINUE
				 */
				@Override
				public FileVisitResult postVisitDirectory(Path dir, IOException exc)
						throws IOException {
					alterPermission(dir);
					Files.deleteIfExists(dir);
					return FileVisitResult.CONTINUE;
				}

				/**
				 * Changes the file permissions for POSIX or DOS Systems to rwx------ or
				 * !readOnly
				 * 
				 * @param file
				 *            the file, were permissions should be checked.
				 * @return true if its could change permission, false if FileSystem is not
				 *         supported.
				 * @throws IOException
				 *             if IO-Error occurs.
				 */
				private boolean alterPermission(Path file) throws IOException {
					PosixFileAttributeView POSIXattr = Files.getFileAttributeView(file,
							PosixFileAttributeView.class);
					// checks if its a POSIX System
					if (POSIXattr != null) {
						Set<PosixFilePermission> perms = PosixFilePermissions
								.fromString("rwx------");
						// sets file permissions
						Files.setPosixFilePermissions(file, perms);
						return true;

					} else {
						// try if its a DOS-like System
						try {
							DosFileAttributeView DOSattr = Files.getFileAttributeView(file,
									DosFileAttributeView.class);
							// sets file permission
							DOSattr.setReadOnly(false);
							return true;
						} catch (UnsupportedOperationException e) {
							e.getMessage();
							return false;
						}
					}
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<String> getMetadataFolderNames() {
		return metadataFolderNames;
	}

	public String getName(){
		return "Default";
	}


}
