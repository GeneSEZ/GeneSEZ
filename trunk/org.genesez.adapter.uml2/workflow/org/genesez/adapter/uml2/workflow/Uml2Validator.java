package org.genesez.adapter.uml2.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_x77jMP5qEeGxKLDeGggo8w) 
 */
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xtend.typesystem.uml2.UML2MetaModel;
import org.genesez.workflow.xpand.Validator;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Uml2Validator extends Validator {
	
	// override default values of workflow parameters
	{
		setSlot("uml2model");
		addScript("org::genesez::adapter::uml2::gcore::validation::UML2Constraints");
		addScript("org::genesez::adapter::uml2::gcore::validation::UML2StatemachineConstraints");
		addScript("org::genesez::adapter::uml2::gcore::validation::GcoreStatemachineConstraints");
	}
	
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._rkJFQP5rEeGxKLDeGggo8w) ENABLED START */
		// add uml meta model (note: not generated if protected region is disabled)
		addMetaModel(new UML2MetaModel());
		
		// delegate to base class
		super.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._x77jMP5qEeGxKLDeGggo8w) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
