package org.genesez.m2t.cp.xpand;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_L9UhsA_0EeKuTrE1zpGjjg) 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.PostProcessor;
import org.genesez.m2t.cp.ContentIncluder;
import org.genesez.m2t.cp.LineContentPreservable;
import org.genesez.m2t.cp.LineContentPreserving;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class XPandLineContentPreserving extends LineContentPreserving implements PostProcessor {
	
	/**
	 * Method stub for further implementation.
	 * @param	file	
	 */
	public void updateFileVisit(Path file) {
		/* PROTECTED REGION ID(java.implementation._GdBFYA_1EeKuTrE1zpGjjg) ENABLED START */
		// prevent the 2nd file tree walk with content inclusion
		if (!prepared) {
			super.updateFileVisit(file);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * This method is implemented from the oAW PostProcessor interface. It is called before the file will be written and closed.
	 * @param	file	the file which shall be modified.
	 */
	public void beforeWriteAndClose(FileHandle file) {
		/* PROTECTED REGION ID(java.implementation._Wcbk5A_0EeKuTrE1zpGjjg) ENABLED START */
		CharSequence input = file.getBuffer();
		// convert file buffer into list of strings
		List<String> fileContent = new LinkedList<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new StringReader(input.toString()));
			String line = null;
			while ((line = br.readLine()) != null) {
				fileContent.add(line);
			}
		} catch (IOException ioe) {
			logger.error("Error converting file buffer into list of strings!", ioe);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					logger.error("Error closing string reader to fetch file buffer!", e);
				}
			}
		}
		// delegate file content to includers
		for (LineContentPreservable lcp : preservable()) {
			ContentIncluder cl = lcp.getIncluder();
			fileContent = cl.includeContent(fileContent);
		}
		// set file content as file buffer
		StringBuilder output = new StringBuilder();
		String newline = System.getProperty("line.separator");
		for (String it : fileContent) {
			output.append(it);
			output.append(newline);
		}
		file.setBuffer(output);
		/* PROTECTED REGION END */
	}
	
	/**
	 * This method is implemented from the oAW PostProcessor interface. It is called after the file is closed. Does nothing.
	 * @param	file	file which shall be modified.
	 */
	public void afterClose(FileHandle file) {
		/* PROTECTED REGION ID(java.implementation._Wcbk4A_0EeKuTrE1zpGjjg) ENABLED START */
		// do nothing ...
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._L9UhsA_0EeKuTrE1zpGjjg) ENABLED START */
	/* PROTECTED REGION END */
	
}
