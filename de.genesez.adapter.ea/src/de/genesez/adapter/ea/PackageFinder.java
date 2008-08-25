package de.genesez.adapter.ea;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.AbstractWorkflowComponent;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;
import org.sparx.Package; 

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
	
	public void invoke(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
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

	public void setInputSlot(String value) {
		log.debug("Setting inputSlot to " + value);
		this.inputSlot = value;
	}

	public void setOutputSlot(String value) {
		log.debug("Setting outputSlot to " + value);
		this.outputSlot = value;
	}
	
	public void setPackagePath(String value) {
		log.debug("Setting packagePath to " + value);
		this.packagePath = value;
	}
	
	private Package findPackage() {
		if ( this.inputModel.GetName().equals(this.pkgPath[0])) {
			return this.findPackage(this.inputModel, 1);
		}
		return null;
	}
	
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
