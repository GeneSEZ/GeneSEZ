/**
 * 
 */
package org.genesez.metamodel.gtrace.adapter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.genesez.metamodel.greq.RModel;
import org.genesez.metamodel.greq.RRequirement;
import org.genesez.metamodel.greq.RScenario;
import org.genesez.metamodel.greq.RScenarioStep;
import org.genesez.metamodel.greq.RSpecObject;
import org.genesez.metamodel.greq.extension.RTraceability;
import org.genesez.metamodel.gtrace.GtracePackage;
import org.genesez.metamodel.gtrace.TRequirementTrace;
import org.genesez.metamodel.gtrace.TScenarioStepTrace;
import org.genesez.metamodel.gtrace.TScenarioTrace;

import org.genesez.metamodel.gcore.MClassifier;
import org.genesez.metamodel.gcore.MElement;
import org.genesez.metamodel.gcore.MModel;
import org.genesez.metamodel.gcore.MOperation;
import org.genesez.metamodel.gcore.extension.MTraceability;

/**
 * @author dreamer
 */
public class TraceAdapter extends AdapterImpl {
	
	private static final TraceAdapter INSTANCE = new TraceAdapter();
	
	private MTraceability gcore = new MTraceability();
	private RTraceability greq = new RTraceability();
	
	
	protected TraceAdapter() {
		// ensure to use only one adapter for all observed model elements
	}
	
	public static TraceAdapter getInstance() {
		return INSTANCE;
	}
	
	@Override
	public boolean isAdapterForType(Object type) {
		return type == TraceAdapter.class;
	}
	
	@Override
	public void notifyChanged(Notification msg) {
//		System.out.println("[trace model] changed: " + msg);
		switch (msg.getEventType()) {
			// trace elements have only single valued references + attributes
			case Notification.SET :
				dispatchTrace(msg);
				break;
			case Notification.ADD :
			case Notification.ADD_MANY :
			case Notification.REMOVE :
			case Notification.REMOVE_MANY :
			case Notification.RESOLVE :
			default: break;
		}
	}
	
	// filter notification, just process a subset of features
	private void dispatchTrace(Notification msg) {
		if (msg.getFeature().equals(GtracePackage.Literals.TREQUIREMENT_TRACE__REQUIREMENT)
				|| msg.getFeature().equals(GtracePackage.Literals.TREQUIREMENT_TRACE__STRUCTURAL_ELEMENT)) {
			TRequirementTrace trace = (TRequirementTrace)msg.getNotifier();
			dispatch(trace, trace.getRequirement(), trace.getStructuralElement());
		} else if (msg.getFeature().equals(GtracePackage.Literals.TSCENARIO_TRACE__SCENARIO)
				|| (msg.getFeature().equals(GtracePackage.Literals.TSCENARIO_TRACE__CLASSIFIER))) {
			TScenarioTrace trace = (TScenarioTrace)msg.getNotifier();
			dispatch(trace, trace.getScenario(), trace.getClassifier());
		} else if (msg.getFeature().equals(GtracePackage.Literals.TSCENARIO_STEP_TRACE__SCENARIO_STEP)
				|| msg.getFeature().equals(GtracePackage.Literals.TSCENARIO_STEP_TRACE__OPERATION)) {
			TScenarioStepTrace trace = (TScenarioStepTrace)msg.getNotifier();
			dispatch(trace, trace.getScenarioStep(), trace.getOperation());
		}
	}
	
	// note: requirement or element or  both can be null
	private void dispatch(TRequirementTrace trace, RRequirement requirement, MElement element) {
		if (checkAndResolveEObject(requirement, element) && checkAndResolveEObject(element, requirement)) {
			gcore.init(getModel(element));
			gcore.assign(element, MTraceability.TStereotype.TRACEABILITY, MTraceability.TTag.REQUIREMENT_TRACE, getUri(trace));
			greq.init(getModel(requirement));
			greq.assign(requirement, RTraceability.TAnnotation.TRACEABILITY, RTraceability.TTag.REQUIREMENT_TRACE, getUri(trace));
		}
	}
	
	private void dispatch(TScenarioTrace trace, RScenario scenario, MClassifier classifier) {
		if (checkAndResolveEObject(scenario, classifier) && checkAndResolveEObject(classifier, scenario)) {
			gcore.init(getModel(classifier));
			gcore.assign(classifier, MTraceability.TStereotype.TRACEABILITY, MTraceability.TTag.SCENARIO_TRACE, getUri(trace));
			greq.init(getModel(scenario));
			greq.assign(scenario, RTraceability.TAnnotation.TRACEABILITY, RTraceability.TTag.SCENARIO_TRACE, getUri(trace));
		}
	}
	
	private void dispatch(TScenarioStepTrace trace, RScenarioStep step, MOperation operation) {
		if (checkAndResolveEObject(step, operation) && checkAndResolveEObject(operation, step)) {
			gcore.init(getModel(operation));
			gcore.assign(operation, MTraceability.TStereotype.TRACEABILITY, MTraceability.TTag.SCENARIO_STEP_TRACE, getUri(trace));
			greq.init(getModel(step));
			greq.assign(step, RTraceability.TAnnotation.TRACEABILITY, RTraceability.TTag.SCENARIO_STEP_TRACE, getUri(trace));
		}
	}
	
	private <T extends EObject> boolean checkAndResolveEObject(T object, T helper) {
		if (object != null && helper != null) {
			Resource resource = helper.eResource();
			if (object.eIsProxy() && resource != null) {
				object = (T)EcoreUtil.resolve(object, resource);
			}
			if (!object.eIsProxy()) {
				return true;
			}
		}
		return false;
	}
	
	private MModel getModel(MElement element) {
		return (MModel) element.eResource().getEObject("/");
	}
	
	private RModel getModel(RSpecObject object) {
		return (RModel) object.eResource().getEObject("/");
	}
	
	private String getUri(EObject object) {
		return object.eResource().getURI().appendFragment(object.eResource().getURIFragment(object)).toString();
	}
}
