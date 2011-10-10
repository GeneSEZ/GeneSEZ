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

import de.genesez.platforms.common.revisioncontrol.RevisionControlSystem;
import de.genesez.platforms.common.workflow.WorkflowUtils;
import de.genesez.platforms.common.workflow.feature.FileTreeWalkerFeature.FileEvent;

/**
 * The FileDeletionFeature handles the deletion of unchanged files during the
 * generation process. With the filter-options the search can be specified.
 * 
 * @prePrior 10
 * @postPrior 20
 * 
 * NOTE: Works only with Java 7.
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

	/**
	 * Constructor, sets postPriority to 20 and prePriority to 10
	 */
	public FileDeletionFeature(){
		super();
		prePriority = 10;
		postPriority = 20;
	}
	
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
		setIncludedFiles(properties.getProperty("includedFiles", ""));
		setExcludedFiles(properties.getProperty("excludedFiles", ""));
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
	public void post() {
		if (deleteOldFiles) {
			long time = System.currentTimeMillis();
			List<String> log = delete();
			time = System.currentTimeMillis() - time;
			logger.info(log.size() + " file(s) deleted.");
			logger.debug("Deleted file(s): " + log.toString());
			logger.debug("File deletion took: " + (time/1000.0) + "s");
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
			throw new NotPreparedException("File deletion was not prepared properly");
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
	public void setIncludedFiles(String extensions) {
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
		excludedFiles.addAll(WorkflowUtils.split(extensions));

	}

//	/**
//	 * Setter for the workflow parameter <em><b>deleteOld</b></em>.
//	 * 
//	 * Sets if old files should be deleted or not
//	 * 
//	 * @param deleteOld
//	 *            Value of deleteOld True if it should be deleted.
//	 */
//	protected void setDeleteOldFiles(String deleteOld) {
//		this.deleteOldFiles = Boolean.parseBoolean(deleteOld);
//	}

	/**
	 * checks if the file is a not excluded directory. If so it looks if its
	 * a known metadata folder. If its a not excluded or an included file, it
	 * will be stored with its last modification date in Map.
	 * 
	 * @param event
	 *            the event from FileTreeWalker
	 * @param file
	 *            the directory that will be checked
	 */
	@Override
	public void update(FileEvent event, Path file) {
		if (deleteOldFiles) {
			if (event.equals(FileEvent.BEFORE_DIR)) {
				// checks for revision System
				super.checkRepository(file);
			} else if (event.equals(FileEvent.FILE_VISIT)) {
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
			} else if (event.equals(FileEvent.COMPLETED)) {
				// log revision Systems, switch switches
				try {
					super.checksAbove(file.toRealPath());
				} catch (IOException e) {
					e.printStackTrace();
				}
				super.update(event, file);
				logger.debug(oldFiles.size() + " File(s) found.");
				prepared = true;
			}
		} 
	}

	/**
	 * Only for testing, gives the count of oldFiles found.
	 * 
	 * @return size of oldFiles set
	 */
	protected int getOldFileCount() {
		return oldFiles.size();
	}

	/**
	 * Called if in pre-list, does nothing
	 */
	@Override
	public void pre() {	
		// nothing to do
	}
	
//	@Override
//	public boolean needsPreWalk(){
//		return true;
//	}
//	
//	@Override
//	public boolean needsPostWalk(){
//		return false;
//	}
}
