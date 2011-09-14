package de.genesez.platforms.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
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
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.genesez.platforms.common.revisioncontrol.RevisionControlSystem;
import de.genesez.platforms.common.revisioncontrol.SubversionSystem;
import de.genesez.platforms.common.workflow.WorkflowUtils;

/**
 * The Deletor handles the deletion of unchanged files during the generation
 * process. With the filter-options the search can be specified. It's also
 * possible to delete empty packages.
 * 
 * NOTE: For full functionality (with deletion of empty packages) Java 7 is
 * needed.
 * 
 * @author Dominik Wetzel
 * @date 2011-09-14
 * 
 */
public class Deletor extends SimpleFileVisitor<Path> {

	private List<String> includedFiles = new LinkedList<String>();
	private List<String> excludedFiles = new LinkedList<String>();
	private List<String> excludedRelativePaths = new LinkedList<String>();
	private List<String> excludedDirectoryNames = new LinkedList<String>();
	private String repositoryFolderName = "";

	private Map<String, Long> oldFiles = new LinkedHashMap<String, Long>();
	private boolean runtimeVersionBelow7;
	private boolean prepared = false;
	private Object outputPath;
	private RevisionControlSystem svn = new SubversionSystem();

	private Map<String, Long> fileMap = new LinkedHashMap<String, Long>();

	/**
	 * Constructs a new Deletor
	 * 
	 * @param runtimeVersion
	 *            true if its below Java 7
	 * @param path
	 *            the startPath, where the search begins
	 */
	public Deletor(boolean runtimeVersionBelow7) {
		this.runtimeVersionBelow7 = runtimeVersionBelow7;
	}

	/**
	 * Prepares the deletion of Files. Needs to be called before delete.
	 * Searches for files in the directories under path and stores the last
	 * modification dates in a map. The search uses the given filters.
	 * 
	 * @param path
	 *            The startPath, where the search begins
	 * 
	 * @return number of elements in the map
	 */
	public int prepare(String path) {
		if (runtimeVersionBelow7) {
			outputPath = new File(path);
			oldFiles = prepareDeletion((File) outputPath);
			prepared = true;
			return oldFiles.size();
		} else {
			outputPath = Paths.get(path);
			try {
				Files.walkFileTree((Path) outputPath, this);
			} catch (IOException e) {
				e.printStackTrace();
			}
			oldFiles.putAll(fileMap);
			fileMap.clear();
			prepared = true;
			return oldFiles.size();
		}
	}

