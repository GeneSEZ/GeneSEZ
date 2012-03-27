package org.genesez.platform.common.m2t;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1317372073268_640398_1748) 
 */

import java.util.List;
import java.util.Map;
import java.io.IOException;
import org.apache.commons.logging.LogFactory;
import org.genesez.platform.common.FileTreeObserverAdapter;
import org.genesez.platform.common.NotPreparedException;
import org.genesez.platform.common.workflow.WorkflowUtils;
import org.apache.commons.logging.Log;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.regex.PatternSyntaxException;
import org.eclipse.xpand2.output.FileHandle;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Set;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.StringReader;
import java.io.BufferedReader;
import org.eclipse.xpand2.output.PostProcessor;
import java.io.File;
import java.util.LinkedList;
import java.util.HashSet;

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
public class ImportBeautifier extends FileTreeObserverAdapter implements PostProcessor {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * To find the place where the file-ID stands.
	 */
	private static final String FILE_ID_STRING = "@FILE-ID : (";
	
	/**
	 * Using log4j-mechanism for error logging.
	 */
	protected Log logger = LogFactory.getLog(getClass());
	
	/**
	 * Stores the settings for the import formatter.
	 */
	private Properties options = new Properties();
	
	/**
	 * Map with FILE-IDs and corresponding imports
	 */
	protected Map<String, Set<String>> importMap = new HashMap<String, Set<String>>();
	
	private Pattern extensionsRegex;
	
	private Pattern importRegex;
	
	private boolean prepared = false;
	
	private boolean importTakeOver = true;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Searches for the File-ID in the given file and if found it searches the file for imports using the importRegex. After that it stores both in a map.
	 * @param	file	file to be searched
	 */
	
