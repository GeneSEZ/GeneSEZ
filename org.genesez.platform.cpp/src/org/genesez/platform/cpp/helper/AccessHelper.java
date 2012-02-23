package org.genesez.platform.cpp.helper;

import org.genesez.metamodel.gcore.MClassifier;
import org.genesez.metamodel.gcore.MDefinitionContext;
import org.genesez.metamodel.gcore.MPackage;


/**
 * Provides helper methods for navigation within genesez models
 * @author dreamer
 */
public class AccessHelper {
	
	public static MPackage owningPackage(MClassifier classifier) {
		MDefinitionContext context = classifier.getOwningContext();
		if (context instanceof MPackage) {
			return (MPackage)context;
		}
		throw new RuntimeException("C++ Include-Helper: Only classifiers owned by a package are supported!");
	}
}
