package org.genesez.platform.common;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324544960704_472801_1972) 
 */

import java.io.File;
/**
 * Helper class to create file system elements 
 * 
 * @author nicher
 */
public class FileSystemHelper {
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Creates the directory named by this abstract directory name.
	 * @param	directoryName	the directory name
	 * @return	true if and only if the directory was created, otherwise false
	 */
	public static boolean createDirectory(String directoryName) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324545009733_326318_2002) ENABLED START */
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
		/* PROTECTED REGION END */
	}
	
	/**
	 * Creates the directory named by this abstract path name, including any necessary but nonexistent parent directories.
	 * @param	pathName	the path name
	 * @return	true if and only if the directory was created, along with all necessary parent directories, otherwise false
	 */
	public static boolean createDirectoryPath(String pathName) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324545416605_447454_2019) ENABLED START */
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
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324544960704_472801_1972) ENABLED START */
	/* PROTECTED REGION END */
	
}
