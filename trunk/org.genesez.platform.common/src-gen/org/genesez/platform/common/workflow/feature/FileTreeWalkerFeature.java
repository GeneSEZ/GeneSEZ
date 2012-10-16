package org.genesez.platform.common.workflow.feature;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1317371963849_784629_1682) 
 */

import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Paths;
import org.apache.commons.logging.LogFactory;
import java.util.LinkedHashSet;
import org.apache.commons.logging.Log;
import java.util.Properties;
import java.nio.file.FileVisitResult;

import org.genesez.platform.common.FileTreeObserver;

import java.nio.file.FileVisitor;

/**
 * A FileVisitor that walks the given FileTree and calls the update methods on its Observers.
 * 
 * @author Dominik Wetzel
 * @date 2011-10-11
 * @deprecated
 */
public class FileTreeWalkerFeature implements PreFeature, PostFeature, FileVisitor<Path> {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * the observers
	 */
	
	private java.util.Set<FileTreeObserver> observers = new LinkedHashSet<FileTreeObserver>();
	
	private boolean runAborted = false;
	
	/**
	 * The Log instance for this object
	 */
	protected Log logger = LogFactory.getLog(getClass());
	
	private Path searchedDir = null;
	
	private Properties properties = new Properties();
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Sets the properties <br>
	 * outputDir - the Output Directory which should be searched <br>
	 * @param	properties	the Properties-Map with the properties.
	 */
	
