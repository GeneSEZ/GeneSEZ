package org.genesez.mapping.name;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324554204402_678855_3571) 
 */

import java.util.Set;

import org.apache.commons.logging.LogFactory;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.typesystem.MetaModel;
import org.apache.commons.logging.Log;
import org.eclipse.xtend.XtendFacade;

/**
 * This class will call the Xtend scripts within the specified Xtend naming file. 
 *  
 * @author	Nico Herbig <nico.herbig@fh-zwickau.de> (maintainer)
 */
public class NameMapper {
	
	/**
	 * Singleton of the name mapper instance.
	 */
	private static NameMapper instance;
	
	/**
	 * Using log4j-mechanism for error logging.
	 */
	protected Log logger = LogFactory.getLog(getClass());
	
	/**
	 * Facade to call Xtend scripts of an Xtend file.
	 */
	protected XtendFacade xtendNamingFacade;
	
	/**
	 * Default constructor of the name mapper.
	 */
	private NameMapper() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1324555827542_937042_4032) ENABLED START */
		/* PROTECTED REGION END */
	}
	
	/**
	 * Constructor to initialize the name mapper with the necessary data.
	 * 
	 * @param xtendNamingFile	The Xtend naming file.
	 * @param ctx				The execution context in which the Xtend facade will be executed.
	 * @param metaModels		The meta-models which will be registered in the Xtend facade.
	 */
	private NameMapper(String xtendNamingFile, ExecutionContext ctx, Set<MetaModel> metaModels) {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1324556070041_597634_4044) ENABLED START */
		xtendNamingFacade = XtendFacade.create(ctx, xtendNamingFile);
		for (MetaModel metaModel : metaModels) {
			xtendNamingFacade.registerMetaModel(metaModel);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the mapped name of the model element by means of the specified naming context.
	 * If no Xtend script for the specified model element and naming context exists, 
	 * the string representation of the specified model element will be returned.
	 * 
	 * @param	element			The model element which shall be mapped.
	 * @param	namingContext	The naming context in which the model element shall be mapped.
	 * @return	The mapped name of the model element or its string representation.
	 */
	public String mapElementName(Object element, String namingContext) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324556263384_372255_4089) ENABLED START */
		String elementName = element.toString();
		
		if (namingContext != null) {
			String xtendScriptName = contextToXtendScriptName(namingContext);
			try {
				elementName = (String) xtendNamingFacade.call(xtendScriptName, element);
			} catch (Exception e) {
				logger.warn("There exists no '" + namingContext + "' context for " + elementName + " (" + element.getClass() + "). As fallback default name is returned.");
			}
		}
		return elementName;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Converts the specified naming context to the Xtend script name which will be called.
	 * The name of the Xtend script conforms to the following naming convention: "as" + name of the context + "Name".
	 * E.g. for the naming context "General": "asGeneralName". 
	 * 
	 * @param namingContext	The naming context.
	 * @return The converted Xtend script name.
	 */
	private String contextToXtendScriptName(String namingContext) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324556300503_888174_4096) ENABLED START */
		return "as" + namingContext + "Name";
		/* PROTECTED REGION END */
	}
	
	/**
	 * This static method initializes the name mapper. Please call this function before the beginning of the model to model or model to text transformation 
	 * to configure or reconfigure the name mapper with the specified Xtend naming file, execution context and meta-models.
	 * 
	 * @param xtendNamingFile	The Xtend naming file.
	 * @param ctx				The execution context in which the Xtend facade will be executed.
	 * @param metaModels		The meta-models which will be registered in the Xtend facade.
	 */
	public static NameMapper initNameMapper(String xtendNamingFile, ExecutionContext ctx, Set<MetaModel> metaModels) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324556393499_265923_4111) ENABLED START */
		instance = new NameMapper(xtendNamingFile, ctx, metaModels);
		return instance;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sole method to get the preconfigured name mapper.
	 * 
	 * @return	The configured name mapper instance.
	 */
	public static NameMapper getInstance() {
		if (instance == null) {
			instance = new NameMapper();
		}
		return instance;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324554204402_678855_3571) ENABLED START */
	/* PROTECTED REGION END */
	
}
