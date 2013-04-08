package org.genesez.adapter.ea;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_12d203c6_1328866905812_18982_1969) 
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.uml.Package;

/**
 * An oAW workflow component to find a package within an Enterprise Architect model
 * 
 * The PackageFinder search for a Enterprise Architect package within a model
 * by a provided search path and set the package to the output slot.
 * The Enterprise Architect model needs to be located at the input slot.
 * @author christian
 */

public class PackageFinder extends AbstractWorkflowComponent {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(PackageFinder.class);
	
	private String inputSlot;
	
	private String outputSlot;
	
	private String packagePath;
	
	private java.util.Set<String> pkgPath = new java.util.HashSet<String>();
	
	private Package inputModel;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	wc	
	 * @param	pm	
	 * @param	i	
	 */
	
	protected void invokeInternal(WorkflowContext wc, ProgressMonitor pm, Issues i) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363342407577_797486_2167) ENABLED START */
		// TODO: implementation of method 'PackageFinder.invokeInternal(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	i	
	 */
	
	public void checkConfiguration(Issues i) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363342418885_436538_2172) ENABLED START */
		// TODO: implementation of method 'PackageFinder.checkConfiguration(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_12d203c6_1328866905812_18982_1969) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
