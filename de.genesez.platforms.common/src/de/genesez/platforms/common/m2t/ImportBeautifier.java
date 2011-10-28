package de.genesez.platforms.common.m2t;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.PostProcessor;

import de.genesez.platforms.common.FileTreeObserverAdapter;
import de.genesez.platforms.common.NotPreparedException;
import de.genesez.platforms.common.workflow.WorkflowUtils;

/**
 * The task of an import beautifier is the detection and reduction of double
 * import statements. It also stores and adds previously added imports.
 * Furthermore, this class implements the PostProcessor interface which allows
 * to define an import beautifier as a beautifier attribute in the Xpand
 * workflow component.
 * 
 * @author nihe
 * @author Dominik Wetzel
 * @date 2011-10-12
 */
public class ImportBeautifier extends FileTreeObserverAdapter implements
		PostProcessor {

	/**
	 * Using log4j-mechanism for error logging.
	 */
	protected final Log logger = LogFactory.getLog(getClass());

	private final static String FileIDString = "@FILE-ID : (";

	/**
	 * Singleton import formatter instance.
	 */
	private ImportFormatter importFormatter = null;

	/**
	 * Stores the settings for the import formatter.
	 */
	private Properties options = null;

	/**
	 * Map with File-IDs and corresponding Imports
	 */
	protected Map<String, Set<String>> importMap = new LinkedHashMap<String, Set<String>>();

	private Pattern extensionsRegex = null;

	private Pattern importRegex = null;

	private boolean prepared = false;

	private boolean importTakeOver = true;

	/**
	 * Constructor which sets some creates options and set
	 * de.genesez.importformatter.delim to "\n".
	 */
	public ImportBeautifier() {
		options = new Properties();
		options.setProperty("de.genesez.importformatter.delim", "\n");
	}

	/**
	 * Getter for the options.
	 * 
	 * @return the settings as Properties class
	 */
	public Properties getOptions() {
		return this.options;
	}

	/**
	 * Setter for the options.
	 * 
	 * @param options
	 *            the settings as Properties class
	 */
	public void setOptions(Properties options) {
		this.options = options;
	}

	/**
	 * Sets file extensions for files that should be scanned. It creates a
	 * regular expression, which looks like:
	 * ".*(\\.extension|\\.extension|...)$"
	 * 
	 * @param extensions
	 *            the file extensions separated by ("," or ";")
	 */
	public void setFileExtensions(String extensions) {
		String regex = WorkflowUtils.split(extensions).toString()
				.replaceAll(", ", "|").replaceAll("\\.", "\\\\.");
		regex = regex.substring(1, regex.length() - 1);
		try {
			extensionsRegex = Pattern.compile(".*(" + regex + ")$");
		} catch (PatternSyntaxException e) {
			logger.error("Given file extensions are defective: " + extensions);
		}
		if (extensionsRegex != null) {
			this.getOptions().setProperty(
					"de.genesez.importbeautifier.fileextensions",
					".*(" + regex + ")$");
		}
	}

	/**
	 * Compiles the given string into a regular expression pattern to indicate
	 * imports. NOTE: Be sure to use appropriate regular expression syntax.
	 * 
	 * @see java.util.regex.Pattern for more information.
	 * 
	 * @param regex
	 *            the import regular expressions.
	 */
	public void setImportRegex(String regex) {
		try {
			this.importRegex = Pattern.compile(regex);
		} catch (PatternSyntaxException e) {
			logger.error("Error in import regular expression: " + regex
					+ " - Imports can not be carried over.");
		}
		if (importRegex != null) {
			this.getOptions().setProperty("de.genesez.importformatter.regex",
					regex);
		}
	}

	/**
	 * Only for convenience. Makes an import regular expression.
	 * 
	 * @see #setImportRegex(java.lang.String)
	 * @param importStrings
	 *            import strings (separated by "," or ";")
	 */
	public void setImportStrings(String importStrings) {
		String regex = WorkflowUtils.split(importStrings).toString()
				.replaceAll(", ", "|");
		regex = "(" + regex.substring(1, regex.length() - 1) + ") .*$";
		this.setImportRegex(regex);
	}

	/**
	 * Sets a new line delimiter, to check the line endings.
	 * 
	 * @param delim
	 *            the new delimiter.
	 */
	public void setLineDelimiter(String delim) {
		options.setProperty("de.genesez.importformatter.delim", delim);
	}

	/**
	 * Sets if imports should be carried over from old to new generated files or
	 * not.
	 * 
	 * @param importTakeOver
	 *            if false imports won't be carried over.
	 */
	public void setImportTakeOver(String importTakeOver) {
		this.importTakeOver = Boolean.parseBoolean(importTakeOver);
	}

	/**
	 * Sole method to get the preconfigured import formatter.
	 * 
	 * @return singleton import formatter instance
	 */
	protected ImportFormatter getImportFormatter() {
		if (this.importFormatter == null) {
			this.importFormatter = new ImportFormatter(this.options);
		}
		return this.importFormatter;
	}

	/**
	 * Searches for the File-ID in the given file and if found it searches the
	 * file for imports using the importRegex. After that it stores both in a
	 * map.
	 * 
	 * @param file
	 *            file to be searched
	 */
	@Override
	public void updateFileVisit(Path file) {
		if (importRegex != null && importTakeOver) {
			if (extensionsRegex == null || extensionsRegex.matcher(file.toString()).matches()) {
				// initialize
				Set<String> imports = new HashSet<String>();
				String guID = null;
				String line = null;
				BufferedReader br = null;
				try {
					br = Files
							.newBufferedReader(file, Charset.defaultCharset());
					// check line for FileIDString
					while ((line = br.readLine()) != null) {
						if (line.contains(FileIDString) && guID == null) {
							guID = line.substring(line.indexOf("(") + 1,
									line.indexOf(")"));
						}
						// add imports to guID
						line = line.trim();
						if (guID != null && importRegex.matcher(line).matches()) {
							imports.add(line);
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (br != null) {
							br.close();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				// add to importMap
				if (!imports.isEmpty()) {
					importMap.put(guID, imports);
				}
			}
		}
	}

	/**
	 * Sets prepared to true after file tree walked completely
	 */
	@Override
	public void updateComplete() {
		prepared = true;
	}

	/**
	 * Puts the before found imports onto the right place in the currently
	 * opened file.
	 * 
	 * @param file
	 *            opened filehandle
	 * @return file as String with included imports
	 * @throws NotPreparedException
	 *             thrown if beautifier is not added as observer (file tree not
	 *             walked properly)
	 */
	protected String putImports(FileHandle file) throws NotPreparedException {
		String fileString = file.getBuffer().toString();
		if (importRegex == null || !importTakeOver) {
			return fileString;
		}
		if (prepared) {
			// initialize
			String delim = options
					.getProperty("de.genesez.importformatter.delim");
			StringTokenizer st = new StringTokenizer(fileString, delim);
			List<String> lines = new LinkedList<String>();
			String guID = null;
			int putImports = -1;

			// make a line List
			while (st.hasMoreTokens()) {
				String token = st.nextToken();
				lines.add(token);
				// look for guID
				if (token.contains(FileIDString) && guID == null) {
					guID = token.substring(token.indexOf("(") + 1,
							token.indexOf(")"));
				} else if (guID != null && putImports == -1
						&& token.trim().isEmpty()) {
					// search for next free line to put imports into
					putImports = lines.size();
				}
			}

			// put imports into file
			if (guID != null && importMap.containsKey(guID)) {
				Set<String> imports = importMap.get(guID);
				if (putImports > -1) {
					lines.addAll(putImports - 1, imports);
				}
			}
			// creates a String from tokens.
			fileString = "";
			for (String line : lines) {
				fileString = fileString.concat(line + delim);
			}
			return fileString;
		} else {
			throw new NotPreparedException(
					"Beautifier is not prepared properly");
		}
	}

	/**
	 * This method is implemented from the oAW PostProcessor interface. It is
	 * called before the file will be written and closed.
	 * 
	 * @param file
	 *            the file which shall be modified.
	 */
	@SuppressWarnings("deprecation")
	public void beforeWriteAndClose(FileHandle file) {
		if (file.getTargetFile() != null
				&& (extensionsRegex == null || extensionsRegex.matcher(
						file.getAbsolutePath()).matches())) {
			String edit = putImports(file);
			// String edit = file.getBuffer().toString();
			// detect and delete double import statements
			edit = getImportFormatter().format(edit);
			// write string to file
			file.setBuffer(new StringBuffer(edit));
		}
	}

	/**
	 * This method is implemented from the oAW PostProcessor interface. It is
	 * called after the file is closed.
	 * 
	 * @param file
	 *            the file which shall be modified.
	 */
	public void afterClose(FileHandle file) {
		// nothing to do
	}
}
