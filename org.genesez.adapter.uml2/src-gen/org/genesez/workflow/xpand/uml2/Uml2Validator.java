package org.genesez.workflow.xpand.uml2;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_x77jMP5qEeGxKLDeGggo8w) 
 */

import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xtend.typesystem.uml2.UML2MetaModel;
import org.genesez.workflow.xpand.Validator;
import org.genesez.workflow.profile.DefaultOverride;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author dreamer
 */
public class Uml2Validator extends Validator {
	
	// -- generated attribute, constant + association declarations ----------
	
	@DefaultOverride
	private String slot = "uml2model";
	
	@DefaultOverride
	private java.util.Set<String> script = new java.util.HashSet<String>();
	
	// initialize all multi valued fields with their default values
	{
		script.add("org::genesez::adapter::uml2::uml2constraints");
		script.add("org::genesez::adapter::uml2::UmlStateMachineValidation");
		script.add("org::genesez::adapter::uml2::Uml2GeneSezStateMachineValidation");
		
		// override default values of workflow parameters
		setSlot(slot);
		for (String it : script) {
			addScript(it);
		}
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._rkJFQP5rEeGxKLDeGggo8w) ENABLED START */
		// add uml meta model (note: not generated if disabling the protected region)
		addMetaModel(new UML2MetaModel());
		
		// delegate to base class
		super.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._x77jMP5qEeGxKLDeGggo8w) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
