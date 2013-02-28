package org.genesez.platform.common.revisioncontrol;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1323946227166_577883_2730) 
 */

import java.io.File;
import org.tmatesoft.svn.core.wc.SVNWCClient;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.SVNException;

/**
 * Implementation of the delete algorithm for SVN.
 * 
 * @author Dominik Wetzel
 * @date 2011-09-15
 */
public class SubversionImpl implements RevisionControlSystem {
	
	// -- generated attribute, constant + association declarations ----------
	
	private String metadataFolderName = ".svn";
	
	private SVNClientManager manager = SVNClientManager.newInstance();
	
	private SVNWCClient wcClient = manager.getWCClient();
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * A callback from the DeletionFeature. Not needed for Subversion.
	 * @param	name	the location of found metadata folder
	 */
	
	public void setRepositoryRoot(String name) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1323946227182_58995_2738) ENABLED START */
		/* PROTECTED REGION END */
	}
	
	/**
	 * deletes a file with subversion, files will be marked for deletion and folders will be deleted
	 * @param	file	path to file that should be deleted.
	 */
	
	public void markForDelete(String file) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1323946227184_845066_2739) ENABLED START */
		try {
			File path = new File(file);
			if (path.isDirectory()) {
				// doDelete(the file, force deletion, delete also on filesystem,
				// only to test);
				wcClient.doDelete(path, true, true, false);
			} else {
				// doDelete(the file, force deletion, delete also on filesystem,
				// only to test);
				wcClient.doDelete(path, true, false, false);
			}
		} catch (SVNException e) {
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * The name that will be printed on the log
	 * @return	"Subversion"
	 */
	public String toString() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1323946227185_65603_2740) ENABLED START */
		return "Subversion";
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>metadataFolderName</b></em>'
	 */
	public String getMetadataFolderName() {
		return metadataFolderName;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1323946227166_577883_2730) ENABLED START */
	//	static {
	//		RegisterHelper.addRepositoryImpl(new SubversionImpl());
	//	}
	/* PROTECTED REGION END */
	
}
