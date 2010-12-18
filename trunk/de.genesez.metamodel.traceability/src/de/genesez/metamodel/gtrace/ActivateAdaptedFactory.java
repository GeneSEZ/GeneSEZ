package de.genesez.metamodel.gtrace;

import de.genesez.metamodel.gtrace.impl.GtraceAdaptedFactoryImpl;

public class ActivateAdaptedFactory {
	static {
		GtracePackage p = GtracePackage.eINSTANCE;
//		GtraceFactory f = GtracePackage.eINSTANCE.getGtraceFactory();
		p.setEFactoryInstance(new GtraceAdaptedFactoryImpl());
		System.out.println(p.getGtraceFactory());
	}
}
