package de.genesez.adapter.ea;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.sparx.Package;

/**
 * An oAW workflow component to find a package within an Enterprise Architect model
 * 
 * @author gerbe
 *
 * The PackageFinder search for a Enterprise Architect package within a model
 * by a provided search path and set the package to the output slot.
 * The Enterprise Architect model needs to be located at the input slot.
 */
public class PackageFinder extends AbstractWorkflowComponent {

	private static final Log log = LogFactory.getLog(PackageFinder.class);

	private String inputSlot = null;
	private String outputSlot = null;
	private String packagePath = null;
	private String[] pkgPath = null;
	
	private Package inputModel = null;
	
	public void checkConfiguration(Issues issues) {
		this.pkgPath = this.packagePath.split("/");
		if ( 1 > this.pkgPath.length ) {
			issues.addError("Invalid package path");
		}
	}
	
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		log.info("Start searching Package " + this.packagePath);
		log.debug("Get model from slot: " + this.inputSlot);
		this.inputModel = (Package) ctx.get(this.inputSlot);
		if ( null == this.inputModel ) {
			issues.addError("No model in inputSlot");
		}
		Package outputPackage = this.findPackage();
		if ( null == outputPackage ) {
			issues.addError("Package " + this.packagePath + " not found in model");
		}
		ctx.set(this.outputSlot, outputPackage);	
	}

	/**
	 * Set the input slot from where to get the Enterprise Architect model
	 * @param value
	 */
	public void setInputSlot(String value) {
		log.debug("Setting inputSlot to " + value);
		this.inputSlot = value;
	}

	/**
	 * Set the output slot from where to put the Enterprise Architect package
	 * @param value
	 */
	public void setOutputSlot(String value) {
		log.debug("Setting outputSlot to " + value);
		this.outputSlot = value;
	}
	
	/**
	 * Set the path to the package
	 * @param value
	 */
	public void setPackagePath(String value) {
		log.debug("Setting packagePath to " + value);
		this.packagePath = value;
	}
	
	/**
	 * Start searching for the package
	 * @return
	 */
	private Package findPackage() {
		if ( this.inputModel.GetName().equals(this.pkgPath[0])) {
			return this.findPackage(this.inputModel, 1);
		}
		return null;
	}
	
	/**
	 * Helper method to find the package 
	 * @param _p	The package to process
	 * @param depth	The current depth within package path
	 * @return	The searched package or null 
	 */
	private Package findPackage(Package _p, int depth) {
		if ( this.pkgPath.length == depth ) {
			return _p;
		} else {
			for ( Package p : _p.GetPackages() ) {
				if ( p.GetName().equals(this.pkgPath[depth]) ) {
					return this.findPackage(p, depth+1);
				}
			}
		}
		return null;
	}
}
