package org.genesez.platform.common.workflow.feature;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1317801515946_36906_1554) 
 */

import java.util.List;
import java.io.IOException;
import org.apache.commons.logging.LogFactory;
import java.nio.file.Paths;
import org.genesez.platform.common.FileTreeObserverAdapter;
import org.apache.commons.logging.Log;
import java.util.Properties;
import org.genesez.platform.common.revisioncontrol.RegisterHelper;
import java.nio.file.DirectoryStream;
import org.genesez.platform.common.workflow.WorkflowUtils;
import java.nio.file.Path;
import java.nio.file.Files;
import org.genesez.platform.common.revisioncontrol.RevisionControlSystem;
import java.util.LinkedList;

/**
 * Superclass for the FileDeletion. Contains methods to check which repository is in use and logs them.
 * 
 * @author Dominik Wetzel
 * @date 2011-10-11
 * @deprecated
 */
public abstract class DeletionFeature extends FileTreeObserverAdapter implements PostFeature {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static boolean printedRevisionSystemsOnce = false;
	
	/**
	 * Logger instance to output important messages.
	 */
	protected Log logger = LogFactory.getLog(getClass());
	
	/**
	 * Directory names that are excluded during file search
	 */
	
	protected java.util.Set<String> excludedDirectoryNames = new java.util.HashSet<String>();
	
	/**
	 * paths relative to output directory that are excluded during the file search.
	 */
	
	protected java.util.Set<String> excludedRelativePaths = new java.util.HashSet<String>();
	
	/**
	 * The outputPath, where deletion should take place.
	 */
	protected Path outputPath = null;
	
	private java.util.Set<RevisionControlSystem> revisionSystems = new java.util.HashSet<RevisionControlSystem>();
	
	private java.util.Set<RevisionControlSystem> repos = RegisterHelper.getAvailableImpls();
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Checks if the given directory is a known repository metadata folder
	 * @param	dir	the folder that should be checked
	 */
	
	protected void checkRepository(Path dir) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1317884498346_130118_1598) ENABLED START */
		for (RevisionControlSystem rep : repos) {
			String name = rep.getMetadataFolderName();
			if (dir.endsWith(name)) {
				excludedDirectoryNames.add(name);
				revisionSystems.add(rep);
				rep.setRepositoryRoot(dir.toString());
				return;
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Checks if there is another repository metadata folder above the given path.
	 * @param	absolutePath	the absolute path where the search begins.
	 */
	
	protected void checkAbove(Path absolutePath) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1317884506208_100588_1601) ENABLED START */
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
			checkAbove(parent);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Checks if the directory is a repository metadata folder.
	 * @see #checkRepository(Path)
	 * @param	dir	the directory that will be checked.
	 */
	
	public void updateBeforeDir(Path dir) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1317885012666_785322_1880) ENABLED START */
		checkRepository(dir);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets the properties:
	 * <p>
	 * excludedRelativePaths<br>
	 * excludedDirectoryNames<br>
	 * outputPath
	 * </p>
	 * @param	properties	the Properties-Map with the properties.
	 */
	
	public void setProperties(Properties properties) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318575036056_189346_1991) ENABLED START */
		outputPath = Paths.get(properties.getProperty("outputDir", ""));
		// checks if excludedRelativePaths set before.
		if (excludedRelativePaths.isEmpty()) {
			setExcludedRelativePaths(properties.getProperty("excludedRelativePaths", ""));
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
			setExcludedDirectoryNames(properties.getProperty("excludedDirectoryNames", ""));
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets RelativPaths (to the OutputDirectory) which will be excluded in the search.
	 * @param	paths	contains all excluded Paths in a single String (separated by "," or ";")
	 */
	
	public void setExcludedRelativePaths(String paths) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318592131059_64292_3400) ENABLED START */
		List<String> list = WorkflowUtils.split(paths);
		for (String s : list) {
			excludedRelativePaths.add(Paths.get(s).toString());
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets directory names that are excluded in the search. <br> NOTE: Every directory with the same spelling will be excluded.
	 * @param	names	contains all Names that are excluded (separated by "," or ";")
	 */
	
	public void setExcludedDirectoryNames(String names) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318592151612_629365_3403) ENABLED START */
		excludedDirectoryNames.addAll(WorkflowUtils.split(names));
		/* PROTECTED REGION END */
	}
	
	/**
	 * logs the found revision systems once.
	 */
	
	protected void logRevisionSystems() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318592243052_444308_3407) ENABLED START */
		try {
			checkAbove(outputPath.toRealPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (!printedRevisionSystemsOnce) {
			if (getRevisionSystems().isEmpty()) {
				logger.info("No supported revision control system found. Default will be used.");
			} else {
				logger.info("Revision control system(s) found: " + getRevisionSystems().toString());
			}
			printedRevisionSystemsOnce = true;
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>revisionSystems</b></em>'
	 */
	public java.util.Set<RevisionControlSystem> getRevisionSystems() {
		return revisionSystems;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1317801515946_36906_1554) ENABLED START */
	/* PROTECTED REGION END */
	
}
