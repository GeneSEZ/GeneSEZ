package org.genesez.eclipse4.wizard.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.core.runtime.IPath;

/**
 * The Bean class for JAXB parsing for a template zip file.
 * Contains also some additional information.
 * 
 * @author Dominik Wetzel
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
	
	/** all internal files */
	private List<IPath> internalFiles = new ArrayList<IPath>();
	
	/** all internal folders */
	private List<IPath> internalFolders = new ArrayList<IPath>();

	/** Standard constructor */
	public TemplateConfigXml(){
	}
	
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
	
	/** @return a List of internal files */
	public List<IPath> getInternalFiles(){
		return internalFiles;
	}
	
	/** @return a List of internal folders */
	public List<IPath> getInternalFolders(){
		return internalFolders;
	}

	/**
	 * Sets the corresponding file
	 * @param file the file
	 */
	protected void setFile(File file) {
		this.file = file;
	}
	
	/**
	 * Adds a folder to internalFolders
	 * @param path the folder to add
	 */
	protected void addInternalFolder(IPath path){
		internalFolders.add(path);
	}
	
	/**
	 * Adds a file to internalFiles
	 * @param path the file to add
	 */
	protected void addInternalFile(IPath path){
		internalFiles.add(path);
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
