package org.genesez.eclipse.workfloweditor.ui.renderer.collection;

import java.lang.reflect.Field;
import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.genesez.eclipse.workfloweditor.ui.renderer.FieldRenderer;
import org.genesez.eclipse.workfloweditor.util.ClassHelper;
import org.genesez.eclipse.workfloweditor.util.WorkfloweditorConstants;
import org.genesez.workflow.WorkflowComponent;
import org.genesez.workflow.profile.Parameter;

@SuppressWarnings("restriction")
public abstract class AbstractCollectionRenderer implements FieldRenderer {

	protected Image addImage = null;
	protected Image remImage = null;
	protected Composite parent = null;
	protected IEclipseContext context = null;

	@Inject
	@Named(WorkfloweditorConstants.HEAD_COMPOSITE)
	protected Composite headComposite;

	public AbstractCollectionRenderer() {
	}

	@Override
	public boolean renderElement(Composite parent, Field field, Parameter param, WorkflowComponent instance,
			IWorkbench workbench, IEclipseContext context) {
		this.parent = parent;
		this.context = context;
		ContextInjectionFactory.inject(this, context);
		if (workbench != null) {
			ISharedImages eclipseImages = workbench.getSharedImages();
			remImage = eclipseImages.getImage(ISharedImages.IMG_ETOOL_CLEAR);
			addImage = eclipseImages.getImage(ISharedImages.IMG_OBJ_ADD);
		}
		if (ClassHelper.isSubtypeOf(field.getType(), Collection.class)) {
			return renderList(field, param, instance);
		}
		return false;
	}

	protected abstract boolean renderList(Field field, Parameter param, WorkflowComponent instance);

}
