package de.genesez.platforms.java.m2t;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.eclipse.xpand2.output.FileHandle;

import de.genesez.platforms.common.m2t.ImportBeautifier;

/**
 * This class is a concrete import beautifier for the java programming language.
 * It uses the "\n" value for the "de.genesez.importformatter.delim" property
 * key and the "(import)( )" regular expression for the
 * "de.genesez.importformatter.regex" property key.
 * 
 * @author nihe
 * @date 2009-02-24
 */
public class JavaImportBeautifier extends ImportBeautifier {
	// constants for import resolving
	private final static List<String> preProRegIDStrings = Arrays.asList(new String[]{"java.class.own.code.implementation."}); 
	private final static String importString = "import ";
	
	// variables for import resolving
	private boolean importsChecked = false;
	private String outputDir;
	
	/**
	 * Sole constructor which sets the properties.
	 */
	public JavaImportBeautifier(String outputDir) {
		super();
		Properties options = new Properties();
		this.outputDir = outputDir;
		options.setProperty("de.genesez.importformatter.delim", "\n");
		options.setProperty("de.genesez.importformatter.regex", "(import)( )");
		setOptions(options);
	}
	
	/**
	 * This method is implemented from the oAW PostProcessor interface. It is
	 * called after the file is closed.
	 * 
	 * @param file the file which shall be modified.
	 */
	public void afterClose(FileHandle file) {
		// nothing to do
	}
	
	/**
	 * This method is implemented from the oAW PostProcessor interface. It is
	 * called before the file will be written and closed.
	 * 
	 * @param file the file which shall be modified.
	 */
	@SuppressWarnings("deprecation")
	public void beforeWriteAndClose(FileHandle file) {
		if(!importsChecked){
			importsChecked = getImports(preProRegIDStrings, importString, outputDir);
		}
		if (file.getTargetFile() != null && file.getAbsolutePath().endsWith(".java")) {
			String edit = putImports(file);
			// detect and delete double import statements
			edit = getImportFormatter().format(edit);
			// write string to file
			file.setBuffer(new StringBuffer(edit));
		}
	}
}