	public void updateFileVisit(Path file) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1317372092237_663255_1766) ENABLED START */
		if (importRegex != null && importTakeOver) {
			if (extensionsRegex == null || extensionsRegex.matcher(file.toString()).matches()) {
				// initialize
				Set<String> imports = new HashSet<String>();
				String guID = null;
				String line = null;
				BufferedReader br = null;
				try {
					br = Files.newBufferedReader(file, Charset.defaultCharset());
					// check line for FileIDString
					while ((line = br.readLine()) != null) {
						if (guID == null && line.contains(FILE_ID_STRING)) {
							guID = line.substring(line.indexOf("(") + 1, line.indexOf(")"));
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
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets prepared to true after file tree walked completely.
	 */
	
	public void updateComplete() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318574734552_492529_1974) ENABLED START */
		prepared = true;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets file extensions for files that should be scanned. It creates a regular expression, which looks like: ".*(\\.extension|\\.extension|...)$"
	 * @param	extension	the file extensions separated by ("," or ";")
	 */
	
	public void setFileExtensions(String extension) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318593138571_872664_3460) ENABLED START */
		String regex = WorkflowUtils.split(extension).toString().replaceAll(", ", "|").replaceAll("\\.", "\\\\.");
		regex = regex.substring(1, regex.length() - 1);
		try {
			extensionsRegex = Pattern.compile(".*(" + regex + ")$");
		} catch (PatternSyntaxException e) {
			logger.error("Given file extensions are defective: " + extension);
		}
		if (extensionsRegex != null) {
			this.getOptions().setProperty("org.genesez.importbeautifier.fileextensions", ".*(" + regex + ")$");
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Compiles the given string into a regular expression pattern to indicate imports. NOTE: Be sure to use appropriate regular expression syntax.
	 * @see java.util.regex.Pattern for more information.
	 * @param	regex	the import regular expressions.
	 */
	
	public void setImportRegex(String regex) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318593158947_657263_3463) ENABLED START */
		try {
			this.importRegex = Pattern.compile(regex);
		} catch (PatternSyntaxException e) {
			logger.error("Error in import regular expression: " + regex + " - Imports can not be carried over.");
		}
		if (importRegex != null) {
			this.getOptions().setProperty("org.genesez.importformatter.regex", regex);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Only for convenience. Makes an import regular expression.
	 * @see #setImportRegex(java.lang.String)
	 * @param	importStrings	import strings (separated by "," or ";")
	 */
	
	public void setImportStrings(String importStrings) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318593176812_133963_3466) ENABLED START */
		String regex = WorkflowUtils.split(importStrings).toString().replaceAll(", ", "|");
		regex = "(" + regex.substring(1, regex.length() - 1) + ") .*$";
		this.setImportRegex(regex);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Puts the before found imports onto the right place in the currently opened file.
	 * 
	 * @return file as String with included imports
	 * @throws NotPreparedException thrown if beautifier is not added as observer and/or if file tree not walked properly.
	 * @param	file	opened filehandle
	 * @return	file as String with included imports
	 */
	private StringBuffer putImports(FileHandle file) throws NotPreparedException {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318593227639_452561_3476) ENABLED START */
		String fileString = file.getBuffer().toString();
		
		if (importRegex == null || !importTakeOver) {
			return new StringBuffer(fileString);
		}
		BufferedReader br = new BufferedReader(new StringReader(fileString));
		if (!prepared) {
			throw new NotPreparedException("Beautifier is not prepared properly");
		}
		// initialize
		List<String> lines = new LinkedList<String>();
		String guID = null;
		int putImports = -1;
		
		Set<String> imports = new HashSet<String>();
		String line = null;
		boolean importFound = false;
		int nextLine = -1;
		// makes a line~ and an import list
		try {
			while ((line = br.readLine()) != null) {
				if (guID != null && importRegex.matcher(line).matches()) {
					// checks if line is an import line
					importFound = true;
					imports.add(line);
				} else {
					lines.add(line);
					if (guID == null && line.contains(FILE_ID_STRING)) {
						// checks for guID
						guID = line.substring(line.indexOf("(") + 1, line.indexOf(")"));
						if (importMap.containsKey(guID)) {
							imports.addAll(importMap.get(guID));
						}
					} else if (guID != null && putImports == -1 && line.trim().isEmpty()) {
						// search for next free line to put imports into
						putImports = lines.size();
					} else if (guID != null && nextLine == -1 && importFound && !line.trim().isEmpty()) {
						nextLine = lines.size() - 2;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
			}
		}
		
		// put imports into file
		if (guID != null && putImports > -1) {
			while (nextLine > putImports) {
				lines.remove(putImports);
				nextLine--;
			}
			lines.addAll(putImports, imports);
		}
		
		// creates a String from tokens.
		StringBuffer sb = new StringBuffer(lines.size() * 80);
		for (String aLine : lines) {
			sb.append(aLine + System.getProperty("line.separator"));
		}
		
		return sb;
		/* PROTECTED REGION END */
	}
	
	/**
	 * This method is implemented from the oAW PostProcessor interface. It is called before the file will be written and closed.
	 * @param	file	the file which shall be modified.
	 */
	
	public void beforeWriteAndClose(FileHandle file) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318593297439_371260_3480) ENABLED START */
		@SuppressWarnings("deprecation")
		File target = file.getTargetFile();
		if (target != null && (extensionsRegex == null || extensionsRegex.matcher(file.getAbsolutePath()).matches())) {
			file.setBuffer(putImports(file));
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * This method is implemented from the oAW PostProcessor interface. It is called after the file is closed. Does nothing.
	 * @param	file	file which shall be modified.
	 */
	
	public void afterClose(FileHandle file) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318593315889_656773_3483) ENABLED START */
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Stores the settings for the import formatter.
	 */
	public Properties getOptions() {
		return options;
	}
	
	/**
	 * Stores the settings for the import formatter.
	 */
	public void setOptions(Properties options) {
		this.options = options;
	}
	
	/**
	 * Sets the value of attribute '<em><b>importTakeOver</b></em>'
	 */
	public void setImportTakeOver(boolean importTakeOver) {
		this.importTakeOver = importTakeOver;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1317372073268_640398_1748) ENABLED START */
	/* PROTECTED REGION END */
	
}
