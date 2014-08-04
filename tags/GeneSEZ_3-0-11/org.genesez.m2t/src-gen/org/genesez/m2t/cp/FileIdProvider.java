package org.genesez.m2t.cp;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_G9snEA8lEeK6yuw9r03UDQ) 
 */
import java.nio.file.Path;
import java.util.List;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class FileIdProvider implements LineContentExtractor, LineContentPreservable {
	
	/**
	 * To find the place where the file-ID stands.
	 */
	private static final String FILE_ID_STRING = "@FILE-ID : (";
	
	private String fileId;
	
	/**
	 * Method stub for further implementation.
	 */
	public String getFileId() {
		/* PROTECTED REGION ID(java.implementation._LMKyoA8lEeK6yuw9r03UDQ) ENABLED START */
		return fileId;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public boolean hasFileId() {
		/* PROTECTED REGION ID(java.implementation._yNM6AA8sEeK6yuw9r03UDQ) ENABLED START */
		return fileId != null;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public boolean hasExtractableContent(Path file) {
		/* PROTECTED REGION ID(java.implementation._G9snEA8lEeK6yuw9r03UDQ__BeNPcA7sEeKn_eQP-uNBOQ) ENABLED START */
		return true;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Processes the specified line of content.
	 */
	public void extractContent(String line) {
		/* PROTECTED REGION ID(java.implementation._G9snEA8lEeK6yuw9r03UDQ__R27m0A7rEeKn_eQP-uNBOQ) ENABLED START */
		if (hasFileId()) {
			return;
		}
		if (line.contains(FILE_ID_STRING)) {
			fileId = line.substring(line.indexOf("(") + 1, line.indexOf(")"));
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public void finished(boolean file) {
		/* PROTECTED REGION ID(java.implementation._G9snEA8lEeK6yuw9r03UDQ__mYwn8A7yEeKn_eQP-uNBOQ) ENABLED START */
		if (file) {
			fileId = null;
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public LineContentExtractor getExtractor() {
		/* PROTECTED REGION ID(java.implementation._G9snEA8lEeK6yuw9r03UDQ__j24soA7oEeKn_eQP-uNBOQ) ENABLED START */
		return this;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public ContentIncluder getIncluder() {
		/* PROTECTED REGION ID(java.implementation._G9snEA8lEeK6yuw9r03UDQ__n5OgsA7oEeKn_eQP-uNBOQ) ENABLED START */
		return new ContentIncluder() {
			
			@Override
			public List<String> includeContent(List<String> input) {
				return input;
			}
		};
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._G9snEA8lEeK6yuw9r03UDQ) ENABLED START */
	/* PROTECTED REGION END */
}
