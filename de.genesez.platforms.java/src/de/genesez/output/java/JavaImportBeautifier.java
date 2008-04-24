package de.genesez.output.java;

import org.openarchitectureware.xpand2.output.FileHandle;

import de.genesez.output.ImportBeautifier;
import de.genesez.output.Properties;


public class JavaImportBeautifier extends ImportBeautifier {

	/**
	 * 
	 */
	public JavaImportBeautifier() {
		super();
		Properties options = new Properties();
		options.put("de.genesez.importformatter.delim", "\n");
		options.put("de.genesez.importformatter.regex", "(import)( )");
		setOptions(options);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openarchitectureware.xpand2.output.PostProcessor#afterClose(org.openarchitectureware.xpand2.output.FileHandle)
	 */
	
	public void afterClose(FileHandle arg0) {
		// nothing to do
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openarchitectureware.xpand2.output.PostProcessor#beforeWriteAndClose(org.openarchitectureware.xpand2.output.FileHandle)
	 */
	
	public void beforeWriteAndClose(FileHandle file) {
		if (file.getTargetFile() != null
				&& file.getTargetFile().getAbsolutePath().endsWith(".java")) {

			String edit = file.getBuffer().toString();
			edit = getImportFormatter().format(edit);

			// check if text formatted successfully
			file.setBuffer(new StringBuffer(edit));
		}
	}
}
