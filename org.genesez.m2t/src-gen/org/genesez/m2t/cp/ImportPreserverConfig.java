package org.genesez.m2t.cp;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_8oUToAm-EeK7rvpt4qDtAg) 
 */

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class ImportPreserverConfig {
	
	private String fileExtensionRegExp;
	
	private String importRegExp;
	
	/**
	 * Initializing constructor for class '<em><b>ImportPreserverConfig</b></em>'.
	 * @param	fileExtensionRegExp	{@link String.getFileExtensionRegExp()}
	 * @param	importRegExp	{@link String.getImportRegExp()}
	 */
	public ImportPreserverConfig(String fileExtensionRegExp, String importRegExp) {
		this.fileExtensionRegExp = fileExtensionRegExp;
		this.importRegExp = importRegExp;
	}
	
	/**
	 * Returns the value of attribute '<em><b>fileExtensionRegExp</b></em>'
	 */
	public String getFileExtensionRegExp() {
		return fileExtensionRegExp;
	}
	
	/**
	 * Returns the value of attribute '<em><b>importRegExp</b></em>'
	 */
	public String getImportRegExp() {
		return importRegExp;
	}
	
	/* PROTECTED REGION ID(java.datatype.own.code.implementation._8oUToAm-EeK7rvpt4qDtAg) ENABLED START */
	/* PROTECTED REGION END */
}
