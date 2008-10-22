package de.genesez.platforms.common.m2t;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openarchitectureware.xpand2.output.PostProcessor;

/**
 * This class provides a skeletal implementation for concrete import beautifier.
 * The task of an import beautifier is the detection and reduction of double
 * import statements. Furthermore, this class implements the PostProcessor
 * interface which allows to define a concrete import beautifier as a beautifier
 * attribute in the Xpand workflow component.
 * 
 * @author nihe
 * @date 2008-02-24
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
		return options;
	}
	
	/**
	 * Setter for the settings of the import formatter.
	 * 
	 * @param options the settings as Properties class
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
		if (importFormatter == null) {
			importFormatter = new ImportFormatter(options);
		}
		return importFormatter;
	}
	
}
