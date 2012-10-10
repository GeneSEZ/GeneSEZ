package org.genesez.m2t.cp;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_jnWBUA7TEeKSL4xN3YIZZg) 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.genesez.m2t.FileTreeObserverAdapter;
import org.genesez.platform.java.umlsupport.associations.Association;
import org.genesez.platform.java.umlsupport.associations.AssociationRole;
import org.genesez.platform.java.umlsupport.associations.ManyAssociation;
import org.genesez.platform.java.umlsupport.associations.RelatedAssociationRole;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author dreamer
 */
public class LineContentPreserving extends FileTreeObserverAdapter implements AssociationRole {
	
	// -- generated attribute, constant + association declarations ----------
	/** Defines an identifier for each association, used by the association handling library */
	public enum Associations implements RelatedAssociationRole {
		PRESERVABLE
	}
	
	/** Stores the association management objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	
	/** Stores associated objects of association PRESERVABLE to LineContentPreservable */
	public java.util.Set<LineContentPreservable> preservable = new java.util.LinkedHashSet<LineContentPreservable>();
	
	public final Log logger = LogFactory.getLog(getClass());
	
	/**
	 * paths relative to output directory that are excluded during the file search.
	 */
	private java.util.Set<String> excludedRelativePaths = new java.util.HashSet<String>();
	
	/**
	 * Directory names that are excluded during file search
	 */
	private java.util.Set<String> excludedDirectoryNames = new java.util.HashSet<String>();
	
	protected boolean prepared = false;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	dir	
	 */
	public void updateBeforeDir(Path dir) {
		/* PROTECTED REGION ID(java.implementation._7nBVcA7yEeKn_eQP-uNBOQ) ENABLED START */
		// TODO: we should return true if we want to access the directory, otherwise false -> refactor file tree walker!
		for (String dirname : excludedDirectoryNames) {
			if (dir.endsWith(dirname)) {
				return;
			}
		}
		for (String path : excludedRelativePaths) {
			if (dir.startsWith(path)) {
				return;
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	file	
	 */
	public void updateFileVisit(Path file) {
		/* PROTECTED REGION ID(java.implementation._amVfkA7uEeKn_eQP-uNBOQ) ENABLED START */
		// check execluded files + directories
		for (String dirname : excludedDirectoryNames) {
			if (file.toString().matches(".*[\\\\|/]" + dirname + "[\\\\|/].*")) {
				return;
			}
		}
		for (String path : excludedRelativePaths) {
			if (file.startsWith(path)) {
				return;
			}
		}
		// extract or include content
		if (!prepared) {
			extractContent(file);
		} else {
			includeContent(file);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public void updateComplete() {
		/* PROTECTED REGION ID(java.implementation._rUTU4A7yEeKn_eQP-uNBOQ) ENABLED START */
		if (!prepared) {
			// notify extractors
			for (LineContentPreservable lcp : preservable) {
				LineContentExtractor lce = lcp.getExtractor();
				lce.finished(false);
			}
			// mark prepared
			prepared = true;
		} else {
			prepared = false;
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	file	
	 */
	protected void extractContent(Path file) {
		/* PROTECTED REGION ID(java.implementation._0Qg2UA_AEeKuTrE1zpGjjg) ENABLED START */
		// collect to extractors
		Set<LineContentExtractor> extractor = new LinkedHashSet<>();
		for (LineContentPreservable lcp : preservable) {
			LineContentExtractor lce = lcp.getExtractor();
			if (lce.hasExtractableContent(file)) {
				extractor.add(lce);
			}
		}
		// read file line by line
		BufferedReader br = null;
		try {
			br = Files.newBufferedReader(file, Charset.defaultCharset());
			String line = null;
			while ((line = br.readLine()) != null) {
				for (LineContentExtractor lce : extractor) {
					lce.extractContent(line);
				}
			}
		} catch (IOException ioe) {
			logger.error("Error reading file '" + file + "'", ioe);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					logger.error("Error closing file '" + file + "'", e);
				}
			}
		}
		// notify file complete
		for (LineContentExtractor lce : extractor) {
			lce.finished(true);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	file	
	 */
	protected void includeContent(Path file) {
		/* PROTECTED REGION ID(java.implementation._1oeHwA_AEeKuTrE1zpGjjg) ENABLED START */
		List<String> fileContent = new LinkedList<>();
		// read file line by line into buffer
		BufferedReader br = null;
		try {
			br = Files.newBufferedReader(file, Charset.defaultCharset());
			String line = null;
			while ((line = br.readLine()) != null) {
				fileContent.add(line);
			}
		} catch (IOException ioe) {
			logger.error("Error reading file '" + file + "'", ioe);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					logger.error("Error closing file '" + file + "'", e);
				}
			}
		}
		// delegate to includers
		for (LineContentPreservable lcp : preservable) {
			ContentIncluder cl = lcp.getIncluder();
			fileContent = cl.includeContent(fileContent);
		}
		// write file content to file
		BufferedWriter bw = null;
		try {
			bw = Files.newBufferedWriter(file, Charset.defaultCharset());
			for (String s : fileContent) {
				bw.write(s);
				bw.newLine();
			}
		} catch (IOException ioe) {
			logger.error("Error writing to file '" + file + "'", ioe);
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					logger.error("Error closing file '" + file + "'", e);
				}
			}
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * paths relative to output directory that are excluded during the file search.
	 */
	public void addExcludedRelativePaths(String excludedRelativePaths) {
		this.excludedRelativePaths.add(excludedRelativePaths);
	}
	
	/**
	 * paths relative to output directory that are excluded during the file search.
	 */
	public void removeExcludedRelativePaths(String excludedRelativePaths) {
		this.excludedRelativePaths.remove(excludedRelativePaths);
	}
	
	/**
	 * Directory names that are excluded during file search
	 */
	public void addExcludedDirectoryNames(String excludedDirectoryNames) {
		this.excludedDirectoryNames.add(excludedDirectoryNames);
	}
	
	/**
	 * Directory names that are excluded during file search
	 */
	public void removeExcludedDirectoryNames(String excludedDirectoryNames) {
		this.excludedDirectoryNames.remove(excludedDirectoryNames);
	}
	
	// initialization block for association management objects
	{
		association.put(Associations.PRESERVABLE, new ManyAssociation<LineContentPreserving, LineContentPreservable>(this, preservable));
	}
	
	/**
	 * Provides generic access to association objects, used by the association handling library
	 * @see org.genesez.platform.java.umlsupport.associations.AssociationRole#getAssociation(org.genesez.platform.java.umlsupport.associations.modified.RelatedAssociationRole)
	 */
	public Association<? extends Object, ? extends Object> getAssociation(RelatedAssociationRole role) {
		if (association.containsKey(role))
			return association.get(role);
		throw new RuntimeException("the class doesn't have the association you specified!");
	}
	
	/**
	 * Provides access to the association '<em><b>preservable</b></em>' to {@link LineContentPreservable}.
	 */
	@SuppressWarnings("unchecked")
	public Association<LineContentPreserving, LineContentPreservable> preservable() {
		return (Association<LineContentPreserving, LineContentPreservable>) association.get(Associations.PRESERVABLE);
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._jnWBUA7TEeKSL4xN3YIZZg) ENABLED START */
	/* PROTECTED REGION END */
	
}
