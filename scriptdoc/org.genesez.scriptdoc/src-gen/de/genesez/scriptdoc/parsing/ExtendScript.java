package de.genesez.scriptdoc.parsing;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337383775559_111332_1957) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class ExtendScript extends Script {
	
	// -- generated attribute, constant + association declarations ----------
	
	private Pattern p;
	
	private Matcher m;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public void parse() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337386100789_343258_2780) ENABLED START */
		read();

		p = Pattern.compile("(?s)" + COMMENT + "(.*?)(import)?");
		m = p.matcher(content);
		if (m.find()) {
			headComment = content.substring(m.start(1), m.end(1));
		}else{
			headComment = "";
		}
		
		p = Pattern.compile("(?s)" + EXTENSION);
		m = p.matcher(content);
		while (m.find()) {
			headExtensions.add(content.substring(m.start(1), m.end(1)));//.replace(" reexport", ""));
		}
		
		p = Pattern.compile("(?s)" + IMPT);
		m = p.matcher(content);
		if (m.find()) {
			headImport = content.substring(m.start(2), m.end(2));
		}else{
			headImport = "";
		}
		
		// remove the headcomment and the import for easier parsing
		content = content.replaceFirst("(?s)" + COMMENT + "(.*?)(import)", "");
		
		p = Pattern.compile("(?s)" + COMMENT + "?\\s*" + FUNCTION);
		m = p.matcher(content);
		
		Function f;
		String exname, retType, codebody, parameters;

		while (m.find()) {
			exname = content.substring(m.start(10), m.end(10));

			codebody = content.substring(m.start(14), m.end(14));
			
			if(m.start(12) > 1) {
				parameters = content.substring(m.start(12), m.end(12));
			}else {
				parameters = "";
			}

			retType = content.substring(m.start(5), m.end(5)).trim();
			
			f = new Function(exname, codebody, parameters);
			f.setRetType(retType);
			
			insertInSymbols(f);

			if(m.start(1) > 1) {
				f.setDocumentation(content.substring(m.start(1), m.end(1)));
			}else {
				f.setDocumentation("");
			}
			
			String c;
			if(m.start(4) > 1) {
				c = content.substring(m.start(4), m.end(4)) + " ";
				if(c.equals("create")) {
					// TODO - create and cached possible?!
					f.setIsCreate(true);
					f.setIsCached(false);
				}else{ // is cached
					f.setIsCreate(false);
					f.setIsCached(true);
				}
			}else {
				f.setIsCached(false);
				f.setIsCreate(false);
			}
			
			if(m.start(3) > 1) {
				f.setVisibility(content.substring(m.start(3), m.end(3)).trim());
			}else {
				f.setVisibility(DEFVISIBILITY);
			}

			if(m.start(14) > 1) {
				f.setCode(content.substring(m.start(14), m.end(14)));
			}else {
				f.setCode("");
			}
			// determine the metatype, parse the function body
			f.parse();		
		}		

		root.getTable().insertInSymbols(this);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337383775559_111332_1957) ENABLED START */
	// matches head import statement
	public static final String IMPT = "(import)\\s(.*?);";
	// matches head extensions
	public static final String EXTENSION = "(?m)^\\s*extension\\s*(.*?)\\s*-?;";
	// matches extend function declaration + function body
	public static final String FUNCTION = "(private|public|protected)?\\s*(create|cached)?\\s*(((List|Set|Collection)\\[(\\w*)\\])|(\\w*))\\s+(\\w*?)\\s*(\\(([^)]*)\\))(\\s*):\\s*(.*?);";
	// matches multiline comments
	public static final String COMMENT = "(/\\*\\*\\s*(.*?)\\*/)";
	// default visibility
	public static final String DEFVISIBILITY = "public";
	/* PROTECTED REGION END */

}
