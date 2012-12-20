package org.genesez.platform.common.statistic;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1321001342783_185965_2437) 
 */

import java.nio.file.Path;
import java.util.Collections;

/**
 * A directory that contains the accumulated stats in its {@link StatisticsSet} of all its subfolders and files. Needed to project the folder hierarchy into the internal memory.
 * 
 * @author Dominik Wetzel
 * @date 2011-11-15
 * @deprecated
 */
public class StatDir extends StatFile {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** Stores associated objects of association FILES to StatFile */
	private java.util.List<StatFile> files = new java.util.ArrayList<StatFile>();
	
	private boolean sorted = false;
	
	// -- generated constructors --------------------------------------------
	/**
	 * The constructor
	 * @see StatFile#StatFile(StatisticSet,Path)
	 * @param	statSet	the corresponding StatisticSet
	 * @param	file	the corresponding real file
	 */
	public StatDir(StatisticsSet statSet, Path file) {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1321011953434_307168_4183) ENABLED START */
		super(statSet, file);
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * The string representation of the StatDir
	 * @return	The path to the directory and its StatisticSet + the string representation of the containing files
	 */
	public String toString() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321012816613_782973_4231) ENABLED START */
		return super.toString() + "Contains:\n" + files.toString() + "\n";
		/* PROTECTED REGION END */
	}
	
	/**
	 * gets all subfiles and subdirectories of this directory.
	 * @return	the sorted subfiles.
	 */
	public java.util.List<StatFile> getFiles() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321012259412_549956_4200) ENABLED START */
		if (!sorted) {
			Collections.sort(files);
			sorted = true;
		}
		return files;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Adds a file to the files list and adds the stats of it to this object's StatisticSet.
	 * @param	file	the file to be added.
	 */
	
	public void addFile(StatFile file) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321012426405_649576_4207) ENABLED START */
		files.add(file);
		statSet.incStats(file.getStatSet());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Whether its a directory or not
	 * @return	true, a StatDir is always a directory
	 */
	public boolean isDirectory() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321012683645_145796_4216) ENABLED START */
		return true;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Checks if the directory contains only 1 subfolder
	 * @return	true if it contains only 1 subfolder.
	 */
	public boolean containsOnly1Dir() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321012738933_316402_4224) ENABLED START */
		if (files.size() == 1 && files.get(0).isDirectory()) {
			return true;
		}
		return false;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1321001342783_185965_2437) ENABLED START */
	/* PROTECTED REGION END */
	
}
