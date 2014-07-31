/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.wizard.util.replace.simpel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Dictionary;

/**
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 *
 */
public abstract class SimpleTextReplacer {

	protected String[] fileExtensions = new String[]{};
	protected static final int BUFFER = 4096;
	protected StringBuilder buffer = new StringBuilder();

	public SimpleTextReplacer() {
	}

	/**
	 * gets the used file extensions
	 * @return the fileextensions array
	 */
	public String[] getFileExtensions() {
		return fileExtensions;
	}
	
	/**
	 * Fills the file with content and makes the necessary changes
	 * 
	 * @param file the emptyFile which should be filled
	 * @param istream the inputstream which contains the old file input
	 * @param oldAppName the old Application Project Name
	 * @param oldGenName the old Generation Project Name
	 * @param newAppName the new Application Project Name
	 * @param newGenName the new Generator Project Name
	 * @param isGenProject true if its a file from the Generator Project
	 * @param properties store for additional information
	 * @return true if file has right extension
	 */
	public boolean fillAndReplace(File file, InputStream istream, String oldAppName,
			String oldGenName, String newAppName, String newGenName,
			boolean isGenProject, Dictionary<String, Object> properties) {
		if (checkFile(file)) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					istream), BUFFER);
			String oldText = getOldText(file, oldAppName, oldGenName,
					isGenProject, properties);
			String newText = getNewText(file, newAppName, newGenName,
					isGenProject, properties);
			try {
				replaceInFile(buffer, reader, oldText, newText);
				writeFile(file, buffer);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				buffer = new StringBuilder();
			}
			return true;
		}
		return false;
	}
	
	/**
	 * Gives the old text, which will be replaced
	 * @param file the file, where things shall be replaced
	 * @param oldAppName the old Application Project Name
	 * @param oldGenName the old Generation Project Name
	 * @param isGenProject true if its a file from the Generator Project
	 * @param properties store for additional information
	 * @return to replace
	 */
	protected abstract String getOldText(File file, String oldAppName,
			String oldGenName, boolean isGenProject,
			Dictionary<String, Object> properties);

	/**
	 * Gives the new text, which will be the replacement for the old text
	 * @param file the file, where things shall be replaced
	 * @param newAppName the new Application Project Name
	 * @param newGenName the new Generator Project Name
	 * @param isGenProject true if its a file from the Generator Project
	 * @param properties store for additional information
	 * @return the replacement
	 */
	protected abstract String getNewText(File file, String newAppName,
			String newGenName, boolean isGenProject,
			Dictionary<String, Object> properties);

	/**
	 * Checks if the file can be used by this replacer
	 * @param file the file to check
	 * @return true if it can be used
	 */
	protected boolean checkFile(File file) {
		for (String ext : fileExtensions)
			if (file.getName().endsWith(ext))
				return true;
		return false;
	}
	
	/**
	 * Does the replacement (is followed by writeFile)
	 * @param buffer the buffer, where the file content will be stored
	 * @param reader the reader, which reads the input string
	 * @param oldText the text to replace
	 * @param newText the replacement
	 * @throws IOException if something goes wrong
	 */
	protected void replaceInFile(StringBuilder buffer, BufferedReader reader,
			String oldText, String newText) throws IOException {
		String line;
		while ((line = reader.readLine()) != null) {
			line = line.replaceAll(oldText, newText);
			buffer.append(line + System.getProperty("line.separator"));
		}
	}

	/**
	 * Writes the file into the file system
	 * @param emptyFile the file to be written
	 * @param buffer the content of the file
	 * @throws IOException if something goes wrong
	 */
	protected void writeFile(File emptyFile, StringBuilder buffer)
			throws IOException {
		FileWriter writer = new FileWriter(emptyFile);
		writer.write(buffer.toString());
		writer.close();
	}

}
