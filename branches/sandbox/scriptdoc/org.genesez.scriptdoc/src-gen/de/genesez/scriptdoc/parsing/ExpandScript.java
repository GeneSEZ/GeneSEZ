package de.genesez.scriptdoc.parsing;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/* PROTECTED REGION ID(java.type.import._16_6_2_6340215_1304096483093_568245_828) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * 
 * @author EmpeROOR
 */
public class ExpandScript extends Script implements IContent {

	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public void parse() {
		/* PROTECTED REGION ID(java.implementation._16_6_2_6340215_1304097132874_168219_900) ENABLED START */
		read();

		p = Pattern.compile("(?s)" + HEADCOMMENT);
		m = p.matcher(content);
		if (m.find()) {
			headComment = content.substring(m.start(3), m.end(3));
		} else {
			headComment = "";
		}

		p = Pattern.compile("(?s)" + IMPT);
		m = p.matcher(content);
		if (m.find()) {
			headImport = content.substring(m.start(1), m.end(1));
		} else {
			headImport = "";
		}

		p = Pattern.compile("(?s)" + EXTENSION);
		m = p.matcher(content);
		while (m.find()) {
			headExtensions.add(content.substring(m.start(1), m.end(1)).replace(
					" reexport", ""));
		}

		p = Pattern.compile("(?s)(" + REM + ")?\\s*" + DEFINE);
		m = p.matcher(content);

		Template t;
		String exname, metatype, codebody, parameters, docu, code;

		while (m.find()) {
			exname = content.substring(m.start(5), m.end(5));

			metatype = content.substring(m.start(4), m.end(4)).split("\n")[0];
			metatype = metatype.split("FOR")[1].replace("-", "")
					.replace("»", "").replaceFirst("(«ENDDEFINE)", "").trim();

			codebody = content.substring(m.start(9), m.end(9));

			if (m.start(6) > 0) {
				parameters = content.substring(m.start(6), m.end(6));
			} else {
				parameters = "";
			}

			t = new Template(exname, codebody, parameters);
			t.setMetaType(metatype);

			if (m.start(3) > 0) {
				docu = content.substring(m.start(3), m.end(3));
			} else {
				docu = "";
			}
			t.setDocumentation(docu);

			if (m.start(4) > 0) {
				code = content.substring(m.start(4), m.end(4));
			} else {
				code = "";
			}
			t.setCode(code);

			insertInSymbols(t);
			// parse template body
			t.parse();
		}
		// add the parsed script to our symboltable
		root.getTable().insertInSymbols(this);
		/* PROTECTED REGION END */
	}

	// -- generated association + attribute accessors -----------------------

	// -- generated code of other cartridges --------------------------------

	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_6_2_6340215_1304096483093_568245_828) ENABLED START */
	public static final String REM = "(«REM»\\s*([^«]*?)\\s*«ENDREM-?»)+?"; // (?s)^((«REM»\\s*)(.*?)(\\s*«ENDREM»))+?
	public static final String EXTENSION = "(?m)^\\s*«EXTENSION\\s*(.*?)\\s*-?»";
	public static final String IMPT = "«IMPORT\\s*(.*?)\\s*-?»";
	public static final String HEADCOMMENT = IMPT + "?\\s*" + REM;
	public static final String DEFINE = "(«DEFINE\\s*(.*?)\\s*(\\(([^)]*)\\))?\\s*FOR\\s*(.*?)\\s*-?»(.*?)«ENDDEFINE-?»)+?";
	/* PROTECTED REGION END */
}
