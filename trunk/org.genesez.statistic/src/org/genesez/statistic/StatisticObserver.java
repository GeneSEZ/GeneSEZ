package org.genesez.statistic;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1320142576629_198275_2371) 
 */

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.IOException;
import org.apache.commons.logging.LogFactory;
import java.nio.file.Paths;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.genesez.m2t.FileTreeObserverAdapter;

import java.nio.charset.Charset;
import java.util.Properties;
import java.util.regex.Pattern;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.File;

/**
 * It observes a FileTreeWalkerFeature and counts the lines of every file (thats not excluded) into following categories:
 * <p>
 * - generated code lines<br>
 * - generated documentation lines<br>
 * - generated comment lines<br>
 * - generated protected region lines<br>
 * - implemented code lines<br>
 * - implemented documentation lines<br>
 * - implemented comment lines
 * </p>
 * 
 * @author Dominik Wetzel
 * @date 2011-11-10
 */
public class StatisticObserver extends FileTreeObserverAdapter {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** Stores the associated object of association ROOTDIR to StatDir */
	private StatDir rootDir;
	
	private static Properties defaults = new Properties();
	
	private static final Pattern PRO_REG_BEGIN = Pattern.compile(".*(PROTECTED REGION) ID(.*).*START.*");
	
	private static final Pattern PRO_REG_END = Pattern.compile(".*(PROTECTED REGION) END.*");
	
	/**
	 * Log instance for this class
	 */
	protected Log logger = LogFactory.getLog(getClass());
	
	private String singleLineCommentString = "//";
	
	private String docuCommentStartString = "/**";
	
	private String multiLineCommentStartString = "/*";
	
	private String multiLineCommentEndString = "*/";
	
	private boolean prepared = false;
	
	private Map<Path, StatFile> statFiles = new LinkedHashMap<Path, StatFile>();
	
	private java.util.Set<Path> gens = new java.util.HashSet<Path>();
	
	private java.util.Set<String> generated = new java.util.HashSet<String>();
	
	private java.util.Set<Path> mans = new java.util.HashSet<Path>();
	
	private java.util.Set<String> manual = new java.util.HashSet<String>();
	
	private java.util.Set<String> excludes = new java.util.HashSet<String>();
	
	private Properties properties = new Properties();
	
	private Path searchedDir;
	
	private boolean withDetails = false;
	
