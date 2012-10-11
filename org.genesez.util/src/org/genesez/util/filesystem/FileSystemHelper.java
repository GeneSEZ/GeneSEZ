package org.genesez.util.filesystem;


/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324544960704_472801_1972) 
 */

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This helper class contains methods that operate on files, directories, or other types of files.
 * 
 * @author	Nico Herbig <nico.herbig@fh-zwickau.de> (maintainer)
 */
public class FileSystemHelper {
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Creates a new directory with the specified directory name.
	 * The {@link #createDirectories(String)} script should be used where it is required to create all nonexistent parent directories first.
	 * 
	 * @param	directoryName	The directory to create.
	 * @return	True if the directory could be created or already exists, otherwise false.
	 */
	public static boolean createDirectory(String directoryName) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324545009733_326318_2002) ENABLED START */
		Path directory = Paths.get(directoryName);
		if (Files.notExists(directory)) {
			try {
				Files.createDirectory(directory);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Creates a new directory with the specified directory name by creating all nonexistent parent directories first.
	 *
	 * @param	directoryName	The directory to create.
	 * @return	True if the directory could be created along with all parent directories or already exists, otherwise false.
	 */
	public static boolean createDirectories(String directoryName) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324545416605_447454_2019) ENABLED START */
		Path directory = Paths.get(directoryName);
		if (Files.notExists(directory)) {
			try {
				Files.createDirectories(directory);
			} catch (Exception e) {
				return false;
			}
		}
		return true;
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324544960704_472801_1972) ENABLED START */
	/* PROTECTED REGION END */
	
}
