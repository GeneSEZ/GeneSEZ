package org.genesez.eclipse.workfloweditor.ui.renderer.collection;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.genesez.eclipse.workfloweditor.ui.BoxingComponent;
import org.genesez.eclipse.workfloweditor.util.ClassHelper;
import org.genesez.workflow.WorkflowComponent;
import org.genesez.workflow.profile.Parameter;

@SuppressWarnings("restriction")
public class WorkflowCollectionRenderer extends AbstractCollectionRenderer {

	private Group group;

	public WorkflowCollectionRenderer() {
	}

	@Override
	protected boolean renderList(Field field, Parameter param, WorkflowComponent instance) {
		try {
			@SuppressWarnings("rawtypes")
			Class genericClass = findGenericClass(field);
			if (genericClass != null) {
				if (ClassHelper.isSubtypeOf(genericClass, WorkflowComponent.class)) {
					group = new Group(parent, SWT.BORDER | SWT.SHADOW_IN);
					group.setText(field.getName());
					if (parent.getLayout() instanceof GridLayout) {
						group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
								((GridLayout) parent.getLayout()).numColumns, 1));
					}
					group.setLayout(new FillLayout());
					// UsedElementsPart part = new UsedElementsPart();
					BoxingComponent part = new BoxingComponent();
					IEclipseContext context = this.context.createChild();
					context.set(Composite.class, group);
					ContextInjectionFactory.inject(part, context);
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("rawtypes")
	private Class findGenericClass(Field field) {
		Type fieldGenType = field.getGenericType();
		if (fieldGenType instanceof ParameterizedType) {
			TypeVariable[] typeVars = field.getDeclaringClass().getTypeParameters();
			if (typeVars != null) {
				TypeVariable classTypeVar = typeVars[0];
				Type fieldType = field.getGenericType();
				if (fieldType instanceof ParameterizedType) {
					Type genericType = ((ParameterizedType) fieldType).getActualTypeArguments()[0];
					if (genericType instanceof TypeVariable) {
						if (classTypeVar.getName().equals(((TypeVariable) genericType).getName())) {
							return (Class) classTypeVar.getBounds()[0];
						}
					}
				}
			}

			Type actualTypeArg = ((ParameterizedType) fieldGenType).getActualTypeArguments()[0];

			if (actualTypeArg.getClass().equals(WorkflowComponent.class)) {
				return WorkflowComponent.class;
			}

			if (actualTypeArg instanceof WildcardType) {
				return (Class) ((WildcardType) actualTypeArg).getUpperBounds()[0];
			}
		}
		return null;
	}
}
