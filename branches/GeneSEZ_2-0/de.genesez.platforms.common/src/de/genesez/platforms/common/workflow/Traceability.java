package de.genesez.platforms.common.workflow;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.emf.mwe.core.container.CompositeComponent;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.utils.Mapping;
import org.eclipse.emf.mwe.utils.Reader;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

import de.genesez.metamodel.gcore.GcorePackage;
import de.genesez.metamodel.greq.GreqPackage;
import de.genesez.metamodel.gtrace.AdaptedFactoryActivator;
import de.genesez.metamodel.gtrace.GtracePackage;

/**
 * Performs the instantiation process of genesez models for traceability purpose.
 * The instantiated core model is serialized to reflect possibile changes for further generation steps.
 * The requirements and traceability model are instantiated. If checked, the necessary information for cross model
 * references is stored using model extensions. Else model queries must be used.
 * @author tobias haubold
 */
public class Traceability extends CompositeComponent {
	
	private static final Properties defaults = new Properties();
	static {
		defaults.putAll(WorkflowUtils.defaults);
	}
	
	private Log logger = LogFactory.getLog(getClass());
	private Properties properties = new Properties(defaults);
	
	private StandaloneSetup setup = new StandaloneSetup();
	private EmfMetaModel gcore = new EmfMetaModel();
	private EmfMetaModel greq = new EmfMetaModel();
	private EmfMetaModel gtrace = new EmfMetaModel();
	
	private AdaptedFactoryActivator traceFactory = new AdaptedFactoryActivator();
	private boolean useExtensionsForCrossModelNavigation = false;
	
	private Serializer gcoreSerializer = new Serializer();
	private Reader greqReader = new Reader();
	private Reader gtraceReader = new Reader();
	
	public Traceability() {
		super(Traceability.class.getSimpleName());
		
		gcore.setMetaModelPackage(GcorePackage.class.getName());
		greq.setMetaModelPackage(GreqPackage.class.getName());
		gtrace.setMetaModelPackage(GtracePackage.class.getName());
		
		gcoreSerializer.setModelSlot(properties.getProperty("coreSlot"));
		
		greqReader.setMakeEPackagesGlobal(true);
		greqReader.setFirstElementOnly(true);
		greqReader.setUseSingleGlobalResourceSet(true);
		greqReader.setModelSlot(properties.getProperty("reqSlot"));
		gtraceReader.setMakeEPackagesGlobal(true);
		gtraceReader.setFirstElementOnly(true);
		gtraceReader.setUseSingleGlobalResourceSet(true);
		gtraceReader.setModelSlot(properties.getProperty("traceSlot"));
		
		super.addComponent(gcoreSerializer);
		super.addComponent(greqReader);
		super.addComponent(gtraceReader);
	}
	
	@Override
	public void checkConfiguration(Issues issues) throws ConfigurationException {
		// if the use of model extensions is preferred instead of model queries, we have
		// to change the traceability model factory and add the respective advices to the navigation functions
		if (useExtensionsForCrossModelNavigation) {
			traceFactory.enable();
		}
		super.checkConfiguration(issues);
	}
	
	/**
	 * @param uri	the filename or uri the structure model is serialized to
	 */
	public void setGcoreModel(String uri) {
		gcoreSerializer.setFile(uri);
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
	 * @param value	indicates the use of metamodel extensions instead of model queries for cross model navigation
	 */
	public void setUseExtensionsForCrossModelNavigation(Boolean value) {
		useExtensionsForCrossModelNavigation = value;
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
