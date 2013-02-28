package de.genesez.core.project;

import java.io.File;

public class ProjectHelper {

	/**
	 * Create a directory recursive
	 * @param name	The name of the directory to create
	 */
	public static void createDirectory(String name) {
		(new File(name)).mkdirs();		
	}
}
