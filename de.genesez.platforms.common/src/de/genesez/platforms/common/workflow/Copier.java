package de.genesez.platforms.common.workflow;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * Workflow component class to to copy files and directories.
 * 
 * @author Tobias Haubold
 * @date 2011-08-23
 */
public class Copier extends AbstractWorkflowComponent {

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

	/**
	 * Called by the container after configuration so the component can validate
	 * the configuration before invocation.
	 * 
	 * @see org.eclipse.emf.mwe.core.WorkflowComponent#checkConfiguration(org.eclipse.emf.mwe.core.issues.Issues)
	 */
	public void checkConfiguration(Issues issues) {
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
	}

	/**
	 * Called by the container at invocation.
	 * 
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#invokeInternal(org.eclipse.emf.mwe.core.WorkflowContext,
	 *      org.eclipse.emf.mwe.core.monitor.ProgressMonitor,
	 *      org.eclipse.emf.mwe.core.issues.Issues)
	 */
	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
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
	}

	/**
	 * Setter for the workflow parameter <em><b>source</b></em>.
	 * 
	 * Sets the source file or direcory.
	 * 
	 * @param source The source file or directory.
	 * 
	 */
	public void setSource(String source) {
		this.source = new File(source);
	}

	/**
	 * Setter for the workflow parameter <em><b>destination</b></em>.
	 * 
	 * Sets the destination file or direcory.
	 * 
	 * @param destination The destination file or directory.
	 * 
	 */

	public void setDestination(String destination) {
		this.destination = new File(destination);
	}
}
