package de.genesez.platforms.common.workflow;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * Provides a simple workflow component to copy files and directories.
 * @author toh
 */
public class Copier extends AbstractWorkflowComponent {

	private File source;
	private File destination;
	
	public void checkConfiguration(Issues issues) {
		if (source == null || !source.exists()) {
			issues.addError("Source is not useable", source);
		}
		if (destination == null) {
			issues.addError("Destination is not useable", destination);
		}
		if (source.isDirectory() && destination.exists() && !destination.isDirectory()) {
			issues.addError("cannot copy a directory to a file");
		}
		if (source.isFile() && destination.exists() && !destination.isFile()) {
			issues.addError("cannot copy a file to a directory");
		}
	}

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
			issues.addError(this, "error during copy", ctx, e, Arrays.<Object>asList(source, destination));
			e.printStackTrace();
		}
	}
	
	public void setSource(String uri) {
		source = new File(uri);
	}
	
	public void setDestination(String uri) {
		destination = new File(uri);
	}
}
