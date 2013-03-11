package de.genesez.scriptdoc.parsing;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* PROTECTED REGION ID(java.type.import._16_6_2_6340215_1304167481434_765762_399) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class Template extends Executable implements IContent {
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>Template</b></em>'.
	 * @param	n	
	 */
	public Template(String n, String c, String p) {
		/* PROTECTED REGION ID(java.constructor._16_6_2_6340215_1305364878921_364186_462) ENABLED START */
		super(n, c, p);	
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * 
	 */
	public void parse() {
		/* PROTECTED REGION ID(java.implementation._16_6_2_6340215_1304167700645_180048_414) ENABLED START */
		Pattern p, pFun, pCrap, pHtmlDoc, pStaticText;
		Matcher m, mFun, mCrap, mHtmlDoc, mStaticText;
		String templateName, functionMatch;
		Script s;
		Template t;
		
		// scan parameters
		if (paramDef.length() > 0) {
			String[] params = paramDef.split(",\\s*");
			for (String param : params) {
				String[] pe = param.split("\\s+");
				if (pe.length == 2) {
					Parameter par = new Parameter();
					par.setMetaType(pe[0]);
					par.setName(pe[1]);
					insertInParams(par);
				}
			}
		}
		
		// scan template body
		if(codeBody.length() > 0) {
			pFun = Pattern.compile(CALLEDFUNCTION);
			pHtmlDoc = Pattern.compile(HTMLDOC);
			pCrap = Pattern.compile(NOTNEEDED);
			
			/*
			 * 
			 * fetch comments
			 * 
			 */
			
			// fetch multiline comments, used in stats..
			p = Pattern.compile(REM);
			m = p.matcher(codeBody);
			while (m.find()) {
				if (m.start(2) > 1) {
					comments.add(codeBody.substring(m.start(2), m.end(2)));
				}	
			}
			
			// fetch singleline comments, used in stats..
			p = Pattern.compile(SINGLELINECOMMENT);
			m = p.matcher(codeBody);
			while (m.find()) {
				if (m.start(1) > 1) {
					comments.add(codeBody.substring(m.start(1), m.end(1)));
				}
			}
			
			/*
			 * 
			 * parse codebody
			 * 
			 */

			// need to remove out commented stuff and annotations in static text,
			// otherwise the parser interprets 'em as functions
//			String cleanedBody = codeBody.replaceAll(OUTCOMMENTEDEXTFUNCTION + "|" + OUTCOMMENTEDEXPFUNCTION + "|" + STATICANNOTATION, "");
			
			String cleanedBody = this.codeBody;
			boolean staticTextFound = false;
			
			pStaticText = Pattern.compile(STATICTEXT);
			mStaticText = pStaticText.matcher(cleanedBody);
			while(mStaticText.find()) {
				cleanedBody = cleanedBody.replaceAll(STATICTEXT, "");
				staticTextFound = true;
			}
			
			if(!staticTextFound) {
				cleanedBody = this.codeBody.replaceAll(OUTCOMMENTEDEXTFUNCTION, "");
			}
			
			cleanedBody = this.codeBody.replaceAll(OUTCOMMENTEDEXPFUNCTION + "|" + STATICANNOTATION + "|" + STATICJAVAFUNCTION, "");
			
			
			// split the codebody at a '«', later we can distinguish between called templates and called functions
			String[] arCodeBody = cleanedBody.split("«");
			
			p = Pattern.compile(CALLEDTEMPLATE);
			
			for (String part : arCodeBody) {
				String modPart = "«" + part;
				m = p.matcher(modPart);
				while (m.find()) {
					String match = modPart.substring(m.start(1), m.end(1));
					String[] arMatch = match.split("::");
	
					if(arMatch.length > 1) {
						templateName = arMatch[1];
	
						s = new ExpandScript();
						String path = this.getScript().getFile().getPath().replace(this.getScript().getFile().getName(), "");				
						s.setFile(new File(path + arMatch[0] + ".xpt"));
					}else {
						templateName = arMatch[0];
						s = this.script;
					}		
					t = new Template(templateName, "", "");
					t.setMetaType(this.metaType);
					t.setScript(s);
						
					if(!calledExists(t))
						insertInCalled(t);
						
					// need a new template with the same atributes
					// otherwise we got some problems wit setting up the link
					Template tmp = new Template(this.name, this.code, this.paramDef);
					tmp.setMetaType(this.metaType);
					tmp.setDocumentation(this.documentation);
					tmp.setScript(this.getScript());
					tmp.setCalled(this.called);
					tmp.setCaller(this.caller);
						
					t.insertInCaller(tmp);

					// replace the part which we've found
					// otherwise the parser indentifys templates like 
					// OwnCodeImpl("java.annotation.own.code.declaration." + xmiGuid) as a function
					modPart = modPart.replaceFirst(CALLEDTEMPLATE, "");
				}

				mFun = pFun.matcher(modPart);
				mHtmlDoc = pHtmlDoc.matcher(modPart);
				mCrap = pCrap.matcher(modPart);
					
				while (mFun.find() && !mCrap.find() && !mHtmlDoc.find()) {
					functionMatch = modPart.substring(mFun.start(1), mFun.end(1));
					splitNestedFunction(functionMatch);
				}
			}
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_6_2_6340215_1304167481434_765762_399) ENABLED START */
	// TODO: put your own implementation code here
	public static final String CALLEDTEMPLATE = "«EXPAND\\s+([\\w::]*)";
	public static final String CALLEDFUNCTION = "(?s)((\\w+)(\\(.*\\))\\s*)"; //"((\\w+)\\s*\\(([\\w\\s,\\\"\\+\\(\\)]*)\\))"; "((\\w+)\\(([\\w\"\\*\\\\\\.\\+,:\\s\\(\\)])*\\))";
	public static final String NOTNEEDED = "(\\s|«|»)(if|LET)\\s*\\(";
	public static final String REM = "(«REM»\\s*([^«]*?)\\s*«ENDREM-?»)+?";
	public static final String SINGLELINECOMMENT = "\\s+//(.*)";
	// remove false positiv matches in html comments
	// otherwise stuff like <!-----	Kreisdiagramme (gesamt) --> matches
	public static final String HTMLDOC = "<!-*\\s*\\w+\\s*\\((.*?)\\)\\s*-*>*";
	/* PROTECTED REGION END */
}
