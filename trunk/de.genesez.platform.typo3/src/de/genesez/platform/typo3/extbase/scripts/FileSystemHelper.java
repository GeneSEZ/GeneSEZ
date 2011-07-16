package de.genesez.platform.typo3.extbase.scripts;

import java.io.File;

/**
 * Helper class to create file system elements  
 * 
 * @author nicher
 *
 */
public class FileSystemHelper {

	/**
	 * Creates the directory named by this abstract directory name.
	 * 
	 * @param directoryName
	 *            the directory name
	 * @return true if and only if the directory was created, otherwise false
	 */
	public static boolean createDirectory(String directoryName) {
		boolean retVal = false;
		File directory = new File(directoryName);

		// checks if file (directory) not exists
		if (!directory.exists()) {
			// no there is no file or directory which exists.
			// Try to create directory
			if (directory.mkdir())
				retVal = true;
		}
		return retVal;
	}

	/**
	 * Creates the directory named by this abstract path name, including any
	 * necessary but nonexistent parent directories.
	 * 
	 * @param pathName
	 *            the path name
	 * @return true if and only if the directory was created, along with all
	 *         necessary parent directories, otherwise false
	 */
	public static boolean createDirectoryPath(String pathName) {
		boolean retVal = false;
		File directory = new File(pathName);

		// checks if file (directory) not exists
		if (!directory.exists()) {
			// no there is no file or directory which exists.
			// Try to create directory
			if (directory.mkdirs())
				retVal = true;
		}
		return retVal;
	}

}
