package de.genesez.platforms.common;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
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
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.genesez.platforms.common.revisioncontrol.RegisterHelper;
import de.genesez.platforms.common.revisioncontrol.RevisionControlSystem;
import de.genesez.platforms.common.workflow.WorkflowUtils;

/**
 * The Deletor handles the deletion of unchanged files during the generation
 * process. With the filter-options the search can be specified. It's also
 * possible to delete empty packages.
 * 
 * NOTE: Works only with Java 7.
 * 
 * @author Dominik Wetzel
 * @date 2011-09-15
 * 
 */
public class Deletor extends SimpleFileVisitor<Path> {

	private Set<String> includedFiles = new LinkedHashSet<String>();
	private Set<String> excludedFiles = new LinkedHashSet<String>();
	private Set<String> excludedRelativePaths = new LinkedHashSet<String>();
	private Set<String> excludedDirectoryNames = new LinkedHashSet<String>();

	private Map<String, Long> oldFiles = new LinkedHashMap<String, Long>();
	private boolean prepared = false;
	private Path outputPath;
	private List<RevisionControlSystem> repos = RegisterHelper
			.getAvailableRepositoryImpls();
	private Set<RevisionControlSystem> revisionSystems = new HashSet<RevisionControlSystem>();

	private Map<String, Long> fileMap = new LinkedHashMap<String, Long>();

	/**
	 * Constructs the singleton
	 */
	public Deletor() {
	}

