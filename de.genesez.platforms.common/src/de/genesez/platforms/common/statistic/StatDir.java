package de.genesez.platforms.common.statistic;

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

/**
 * A representation of a directory attached with a {@link StatisticsSet}.
 * Needed to project the folder hierarchy into the internal memory.
 * @author Dominik Wetzel 
 * @date 2011-11-15
 */
public class StatDir extends StatFile {
	private List<StatFile> files = new LinkedList<StatFile>();
	private boolean sorted = false;

	/**
	 * Constructs a statDir
	 * @see StatFile
	 * @param statSet the statistic set of the directory
	 * @param file the corresponding path to a folder
	 */
	public StatDir(StatisticsSet statSet, Path file) {
		super(statSet, file);
	}

	/**
	 * Gets all files that are stored in this directory
	 * @return all files in this directory sorted by kind and name
	 */
	@Override
	public List<StatFile> getFiles() {
		if (!sorted) {
			Collections.sort(files);
			sorted = true;
		}
		return files;
	}

	/**
	 * adds a {@link StatFile} to the folder
	 * @param file the StatFile to add
	 */
	public void addFile(StatFile file) {
		files.add(file);
		statSet.incStats(file.getStatSet());
	}
	
	/**
	 * Looks if this directory contains only one directory
	 * @return true if it contains only one directory and nothing else.
	 */
	@Override
	public boolean containsOnly1Dir(){
		if(files.size() == 1 && files.get(0).isDirectory()){
			return true;
		}
		return false;
	}

	/**
	 * Says if its a directory
	 * @return true
	 */
	@Override
	public boolean isDirectory() {
		return true;
	}

	/**
	 * Its {@link StatisticsSet} and its containing files will be printed.
	 * @see StatFile#toString()
	 * @return StatisticSet + Contains: [the containing files]
	 */
	@Override
	public String toString() {
		return super.toString() + "Contains:\n" + files.toString() + "\n";
	}
}
