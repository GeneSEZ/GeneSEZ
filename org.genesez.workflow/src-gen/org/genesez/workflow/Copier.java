package org.genesez.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_PXWqsPLLEeGYwYEQM4LYvw) 
 */
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Collections;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.genesez.workflow.profile.WfParameter;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * Provides copying services for files and directories (recursively) based on apache commons io.
 */
public class Copier extends AbstractWorkflowComponent implements WorkflowComponent {
	
	public final Log logger = LogFactory.getLog(getClass());
	
	/**
	 * The source file or directory to copy.
	 */
	@WfParameter(isRequired = true, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String source;
	
	/**
	 * The destination file or directory to copy to.
	 */
	@WfParameter(isRequired = true, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String destination;
	
	/**
	 * A file instance representing the source.
	 */
	private File sourceFile;
	
	/**
	 * A file instance representing the destination.
	 */
	private File destFile;
	
	/**
	 * Method stub for further implementation.
	 */
	public String getLogMessage() {
		/* PROTECTED REGION ID(java.implementation._2zHZIP6tEeGciM7nbRm1bw) ENABLED START */
		return "Copy from '" + source + "' to '" + destination + "'.";
		/* PROTECTED REGION END */
	}
	
	/**
	 * Invokes the execution of the component.
	 * @param	context	The context of workflow execution.
	 * @param	monitor	Instance to report any activity to.
	 * @param	issues	Instance to collect all problems during execution.
	 */
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._nmjWkI_wEeKQUf80QkSPWA) ENABLED START */
		super.invokeInternal(context, monitor, issues);
		try {
			if (sourceFile.isDirectory()) {
				FileUtils.copyDirectory(sourceFile, destFile);
			}
			if (sourceFile.isFile()) {
				FileUtils.copyFile(sourceFile, destFile);
			}
		} catch (IOException e) {
			issues.addError(this, "Error during copy", context, e, Arrays.<Object> asList(sourceFile, destFile));
			e.printStackTrace();
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * The source file or directory to copy.
	 */
	public String getSource() {
		return source;
	}
	
	/**
	 * The source file or directory to copy.
	 * @param	source	the value to set.
	 */
	public void setSource(String source) {
		this.source = source;
	}
	
	/**
	 * The destination file or directory to copy to.
	 */
	public String getDestination() {
		return destination;
	}
	
	/**
	 * The destination file or directory to copy to.
	 * @param	destination	the value to set.
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._PXWqsPLLEeGYwYEQM4LYvw__pJK_wPU4EeGsV8fV-DCYeA) ENABLED START */
		sourceFile = new File(source);
		destFile = new File(destination);
		if (source == null || !sourceFile.exists()) {
			issues.addError(this, "Source is not useable", source);
		}
		if (destination == null) {
			issues.addError(this, "Destination is not useable", destination);
		}
		if (sourceFile.isDirectory() && destFile.exists() && !destFile.isDirectory()) {
			issues.addError(this, "Cannot copy a directory to a file");
		}
		if (sourceFile.isFile() && destFile.exists() && !destFile.isFile()) {
			issues.addError(this, "Cannot copy a file to a directory");
		}
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._PXWqsPLLEeGYwYEQM4LYvw) ENABLED START */
	/**
	 * Returns the parent path of the location of the specified class file or null, if it cannot be obtained.
	 */
	public static Path resourceBase(Class<?> clazz) {
		Path result = null;
		try {
			// obtain location of class file; note: could be a directory or a jar file!
			URL url = clazz.getProtectionDomain().getCodeSource().getLocation();
			// either the directory or the jar file are in the same folder
			result = Paths.get(url.toURI()).getParent();
		} catch (Exception e) {
			// TODO: log exception
		}
		return result;
	}
	
	/**
	 * Copies everything below the source path into the destination path recursively.
	 */
	public static void copy(final Path source, final Path destination) throws IOException {
		Files.walkFileTree(source, copyFileVisitor(source, destination));
	}
	
	/**
	 * Returns a simple copy file visitor implementation.
	 */
	public static FileVisitor<Path> copyFileVisitor(final Path source, final Path destination) {
		return new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				// create output directory if not exists
				Path rel = source.relativize(dir);
				Path dest = Paths.get(destination.toString(), rel.toString());
				if (Files.notExists(dest)) {
					Files.createDirectories(dest);
				}
				return FileVisitResult.CONTINUE;
			}
			
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				// copy file
				Path rel = source.relativize(file);
				Path dest = Paths.get(destination.toString(), rel.toString());
				Files.copy(file, dest, StandardCopyOption.REPLACE_EXISTING);
				return super.visitFile(file, attrs);
			}
		};
	}
	
	/**
	 * Returns a zip file system for the specified zip file.
	 */
	public static FileSystem zipFileSystem(final Path zipFile) throws IOException {
		// create a new zip file system and copy html template from zip
		URI uri = URI.create("jar:file:" + zipFile.toUri().getPath());
		FileSystem zfs = null;
		try {
			zfs = FileSystems.newFileSystem(uri, Collections.<String, String> emptyMap());
		} catch (IOException ioe) {
			Log logger = LogFactory.getLog(Copier.class);
			if (logger.isDebugEnabled()) {
				logger.debug(zipFile + ": readable(" + Files.isReadable(zipFile) + "), executable(" + Files.isExecutable(zipFile) + "), writable(" + Files.isWritable(zipFile) + "), owner(" + Files.getOwner(zipFile, new LinkOption[0]) + ")");
			}
			throw ioe;
		}
		return zfs;
	}
	
	/**
	 * Returns the root path of the zip file system for the specified zip file.
	 */
	public static Path zipFileSystemRoot(final Path zipFile) throws IOException {
		FileSystem zfs = zipFileSystem(zipFile);
		return zfs.getPath("/");
	}
	/* PROTECTED REGION END */
}
