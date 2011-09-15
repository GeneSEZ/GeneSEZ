package de.genesez.platforms.common.revisioncontrol;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
	private List<String> metadataFolderName = new ArrayList<String>(1);;
	private SVNClientManager manager = SVNClientManager.newInstance();
	private SVNWCClient wcClient = manager.getWCClient();

	/**
	 * Creates a SubversionSystem
	 */
	public SubversionImpl(){	
		metadataFolderName.add(".svn");
	}
	
	/**
	 * deletes a file in a subversive manner, if its not in repository it will deleted normal
	 * @param file path to file that should be deleted.
	 */
	public void delete(String file) {
		try {
			// doDelete(the file, force deletion, delete also on filesystem, only to test);
			wcClient.doDelete(new File(file), true, true, false);
		} catch (SVNException e) {
			try {
				Files.delete(Paths.get(file));
			} catch (IOException e1) {
				System.err.println(file.toString() + " couldn't be deleted. Maybe access denied.");
			}
		}	
	}
	
	/**
	 * gives a list with the repository metadata-folder-name usually this should
	 * contain only 1 entry.
	 * 
	 * @return a List with the metadata-folder-name
	 */
	public List<String> getMetadataFolderNames(){
		return metadataFolderName;
	}
	
	/**
	 * The name that will be printed on the log
	 * 
	 * @return "Subversion"
	 */
	public String getName(){
		return "Subversion";
	}
	
}
