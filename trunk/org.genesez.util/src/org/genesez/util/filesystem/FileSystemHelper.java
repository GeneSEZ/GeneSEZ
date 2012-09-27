package org.genesez.util.filesystem;


/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324544960704_472801_1972) 
 */

import java.util.Set;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFilePermissions;
import java.io.File;
import java.nio.file.attribute.PosixFilePermission;

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
	
	/**
	 * Changes the file permissions for POSIX or DOS Systems to rwx------ or !readOnly
	 * 
	 * @throws IOException if IO-Error occurs.
	 * @param	file	the path, where permissions will be changed.
	 * @return	true if successful false if FileSystem is not supported.
	 * @throws	IOException
	 */
	public static boolean alterPermission(Path file) throws IOException {
		/* PROTECTED REGION ID(java.implementation._17_0_1_2200121_1331731263199_738182_1751) ENABLED START */
		PosixFileAttributeView POSIXattr = Files.getFileAttributeView(file, PosixFileAttributeView.class);
		// checks if its a POSIX System
		if (POSIXattr != null) {
			Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rwx------");
			// sets file permissions
			Files.setPosixFilePermissions(file, perms);
			return true;
			
		} else {
			// try if its a DOS-like System
			try {
				DosFileAttributeView DOSattr = Files.getFileAttributeView(file, DosFileAttributeView.class);
				// sets file permission
				DOSattr.setReadOnly(false);
				return true;
			} catch (UnsupportedOperationException e) {
				e.getMessage();
				return false;
			}
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324544960704_472801_1972) ENABLED START */
	/* PROTECTED REGION END */
	
}
