package de.genesez.platforms.common;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import de.genesez.platforms.common.revisioncontrol.RegisterHelper;
import de.genesez.platforms.common.revisioncontrol.RevisionControlSystem;
import de.genesez.platforms.common.workflow.WorkflowUtils;

/**
 * The Deletor handles the deletion of unchanged files during the generation
 * process. With the filter-options the search can be specified. It's also
 * possible to delete empty packages.
 * 
 * NOTE: Works only with Java 7.
 * 
 * @author Dominik Wetzel
 * @date 2011-09-15
 * 
 */
public class Deletor extends SimpleFileVisitor<Path> {

	private List<String> includedFiles = new LinkedList<String>();
	private List<String> excludedFiles = new LinkedList<String>();
	private List<String> excludedRelativePaths = new LinkedList<String>();
	private List<String> excludedDirectoryNames = new LinkedList<String>();

	private Map<String, Long> oldFiles = new LinkedHashMap<String, Long>();
	private boolean prepared = false;
	private Path outputPath;
	private List<RevisionControlSystem> repos = RegisterHelper
			.getAvailableRepositoryImpls();
	private RevisionControlSystem revisionSystem = null;

	private Map<String, Long> fileMap = new LinkedHashMap<String, Long>();

	// private static final Deletor deletor = new Deletor();
	private String repositoryFolderName = "";

	/**
	 * Constructs the singleton
	 */
	public Deletor() {
	}

	// public static Deletor getInstance() {
	// return deletor;
	// }

