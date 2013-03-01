package de.genesez.platforms.common.m2t;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The task of this class is to perform the the detection and reduction of
 * double import statements. The detection of import statements is solved via
 * regular expressions.
 * 
 * @author nihe
 * @date 2008-02-24
 * @todo support more than one import section
 */
public class ImportFormatter {
	
	/**
	 * Using log4j-mechanism for logging errors.
	 */
	private final Log log = LogFactory.getLog(getClass());
	
	/**
	 * Stores the settings of the import formatter.
	 */
	private Properties options = null;
	
	/**
	 * The list of lines from a file.
	 */
	private List<String> fileLines = null;
	
	/**
	 * The set of non-double import statements.
	 */
	private Set<String> importStatements = null;
	
	/**
	 * The first position of an import statement.
	 */
	private Integer firstImportStatement = null;
	
	/**
	 * The last position of an import statement.
	 */
	private Integer lastImportStatement = null;
	
	/**
	 * Sole constructor which sets the settings of the import formatter. Actual
	 * the property keys "de.genesez.importformatter.delim" and
	 * "de.genesez.importformatter.regex" are supported. The
	 * "de.genesez.importformatter.delim" key has the task to split lines. The
	 * "de.genesez.importformatter.regex" key is used to find import statements.
	 * 
	 * @param options the settings as Properties class
	 */
	public ImportFormatter(Properties options) {
		this.options = options;
		
		if (!options.containsKey("de.genesez.importformatter.delim"))
			log.error("The property: 'de.genesez.importformatter.delim' isn't set.");
		if (!options.containsKey("de.genesez.importformatter.regex"))
			log.error("The property: 'de.genesez.importformatter.regex' isn't set.");
	}
	
	/**
	 * This method performs the detection and reduction of double import
	 * statements and returns the modified file content.
	 * 
	 * @param edit the file content
	 * @return the formatted file content
	 */
	public String format(String edit) {
		String returnValue = null;
		
		String delim = options.getProperty("de.genesez.importformatter.delim");
		String regex = options.getProperty("de.genesez.importformatter.regex");
		
		splitStringInLines(edit, delim);
		findImports(regex);
		
		returnValue = generateModifiedFileContent();
		
		return returnValue;
	}
	
	/**
	 * This method splits the lines by means of the property key
	 * "de.genesez.importformatter.delim".
	 * 
	 * @param edit the file content
	 * @param delim the delimiter to split lines
	 * @return
	 */
	private List<String> splitStringInLines(String edit, String delim) {
		fileLines = new LinkedList<String>();
		StringTokenizer st = new StringTokenizer(edit, delim);
		
		while (st.hasMoreTokens()) {
			fileLines.add(st.nextToken());
		}
		return Collections.unmodifiableList(fileLines);
	}
	
	/**
	 * This method searches import statements by means of the property key
	 * "de.genesez.importformatter.regex".
	 * 
	 * @param regex the regular expression
	 * @return the detected import lines as set of strings
	 */
	private Set<String> findImports(String regex) {
		importStatements = new HashSet<String>();
		
		firstImportStatement = -1;
		lastImportStatement = -1;
		
		Matcher matcher = null;
		String actLine = null;
		
		for (int i = 0; i < fileLines.size(); i++) {
			actLine = fileLines.get(i);
			matcher = initRegex(regex, actLine);
			if (matcher != null) {
				if (matcher.find()) {
					if (firstImportStatement == -1)
						firstImportStatement = i;
					if (lastImportStatement < i)
						lastImportStatement = i;
					importStatements.add(actLine);
				}
			} else {
				log.error("Error in regular expression: " + regex);
			}
		}
		return Collections.unmodifiableSet(importStatements);
	}
	
	/**
	 * This method create the new file content without double import statement.
	 * 
	 * @return the modified context
	 */
	private String generateModifiedFileContent() {
		String returnValue = "";
		
		// text before the first import statement
		for (int i = 0; i < firstImportStatement; i++) {
			returnValue += fileLines.get(i);
		}
		
		// the import statements
		Iterator<String> it = importStatements.iterator();
		while (it.hasNext()) {
			returnValue += it.next();
		}
		
		// text after the last import statement
		for (int i = lastImportStatement + 1; i < fileLines.size(); i++) {
			returnValue += fileLines.get(i);
		}
		
		return returnValue;
	}
	
	/**
	 * Translate regular expression and instantiate a matcher object.
	 * 
	 * @param regex the regular expression
	 * @param input the input string
	 * @return the matcher object for parsing
	 */
	private Matcher initRegex(String regex, String input) {
		Matcher matcher = null;
		
		try {
			Pattern pattern = Pattern.compile(regex);
			matcher = pattern.matcher(input);
		} catch (PatternSyntaxException ex) {
			return null;
		}
		return matcher;
	}
	
}
