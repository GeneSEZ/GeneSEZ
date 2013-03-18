package org.genesez.statistic;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_Nx0r8IzJEeKLl_w7vhifuQ) 
 */
import org.genesez.m2t.FileTreeObserverAdapter;

import org.genesez.workflow.profile.WfDefault;
import org.genesez.workflow.profile.WfParameter;
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

/**
 * Counts the lines of every file thats not excluded and sums them up into the following categories:
 * - generated lines of source code
 * - manual implemented lines of source code
 * - lines of documentation
 * - lines of comments
 * - lines of protected regions (as a special kind of comment lines)
 */
public class LineCounter extends FileTreeObserverAdapter {
	
	public final Log logger = LogFactory.getLog(getClass());
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private boolean withFileDetails = false;
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String beginProtectedRegionRegExp = ".*(PROTECTED REGION) ID(.*).*START.*";
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String endProtectedRegionRegExp = ".*(PROTECTED REGION) END.*";
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String singleLineComment = "//";
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String multiLineStartComment = "/*";
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String documentationStartComment = "/**";
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String multiLineEndComment = "*/";
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String baseDir;
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private java.util.Set<String> relativeGeneratedDir = new java.util.LinkedHashSet<String>();
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private java.util.Set<String> relativeOwnImplDir = new java.util.LinkedHashSet<String>();
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private java.util.Set<String> excludedDir = new java.util.LinkedHashSet<String>();
	
	private StatDir rootDir;
	
