package org.genesez.platform.common.naming;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324554204402_678855_3571) 
 */

import org.apache.commons.logging.LogFactory;
import org.eclipse.xtend.expression.ExecutionContext;
import org.apache.commons.logging.Log;
import org.eclipse.xtend.XtendFacade;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;
import org.genesez.metamodel.gcore.MElement;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @deprecated
 */
public class NamingMapper {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static NamingMapper instance = new NamingMapper();
	
	protected Log logger = LogFactory.getLog(getClass());
	
	protected XtendFacade xtendNamingFile;
	
	protected ExecutionContext ctx;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>NamingMapper</b></em>'.
	 */
	private NamingMapper() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1324555827542_937042_4032) ENABLED START */
		/* PROTECTED REGION END */
	}
	
	/**
	 * Constructor for class '<em><b>NamingMapper</b></em>'.
	 * @param	xtendNamingFile	
	 * @param	ctx	
	 */
	private NamingMapper(String xtendNamingFile, ExecutionContext ctx) {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1324556070041_597634_4044) ENABLED START */
		this.ctx = ctx;
		setXtendNamingFile(xtendNamingFile);
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	element	
	 * @param	namingContext	
	 * @return	
	 */
	public String getMappingName(MElement element, String namingContext) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324556263384_372255_4089) ENABLED START */
		String elementName;
		
		elementName = element.getName();
		
		if (namingContext != null) {
			String scriptName = contextToXtendScript(namingContext);
			try {
				elementName = (String) xtendNamingFile.call(scriptName, element);
			} catch (Exception e) {
				logger.warn("There exists no '" + namingContext + "' context for " + element.getName() + " (" + element.getClass() + ") so that for fallback the default name is returned.");
			}
		}
		return elementName;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	namingContext	
	 * @return	
	 */
	private String contextToXtendScript(String namingContext) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324556300503_888174_4096) ENABLED START */
		return "as" + namingContext + "Name";
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	xtendNamingFile	
	 */
	
	public void setXtendNamingFile(String xtendNamingFile) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324556351796_693675_4103) ENABLED START */
		XtendFacade xf;
		
		if (ctx == null)
			xf = XtendFacade.create(xtendNamingFile);
		else {
			xf = XtendFacade.create(ctx, xtendNamingFile);
		}
		
		EmfMetaModel gcore = new EmfMetaModel();
		gcore.setMetaModelPackage("org.genesez.metamodel.gcore.GcorePackage");
		xf.registerMetaModel(gcore);
		
		this.xtendNamingFile = xf;
		/* PROTECTED REGION END */
	}
	
	/**
	 * This static method initializes the naming mapper. Please call this function before the beginning of the model to model modification, model to model transformation or model to text transformation to configure or reconfigure the naming mapper with the specified xtend naming file.
	 * @param	xtendNamingFile	the specified naming file
	 * @param	ctx	the execution context
	 * @return	a half-singleton naming mapper instance
	 */
	public static NamingMapper initNamingMapper(String xtendNamingFile, ExecutionContext ctx) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324556393499_265923_4111) ENABLED START */
		instance = new NamingMapper(xtendNamingFile, ctx);
		return instance;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>instance</b></em>'
	 */
	public static NamingMapper getInstance() {
		return instance;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324554204402_678855_3571) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
