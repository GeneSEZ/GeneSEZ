package org.genesez.platform.dotnet.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_4vH5QAomEeKxusbn3Pe47g) 
 */

import org.eclipse.emf.mwe.core.issues.Issues;
import org.genesez.workflow.xpand.Model2Text;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author dreamer
 */
public class Gcore2Csharp extends Model2Text {
	
	// -- generated attribute, constant + association declarations ----------
	
	// initialize all multi valued fields with their default values
	{
		
		// override default values of workflow parameters
		setTemplate("org::genesez::platform::dotnet::csharp::templates::Root::Root");
		addTypeMappingFile("org/genesez/platform/dotnet/csharp/typemapping/typemapping.xml");
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._Y5P3YAonEeKxusbn3Pe47g) ENABLED START */
		// delegate to base class
		super.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._4vH5QAomEeKxusbn3Pe47g) ENABLED START */
	/* PROTECTED REGION END */
	
}
