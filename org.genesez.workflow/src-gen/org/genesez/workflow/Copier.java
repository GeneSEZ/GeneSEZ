package org.genesez.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_PXWqsPLLEeGYwYEQM4LYvw) 
 */

import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.genesez.workflow.profile.Parameter;

/**
 * Provides copying services for files and directories (recursively) based on apache commons io.
 */
public class Copier extends AbstractWorkflowComponent implements WorkflowComponent {
	
	/**
	 * The source file or directory to copy.
	 */
	@Parameter(isRequired = true, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String source;
	
	/**
	 * The destination file or directory to copy to.
	 */
	@Parameter(isRequired = true, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
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
	 * @return	
	 */
	public String getLogMessage() {
		/* PROTECTED REGION ID(java.implementation._2zHZIP6tEeGciM7nbRm1bw) ENABLED START */
		// TODO: implementation of method 'Copier.getLogMessage(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Invokes the execution of the component.
	 * @param	context	The context of workflow execution.
	 * @param	monitor	Instance to report any activity to.
	 * @param	issues	Instance to collect all problems during execution.
	 */
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._PXWqsPLLEeGYwYEQM4LYvw__rTW_YPU4EeGsV8fV-DCYeA) ENABLED START */
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
	
	/**
	 * The source file or directory to copy.
	 */
	public String getSource() {
		return source;
	}
	
	/**
	 * The source file or directory to copy.
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
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._PXWqsPLLEeGYwYEQM4LYvw) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
