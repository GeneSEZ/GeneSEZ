package de.genesez.platforms.common.m2t;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
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

import de.genesez.platforms.common.FileTreeObserver;
import de.genesez.platforms.common.workflow.feature.FileTreeWalkerFeature.FileEvent;
import de.genesez.platforms.common.workflow.feature.NotPreparedException;

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
public abstract class ImportBeautifier implements PostProcessor,
		FileTreeObserver {

	private int prePriority = 10;
	private int postPriority = 0;
	
	/**
	 * Using log4j-mechanism for error logging.
	 */
	protected final Log logger = LogFactory.getLog(getClass());

	/**
	 * Singleton import formatter instance.
	 */
	private ImportFormatter importFormatter = null;

	/**
	 * Stores the settings for the import formatter.
	 */
	private Properties options = null;

	private Map<String, List<String>> importMap = new LinkedHashMap<String, List<String>>();
	private final static String FileIDString = "@FILE-ID : (";
	private String importRegex;
	private String extensionsRegex;

	private boolean prepared = false;

	/**
	 * Sole constructor which does nothing.
	 * 
	 * @param importString
	 *            String that declares imports.
	 */
	public ImportBeautifier(String importRegex, List<String> extensions) {
		this.importRegex = importRegex;
		extensionsRegex = extensions.toString().replaceAll(", ", "|");
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
		if (prepared) {
			// initialize
			String fileString = file.getBuffer().toString();
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
				if (token.contains(FileIDString)) {
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
				List<String> imports = importMap.get(guID);
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
	 * Searches for the PreProRegID in the given file and if found it searches
	 * the file again for imports. After that it stores both in a map.
	 * 
	 * @param event
	 *            the event for the file
	 * @param file
	 *            file to be searched
	 */
	public void update(FileEvent event, Path file) {
		if (event.equals(FileEvent.FILE_VISIT)
				&& file.toString().matches(".*" + extensionsRegex + "$")) {
			// initialize
			List<String> imports = new LinkedList<String>();
			String guID = null;
			String line = null;
			BufferedReader br = null;
			try {
				br = Files.newBufferedReader(file, Charset.defaultCharset());
				// check line for FileIDString
				while ((line = br.readLine()) != null) {
					if (line.contains(FileIDString)) {
						guID = line.substring(line.indexOf("(") + 1,
								line.indexOf(")"));
					}
					// add imports to guID
					if (guID != null && line.matches(importRegex)) {
						imports.add(line.trim());
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
		} else if (event.equals(FileEvent.COMPLETED)) {
			prepared = true;
		}
	}
	
	public int getPrePriority(){
		return prePriority;
	}
	
	public int getPostPriority(){
		return postPriority;
	}
	
	public void setPrePriority(int prior){
		this.prePriority = prior;
	}
	
	public void setPostPriority(int prior){
		this.postPriority = prior;
	}
}
