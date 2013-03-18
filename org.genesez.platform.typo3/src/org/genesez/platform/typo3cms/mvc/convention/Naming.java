package org.genesez.platform.typo3cms.mvc.convention;

import java.util.ArrayList;
import java.util.List;

import org.genesez.metamodel.gcore.MOperation;
import org.genesez.metamodel.gcore.MProperty;

/**
 * Utility class for TYPO3 MVC naming conventions.
 * 
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2012-02-17
 */
public class Naming {

	/**
	 * This method is for all attributes and association roles of a domain
	 * object. It converts the property name to get an valid property name in
	 * configuration and localization environment. It splits the property name
	 * by every capital letter, transform every token to lower case and add
	 * underscores between of them. For instance: the property name is
	 * 'relatedPosts' it converts to 'related_posts'.
	 * 
	 * @param property The property.
	 * @return The property name in lower case and with underscores.
	 */
	public static String toLowerPropertyName(MProperty property) {
		StringBuffer propertyName = new StringBuffer();
		String[] propertyNameParts;

		propertyNameParts = property.getName().split("(?=[A-Z])");
		for (int i = 0; i < propertyNameParts.length; i++) {
			propertyName.append(propertyNameParts[i].toLowerCase());
			if (i < propertyNameParts.length - 1) {
				propertyName.append("_");
			}
		}
		return propertyName.toString();
	}

	/**
	 * This method convert assigned controller actions of a TYPO3 MVC plugin or
	 * module. In every plugin or module stereotype it is possible to store a
	 * list of methods for controller actions. For instance: The plugin needs
	 * the following controller actions 'BlogController' -> 'indexAction,
	 * listAction' and 'PostController' -> 'indexAction'. This method returns a
	 * string list with two entries: [0] : 'Blog' => 'index, list' and [1] :
	 * 'Post' => 'index'.
	 * 
	 * @param operations The list of operations (controller actions).
	 * @return The list of valid controller actions.
	 */
	public static List<String> asControllerActionPairs(List<MOperation> operations) throws Exception {
		List<String> controllerActions = new ArrayList<String>();
		List<String> controllers = new ArrayList<String>();
		List<String> actions = new ArrayList<String>();
		String controller;
		Integer controllerIndex;
		String action;

		for (MOperation operation : operations) {
			// Get the controller name where the controller action is owned
			controller = getControllerName(operation);

			// Get the controller action name
			action = getControllerActionName(operation);

			// Check if the controller already exists inside the controller
			// list or not
			if (!controllers.contains(controller)) {
				// If not a new controller and action entry is added
				controllers.add(controller);
				actions.add(action);
			} else {
				// Otherwise the index of the existing controller is
				// searched
				controllerIndex = controllers.indexOf(controller);
				// At the same index the new action is added
				actions.set(controllerIndex, actions.get(controllerIndex) + ", " + action);
			}
		}

		// This loop transforms controllers and actions to be valid TYPO3
		// Extbase controller action pairs.
		for (int i = 0; i < controllers.size(); i++) {
			controllerActions.add("'" + controllers.get(i) + "' => '" + actions.get(i) + "'");
		}
		return controllerActions;
	}

	/**
	 * Gets the name of the controller without the 'Controller' suffix for a
	 * given controller action.
	 * 
	 * @param controllerAction The given controller action.
	 * @return The name of the controller.
	 */
	private static String getControllerName(MOperation controllerAction) {
		String controller;

		// Extract the controller name where the controller action is owned
		controller = ((MOperation) controllerAction).getClassifier().getName();

		// Rewrite the controller name
		if (controller.endsWith("Controller")) {
			controller = controller.substring(0, controller.lastIndexOf("Controller"));
		}
		return controller;
	}

	/**
	 * Gets the name of the controller action without the 'Action' suffix for a
	 * given controller action.
	 * 
	 * @param controllerAction The given controller action.
	 * @return The name of the controller action.
	 */
	private static String getControllerActionName(MOperation controllerAction) {
		String action;

		// Extract the controller action name
		action = ((MOperation) controllerAction).getName();

		// Rewrite the action name
		if (action.endsWith("Action")) {
			action = action.substring(0, action.lastIndexOf("Action"));
		}
		return action;
	}

}
