package de.genesez.core.project;

import org.eclipse.emf.ecore.EPackage;

/**
 * A bean for oAW workflows to register the java implementation of the project metamodel
 * @author gbeine
 *
 */
public class ProjectMetaModelRegistration {
	
    static {
	    register();
	}
	
    /**
     * Register the metamodel for project dsl
     */
	private static void register() {
		String nsURI = "http://www.genesez.de/dsl/project";
		if (EPackage.Registry.INSTANCE.get(nsURI) == null) {
			EPackage.Registry.INSTANCE.put(nsURI, ProjectPackage.eINSTANCE); 
		}
	}
   	
}
