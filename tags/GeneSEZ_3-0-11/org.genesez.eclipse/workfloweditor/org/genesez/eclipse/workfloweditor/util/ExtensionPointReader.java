/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.workfloweditor.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.genesez.workflow.WorkflowComponent;

/**
 * Helper class to read the information from the ExtensionPoint with ID {@link WorkfloweditorConstants#EXTENSION_POINT_ID}.
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * @noextend Should not be extended.
 */
public class ExtensionPointReader {

	private static final String COMPONENT_STRING = "workflowComponent";
	private static final String CLASS_ATTRIBUTE = "class";

	private static List<WorkflowComponent> components;
	private static Map<IExtension, List<WorkflowComponent>> extensionComponents = new HashMap<IExtension, List<WorkflowComponent>>();
	private static boolean isInit = false;

	/**
	 * Initializes the extensions
	 */
	private static void initExtensions() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = registry.getExtensionPoint(WorkfloweditorConstants.EXTENSION_POINT_ID);
		IExtension[] extensions = extensionPoint.getExtensions();
		for (int i = 0; i < extensions.length; i++) {
			IExtension extension = extensions[i];
			components = new ArrayList<WorkflowComponent>();
			loadPluginObject(extension);
			extensionComponents.put(extension, components);
		}
		isInit = true;
	}

	/**
	 * Load components from PluginExtensions
	 * 
	 * @param extension
	 *            the extension that should be read
	 * 
	 */
	private static void loadPluginObject(IExtension extension) {
		IConfigurationElement[] elements = extension.getConfigurationElements();
		for (int j = 0; j < elements.length; j++) {
			IConfigurationElement element = elements[j];
			String name = element.getName();
			try {
				if (name.equals(COMPONENT_STRING)) {
					components.add((WorkflowComponent) element.createExecutableExtension(CLASS_ATTRIBUTE));
				}
			} catch (ClassCastException cce) {
				cce.printStackTrace();
			} catch (CoreException ce) {
				ce.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * Gives a Map with available Extensions and the registered WorkflowComponents in them.
	 * 
	 * @return a Map with Extensions and a List of WorkflowComponents
	 */
	public static Map<IExtension, List<WorkflowComponent>> getAvailableWorkflowComponents() {
		if (!isInit) {
			initExtensions();
		}
		return extensionComponents;
	}

	private ExtensionPointReader() {
	}
}
