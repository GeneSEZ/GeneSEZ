package org.genesez.platform.documentation.workflow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.genesez.platform.common.workflow.WorkflowUtils;

/**
 * Provides a generator component for latex artifacts by setting the default
 * latex template.
 * 
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2012-03-18
 */
public class PDFLatexGenerator extends LatexGenerator {

	/**
	 * Default values of the generator.
	 */
	private static final Properties defaults = new Properties();

	static {
		defaults.setProperty("pdflatex", "pdflatex");
		defaults.setProperty("showPDFLatexOutput", "true");
	}

	public PDFLatexGenerator() {
		super();

		WorkflowUtils.callPropertyAccessors(this, defaults);
	}

	@Override
	protected void invokeInternal2(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		// check if latexRootFile is set.
		String latexRootFile = properties.getProperty("latexRootFile", "");
		if (latexRootFile.length() == 0) {
			issues.addError(this, "Missing property 'latexRootFile'!", latexRootFile);
		}

		// check if a pdf output directory is set.
		String pdfOutputDir = properties.getProperty("pdfOutputDir", "");
		if (pdfOutputDir.length() == 0) {
			issues.addInfo(this, "Pdf Output directory is set to the output directory.", pdfOutputDir);
			pdfOutputDir = properties.getProperty("outputDir", "");
		}

		String pdflatex = properties.getProperty("pdflatex", "");
		Boolean showPDFLatexOutput = Boolean.valueOf(properties.getProperty("showPDFLatexOutput", ""));

		// call latex generation
		super.invokeInternal2(ctx, monitor, issues);

		try {
			Process p = Runtime.getRuntime()
					.exec(pdflatex + " -output-directory=" + pdfOutputDir + " " + latexRootFile);

			if (showPDFLatexOutput) {
				String line;
				BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
				while ((line = input.readLine()) != null) {
					logger.info(line);
				}
				input.close();
			}
		} catch (IOException e) {
			logger.error(e.toString());
		}
	}

	// BEGIN OF DEFAULTS

	/**
	 * Path and file name of the external program 'pdflatex'.
	 * 
	 * @param pdflatex The path and file name of the external program
	 *            'pdflatex'.
	 */
	public void setPdflatex(String pdflatex) {
		properties.put("pdflatex", pdflatex);
	}

	/**
	 * Setter for the workflow parameter <em><b>showPDFLatexOutput</b></em>
	 * 
	 * Sets if the command line output of the 'pdflatex' should be shown.
	 * 
	 * @param showPDFLatexOutput True if the command line output should be
	 *            shown, otherwise false.
	 */
	public void setShowPDFLatexOutput(String showPDFLatexOutput) {
		properties.put("showPDFLatexOutput", showPDFLatexOutput);
	}

	// END OF DEFAULTS

	/**
	 * Setter for the workflow parameter <em><b>pdfOutputDir</b></em>. Sets the
	 * base path where the pdf output will be generated.
	 * 
	 * @param pdfOutputDir The pdf path for the output.
	 */

	public void setPdfOutputDir(String pdfOutputDir) {
		properties.setProperty("pdfOutputDir", pdfOutputDir);
	}

	/**
	 * Setter for the workflow parameter <em><b>latexRootFile</b></em>.
	 * 
	 * Sets the path and file name of the latex root file which should be called
	 * from 'pdflatex'.
	 * 
	 * @param latexRootFile The latex root file.
	 */
	public void setLatexRootFile(String latexRootFile) {
		properties.setProperty("latexRootFile", latexRootFile);
	}

}
