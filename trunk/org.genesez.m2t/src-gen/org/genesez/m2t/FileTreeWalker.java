package org.genesez.m2t;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_Y_wQKQD0EeK7ac-mrkJBDw) 
 */

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * A FileVisitor that walks the given FileTree and calls the update methods on its Observers.
 * 
 * @author Dominik Wetzel
 * @author dreamer
 */
public class FileTreeWalker implements FileVisitor<Path> {
	
	// -- generated attribute, constant + association declarations ----------
	
	public final Log logger = LogFactory.getLog(getClass());
	
	/**
	 * the observers
	 */
	private java.util.Set<FileTreeObserver> observer = new java.util.LinkedHashSet<FileTreeObserver>();
	
	private String baseDir;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Unregisters all currently used observers.
	 */
	public void removeAllObserver() {
		/* PROTECTED REGION ID(java.implementation._Y_wQUAD0EeK7ac-mrkJBDw) ENABLED START */
		observer.clear();
		/* PROTECTED REGION END */
	}
	
	/**
	 * counts the observers.
	 * @return	size of observer set.
	 */
	public int countObservers() {
		/* PROTECTED REGION ID(java.implementation._Y_wQUgD0EeK7ac-mrkJBDw) ENABLED START */
		return observer.size();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public void walkFileTree() {
		/* PROTECTED REGION ID(java.implementation._wiLKYASeEeKUpcpqfZ9tsA) ENABLED START */
		if (baseDir == null || baseDir.isEmpty()) {
			throw new IllegalArgumentException("Missing base directory to walk!");
		}
		if (observer.isEmpty()) {
			return;
		}
		Path dir = Paths.get(baseDir);
		walkTree(dir);
		// remove all observers ?
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
		/* PROTECTED REGION ID(java.implementation._Y_wQXgD0EeK7ac-mrkJBDw) ENABLED START */
		notifyObserverBeforeDir(dir);
		return FileVisitResult.CONTINUE;
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
		/* PROTECTED REGION ID(java.implementation._Y_wQVgD0EeK7ac-mrkJBDw) ENABLED START */
		notifyObserverAfterDir(dir);
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
		/* PROTECTED REGION ID(java.implementation._Y_wQZgD0EeK7ac-mrkJBDw) ENABLED START */
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
		/* PROTECTED REGION ID(java.implementation._Y_wQbgD0EeK7ac-mrkJBDw) ENABLED START */
		notifyObserverFileVisitFailed(file);
		return FileVisitResult.CONTINUE;
		/* PROTECTED REGION END */
	}
	
	/**
	 * starts the fileTree walk. Calls updateComplete() on the observers after complete FileTreeWalk
	 * @param	path	the path where the walk starts.
	 */
	private void walkTree(Path path) {
		/* PROTECTED REGION ID(java.implementation._Y_wQeQD0EeK7ac-mrkJBDw) ENABLED START */
		long time = System.currentTimeMillis();
		try {
			Files.walkFileTree(path, this);
			notifyObserverComplete();
		} catch (IOException e) {
			e.printStackTrace();
		}
		time = System.currentTimeMillis() - time;
		if (logger.isDebugEnabled()) {
			logger.debug("File tree walker finished in " + (time / 1000.0) + "s");
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Notifies all observers with updateBeforeDir.
	 * @param	dir	the directory were the event was called from
	 */
	private void notifyObserverBeforeDir(Path dir) {
		/* PROTECTED REGION ID(java.implementation._Y_wQfQD0EeK7ac-mrkJBDw) ENABLED START */
		for (FileTreeObserver ob : observer) {
			ob.updateBeforeDir(dir);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Notifies all observers with updateAfterDir
	 * @param	dir	the directory were the event was called from.
	 */
	private void notifyObserverAfterDir(Path dir) {
		/* PROTECTED REGION ID(java.implementation._Y_wQgQD0EeK7ac-mrkJBDw) ENABLED START */
		for (FileTreeObserver ob : observer) {
			ob.updateAfterDir(dir);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Notifies all observers with updateFileVisit
	 * @param	file	the file, were the event was called from
	 */
	private void notifyObserverFileVisit(Path file) {
		/* PROTECTED REGION ID(java.implementation._Y_wQhQD0EeK7ac-mrkJBDw) ENABLED START */
		for (FileTreeObserver ob : observer) {
			ob.updateFileVisit(file);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Notifies all observers with updateFileVisitFailed
	 * @param	file	the file, were the event was called from.
	 */
	private void notifyObserverFileVisitFailed(Path file) {
		/* PROTECTED REGION ID(java.implementation._Y_wQiQD0EeK7ac-mrkJBDw) ENABLED START */
		for (FileTreeObserver ob : observer) {
			ob.updateFileVisitFailed(file);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Notifies all observers with updateComplete
	 */
	private void notifyObserverComplete() {
		/* PROTECTED REGION ID(java.implementation._Y_wQjQD0EeK7ac-mrkJBDw) ENABLED START */
		for (FileTreeObserver ob : observer) {
			ob.updateComplete();
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * the observers
	 */
	public void addObserver(FileTreeObserver observer) {
		this.observer.add(observer);
	}
	
	/**
	 * the observers
	 */
	public void removeObserver(FileTreeObserver observer) {
		this.observer.remove(observer);
	}
	
	/**
	 * Sets the value of attribute '<em><b>baseDir</b></em>'
	 */
	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._Y_wQKQD0EeK7ac-mrkJBDw) ENABLED START */
	/* PROTECTED REGION END */
	
}
