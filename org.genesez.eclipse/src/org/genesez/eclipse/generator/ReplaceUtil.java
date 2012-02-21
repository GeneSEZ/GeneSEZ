package org.genesez.eclipse.generator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * Stores the template patterns and their target values for replacing operations.
 * Set desired values to the ReplaceUtil before running the operations.
 * @author Marcel Klein
 */
public class ReplaceUtil {
	
	/** storage of all pattern and their assigned values */
	Map<String,String> patternTable = new Hashtable<String,String>();
	/** list of the current patterns, always linked to the patternTable */
	Set<String> patternKeys = patternTable.keySet();
	/** buffer for huge string building */
	private StringBuilder stringBuffer = new StringBuilder();
	
	/**
	 * Create new replacer utility.
	 */
	public ReplaceUtil() {
	}
	
	/**
	 * Replaces all pattern occurrences in the target string 
	 * with the current assigned pattern values.
	 * @param target replace in that string
	 * @return string with replaced patterns
	 */
	public String replace(String target) {
		for(String key : patternKeys) {
			// get current value of the pattern (if one exists)
			String value;
			if((value = patternTable.get(key)) != null) {
				// run the pattern replacement
				target = target.replace(key, value);
			}
		}
		return target;
	}
	
	/**
	 * Adds a new pattern with should get replaced by the given value.
	 * @param pattern pattern which should be replaced
	 * @param value value which replaces the pattern
	 */
	public void addPattern(String pattern, String value) {
		patternTable.put(pattern, value);
	}
	
	/**
	 * Replaces all pattern occurrences in the targeted file.
	 * <b>The file will be overridden with the new values!</b>
	 * @param fileName name of target file
	 * @throws IOException
	 */
	public void replaceInFile(String fileName) throws IOException {
		File file = new File(fileName);
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		stringBuffer.setLength(0); // reset string builder
		String line = null;
		while((line = reader.readLine()) != null) {
			line = this.replace(line);
			stringBuffer.append(line);
			stringBuffer.append("\r\n");
		}
		reader.close();
		FileWriter writer = new FileWriter(file);
		
		writer.write(stringBuffer.toString());
		writer.close();
	}
}
