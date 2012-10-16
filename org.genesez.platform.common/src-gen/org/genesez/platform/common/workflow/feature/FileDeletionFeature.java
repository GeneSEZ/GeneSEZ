package org.genesez.platform.common.workflow.feature;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1317372275257_835562_2042) 
 */

import java.util.Map;
import org.genesez.platform.common.FileSystemHelper;
import java.io.IOException;
import java.nio.file.Paths;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.genesez.platform.common.NotPreparedException;
import java.util.Properties;
import java.util.HashMap;
import org.genesez.platform.common.workflow.WorkflowUtils;
import java.util.Set;
import java.nio.file.Path;
import java.nio.file.Files;
import org.genesez.platform.common.revisioncontrol.RevisionControlSystem;
import java.util.HashSet;

/**
 * The FileDeletionFeature handles the deletion of unchanged files during the generation process. With the filter-options the search can be specified.
 * 
 * @author Dominik Wetzel
 * @date 2011-09-20
 * @deprecated
 */
public class FileDeletionFeature extends DeletionFeature {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * Logger instance to output important messages.
	 */
	protected Log logger = LogFactory.getLog(getClass());
	
	/**
	 * the includes
	 */
	
	private java.util.Set<String> includedFiles = new java.util.HashSet<String>();
	
	/**
	 * the excludes
	 */
	
	private java.util.Set<String> excludedFiles = new java.util.HashSet<String>();
	
	/**
	 * switch for deletion
	 */
	private boolean deleteOldFiles = true;
	
	/**
	 * trigger for the NotPreparedException
	 */
	private boolean prepared = false;
	
	/**
	 * the map for comparison between last modification dates
	 */
	private Map<String, Long> oldFiles = new HashMap<String, Long>();
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Sets the properties:
	 * <p>
	 * includedFiles<br>
	 * excludedFiles<br>
	 * and properties in Superclass
	 * </p>
	 * @param	properties	the Properties-Map with the properties
	 */
	
	public void setProperties(Properties properties) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1317372284273_984931_2060) ENABLED START */
		setIncludedFileExtensions(properties.getProperty("includedFiles", ""));
		setExcludedFileExtensions(properties.getProperty("excludedFiles", ""));
		super.setProperties(properties);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Checks if an outputDir is given. If not it deactivates itself.
	 */
	
	public void checkConfiguration() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1317372297378_146354_2063) ENABLED START */
		// deactivates deletion if no outputDirectory is set
		if (super.outputPath == null || super.outputPath.toString().isEmpty()) {
			deleteOldFiles = false;
			logger.info("No output directory given. Folder deletion is deactivated.");
		}
		if (deleteOldFiles) {
			logger.info("File deletion is active. Not Generated files will be deleted");
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Processes after generation. Deletes old files if switch is set.
	 */
	
	public void invokePost() throws NotPreparedException {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1317372303618_749971_2069) ENABLED START */
		if (deleteOldFiles) {
			long time = System.currentTimeMillis();
			Set<String> log = delete();
			time = System.currentTimeMillis() - time;
			logger.info(log.size() + " file(s) deleted.");
			logger.debug("Deleted file(s): " + log.toString());
			logger.debug("File deletion took: " + (time / 1000.0) + "s");
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	file	
	 */
	
	public void updateFileVisit(Path file) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1317372319920_484785_2078) ENABLED START */
		if (deleteOldFiles) {
			// looks if file is in or excluded
			for (String exclDirName : super.excludedDirectoryNames) {
				if (file.toString().matches(".*[\\\\|/]" + exclDirName + "[\\\\|/].*")) {
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
						oldFiles.put(file.toString(), file.toFile().lastModified());
					}
				}
				return;
			}
			// add to oldFiles map (with LMD)
			oldFiles.put(file.toString(), file.toFile().lastModified());
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Logs revision systems and found files, also sets prepared to true. Called if file tree completely walked.
	 */
	
	public void updateComplete() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318575240166_679806_1998) ENABLED START */
		super.logRevisionSystems();
		logger.debug(oldFiles.size() + " File(s) found.");
		prepared = true;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Only for testing, gives the count of files found.
	 * @return	size of oldFiles set.
	 */
	protected int getOldFileCount() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318593790564_299932_3525) ENABLED START */
		return oldFiles.size();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets file extensions that will be included in the search. <br>
	 * NOTE: Only files with these extensions will be included.
	 * @param	extensions	the IncludedFileExtension String containing all included file extensions in a single String (separated by "," or ";")
	 */
	
	public void setIncludedFileExtensions(String extensions) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318593800188_66920_3529) ENABLED START */
		includedFiles.addAll(WorkflowUtils.split(extensions));
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets file extensions that will be excluded in the search.
	 * @param	extensions	the excludedFileExtension String containing all excluded file extensions in a single String (separated by "," or ";")
	 */
	
	public void setExcludedFileExtensions(String extensions) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318593851549_988507_3533) ENABLED START */
		excludedFiles.addAll(WorkflowUtils.split(extensions));
		/* PROTECTED REGION END */
	}
	
	/**
	 * deletes the unchanged files. Therefore it compares the old last modification dates with the new ones.
	 * 
	 * @throws NotPreparedException if prepare wasn't called before
	 * @return	
	 */
	protected java.util.Set<String> delete() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318593864667_538815_3536) ENABLED START */
		if (prepared) {
			Set<String> keys = oldFiles.keySet();
			Set<String> toDelete = new HashSet<String>();
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
					FileSystemHelper.alterPermission(del);
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
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1317372275257_835562_2042) ENABLED START */
	/* PROTECTED REGION END */
	
}
