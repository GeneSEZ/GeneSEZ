package de.genesez.platforms.common.revisioncontrol;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.wc.SVNWCClient;
import org.tmatesoft.svn.core.wc.SVNClientManager;


/**
 * Implementation for RevisionControlSystem interface for deletion of files with SVN
 * @author Dominik Wetzel
 * @date 2011-09-14
 *
 */
public class SubversionSystem implements RevisionControlSystem {
	private SVNClientManager manager = SVNClientManager.newInstance();
	private SVNWCClient wcClient = manager.getWCClient();
	
	/**
	 * Creates a SubversionSystem
	 */
	public SubversionSystem(){		
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
				System.out.println(file.toString());
				e.printStackTrace();
				e1.printStackTrace();
			}
		}	
	}
}
