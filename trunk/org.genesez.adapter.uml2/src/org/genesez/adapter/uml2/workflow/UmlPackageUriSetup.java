package org.genesez.adapter.uml2.workflow;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Utility class which allows to set different namespace URIs for the currently registered UML EPackage.
 * 
 * @author tobias haubold <toh@fh-zwickau.de>
 */
public class UmlPackageUriSetup {
	
	/**
	 * Adds the specified URI as namespace URI (nsURI) for the currently available/installed UML version (UML EPackage).
	 * @param uri	a namespace URI to be registered in the EMF EPackage registry for the UML EPackage
	 */
	public void addUmlNsUri(String uri) {
		if (EPackage.Registry.INSTANCE.get(uri) == null) {
			EPackage.Registry.INSTANCE.put(uri, EPackage.Registry.INSTANCE.get(UMLPackage.eINSTANCE.getNsURI()));
		}
	}
}
