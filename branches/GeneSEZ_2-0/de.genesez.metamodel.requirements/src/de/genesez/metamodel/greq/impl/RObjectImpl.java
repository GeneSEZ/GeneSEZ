package de.genesez.metamodel.greq.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.genesez.metamodel.greq.GreqPackage;
import de.genesez.metamodel.greq.RSpecObject;

/**
 * @author dreamer
 */
public class RObjectImpl extends EObjectImpl {
	
	@Override
	public String eURIFragmentSegment(EStructuralFeature eStructuralFeature, EObject eObject) {
		String fragment = super.eURIFragmentSegment(eStructuralFeature, eObject);
		if (eObject instanceof RSpecObject) {
			fragment = eStructuralFeature.getName() + "@" + eObject.eGet(GreqPackage.Literals.RSPEC_OBJECT__ID, true);
		}
		return fragment;
	}
	
	@Override
	public EObject eObjectForURIFragmentSegment(String uriFragmentSegment) {
//		System.out.println("fragment seqment: " + uriFragmentSegment);
		if (!uriFragmentSegment.startsWith("@")) {
			String[] parts = uriFragmentSegment.split("@");
			if (parts.length == 2) {
				EStructuralFeature feature = eClass().getEStructuralFeature(parts[0]);
				if (feature != null) {
					Object obj = eGet(feature);
					if (feature.isMany()) {
						EList<EObject> objs = (EList<EObject>)obj;
						for (EObject o : objs) {
							if (o instanceof RSpecObject) {
								if (((EObject) o).eGet(GreqPackage.Literals.RSPEC_OBJECT__ID, true).equals(parts[1])) {
									return (EObject)o;
								}
							}
						}
					} else {
						if (obj instanceof RSpecObject) {
							if (((RSpecObject) obj).getId().equals(parts[1])) {
								return (EObject)obj;
							}
						}
					}
				}
			}
			return null;
		}
		return super.eObjectForURIFragmentSegment(uriFragmentSegment);
	}
}
