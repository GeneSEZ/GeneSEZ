package de.genesez.metamodel.navigation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.mwe.utils.SingleGlobalResourceSet;

/**
 * @author dreamer
 */
public class EcoreUtil {
	public static EObject resolve(String uri) {
//		System.out.println("[uri] " + uri);
		ResourceSet rs = SingleGlobalResourceSet.get();
		URI eobject = URI.createURI(uri);
		Resource r = rs.getResource(eobject.trimFragment(), true);
		EObject obj = r.getEObject(eobject.fragment());
//		System.out.println("[eobject] " + obj);
		return obj;
	}
}
