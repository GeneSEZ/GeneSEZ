package de.genesez.platforms.common;

import java.nio.file.Path;

/**
 * An adapter with default implementation of the FileTreeObserver, this is used
 * because not every Observer needs every update method. It is also easier to
 * extend this.
 * 
 * @author Dominik Wetzel
 * @date 2011-10-12
 */
public class FileTreeObserverAdapter implements FileTreeObserver {

	@Override
	public void updateComplete() {
		// does nothing
	}

	@Override
	public void updateFileVisit(Path file) {
		// does nothing
	}

	@Override
	public void updateFileVisitFailed(Path file) {
		// does nothing
	}

	@Override
	public void updateBeforeDir(Path file) {
		// does nothing
	}

	@Override
	public void updateAfterDir(Path file) {
		// does nothing
	}

}
