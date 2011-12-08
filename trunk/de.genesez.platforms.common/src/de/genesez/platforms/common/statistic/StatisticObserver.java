package de.genesez.platforms.common.statistic;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.genesez.platforms.common.FileTreeObserverAdapter;
import de.genesez.platforms.common.workflow.WorkflowUtils;
import de.genesez.platforms.common.workflow.feature.FileTreeWalkerFeature;

/**
 * It observes a FileTreeWalkerFeature and counts the lines of every file (thats
 * not excluded) into following categories:
 * <p>
 * - generated code lines<br>
 * - generated documentation lines<br>
 * - generated comment lines<br>
 * - generated protected region lines<br>
 * - implemented code lines<br>
 * - implemented documentation lines<br>
 * - implemented comment lines
 * </p>
 * on the {@link StatisticsSet} of a {@link StatFile} (or {@link StatDir}).
 * 
 * @author Dominik Wetzel
 * @date 2011-11-21
 */
public class StatisticObserver extends FileTreeObserverAdapter {

	/**
	 * the log instance for the class
	 */
	protected Log logger = LogFactory.getLog(getClass());

	private String singleLineCommentString = "//";

	private String docuCommentStartString = "/**";

	private String multiLineCommentStartString = "/*";

	private String multiLineCommentEndString = "*/";

	private final Pattern PRO_REG_BEGIN = Pattern
			.compile(".*PROTECTED REGION ID(.*).*START.*");

	private final Pattern PRO_REG_END = Pattern
			.compile(".*PROTECTED REGION END.*");

	// all lines
	private int allLines = 0;

	private static Properties defaults = new Properties();
	static {
		defaults.put("excludes", ".svn, .cvs, .hg, .git");
		defaults.put("genDirs", "src-gen");
	}

	private Properties properties = new Properties();

	private Map<Path, StatFile> statFiles = new LinkedHashMap<Path, StatFile>();
	private StatDir rootDir = null;

	private List<String> generated = new LinkedList<String>();
	private List<String> manual = new LinkedList<String>();

	private List<Path> gens = new LinkedList<Path>();
	private List<Path> mans = new LinkedList<Path>();

	private List<String> excludes = new LinkedList<String>();

	private Path searchedDir = null;

	private boolean prepared = false;

	private String statisticName = null;

	private boolean withDetails = false;

	/**
	 * Constructs a StatisticObserver, sets defaults
	 */
	public StatisticObserver() {
		super();
		properties.putAll(defaults);
	}

	/**
	 * Called from
	 * {@link FileTreeWalkerFeature#visitFile(Path, java.nio.file.attribute.BasicFileAttributes)}
	 * . Reads the file and counts the lines within the groups. Creates an
	 * {@link StatFile} with an {@link StatisticsSet} for the file.
	 * 
	 * @see #readFile(Path, boolean)
	 * 
	 * @param file
	 *            the file that should be read.
	 */
	@Override
	public void updateFileVisit(Path file) {
		if (!isExcluded(file)) {
			boolean generated = isIn(gens, file);
			if (generated || isIn(mans, file)) {
				readFile(file, generated);
			}
		}
	}

	/**
	 * Called from
	 * {@link FileTreeWalkerFeature#postVisitDirectory(Path, IOException)} .
	 * Creates a new {@link StatDir} with a {@link StatisticsSet} for the
	 * directory if its not excluded and adds all subfiles with its statistics
	 * to it.
	 * 
	 * @param dir
	 *            the directory
	 */
	@Override
	public void updateAfterDir(Path dir) {
		if (!isExcluded(dir)) {
			StatDir statDir = new StatDir(new StatisticsSet(), dir);
			List<File> files = Arrays.asList(dir.toFile().listFiles());
			for (Path key : statFiles.keySet()) {
				if (files.contains(key.toFile())) {
					statDir.addFile(statFiles.get(key));
				}
			}
			if (!(statDir.getStatSet().getAllLines() == 0) || isIn(gens, dir)
					|| isIn(mans, dir)) {
				statFiles.put(dir, statDir);
			}
		}
	}

	/**
	 * Called if the {@link FileTreeWalkerFeature} walked the tree completely.
	 * Sets prepared to true and Logs the found information.
	 */
	@Override
	public void updateComplete() {
		prepared = true;
		rootDir = (StatDir) statFiles.get(searchedDir);
		logger.debug(getRootDir());
	}

