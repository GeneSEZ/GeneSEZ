package de.genesez.platforms.common.statistic;

import java.text.DateFormat;
import java.util.GregorianCalendar;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Represents the frontend and the project of which the statistics should be calculated.
 * 
 * @author tommy hartmann ( tomha@fh-zwickau.de )
 * @author toh
 */
public class SProject {
	
	/** source folders included in the statistics */
	private Set<SDirectory> sourceFolders = new LinkedHashSet<SDirectory>();
	
	/** storage for the statistics */
	private StatisticSet statSet = new StatisticSet();
	
	/** the name of the statistic project */
	private String name;
	private boolean withDate;
	private String excludes;
	
	
	/**
	 * Constructs a new statistic project
	 * @param name		the name of the application project
	 * @param withDate	true if the statistic file name should contain the current date, otherwise false
	 */
	public SProject(String name, boolean withDate) {
		this.name = name;
		this.withDate = withDate;
	}
	
	/**
	 * calculates the statistic of the project
	 */
	public void calculate() {
		for (SDirectory dir : sourceFolders) {
			dir.parseCode();
			statSet.incStats(dir.getStatSet());
		}
	}
	
	/**
	 * calculates the statistic of the project including the given source folders
	 * @param generatedSourceFolders	source folders with generated source code
	 * @param manualSourceFolders		source folders with manually written source code (only)
	 */
	public void calculate(Set<String> generatedSourceFolders, Set<String> manualSourceFolders) {
		addGeneratedSourceFolders(generatedSourceFolders);
		addManualSourceFolders(manualSourceFolders);
		calculate();
	}
	
	/**
	 * Adds a source folder with generated source code
	 * @param directory		a source folder with generated source code
	 */
	public void addGeneratedSourceFolder(String directory) {
		this.sourceFolders.add(new SDirectory(directory, true, excludes));
	}
	
	/**
	 * Adds a source folder with manually written source code (only)
	 * @param directory		a source folder with manually written source code
	 */
	public void addManualSourceFolder(String directory) {
		this.sourceFolders.add(new SDirectory(directory, false, excludes));
	}
	
	/**
	 * Adds source folders with generated source code
	 * @param directories	source folders with generated source code
	 */
	public void addGeneratedSourceFolders(Set<String> directories) {
		for (String dir : directories) {
			addGeneratedSourceFolder(dir);
		}
	}
	
	/**
	 * Adds source folders with manually written source code (only)
	 * @param directories	source folders with manually written source code
	 */
	public void addManualSourceFolders(Set<String> directories) {
		for (String dir : directories) {
			addManualSourceFolder(dir);
		}
	}
	
	/**
	 * Sets the file names to exclude
	 * @param excludes	file names to exclude
	 */
	public void setExcludes(String excludes) {
		this.excludes = excludes;
	}
	
	/**
	 * Returns all source folders
	 * @return	all source folders
	 */
	public Set<SDirectory> getSourceFolders() {
		return sourceFolders;
	}
	
	/**
	 * Returns the statistics
	 * @return	statistics of the project
	 */
	public StatisticSet getStatSet() {
		return statSet;
	}
	
	/** 
	 * Returns the current date and time
	 * @return	current date and time
	 */
	public String getDateTime()
	{
		String date;
		
		GregorianCalendar now=new GregorianCalendar();
		DateFormat df=DateFormat.getDateInstance(DateFormat.MEDIUM);
		date = df.format(now.getTime());
		df=DateFormat.getTimeInstance(DateFormat.SHORT);
		date += " ("+df.format(now.getTime())+")";
		
		return date;
	}
	
	/**
	 * Returns the file name of the statistic file
	 * @return	the file name of the statistic file
	 */
	public String getFilename() {
		StringBuffer filename = new StringBuffer(name);
		if (withDate == true) {
			GregorianCalendar now = new GregorianCalendar();
			DateFormat date = DateFormat.getDateInstance(DateFormat.SHORT);
			if (filename.length() > 0) {
				filename.append("_");
			}
			filename.append(date.format(now.getTime()).replace(".", "-"));
		}
		return filename.toString();
	}
	
	/**
	 * Returns the name of the statistic project
	 * @return	name of the statistic project
	 */
	public String getName() {
		return name;
	}
}
