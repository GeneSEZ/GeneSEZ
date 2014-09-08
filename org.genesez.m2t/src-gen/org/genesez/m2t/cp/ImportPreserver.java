package org.genesez.m2t.cp;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_Pos7EA7zEeKn_eQP-uNBOQ) 
 */
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class ImportPreserver extends FileIdProvider implements LineContentExtractor, ContentIncluder, LineContentPreservable {
	
	public final Log logger = LogFactory.getLog(getClass());
	
	private Pattern importRegex;
	
	private Pattern extensionsRegex;
	
	/**
	 * Map with FILE-IDs and corresponding imports
	 */
	private Map<String, List<String>> allImports;
	
	private java.util.List<String> fileImports = new java.util.ArrayList<String>();
	
	private java.util.List<String> fileContent = new java.util.ArrayList<String>();
	
	private boolean enabled = true;
	
	private boolean prepared = false;
	
	/**
	 * Method stub for further implementation.
	 */
	public void setConfig(ImportPreserverConfig config) {
		/* PROTECTED REGION ID(java.implementation._U0AiUA7zEeKn_eQP-uNBOQ) ENABLED START */
		String regexp = config.getFileExtensionRegExp();
		try {
			extensionsRegex = Pattern.compile(regexp);
			if (logger.isDebugEnabled()) {
				logger.debug("File extension pattern: " + extensionsRegex.toString());
			}
		} catch (PatternSyntaxException e) {
			logger.warn("File extensions regex is incorrectly specified: " + regexp + ". All files will be processed!");
		}
		regexp = config.getImportRegExp();
		try {
			importRegex = Pattern.compile(regexp);
			if (logger.isDebugEnabled()) {
				logger.debug("Import regexp pattern: " + importRegex.toString());
			}
		} catch (PatternSyntaxException e) {
			logger.fatal("Incorrect import regular expression: " + regexp + " - Imports can not be carried over.");
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	protected boolean isComment(String line) {
		/* PROTECTED REGION ID(java.implementation._Xc7swA89EeK6yuw9r03UDQ) ENABLED START */
		return line.trim().startsWith("*");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public boolean hasExtractableContent(Path file) {
		/* PROTECTED REGION ID(java.implementation._kNPlcIvfEeKyp9GO00JvUQ) ENABLED START */
		if (importRegex == null || !enabled) {
			return false;
		}
		if (extensionsRegex == null || extensionsRegex.matcher(file.toString()).matches()) {
			return true;
		}
		return false;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Processes the specified line of content.
	 */
	public void extractContent(String line) {
		/* PROTECTED REGION ID(java.implementation._kNPlc4vfEeKyp9GO00JvUQ) ENABLED START */
		// delegate to file id provider
		super.extractContent(line);
		// extract imports
		String tl = line.trim();
		if (importRegex.matcher(tl).matches()) {
			fileImports.addAll(fileContent);
			fileImports.add(tl);
			fileContent.clear();
		} else if (!fileImports.isEmpty()) {
			fileContent.add(line);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public void finished(boolean file) {
		/* PROTECTED REGION ID(java.implementation._kNF0cIvfEeKyp9GO00JvUQ) ENABLED START */
		if (file) {
			if (hasFileId() && !fileImports.isEmpty()) {
				allImports.put(getFileId(), new ArrayList<>(fileImports));
			}
			fileImports.clear();
			fileContent.clear();
		} else {
			prepared = true;
		}
		// delegate to file id provider
		super.finished(file);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public LineContentExtractor getExtractor() {
		/* PROTECTED REGION ID(java.implementation._pyA1kovfEeKyp9GO00JvUQ) ENABLED START */
		return this;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public ContentIncluder getIncluder() {
		/* PROTECTED REGION ID(java.implementation._pyA1kIvfEeKyp9GO00JvUQ) ENABLED START */
		return this;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets the value of attribute '<em><b>enabled</b></em>'.
	 * @param	enabled	the value to set.
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	/**
	 * Includes the preserved content into the specified content and returns all content.
	 */
	public java.util.List<String> includeContent(java.util.List<String> input) {
		/* PROTECTED REGION ID(java.implementation._Pos7EA7zEeKn_eQP-uNBOQ__4BERgA7pEeKn_eQP-uNBOQ) ENABLED START */
		// check prepared
		if (!prepared) {
			logger.error("Not prepared to include imports in content!");
			return input;
		}
		// fetch generated imports from input
		fileImports.clear();
		String fileId = null;
		int lineFileId = 0;
		int lineImportsStart = 0;
		int lineImportsEnd = 0;
		int i = 0;
		for (String line : input) {
			super.extractContent(line);
			if (importRegex.matcher(line.trim()).matches()) {
				fileImports.add(line);
				lineImportsEnd = i;
			}
			if (fileImports.isEmpty()) {
				lineImportsStart++;
			}
			if (!hasFileId()) {
				lineFileId++;
			}
			i++;
		}
		fileId = getFileId();
		// reset file id provider
		super.finished(true);
		// check file id
		if (fileId == null) {
			return input;
		}
		// check preserved imports
		if (!allImports.containsKey(fileId)) {
			return input;
		}
		// merge generated and preserved imports
		List<String> imports = allImports.get(fileId);
		for (String gi : fileImports) {
			String tgi = gi.trim();
			boolean add = true;
			for (String pi : imports) {
				String tpi = pi.trim();
				if (tgi.equals(tpi)) {
					add = false;
				}
			}
			// add generated import if it's not already a preserved import
			if (add) {
				imports.add(gi);
			}
		}
		// put merged imports
		int putOnLine = 0;
		if (lineImportsStart != 0 && lineImportsEnd != 0) {
			// remove all generated imports
			for (int rows = lineImportsEnd - lineImportsStart; rows >= 0; rows--) {
				input.remove(lineImportsStart);
			}
			putOnLine = lineImportsStart;
		} else {
			// find line to put imports on below file id
			putOnLine = lineFileId;
			String l = null;
			do {
				putOnLine++;
				l = input.get(putOnLine).trim();
			} while (isComment(l) && putOnLine <= i);
		}
		// put imports
		for (String imp : imports) {
			input.add(putOnLine++, imp);
		}
		return input;
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._Pos7EA7zEeKn_eQP-uNBOQ) ENABLED START */
	{
		allImports = new LinkedHashMap<>();
	}
	/* PROTECTED REGION END */
}
