package org.genesez.platform.java.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_4JuPUIZrEeKi-fAVJTcXlg) 
 */
import org.eclipse.xpand2.output.JavaBeautifier;
import org.genesez.workflow.profile.WfDefault;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class GeneSezJavaPostProcessor extends JavaBeautifier {
	
	/**
	 * Constructor for class '<em><b>GeneSezJavaPostProcessor</b></em>'.
	 */
	public GeneSezJavaPostProcessor() {
		/* PROTECTED REGION ID(java.constructor._5_CuUIeAEeK1Y67SYGPJ1A) ENABLED START */
		setConfigFile(getDefaultConfigFile());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "configFile")
	public String getDefaultConfigFile() {
		return "org/genesez/platform/java/workflow/eclipse.java.formatter.settings.xml";
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._4JuPUIZrEeKi-fAVJTcXlg) ENABLED START */
	/* PROTECTED REGION END */
}
