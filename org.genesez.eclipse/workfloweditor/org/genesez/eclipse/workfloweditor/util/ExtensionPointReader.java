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
 * 
 * @author dom
 * @noextend Should not be extended.
 */
public class ExtensionPointReader {

	private static final String COMPONENT_STRING = "workflowComponent";
	private static final String CLASS_ATTRIBUTE = "class";
	
	private static List<WorkflowComponent> components;
	private static Map<IExtension, List<WorkflowComponent>> extensionComponents = new HashMap<IExtension, List<WorkflowComponent>>();
	private static boolean isInit = false;
	
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

	private static void loadPluginObject(IExtension extension) {
		IConfigurationElement[] elements = extension.getConfigurationElements();
		for (int j = 0; j < elements.length; j++) {
			IConfigurationElement element = elements[j];
			String name = element.getName();
			try {
				if(name.equals(COMPONENT_STRING)){
					components.add((WorkflowComponent) element.createExecutableExtension(CLASS_ATTRIBUTE));
				}
			} catch (ClassCastException cce) {
				cce.printStackTrace();
			} catch (CoreException ce) {
				ce.printStackTrace();
			}
		}
	}
	
	public static Map<IExtension, List<WorkflowComponent>> getAvailableWorkflowComponents(){
		if(!isInit)
			initExtensions();
		return extensionComponents;
	}
	
	private ExtensionPointReader(){}
}
