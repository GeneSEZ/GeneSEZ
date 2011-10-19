package de.genesez.platforms.common.workflow.feature;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.genesez.platforms.common.FileTreeObserver;
import de.genesez.platforms.common.FileTreeObserverAdapter;
import de.genesez.platforms.common.revisioncontrol.RegisterHelper;
import de.genesez.platforms.common.revisioncontrol.RevisionControlSystem;
import de.genesez.platforms.common.workflow.WorkflowUtils;

/**
 * Superclass for the FileDeletion. Contains methods to check which repository
 * is in use and logs them.
 * 
 * @author Dominik Wetzel
 * @date 2011-10-11
 */
public abstract class DeletionFeature extends FileTreeObserverAdapter implements
		PostFeature, FileTreeObserver {

	/**
	 * Logger instance to output important messages.
	 */
	protected Log logger = LogFactory.getLog(getClass());

	/**
	 * Directory names that are excluded during file search
	 */
	protected Set<String> excludedDirectoryNames = new LinkedHashSet<String>();

	/**
	 * paths relative to output directory that are excluded during the file
	 * search.
	 */
	protected Set<String> excludedRelativePaths = new LinkedHashSet<String>();

	/**
	 * The outputPath, where deletion should take place
	 */
	protected Path outputPath = null;

	private Set<RevisionControlSystem> revisionSystems = new HashSet<RevisionControlSystem>();
	private List<RevisionControlSystem> repos = RegisterHelper
			.getAvailableRepositoryImpls();
	private static boolean printedRevisionSystemsOnce = false;

	/**
	 * Sets the properties:
	 * <p>
	 * excludedRelativePaths<br>
	 * excludedDirectoryNames<br>
	 * outputPath
	 * </p>
	 * 
	 * @param properties
	 *            the Properties-Map with the properties
	 */
	public void setProperties(Properties properties) {
		outputPath = Paths.get(properties.getProperty("outputDir", ""));
		// checks if excludedRelativePaths set before.
		if (excludedRelativePaths.isEmpty()) {
			setExcludedRelativePaths(properties.getProperty(
					"excludedRelativePaths", ""));
		}
		// adds the outputPath before the excludedRelativePaths.
		List<String> tmpList = new LinkedList<String>();
		tmpList.addAll(excludedRelativePaths);
		excludedRelativePaths.clear();
		for (String s : tmpList) {
			excludedRelativePaths.add(outputPath.resolve(s).toString());
		}
		// checks if excludedDirectoryNames set before.
		if (excludedDirectoryNames.isEmpty()) {
			setExcludedDirectoryNames(properties.getProperty(
					"excludedDirectoryNames", ""));
		}
	}

	/**
	 * Checks if the given directory is a known repository metadata folder
	 * 
	 * @param dir
	 *            the folder that should be checked
	 */
	protected void checkRepository(Path dir) {
		for (RevisionControlSystem rep : repos) {
			String name = rep.getMetadataFolderName();
			if (dir.endsWith(name)) {
				excludedDirectoryNames.add(name);
				revisionSystems.add(rep);
				rep.setRepositoryRoot(dir.toString());
				return;
			}
		}
	}

	/**
	 * Checks if there is another repository metadata folder above the given
	 * path.
	 * 
	 * @param absolutePath
	 *            the absolute path where the search begins
	 */
	protected void checksAbove(Path absolutePath) {
		// get parent dir of absolute path
		Path parent = absolutePath.getParent();
		if (parent != null) {

			DirectoryStream<Path> stream = null;
			// checks if parent contains a repository metadata folder
			try {
				stream = Files.newDirectoryStream(parent, ".*");
				for (Path dir : stream) {
					for (RevisionControlSystem rep : repos) {
						String name = rep.getMetadataFolderName();
						if (dir.endsWith(name)) {
							excludedDirectoryNames.add(name);
							revisionSystems.add(rep);
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("Something went wrong");
			} finally {
				if (stream != null) {
					try {
						stream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			checksAbove(parent);
		}
	}

	/**
	 * Getter for found revisionSystems
	 * 
	 * @return copy of revisionSystems Set.
	 */
	public Set<RevisionControlSystem> getRevisionSystems() {
		Set<RevisionControlSystem> copy = new LinkedHashSet<RevisionControlSystem>();
		copy.addAll(revisionSystems);
		return copy;
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
	protected boolean alterPermission(Path file) throws IOException {
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
	 * Sets RelativPaths (to the OutputDirectory) which will be excluded in the
	 * search.
	 * 
	 * @param paths
	 *            contains all excluded Paths in a single String (separated by
	 *            "," or ";")
	 */
	public void setExcludedRelativePaths(String paths) {
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
		excludedDirectoryNames.addAll(WorkflowUtils.split(names));
	}

	/**
	 * logs the found revision systems once.
	 */
	protected void logRevisionSystems() {
		try {
			checksAbove(outputPath.toRealPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (!printedRevisionSystemsOnce) {
			if (getRevisionSystems().isEmpty()) {
				logger.info("No supported revision control system found. Default will be used.");
			} else {
				logger.info("Revision control system(s) found: "
						+ getRevisionSystems().toString());
			}
			printedRevisionSystemsOnce = true;
		}
	}

	/**
	 * Checks if the directory is a repository metadata folder
	 * 
	 * @see #checkRepository(Path)
	 * @param dir
	 *            the directory that will be checked
	 */
	public void updateBeforeDir(Path dir) {
		checkRepository(dir);
	}
}
