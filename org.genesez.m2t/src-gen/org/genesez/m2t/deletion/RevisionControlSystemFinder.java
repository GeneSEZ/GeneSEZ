package org.genesez.m2t.deletion;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_jOF40ATYEeKUpcpqfZ9tsA) 
 */
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.genesez.m2t.FileTreeObserverAdapter;

/**
 * org.eclipse.jgit-1.0.0.201106090707-r.jar
 * svnkit.jar
 */
public class RevisionControlSystemFinder extends FileTreeObserverAdapter {
	
	public static java.util.Set<RevisionControlSystem> available = new java.util.HashSet<RevisionControlSystem>();
	
	public final Log logger = LogFactory.getLog(getClass());
	
	/**
	 * The outputPath, where deletion should take place.
	 */
	protected String baseDir;
	
	/**
	 * Method stub for further implementation.
	 * @param	dir	
	 */
	public void updateBeforeDir(Path dir) {
		/* PROTECTED REGION ID(java.implementation._v2WZ0ATYEeKUpcpqfZ9tsA) ENABLED START */
		for (RevisionControlSystem rep : RevisionControlSystem.REGISTRY) {
			String name = rep.getMetadataFolderName();
			if (dir.endsWith(name)) {
				available.add(rep);
				rep.setRepositoryRoot(dir.toString());
				return;
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public void updateComplete() {
		/* PROTECTED REGION ID(java.implementation.__fn0wATYEeKUpcpqfZ9tsA) ENABLED START */
		try {
			Path current = Paths.get(baseDir).toRealPath();
			checkAbove(current);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (available.isEmpty()) {
			logger.info("No supported revision control system found. None will be used.");
		} else {
			logger.info("Revision control system(s) found: " + available.toString());
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Checks if there is another repository metadata folder above the given path.
	 * @param	folder	
	 */
	private void checkAbove(Path folder) {
		/* PROTECTED REGION ID(java.implementation._ZAIq7QD0EeK7ac-mrkJBDw) ENABLED START */
		// get parent dir of absolute path
		Path parent = folder.getParent();
		if (parent == null) {
			return;
		}
		
		DirectoryStream<Path> stream = null;
		// checks if parent contains a repository metadata folder
		try {
			stream = Files.newDirectoryStream(parent, ".*");
			for (Path dir : stream) {
				for (RevisionControlSystem rep : RevisionControlSystem.REGISTRY) {
					String name = rep.getMetadataFolderName();
					if (dir.endsWith(name)) {
						//						excludedDirectoryNames.add(name);
						available.add(rep);
					}
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.err.println("Something went wrong: " + ioe);
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		checkAbove(parent);
		/* PROTECTED REGION END */
	}
	
	/**
	 * The outputPath, where deletion should take place.
	 */
	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._jOF40ATYEeKUpcpqfZ9tsA) ENABLED START */
	static {
		RevisionControlSystem.REGISTRY.add(new GitRcs());
		RevisionControlSystem.REGISTRY.add(new SubversionRcs());
	}
	/* PROTECTED REGION END */
	
}
