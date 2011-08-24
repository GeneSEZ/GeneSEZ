package de.genesez.platforms.common.workflow;

import java.util.Properties;

/**
 * Class where the default values for the GeneSEZ meta models and slots are
 * defined.
 * 
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-08-20
 */
public abstract class WorkflowProperties {
	
	/**
	 * Default values for GeneSEZ meta models and slots.
	 */
	public static final Properties defaults = new Properties();
	static {
		defaults.setProperty("slot", "coremodel");
		defaults.setProperty("coreSlot", "coremodel");
		defaults.setProperty("reqSlot", "reqmodel");
		defaults.setProperty("traceSlot", "tracemodel");
		defaults.setProperty("gcorePackage", "de.genesez.metamodel.gcore.GcorePackage");
		defaults.setProperty("greqPackage", "de.genesez.metamodel.greq.GreqPackage");
		defaults.setProperty("gtracePackage", "de.genesez.metamodel.gtrace.GtracePackage");
	}
}
