package de.genesez.adapter.ea;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.FlowFinalNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UseCase;

public class ElementFactory {

	private final static Log log = LogFactory.getLog(ElementFactory.class);

	/**
	 * Creates children element of a package
	 * @param e	the children element
	 * @param p	the UML package
	 */
	public static void create(org.sparx.Element e, Package p, TransformHelper _t) {
		log.info("Create Element for " + e.GetName());

		TransformHelper t = new TransformHelper();

		if ( e.GetType().equals("Actor") ) {
			log.info("Element is an Actor");
			Actor actor = UMLFactory.eINSTANCE.createActor();
			actor.setPackage(p);
			t.transform(e, actor);
		}
		else if ( e.GetType().equals("UseCase") ) {
			log.info("Element is a UseCase");
			UseCase usecase = UMLFactory.eINSTANCE.createUseCase();
			usecase.setPackage(p);
			t.transform(e, usecase);
		}
	}
	
	/**
	 * Creates children element of a usecase
	 * @param e
	 * @param u
	 */
	public static void create(org.sparx.Element e, UseCase u, TransformHelper _t) {
		log.info("Create Element for " + e.GetName());

		TransformHelper t = new TransformHelper();

		if ( e.GetType().equals("Activity") ) {
			log.info("Element is an Activity");
			Activity activity = UMLFactory.eINSTANCE.createActivity();
			activity = (Activity)u.createOwnedBehavior(e.GetName(), activity.eClass());
			t.transform(e, activity);
		}
	}
	
	/**
	 * Creates children element of an activity
	 * @param e
	 * @param a
	 */
	public static void create(org.sparx.Element e, Activity a, TransformHelper _t) {
		log.debug("Create Element for " + e.GetName());

		if ( e.GetType().equals("Action") && e.GetClassfierID() > 0) {
			log.info("Element is a CallBehaviourAction");
			Action action = UMLFactory.eINSTANCE.createCallBehaviorAction();
			action.setActivity(a);
			_t.transform(e, action);
		}
		else if ( e.GetType().equals("Action")) {
			log.info("Element is an Action");
			Action action = UMLFactory.eINSTANCE.createCallOperationAction();
			action.setActivity(a);
			_t.transform(e, action);
		}
		else if (e.GetType().equals("Activity") ) {
			log.info("Element is an Activity");
			Activity activity = UMLFactory.eINSTANCE.createActivity();
			activity = (Activity)a.createOwnedBehavior(e.GetName(), activity.eClass());
			TransformHelper t = new TransformHelper();
			t.transform(e, activity);
		}
		else if (e.GetType().equals("StateNode") && e.GetSubtype() == 100 ) {
			log.info("Element is an ActivityInitial");
			InitialNode initialNode = UMLFactory.eINSTANCE.createInitialNode();
			initialNode.setActivity(a);
			_t.transform(e, initialNode);
		}
		else if (e.GetType().equals("StateNode") && e.GetSubtype() == 101 ) {
			log.info("Element is an ActivityFinial");
			ActivityFinalNode finalNode = UMLFactory.eINSTANCE.createActivityFinalNode();
			finalNode.setActivity(a);
			_t.transform(e, finalNode);
		}
		else if (e.GetType().equals("StateNode") && e.GetSubtype() == 102 ) {
			log.info("Element is an FlowFinal");
			FlowFinalNode finalNode = UMLFactory.eINSTANCE.createFlowFinalNode();
			finalNode.setActivity(a);
			_t.transform(e, finalNode);
		}

	}

	/**
	 * Creates activity edges
	 * @param c
	 * @param a
	 */
	public static void create(org.sparx.Connector c, Activity a, TransformHelper _t) {
		log.debug("Create connector " + c.GetConnectorGUID());
		
		// at the moment we create only control flows
		ControlFlow activityEdge = UMLFactory.eINSTANCE.createControlFlow();
		activityEdge = (ControlFlow)a.createEdge(c.GetName(), activityEdge.eClass());
		_t.transform(c, activityEdge);
	}
	
	/**
	 * Creates children element of an action
	 * @param e
	 * @param a
	 */
	public static void create(org.sparx.Element e, Action a, TransformHelper _t) {
		log.debug("Create Element for " + e.GetName());
		
		TransformHelper t = new TransformHelper();

		// Maybe, an action contains an activity as a child element
		// Then, the real parent of this activity would be the actions parent activity
		if (e.GetType().equals("Activity") ) {
			log.info("Element is an Activity");
			Activity activity = UMLFactory.eINSTANCE.createActivity();
			activity = (Activity)a.getActivity().createOwnedBehavior(e.GetName(), activity.eClass());
			t.transform(e, activity);
		}
	}
}
