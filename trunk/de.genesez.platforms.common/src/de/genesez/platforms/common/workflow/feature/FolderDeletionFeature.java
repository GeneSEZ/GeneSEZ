package de.genesez.platforms.common.workflow.feature;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.genesez.platforms.common.FileTreeObserver;
import de.genesez.platforms.common.revisioncontrol.RevisionControlSystem;
import de.genesez.platforms.common.workflow.feature.FileTreeWalkerFeature.FileEvent;

/**
 * Does the deletion of empty packages, it should run after generation and deletion
 * @prePrior 0
 * @postPrior 40
 * 
 * @author Dominik Wetzel
 *
 */
public class FolderDeletionFeature extends DeletionFeature implements
		GeneratorFeature, FileTreeObserver {

	/**
	 * Logger instance to output important messages.
	 */
	protected Log logger = LogFactory.getLog(getClass());

	// The switches for deletion
	private boolean deleteEmptyFolders = true;

	// The trigger for the NotPreparedException
	private boolean prepared = false;

	private List<Path> emptyFolders = new ArrayList<Path>();

	/**
	 * Constructor, sets postPriority to 40
	 */
	public FolderDeletionFeature() {
		postPriority = 40;
	}

	// Methods from the Interface //

	/**
	 * checks if file is a Repository folder, or an Empty folder.
	 * Prepares the deletion of empty packages
	 * 
	 * @param event
	 *            the event from FileTreeWalker
	 * @param file
	 *            the directory that will be checked
	 */
	@Override
	public void update(FileEvent event, Path file) {
		if (deleteEmptyFolders) {
			if (event.equals(FileEvent.BEFORE_DIR)) {
				super.checkRepository(file);
			} else if (event.equals(FileEvent.AFTER_DIR) && deleteEmptyFolders) {
				// prepare package deletion
				prepareDeleteEmptyPackages(file);
			} else if (event.equals(FileEvent.COMPLETED)) {
				// log revision Systems
				try {
					super.checksAbove(file.toRealPath());
				} catch (IOException e) {
					e.printStackTrace();
				}
				super.update(event, file);
				prepared = true;
			}
		}
	}

	/**
	 * Checks the configuration. Disables folder deletion if no outputDir was
	 * given.
	 */
	@Override
	public void checkConfiguration() {
		if (super.outputPath == null || super.outputPath.toString().isEmpty()) {
			deleteEmptyFolders = false;
			logger.info("No output directory given. Folder deletion is deactivated.");
		}
		if (deleteEmptyFolders) {
			logger.info("Folder deletion activated. Empty folders will be deleted.");
		}
	}

	/**
	 * Called before generation. Does nothing
	 */
	@Override
	public void pre() {
		// nothing to do
	}

	/**
	 * Deletes empty Folders from found revision control system and if possible
	 * from the file system.
	 */
	@Override
	public void post() throws NotPreparedException {
		if (deleteEmptyFolders) {
			if (prepared) {
				long time = System.currentTimeMillis();
				List<String> log = deleteEmptyPackages();
				time = System.currentTimeMillis() - time;
				logger.info(log.size() + " folder(s) deleted.");
				logger.debug("Deleted folders: " + log);
				logger.debug("Folder deletion took: " + (time / 1000.0) + "s");
			} else {
				throw new NotPreparedException(
						"Folder deletion is not prepared properly.");
			}
		}
	}

	// Setter Methods //

	// /**
	// * Setter for the workflow parameter <em><b>deleteEmptyFolders</b></em>.
	// *
	// * if this is true, empty folders will be deleted after generation process
	// *
	// * @param deleteEmpty
	// */
	// protected void setDeleteEmptyFolders(String deleteEmpty) {
	// this.deleteEmptyFolders = Boolean.parseBoolean(deleteEmpty);
	// }

	/**
	 * Prepares deletion of empty packages (folders). It checks whether the
	 * subfolders are empty or not and stores the folder paths if its empty.
	 * 
	 * @param dir
	 *            the current directory that will be checked
	 * @return a list with all deleted folders
	 */
	protected void prepareDeleteEmptyPackages(Path dir) {
		// is directory excluded?
		for (String exclDirName : super.excludedDirectoryNames) {
			if (dir.endsWith(exclDirName)
					|| dir.toString().matches(
							".*[\\\\|/]" + exclDirName + "[\\\\|/].*")) {
				return;
			}
		}
		for (String exclRelPath : super.excludedRelativePaths) {
			if (dir.startsWith(exclRelPath)) {
				return;
			}
		}
		// get subfiles and count of subfiles
		int size = 0;
		List<File> files = new LinkedList<File>();
		if (Files.exists(dir) && Files.isDirectory(dir)) {
			files = Arrays.asList(dir.toFile().listFiles());
			size = files.size();
		}
		// number of not empty files in the directory
		int notEmptyFolders = size;

		for (int i = 0; i < size; i++) {
			Path subfolder = files.get(i).toPath();
			if (Files.isDirectory(subfolder)) {
				boolean toBreak = false;
				// if metadata folder "number of not empty files" -1
				for (RevisionControlSystem rep : super.getRevisionSystems()) {
					if (subfolder.endsWith(rep.getMetadataFolderName())) {
						notEmptyFolders--;
						toBreak = true;
						break;
					}
				}
				if (toBreak) {
					continue;
				}
				if (emptyFolders.contains(subfolder)) {
					notEmptyFolders--;
				}
			} else {
				break;
			}
		}

		if (notEmptyFolders == 0) {
			emptyFolders.add(dir);
		}
	}

	/**
	 * deletes previously found empty folders
	 * 
	 * @return list with deleted folders
	 */
	protected List<String> deleteEmptyPackages() {
		List<String> list = new LinkedList<String>();
		for (Path dir : emptyFolders) {
			for (RevisionControlSystem rep : super.getRevisionSystems()) {
				rep.markForDelete(dir.toString());
			}
			// delete all folders normal if possible
			if (Files.exists(dir) && dir.toFile().listFiles().length == 0) {
				try {
					super.alterPermission(dir);
					Files.delete(dir);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			list.add(dir.toString());
		}
		emptyFolders.clear();
		return list;
	}
	
//	@Override
//	public boolean needsPreWalk(){
//		return false;
//	}
//	
//	@Override
//	public boolean needsPostWalk(){
//		return true;
//	}
}
