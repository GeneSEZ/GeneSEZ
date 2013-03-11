package de.genesez.scriptdoc.parsing;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337383784747_351996_1958) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class CheckScript extends Script {
	
	// -- generated attribute, constant + association declarations ----------
	
	private Pattern p;
	
	private Matcher m;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public void parse() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337386062257_652947_2774) ENABLED START */
		read();

		p = Pattern.compile("(?s)" + COMMENT + "(.*?)(import)?");
		m = p.matcher(content);
		if (m.find()) {
			headComment = content.substring(m.start(1), m.end(1));
		}else {
			headComment = "";
		}
		
		p = Pattern.compile("(?s)" + EXTENSION);
		m = p.matcher(content);
		while (m.find()) {
			headExtensions.add(content.substring(m.start(1), m.end(1)).replace(" reexport", ""));
		}
		
		p = Pattern.compile("(?s)" + IMPT);
		m = p.matcher(content);
		if (m.find()) {
			headImport = content.substring(m.start(2), m.end(2));
		}else {
			headImport = "";
		}
		
		// remove the headcomment and the import for easier parsing
		content = content.replaceFirst("(?s)" + COMMENT + "(.*?)(import)", "");
		
		p = Pattern.compile("(?s)" + COMMENT + "?\\s*" + VALIDATION);
		m = p.matcher(content);
		
		Validation v;
		String exname;		// WARNING or ERROR
		
		while (m.find()) {
			exname = content.substring(m.start(5), m.end(5));
			
			v = new Validation(exname);
			
			if(m.start(4) > 1) {
				v.setMetaType(content.substring(m.start(4), m.end(4)));
			}else {
				v.setMetaType("");
			}
			
			if(m.start(6) > 1) {
				v.setCodeBody(content.substring(m.start(6), m.end(6)));
			}else {
				v.setCodeBody("");
			}
			
			if(m.start(1) > 1) {
				v.setDocumentation(content.substring(m.start(1), m.end(1)));
			}else {
				v.setDocumentation("");
			}
			
			insertInSymbols(v);
			
			// edit validation codebody - set paramDef
			v.parse();		
		}		
		
		root.getTable().insertInSymbols(this);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337383784747_351996_1958) ENABLED START */
	public static final String IMPT = "(import)\\s(.*?);";
	public static final String EXTENSION = "(?m)^\\s*extension\\s*(.*?)\\s*-?;";
	public static final String COMMENT = "(/\\*\\*\\s*(.*?)\\*/)";
	public static final String VALIDATION = "(?s)(?m)(context)\\s*(\\w+)\\s*(ERROR|WARNING)\\s*(.*?);$";
	/* PROTECTED REGION END */

}
