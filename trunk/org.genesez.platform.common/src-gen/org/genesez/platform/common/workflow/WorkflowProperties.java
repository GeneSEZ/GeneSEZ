package org.genesez.platform.common.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1319198023234_554284_1876) 
 */

import java.util.Properties;

/**
 * Class where the default values for the GeneSEZ meta models and slots are defined.
 * 
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-08-20
 */
public class WorkflowProperties {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * Default values for GeneSEZ meta models and slots.
	 */
	public static Properties defaults = new Properties();
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1319198023234_554284_1876) ENABLED START */
	static {
		defaults.setProperty("slot", "coremodel");
		defaults.setProperty("coreSlot", "coremodel");
		defaults.setProperty("presentationSlot", "presentationmodel");
		defaults.setProperty("reqSlot", "reqmodel");
		defaults.setProperty("traceSlot", "tracemodel");
		defaults.setProperty("gcorePackage", "org.genesez.metamodel.gcore.GcorePackage");
		defaults.setProperty("gpresentationPackage", "org.genesez.metamodel.gpresentation.GpresentationPackage");
		defaults.setProperty("greqPackage", "org.genesez.metamodel.greq.GreqPackage");
		defaults.setProperty("gtracePackage", "org.genesez.metamodel.gtrace.GtracePackage");
	}
	/* PROTECTED REGION END */
	
}