	/**
	 * Checks if a path is in a list
	 * 
	 * @param listToCheck
	 *            the list with which it should be compared
	 * @param file
	 *            the file to check
	 * 
	 * @return true if the file is in the list
	 */
	private boolean isIn(List<Path> listToCheck, Path file) {
		for (Path check : listToCheck) {
			if (file.toAbsolutePath().normalize().startsWith(check)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks whether a file is excluded. Therefore it looks if a string is
	 * contained in the path
	 * 
	 * @param file
	 *            file to check
	 * @return true if its excluded
	 */
	private boolean isExcluded(Path file) {
		for (String excl : excludes) {
			Path ex = Paths.get(excl);
			if (ex.isAbsolute()) {
				if (file.toAbsolutePath().normalize().startsWith(ex)) {
					return true;
				}
			} else if (file.toString().matches(
					".*[\\\\|/]" + excl + "([\\\\|/].*)?$")) {
				return true;
			}
		}
		return false;
	}

	/**
	 * reads a file and counts the lines
	 * 
	 * @param file
	 *            the file to read
	 * @param generated
	 *            true, if its a generated file
	 */
	private void readFile(Path file, boolean generated) {
		StatFile statFile = new StatFile(new StatisticsSet(), file);
		try {
			BufferedReader bf = Files.newBufferedReader(file,
					Charset.defaultCharset());
			String line = null;
			while ((line = bf.readLine()) != null) {
				countLine(line.trim(), bf, generated, statFile.getStatSet());
			}
			bf.close();
		} catch (IOException e) {
			logger.warn("Could not read file: " + file);
		}
		statFiles.put(file, statFile);
	}

	/**
	 * Sets the properties for default excludes with the directory where the
	 * files will be generated in.
	 * 
	 * @param properties
	 *            the properties that should be used.
	 */
	public void setProperties(Properties properties) {
		String excludes = this.properties.getProperty("excludes").concat(",");
		excludes = excludes.concat(Paths
				.get(properties.getProperty("outputDir")).toAbsolutePath()
				.normalize().toString());
		this.properties.setProperty("excludes", excludes);
		this.withDetails = Boolean.parseBoolean(properties.getProperty(
				"withDetails", "false"));
	}

	/**
	 * Sets a generated file or directory. Will be resolved to the searchedDir
	 * from the {@link FileTreeWalkerFeature}. This file/directory will be
	 * checked for generated lines.
	 * 
	 * @param file
	 *            file or directory to add.
	 */
	public void setGenerate(String file) {
		generated.add(file);
	}

	/**
	 * Sets generated files or directories
	 * 
	 * @see #setGenerate(String)
	 * @param files
	 *            the files or directories separated by "," or ";"
	 */
	public void setGenerates(String files) {
		if (files.length() > 0) {
			List<String> list = WorkflowUtils.split(files);
			for (String s : list) {
				setGenerate(s);
			}
		}
	}

	/**
	 * Sets a manual implemented file or directory. Will be resolved to the
	 * searchedDir from the {@link FileTreeWalkerFeature}. This file/directory
	 * will not be checked for generated lines.
	 * 
	 * @param file
	 *            file or directory to add
	 */
	public void setManual(String file) {
		manual.add(file);
	}

	/**
	 * Sets manual files or directories
	 * 
	 * @see #setManual(String)
	 * @param files
	 *            the files or directories separated by "," or ";"
	 */
	public void setManuals(String files) {
		if (files.length() > 0) {
			List<String> list = WorkflowUtils.split(files);
			for (String s : list) {
				setManual(s);
			}
		}
	}

	/**
	 * Sets a excluded directory, will be resolved to the searchedDir from the
	 * {@link FileTreeWalkerFeature} This directory will not be checked.
	 * 
	 * @param exclude
	 *            directory or file that is excluded.
	 */
	public void setExclude(String exclude) {
		excludes.add(exclude);
	}

	/**
	 * Sets excluded directories
	 * 
	 * @see #setExclude(String)
	 * @param dirs
	 *            the directories separated by "," or ";"
	 */
	public void setExcludes(String excludes) {
		if (excludes.length() > 0) {
			List<String> list = WorkflowUtils.split(excludes);
			for (String s : list) {
				setExclude(s);
			}
		}
	}

	/**
	 * Sets the name of the statistic
	 * 
	 * @param name
	 *            the name
	 */
	public void setStatisticName(String name) {
		this.statisticName = name;
	}

	/**
	 * Counts the line within the different groups:
	 * <p>
	 * genComment/ownComment: comments<br>
	 * genDocu/ownDocu: documentation<br>
	 * genCode/ownCode: the usable code<br>
	 * protectedRegions: protected region lines
	 * </p>
	 * 
	 * @param line
	 *            the line the should be checked and counted
	 * @param bf
	 *            the BufferedReader that contains the file
	 * @param generated
	 *            whether the line is generated or not
	 * @param stats
	 *            the StatisticSet that stores the information
	 */
	private void countLine(String line, BufferedReader bf, boolean generated,
			StatisticsSet stats) {

		if (line.isEmpty()) {
			return;
		}

		allLines++;

		if (line.startsWith(singleLineCommentString)) {
			stats.incComment(generated);
			return;
		}

		if (docuCommentStartString != null) {
			if (line.startsWith(docuCommentStartString)
					&& !line.endsWith(multiLineCommentEndString)) {
				int lines = countMultiCommentLines(bf);
				allLines += lines;
				stats.incDocu(lines, generated);
				return;
			}
			stats.incDocu(generated);
		}

		if (line.startsWith(multiLineCommentStartString)) {
			if (generated && PRO_REG_BEGIN.matcher(line).matches()) {
				stats.incProtReg(2);
				try {
					while (!PRO_REG_END.matcher(line = bf.readLine().trim())
							.matches()) {
						countLine(line, bf, false, stats);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				allLines++;
				return;
			}

			if (!line.endsWith(multiLineCommentEndString)) {
				int lines = countMultiCommentLines(bf);
				allLines += lines;
				stats.incComment(lines, generated);
			}
			stats.incComment(generated);
			return;
		}
		stats.incCode(generated);
	}

	/**
	 * Count multiLine comment lines. Used for doc and normal multiLine comments
	 * 
	 * @param bf
	 *            the BufferedReader that contains the opened file
	 * @return the count of lines until
	 *         <em><b>multiLineCommentEndString</b></em>
	 */
	private int countMultiCommentLines(BufferedReader bf) {
		int lines = 1;
		try {
			while (!bf.readLine().trim().endsWith(multiLineCommentEndString)) {
				lines++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	/**
	 * Sets the commentStrings in order of
	 * <p>
	 * singleLineComment<br>
	 * multiLineStartComment<br>
	 * multiLineEndComment<br>
	 * docStartComment
	 * </p>
	 * 
	 * @param commentStrings
	 *            a string that contains all commentStrings separated by "," or
	 *            ";".
	 */
	public void setCommentStrings(String commentStrings) {
		List<String> list = WorkflowUtils.split(commentStrings);
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
	}

	/**
	 * Sets the value of attribute '<em><b>singlielineCommentString</b></em>'
	 */
	public void setSingleLineCommentString(String singlielineCommentString) {
		this.singleLineCommentString = singlielineCommentString;
	}

	/**
	 * Sets the value of attribute '<em><b>multilineCommentStartString</b></em>'
	 */
	public void setMultiLineCommentStartString(
			String multilineCommentStartString) {
		this.multiLineCommentStartString = multilineCommentStartString;
	}

	/**
	 * Sets the value of attribute '<em><b>multiLineCommentEndString</b></em>'
	 */
	public void setMultiLineCommentEndString(String multiLineCommentEndString) {
		this.multiLineCommentEndString = multiLineCommentEndString;
	}

	/**
	 * Sets the value of attribute '<em><b>docuCommentStartString</b></em>'
	 */
	public void setDocuCommentStartString(String docuCommentStartString) {
		if (docuCommentStartString.equals("")) {
			this.docuCommentStartString = null;
		} else {
			this.docuCommentStartString = docuCommentStartString;
		}
	}

	/**
	 * Returns the value of attribute '<em><b>allLines</b></em>'
	 */
	public int getAllLines() {
		return allLines;
	}

	/**
	 * Returns the value of attribute '<em><b>rootDir</b></em>'
	 */
	public StatDir getRootDir() {
		return rootDir;
	}

	/**
	 * Returns the value of attribute '<em><b>prepared</b></em>'
	 */
	public boolean getPrepared() {
		return prepared;
	}

	/**
	 * @return the value of attribute '<em><b>withDetails</b></em>'
	 */
	public boolean getWithDetails() {
		return withDetails;
	}

	/**
	 * Sets the properties from the FileTreeWalkerFeature. Resolves
	 * generatedDirs and excludes to "searchedDir". If no own excludes and
	 * generatedDirs set, defaults will be used.
	 * 
	 * @param properties
	 *            properties that should be used.
	 */
	@Override
	public void setFileTreeProperties(Properties properties) {
		String check = properties.getProperty("searchedDir", "");
		if (check.isEmpty()) {
			logger.error("No searchedDir given, maybe FileTreeWalkerFeature is not configured correctly. Statistic should fail.");
		}
		searchedDir = Paths.get(check);
		if (excludes.isEmpty()) {
			excludes = WorkflowUtils.split(this.properties
					.getProperty("excludes"));
		}
		if (generated.isEmpty()) {
			generated = WorkflowUtils.split(this.properties
					.getProperty("genDirs"));
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
	}

	/**
	 * @return the file name of the '<em><b>rootDir</b></em>'.
	 */
	@Override
	public String toString() {
		if (statisticName != null) {
			return statisticName;
		}
		return rootDir.getFileName();
	}
}
