package org.genesez.workflow.xpand;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_wWx1oPt9EeGRytmSxmtqcQ) 
 */

import java.util.List;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xpand2.Generator;
import org.genesez.platform.common.typemapping.TypeMapper;
import org.genesez.workflow.profile.Parameter;
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;
import static org.genesez.workflow.profile.WorkflowFileInclusion.ALWAYS;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.PostProcessor;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent.GlobalVarDef;
import org.eclipse.xtend.typesystem.MetaModel;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.TYPE;
import org.genesez.m2t.ImportPreserverConfig;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author dreamer
 */
public class Model2Text extends AbstractXpandWorkflowComponent {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String fileEncoding = "utf-8";
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private boolean isMultiValueSlot = false;
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private boolean prDefaultExcludes = false;
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String prExcludes = ".svn";
	
	@Parameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED)
	private java.util.Set<String> prSourceDir = new java.util.LinkedHashSet<String>();
	
	private java.util.Set<Outlet> outlet = new java.util.LinkedHashSet<Outlet>();
	
	@Parameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED)
	private java.util.Set<PostProcessor> postProcessor = new java.util.LinkedHashSet<PostProcessor>();
	
	@Parameter(isRequired = false, isMultiValued = true, workflowInclusion = ALWAYS)
	private java.util.Set<String> aopTemplate = new java.util.LinkedHashSet<String>();
	
	@Parameter(isRequired = true, isMultiValued = false, workflowInclusion = ALWAYS)
	private String template;
	
	@Parameter(isRequired = true, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String outputDir;
	
	private Generator generator;
	
	@Parameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED)
	private java.util.Set<String> typeMappingFile = new java.util.LinkedHashSet<String>();
	
	private ImportPreserverConfig importPreserverConfig;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._gLI4APt-EeGRytmSxmtqcQ) ENABLED START */
		if (template == null || template.isEmpty()) {
			issues.addError(this, "Workflow parameter 'template' is missing!", template);
		}
		if (outputDir == null || outputDir.isEmpty()) {
			if (outlet.isEmpty()) {
				issues.addError(this, "Workflow parameter 'outputDir' or 'outlet' must be present", outlet);
			} else {
				Outlet o = getDefaultOutlet();
				if (o == null) {
					issues.addError(this, "Workflow parameter 'outputDir' or a default 'outlet' must be present", outlet);
				} else {
					prSourceDir.add(o.getPath());
				}
			}
		} else {
			Outlet d = getDefaultOutlet();
			if (d == null) {
				Outlet o = new Outlet();
				o.setAppend(false);
				o.setFileEncoding(fileEncoding);
				o.setOverwrite(true);
				o.setPath(outputDir);
				o.postprocessors.addAll(postProcessor);
				outlet.add(o);
			}
			prSourceDir.add(outputDir);
		}
		super.checkConfiguration(issues);
		prepareDelegate();
		generator.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Invokes the execution of the component.
	 * @param	context	The context of workflow execution.
	 * @param	monitor	Instance to report any activity to.
	 * @param	issues	Instance to collect all problems during execution.
	 */
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._iXJckPt-EeGRytmSxmtqcQ) ENABLED START */
		// init type mapper
		TypeMapper.initTypeMapper(typeMappingFile.toArray(new String[0]));
		generator.invoke(context, monitor, issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	public String getLogMessage() {
		return generator.getLogMessage();
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>fileEncoding</b></em>'
	 */
	public String getFileEncoding() {
		return fileEncoding;
	}
	
	/**
	 * Sets the value of attribute '<em><b>fileEncoding</b></em>'
	 */
	public void setFileEncoding(String fileEncoding) {
		this.fileEncoding = fileEncoding;
	}
	
	/**
	 * Returns the value of attribute '<em><b>isMultiValueSlot</b></em>'
	 */
	public boolean getIsMultiValueSlot() {
		return isMultiValueSlot;
	}
	
	/**
	 * Sets the value of attribute '<em><b>isMultiValueSlot</b></em>'
	 */
	public void setIsMultiValueSlot(boolean isMultiValueSlot) {
		this.isMultiValueSlot = isMultiValueSlot;
	}
	
	/**
	 * Returns the value of attribute '<em><b>prDefaultExcludes</b></em>'
	 */
	public boolean getPrDefaultExcludes() {
		return prDefaultExcludes;
	}
	
	/**
	 * Sets the value of attribute '<em><b>prDefaultExcludes</b></em>'
	 */
	public void setPrDefaultExcludes(boolean prDefaultExcludes) {
		this.prDefaultExcludes = prDefaultExcludes;
	}
	
	/**
	 * Returns the value of attribute '<em><b>prExcludes</b></em>'
	 */
	public String getPrExcludes() {
		return prExcludes;
	}
	
	/**
	 * Sets the value of attribute '<em><b>prExcludes</b></em>'
	 */
	public void setPrExcludes(String prExcludes) {
		this.prExcludes = prExcludes;
	}
	
	/**
	 * Returns the value of attribute '<em><b>prSourceDir</b></em>'
	 */
	public java.util.Set<String> getPrSourceDir() {
		return prSourceDir;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>prSourceDir</b></em>'.
	 * @param	prSourceDir	the value to add
	 */
	public void addPrSourceDir(String prSourceDir) {
		this.prSourceDir.add(prSourceDir);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>prSourceDir</b></em>'.
	 * @param	prSourceDir	the value to remove
	 */
	public void removePrSourceDir(String prSourceDir) {
		this.prSourceDir.remove(prSourceDir);
	}
	
	/**
	 * Returns the value of attribute '<em><b>outlet</b></em>'
	 */
	public java.util.Set<Outlet> getOutlet() {
		return outlet;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>outlet</b></em>'.
	 * @param	outlet	the value to add
	 */
	public void addOutlet(Outlet outlet) {
		this.outlet.add(outlet);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>outlet</b></em>'.
	 * @param	outlet	the value to remove
	 */
	public void removeOutlet(Outlet outlet) {
		this.outlet.remove(outlet);
	}
	
	/**
	 * Returns the value of attribute '<em><b>postProcessor</b></em>'
	 */
	public java.util.Set<PostProcessor> getPostProcessor() {
		return postProcessor;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>postProcessor</b></em>'.
	 * @param	postProcessor	the value to add
	 */
	public void addPostProcessor(PostProcessor postProcessor) {
		this.postProcessor.add(postProcessor);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>postProcessor</b></em>'.
	 * @param	postProcessor	the value to remove
	 */
	public void removePostProcessor(PostProcessor postProcessor) {
		this.postProcessor.remove(postProcessor);
	}
	
	/**
	 * Returns the value of attribute '<em><b>aopTemplate</b></em>'
	 */
	public java.util.Set<String> getAopTemplate() {
		return aopTemplate;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>aopTemplate</b></em>'.
	 * @param	aopTemplate	the value to add
	 */
	public void addAopTemplate(String aopTemplate) {
		this.aopTemplate.add(aopTemplate);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>aopTemplate</b></em>'.
	 * @param	aopTemplate	the value to remove
	 */
	public void removeAopTemplate(String aopTemplate) {
		this.aopTemplate.remove(aopTemplate);
	}
	
	/**
	 * Returns the value of attribute '<em><b>template</b></em>'
	 */
	public String getTemplate() {
		return template;
	}
	
	/**
	 * Sets the value of attribute '<em><b>template</b></em>'
	 */
	public void setTemplate(String template) {
		this.template = template;
	}
	
	/**
	 * Returns the value of attribute '<em><b>outputDir</b></em>'
	 */
	public String getOutputDir() {
		return outputDir;
	}
	
	/**
	 * Sets the value of attribute '<em><b>outputDir</b></em>'
	 */
	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
	}
	
	/**
	 * Returns the value of attribute '<em><b>typeMappingFile</b></em>'
	 */
	public java.util.Set<String> getTypeMappingFile() {
		return typeMappingFile;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>typeMappingFile</b></em>'.
	 * @param	typeMappingFile	the value to add
	 */
	public void addTypeMappingFile(String typeMappingFile) {
		this.typeMappingFile.add(typeMappingFile);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>typeMappingFile</b></em>'.
	 * @param	typeMappingFile	the value to remove
	 */
	public void removeTypeMappingFile(String typeMappingFile) {
		this.typeMappingFile.remove(typeMappingFile);
	}
	
	/**
	 * Returns the value of attribute '<em><b>importPreserverConfig</b></em>'
	 */
	public ImportPreserverConfig getImportPreserverConfig() {
		return importPreserverConfig;
	}
	
	/**
	 * Sets the value of attribute '<em><b>importPreserverConfig</b></em>'
	 */
	public void setImportPreserverConfig(ImportPreserverConfig importPreserverConfig) {
		this.importPreserverConfig = importPreserverConfig;
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._wWx1oPt9EeGRytmSxmtqcQ) ENABLED START */
	private Outlet getDefaultOutlet() {
		for (Outlet o : outlet) {
			if (o.getName() == null) {
				return o;
			}
		}
		return null;
	}
	
	// the generator delegate deals with beautifiers in a way of List<?>
	@SuppressWarnings("unchecked")
	private void prepareDelegate() {
		generator = new Generator();
		generator.setSkipOnErrors(getAbortOnError());
		for (MetaModel mm : getMetaModel()) {
			generator.addMetaModel(mm);
		}
		for (GlobalVarDef def : getGlobalVarDef()) {
			generator.addGlobalVarDef(def);
		}
		for (String s : getAopScript()) {
			generator.addExtensionAdvice(s);
		}
		for (String s : aopTemplate) {
			generator.addAdvice(s);
		}
		generator.setFileEncoding(fileEncoding);
		generator.setPrDefaultExcludes(prDefaultExcludes);
		generator.setPrExcludes(prExcludes);
		generator.setPrSrcPaths(listToString(prSourceDir));
		for (Outlet o : outlet) {
			generator.addOutlet(o);
		}
		for (PostProcessor p : postProcessor) {
			((List<Object>) generator.getBeautifier()).add(p);
		}
		if (isMultiValueSlot) {
			generator.setExpand(template + " FOREACH " + getSlot());
		} else {
			generator.setExpand(template + " FOR " + getSlot());
		}
	}
	
	/* PROTECTED REGION END */
	
}
