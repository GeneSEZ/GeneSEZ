package de.genesez.platform.typo3.extbase.scripts;

import java.util.ArrayList;
import java.util.List;

import de.genesez.metamodel.gcore.MElement;
import de.genesez.metamodel.gcore.MModel;
import de.genesez.metamodel.gcore.MOperation;
import de.genesez.platforms.common.AccessHelper;

public class Conversion {

	public static List<String> asControllerActionPairs(MModel model, List<String> xmiGuids) {
		List<String> controllerActions = new ArrayList<String>();
		List<String> controllers = new ArrayList<String>();
		List<String> actions = new ArrayList<String>();
		String controller;
		Integer controllerIndex;
		String action;

		for (String xmiGuid : xmiGuids) {
			MElement elem = AccessHelper.getMElement(model, xmiGuid);
			if (elem instanceof MOperation) {
				controller = ((MOperation) elem).getClassifier().getName();
				action = ((MOperation) elem).getName();

				// Rewrite the controller name
				controller = controller.substring(controller.lastIndexOf("_") + 1);
				controller = controller.substring(0, controller.lastIndexOf("Controller"));

				// Rewrite the action name
				action = action.substring(0, action.lastIndexOf("Action"));

				if (!controllers.contains(controller)) {
					controllers.add(controller);
					actions.add(action);
				} else {
					controllerIndex = controllers.indexOf(controller);
					actions.set(controllerIndex, actions.get(controllerIndex) + ", " + action);
				}
			}
		}

		for (int i = 0; i < controllers.size(); i++) {
			controllerActions.add("'" + controllers.get(i) + "' => '" + actions.get(i) + "'");
		}
		return controllerActions;
	}

}