	public void setProperties(Properties properties) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1317372026187_502649_1717) ENABLED START */
		if (searchedDir == null) {
			setSearchedDir(properties.getProperty("outputDir"));
		}
		for (FileTreeObserver ob : observers) {
			ob.setFileTreeWalkerProperties(this.properties);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * checks the configuration
	 * @throws IllegalArgumentException if no output directory was given.
	 */
	
	public void checkConfiguration() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1317372043269_41178_1721) ENABLED START */
		if (searchedDir == null || searchedDir.toString().isEmpty()) {
			runAborted = true;
			throw new IllegalArgumentException("No output directory given.");
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	dir	
	 */
	
	public void setSearchedDir(String dir) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1320141198468_687882_1906) ENABLED START */
		this.searchedDir = Paths.get(dir);
		properties.setProperty("searchedDir", dir);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Registers an observer in the list of observers.
	 * @param	ob	the observer to be added.
	 * @return	true if observer could be added false if not or already in set.
	 */
	public boolean addObserver(FileTreeObserver ob) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1317373779115_316974_2269) ENABLED START */
		return this.observers.add(ob);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Unregisters an observer of the list of observers.
	 * @param	ob	the observer to be removed
	 * @return	true if remove worked, false if something went wrong
	 */
	public boolean unregisterObserver(FileTreeObserver ob) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1317373789255_938031_2272) ENABLED START */
		return this.observers.remove(ob);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Unregisters all currently used observers.
	 */
	
	public void unregisterAllObservers() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318234095884_47525_2340) ENABLED START */
		this.observers.clear();
		/* PROTECTED REGION END */
	}
	
	/**
	 * counts the observers.
	 * @return	size of observer set.
	 */
	public int countObservers() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318594489751_355090_3587) ENABLED START */
		return observers.size();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Invoked for a directory after entries in the directory, and all of their descendants, have been visited. This method is also invoked when iteration of the directory completes prematurely (by an I/O error when iterating over the directory). Calls updateAfterDir() on the observers.
	 * 
	 * @throws IOException if IO-Error occurs
	 * @param	dir	a reference to the directory
	 * @param	exc	null if the iteration of the directory completes without an error; otherwise the I/O exception that caused the iteration of the directory to complete prematurely.
	 * @return	CONTINUE
	 * @throws	IOException
	 */
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318594093469_451981_3559) ENABLED START */
		notifyObserverAfterDir(dir);
		return FileVisitResult.CONTINUE;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Invoked for a directory before entries in the directory are visited. Calls updateBeforeDir() on the observers 
	 * 
	 * @throws IOException if IO-Error occurs
	 * @param	dir	a reference to the directory
	 * @param	attrs	the directory's basic attributes
	 * @return	CONTINUE
	 * @throws	IOException
	 */
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318594227710_896047_3564) ENABLED START */
		notifyObserverBeforeDir(dir);
		return FileVisitResult.CONTINUE;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Invoked for a file in a directory. Calls updateFileVisit() on the observers.
	 * 
	 * @throws IOException if IO-Error occurs
	 * @param	file	a reference to the file
	 * @param	attrs	the file's basic attributes.
	 * @return	CONTINUE
	 * @throws	IOException
	 */
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318594274673_607479_3569) ENABLED START */
		notifyObserverFileVisit(file);
		return FileVisitResult.CONTINUE;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Invoked for a file that could not be visited. This method is invoked if the file's attributes could not be read, the file is a directory that could not be opened, and other reasons. Calls updateFileVisitFailed() on the observers.
	 * 
	 * @throws IOException if an I/O-Error occurs
	 * @param	file	a reference to the file
	 * @param	exc	the I/O exception that prevented the file from being visited.
	 * @return	
	 * @throws	IOException
	 */
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318594320989_664620_3573) ENABLED START */
		notifyObserverFileVisitFailed(file);
		return FileVisitResult.CONTINUE;
		/* PROTECTED REGION END */
	}
	
	/**
	 * file tree walk before generation. Runs only if at least 1 observer is registered.
	 */
	
	public void invokePre() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1317371981305_162532_1703) ENABLED START */
		if (countObservers() > 0) {
			walkTree(searchedDir);
			this.unregisterAllObservers();
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * file tree walk after generation. Runs only if at least 1 observer is registered.
	 */
	
	public void invokePost() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1317371987280_645704_1706) ENABLED START */
		this.invokePre();
		/* PROTECTED REGION END */
	}
	
	/**
	 * starts the fileTree walk. Calls updateComplete() on the observers after complete FileTreeWalk
	 * @param	path	the path where the walk starts.
	 */
	
	private void walkTree(Path path) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1317373795355_437846_2275) ENABLED START */
		if (!runAborted) {
			long time = System.currentTimeMillis();
			try {
				Files.walkFileTree(path, this);
				notifyObserverComplete();
			} catch (IOException e) {
				e.printStackTrace();
			}
			time = System.currentTimeMillis() - time;
			logger.debug("file tree walk finished in " + (time / 1000.0) + "s");
		} else {
			logger.info("Run was aborted because no output directory was given.");
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Notifies all observers with updateBeforeDir.
	 * @param	dir	the directory were the event was called from
	 */
	
	private void notifyObserverBeforeDir(Path dir) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1317371972304_391373_1700) ENABLED START */
		for (FileTreeObserver ob : observers) {
			ob.updateBeforeDir(dir);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Notifies all observers with updateAfterDir
	 * @param	dir	the directory were the event was called from.
	 */
	
	private void notifyObserverAfterDir(Path dir) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318233852211_798040_2294) ENABLED START */
		for (FileTreeObserver ob : observers) {
			ob.updateAfterDir(dir);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Notifies all observers with updateFileVisit
	 * @param	file	the file, were the event was called from
	 */
	
	private void notifyObserverFileVisit(Path file) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318233863677_311883_2300) ENABLED START */
		for (FileTreeObserver ob : observers) {
			ob.updateFileVisit(file);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Notifies all observers with updateFileVisitFailed
	 * @param	file	the file, were the event was called from.
	 */
	
	private void notifyObserverFileVisitFailed(Path file) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318233876344_896198_2303) ENABLED START */
		for (FileTreeObserver ob : observers) {
			ob.updateFileVisitFailed(file);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Notifies all observers with updateComplete
	 */
	
	private void notifyObserverComplete() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318233858748_796685_2297) ENABLED START */
		for (FileTreeObserver ob : observers) {
			ob.updateComplete();
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1317371963849_784629_1682) ENABLED START */
	/* PROTECTED REGION END */
	
}
