package de.genesez.platforms.common.revisioncontrol;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jgit.util.FileUtils;

/**
 * Implementation of the delete algorithm for Git.
 * 
 * @author Dominik Wetzel
 * @date 2011-09-15
 */
public class GitImpl implements RevisionControlSystem {
	List<String> metadataFolderName = new ArrayList<String>(1);

	/**
	 * creates a new Git implementation
	 */
	public GitImpl() {
		metadataFolderName.add(".git");
	}

	/**
	 * deletes a file with the given path String under Git
	 * @param file the file, that should be deleted
	 */
	public void delete(String file) {
		try {
			FileUtils.delete(new File(file), FileUtils.RETRY);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * gives a list with the repository metadata-folder-name usually this should
	 * contain only 1 entry.
	 * 
	 * @return a List with metadata-folder-name
	 */
	public List<String> getMetadataFolderNames() {
		return metadataFolderName;
	}

	/**
	 * The name that will be printed on the log
	 * 
	 * @return "Git"
	 */
	public String getName() {
		return "Git";
	}

}
