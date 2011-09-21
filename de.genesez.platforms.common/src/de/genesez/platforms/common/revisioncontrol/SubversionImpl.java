package de.genesez.platforms.common.revisioncontrol;

import java.io.File;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.wc.SVNWCClient;
import org.tmatesoft.svn.core.wc.SVNClientManager;

/**
 * Implementation of the delete algorithm for SVN.
 * 
 * @author Dominik Wetzel
 * @date 2011-09-15
 */
public class SubversionImpl implements RevisionControlSystem {
	private String metadataFolderName = ".svn";
	private SVNClientManager manager = SVNClientManager.newInstance();
	private SVNWCClient wcClient = manager.getWCClient();

	/**
	 * Creates a SubversionSystem
	 */
	public SubversionImpl() {
	}

	/**
	 * deletes a file with subversion, files will be marked for deletion and
	 * folders will be deleted
	 * 
	 * @param file
	 *            path to file that should be deleted.
	 */
	public void markForDelete(String file) {
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
	}

	/**
	 * gives a list with the repository metadata-folder-name usually this should
	 * contain only 1 entry.
	 * 
	 * @return a List with the metadata-folder-name
	 */
	public String getMetadataFolderName() {
		return metadataFolderName;
	}

	/**
	 * A callback from Deletor Module. Currently not needed.
	 */
	public void setRepositoryRoot(String root) {
	}

	/**
	 * The name that will be printed on the log
	 * 
	 * @return "Subversion"
	 */
	@Override
	public String toString() {
		return "Subversion";
	}
}
