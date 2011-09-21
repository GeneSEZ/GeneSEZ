package de.genesez.platforms.common.workflow.feature;

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
import java.util.Properties;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.genesez.platforms.common.revisioncontrol.RegisterHelper;
import de.genesez.platforms.common.revisioncontrol.RevisionControlSystem;
import de.genesez.platforms.common.workflow.WorkflowUtils;

/**
 * The FileDeletionFeature handles the deletion of unchanged files during the
 * generation process. With the filter-options the search can be specified. It's
 * also possible to delete empty packages.
 * 
 * NOTE: Works only with Java 7.
 * 
 * @author Dominik Wetzel
 * @date 2011-09-20
 */
public class FileDeletionFeature extends SimpleFileVisitor<Path> implements
		GeneratorFeature {

	/**
	 * Logger instance to output important messages.
	 */
	protected Log logger = LogFactory.getLog(getClass());

	// The includes
	private Set<String> includedFiles = new LinkedHashSet<String>();

	// The excludes
	private Set<String> excludedFiles = new LinkedHashSet<String>();
	private Set<String> excludedRelativePaths = new LinkedHashSet<String>();
	private Set<String> excludedDirectoryNames = new LinkedHashSet<String>();

	// The switches for deletion
	private boolean deleteOldFiles = false;
	private boolean deleteEmptyFolders = false;

	// The available revision system implementations
	private List<RevisionControlSystem> repos = RegisterHelper
			.getAvailableRepositoryImpls();

	// The found revision system implementations
	private Set<RevisionControlSystem> revisionSystems = new HashSet<RevisionControlSystem>();

	// The trigger for the NotPreparedException
	private boolean prepared = false;

	// the maps for comparison between last modification dates
	private Map<String, Long> oldFiles = new LinkedHashMap<String, Long>();
	private Map<String, Long> fileMap = new LinkedHashMap<String, Long>();

	// the Path to the outputDirectory
	private Path outputPath;

	// Methods from the Interface //

	/**
	 * Sets the properties:
	 * <p>
	 * includedFiles<br>
	 * excludedFiles<br>
	 * excludedRelativePaths<br>
	 * excludedDirectoryNames<br>
	 * deleteOldFiles<br>
	 * deleteEmptyFolders<br>
	 * outputPath
	 * </p>
	 * 
	 * @param properties
	 *            the Properties-Map with the properties
	 */
	public void setProperties(Properties properties) {
		setIncludedFiles(properties.getProperty("includedFiles", ""));
		setExcludedFiles(properties.getProperty("excludedFiles", ""));
		setExcludedRelativePaths(properties.getProperty(
				"excludedRelativePaths", ""));
		setExcludedDirectoryNames(properties.getProperty(
				"excludedDirectoryNames", ""));
		setDeleteOldFiles(properties.getProperty("deleteOldFiles", "false"));
		setDeleteEmptyFolders(properties.getProperty("deleteEmptyFolders",
				"false"));
		outputPath = Paths.get(properties.getProperty("outputDir", ""));
	}

	/**
	 * Checks the Configuration and the revision system
	 */
	public void checkConfiguration() {
		if (outputPath.toString().equals("")) {
			deleteOldFiles = false;
			deleteEmptyFolders = false;
		}
		if (deleteOldFiles || deleteEmptyFolders) {
			String info = "File deletion is active.";
			if (deleteOldFiles && deleteEmptyFolders) {
				info = info.concat(" Not generated files and empty folders");
			} else if (deleteOldFiles) {
				info = info.concat(" Not generated files");
			} else {
				info = info.concat(" Empty folders");
			}
			info = info.concat(" will be deleted.");
			logger.info(info);

			String repos = checkRepository();
			if (repos == null) {
				logger.info("No supported revision control system found. Default will be used.");
			} else {
				logger.info("Revision control system(s) found: "
						+ repos.toString());
			}
			if (includedFiles.isEmpty() && excludedFiles.isEmpty()
					&& excludedRelativePaths.isEmpty()
					&& excludedDirectoryNames.isEmpty()) {
				logger.warn("Nothing included and excluded, every file will be searched and unchanged files will be deleted.");
			}
		}
	}

	/**
	 * Processes before generation. Prepares the file deletion.
	 */
	public void preProcessing() {
		if (deleteOldFiles) {
			logger.debug(prepare() + " file(s) found.");
		}
	}

	/**
	 * Processes after generation. Deletes old files and empty folders if
	 * switches set.
	 * 
	 * @throws NotPreparedException
	 *             if called before preProcessing()
	 */
	public void postProcessing() throws NotPreparedException {
		if (deleteOldFiles) {
			List<String> log = delete();
			logger.info(log.size() + " file(s) deleted.");
			logger.debug("Deleted file(s): " + log.toString());
		}
		if (deleteEmptyFolders) {
			List<String> log = deleteEmptyPackages();
			logger.info(log.size() + " folder(s) deleted.");
			logger.debug("Deleted folder(s): " + log.toString());
		}
	}

	// Methods that are internally used //

	/**
	 * checks which revision control system is used. Therefore it checks if a
	 * folder is one of the registered metadata folders
	 * 
	 * @param path
	 *            the startPath where the search begins (usually the outputDir)
	 * @return the name of the found revision control systems or "Default" if
	 *         nothing was found
	 */
	protected String checkRepository() {
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
	 * @return number of elements in the map
	 */
	protected int prepare() {
		try {
			Files.walkFileTree(outputPath, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		oldFiles.clear();
		oldFiles.putAll(fileMap);
		prepared = true;
		fileMap.clear();
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
	protected List<String> delete() throws NotPreparedException {
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
	protected List<String> deleteEmptyPackages() {
		final List<String> log = new LinkedList<String>();

		try {
			Files.walkFileTree(outputPath, new SimpleFileVisitor<Path>() {

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

					int size = 0;
					List<File> files = new LinkedList<File>();
					if (Files.exists(dir) && Files.isDirectory(dir)) {
						files = Arrays.asList(dir.toFile().listFiles());
						size = files.size();
					}
					// number of not empty files in the directory
					int notEmptyFolders = size;

					for (int i = 0; i < size; i++) {
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
						for (RevisionControlSystem rep : revisionSystems) {
							rep.markForDelete(dir.toString());
						}
						// delete all folders normal if possible
						if (Files.exists(dir) && size == 0) {
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

	// Setter Methods //

	/**
	 * Sets files that will be included in the search. <br>
	 * NOTE: Only files with these extensions will be included.
	 * 
	 * @param extensions
	 *            the IncludedFileExtension String contains all included Files
	 *            in a single String (separated by "," or ";")
	 */
	protected void setIncludedFiles(String extensions) {
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
	protected void setExcludedFiles(String extensions) {
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
	protected void setExcludedRelativePaths(String paths) {
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
	protected void setExcludedDirectoryNames(String names) {
		excludedDirectoryNames.clear();
		excludedDirectoryNames.addAll(WorkflowUtils.split(names));
	}

	/**
	 * Setter for the workflow parameter <em><b>deleteOld</b></em>.
	 * 
	 * Sets if old files should be deleted or not
	 * 
	 * @param deleteOld
	 *            Value of deleteOld True if it should be deleted.
	 */
	protected void setDeleteOldFiles(String deleteOld) {
		this.deleteOldFiles = Boolean.parseBoolean(deleteOld);
	}

	/**
	 * Setter for the workflow parameter <em><b>deleteEmptyFolders</b></em>.
	 * 
	 * if this is true, empty folders will be deleted after generation process
	 * 
	 * @param deleteEmpty
	 */
	protected void setDeleteEmptyFolders(String deleteEmpty) {
		this.deleteEmptyFolders = Boolean.parseBoolean(deleteEmpty);
	}

	// Methods from Superclass //

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
}
