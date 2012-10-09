package org.genesez.eclipse4.wizard.util;

import java.io.File;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Bean class for JAXB parsing
 * 
 * @author domwet
 */
@XmlRootElement(name = "templateConfig")
public class TemplateConfigXml {
	/** programming language of the template */
	@XmlElement
	private String language;

	/** name of the template */
	@XmlElement
	private String name;

	/** determines if the template is an example */
	@XmlElement
	private boolean example;

	/** description of the template */
	@XmlElement
	private String description;
	
	/** the project name in the Zip-File */
	@XmlElement(name = "projectName")
	private String internalProjectName;

	/** the corresponding ZipFile */
	private File file;

	/** @return name of the template */
	public String getName() {
		return name;
	}

	/** @return description of the template */
	public String getDescription() {
		return description;
	}

	/** @return programming language of the template */
	public String getLanguage() {
		return language;
	}

	/** @return true if template is an example */
	public boolean isExample() {
		return example;
	}

	/** @return the internal project name */
	public String getInternalProjectName() {
		return internalProjectName;
	}

	/** @return the corresponding file */
	public File getFile() {
		return file;
	}

	/**
	 * Sets the corresponding file
	 * 
	 * @param file
	 *            the file
	 */
	protected void setFile(File file) {
		this.file = file;
	}

	/**
	 * @return a String with all important information.
	 */
	public String toString() {
		return "File: " + file.getPath() + "\nName: " + name
				+ "\nLanguage: " + language + "\nExample: " + example
				+ "\nProjectName: " + internalProjectName
				+ "\nDescription: " + description + "\n";
	}
}
