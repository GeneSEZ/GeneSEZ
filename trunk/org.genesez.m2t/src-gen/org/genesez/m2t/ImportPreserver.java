package org.genesez.m2t;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_Y_qJgAD0EeK7ac-mrkJBDw) 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
 * @author dreamer
 */
public class ImportPreserver extends FileTreeObserverAdapter {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * To find the place where the file-ID stands.
	 */
	private static final String FILE_ID_STRING = "@FILE-ID : (";
	
	public final Log logger = LogFactory.getLog(getClass());
	
	/**
	 * Map with FILE-IDs and corresponding imports
	 */
	protected Map<String, Set<String>> importMap;
	
	private Pattern extensionsRegex;
	
	private Pattern importRegex;
	
	private boolean prepared = false;
	
	private boolean enabled = true;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Sets file extensions for files that should be scanned. It creates a regular expression, which looks like: ".*(\\.extension|\\.extension|...)$"
	 * @param	regex	the file extensions separated by ("," or ";")
	 */
	public void setFileExtensionRegex(String regex) {
		/* PROTECTED REGION ID(java.implementation._Y_qJnAD0EeK7ac-mrkJBDw) ENABLED START */
		try {
			extensionsRegex = Pattern.compile(".*(" + regex + ")$");
			if (logger.isDebugEnabled()) {
				logger.debug("File extension pattern: " + extensionsRegex.toString());
			}
		} catch (PatternSyntaxException e) {
			logger.warn("File extensions regex is incorrectly specified: " + regex + ". All files will be processed!");
		}
		//		if (extensionsRegex != null) {
		//			this.getOptions().setProperty("org.genesez.importbeautifier.fileextensions", ".*(" + regex + ")$");
		//		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Compiles the given string into a regular expression pattern to indicate imports. NOTE: Be sure to use appropriate regular expression syntax.
	 * @see java.util.regex.Pattern for more information.
	 * @param	regex	the import regular expressions.
	 */
	public void setImportRegex(String regex) {
		/* PROTECTED REGION ID(java.implementation._Y_qJoAD0EeK7ac-mrkJBDw) ENABLED START */
		try {
			importRegex = Pattern.compile(regex);
			if (logger.isDebugEnabled()) {
				logger.debug("Import regexp pattern: " + importRegex.toString());
			}
		} catch (PatternSyntaxException e) {
			logger.fatal("Incorrect import regular expression: " + regex + " - Imports can not be carried over.");
		}
		//		if (importRegex != null) {
		//			this.getOptions().setProperty("org.genesez.importformatter.regex", regex);
		//		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Only for convenience. Makes an import regular expression.
	 * @see #setImportRegex(java.lang.String)
	 * @param	importStrings	import strings (separated by "," or ";")
	 */
	public void setImportStrings(String importStrings) {
		/* PROTECTED REGION ID(java.implementation._Y_qJpAD0EeK7ac-mrkJBDw) ENABLED START */
		String regex = importStrings.replaceAll(",", "|");
		regex = "(" + regex.substring(1, regex.length() - 1) + ") .*$";
		setImportRegex(regex);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Searches for the File-ID in the given file and if found it searches the file for imports using the importRegex. After that it stores both in a map.
	 * @param	file	file to be searched
	 */
	public void updateFileVisit(Path file) {
		/* PROTECTED REGION ID(java.implementation._Y_qJlgD0EeK7ac-mrkJBDw) ENABLED START */
		if (importRegex == null || !enabled) {
			return;
		}
		if (extensionsRegex == null || extensionsRegex.matcher(file.toString()).matches()) {
			// initialize
			Set<String> imports = new LinkedHashSet<String>();
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
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets prepared to true after file tree walked completely.
	 */
	public void updateComplete() {
		/* PROTECTED REGION ID(java.implementation._Y_qJmgD0EeK7ac-mrkJBDw) ENABLED START */
		prepared = true;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Puts the before found imports onto the right place in the currently opened file.
	 * 
	 * @return file as String with included imports
	 * @throws NotPreparedException thrown if beautifier is not added as observer and/or if file tree not walked properly.
	 * @param	fileContent	opened filehandle
	 * @return	file as String with included imports
	 */
	protected CharSequence putImports(CharSequence fileContent) {
		/* PROTECTED REGION ID(java.implementation._Y_qJqAD0EeK7ac-mrkJBDw) ENABLED START */
		if (importRegex == null || !enabled) {
			return fileContent;
		}
		if (!prepared) {
			logger.fatal("Import take over is not prepared! Can't do anything!");
			return fileContent;
		}
		
		// initialize
		String fileString = fileContent.toString();
		BufferedReader br = new BufferedReader(new StringReader(fileString));
		List<String> lines = new LinkedList<String>();
		String guID = null;
		int putImports = -1;
		
		Set<String> imports = new LinkedHashSet<String>();
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
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Sets the value of attribute '<em><b>enabled</b></em>'
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._Y_qJgAD0EeK7ac-mrkJBDw) ENABLED START */
	{
		importMap = new LinkedHashMap<>();
	}
	/* PROTECTED REGION END */
	
}
