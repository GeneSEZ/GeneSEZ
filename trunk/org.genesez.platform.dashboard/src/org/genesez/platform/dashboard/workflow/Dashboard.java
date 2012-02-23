
package org.genesez.platform.dashboard.workflow;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.ConfigurationException;
import org.eclipse.emf.mwe.core.container.CompositeComponent;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.utils.DirectoryCleaner;
import org.eclipse.xpand2.Generator;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;
import org.genesez.metamodel.gcore.GcorePackage;
import org.genesez.metamodel.greq.GreqPackage;
import org.genesez.metamodel.gtrace.GtracePackage;
import org.genesez.platform.common.workflow.Copier;
import org.genesez.platform.common.workflow.WorkflowProperties;
import org.genesez.platform.common.workflow.WorkflowUtils;

/**
 * Performs the generation of the GeneSEZ Dashboard.
 * @author tobias haubold
 */
public class Dashboard extends CompositeComponent {
	
	private static final Properties defaults = new Properties();
	static {
		defaults.putAll(WorkflowProperties.defaults);
		defaults.put("template", "org::genesez::platform::dashboard::Root::Root");
		defaults.put("crossModelNavigationAdvice", "org::genesez::metamodel::navigation::RequirementsTraceabilityExtensionAdvice");
	}
	
	private Log logger = LogFactory.getLog(getClass());
	private Properties properties = new Properties(defaults);
	private boolean useExtensionsForCrossModelNavigation = false;
	
	private EmfMetaModel gcore = new EmfMetaModel();
	private EmfMetaModel greq = new EmfMetaModel();
	private EmfMetaModel gtrace = new EmfMetaModel();
	
	private DirectoryCleaner cleaner = new DirectoryCleaner();
	private Copier copier = new Copier();
	private Generator generator = new Generator();
	
	public Dashboard() {
		super(Dashboard.class.getSimpleName());
		
		gcore.setMetaModelPackage(GcorePackage.class.getName());
		greq.setMetaModelPackage(GreqPackage.class.getName());
		gtrace.setMetaModelPackage(GtracePackage.class.getName());
		
		cleaner.setUseDefaultExcludes(false);
		
		generator.addMetaModel(gcore);
		generator.addMetaModel(greq);
		generator.addMetaModel(gtrace);
		
		generator.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("coremodel", properties.getProperty("coreSlot")));
		generator.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("reqmodel", properties.getProperty("reqSlot")));
		generator.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("tracemodel", properties.getProperty("traceSlot")));
		generator.setFileEncoding("utf-8");
		generator.setExpand(properties.getProperty("template") + " FOR " + properties.getProperty("traceSlot"));
		
		super.addComponent(cleaner);
		super.addComponent(copier);
		super.addComponent(generator);
	}
	
	@Override
	public void checkConfiguration(Issues issues) throws ConfigurationException {
		if (useExtensionsForCrossModelNavigation) {
			generator.addExtensionAdvice(properties.getProperty("crossModelNavigationAdvice"));
		}
		super.checkConfiguration(issues);
	}
	
	/**
	 * @param value	indicates the use of metamodel extensions instead of model queries for cross model navigation
	 */
	public void setUseExtensionsForCrossModelNavigation(Boolean value) {
		useExtensionsForCrossModelNavigation = value;
	}
	
	/**
	 * @param uri	the filename or uri of the output directory
	 */
	public void setOutputDir(String uri) {
		cleaner.setDirectory(uri);
		copier.setDestination(uri);
		generator.addOutlet(new Outlet(uri));
	}
	
	/**
	 * Note: this is just a workaround till we find out, how we can obtain the /template directory uri automatically
	 * @param uri	the filename or uri of the dashboard template directory
	 */
	public void setSource(String uri) {
		copier.setSource(uri);
	}
}
