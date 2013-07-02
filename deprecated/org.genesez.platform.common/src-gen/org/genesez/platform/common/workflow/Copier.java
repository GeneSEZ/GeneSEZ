package org.genesez.platform.common.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1321346648079_175821_2456) 
 */

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import java.io.IOException;
import org.apache.commons.logging.LogFactory;
import java.util.Arrays;
import org.apache.commons.logging.Log;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * Workflow component class to to copy files and directories.
 *  
 * @author Tobias Haubold
 * @date 2011-08-23
 * @deprecated
 */
public class Copier extends AbstractWorkflowComponent {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * Logger instance to output important messages.
	 */
	protected Log logger = LogFactory.getLog(getClass());
	
	/**
	 * Variable for the source file or directory.
	 */
	private File source;
	
	/**
	 * Variable for the destination file or directory.
	 */
	private File destination;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Called by the container after configuration so the component can validate the configuration before invocation.
	 * @see org.eclipse.emf.mwe.core.WorkflowComponent#checkConfiguration(org.eclipse.emf.mwe.core.issues.Issues)
	 * @param	issues	the issues.
	 */
	
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321519864930_418381_1875) ENABLED START */
		if (source == null || !source.exists()) {
			issues.addError(this, "Source is not useable", source);
		}
		if (destination == null) {
			issues.addError(this, "Destination is not useable", destination);
		}
		if (source.isDirectory() && destination.exists() && !destination.isDirectory()) {
			issues.addError(this, "cannot copy a directory to a file");
		}
		if (source.isFile() && destination.exists() && !destination.isFile()) {
			issues.addError(this, "cannot copy a file to a directory");
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Called by the container at invocation.
	 * 
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#invokeInternal(org.eclipse.emf.mwe.core.WorkflowContext,
	 * org.eclipse.emf.mwe.core.monitor.ProgressMonitor,
	 * org.eclipse.emf.mwe.core.issues.Issues)
	 * @param	ctx	
	 * @param	monitor	
	 * @param	issues	
	 */
	
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321519897258_247472_2115) ENABLED START */
		try {
			if (source.isDirectory()) {
				FileUtils.copyDirectory(source, destination);
			}
			if (source.isFile()) {
				FileUtils.copyFile(source, destination);
			}
		} catch (IOException e) {
			issues.addError(this, "error during copy", ctx, e, Arrays.<Object> asList(source, destination));
			e.printStackTrace();
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>source</b></em>.
	 * 
	 * Sets the source file or direcory.
	 * @param	source	The source file or directory.
	 */
	
	public void setSource(String source) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321519941487_940003_2122) ENABLED START */
		this.source = new File(source);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>destination</b></em>.
	 * 
	 * Sets the destination file or direcory.
	 * @param	destination	The destination file or directory.
	 */
	
	public void setDestination(String destination) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1321519974770_378189_2129) ENABLED START */
		this.destination = new File(destination);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1321346648079_175821_2456) ENABLED START */
	/* PROTECTED REGION END */
	
}
