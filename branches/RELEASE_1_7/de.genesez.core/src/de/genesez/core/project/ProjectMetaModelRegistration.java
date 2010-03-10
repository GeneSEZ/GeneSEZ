package de.genesez.core.project;

import org.eclipse.emf.ecore.EPackage;

public class ProjectMetaModelRegistration {
	
    static {
	    register();
	}
	
	public static void register() {
		String nsURI = "http://www.genesez.de/dsl/project";
		if (EPackage.Registry.INSTANCE.get(nsURI) == null) {
			EPackage.Registry.INSTANCE.put(nsURI, ProjectPackage.eINSTANCE); 
		}
	}
   	
}
