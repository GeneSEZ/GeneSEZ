package de.genesez.platforms.common.workflow.feature;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.genesez.platforms.common.FileTreeObserver;
import de.genesez.platforms.common.NotPreparedException;

/**
 * A FileVisitor that walks the given FileTree and calls the update methods on
 * its Observers.
 * 
 * @author Dominik Wetzel
 * @date 2011-10-11
 */
public class FileTreeWalkerFeature implements FileVisitor<Path>, PostFeature,
		PreFeature {

	// The observers
	private Set<FileTreeObserver> observer = new LinkedHashSet<FileTreeObserver>();
	private boolean runAborted = false;

	/**
	 * The Log instance for this object
	 */
	protected Log logger = LogFactory.getLog(getClass());

	private Path outputDir = null;

	/**
	 * starts the fileTree walk. Calls updateComplete() on the observers after
	 * complete FileTreeWalk
	 * 
	 * @param path
	 *            the path where the walk starts
	 */
	private void walkTree(Path path) {
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
	}

	/**
	 * Invoked for a directory after entries in the directory, and all of their
	 * descendants, have been visited. This method is also invoked when
	 * iteration of the directory completes prematurely (by an I/O error when
	 * iterating over the directory). Calls updateAfterDir() on the observers.
	 * 
	 * @param dir
	 *            a reference to the directory
	 * @param exc
	 *            null if the iteration of the directory completes without an
	 *            error; otherwise the I/O exception that caused the iteration
	 *            of the directory to complete prematurely.
	 * @return CONTINUE
	 * @throws IOException
	 *             if IO-Error occurs
	 */
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc)
			throws IOException {
		notifyObserverAfterDir(dir);
		return FileVisitResult.CONTINUE;

	}

	/**
	 * Invoked for a directory before entries in the directory are visited.
	 * Calls updateBeforeDir() on the observers.
	 * 
	 * @param dir
	 *            a reference to the directory
	 * @param attrs
	 *            the directory's basic attributes
	 * @return CONTINUE
	 * @throws IOException
	 *             if IO-Error occurs
	 */
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
			throws IOException {
		notifyObserverBeforeDir(dir);
		return FileVisitResult.CONTINUE;
	}

	/**
	 * Invoked for a file in a directory. Calls updateFileVisit() on the
	 * observers.
	 * 
	 * @param file
	 *            a reference to the file
	 * @param attrs
	 *            the file's basic attributes
	 * @return CONTINUE
	 * @throws IOException
	 *             if IO-Error occurs
	 */
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		notifyObserverFileVisit(file);
		return FileVisitResult.CONTINUE;
	}

	/**
	 * Invoked for a file that could not be visited. This method is invoked if
	 * the file's attributes could not be read, the file is a directory that
	 * could not be opened, and other reasons. Calls updateFileVisitFailed() on
	 * the observers.
	 * 
	 * @param file
	 *            a reference to the file
	 * @param exc
	 *            the I/O exception that prevented the file from being visited
	 * @return CONTINUE
	 * @throws IOException if an I/O-Error occurs
	 */
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc)
			throws IOException {
		notifyObserverFileVisitFailed(file);
		return FileVisitResult.CONTINUE;
	}

	/**
	 * Sets the properties <br>
	 * outputDir - the Output Directory which should be searched <br>
	 * 
	 * @param properties
	 *            the Properties-Map with the properties
	 */
	@Override
	public void setProperties(Properties properties) {
		outputDir = Paths.get(properties.getProperty("outputDir"));
	}

	/**
	 * checks Configuration.
	 * 
	 * @throws IllegalArgumentException
	 *             if no output directory was given
	 */
	@Override
	public void checkConfiguration() throws IllegalArgumentException {
		if (outputDir == null || outputDir.toString().isEmpty()) {
			runAborted = true;
			throw new IllegalArgumentException("No output directory given.");
		}
	}

	/**
	 * file tree walk before generation. Runs only if at least 1 observer is
	 * registered.
	 */
	@Override
	public void invokePre() {
		if (countObservers() > 0) {
			walkTree(outputDir);
			this.unregisterAllObserver();
		}
	}

	/**
	 * file tree walk after generation. Runs only if at least 1 observer is
	 * registered.
	 */
	@Override
	public void invokePost() throws NotPreparedException {
		this.invokePre();
	}

	/**
	 * Registers an observer in the list of observers.
	 * 
	 * @param observer
	 *            the observer to be added
	 */
	public boolean addObserver(FileTreeObserver observer) {
		return this.observer.add(observer);
	}

	/**
	 * Unregisters an observer of the list of observers.
	 * 
	 * @param observer
	 *            the observer to be removed
	 */
	public boolean unregisterObserver(FileTreeObserver observer) {
		return this.observer.remove(observer);
	}

	/**
	 * Unregisters all currently used observers.
	 */
	public void unregisterAllObserver() {
		this.observer.clear();
	}

	/**
	 * counts the observers
	 * 
	 * @return size of observer set
	 */
	public int countObservers() {
		return observer.size();
	}

	/**
	 * Notifies all observers with BeforeDir.
	 * 
	 * @param dir
	 *            the directory were the event was called from
	 */
	private void notifyObserverBeforeDir(Path dir) {
		for (FileTreeObserver ob : observer) {
			ob.updateBeforeDir(dir);
		}
	}

	/**
	 * Notifies all observers with AfterDir
	 * 
	 * @param dir
	 *            the directory were the event was called from
	 */
	private void notifyObserverAfterDir(Path dir) {
		for (FileTreeObserver ob : observer) {
			ob.updateAfterDir(dir);
		}
	}

	/**
	 * Notifies all observers with Complete
	 */
	private void notifyObserverComplete() {
		for (FileTreeObserver ob : observer) {
			ob.updateComplete();
		}
	}

	/**
	 * Notifies all observers with FileVisit
	 * 
	 * @param file
	 *            the file, were the event was called from
	 */
	private void notifyObserverFileVisit(Path file) {
		for (FileTreeObserver ob : observer) {
			ob.updateFileVisit(file);
		}
	}

	/**
	 * Notifies all observers with FileVisitFailed
	 * 
	 * @param file
	 *            the file, were the event was called from
	 */
	private void notifyObserverFileVisitFailed(Path file) {
		for (FileTreeObserver ob : observer) {
			ob.updateFileVisitFailed(file);
		}
	}
}
