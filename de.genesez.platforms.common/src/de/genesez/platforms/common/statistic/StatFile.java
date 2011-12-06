package de.genesez.platforms.common.statistic;

import java.nio.file.Path;
import java.util.List;

/**
 * A simple representation of a file, with an attached {@link StatisticsSet}.
 * Needed to project the file hierarchy into the internal memory.
 * 
 * @author Dominik Wetzel
 * @date 2011-11-15
 */
public class StatFile implements Comparable<StatFile> {
	protected StatisticsSet statSet = null;
	protected Path file = null;

	/**
	 * Constructs a StatFile
	 * 
	 * @param statSet
	 *            the StatisticSet
	 * @param file
	 *            the corresponding path to a file
	 */
	public StatFile(StatisticsSet statSet, Path file) {
		this.statSet = statSet;
		this.file = file;
	}

	/**
	 * Gets the contained files.
	 * 
	 * @return null - a file does not contain any other files
	 */
	public List<StatFile> getFiles() {
		return null;
	}

	/**
	 * Gets its {@link StatisticsSet}
	 * 
	 * @return the StatisticsSet
	 */
	public StatisticsSet getStatSet() {
		return statSet;
	}

	/**
	 * Gets the corresponding path
	 * 
	 * @return the path
	 */
	public Path getPath() {
		return file;
	}

	/**
	 * Says if its a directory.
	 * 
	 * @return false
	 */
	public boolean isDirectory() {
		return false;
	}

	/**
	 * Says if its contains only one directory
	 * 
	 * @return false - a file doesn't contain any directory (nor other files)
	 */
	public boolean containsOnly1Dir() {
		return false;
	}

	/**
	 * Relativizes its file path to the given path
	 * 
	 * @param path
	 *            the path on which it will be relativized
	 * @return the relativized path
	 */
	public Path relativize(Path path) {
		return path.relativize(file);
	}

	/**
	 * Gets the name of the file
	 * 
	 * @return the last element of the path (name of the file)
	 */
	public String getFileName() {
		return file.getFileName().toString();
	}

	/**
	 * String representation for the file
	 * 
	 * @return complete Path: + {@link StatisticsSet#toString()}
	 */
	@Override
	public String toString() {
		return file.toString() + ": " + statSet.toString();
	}

	/**
	 * Compares the file to another file. Needed to sort files in the folders.
	 * 
	 * @param o
	 *            a other StatFile to compare to
	 * @return 1 if this is a directory and o not, if its vice versa -1, and if
	 *         same see {@link String#compareTo(String)}
	 */
	@Override
	public int compareTo(StatFile o) {
		if (this.isDirectory() && !o.isDirectory())
			return 1;
		else if (!this.isDirectory() && o.isDirectory())
			return -1;
		else
			return (this.getFileName().compareTo(o.getFileName()));
	}
}
