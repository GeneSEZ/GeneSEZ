package org.genesez.metamodel.gtrace;

import org.genesez.metamodel.gtrace.GtraceFactory;
import org.genesez.metamodel.gtrace.GtracePackage;
import org.genesez.metamodel.gtrace.impl.GtraceAdaptedFactoryImpl;


public class AdaptedFactoryActivator {
	
	private GtraceFactory usual = GtracePackage.eINSTANCE.getGtraceFactory();
	private GtraceFactory factory = new GtraceAdaptedFactoryImpl();
	
	public void enable() {
		GtracePackage.eINSTANCE.setEFactoryInstance(factory);
	}
	
	public void disable() {
		GtracePackage.eINSTANCE.setEFactoryInstance(usual);
	}
}
