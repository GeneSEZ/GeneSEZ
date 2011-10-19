package de.genesez.platforms.common.m2t;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
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
 * @date 2011-10-17
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
	 * the compiled regular expression
	 */
	private Pattern pattern = null;

	/**
	 * Sole constructor which sets the settings of the import formatter. Actual
	 * the property keys "de.genesez.importformatter.delim" and
	 * "de.genesez.importformatter.regex" are supported. The
	 * "de.genesez.importformatter.delim" key has the task to split lines. The
	 * "de.genesez.importformatter.regex" key is used to find import statements.
	 * 
	 * @param options
	 *            the settings as Properties class
	 */
	public ImportFormatter(Properties options) {
		this.options = options;

		if (!this.options.containsKey("de.genesez.importformatter.delim"))
			log.error("The property: 'de.genesez.importformatter.delim' isn't set.");
		if (!this.options.containsKey("de.genesez.importformatter.regex")){
			log.error("The property: 'de.genesez.importformatter.regex' isn't set.");
		} else {
			pattern = initRegex(options.getProperty("de.genesez.importformatter.regex"));
		}
	}

	/**
	 * This method performs the detection and reduction of double import
	 * statements and returns the modified file content.
	 * 
	 * @param edit
	 *            the file content
	 * @return the formatted file content
	 */
	public String format(String edit) {
		String returnValue = null;

		String delim = this.options
				.getProperty("de.genesez.importformatter.delim");
		String regex = this.options
				.getProperty("de.genesez.importformatter.regex");

		splitStringInLines(edit, delim);
		findImports(regex);

		returnValue = generateModifiedFileContent(delim);

		return returnValue;
	}

	/**
	 * This method splits the lines by means of the property key
	 * "de.genesez.importformatter.delim".
	 * 
	 * @param edit
	 *            the file content
	 * @param delim
	 *            the delimiter to split lines
	 * @return list with all lines
	 */
	private List<String> splitStringInLines(String edit, String delim) {
		this.fileLines = new LinkedList<String>();
		StringTokenizer st = new StringTokenizer(edit, delim);

		while (st.hasMoreTokens()) {
			this.fileLines.add(st.nextToken());
		}
		return Collections.unmodifiableList(this.fileLines);
	}

	/**
	 * This method searches import statements by means of the property key
	 * "de.genesez.importformatter.regex".
	 * 
	 * @param regex
	 *            the regular expression
	 * @return the detected import lines as set of strings
	 */
	private Set<String> findImports(String regex) {
		this.importStatements = new LinkedHashSet<String>();

		this.firstImportStatement = -1;
		this.lastImportStatement = -1;

		String actLine = null;

		for (int i = 0; i < this.fileLines.size(); i++) {
			actLine = this.fileLines.get(i).trim();
			if (pattern != null) {
				if (pattern.matcher(actLine).matches()) {
					if (this.firstImportStatement == -1)
						this.firstImportStatement = i;
					if (this.lastImportStatement < i)
						this.lastImportStatement = i;
					this.importStatements.add(actLine);
				}
			}
		}
		return Collections.unmodifiableSet(this.importStatements);
	}

	/**
	 * This method create the new file content without double import statement.
	 * 
	 * @param delim the delimiter which separates the lines
	 * @return the modified context
	 */
	private String generateModifiedFileContent(String delim) {
		String returnValue = "";

		// text before the first import statement
		for (int i = 0; i < this.firstImportStatement; i++) {
			returnValue += this.fileLines.get(i) + delim;
		}

		// the import statements
		for (String importStament : this.importStatements) {
			returnValue += importStament + delim;
		}

		// text after the last import statement
		for (int i = this.lastImportStatement + 1; i < this.fileLines.size(); i++) {
			returnValue += this.fileLines.get(i) + delim;
		}

		return returnValue;
	}

	/**
	 * Compiles regular expression into a Pattern.
	 * 
	 * @param regex
	 *            the regular expression
	 * @return the compiled Pattern or null if regular expression is defective.
	 */
	private Pattern initRegex(String regex) {
		Pattern pattern = null;
		try {
			pattern = Pattern.compile(regex);
		} catch (PatternSyntaxException ex) {
			log.error("Error in import regular expression: " + regex);
		}
		return pattern;
	}

}
