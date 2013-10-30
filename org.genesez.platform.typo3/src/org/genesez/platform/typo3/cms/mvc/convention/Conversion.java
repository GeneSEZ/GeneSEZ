package org.genesez.platform.typo3.cms.mvc.convention;

/*
 * (c) GeneSEZ Research Group
 * All rights reserved.
 *
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */

import java.util.ArrayList;
import java.util.List;

import org.genesez.metamodel.gcore.MOperation;

/**
 * Utility class for TYPO3 CMS specific Extbase naming conventions.
 * 
 * @author	Nico Herbig <nico.herbig@fh-zwickau.de> (maintainer)
 */
public class Conversion {

	/**
	 * This method convert assigned controller actions of a TYPO3 CMS plugin or module. 
	 * In every TYPO3 CMS specific Extbase plugin and module stereotype it is possible 
	 * to store a list of methods for controller actions. 
	 * E.g.: If a plugin needs the following controller actions:
	 *       * 'BlogController' -> 'indexAction, listAction' and 
	 *       * 'PostController' -> 'indexAction'. 
	 *       This method returns a string list with two entries: 
	 *       * [0] : 'Blog' => 'index, list' and 
	 *       * [1] : 'Post' => 'index'.
	 * 
	 * @param	operations	The list of operations (controller actions).
	 * @return 	The list of valid controller actions.
	 */
	public static List<String> asControllerActionPairs(List<MOperation> operations) throws Exception {
		List<String> controllerActions = new ArrayList<String>();
		List<String> controllers = new ArrayList<String>();
		List<String> actions = new ArrayList<String>();
		String controllerName;
		Integer controllerIndex;
		String actionName;

		for (MOperation operation : operations) {
			// get controller name where the controller action is owned
			controllerName = getControllerName(operation);

			// get controller action name
			actionName = getControllerActionName(operation);

			// check if the controller already exists inside the controller list
			if (!controllers.contains(controllerName)) {
				// ... if not a new controller and action entry is added
				controllers.add(controllerName);
				actions.add(actionName);
			} else {
				// ... otherwise the index of the existing controller is searched
				controllerIndex = controllers.indexOf(controllerName);
				// and the new action is added at the same index seperated by a comma
				actions.set(controllerIndex, actions.get(controllerIndex) + ", " + actionName);
			}
		}

		// This loop iterates over all controllers inside the conroller list and
		// transforms the controllers and actions to be valid TYPO3 CMS specific Extbase controller action pairs.
		for (int i = 0; i < controllers.size(); i++) {
			controllerActions.add("'" + controllers.get(i) + "' => '" + actions.get(i) + "'");
		}
		
		return controllerActions;
	}

	/**
	 * Returns the name of the controller without the 'Controller' suffix for a given controller action.
	 * 
	 * @param 	controllerAction	The given controller action.
	 * @return 	The name of the controller.
	 */
	private static String getControllerName(MOperation controllerAction) {
		String controllerName;

		// extract controller name where the controller action is owned
		controllerName = ((MOperation) controllerAction).getClassifier().getName();

		// rewrite controller name if required
		if (controllerName.endsWith("Controller")) {
			controllerName = controllerName.substring(0, controllerName.lastIndexOf("Controller"));
		}
		return controllerName;
	}

	/**
	 * Returns the name of the controller action without the 'Action' suffix for a given controller action.
	 * 
	 * @param	controllerAction	The given controller action.
	 * @return	The name of the controller action.
	 */
	private static String getControllerActionName(MOperation controllerAction) {
		String controllerActionName;

		// extract controller action name
		controllerActionName = ((MOperation) controllerAction).getName();

		// rewrite action name if required
		if (controllerActionName.endsWith("Action")) {
			controllerActionName = controllerActionName.substring(0, controllerActionName.lastIndexOf("Action"));
		}
		return controllerActionName;
	}

}
