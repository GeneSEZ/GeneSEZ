package de.genesez.core.project;

import org.eclipse.emf.ecore.EPackage;

/**
 * A bean for oAW workflows to register the java implementation of the project metamodel
 * @author gbeine
 *
 */
public class ProjectMetaModelRegistration {
	
	public static final String nsURI = "http://www.genesez.de/dsl/project";
	
    static {
	    register();
	}
	
    /**
     * Register the metamodel for project dsl
     */
	private static void register() {
		if (EPackage.Registry.INSTANCE.get(ProjectMetaModelRegistration.nsURI) == null) {
			EPackage.Registry.INSTANCE.put(ProjectMetaModelRegistration.nsURI, ProjectPackage.eINSTANCE); 
		}
	}
   	
}
