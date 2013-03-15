package org.genesez.workflow.xpand;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_wWx1oPt9EeGRytmSxmtqcQ) 
 */
import static org.genesez.workflow.profile.WorkflowFileInclusion.ALWAYS;
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.container.CompositeComponent;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xpand2.Generator;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.PostProcessor;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.TypeSystemImpl;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent.GlobalVarDef;
import org.eclipse.xtend.typesystem.MetaModel;
import org.genesez.m2t.cp.ImportPreserverConfig;
import org.genesez.mapping.type.TypeMapper;
import org.genesez.workflow.Model2Text;
import org.genesez.workflow.Transformable;
import org.genesez.workflow.profile.WfDefault;
import org.genesez.workflow.profile.WfParameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Model2TextComponent extends AbstractXpandWorkflowComponent {
	
	public final Log logger = LogFactory.getLog(getClass());
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String fileEncoding = "utf-8";
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private boolean isMultiValueSlot = false;
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private boolean prDefaultExcludes = false;
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String prExcludes = ".svn";
	
	@WfParameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private java.util.Set<String> prSourceDir = new java.util.LinkedHashSet<String>();
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private java.util.Set<Outlet> outlet = new java.util.LinkedHashSet<Outlet>();
	
	@WfParameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private java.util.Set<PostProcessor> postProcessor = new java.util.LinkedHashSet<PostProcessor>();
	
	@WfParameter(isRequired = false, isMultiValued = true, workflowInclusion = ALWAYS, isTransformationParameter = true)
	private java.util.Set<String> aopTemplate = new java.util.LinkedHashSet<String>();
	
	@WfParameter(isRequired = true, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String outputDir;
	
	private CompositeComponent compositeGenerator;
	
	@WfParameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private java.util.Set<String> typeMappingFile = new java.util.LinkedHashSet<String>();
	
	private ImportPreserverConfig importPreserverConfig;
	
	@WfParameter(isRequired = true, isMultiValued = true, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private java.util.Set<Model2Text> model2text = new java.util.HashSet<Model2Text>();
	
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._gLI4APt-EeGRytmSxmtqcQ) ENABLED START */
		if (model2text.isEmpty()) {
			issues.addError(this, "Workflow parameter 'model2text' is missing!", model2text);
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
			// ensure output directory exists
			try {
				java.nio.file.Files.createDirectories(Paths.get(outputDir));
			} catch (IOException e) {
				logger.error("Unable to create output directory", e);
			}
			// check default outlet
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
		// ensure all output directories exist
		for (Outlet o : outlet) {
			ensureDirectoryExists(o.getPath());
		}
		// ensure valid transformables
		for (Transformable t : model2text) {
			if (!t.validate()) {
				issues.addError(this, "Model2Text transformable is not valid!", t);
			}
		}
		super.checkConfiguration(issues);
		prepareDelegate();
		compositeGenerator.checkConfiguration(issues);
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
		// init naming mapper
		Map<String, Variable> globalVars = new HashMap<String, Variable>();
		for (GlobalVarDef globalVarDef : getGlobalVarDef()) {
			globalVars.put(globalVarDef.getName(), new Variable(globalVarDef.getName(), globalVarDef.getValue()));
		}
		ExecutionContext namingCtx = new ExecutionContextImpl(new TypeSystemImpl(), globalVars);
		//		NameMapper.initNameMapper(xtendNamingFile, namingCtx, getMetaModel());
		
		// init type mapper
		TypeMapper.initTypeMapper(typeMappingFile.toArray(new String[0]));
		
		// invoke
		compositeGenerator.invoke(context, monitor, issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>fileEncoding</b></em>'.
	 */
	public String getFileEncoding() {
		return fileEncoding;
	}
	
	/**
	 * Sets the value of attribute '<em><b>fileEncoding</b></em>'.
	 * @param	fileEncoding	the value to set.
	 */
	public void setFileEncoding(String fileEncoding) {
		this.fileEncoding = fileEncoding;
	}
	
	/**
	 * Returns the value of attribute '<em><b>isMultiValueSlot</b></em>'.
	 */
	public boolean getIsMultiValueSlot() {
		return isMultiValueSlot;
	}
	
	/**
	 * Sets the value of attribute '<em><b>isMultiValueSlot</b></em>'.
	 * @param	isMultiValueSlot	the value to set.
	 */
	public void setIsMultiValueSlot(boolean isMultiValueSlot) {
		this.isMultiValueSlot = isMultiValueSlot;
	}
	
	/**
	 * Returns the value of attribute '<em><b>prDefaultExcludes</b></em>'.
	 */
	public boolean getPrDefaultExcludes() {
		return prDefaultExcludes;
	}
	
	/**
	 * Sets the value of attribute '<em><b>prDefaultExcludes</b></em>'.
	 * @param	prDefaultExcludes	the value to set.
	 */
	public void setPrDefaultExcludes(boolean prDefaultExcludes) {
		this.prDefaultExcludes = prDefaultExcludes;
	}
	
	/**
	 * Returns the value of attribute '<em><b>prExcludes</b></em>'.
	 */
	public String getPrExcludes() {
		return prExcludes;
	}
	
	/**
	 * Sets the value of attribute '<em><b>prExcludes</b></em>'.
	 * @param	prExcludes	the value to set.
	 */
	public void setPrExcludes(String prExcludes) {
		this.prExcludes = prExcludes;
	}
	
	/**
	 * Returns the value of attribute '<em><b>prSourceDir</b></em>'.
	 */
	public java.util.Set<String> getPrSourceDir() {
		return prSourceDir;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>prSourceDir</b></em>'.
	 * @param	prSourceDir	the value to add.
	 */
	public void addPrSourceDir(String prSourceDir) {
		this.prSourceDir.add(prSourceDir);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>prSourceDir</b></em>'.
	 * @param	prSourceDir	the value to remove.
	 */
	public void removePrSourceDir(String prSourceDir) {
		this.prSourceDir.remove(prSourceDir);
	}
	
	/**
	 * Returns the value of attribute '<em><b>outlet</b></em>'.
	 */
	public java.util.Set<Outlet> getOutlet() {
		return outlet;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>outlet</b></em>'.
	 * @param	outlet	the value to add.
	 */
	public void addOutlet(Outlet outlet) {
		this.outlet.add(outlet);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>outlet</b></em>'.
	 * @param	outlet	the value to remove.
	 */
	public void removeOutlet(Outlet outlet) {
		this.outlet.remove(outlet);
	}
	
	/**
	 * Returns the value of attribute '<em><b>postProcessor</b></em>'.
	 */
	public java.util.Set<PostProcessor> getPostProcessor() {
		return postProcessor;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>postProcessor</b></em>'.
	 * @param	postProcessor	the value to add.
	 */
	public void addPostProcessor(PostProcessor postProcessor) {
		this.postProcessor.add(postProcessor);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>postProcessor</b></em>'.
	 * @param	postProcessor	the value to remove.
	 */
	public void removePostProcessor(PostProcessor postProcessor) {
		this.postProcessor.remove(postProcessor);
	}
	
	/**
	 * Returns the value of attribute '<em><b>aopTemplate</b></em>'.
	 */
	public java.util.Set<String> getAopTemplate() {
		return aopTemplate;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>aopTemplate</b></em>'.
	 * @param	aopTemplate	the value to add.
	 */
	public void addAopTemplate(String aopTemplate) {
		this.aopTemplate.add(aopTemplate);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>aopTemplate</b></em>'.
	 * @param	aopTemplate	the value to remove.
	 */
	public void removeAopTemplate(String aopTemplate) {
		this.aopTemplate.remove(aopTemplate);
	}
	
	/**
	 * Returns the value of attribute '<em><b>outputDir</b></em>'.
	 */
	public String getOutputDir() {
		return outputDir;
	}
	
	/**
	 * Sets the value of attribute '<em><b>outputDir</b></em>'.
	 * @param	outputDir	the value to set.
	 */
	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
	}
	
	/**
	 * Returns the value of attribute '<em><b>typeMappingFile</b></em>'.
	 */
	public java.util.Set<String> getTypeMappingFile() {
		return typeMappingFile;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>typeMappingFile</b></em>'.
	 * @param	typeMappingFile	the value to add.
	 */
	public void addTypeMappingFile(String typeMappingFile) {
		this.typeMappingFile.add(typeMappingFile);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>typeMappingFile</b></em>'.
	 * @param	typeMappingFile	the value to remove.
	 */
	public void removeTypeMappingFile(String typeMappingFile) {
		this.typeMappingFile.remove(typeMappingFile);
	}
	
	/**
	 * Returns the value of attribute '<em><b>importPreserverConfig</b></em>'.
	 */
	public ImportPreserverConfig getImportPreserverConfig() {
		return importPreserverConfig;
	}
	
	/**
	 * Sets the value of attribute '<em><b>importPreserverConfig</b></em>'.
	 * @param	importPreserverConfig	the value to set.
	 */
	public void setImportPreserverConfig(ImportPreserverConfig importPreserverConfig) {
		this.importPreserverConfig = importPreserverConfig;
	}
	
	/**
	 * Returns the value of attribute '<em><b>model2text</b></em>'.
	 */
	public java.util.Set<Model2Text> getModel2text() {
		return model2text;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>model2text</b></em>'.
	 * @param	model2text	the value to add.
	 */
	public void addModel2text(Model2Text model2text) {
		this.model2text.add(model2text);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>model2text</b></em>'.
	 * @param	model2text	the value to remove.
	 */
	public void removeModel2text(Model2Text model2text) {
		this.model2text.remove(model2text);
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "fileEncoding")
	public String getDefaultFileEncoding() {
		return "utf-8";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "isMultiValueSlot")
	public boolean getDefaultIsMultiValueSlot() {
		return false;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "prDefaultExcludes")
	public boolean getDefaultPrDefaultExcludes() {
		return false;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "prExcludes")
	public String getDefaultPrExcludes() {
		return ".svn";
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._wWx1oPt9EeGRytmSxmtqcQ) ENABLED START */
	private Outlet getDefaultOutlet() {
		for (Outlet o : outlet) {
			if (o.getName() == null) {
				return o;
			}
		}
		return null;
	}
	
	private void ensureDirectoryExists(String uri) {
		File f = new File(uri);
		if (!f.exists()) {
			if (!f.mkdir()) {
				logger.error("Unable to create output directory: " + uri);
			}
		}
	}
	
	// the generator delegate deals with beautifiers in a way of List<?>
	@SuppressWarnings("unchecked")
	private void prepareDelegate() {
		compositeGenerator = new CompositeComponent(getClass().getName());
		for (Model2Text m2t : model2text) {
			Generator gen = new Generator();
			gen.setSkipOnErrors(getAbortOnError());
			for (MetaModel mm : getMetaModel()) {
				gen.addMetaModel(mm);
			}
			addGlobalVarDefs(m2t.getParameter());
			for (GlobalVarDef def : getGlobalVarDef()) {
				gen.addGlobalVarDef(def);
			}
			for (String s : getAopScript()) {
				gen.addExtensionAdvice(s);
			}
			for (String s : aopTemplate) {
				gen.addAdvice(s);
			}
			gen.setFileEncoding(fileEncoding);
			gen.setPrDefaultExcludes(prDefaultExcludes);
			gen.setPrExcludes(prExcludes);
			gen.setPrSrcPaths(listToString(prSourceDir));
			for (Outlet o : outlet) {
				gen.addOutlet(o);
			}
			for (PostProcessor p : postProcessor) {
				((List<Object>) gen.getBeautifier()).add(p);
			}
			String template = m2t.getTemplate();
			if (isMultiValueSlot) {
				gen.setExpand(template + " FOREACH " + getSlot());
			} else {
				gen.setExpand(template + " FOR " + getSlot());
			}
			compositeGenerator.addComponent(gen);
		}
	}
	/* PROTECTED REGION END */
}
