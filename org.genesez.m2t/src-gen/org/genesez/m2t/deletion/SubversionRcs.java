package org.genesez.m2t.deletion;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_bP3SQAS9EeKUpcpqfZ9tsA) 
 */
import java.io.File;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNWCClient;

/**
 * Implementation of the delete algorithm for SVN.
 * 
 * @author Dominik Wetzel
 * @date 2011-09-15
 */
public class SubversionRcs implements RevisionControlSystem {
	
	private String metadataFolderName = ".svn";
	
	private SVNClientManager manager = SVNClientManager.newInstance();
	
	private SVNWCClient wcClient = manager.getWCClient();
	
	/**
	 * gives the metadata foldername of the currently checked RCS.
	 * @return	the metadata folder name
	 */
	public String getMetadataFolderName() {
		/* PROTECTED REGION ID(java.implementation._bP3SQAS9EeKUpcpqfZ9tsA__qUp80gQdEeK-ufRtI9UaTA) ENABLED START */
		return metadataFolderName;
		/* PROTECTED REGION END */
	}
	
	/**
	 * a callback from the DeletionFeature to set the Path of the metadata folder
	 * @param	name	the directory where the metadata folder was found
	 */
	public void setRepositoryRoot(String name) {
		/* PROTECTED REGION ID(java.implementation._bP3SQAS9EeKUpcpqfZ9tsA__qUp81gQdEeK-ufRtI9UaTA) ENABLED START */
		/* PROTECTED REGION END */
	}
	
	/**
	 * deletes a file with the given path String
	 * @param	file	the file, that should be deleted
	 */
	public void markForDelete(String file) {
		/* PROTECTED REGION ID(java.implementation._bP3SQAS9EeKUpcpqfZ9tsA__qUp82gQdEeK-ufRtI9UaTA) ENABLED START */
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
	 * @return	name of the RCS
	 */
	public String toString() {
		/* PROTECTED REGION ID(java.implementation._bP3SQAS9EeKUpcpqfZ9tsA__qUp83gQdEeK-ufRtI9UaTA) ENABLED START */
		return "Subversion";
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._bP3SQAS9EeKUpcpqfZ9tsA) ENABLED START */
	/* PROTECTED REGION END */
	
}
