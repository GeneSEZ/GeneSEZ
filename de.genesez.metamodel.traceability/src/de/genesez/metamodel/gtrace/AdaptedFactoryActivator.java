package de.genesez.metamodel.gtrace;

import de.genesez.metamodel.gtrace.impl.GtraceAdaptedFactoryImpl;

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