	/**
	 * deletes the unchanged files. Therefore it searches again and compares the
	 * last modification dates.
	 * 
	 * @return List with deleted Elements
	 * @throws NotPreparedException
	 *             if prepare wasn't called before
	 */
	public List<String> delete() throws NotPreparedException {
		if (prepared) {
			if (runtimeVersionBelow7) {
				return deleteOldFiles(oldFiles, (File) outputPath);
			} else {
				try {
					Files.walkFileTree((Path) outputPath, this);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return deleteOldFiles(oldFiles);
			}
		} else {
			throw new NotPreparedException("prepare() was not called before");
		}
	}

	/**
	 * deletes empty packages (folders) in the given directory, uses the
	 * specified filters: excludedRelativePaths and excludedDirectoryNames.<br>
	 * 
	 * @param path
	 *            the path where the search will begin (should be the Output
	 *            directory)
	 * @return a list with all deleted folders
	 * @throws UnsupportedOperationException
	 *             is thrown when the JRE version is below 7
	 */
	public List<String> deleteEmptyPackages(String path)
			throws UnsupportedOperationException {
		if (runtimeVersionBelow7) {
			throw new UnsupportedOperationException(
					"currently not implemented for JRE versions below 7");
		} else {
			final List<String> log = new LinkedList<String>();

			try {
				Files.walkFileTree(Paths.get(path),
						new SimpleFileVisitor<Path>() {

							/**
							 * checks if the current directory is excluded using
							 * excludedRelativePaths and excludedDirectoryNames
							 * 
							 * @param dir
							 *            the directory, that is checked
							 * @param attrs
							 *            the directory's basic attributes
							 * @returns SKIP_SUBTREE if excluded, else CONTINUE
							 * @throws IOException
							 *             if IO-Error occurs
							 */
							@Override
							public FileVisitResult preVisitDirectory(Path dir,
									BasicFileAttributes attrs)
									throws IOException {
								for (String s : excludedRelativePaths) {
									if (dir.startsWith(Paths.get(s))) {
										return FileVisitResult.SKIP_SUBTREE;
									}
								}
								for (String s : excludedDirectoryNames) {
									if (dir.toString().endsWith(s)) {
										return FileVisitResult.SKIP_SUBTREE;
									}
								}
								return FileVisitResult.CONTINUE;
							}

							/**
							 * After it visits the directory the method checks,
							 * whether its empty or not and deletes it if its
							 * empty. Also repository folder will be delete if
							 * it is the only one left
							 * 
							 * @param dir
							 *            directory that is checked
							 * @param null if the iteration of the directory
							 *        completes without an error; otherwise the
							 *        I/O exception that caused the iteration of
							 *        the directory to complete prematurely
							 * @return CONTINUE
							 * @throws IOException
							 *             if IO-Error occurs
							 */
							@Override
							public FileVisitResult postVisitDirectory(Path dir,
									IOException exc) throws IOException {

								// try(DirectoryStream<Path> stream = Files
								// .newDirectoryStream(dir)){
								DirectoryStream<Path> stream = Files
										.newDirectoryStream(dir);

								java.util.Iterator<Path> streamIter = stream
										.iterator();

								if (streamIter.hasNext()) {
									Path subfolder = streamIter.next();
									// looks if the repository folder is the
									// only folder in this directory
									if (!streamIter.hasNext()
											&& subfolder
													.endsWith(repositoryFolderName)
											&& Files.isDirectory(subfolder)) {
										// deletes the repository folder
//										deleteRepFolder(subfolder);
//										log.add(subfolder.toString());
										svn.delete(dir.toString());
										log.add(dir.toString());
									}
								} else {
									Files.delete(dir);
									log.add(dir.toString());
								}
								// } catch (DirectoryIteratorException ex){
								// ex.printStackTrace();
								// }
								if (stream != null) {
									stream.close();
								}
//								// try(DirectoryStream<Path> stream2 = Files
//								// .newDirectoryStream(dir)){
//								DirectoryStream<Path> stream2 = Files
//										.newDirectoryStream(dir);
//								if (!stream2.iterator().hasNext()
//										&& Files.isDirectory(dir)) {
//									// the deleted File is logged
//									Files.delete(dir);
//									log.add(dir.toString());
//								}
//								// } catch (DirectoryIteratorException ex) {
//								// ex.printStackTrace();
//								// }
//
//								if (stream2 != null) {
//									stream2.close();
//								}
								return FileVisitResult.CONTINUE;
							}

							/**
							 * deletes the complete folder structure under the
							 * given path.
							 * 
							 * @param dir
							 *            the path that is to be deleted.
							 * @throws IOException
							 *             if IO-Error occurs
							 */
							private void deleteRepFolder(Path dir)
									throws IOException {
								Files.walkFileTree(dir,
										new SimpleFileVisitor<Path>() {

											/**
											 * Sets the permissions and deletes
											 * the given file
											 * 
											 * @param file
											 *            file that will be
											 *            deleted
											 * @param attrs
											 *            basic attributes of
											 *            the file
											 * @return CONTINUE
											 * @throws IOException
											 *             if an IO-Error occurs
											 */
											@Override
											public FileVisitResult visitFile(
													Path file,
													BasicFileAttributes attrs)
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
											 *            the directory that
											 *            will be deleted
											 * @param exc
											 *            null if the iteration
											 *            of the directory
											 *            completes without an
											 *            error; otherwise the
											 *            I/O exception that
											 *            caused the iteration
											 *            of the directory to
											 *            complete prematurely
											 * @throws IOException
											 *             if IO-Error occurs
											 * @return CONTINUE
											 */
											@Override
											public FileVisitResult postVisitDirectory(
													Path dir, IOException exc)
													throws IOException {
												alterPermission(dir);
												Files.deleteIfExists(dir);
												return FileVisitResult.CONTINUE;
											}

											/**
											 * Changes the file permissions for
											 * POSIX or DOS Systems to rwxrwxrwx
											 * or !readOnly
											 * 
											 * @param file
											 *            the file, were
											 *            permissions should be
											 *            checked.
											 * @return true if its could change
											 *         permission, false if
											 *         FileSystem is not
											 *         supported.
											 * @throws IOException
											 *             if IO-Error occurs.
											 */
											private boolean alterPermission(
													Path file)
													throws IOException {
												PosixFileAttributeView POSIXattr = Files
														.getFileAttributeView(
																file,
																PosixFileAttributeView.class);
												// checks if its a POSIX System
												if (POSIXattr != null) {
													Set<PosixFilePermission> perms = PosixFilePermissions
															.fromString("rwxrwxrwx");
													// sets file permissions
													Files.setPosixFilePermissions(
															file, perms);
													return true;

												} else {
													// try if its a DOS-like
													// System
													try {
														DosFileAttributeView DOSattr = Files
																.getFileAttributeView(
																		file,
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
							}
						});
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			return log;
		}
	}

	/**
	 * Sets files that will be included in the search. <br>
	 * NOTE: Only files with these extensions will be included.
	 * 
	 * @param extensions
	 *            the IncludedFileExtension String contains all included Files
	 *            in a single String (separated by "," or ";")
	 */
	public void setIncludedFiles(String extensions) {
		if (extensions.length() > 0) {
			includedFiles = WorkflowUtils.split(extensions);
		}
	}

	/**
	 * Sets files that will be excluded in the search.
	 * 
	 * @param extensions
	 *            the ExcludedFileExtension String contains all excluded Files
	 *            in a single String (separated by "," or ";")
	 */
	public void setExcludedFiles(String extensions) {
		if (extensions.length() > 0) {
			excludedFiles = WorkflowUtils.split(extensions);
		}
	}

	/**
	 * Sets RelativPaths (to the OutputDirectory) which will be excluded in the
	 * search.
	 * 
	 * @param paths
	 *            contains all excluded Paths in a single String (separated by
	 *            "," or ";")
	 */
	public void setExcludedRelativePaths(String paths) {
		if (paths.length() > 0) {
			excludedRelativePaths = WorkflowUtils.split(paths);
			for (int i = 0; i < excludedRelativePaths.size(); i++) {
				String s = excludedRelativePaths.get(i);
				if (!s.startsWith(".")) {
					s = ".".concat(s);
				} else if (!s.startsWith("./")) {
					s = "./".concat(s);
				}
				if (!s.startsWith(".\\")) {
					if (!s.startsWith("./")) {
						s = s.replaceFirst(".", "./");
					}
				}
				excludedRelativePaths.set(i, new File(s).getPath());
			}
		}
	}

	/**
	 * Sets directory names that are excluded in the search. <br>
	 * NOTE: Every directory with the same spelling will be excluded.
	 * 
	 * @param names
	 *            contains all Names that are excluded (separated by "," or ";")
	 */
	public void setExcludedDirectoryNames(String names) {
		if (names.length() > 0) {
			excludedDirectoryNames = WorkflowUtils.split(names);
		}
	}

	/**
	 * Sets the repository folder name for deletion of folders
	 * 
	 * @param name
	 *            repository folder name
	 */
	public void setRepositoryFolderName(String name) {
		repositoryFolderName = name;
	}

	/**
	 * Searches for files and stores them with the last modification date
	 * 
	 * @param path
	 *            directory which will be searched recursively
	 * @return a Map with the path as key and the last modification date as
	 *         value
	 */
	private Map<String, Long> prepareDeletion(File path) {
		Map<String, Long> oldFiles = new LinkedHashMap<String, Long>();
		List<File> files = searchForFiles(path);
		for (File f : files) {
			oldFiles.put(f.getPath(), f.lastModified());
		}
		return oldFiles;
	}

	/**
	 * Compares the last modification date of the files found in path with the
	 * files in the given map. If the last modification date didn't change the
	 * file will be deleted
	 * 
	 * @param oldFiles
	 *            map with the oldFiles to compare with
	 * @param path
	 *            the directory which will be searched recursively for files
	 * @return a List with the deleted paths.
	 */
	private List<String> deleteOldFiles(Map<String, Long> oldFiles, File path) {
		List<String> logged = new LinkedList<String>();
		List<File> files = searchForFiles(path);
		for (File f : files) {
			if (oldFiles.containsKey(f.getPath())) {
				if (f.lastModified() == oldFiles.get(f.getPath())) {
					logged.add(f.getPath());
					f.delete();
				}
			}
		}
		return logged;
	}

	/**
	 * Compares the last modification date of the files found in path with the
	 * files in the given map. If the last modification date didn't change the
	 * file will be deleted (runs only with Java7)
	 * 
	 * @param oldFiles
	 *            map with the oldFiles to compare with
	 * @return list with deleted paths
	 */
	private List<String> deleteOldFiles(Map<String, Long> oldFiles) {
		List<String> logged = new LinkedList<String>();
		Set<String> check = fileMap.keySet();
		for (String s : check) {
			if (oldFiles.containsKey(s)) {
//				try {
					if (fileMap.get(s).equals(oldFiles.get(s))) {
						logged.add(s.toString());
						svn.delete(s);
						// Files.delete(Paths.get(s));
					}
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
			}
		}
		fileMap.clear();
		return logged;
	}

	/**
	 * Starts the recursive search for files at the given path. Checks files
	 * with included and excluded filters.
	 * 
	 * @param path
	 *            entry point for the search
	 * @return a List with all files found
	 */
	private List<File> searchForFiles(File path) {
		List<File> list = new LinkedList<File>();
		return searchForFiles(path, list);
	}

	/**
	 * Searches directory recursively for files checks files with included and
	 * excluded filters (excluded filters are stronger)
	 * 
	 * @param file
	 *            root-Element where the search begins
	 * @param list
	 *            a list where the files can be stored inside the recursion
	 * @return a List with all files found
	 */
	private List<File> searchForFiles(File path, List<File> list) {
		for (String exclPath : excludedRelativePaths) {
			if (path.getPath().startsWith(exclPath)) {
				return list;
			}
		}
		if (path.isFile()) {
			for (String exclFile : excludedFiles) {
				if (path.getPath().endsWith(exclFile)) {
					return list;
				}
			}
			if (includedFiles.isEmpty()) {
				list.add(path);
			} else {
				// checks included Filters and adds file to List
				for (String inclFile : includedFiles) {
					if (path.getPath().endsWith(inclFile)) {
						list.add(path);
						break;
					}
				}
			}
			return list;
		}
		for (String exclDirName : excludedDirectoryNames) {
			if (path.getPath().endsWith(exclDirName)) {
				return list;
			}
		}
		// checks files of the directory
		List<File> moreFiles = Arrays.asList(path.listFiles());
		for (File file : moreFiles) {
			list = searchForFiles(file, list);
		}
		return list;
	}

	/**
	 * Is invoked by walkFileTree. Checks if the file is excluded or included in
	 * the search. Puts included files into the filemap.
	 * 
	 * @param file
	 *            a reference to the file
	 * @param attrs
	 *            the file's basic attributes
	 * @return CONTINUE if everything worked.
	 * @throws IOException
	 *             if something went wrong
	 */
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		for (String s : excludedFiles) {
			if (file.toString().endsWith(s)) {
				return FileVisitResult.CONTINUE;
			}
		}
		if (!includedFiles.isEmpty()) {
			for (String s : includedFiles) {
				if (file.toString().endsWith(s)) {
					fileMap.put(file.toString(), Files
							.getLastModifiedTime(file).toMillis());
				}
			}
		} else {
			fileMap.put(file.toString(), Files.getLastModifiedTime(file)
					.toMillis());
		}
		return FileVisitResult.CONTINUE;
	}

	/**
	 * Is invoked by walkFileTree. If the path starts with a phrase form the
	 * excludedFolder the directory will be skipped in the search.
	 * 
	 * @param dir
	 *            a reference to the directory
	 * @param attrs
	 *            the directory's basic attributes
	 * @return CONTINUE if its not excluded else SKIP_SUBTREE
	 */
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
		for (String s : excludedRelativePaths) {
			if (dir.startsWith(Paths.get(s))) {
				return FileVisitResult.SKIP_SUBTREE;
			}
		}
		for (String s : excludedDirectoryNames) {
			if (dir.toString().endsWith(s)) {
				return FileVisitResult.SKIP_SUBTREE;
			}
		}

		return FileVisitResult.CONTINUE;
	}

	/**
	 * The NotPreparedException is thrown, if prepare() wasn't called before
	 * delete()
	 * 
	 * @author Dominik Wetzel
	 * 
	 */
	protected class NotPreparedException extends RuntimeException {
		private static final long serialVersionUID = -1871632509826762886L;

		public NotPreparedException(String message) {
			super(message);
		}

	}

}