	/**
	 * checks which revision control system is used. Therefore it checks if a
	 * folder is one of the registered metadata folders
	 * 
	 * @param path
	 *            the startPath where the search begins (usually the outputDir)
	 * @return the name of the found revision control systems or "Default" if
	 *         nothing was found
	 */
	public String checkRepository(String path) {
		outputPath = Paths.get(path);
		try {
			Files.walkFileTree(outputPath, new SimpleFileVisitor<Path>() {

				/**
				 * looks if the directory is a known metadata folder.
				 * 
				 * @param dir
				 *            the directory that will be checked
				 * @param attr
				 *            the basic attributes of the directory.
				 * @return CONTINUE if no metadate Folder was found.
				 * @return SKIP_SUBTREE if a metadata folder was found.
				 */
				@Override
				public FileVisitResult preVisitDirectory(Path dir,
						BasicFileAttributes attr) throws IOException {
					for (RevisionControlSystem rep : repos) {
						String name = rep.getMetadataFolderName();
						if (dir.endsWith(name)) {
							excludedDirectoryNames.add(name);
							revisionSystems.add(rep);
							rep.setRepositoryRoot(dir.toString());
							return FileVisitResult.SKIP_SUBTREE;
						}
					}
					return FileVisitResult.CONTINUE;
				}
			});
			checksAbove(outputPath.toRealPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (revisionSystems.isEmpty()) {
			return null;
		}
		return revisionSystems.toString();
	}

	/**
	 * Checks if there is another repository metadata folder above the given
	 * path.
	 * 
	 * @param absolutePath
	 *            the absolute path where the search begins
	 */
	private void checksAbove(Path absolutePath) {
		Path parent = absolutePath.getParent();
		if (parent != null) {
			DirectoryStream<Path> stream = null;
			try {
				stream = Files.newDirectoryStream(parent, "*.*");
				for (Path dir : stream) {
					for (RevisionControlSystem rep : repos) {
						String name = rep.getMetadataFolderName();
						if (dir.endsWith(name)) {
							revisionSystems.add(rep);
						}
					}
				}
			} catch (IOException e) {
			} finally {
				if (stream != null) {
					try {
						stream.close();
					} catch (IOException e) {
						System.err.println("Directory Stream on " + parent
								+ " couldn't be closed.");
					}
				}
			}
			checksAbove(parent);
		}
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
		outputPath = Paths.get(path);
		return prepare();
	}

	/**
	 * Prepares the deletion of Files. Needs to be called before delete.
	 * Searches for files in the directories under path and stores the last
	 * modification dates in a map. The search uses the given filters.
	 * 
	 * @return number of elements in the map
	 */
	public int prepare() {
		try {
			Files.walkFileTree(outputPath, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		oldFiles.clear();
		oldFiles.putAll(fileMap);
		fileMap.clear();
		prepared = true;
		return oldFiles.size();
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
			try {
				Files.walkFileTree(outputPath, this);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return deleteOldFiles(oldFiles);
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
	public List<String> deleteEmptyPackages(String path) {
		final List<String> log = new LinkedList<String>();

		try {
			Files.walkFileTree(Paths.get(path), new SimpleFileVisitor<Path>() {

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
						BasicFileAttributes attrs) throws IOException {
					UserDefinedFileAttributeView view = Files
							.getFileAttributeView(dir,
									UserDefinedFileAttributeView.class);
					view.write("user.empty",
							Charset.defaultCharset().encode("false"));
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
				 * After it visits the directory the method checks, whether its
				 * and its subfolders are empty or not and deletes it if they
				 * are empty.
				 * 
				 * @param dir
				 *            directory that is checked
				 * @param null if the iteration of the directory completes
				 *        without an error; otherwise the I/O exception that
				 *        caused the iteration of the directory to complete
				 *        prematurely
				 * @return CONTINUE
				 * @throws IOException
				 *             if IO-Error occurs
				 */
				@Override
				public FileVisitResult postVisitDirectory(Path dir,
						IOException exc) throws IOException {

					List<File> files = Arrays.asList(dir.toFile().listFiles());
					// number of not empty files in the directory
					int notEmptyFolders = files.size();

					for (int i = 0; i < files.size(); i++) {
						Path subfolder = files.get(i).toPath();
						if (Files.isDirectory(subfolder)) {
							boolean toBreak = false;
							// if metadata folder "number of not empty files" -1
							for (RevisionControlSystem rep : revisionSystems) {
								if (subfolder.endsWith(rep
										.getMetadataFolderName())) {
									notEmptyFolders--;
									toBreak = true;
									break;
								}
							}
							if (toBreak) {
								continue;
							}
							UserDefinedFileAttributeView view = Files
									.getFileAttributeView(subfolder,
											UserDefinedFileAttributeView.class);
							ByteBuffer buffer = ByteBuffer.allocate(view
									.size("user.empty"));
							// reads user attribute "user.empty"
							view.read("user.empty", buffer);
							buffer.flip();
							// checks if subfolders are empty or not, if empty
							// "number of not empty files" -1
							if (Charset.defaultCharset().decode(buffer)
									.toString().equals("true")) {
								notEmptyFolders--;
							}
						} else {
							break;
						}
					}

					if (notEmptyFolders == 0) {
						UserDefinedFileAttributeView view = Files
								.getFileAttributeView(dir,
										UserDefinedFileAttributeView.class);
						view.write("user.empty", Charset.defaultCharset()
								.encode("true"));
						// delete all folders with revisionSystem
						if (revisionSystems != null) {
							for (RevisionControlSystem rep : revisionSystems) {
								rep.markForDelete(dir.toString());
							}
						}
						if(Files.exists(dir) && files.size() == 0){
							alterPermission(dir);
							Files.delete(dir);
						}
						log.add(dir.toString());
					}
					return FileVisitResult.CONTINUE;
				}
			});
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return log;
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
		includedFiles.clear();
		includedFiles.addAll(WorkflowUtils.split(extensions));

	}

	/**
	 * Sets files that will be excluded in the search.
	 * 
	 * @param extensions
	 *            the ExcludedFileExtension String contains all excluded Files
	 *            in a single String (separated by "," or ";")
	 */
	public void setExcludedFiles(String extensions) {
		excludedFiles.clear();
		excludedFiles.addAll(WorkflowUtils.split(extensions));

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
		excludedRelativePaths.clear();
		List<String> list = WorkflowUtils.split(paths);
		for (String s : list) {
			excludedRelativePaths.add(Paths.get(s).toString());
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
		excludedDirectoryNames.clear();
		excludedDirectoryNames.addAll(WorkflowUtils.split(names));
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
				if (fileMap.get(s).equals(oldFiles.get(s))) {
					logged.add(s.toString());
					for (RevisionControlSystem rep : revisionSystems) {
						rep.markForDelete(s);
					}
					try {
						Path path = Paths.get(s);
						if (Files.exists(path)) {
							alterPermission(path);
							Files.delete(path);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		fileMap.clear();
		return logged;
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
		if (!(excludedFiles.size() == 1 && excludedFiles.contains(""))) {
			for (String s : excludedFiles) {
				if (file.toString().endsWith(s)) {
					return FileVisitResult.CONTINUE;
				}
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
	 * Is invoked by walkFileTree. If the path starts with a phrase from the
	 * excludedRelativePaths or is in excludedDirectoryNames the directory will
	 * be skipped in the search.
	 * 
	 * @param dir
	 *            a reference to the directory
	 * @param attrs
	 *            the directory's basic attributes
	 * @return CONTINUE if its not excluded else SKIP_SUBTREE
	 */
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
		if (!(excludedRelativePaths.size() == 1 && excludedRelativePaths
				.contains(""))) {
			for (String s : excludedRelativePaths) {
				if (dir.startsWith(Paths.get(s))) {
					return FileVisitResult.SKIP_SUBTREE;
				}
			}
		}
		if (!(excludedDirectoryNames.size() == 1 && excludedDirectoryNames
				.contains(""))) {
			for (String s : excludedDirectoryNames) {
				if (dir.endsWith(s)) {
					return FileVisitResult.SKIP_SUBTREE;
				}
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
