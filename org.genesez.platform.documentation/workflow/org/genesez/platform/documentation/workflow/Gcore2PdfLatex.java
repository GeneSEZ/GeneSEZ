package org.genesez.platform.documentation.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_AmnOYAoxEeKxusbn3Pe47g) 
 */
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.genesez.workflow.profile.WfDefault;
import org.genesez.workflow.profile.WfParameter;
import org.genesez.workflow.xpand.Model2TextComponent;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Gcore2PdfLatex extends Model2TextComponent {
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String pdfOutputDir;
	
	@WfParameter(isRequired = true, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String latexRootFile;
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private boolean showPdfLatexLog = true;
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String command = "pdflatex";
	
	/**
	 * Invokes the execution of the component.
	 * @param	context	The context of workflow execution.
	 * @param	monitor	Instance to report any activity to.
	 * @param	issues	Instance to collect all problems during execution.
	 */
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._xl8ZoAoyEeKxusbn3Pe47g) ENABLED START */
		// do latex generation
		super.invokeInternal(context, monitor, issues);
		// do latex 2 pdf transformation
		try {
			Process p = Runtime.getRuntime().exec(command + " -output-directory=" + pdfOutputDir + " " + latexRootFile);
			
			String line;
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = input.readLine()) != null) {
				if (showPdfLatexLog) {
					logger.info(line);
				}
			}
			input.close();
			
		} catch (IOException e) {
			logger.error(e.toString());
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._xl8ZqAoyEeKxusbn3Pe47g) ENABLED START */
		if (latexRootFile == null || latexRootFile.isEmpty()) {
			issues.addError(this, "Workflow parameter 'latexRootFile' is missing!", latexRootFile);
		}
		if (pdfOutputDir == null || pdfOutputDir.isEmpty()) {
			pdfOutputDir = getOutputDir();
			issues.addInfo(this, "Workflow parameter 'pdfOutputDir' is missing and set to 'outputDir'!", pdfOutputDir);
		}
		// delegate to further checks
		super.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "showPdfLatexLog")
	public boolean getDefaultShowPdfLatexLog() {
		return true;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "command")
	public String getDefaultCommand() {
		return "pdflatex";
	}
	
	/**
	 * Returns the value of attribute '<em><b>pdfOutputDir</b></em>'.
	 */
	public String getPdfOutputDir() {
		return pdfOutputDir;
	}
	
	/**
	 * Sets the value of attribute '<em><b>pdfOutputDir</b></em>'.
	 * @param	pdfOutputDir	the value to set.
	 */
	public void setPdfOutputDir(String pdfOutputDir) {
		this.pdfOutputDir = pdfOutputDir;
	}
	
	/**
	 * Returns the value of attribute '<em><b>latexRootFile</b></em>'.
	 */
	public String getLatexRootFile() {
		return latexRootFile;
	}
	
	/**
	 * Sets the value of attribute '<em><b>latexRootFile</b></em>'.
	 * @param	latexRootFile	the value to set.
	 */
	public void setLatexRootFile(String latexRootFile) {
		this.latexRootFile = latexRootFile;
	}
	
	/**
	 * Returns the value of attribute '<em><b>showPdfLatexLog</b></em>'.
	 */
	public boolean getShowPdfLatexLog() {
		return showPdfLatexLog;
	}
	
	/**
	 * Sets the value of attribute '<em><b>showPdfLatexLog</b></em>'.
	 * @param	showPdfLatexLog	the value to set.
	 */
	public void setShowPdfLatexLog(boolean showPdfLatexLog) {
		this.showPdfLatexLog = showPdfLatexLog;
	}
	
	/**
	 * Returns the value of attribute '<em><b>command</b></em>'.
	 */
	public String getCommand() {
		return command;
	}
	
	/**
	 * Sets the value of attribute '<em><b>command</b></em>'.
	 * @param	command	the value to set.
	 */
	public void setCommand(String command) {
		this.command = command;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._AmnOYAoxEeKxusbn3Pe47g) ENABLED START */
	/* PROTECTED REGION END */
}
