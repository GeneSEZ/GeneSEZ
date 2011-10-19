package de.genesez.platforms.common.workflow.feature;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.genesez.platforms.common.NotPreparedException;
import de.genesez.platforms.common.revisioncontrol.RevisionControlSystem;
import de.genesez.platforms.common.workflow.WorkflowUtils;

/**
 * The FileDeletionFeature handles the deletion of unchanged files during the
 * generation process. With the filter-options the search can be specified.
 * 
 * @author Dominik Wetzel
 * @date 2011-09-20
 */
public class FileDeletionFeature extends DeletionFeature {

	/**
	 * Logger instance to output important messages.
	 */
	protected Log logger = LogFactory.getLog(getClass());

	// The includes
	private Set<String> includedFiles = new LinkedHashSet<String>();

	// The excludes
	private Set<String> excludedFiles = new LinkedHashSet<String>();

	// The switches for deletion
	private boolean deleteOldFiles = true;

	// The trigger for the NotPreparedException
	private boolean prepared = false;

	// the maps for comparison between last modification dates
	private Map<String, Long> oldFiles = new LinkedHashMap<String, Long>();

	// Methods from the Interface //

	/**
	 * Sets the properties:
	 * <p>
	 * includedFiles<br>
	 * excludedFiles<br>
	 * and properties in Superclass
	 * </p>
	 * 
	 * @param properties
	 *            the Properties-Map with the properties
	 */
	public void setProperties(Properties properties) {
		setIncludedFileExtensions(properties.getProperty("includedFiles", ""));
		setExcludedFileExtensions(properties.getProperty("excludedFiles", ""));
		super.setProperties(properties);
	}

	/**
	 * Checks if an outputDir is given.
	 */
	public void checkConfiguration() {
		// deactivates deletion if no outputDirectory is set
		if (super.outputPath == null || super.outputPath.toString().isEmpty()) {
			deleteOldFiles = false;
			logger.info("No output directory given. Folder deletion is deactivated.");
		}
		if (deleteOldFiles) {
			logger.info("File deletion is active. Not Generated files will be deleted");
		}
	}

	/**
	 * Processes after generation. Deletes old files if switch is set.
	 */
	public void invokePost() {
		if (deleteOldFiles) {
			long time = System.currentTimeMillis();
			List<String> log = delete();
			time = System.currentTimeMillis() - time;
			logger.info(log.size() + " file(s) deleted.");
			logger.debug("Deleted file(s): " + log.toString());
			logger.debug("File deletion took: " + (time / 1000.0) + "s");
		}
	}

	// Methods that are internally used //

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
			List<String> toDelete = new LinkedList<String>();
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
				for (RevisionControlSystem rep : super.getRevisionSystems()) {
					rep.markForDelete(delete);
				}
				try {
					Path del = Paths.get(delete);
					super.alterPermission(del);
					Files.deleteIfExists(del);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return toDelete;
		} else {
			throw new NotPreparedException(
					"File deletion was not prepared properly");
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
	public void setIncludedFileExtensions(String extensions) {
		includedFiles.addAll(WorkflowUtils.split(extensions));

	}

	/**
	 * Sets files that will be excluded in the search.
	 * 
	 * @param extensions
	 *            the ExcludedFileExtension String contains all excluded Files
	 *            in a single String (separated by "," or ";")
	 */
	public void setExcludedFileExtensions(String extensions) {
		excludedFiles.addAll(WorkflowUtils.split(extensions));

	}

	/**
	 * checks if the file is not excluded somehow or if its included. If so, it
	 * will be stored with its last modification date in Map.
	 * 
	 * @param file
	 *            the file that will be checked
	 */
	@Override
	public void updateFileVisit(Path file) {
		if (deleteOldFiles) {
			// looks if file is in or excluded
			for (String exclDirName : super.excludedDirectoryNames) {
				if (file.toString().matches(
						".*[\\\\|/]" + exclDirName + "[\\\\|/].*")) {
					return;
				}
			}
			for (String exclRelPath : super.excludedRelativePaths) {
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
		}
	}

	/**
	 * Logs revision Systems and found files, also sets prepared to true. Called
	 * if file tree completely walked.
	 */
	@Override
	public void updateComplete() {
		super.logRevisionSystems();
		logger.debug(oldFiles.size() + " File(s) found.");
		prepared = true;
	}

	/**
	 * Only for testing, gives the count of oldFiles found.
	 * 
	 * @return size of oldFiles set
	 */
	protected int getOldFileCount() {
		return oldFiles.size();
	}
}
