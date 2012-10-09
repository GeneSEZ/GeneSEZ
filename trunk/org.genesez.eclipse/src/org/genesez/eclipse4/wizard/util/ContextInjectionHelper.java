package org.genesez.eclipse4.wizard.util;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.swt.widgets.Composite;

@SuppressWarnings("restriction")
public class ContextInjectionHelper {
	
	/**
	 * Makes a child context and injects the given classes into it, also a guiElement is inserted into the context
	 * @param parent The parent Object for this Context
	 * @param context the parent context
	 * @param guiElement the gui element which is used for adding to the context
	 * @param classes the classes that should use this new context
	 * @return
	 */
	public static IEclipseContext makeAndInjectIntoChildContext(Object parent, IEclipseContext context, Composite guiElement, Class<?>... classes){
		IEclipseContext childContext = EclipseContextFactory.create();
		ContextInjectionFactory.inject(parent, childContext);
		childContext.setParent(context);
		childContext.set(Composite.class, guiElement);
		for(Class<?> clazz : classes){
			ContextInjectionFactory.make(clazz, childContext);
		}
		return childContext;
	}

}
