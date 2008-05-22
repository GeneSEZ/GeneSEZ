package de.genesez.platforms.common.m2t;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openarchitectureware.xpand2.output.PostProcessor;

/**
 * Basic abstract class for concrete import beautifier.
 * 
 * @author nicher
 */
public abstract class ImportBeautifier implements PostProcessor {

	/**
	 * Logger instance.
	 */
	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * Singleton import formatter instance.
	 */
	private ImportFormatter importFormatter = null;

	/**
	 * Properties for import formatter
	 */
	private Properties options = null;

	/**
	 * 
	 */
	public ImportBeautifier() {
	}

	/**
	 * @return the options for the import formatter.
	 */
	public Properties getOptions() {
		return options;
	}

	/**
	 * @param options
	 *            for the import formatter.
	 */
	public void setOptions(Properties options) {
		this.options = options;
	}

	/**
	 * Returns an instance of the import formatter.
	 * 
	 * @return a preconfigured instance of the import formatter.
	 */
	protected ImportFormatter getImportFormatter() {
		if (importFormatter == null) {
			importFormatter = new ImportFormatter(options);
		}
		return importFormatter;
	}

}
