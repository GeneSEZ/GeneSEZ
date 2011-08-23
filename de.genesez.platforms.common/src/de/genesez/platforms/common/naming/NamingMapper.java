package de.genesez.platforms.common.naming;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.xtend.XtendFacade;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

import de.genesez.metamodel.gcore.MElement;

public class NamingMapper {
	
	/**
	 * Singleton naming mapper instance.
	 */
	private static NamingMapper namingMapper = null;
	
	/**
	 * Using log4j-mechanism for error logging.
	 */
	protected Log logger = LogFactory.getLog(getClass());
	
	/**
	 * 
	 */
	protected XtendFacade xtendNamingFile;
	
	/**
	 * 
	 */
	protected ExecutionContext ctx;
	
	protected NamingMapper() {
	}
	
	/**
	 * @param xtendNamingFile
	 */
	protected NamingMapper(String xtendNamingFile, ExecutionContext ctx) {
		this.ctx = ctx;
		setXtendNamingFile(xtendNamingFile);
	}
	
	/**
	 * @param element
	 * @param namingContext
	 * @return
	 */
	public String getMappingName(MElement element, String namingContext) {
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
	}
	
	private String contextToXtendScript(String namingContext) {
		return "as" + namingContext + "Name";
		
	}
	
	/**
	 * @param xtendNamingFile
	 */
	public void setXtendNamingFile(String xtendNamingFile) {
		XtendFacade xf;
		
		if (ctx == null)
			xf = XtendFacade.create(xtendNamingFile);
		else {
			xf = XtendFacade.create(ctx, xtendNamingFile);
		}
		
		EmfMetaModel gcore = new EmfMetaModel();
		gcore.setMetaModelPackage("de.genesez.metamodel.gcore.GcorePackage");
		xf.registerMetaModel(gcore);
		
		this.xtendNamingFile = xf;
	}
	
	/**
	 * This static method initializes the naming mapper. Please call this
	 * function before the beginning of the model to model modification, model
	 * to model transformation or model to text transformation to configure or
	 * reconfigure the naming mapper with the specified xtend naming file.
	 * 
	 * @param namingFile the specified naming file
	 * @return singleton type mapper instance
	 */
	public static NamingMapper initNamingMapper(String xtendNamingFile, ExecutionContext ctx) {
		namingMapper = new NamingMapper(xtendNamingFile, ctx);
		return namingMapper;
	}
	
	/**
	 * Sole method to get the preconfigured naming mapper.
	 * 
	 * @return singleton naming mapper instance
	 */
	public static NamingMapper getInstance() {
		if (namingMapper == null) {
			namingMapper = new NamingMapper();
		}
		return namingMapper;
	}
	
}
