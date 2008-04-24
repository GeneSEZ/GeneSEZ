package de.genesez.output;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author nicher
 * 
 */
public class ImportFormatter {

	/**
	 * Logger instance.
	 */
	private final Log log = LogFactory.getLog(getClass());

	/**
	 * Properties for import formatter.
	 */
	private Properties options = null;

	/**
	 * A list of lines from a text file.
	 */
	private List<String> fileLines = null;

	/**
	 * A set of import statements.
	 */
	private Set<String> importStatements = null;

	/**
	 * First position of an import statement.
	 */
	private Integer firstImportStatement = null;

	/**
	 * Last position of an import statement.
	 */
	private Integer lastImportStatement = null;

	/**
	 * @param options
	 *            for the import formatter
	 */
	public ImportFormatter(Properties options) {
		this.options = options;

		if (!options.containsKey("de.genesez.importformatter.delim"))
			log
					.error("The property: 'de.genesez.importformatter.delim' isn't set.");
		if (!options.containsKey("de.genesez.importformatter.regex"))
			log
					.error("The property: 'de.genesez.importformatter.regex' isn't set.");
	}

	/**
	 * @param edit
	 * @return a formatted content of a file.
	 */
	public String format(String edit) {
		String returnValue = null;

		String delim = options.getValue("de.genesez.importformatter.delim");
		String regex = options.getValue("de.genesez.importformatter.regex");

		splitStringInLines(edit, delim);
		findImports(regex);

		returnValue = generateModifiedFileContent();

		return returnValue;
	}

	/**
	 * @param edit
	 * @param delim
	 *            The delimiter to break lines.
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
	 * @param regex
	 *            The regular expression.
	 * @return
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
	 * @return the modified context.
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
	 * @param regex
	 *            The regular expression.
	 * @param input
	 *            The input string.
	 * @return a matcher object for parsing.
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