	private String statisticName;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor, sets the default properties
	 */
	public StatisticObserver() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1321001865961_163134_2715) ENABLED START */
		super();
		properties.putAll(defaults);
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Sets the properties from the FileTreeWalkerFeature. Resolves generatedDirs and excludes to "searchedDir". If no own excludes and generatedDirs set, defaults will be used.
	 * @param	properties	properties that should be used.
	 */
	
	public void setFileTreeWalkerProperties(Properties properties) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321003427681_414689_2777) ENABLED START */
		String check = properties.getProperty("searchedDir", "");
		if (check.isEmpty()) {
			logger.error("No searchedDir given, maybe FileTreeWalkerFeature is not configured correctly. Statistic should fail.");
		}
		searchedDir = Paths.get(check);
		if (excludes.isEmpty()) {
			excludes.addAll(split(this.properties.getProperty("excludes")));
		}
		if (generated.isEmpty()) {
			generated.addAll(split(this.properties.getProperty("genDirs")));
		}
		for (String s : manual) {
			mans.add(searchedDir.resolve(s).toAbsolutePath().normalize());
		}
		for (String s : generated) {
			try {
				gens.add(searchedDir.resolve(s).toRealPath());
			} catch (IOException e) {
				logger.warn("generated directory " + s + " does not exist.");
			}
		}
		generated.clear();
		manual.clear();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Reads the file and counts the lines.
	 * @param	file	the file to read
	 * @param	generated	true, if its a generated file
	 */
	
	private void readFile(Path file, boolean generated) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321366528466_318361_4238) ENABLED START */
		StatFile statFile = new StatFile(new StatisticsSet(), file);
		try {
			BufferedReader bf = Files.newBufferedReader(file, Charset.defaultCharset());
			String line = null;
			while ((line = bf.readLine()) != null) {
				countLine(line.trim(), bf, generated, statFile.getStatSet());
			}
			bf.close();
		} catch (IOException e) {
			logger.warn("Could not read file: " + file);
		}
		statFiles.put(file, statFile);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Counts the line within the different groups:
	 * <p>
	 * genComment/ownComment: comments<br>
	 * genDocu/ownDocu: documentation<br>
	 * genCode/ownCode: the usable code<br>
	 * protectedRegions: protected region lines
	 * </p>
	 * @param	line	the line that should be checked and counted
	 * @param	bf	the BufferedReader that contains the whole file.
	 * @param	generated	indicates whether its an generated or a not generated part. For example within protected regions there is a not generated part.
	 * @param	stats	the StatisticSet where the information will be stored.
	 */
	
	private void countLine(String line, BufferedReader bf, boolean generated, StatisticsSet stats) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1320142775057_254852_2487) ENABLED START */
		if (line.isEmpty()) {
			return;
		}
		
		if (line.startsWith(singleLineCommentString)) {
			stats.incComment(generated);
			return;
		}
		
		if (docuCommentStartString != null) {
			if (line.startsWith(docuCommentStartString) && !line.endsWith(multiLineCommentEndString)) {
				int lines = countMultiCommentLines(bf);
				stats.incDocu(lines, generated);
				return;
			}
			stats.incDocu(generated);
		}
		
		if (line.startsWith(multiLineCommentStartString)) {
			if (generated && PRO_REG_BEGIN.matcher(line).matches()) {
				stats.incProtReg(2);
				try {
					while (!PRO_REG_END.matcher(line = bf.readLine().trim()).matches()) {
						countLine(line, bf, false, stats);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			}
			
			if (!line.endsWith(multiLineCommentEndString)) {
				int lines = countMultiCommentLines(bf);
				stats.incComment(lines, generated);
			}
			stats.incComment(generated);
			return;
		}
		stats.incCode(generated);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Checks if a path is in a list.
	 * @param	listToCheck	The list with which it should be compared.
	 * @param	file	the file to check
	 * @return	true if the file is in the list
	 */
	private boolean isIn(java.util.Set<Path> listToCheck, Path file) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321366259290_727094_4216) ENABLED START */
		for (Path check : listToCheck) {
			if (file.toAbsolutePath().normalize().startsWith(check)) {
				return true;
			}
		}
		return false;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Checks whether a file is excluded. Therefore it looks if a exclude string is contained in the path or the file starts with the absolute exclude path.
	 * @param	file	the file/directory to check
	 * @return	true if the file is excluded
	 */
	private boolean isExcluded(Path file) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321001911857_273001_2718) ENABLED START */
		for (String excl : excludes) {
			Path ex = Paths.get(excl);
			if (ex.isAbsolute()) {
				if (file.toAbsolutePath().normalize().startsWith(ex)) {
					return true;
				}
			} else if (file.toString().matches(".*[\\\\|/]" + excl + "([\\\\|/].*)?$")) {
				return true;
			}
		}
		return false;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Count multiLine comment lines. Used for doc and normal multiLine comments.
	 * @param	bf	the BufferedReader that contains the opened file.
	 * @return	the count of lines until <em><b>multiLineCommentEndString</b></em>
	 */
	private int countMultiCommentLines(BufferedReader bf) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321003025003_634858_2763) ENABLED START */
		int lines = 1;
		try {
			while (!bf.readLine().trim().endsWith(multiLineCommentEndString)) {
				lines++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets the properties for default excludes with the directory where the files will be generated in.
	 * @param	properties	the properties that should be used.
	 */
	
	public void setProperties(Properties properties) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321002480433_613029_2731) ENABLED START */
		String excludes = this.properties.getProperty("excludes").concat(",");
		excludes = excludes.concat(Paths.get(properties.getProperty("outputDir")).toAbsolutePath().normalize().toString());
		this.properties.setProperty("excludes", excludes);
		this.withDetails = Boolean.parseBoolean(properties.getProperty("withDetails", "false"));
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets a generated file or directory. Will be resolved to the searchedDir from the {@link FileTreeWalkerFeature}. This file/directory will be checked for generated lines.
	 * @param	file	file or directory to add.
	 */
	
	public void setGenerate(String file) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321002560745_880894_2737) ENABLED START */
		generated.add(file);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets generated directories or files
	 * 
	 * @see #setGeneratedDir(String)
	 * @param	dirs	the files or directories separated by "," or ";".
	 */
	
	public void setGenerates(String dirs) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321002626184_879568_2743) ENABLED START */
		if (dirs.length() > 0) {
			List<String> list = split(dirs);
			for (String s : list) {
				setGenerate(s);
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets a excluded directory, will be resolved to the searchedDir from the {@link FileTreeWalkerFeature} This directory or file will not be checked.
	 * @param	exclude	dir or file that is excluded.
	 */
	
	public void setExclude(String exclude) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321002679601_355164_2749) ENABLED START */
		excludes.add(exclude);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets excluded directories
	 * 
	 * @see #setExclude(String)
	 * @param	excludes	the files or directories separated by "," or ";".
	 */
	
	public void setExcludes(String excludes) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321002776321_326682_2755) ENABLED START */
		if (excludes.length() > 0) {
			List<String> list = split(excludes);
			for (String s : list) {
				setExclude(s);
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets a manual implemented file or directory. Will be resolved to the searchedDir from the {@link FileTreeWalkerFeature}. This file/directory will not be checked for generated lines.
	 * @param	file	file or directory to add
	 */
	
	public void setManual(String file) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321366782314_620271_4251) ENABLED START */
		manual.add(file);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets manual files or directories
	 * 
	 * @see #setManual(String)
	 * @param	files	the files or directories separated by "," or ";"
	 */
	
	public void setManuals(String files) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321366840897_46807_4259) ENABLED START */
		if (files.length() > 0) {
			List<String> list = split(files);
			for (String s : list) {
				setManual(s);
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Called from {@link FileTreeWalkerFeature#visitFile(Path, java.nio.file.attribute.BasicFileAttributes)}. Reads the file and counts the lines within the groups. Creates an {@link StatFile} with an {@link StatisticSet} for the file.
	 * 
	 * @see #readFile(Path, boolean)
	 * @param	file	the file that should be read.
	 */
	
	public void updateFileVisit(Path file) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1320142742444_514663_2473) ENABLED START */
		if (!isExcluded(file)) {
			boolean generated = isIn(gens, file);
			if (generated || isIn(mans, file)) {
				readFile(file, generated);
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Called from {@link FileTreeWalkerFeature#postVisitDirectory(Path, IOException)} . Creates a new {@link StatDir} with a {@link StatisticSet} for the directory if its not excluded and adds all subfiles with its statistics to it.
	 * @param	dir	the directory
	 */
	
	public void updateAfterDir(Path dir) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321001784088_265750_2708) ENABLED START */
		if (!isExcluded(dir)) {
			StatDir statDir = new StatDir(new StatisticsSet(), dir);
			List<File> files = Arrays.asList(dir.toFile().listFiles());
			for (Path key : statFiles.keySet()) {
				if (files.contains(key.toFile())) {
					statDir.addFile(statFiles.get(key));
				}
			}
			if (!(statDir.getStatSet().getAllLines() == 0) || isIn(gens, dir) || isIn(mans, dir)) {
				statFiles.put(dir, statDir);
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Called if the {@link FileTreeWalkerFeature} walked the tree completely. Sets prepared to true and Logs the found information.
	 */
	
	public void updateComplete() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1320244326053_426627_2148) ENABLED START */
		prepared = true;
		rootDir = (StatDir) statFiles.get(searchedDir);
		logger.debug(getRootDir());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets the comment Strings in the order of
	 * <p>
	 * - {@link #setSingleLineCommentString<br>
	 * - {@link #setMultiLineCommentStartString}<br>
	 * - {@link #setMultiLineCommentEndString}<br>
	 * - {@link #setDocuCommentStartString}
	 * </p>
	 * @param	commentStrings	a string that contains all commentStrings separated by "," or ";".
	 */
	
	public void setCommentStrings(String commentStrings) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1320143362409_170016_2699) ENABLED START */
		List<String> list = split(commentStrings);
		int size = list.size();
		if (size > 4) {
			logger.warn("More than 4 comment Strings, only the first 4 will be used.");
		}
		try {
			setSingleLineCommentString(list.get(0));
			setMultiLineCommentStartString(list.get(1));
			setMultiLineCommentEndString(list.get(2));
		} catch (IndexOutOfBoundsException ex) {
			logger.warn("Less than 3 comment Strings. Statistic probably defective");
		}
		try {
			setDocuCommentStartString(list.get(3));
		} catch (IndexOutOfBoundsException ex) {
			docuCommentStartString = null;
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * String representation of the object
	 * @return	the file name of the '<em><b>rootDir</b></em>'
	 */
	public String toString() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321003359489_699361_2771) ENABLED START */
		if (statisticName != null) {
			return statisticName;
		}
		return rootDir.getFileName();
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Sets the value of attribute '<em><b>singleLineCommentString</b></em>'
	 */
	public void setSingleLineCommentString(String singleLineCommentString) {
		this.singleLineCommentString = singleLineCommentString;
	}
	
	/**
	 * Sets the value of attribute '<em><b>docuCommentStartString</b></em>'
	 */
	public void setDocuCommentStartString(String docuCommentStartString) {
		this.docuCommentStartString = docuCommentStartString;
	}
	
	/**
	 * Sets the value of attribute '<em><b>multiLineCommentStartString</b></em>'
	 */
	public void setMultiLineCommentStartString(String multiLineCommentStartString) {
		this.multiLineCommentStartString = multiLineCommentStartString;
	}
	
	/**
	 * Sets the value of attribute '<em><b>multiLineCommentEndString</b></em>'
	 */
	public void setMultiLineCommentEndString(String multiLineCommentEndString) {
		this.multiLineCommentEndString = multiLineCommentEndString;
	}
	
	/**
	 * Returns the value of attribute '<em><b>prepared</b></em>'
	 */
	public boolean getPrepared() {
		return prepared;
	}
	
	/**
	 * Sets the value of attribute '<em><b>searchedDir</b></em>'
	 */
	public void setSearchedDir(Path searchedDir) {
		this.searchedDir = searchedDir;
	}
	
	/**
	 * Returns the value of attribute '<em><b>withDetails</b></em>'
	 */
	public boolean getWithDetails() {
		return withDetails;
	}
	
	/**
	 * Sets the value of attribute '<em><b>withDetails</b></em>'
	 */
	public void setWithDetails(boolean withDetails) {
		this.withDetails = withDetails;
	}
	
	/**
	 * Sets the value of attribute '<em><b>statisticName</b></em>'
	 */
	public void setStatisticName(String statisticName) {
		this.statisticName = statisticName;
	}
	
	/**
	 * accessor for association to rootDir
	 */
	public StatDir getRootDir() {
		return rootDir;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1320142576629_198275_2371) ENABLED START */
	static {
		defaults.put("excludes", ".svn, .cvs, .hg, .git");
		defaults.put("genDirs", "src-gen");
	}
	
	/**
	 * Converts a comma or semicolon separated string into a list an trims the values.
	 * @param	str	A comma or semicolon separated string.
	 * @return	A list of strings.
	 */
	public static java.util.List<String> split(String str) {
		List<String> result = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(str, ",;");
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			result.add(token.trim());
		}
		return result;
	}
	
	/* PROTECTED REGION END */
	
}
