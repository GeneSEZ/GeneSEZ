package de.genesez.metamodel.gtrace.impl;

import de.genesez.metamodel.gtrace.TRequirementTrace;
import de.genesez.metamodel.gtrace.TScenarioStepTrace;
import de.genesez.metamodel.gtrace.TScenarioTrace;
import de.genesez.metamodel.gtrace.adapter.TraceAdapter;

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
