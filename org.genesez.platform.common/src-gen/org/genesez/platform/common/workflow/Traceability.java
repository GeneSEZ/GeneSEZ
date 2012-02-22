package org.genesez.platform.common.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324564423951_527900_6334) 
 */

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import java.util.Properties;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.genesez.metamodel.gtrace.GtracePackage;
import org.genesez.metamodel.gcore.GcorePackage;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.utils.Reader;
import org.eclipse.emf.mwe.utils.Mapping;
import org.genesez.metamodel.gtrace.AdaptedFactoryActivator;
import org.genesez.metamodel.greq.GreqPackage;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;
import org.eclipse.emf.mwe.core.container.CompositeComponent;

/**
 * Performs the instantiation process of genesez models for traceability purpose. The instantiated core model is serialized to reflect possibile changes for further generation steps. The requirements and traceability model are instantiated. If checked, the necessary information for cross model references is stored using model extensions. Else model queries must be used.
 * 
 * @author tobias haubold
 * @todo rework to fit the actual configuration guide lines.
 */
public class Traceability extends CompositeComponent {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static Properties defaults = new Properties();
	
	private Log logger = LogFactory.getLog(getClass());
	
	private Properties properties = new Properties();
	
	private StandaloneSetup setup = new StandaloneSetup();
	
	private EmfMetaModel gcore = new EmfMetaModel();
	
	private EmfMetaModel greq = new EmfMetaModel();
	
	private EmfMetaModel gtrace = new EmfMetaModel();
	
	private AdaptedFactoryActivator traceFactory = new AdaptedFactoryActivator();
	
	private boolean useExtensionsForCrossModelNavigation = false;
	
	private Serializer gcoreSerializer = new Serializer();
	
	private Reader greqReader = new Reader();
	
	private Reader gtraceReader = new Reader();
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>Traceability</b></em>'.
	 */
	public Traceability() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1324564810363_487851_6539) ENABLED START */
		super(Traceability.class.getSimpleName());
		
		properties.putAll(defaults);
		
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
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	issues	
	 */
	
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324564824296_741455_6546) ENABLED START */
		// if the use of model extensions is preferred instead of model queries, we have
		// to change the traceability model factory and add the respective advices to the navigation functions
		if (useExtensionsForCrossModelNavigation) {
			traceFactory.enable();
		}
		super.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	uri	the filename or uri the structure model is serialized to
	 */
	
	public void setGcoreModel(String uri) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324564841800_964735_6553) ENABLED START */
		gcoreSerializer.setFile(uri);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	uri	the filename or uri to the requirements model
	 */
	
	public void setGreqModel(String uri) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324564886409_152034_6561) ENABLED START */
		greqReader.setUri(uri);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	uri	the filename or uri to the traceability model
	 */
	
	public void setGtraceModel(String uri) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324564899904_882761_6568) ENABLED START */
		gtraceReader.setUri(uri);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Adds an uri mapping to locate ecore models. It is particularly useful if the traceability model uses relative uri's to reference structure + requirements model elements and the current directory during execution is not the same where the traceability model is located.
	 * @param	uriMap	an uri mapping to load ecore models
	 */
	
	public void addUriMap(Mapping uriMap) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324564919508_182861_6578) ENABLED START */
		setup.addUriMap(uriMap);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Sets the value of attribute '<em><b>useExtensionsForCrossModelNavigation</b></em>'
	 */
	public void setUseExtensionsForCrossModelNavigation(boolean useExtensionsForCrossModelNavigation) {
		this.useExtensionsForCrossModelNavigation = useExtensionsForCrossModelNavigation;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324564423951_527900_6334) ENABLED START */
	static {
		defaults.putAll(WorkflowProperties.defaults);
	}
	/* PROTECTED REGION END */
	
}
