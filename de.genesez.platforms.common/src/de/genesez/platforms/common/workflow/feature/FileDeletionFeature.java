package de.genesez.platforms.common.workflow.feature;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.ArrayList;
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

import de.genesez.platforms.common.FileTreeObserver;
import de.genesez.platforms.common.FileTreeWalker.FileEvent;
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
public class FileDeletionFeature implements	FileTreeObserver, GeneratorFeature {

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

	// the Path to the outputDirectory
	private Path outputPath;

	private boolean treeWalked = false;

	private List<Path> emptyFolders = new ArrayList<>();
	
	private long time;

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
	 * Checks the Configuration and the revision system above the outputDir
	 */
	public void checkConfiguration() {
		// deactivates deletion if no outputDirectory is set
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

			try {
				checksAbove(outputPath.toRealPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
//			if (includedFiles.isEmpty() && excludedFiles.isEmpty()
//					&& excludedRelativePaths.isEmpty()
//					&& excludedDirectoryNames.isEmpty()) {
//				logger.warn("Nothing included and excluded, every file will be searched and unchanged files will be deleted.");
//			}
		}
	}

	/**
	 * Processes after generation. Deletes old files if
	 * switch is set.
	 */
	public void afterGeneration() {
		time = System.currentTimeMillis();
		if (deleteOldFiles) {
			List<String> log = delete();
			logger.info(log.size() + " file(s) deleted.");
			logger.debug("Deleted file(s): " + log.toString());
		}
	}
	
	/**
	 * Processes after second file tree walk. Deletes empty folders if
	 * switch is set.
	 */
	public void afterSecondFileWalk() {
		if (deleteEmptyFolders) {
			List<String> log = deleteEmptyPackages();
			logger.info(log.size() + " folder(s) deleted.");
			logger.debug("Deleted folder(s): " + log.toString());
		}
		time = System.currentTimeMillis() - time;
		logger.debug("File deletion took: " + (time/1000.0) + "s");
	}

	// Methods that are internally used //

	/**
	 * Checks if there is another repository metadata folder above the given
	 * path.
	 * 
	 * @param absolutePath
	 *            the absolute path where the search begins
	 */
	private void checksAbove(Path absolutePath) {
		// get parent dir of absolute path
		Path parent = absolutePath.getParent();
		if (parent != null) {
			// checks if parent contains a repository metadata folder
			try (DirectoryStream<Path> stream = Files.newDirectoryStream(parent, "*.*")){
				for (Path dir : stream) {
					for (RevisionControlSystem rep : repos) {
						String name = rep.getMetadataFolderName();
						if (dir.endsWith(name)) {
							// add found revision system
							revisionSystems.add(rep);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Something went wrong");
			}
			checksAbove(parent);
		}
	}

	/**
	 * deletes the unchanged files. Therefore it compares the old last
	 * modification dates with the new ones.
	 * 
	 * @return List with deleted Elements
	 * @throws NotPreparedException
	 *             if prepare wasn't called before
	 */
	protected List<String> delete() throws NotPreparedException {
		if (prepared) {
			Set<String> keys = oldFiles.keySet();
			List<String> toDelete = new LinkedList<>();
			// search for files to delete
			for (String key : keys) {
				Path path = Paths.get(key);
				if (Files.exists(path)) {
					// check if LMDs are equal
					if (oldFiles.get(key) == path.toFile().lastModified()) {
						toDelete.add(key);
					}
				}
			}
			// delete files in repositories and in filesystem
			for (String delete : toDelete) {
				for (RevisionControlSystem rep : revisionSystems) {
					rep.markForDelete(delete);
				}
				try {
					Files.deleteIfExists(Paths.get(delete));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return toDelete;
		} else {
			throw new NotPreparedException("prepare() was not called before");
		}
	}

	/**
	 * Prepares deletion of empty packages (folders). It checks whether the subfolders are
	 * empty or not and stores the folder paths if its empty.
	 * 
	 * @param dir
	 *            the current directory that will be checked
	 * @return a list with all deleted folders
	 */
	protected void prepareDeleteEmptyPackages(Path dir) {
		// is directory excluded?
		for (String exclDirName : excludedDirectoryNames) {
			if (dir.endsWith(exclDirName) || dir.toString().matches(".*[\\\\|/]" + exclDirName + "[\\\\|/].*")) {
				return;
			}
		}
		for (String exclRelPath : excludedRelativePaths) {
			if (dir.startsWith(exclRelPath)) {
				return;
			}
		}
		// get subfiles and count of subfiles
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
					if (subfolder.endsWith(rep.getMetadataFolderName())) {
						notEmptyFolders--;
						toBreak = true;
						break;
					}
				}
				if (toBreak) {
					continue;
				}
				if (emptyFolders.contains(subfolder)) {
					notEmptyFolders--;
				}
			} else {
				break;
			}
		}

		if (notEmptyFolders == 0) {
			emptyFolders.add(dir);
		}
	}

	/**
	 * deletes previously found empty folders
	 * @return list with deleted folders
	 */
	protected List<String> deleteEmptyPackages() {
		List<String> list = new LinkedList<String>();
		for (Path dir : emptyFolders) {
			for (RevisionControlSystem rep : revisionSystems) {
				rep.markForDelete(dir.toString());
			}
			// delete all folders normal if possible
			if (Files.exists(dir) && dir.toFile().listFiles().length == 0) {
				try {
					alterPermission(dir);
					Files.delete(dir);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			list.add(dir.toString());
		}
		emptyFolders.clear();
		return list;
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

	/**
	 * checks if the file is a not excluded directory and if so it looks if its
	 * a known metadata folder. If its a not excluded or an included file, it
	 * will be stored with its last modification date in Map.
	 * 
	 * @param event
	 *            the event from FileTreeWalker
	 * @param file
	 *            the directory that will be checked
	 */
	public void update(FileEvent event, Path file) {
		if (!treeWalked && deleteOldFiles) {
			if (event.equals(FileEvent.BEFORE_DIR)) {
				// checks for revision System
				for (RevisionControlSystem rep : repos) {
					String name = rep.getMetadataFolderName();
					if (file.endsWith(name)) {
						excludedDirectoryNames.add(name);
						revisionSystems.add(rep);
						rep.setRepositoryRoot(file.toString());
					}
				}
			} else if (event.equals(FileEvent.FILE_VISIT)) {
				// looks if file is in or excluded
				for (String exclDirName : excludedDirectoryNames) {
					if (file.toString().matches(
							".*[\\\\|/]" + exclDirName + "[\\\\|/].*")) {
						return;
					}
				}
				for (String exclRelPath : excludedRelativePaths) {
					if (file.startsWith(exclRelPath)) {
						return;
					}
				}
				for (String exclFile : excludedFiles) {
					if (file.toString().endsWith(exclFile)) {
						return;
					}
				}
				if (!includedFiles.isEmpty()) {
					for (String inclFile : includedFiles) {
						if (file.toString().endsWith(inclFile)) {
							oldFiles.put(file.toString(), file.toFile()
									.lastModified());
						}
					}
					return;
				}
				// add to oldFiles map (with LMD)
				oldFiles.put(file.toString(), file.toFile().lastModified());
			} else if (event.equals(FileEvent.COMPLETED)) {
				// log revision Systems, switch switches
				if (revisionSystems.isEmpty()) {
					logger.info("No supported revision control system found. Default will be used.");
				} else {
					logger.info("Revision control system(s) found: "
							+ revisionSystems.toString());
				}
				logger.debug(oldFiles.size() + " File(s) found.");
				treeWalked = true;
				prepared = true;
			}
		} else if (event.equals(FileEvent.AFTER_DIR) && deleteEmptyFolders) {
			// prepare package deletion
			prepareDeleteEmptyPackages(file);
		} else if (event.equals(FileEvent.COMPLETED)){
			// switch treeWalked switch
			treeWalked = false;
		}
	}
	
	/**
	 * Only for testing, gives the count of oldFiles found.
	 * @return size of oldFiles set
	 */
	protected int getOldFileCount(){
		return oldFiles.size();
	}
	
	/**
	 * Says whether the observer needs a file tree walk before generation.
	 * It will be registered as observer if true.
	 * @return value of deleteOldFiles
	 */
	public boolean getNeedsPrepare(){
		return deleteOldFiles;
	}
	
	/**
	 * Says whether the observer needs file tree walk after generation.
	 * It will be again registered as observer if true
	 * @return value of deleteEmptyFolders
	 */
	public boolean getNeedsSecondWalk(){
		return deleteEmptyFolders;
	}
}
