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

/**
 * A FileVisitor that walks the given FileTree
 * 
 * @prePrior 1
 * @postPrior 10 + ((FTW instances from workflow) * 20)
 * 
 * @author Dominik Wetzel
 * 
 */
public class FileTreeWalkerFeature implements FileVisitor<Path>,
		GeneratorFeature {

	private static int currentWalker = 0;

	private Path start;
	// The observers
	private Set<FileTreeObserver> observer = new LinkedHashSet<FileTreeObserver>();
	private long time = 0;

	/**
	 * The Log instance for this object
	 */
	protected Log logger = LogFactory.getLog(getClass());

	private String outputDir = "";

	private int postPriority;
	private int prePriority = 1;

	/**
	 * Constructs the FTW. Calculates priority in post-list
	 */
	public FileTreeWalkerFeature() {
		postPriority = 10 + (++currentWalker * 20);
	}

	/**
	 * Constructs the FTW with given priorities.
	 * @param pre priority in pre-list
	 * @param post priority in post-list
	 */
	public FileTreeWalkerFeature(int pre, int post) {
		this.prePriority = pre;
		this.postPriority = post;
	}

	/**
	 * starts the fileTree walk
	 * 
	 * @param path
	 *            the path where the walk starts
	 */
	private void walkTree(String path) {
		try {
			time = System.currentTimeMillis();
			Files.walkFileTree(Paths.get(path), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Invoked for a directory after entries in the directory, and all of their
	 * descendants, have been visited. This method is also invoked when
	 * iteration of the directory completes prematurely (by an I/O error when
	 * iterating over the directory). Passes FileEvent.AFTER_DIR to the
	 * observers. If file tree completely walked it passes also
	 * FileEvent.COMPLETED to the observers.
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
		notifyObserver(FileEvent.AFTER_DIR, dir);
		if (start != null && start.equals(dir)) {
			notifyObserver(FileEvent.COMPLETED, dir);
			start = null;
			time = System.currentTimeMillis() - time;
			logger.debug("file tree walk finished in " + (time / 1000.0) + "s");
		}
		return FileVisitResult.CONTINUE;

	}

	/**
	 * Invoked for a directory before entries in the directory are visited.
	 * Passes FileEvent.BEFORE_DIR to the observers.
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
		if (start == null) {
			start = dir;
		}
		notifyObserver(FileEvent.BEFORE_DIR, dir);
		return FileVisitResult.CONTINUE;
	}

	/**
	 * Invoked for a file in a directory. Passes FileEvent.FILE_VISIT to the
	 * observers
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
		notifyObserver(FileEvent.FILE_VISIT, file);
		return FileVisitResult.CONTINUE;
	}

	/**
	 * Invoked for a file that could not be visited. This method is invoked if
	 * the file's attributes could not be read, the file is a directory that
	 * could not be opened, and other reasons. Passes FileEvent ACCESS_FAILED to
	 * the observers.
	 * 
	 * @param file
	 *            a reference to the file
	 * @param exc
	 *            the I/O exception that prevented the file from being visited
	 * @return CONTINUE
	 */
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc)
			throws IOException {
		notifyObserver(FileEvent.ACCESS_FAILED, file);
		return FileVisitResult.CONTINUE;
	}

	/**
	 * Registers an observer in the list of observers.
	 * 
	 * @param observer
	 *            the observer to be added
	 */
	public boolean registerObserver(FileTreeObserver observer) {
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
	 * Notifies all observers with an event
	 * 
	 * @param event
	 *            the event thats given
	 * @param file
	 *            the file, were the event was called from
	 */
	private void notifyObserver(FileEvent event, Path file) {
		for (FileTreeObserver ob : observer) {
			ob.update(event, file);
		}
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
		outputDir = properties.getProperty("outputDir");
	}

	/**
	 * checks Configuration.
	 * 
	 * @throws IllegalArgumentException
	 *             if no output directory was given
	 */
	@Override
	public void checkConfiguration() throws IllegalArgumentException {
		if (outputDir.isEmpty()) {
			throw new IllegalArgumentException("No output directory given.");
		}
	}

	/**
	 * file tree walk before generation. Runs only if at least 1 observer is registered.
	 */
	@Override
	public void pre() {
		if (countObservers() > 0) {
			walkTree(outputDir);
			this.unregisterAllObserver();
		}
	}

	/**
	 * file tree walk after generation. Runs only if at least 1 observer is registered.
	 */
	@Override
	public void post() throws NotPreparedException {
		this.pre();
	}

	/**
	 * gets priority in pre-list
	 * @return prePriority
	 */
	@Override
	public int getPrePriority() {
		return prePriority;
	}

	/**
	 * gets priority in post-list
	 * @return postPriority
	 */
	@Override
	public int getPostPriority() {
		return postPriority;
	}

//	@Override
//	public boolean changeFileTree() {
//		return false;
//	}

	/**
	 * Sets priority in pre-list
	 * @param priority prePriority
	 */
	@Override
	public void setPrePriority(int priority) {
		this.prePriority = priority;
	}

	/**
	 * Sets priority in post-list
	 * @param priority postPriority
	 */
	@Override
	public void setPostPriority(int priority) {
		this.postPriority = priority;
	}
	
	/**
	 * Enumeration for different File Events
	 * 
	 * @author Dominik Wetzel
	 */
	public enum FileEvent {

		/**
		 * Directory not visited yet
		 */
		BEFORE_DIR,

		/**
		 * Directory already visited
		 */
		AFTER_DIR,

		/**
		 * File currently visited
		 */
		FILE_VISIT,

		/**
		 * if access to file failed.
		 */
		ACCESS_FAILED,

		/**
		 * tree walk completed
		 */
		COMPLETED;
	}
	
//	@Override
//	public boolean needsPreWalk(){
//		return false;
//	}
//	
//	@Override
//	public boolean needsPostWalk(){
//		return false;
//	}
//
//	@Override
//	public boolean changesPreFileTree() {
//		return false;
//	}
//
//	@Override
//	public boolean changesPostFileTree() {
//		return false;
//	}

}
