package de.genesez.adapter.ea;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.FlowFinalNode;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.internal.impl.ActivityImpl;

public class ElementFactory {

	private final static Log log = LogFactory.getLog(ElementFactory.class);

	/**
	 * Creates children element of a package
	 * @param e	the children element
	 * @param p	the UML package
	 */
	public static void create(org.sparx.Element e, Package p) {
		log.info("Create Element for " + e.GetName());
		
		if ( e.GetType().equals("Actor") ) {
			log.info("Element is an Actor");
			Actor actor = UMLFactory.eINSTANCE.createActor();
			actor.setPackage(p);
			TransformHelper.transform(e, actor);
		}
		else if ( e.GetType().equals("UseCase") ) {
			log.info("Element is a UseCase");
			UseCase usecase = UMLFactory.eINSTANCE.createUseCase();
			usecase.setPackage(p);
			TransformHelper.transform(e, usecase);
		}
	}
	
	/**
	 * Creates children element of a usecase
	 * @param e
	 * @param u
	 */
	public static void create(org.sparx.Element e, UseCase u) {
		log.info("Create Element for " + e.GetName());

		if ( e.GetType().equals("Activity") ) {
			log.info("Element is an Activity");
			Activity activity = UMLFactory.eINSTANCE.createActivity();
			activity = (Activity)u.createOwnedBehavior(e.GetName(), activity.eClass());
			TransformHelper.transform(e, activity);
		}
	}
	
	/**
	 * Creates children element of an activity
	 * @param e
	 * @param a
	 */
	public static void create(org.sparx.Element e, Activity a) {
		log.debug("Create Element for " + e.GetName());

		if ( e.GetType().equals("Action") && e.GetClassfierID() > 0) {
			log.info("Element is a CallBehaviourAction");
			Action action = UMLFactory.eINSTANCE.createCallBehaviorAction();
			action.setActivity(a);
			TransformHelper.transform(e, action);
		}
		else if ( e.GetType().equals("Action")) {
			log.info("Element is an Action");
			Action action = UMLFactory.eINSTANCE.createCallOperationAction();
			action.setActivity(a);
			TransformHelper.transform(e, action);
		}
		else if (e.GetType().equals("Activity") ) {
			log.info("Element is an Activity");
			Activity activity = UMLFactory.eINSTANCE.createActivity();
			activity = (Activity)a.createOwnedBehavior(e.GetName(), activity.eClass());
			TransformHelper.transform(e, activity);
		}
		else if (e.GetType().equals("StateNode") && e.GetSubtype() == 100 ) {
			log.info("Element is an ActivityInitial");
			InitialNode initialNode = UMLFactory.eINSTANCE.createInitialNode();
			initialNode.setActivity(a);
			TransformHelper.transform(e, initialNode);
		}
		else if (e.GetType().equals("StateNode") && e.GetSubtype() == 101 ) {
			log.info("Element is an ActivityFinial");
			ActivityFinalNode finalNode = UMLFactory.eINSTANCE.createActivityFinalNode();
			finalNode.setActivity(a);
			TransformHelper.transform(e, finalNode);
		}
		else if (e.GetType().equals("StateNode") && e.GetSubtype() == 102 ) {
			log.info("Element is an FlowFinal");
			FlowFinalNode finalNode = UMLFactory.eINSTANCE.createFlowFinalNode();
			finalNode.setActivity(a);
			TransformHelper.transform(e, finalNode);
		}

	}

	/**
	 * Creates children element of an action
	 * @param e
	 * @param a
	 */
	public static void create(org.sparx.Element e, Action a) {
		log.debug("Create Element for " + e.GetName());
		
		if (e.GetType().equals("Activity") ) {
			log.info("Element is an Activity");
			Activity activity = UMLFactory.eINSTANCE.createActivity();
			TransformHelper.transform(e, activity);
		}
	}
}