	/**
	 * checks which revision control system is used. Therefore it checks if a
	 * folder starts with a dot and than checks if its one of the registered
	 * control systems.
	 * 
	 * @param path the startPath where the search begins (usually the outputDir)
	 * @return the name of the found revision control system.
	 * @return "" (empty String) if no System was found
	 * @return "Not supported" if a System was found but its not supported
	 * @return null if 2 different systems where found.
	 */
	public String checkRepository(String path) {
		outputPath = Paths.get(path);
		try {
			Files.walkFileTree(outputPath, new SimpleFileVisitor<Path>() {
				
				/**
				 * looks if the directory is a metadata folder. (if its starts with a dot)
				 * @param dir the directory that will be checked
				 * @param attr the basic attributes of the directory.
				 * @return CONTINUE if it does not start with a dot.
				 * @return SKIP_SUBTREE if one metadata folder was found.
				 * @return SKIP_SIBLINGS if an other metadata folder was found.
				 */
				@Override
				public FileVisitResult preVisitDirectory(Path dir,
						BasicFileAttributes attr) throws IOException {
					if (dir.getFileName().toString().startsWith(".")) {
						if (repositoryFolderName.length() > 0
								&& !(dir.getFileName().toString()
										.equals(repositoryFolderName))) {
							repos = null;
							return FileVisitResult.SKIP_SIBLINGS;
						}
						repositoryFolderName = dir.getFileName().toString();
						return FileVisitResult.SKIP_SUBTREE;
					}
					return FileVisitResult.CONTINUE;
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Case 1: found 2 different repositories --> fail
		if (repos == null) {
			return null;
		}
		if (repositoryFolderName.length() > 0) {
			for (RevisionControlSystem rep : repos) {
				for (String metadataFolderName : rep.getMetadataFolderNames()) {
					if (metadataFolderName.equals(repositoryFolderName)) {
						revisionSystem = rep;
						// Case 2: revisionSystem found
						excludedDirectoryNames.add(repositoryFolderName);
						return revisionSystem.getName();
					}
				}
			}
			// Case 3: revisionSystem found but not supported
			return "Not supported";
		}
		// Case 4: no revision System found
		return "";
	}

	/**
	 * Prepares the deletion of Files. Needs to be called before delete.
	 * Searches for files in the directories under path and stores the last
	 * modification dates in a map. The search uses the given filters.
	 * 
	 * @param path
	 *            The startPath, where the search begins
	 * 
	 * @return number of elements in the map
	 */
	public int prepare(String path) {
		outputPath = Paths.get(path);
		return prepare();
	}

	/**
	 * Prepares the deletion of Files. Needs to be called before delete.
	 * Searches for files in the directories under path and stores the last
	 * modification dates in a map. The search uses the given filters.
	 * 
	 * @return number of elements in the map
	 */
	public int prepare() {
		try {
			Files.walkFileTree(outputPath, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		oldFiles.clear();
		oldFiles.putAll(fileMap);
		fileMap.clear();
		prepared = true;
		return oldFiles.size();
	}

	/**
	 * deletes the unchanged files. Therefore it searches again and compares the
	 * last modification dates.
	 * 
	 * @return List with deleted Elements
	 * @throws NotPreparedException
	 *             if prepare wasn't called before
	 */
	public List<String> delete() throws NotPreparedException {
		if (prepared) {
			try {
				Files.walkFileTree(outputPath, this);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return deleteOldFiles(oldFiles);
		} else {
			throw new NotPreparedException("prepare() was not called before");
		}
	}

	/**
	 * deletes empty packages (folders) in the given directory, uses the
	 * specified filters: excludedRelativePaths and excludedDirectoryNames.<br>
	 * 
	 * @param path
	 *            the path where the search will begin (should be the Output
	 *            directory)
	 * @return a list with all deleted folders
	 * @throws UnsupportedOperationException
	 *             is thrown when the JRE version is below 7
	 */
	public List<String> deleteEmptyPackages(String path) {
		final List<String> log = new LinkedList<String>();

		try {
			Files.walkFileTree(Paths.get(path), new SimpleFileVisitor<Path>() {

				/**
				 * checks if the current directory is excluded using
				 * excludedRelativePaths and excludedDirectoryNames
				 * 
				 * @param dir
				 *            the directory, that is checked
				 * @param attrs
				 *            the directory's basic attributes
				 * @returns SKIP_SUBTREE if excluded, else CONTINUE
				 * @throws IOException
				 *             if IO-Error occurs
				 */
				@Override
				public FileVisitResult preVisitDirectory(Path dir,
						BasicFileAttributes attrs) throws IOException {
					for (String s : excludedRelativePaths) {
						if (dir.startsWith(Paths.get(s))) {
							return FileVisitResult.SKIP_SUBTREE;
						}
					}
					for (String s : excludedDirectoryNames) {
						if (dir.toString().endsWith(s)) {
							return FileVisitResult.SKIP_SUBTREE;
						}
					}
					return FileVisitResult.CONTINUE;
				}

				/**
				 * After it visits the directory the method checks, whether its
				 * empty or not and deletes it if its empty. Also repository
				 * folder will be delete if it is the only one left
				 * 
				 * @param dir
				 *            directory that is checked
				 * @param null if the iteration of the directory completes
				 *        without an error; otherwise the I/O exception that
				 *        caused the iteration of the directory to complete
				 *        prematurely
				 * @return CONTINUE
				 * @throws IOException
				 *             if IO-Error occurs
				 */
				@Override
				public FileVisitResult postVisitDirectory(Path dir,
						IOException exc) throws IOException {

					// try(DirectoryStream<Path> stream = Files
					// .newDirectoryStream(dir)){
					DirectoryStream<Path> stream = Files
							.newDirectoryStream(dir);

					java.util.Iterator<Path> streamIter = stream.iterator();

					if (streamIter.hasNext()) {
						Path subfolder = streamIter.next();
						// looks if the repository folder is the
						// only folder in this directory
						if (repositoryFolderName.length() > 0) {
							if (!streamIter.hasNext()
									&& subfolder.endsWith(repositoryFolderName)
									&& Files.isDirectory(subfolder)) {
								// deletes the folder
								revisionSystem.delete(dir.toString());
								log.add(dir.toString());
							}
						}
					} else {
						Files.delete(dir);
						log.add(dir.toString());
					}
					// } catch (DirectoryIteratorException ex){
					// ex.printStackTrace();
					// }
					if (stream != null) {
						stream.close();
					}
					return FileVisitResult.CONTINUE;
				}
			});
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return log;
	}

	/**
	 * Sets files that will be included in the search. <br>
	 * NOTE: Only files with these extensions will be included.
	 * 
	 * @param extensions
	 *            the IncludedFileExtension String contains all included Files
	 *            in a single String (separated by "," or ";")
	 */
	public void setIncludedFiles(String extensions) {

		includedFiles = WorkflowUtils.split(extensions);

	}

	/**
	 * Sets files that will be excluded in the search.
	 * 
	 * @param extensions
	 *            the ExcludedFileExtension String contains all excluded Files
	 *            in a single String (separated by "," or ";")
	 */
	public void setExcludedFiles(String extensions) {

		excludedFiles = WorkflowUtils.split(extensions);

	}

	/**
	 * Sets RelativPaths (to the OutputDirectory) which will be excluded in the
	 * search.
	 * 
	 * @param paths
	 *            contains all excluded Paths in a single String (separated by
	 *            "," or ";")
	 */
	public void setExcludedRelativePaths(String paths) {
		excludedRelativePaths = WorkflowUtils.split(paths);
		for (int i = 0; i < excludedRelativePaths.size(); i++) {
			String s = excludedRelativePaths.get(i);
			if (!s.startsWith(".")) {
				s = ".".concat(s);
			} else if (!s.startsWith("./")) {
				s = "./".concat(s);
			}
			if (!s.startsWith(".\\")) {
				if (!s.startsWith("./")) {
					s = s.replaceFirst(".", "./");
				}
			}
			excludedRelativePaths.set(i, Paths.get(s).toString());

		}
	}

	/**
	 * Sets directory names that are excluded in the search. <br>
	 * NOTE: Every directory with the same spelling will be excluded.
	 * 
	 * @param names
	 *            contains all Names that are excluded (separated by "," or ";")
	 */
	public void setExcludedDirectoryNames(String names) {
		excludedDirectoryNames = WorkflowUtils.split(names);
	}

	/**
	 * Compares the last modification date of the files found in path with the
	 * files in the given map. If the last modification date didn't change the
	 * file will be deleted (runs only with Java7)
	 * 
	 * @param oldFiles
	 *            map with the oldFiles to compare with
	 * @return list with deleted paths
	 */
	private List<String> deleteOldFiles(Map<String, Long> oldFiles) {
		List<String> logged = new LinkedList<String>();
		Set<String> check = fileMap.keySet();
		for (String s : check) {
			if (oldFiles.containsKey(s)) {

				if (fileMap.get(s).equals(oldFiles.get(s))) {
					logged.add(s.toString());
					if (revisionSystem != null) {
						revisionSystem.delete(s);
					} else {
						try {
							Files.delete(Paths.get(s));
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		fileMap.clear();
		return logged;
	}

	/**
	 * Is invoked by walkFileTree. Checks if the file is excluded or included in
	 * the search. Puts included files into the filemap.
	 * 
	 * @param file
	 *            a reference to the file
	 * @param attrs
	 *            the file's basic attributes
	 * @return CONTINUE if everything worked.
	 * @throws IOException
	 *             if something went wrong
	 */
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		if (!(excludedFiles.size() == 1 && excludedFiles.get(0).equals(""))) {
			for (String s : excludedFiles) {
				if (file.toString().endsWith(s)) {
					return FileVisitResult.CONTINUE;
				}
			}
		}
		if (!includedFiles.isEmpty()) {
			for (String s : includedFiles) {
				if (file.toString().endsWith(s)) {
					fileMap.put(file.toString(), Files
							.getLastModifiedTime(file).toMillis());
				}
			}
		} else {
			fileMap.put(file.toString(), Files.getLastModifiedTime(file)
					.toMillis());
		}
		return FileVisitResult.CONTINUE;
	}

	/**
	 * Is invoked by walkFileTree. If the path starts with a phrase from the
	 * excludedRelativePaths or is in excludedDirectoryNames the directory will
	 * be skipped in the search.
	 * 
	 * @param dir
	 *            a reference to the directory
	 * @param attrs
	 *            the directory's basic attributes
	 * @return CONTINUE if its not excluded else SKIP_SUBTREE
	 */
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
		if (!(excludedRelativePaths.size() == 1 && excludedRelativePaths.get(0)
				.equals(""))) {
			for (String s : excludedRelativePaths) {
				if (dir.startsWith(Paths.get(s))) {
					return FileVisitResult.SKIP_SUBTREE;
				}
			}
		}
		if (!(excludedDirectoryNames.size() == 1 && excludedDirectoryNames.get(
				0).equals(""))) {
			for (String s : excludedDirectoryNames) {
				if (dir.endsWith(s)) {
					return FileVisitResult.SKIP_SUBTREE;
				}
			}
		}
		return FileVisitResult.CONTINUE;
	}

	/**
	 * The NotPreparedException is thrown, if prepare() wasn't called before
	 * delete()
	 * 
	 * @author Dominik Wetzel
	 * 
	 */
	protected class NotPreparedException extends RuntimeException {
		private static final long serialVersionUID = -1871632509826762886L;

		public NotPreparedException(String message) {
			super(message);
		}

	}

}
