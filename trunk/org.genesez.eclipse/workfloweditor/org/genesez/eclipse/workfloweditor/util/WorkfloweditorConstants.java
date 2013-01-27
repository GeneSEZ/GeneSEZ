/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.workfloweditor.util;

import org.genesez.eclipse.workfloweditor.ui.AvailableElementsPart;
import org.genesez.eclipse.workfloweditor.ui.renderer.WrapFeatureRenderer;

/**
 * Constants for use with the Context.
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
public class WorkfloweditorConstants {

	/** The ID of the Extension Point for the {@link AvailableElementsPart} */
	public static final String EXTENSION_POINT_ID = "org.genesez.workflow.registerelements";

	/** Needed to find the Composite of a {@link WrapFeatureRenderer} */
	public static final String CURRENT_FILLER = "current.label.filler";

	/** Needed to find the height data stored in the Composite */
	public static final String COMPOSITE_HEIGHT = "composite.heigth";

	// Contextelements

	/**
	 * To determine the selected WorkflowComponent from {@link AvailableElementsPart} (key == selected.workflow.component,
	 * valueType: {@link org.genesez.workflow.WorkflowComponent})
	 */
	public static final String SELECTED_WORKFLOWCOMPONENT = "selected.workflow.component";

	/**
	 * To determine the currently dragged WorkflowComponent (key == dragged.workflow.component.group, valueType:
	 * {@link org.eclipse.swt.widgets.Group})
	 */
	public static final String DRAGGED_WORKFLOWCOMPONENTGROUP = "dragged.workflow.component.group";

	/**
	 * To determine the currentTransfers for DND (key == current.dnd.transfers, valueType: Array of
	 * {@link org.eclipse.swt.dnd.Transfer})
	 */
	public static final String CURRENT_TRANSFERS = "current.dnd.transfers";

	/**
	 * To determine the Composite that should be decorated (key == decorator.composite, valueType:
	 * {@link org.eclipse.swt.widgets.Composite})
	 */
	public static final String DECORATED_COMPOSITE = "decorator.composite";

	/**
	 * To determine Renderer in which renderer to decorate the Composite (key == decorator.renderer, valueType:
	 * {@link org.genesez.eclipse.workfloweditor.ui.renderer.IFeatureRenderer})
	 */
	public static final String DECORATED_RENDERER = "decorator.renderer";

	private WorkfloweditorConstants() {
	}
}
