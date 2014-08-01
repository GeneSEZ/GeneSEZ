package org.genesez.metamodel.gtrace;

import org.genesez.metamodel.gtrace.GtraceFactory;
import org.genesez.metamodel.gtrace.GtracePackage;
import org.genesez.metamodel.gtrace.impl.GtraceAdaptedFactoryImpl;


public class AdaptedFactoryActivator {
	
	private static GtraceFactory usual = GtracePackage.eINSTANCE.getGtraceFactory();
	private static GtraceFactory factory = new GtraceAdaptedFactoryImpl();
	
	public static void enable() {
		GtracePackage.eINSTANCE.setEFactoryInstance(factory);
	}
	
	public static void disable() {
		GtracePackage.eINSTANCE.setEFactoryInstance(usual);
	}
}
