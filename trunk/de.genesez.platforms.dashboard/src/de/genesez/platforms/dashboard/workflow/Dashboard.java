
package de.genesez.platforms.dashboard.workflow;

import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.emf.mwe.core.container.CompositeComponent;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.utils.DirectoryCleaner;
import org.eclipse.emf.mwe.utils.Mapping;
import org.eclipse.emf.mwe.utils.Reader;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.xpand2.Generator;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

import de.genesez.metamodel.gcore.GcorePackage;
import de.genesez.metamodel.greq.GreqPackage;
import de.genesez.metamodel.gtrace.AdaptedFactoryActivator;
import de.genesez.metamodel.gtrace.GtracePackage;
import de.genesez.platforms.common.workflow.Copier;
import de.genesez.platforms.common.workflow.WorkflowUtils;

/**
 * Performs the generation of the GeneSEZ Dashboard.
 * @author tobias haubold
 * @version	2011-01-07
 */
public class Dashboard extends CompositeComponent {
	
	private static final String GCORE_MODEL_SLOT = "coremodel";
	private static final String GREQ_MODEL_SLOT = "reqmodel";
	private static final String GTRACE_MODEL_SLOT = "tracemodel";
	private static final String CROSS_MODEL_NAVIGATION_USING_EXTENSIONS_ADVICE = "de::genesez::metamodel::navigation::RequirementsTraceabilityExtensionAdvice";
	
	private StandaloneSetup setup = new StandaloneSetup();
	private EmfMetaModel gcore = new EmfMetaModel();
	private EmfMetaModel greq = new EmfMetaModel();
	private EmfMetaModel gtrace = new EmfMetaModel();
	
	private AdaptedFactoryActivator traceFactory = new AdaptedFactoryActivator();
	private boolean useExtensions = false;
	
	private Reader gcoreReader = new Reader();
	private Reader greqReader = new Reader();
	private Reader gtraceReader = new Reader();
	private DirectoryCleaner cleaner = new DirectoryCleaner();
	private Copier copier = new Copier();
	private Generator generator = new Generator();
	
	public Dashboard() {
		super(Dashboard.class.getSimpleName());
		
		gcore.setMetaModelPackage(GcorePackage.class.getName());
		greq.setMetaModelPackage(GreqPackage.class.getName());
		gtrace.setMetaModelPackage(GtracePackage.class.getName());
		
		gcoreReader.setMakeEPackagesGlobal(true);
		gcoreReader.setFirstElementOnly(true);
		gcoreReader.setUseSingleGlobalResourceSet(true);
		gcoreReader.setModelSlot(GCORE_MODEL_SLOT);
		greqReader.setMakeEPackagesGlobal(true);
		greqReader.setFirstElementOnly(true);
		greqReader.setUseSingleGlobalResourceSet(true);
		greqReader.setModelSlot(GREQ_MODEL_SLOT);
		gtraceReader.setMakeEPackagesGlobal(true);
		gtraceReader.setFirstElementOnly(true);
		gtraceReader.setUseSingleGlobalResourceSet(true);
		gtraceReader.setModelSlot(GTRACE_MODEL_SLOT);
		
		cleaner.setUseDefaultExcludes(false);
		
		generator.addMetaModel(gcore);
		generator.addMetaModel(greq);
		generator.addMetaModel(gtrace);
		generator.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("coremodel", GCORE_MODEL_SLOT));
		generator.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("reqmodel", GREQ_MODEL_SLOT));
		generator.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("tracemodel", GTRACE_MODEL_SLOT));
		generator.setFileEncoding("utf-8");
		generator.setExpand("de::genesez::platforms::dashboard::Root::Root FOR tracemodel");
		
		super.addComponent(gcoreReader);
		super.addComponent(greqReader);
		super.addComponent(gtraceReader);
		super.addComponent(cleaner);
		super.addComponent(copier);
		super.addComponent(generator);
	}
	
	@Override
	public void checkConfiguration(Issues issues) throws ConfigurationException {
		// if the use of model extensions is preferred instead of model queries, we have
		// to change the traceability model factory and add the respective advices to the navigation functions
		if (useExtensions) {
			traceFactory.enable();
			generator.addExtensionAdvice(CROSS_MODEL_NAVIGATION_USING_EXTENSIONS_ADVICE);
		}
		super.checkConfiguration(issues);
	}
	
	/**
	 * @param uri	the filename or uri to the structure model
	 */
	public void setGcoreModel(String uri) {
		gcoreReader.setUri(uri);
	}
	
	/**
	 * @param uri	the filename or uri to the requirements model
	 */
	public void setGreqModel(String uri) {
		greqReader.setUri(uri);
	}
	
	/**
	 * @param uri	the filename or uri to the traceability model
	 */
	public void setGtraceModel(String uri) {
		gtraceReader.setUri(uri);
	}
	
	/**
	 * @param uri	the filename or uri of the output directory
	 */
	public void setOutputDir(String uri) {
		cleaner.setDirectory(uri);
		copier.setDestination(uri);
		generator.addOutlet(new Outlet(uri));
	}
	
	/**
	 * Note: this is just a workaround till we find out, how we can obtain the /template directory uri automatically
	 * @param uri	the filename or uri of the dashboard template directory
	 */
	public void setSource(String uri) {
		copier.setSource(uri);
	}
	
	/**
	 * @param value	indicates the use of metamodel extensions instead of model queries for cross model navigation
	 */
	public void setUseExtensions(Boolean value) {
		useExtensions = value;
	}
	
	/**
	 * Adds an uri mapping to locate ecore models. It is particularly useful if
	 * the traceability model uses relative uri's to reference structure + requirements
	 * model elements and the current directory during execution is not the same where the
	 * traceability model is located.
	 * @param uriMap	an uri mapping to load ecore models
	 */
	public void addUriMap(Mapping uriMap) {
		setup.addUriMap(uriMap);
	}
}
