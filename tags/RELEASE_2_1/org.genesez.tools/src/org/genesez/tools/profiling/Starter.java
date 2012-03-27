package org.genesez.tools.profiling;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.WorkflowRunner;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

public class Starter extends AbstractWorkflowComponent {

	/**
	 * the logger instance for the WorkflowComponent
	 */
	protected Log logger = LogFactory.getLog(Starter.class);
	private long time;

	/**
	 * Starts a Workflow file. If no file given you can write one into the
	 * console.
	 * 
	 * @param args
	 *            contains the Workflow file to start
	 * @throws Exception
	 *             if something went wrong
	 */
	public static void main(String[] args) throws Throwable {
		Path folder = null;
		if (args.length < 1) {
			System.out.print("Please indicate an MWE workflow file:");
			folder = Paths.get(new BufferedReader(new InputStreamReader(System.in)).readLine());
		} else {
			folder = Paths.get(args[0]);
		}
		String baseDir = createFileString(folder.getParent().getParent().toString());
		String typeMappingDir = createFileString(folder.getParent().toString());
		args = new String[] { createFileString(folder.toString()), "-pbaseDir=" + baseDir, "-ptypeMappingDir=" + typeMappingDir };
		WorkflowRunner.main(args);
	}

	/**
	 * replaces \ with /
	 * @param fileString the String, where to replace
	 * @return ready String
	 */
	private static String createFileString(String fileString) {
		StringBuilder file = new StringBuilder(fileString);
			for (int i = 0; i < file.length(); i++) {
				if (file.charAt(i) == '\\') {
					file.replace(i, i+1, "/");
				}
			}
		return file.toString();
	}

	/**
	 * Constructs a Starter, halts the system and initializes the time
	 */
	public Starter() {
		super();
		logger.info("Press enter to continue...");
		try {
			System.in.read();
		} catch (Exception e) {
		} finally {
			time = System.currentTimeMillis();
		}
		
	}

	/**
	 * Logs the initialization time
	 */
	public void checkConfiguration(Issues issues) {
		time = System.currentTimeMillis() - time;
		logger.debug("Initialization took: " + (time / 1000.0) + "s");
	}

	/**
	 * logs configuration time
	 */
	@Override
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		time = System.currentTimeMillis() - time;
		logger.debug("Configuration and checking these took: " + (time / 1000.0) + "s");
	}

}
