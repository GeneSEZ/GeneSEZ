package de.genesez.platforms.common.m2t;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.PostProcessor;

/**
 * This class provides a skeletal implementation for concrete import beautifier.
 * The task of an import beautifier is the detection and reduction of double
 * import statements. It also stores and adds previously added imports.
 * Furthermore, this class implements the PostProcessor interface which allows
 * to define a concrete import beautifier as a beautifier attribute in the Xpand
 * workflow component.
 * 
 * @author nihe
 * @author Dominik Wetzel
 * @date 2011-09-22
 */
public abstract class ImportBeautifier implements PostProcessor {

	/**
	 * Using log4j-mechanism for error logging.
	 */
	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * Singleton import formatter instance.
	 */
	private ImportFormatter importFormatter = null;

	/**
	 * Stores the settings for the import formatter.
	 */
	private Properties options = null;

	private Map<String, List<String>> importMap = new LinkedHashMap<String, List<String>>();
	private List<String> preProRegStrings;
	private String importString;

	/**
	 * Sole constructor which does nothing.
	 */
	public ImportBeautifier() {
	}

	/**
	 * Getter for the settings of the import formatter.
	 * 
	 * @return the settings as Properties class
	 */
	public Properties getOptions() {
		return this.options;
	}

	/**
	 * Setter for the settings of the import formatter.
	 * 
	 * @param options
	 *            the settings as Properties class
	 */
	public void setOptions(Properties options) {
		this.options = options;
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
	 * Searches all Files for ProRegIDs and associated imports. and stores them
	 * in a map.
	 * 
	 * @param preProRegStrs
	 *            strings with ProRegID prefixes that should be searched.
	 * @param importRegx
	 *            the used String for imports.
	 * @return true, after file search is finished
	 * 
	 */
	protected boolean getImports(List<String> preProRegStrs, String importStr,
			String outputDir) {
		this.preProRegStrings = preProRegStrs;
		this.importString = importStr;
		try {
			Files.walkFileTree(Paths.get(outputDir),
					new SimpleFileVisitor<Path>() {
						/**
						 * Searches for the PreProRegID in the given file and if
						 * found it searches the file again for imports. After
						 * that it stores both in a map.
						 * 
						 * @param file
						 *            file to be searched
						 * @param attrs
						 *            the file's basic attributes.
						 */
						@Override
						public FileVisitResult visitFile(Path file,
								BasicFileAttributes attrs) throws IOException {
							List<String> imports = new LinkedList<String>();
							String guiID = null;
							BufferedReader br = Files.newBufferedReader(file,
									Charset.defaultCharset());
							String line = null;
							while ((line = br.readLine()) != null) {
								for (String s : preProRegStrings) {
									if (line.contains("PROTECTED REGION ID("
											+ s)) {
										guiID = line.trim();
									}
								}
							}
							br.close();
							if (guiID != null) {
								br = Files.newBufferedReader(file,
										Charset.defaultCharset());
								while ((line = br.readLine()) != null) {
									if (line.trim().startsWith(importString)) {
										imports.add(line.trim());
									}
								}
								if (!imports.isEmpty()) {
									importMap.put(guiID, imports);
								}
								br.close();
							}
							return FileVisitResult.CONTINUE;
						}
					});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * Puts the before found imports onto the right place in the currently
	 * opened file.
	 * 
	 * @param file
	 *            opened filehandle
	 * @return file as String with included imports
	 */
	protected String putImports(FileHandle file) {
		// initialize
		String fileString = file.getBuffer().toString();
		String delim = options.getProperty("de.genesez.importformatter.delim");
		StringTokenizer st = new StringTokenizer(fileString, delim);
		List<String> lines = new LinkedList<String>();
		String guiID = null;
		int firstImport = 0;

		// make a line List
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			lines.add(token);
			for (String s : preProRegStrings) {
				if (firstImport == 0 && token.trim().startsWith(importString)) {
					firstImport = lines.size();
				} else if (token.contains("PROTECTED REGION ID(" + s)) {
					guiID = token.trim();
				}
			}
		}

		// put imports into map
		if (guiID != null && importMap.containsKey(guiID)) {
			List<String> imports = importMap.get(guiID);
			lines.addAll(firstImport - 1, imports);
		}

		// creates a String from tokens.
		fileString = "";
		for (String line : lines) {
			fileString = fileString.concat(line + delim);
		}
		return fileString;
	}
}
