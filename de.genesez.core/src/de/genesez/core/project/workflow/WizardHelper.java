package de.genesez.core.project.workflow;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.core.JavaCore;
import org.openarchitectureware.core.builder.OawBuilder;
import org.openarchitectureware.core.builder.OawNature;

public final class WizardHelper {

	public static final Map<String,String> NATUREMAP = new HashMap<String, String>();
	public static final Map<String,String> BUILDERMAP = new HashMap<String, String>();
	public static final Map<String,String> CLASSPATHMAP = new HashMap<String, String>();
	static {
		WizardHelper.NATUREMAP.put("Java", JavaCore.NATURE_ID);
		WizardHelper.NATUREMAP.put("PDE", "org.eclipse.pde.PluginNature");
		WizardHelper.NATUREMAP.put("oaw", OawNature.NATURE_ID);
		WizardHelper.BUILDERMAP.put("Java", JavaCore.BUILDER_ID);
		WizardHelper.BUILDERMAP.put("Manifest", "org.eclipse.pde.ManifestBuilder");
		WizardHelper.BUILDERMAP.put("Schema", "org.eclipse.pde.SchemaBuilder");
		WizardHelper.BUILDERMAP.put("oaw", OawBuilder.getBUILDER_ID());
		WizardHelper.CLASSPATHMAP.put("Java", "org.eclipse.jdt.launching.JRE_CONTAINER");
		WizardHelper.CLASSPATHMAP.put("PDE", "org.eclipse.pde.core.requiredPlugins");
	}
}
