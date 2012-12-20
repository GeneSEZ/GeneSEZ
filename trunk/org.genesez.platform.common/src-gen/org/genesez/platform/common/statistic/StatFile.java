package org.genesez.platform.common.statistic;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1321004204827_726994_3291) 
 */

import java.nio.file.Path;

/**
 * A simple representation of a file, with an attached {@link StatisticsSet}.
 * Needed to project the file hierarchy into the internal memory.
 *  
 * @author Dominik Wetzel
 * @date 2011-11-15
 * @deprecated
 */
public class StatFile implements Comparable<StatFile> {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** Stores the associated object of association STATSET to StatisticsSet */
	protected StatisticsSet statSet;
	
	/**
	 * The path to a real file on the file system, for which the statistics are stored.
	 */
	protected Path path;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor, sets the corresponding statisticSet and the file.
	 * @param	statSet	the StatisticSet that contains the stats.
	 * @param	file	that real file that is corresponding to the object.
	 */
	public StatFile(StatisticsSet statSet, Path file) {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1321009201629_548789_4073) ENABLED START */
		this.statSet = statSet;
		this.path = file;
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Gets the corresponding subfiles.
	 * @return	null - file does not contain any other files
	 */
	public java.util.List<StatFile> getFiles() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321008786549_318534_4026) ENABLED START */
		return null;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Indicates whether its a directory or not.
	 * @return	false a file is not a directory
	 */
	public boolean isDirectory() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321009345366_696033_4088) ENABLED START */
		return false;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Checks whether the object contains only one subdirectory
	 * @return	false, a file contains no directories.
	 */
	public boolean containsOnly1Dir() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321009425629_972029_4096) ENABLED START */
		return false;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Relativizes the path of the object to the given path.
	 * @param	path	the path on which it will be relativized
	 * @return	the relativized path
	 */
	public Path relativize(Path path) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321009541062_598877_4104) ENABLED START */
		return path.relativize(this.path);
		/* PROTECTED REGION END */
	}
	
	/**
	 * gets the name (not the complete path) of the corresponding file
	 * @return	the filename
	 */
	public String getFileName() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321011173293_689800_4118) ENABLED START */
		return path.getFileName().toString();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Needed to sort the files. If this is a directory it is greater than the other file. If they are the same, than it will be checked lexicographically.
	 * @param	o	the file to which its compared to.
	 * @return	
	 */
	public int compareTo(StatFile o) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321011264461_544371_4126) ENABLED START */
		if (this.isDirectory() && !o.isDirectory())
			return 1;
		else if (!this.isDirectory() && o.isDirectory())
			return -1;
		else
			return (this.getFileName().compareTo(o.getFileName()));
		/* PROTECTED REGION END */
	}
	
	/**
	 * The string representation of this object.
	 * @return	string representation of the corresponding path and the corresponding StatisticSet.
	 */
	public String toString() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321011687652_88059_4133) ENABLED START */
		return path.toString() + ": " + statSet.toString();
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * The path to a real file on the file system, for which the statistics are stored.
	 */
	public Path getPath() {
		return path;
	}
	
	/**
	 * accessor for association to statSet
	 */
	public StatisticsSet getStatSet() {
		return statSet;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1321004204827_726994_3291) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
