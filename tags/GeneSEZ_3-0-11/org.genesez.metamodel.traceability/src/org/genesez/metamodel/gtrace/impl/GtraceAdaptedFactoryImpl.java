package org.genesez.metamodel.gtrace.impl;

import org.genesez.metamodel.gtrace.TRequirementTrace;
import org.genesez.metamodel.gtrace.TScenarioStepTrace;
import org.genesez.metamodel.gtrace.TScenarioTrace;
import org.genesez.metamodel.gtrace.adapter.TraceAdapter;
import org.genesez.metamodel.gtrace.impl.GtraceFactoryImpl;


public class GtraceAdaptedFactoryImpl extends GtraceFactoryImpl {
	
	@Override
	public TRequirementTrace createTRequirementTrace() {
		TRequirementTrace rt = super.createTRequirementTrace();
		rt.eAdapters().add(TraceAdapter.getInstance());
		return rt;
	}
	
	@Override
	public TScenarioTrace createTScenarioTrace() {
		TScenarioTrace st = super.createTScenarioTrace();
		st.eAdapters().add(TraceAdapter.getInstance());
		return st;
	}
	
	@Override
	public TScenarioStepTrace createTScenarioStepTrace() {
		TScenarioStepTrace sst = super.createTScenarioStepTrace();
		sst.eAdapters().add(TraceAdapter.getInstance());
		return sst;
	}
}