	/**
	 * Method stub for further implementation.
	 */
	public boolean initialize() {
		/* PROTECTED REGION ID(java.implementation._x-EoMI14EeKY9prllV7Cvw) ENABLED START */
		boolean result = true;
		// init reg exp pattern
		try {
			beginProtectedRegionRegExpPattern = Pattern.compile(beginProtectedRegionRegExp);
		} catch (PatternSyntaxException pse) {
			logger.error("Invalid regular expression for protected region begin: ", pse);
			result = false;
		}
		try {
			endProtectedRegionRegExpPattern = Pattern.compile(endProtectedRegionRegExp);
		} catch (PatternSyntaxException pse) {
			logger.error("Invalid regular expression for protected region end: ", pse);
			result = false;
		}
		// init base path
		if (baseDir == null || baseDir.isEmpty()) {
			logger.error("Property 'baseDir' not specified");
			result = false;
		} else {
			basePath = Paths.get(baseDir);
		}
		// init own impl + generated dirs
		for (String s : relativeOwnImplDir) {
			Path p = basePath.resolve(s).toAbsolutePath().normalize();
			ownImplDir.add(p);
		}
		for (String s : relativeGeneratedDir) {
			Path p = basePath.resolve(s).toAbsolutePath().normalize();
			generatedDir.add(p);
		}
		
		return result;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Reads the specified file and counts the lines.
	 */
	public void readFile(Path file, boolean isGenerated) {
		/* PROTECTED REGION ID(java.implementation._Y8qXAI1pEeKY9prllV7Cvw) ENABLED START */
		StatFile statFile = new StatFile(new StatisticsSet(), file);
		try {
			BufferedReader bf = Files.newBufferedReader(file, Charset.defaultCharset());
			String line = null;
			while ((line = bf.readLine()) != null) {
				countLine(line.trim(), bf, isGenerated, statFile.getStatSet());
			}
			bf.close();
		} catch (IOException e) {
			logger.warn("Could not read file: " + file);
		}
		statFiles.put(file, statFile);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>withFileDetails</b></em>'.
	 */
	public boolean getWithFileDetails() {
		return withFileDetails;
	}
	
	/**
	 * Sets the value of attribute '<em><b>withFileDetails</b></em>'.
	 * @param	withFileDetails	the value to set.
	 */
	public void setWithFileDetails(boolean withFileDetails) {
		this.withFileDetails = withFileDetails;
	}
	
	/**
	 * Returns the value of attribute '<em><b>beginProtectedRegionRegExp</b></em>'.
	 */
	public String getBeginProtectedRegionRegExp() {
		return beginProtectedRegionRegExp;
	}
	
	/**
	 * Sets the value of attribute '<em><b>beginProtectedRegionRegExp</b></em>'.
	 * @param	beginProtectedRegionRegExp	the value to set.
	 */
	public void setBeginProtectedRegionRegExp(String beginProtectedRegionRegExp) {
		this.beginProtectedRegionRegExp = beginProtectedRegionRegExp;
	}
	
	/**
	 * Returns the value of attribute '<em><b>endProtectedRegionRegExp</b></em>'.
	 */
	public String getEndProtectedRegionRegExp() {
		return endProtectedRegionRegExp;
	}
	
	/**
	 * Sets the value of attribute '<em><b>endProtectedRegionRegExp</b></em>'.
	 * @param	endProtectedRegionRegExp	the value to set.
	 */
	public void setEndProtectedRegionRegExp(String endProtectedRegionRegExp) {
		this.endProtectedRegionRegExp = endProtectedRegionRegExp;
	}
	
	/**
	 * Returns the value of attribute '<em><b>singleLineComment</b></em>'.
	 */
	public String getSingleLineComment() {
		return singleLineComment;
	}
	
	/**
	 * Sets the value of attribute '<em><b>singleLineComment</b></em>'.
	 * @param	singleLineComment	the value to set.
	 */
	public void setSingleLineComment(String singleLineComment) {
		this.singleLineComment = singleLineComment;
	}
	
	/**
	 * Returns the value of attribute '<em><b>multiLineStartComment</b></em>'.
	 */
	public String getMultiLineStartComment() {
		return multiLineStartComment;
	}
	
	/**
	 * Sets the value of attribute '<em><b>multiLineStartComment</b></em>'.
	 * @param	multiLineStartComment	the value to set.
	 */
	public void setMultiLineStartComment(String multiLineStartComment) {
		this.multiLineStartComment = multiLineStartComment;
	}
	
	/**
	 * Returns the value of attribute '<em><b>documentationStartComment</b></em>'.
	 */
	public String getDocumentationStartComment() {
		return documentationStartComment;
	}
	
	/**
	 * Sets the value of attribute '<em><b>documentationStartComment</b></em>'.
	 * @param	documentationStartComment	the value to set.
	 */
	public void setDocumentationStartComment(String documentationStartComment) {
		this.documentationStartComment = documentationStartComment;
	}
	
	/**
	 * Returns the value of attribute '<em><b>multiLineEndComment</b></em>'.
	 */
	public String getMultiLineEndComment() {
		return multiLineEndComment;
	}
	
	/**
	 * Sets the value of attribute '<em><b>multiLineEndComment</b></em>'.
	 * @param	multiLineEndComment	the value to set.
	 */
	public void setMultiLineEndComment(String multiLineEndComment) {
		this.multiLineEndComment = multiLineEndComment;
	}
	
	/**
	 * Returns the value of attribute '<em><b>baseDir</b></em>'.
	 */
	public String getBaseDir() {
		return baseDir;
	}
	
	/**
	 * Sets the value of attribute '<em><b>baseDir</b></em>'.
	 * @param	baseDir	the value to set.
	 */
	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
	}
	
	/**
	 * Returns the value of attribute '<em><b>relativeGeneratedDir</b></em>'.
	 */
	public java.util.Set<String> getRelativeGeneratedDir() {
		return relativeGeneratedDir;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>relativeGeneratedDir</b></em>'.
	 * @param	relativeGeneratedDir	the value to add.
	 */
	public void addRelativeGeneratedDir(String relativeGeneratedDir) {
		this.relativeGeneratedDir.add(relativeGeneratedDir);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>relativeGeneratedDir</b></em>'.
	 * @param	relativeGeneratedDir	the value to remove.
	 */
	public void removeRelativeGeneratedDir(String relativeGeneratedDir) {
		this.relativeGeneratedDir.remove(relativeGeneratedDir);
	}
	
	/**
	 * Returns the value of attribute '<em><b>relativeOwnImplDir</b></em>'.
	 */
	public java.util.Set<String> getRelativeOwnImplDir() {
		return relativeOwnImplDir;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>relativeOwnImplDir</b></em>'.
	 * @param	relativeOwnImplDir	the value to add.
	 */
	public void addRelativeOwnImplDir(String relativeOwnImplDir) {
		this.relativeOwnImplDir.add(relativeOwnImplDir);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>relativeOwnImplDir</b></em>'.
	 * @param	relativeOwnImplDir	the value to remove.
	 */
	public void removeRelativeOwnImplDir(String relativeOwnImplDir) {
		this.relativeOwnImplDir.remove(relativeOwnImplDir);
	}
	
	/**
	 * Returns the value of attribute '<em><b>excludedDir</b></em>'.
	 */
	public java.util.Set<String> getExcludedDir() {
		return excludedDir;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>excludedDir</b></em>'.
	 * @param	excludedDir	the value to add.
	 */
	public void addExcludedDir(String excludedDir) {
		this.excludedDir.add(excludedDir);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>excludedDir</b></em>'.
	 * @param	excludedDir	the value to remove.
	 */
	public void removeExcludedDir(String excludedDir) {
		this.excludedDir.remove(excludedDir);
	}
	
	/**
	 * Returns the value of attribute '<em><b>rootDir</b></em>'.
	 */
	public StatDir getRootDir() {
		return rootDir;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "withFileDetails")
	public boolean getDefaultWithFileDetails() {
		return false;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "beginProtectedRegionRegExp")
	public String getDefaultBeginProtectedRegionRegExp() {
		return ".*(PROTECTED REGION) ID(.*).*START.*";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "endProtectedRegionRegExp")
	public String getDefaultEndProtectedRegionRegExp() {
		return ".*(PROTECTED REGION) END.*";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "singleLineComment")
	public String getDefaultSingleLineComment() {
		return "//";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "multiLineStartComment")
	public String getDefaultMultiLineStartComment() {
		return "/*";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "documentationStartComment")
	public String getDefaultDocumentationStartComment() {
		return "/**";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "multiLineEndComment")
	public String getDefaultMultiLineEndComment() {
		return "*/";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "relativeGeneratedDir")
	public java.util.Set<String> getDefaultRelativeGeneratedDir() {
		java.util.Set<String> result = new java.util.LinkedHashSet<String>();
		result.add("src-gen");
		return result;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "excludedDir")
	public java.util.Set<String> getDefaultExcludedDir() {
		java.util.Set<String> result = new java.util.LinkedHashSet<String>();
		result.add(".svn");
		result.add(".cvs");
		result.add(".hg");
		result.add(".git");
		return result;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._Nx0r8IzJEeKLl_w7vhifuQ) ENABLED START */
	private Map<Path, StatFile> statFiles = new LinkedHashMap<Path, StatFile>();
	private Pattern beginProtectedRegionRegExpPattern;
	private Pattern endProtectedRegionRegExpPattern;
	private Set<Path> generatedDir = new LinkedHashSet<Path>();
	private Set<Path> ownImplDir = new LinkedHashSet<Path>();
	private Path basePath;
	
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
		if (line.isEmpty()) {
			return;
		}
		
		if (line.startsWith(singleLineComment)) {
			stats.incComment(generated);
			return;
		}
		
		if (documentationStartComment != null) {
			if (line.startsWith(documentationStartComment) && !line.endsWith(multiLineEndComment)) {
				int lines = countMultiCommentLines(bf);
				stats.incDocu(lines, generated);
				return;
			}
			stats.incDocu(generated);
		}
		
		if (line.startsWith(multiLineStartComment)) {
			if (generated && beginProtectedRegionRegExpPattern.matcher(line).matches()) {
				stats.incProtReg(2);
				try {
					while (!endProtectedRegionRegExpPattern.matcher(line = bf.readLine().trim()).matches()) {
						countLine(line, bf, false, stats);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				return;
			}
			
			if (!line.endsWith(multiLineEndComment)) {
				int lines = countMultiCommentLines(bf);
				stats.incComment(lines, generated);
			}
			stats.incComment(generated);
			return;
		}
		stats.incCode(generated);
	}
	
	/**
	 * Checks if a path is in a list.
	 * @param	listToCheck	The list with which it should be compared.
	 * @param	file	the file to check
	 * @return	true if the file is in the list
	 */
	private boolean isIn(java.util.Set<Path> listToCheck, Path file) {
		for (Path check : listToCheck) {
			if (file.toAbsolutePath().normalize().startsWith(check)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks whether a file is excluded. Therefore it looks if a exclude string is contained in the path or the file starts with the absolute exclude path.
	 * @param	file	the file/directory to check
	 * @return	true if the file is excluded
	 */
	private boolean isExcluded(Path file) {
		for (String excl : excludedDir) {
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
	}
	
	/**
	 * Count multiLine comment lines. Used for doc and normal multiLine comments.
	 * @param	bf	the BufferedReader that contains the opened file.
	 * @return	the count of lines until <em><b>multiLineCommentEndString</b></em>
	 */
	private int countMultiCommentLines(BufferedReader bf) {
		int lines = 1;
		try {
			while (!bf.readLine().trim().endsWith(multiLineEndComment)) {
				lines++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	/**
	 * Called from {@link FileTreeWalkerFeature#visitFile(Path, java.nio.file.attribute.BasicFileAttributes)}. Reads the file and counts the lines within the groups. Creates an {@link StatFile} with an {@link StatisticSet} for the file.
	 * 
	 * @see #readFile(Path, boolean)
	 * @param	file	the file that should be read.
	 */
	
	public void updateFileVisit(Path file) {
		if (!isExcluded(file)) {
			boolean generated = isIn(generatedDir, file);
			if (generated || isIn(ownImplDir, file)) {
				readFile(file, generated);
			}
		}
	}
	
	/**
	 * Called from {@link FileTreeWalkerFeature#postVisitDirectory(Path, IOException)} . Creates a new {@link StatDir} with a {@link StatisticSet} for the directory if its not excluded and adds all subfiles with its statistics to it.
	 * @param	dir	the directory
	 */
	
	public void updateAfterDir(Path dir) {
		if (!isExcluded(dir)) {
			StatDir statDir = new StatDir(new StatisticsSet(), dir);
			List<File> files = Arrays.asList(dir.toFile().listFiles());
			for (Path key : statFiles.keySet()) {
				if (files.contains(key.toFile())) {
					statDir.addFile(statFiles.get(key));
				}
			}
			if (!(statDir.getStatSet().getAllLines() == 0) || isIn(generatedDir, dir) || isIn(ownImplDir, dir)) {
				statFiles.put(dir, statDir);
			}
		}
	}
	
	/**
	 * Called if the {@link FileTreeWalkerFeature} walked the tree completely. Sets prepared to true and Logs the found information.
	 */
	
	public void updateComplete() {
		//		prepared = true;
		rootDir = (StatDir) statFiles.get(basePath);
		//		logger.debug(getRootDir());
	}
	/* PROTECTED REGION END */
}
