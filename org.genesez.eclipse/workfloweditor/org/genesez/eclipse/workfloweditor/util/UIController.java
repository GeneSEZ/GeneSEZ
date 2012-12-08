package org.genesez.eclipse.workfloweditor.util;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.mwe2.language.Mwe2StandaloneSetup;
import org.eclipse.emf.mwe2.language.mwe2.Component;
import org.eclipse.emf.mwe2.language.mwe2.Module;
import org.eclipse.emf.mwe2.language.mwe2.Mwe2Factory;
import org.eclipse.emf.mwe2.runtime.workflow.Workflow;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.ClasspathTypeProviderFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.IJdtTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.genesez.eclipse.workfloweditor.WorkflowEditor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class UIController {

	private final IFile file;
	private final Mwe2Factory mwe2Factory = Mwe2Factory.eINSTANCE;
	private Module module = null;
	private Component root = null;
	private final XtextResourceSet rSet = new XtextResourceSet();
	private final Resource fileResource;
	private IJvmTypeProvider typeProvider;
	private final WorkflowEditor editor;
	private boolean fresh = false;

	public UIController(IFile file, WorkflowEditor editor) {
		this.file = file;
		this.editor = editor;
		this.fileResource = rSet.getResource(URI.createFileURI(file.getLocationURI().getPath()), true);
	}

	@PostConstruct
	public void initialize() {
		Injector injector = new Mwe2StandaloneSetup().createInjectorAndDoEMFRegistration();

		fresh = setModuleInternal();

		if (fresh) {
			rSet.setClasspathURIContext(JavaCore.create(file.getProject()));
			JdtTypeProviderFactory jtpf = injector.getInstance(JdtTypeProviderFactory.class);
			typeProvider = jtpf.createTypeProvider(rSet);
		} else {
			ClasspathTypeProviderFactory ctpf = injector.getInstance(ClasspathTypeProviderFactory.class);
			typeProvider = ctpf.createTypeProvider(rSet);
		}

		root = getRootInternal();
	}

	public Module getModule() {
		return module;
	}

	public Component getRootComponent() {
		return root;
	}

	public JvmType getType(Class<?> clazz) {
		return typeProvider.findTypeByName(clazz.getName());
	}

	public JvmOperation getSpecificOperation(JvmDeclaredType type, final String methodName, final String... params) {

		return Iterables.find(Iterables.filter(type.getAllFeatures(), JvmOperation.class), new Predicate<JvmOperation>() {
			@Override
			public boolean apply(JvmOperation op) {
				List<JvmFormalParameter> parameters = op.getParameters();
				if (!(op.getSimpleName().equalsIgnoreCase(methodName) && parameters.size() == params.length)) {
					return false;
				}
				for (int i = 0; i < params.length; i++) {
					if (!parameters.get(i).getParameterType().getQualifiedName().equals(params[i])) {
						return false;
					}
				}
				return true;
			}
		});
	}

	public void serialize() {
		if (module.getCanonicalName() == null || module.getCanonicalName().equals("")) {
			module.setCanonicalName(file.getName());
		}

		try {
			fileResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean setModuleInternal() {
		List<EObject> list = fileResource.getContents();
		if (list.isEmpty() || !(list.get(0) instanceof Module)) {
			Module m = mwe2Factory.createModule();
			fileResource.getContents().add(m);
			this.module = m;
			return false;
		}
		module = (Module) list.get(0);
		return true;
	}

	private Component getRootInternal() {
		Component root = module.getRoot();
		if (root != null && root.getType().equals(getType(Workflow.class))) {
			return root;
		}
		root = mwe2Factory.createComponent();
		root.setType(getType(Workflow.class));
		module.setRoot(root);
		editor.setDirty(true);
		return root;
	}
}
