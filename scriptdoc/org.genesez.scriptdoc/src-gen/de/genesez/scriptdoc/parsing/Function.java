package de.genesez.scriptdoc.parsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* PROTECTED REGION ID(java.type.import._16_6_2_6340215_1304167512306_299263_406) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class Function extends Executable implements IContent {
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>Executable</b></em>'.
	 * @param	n - the executable name
	 * @param	c - the codebody	
	 * @param	p - the parameter definition
	 */
	public Function(String n, String c, String p) {
		/* PROTECTED REGION ID(java.constructor._16_6_2_6340215_1305364902212_631428_465) ENABLED START */
		super(n, c, p);
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public void parse() { 
		/* PROTECTED REGION ID(java.implementation._16_6_2_6340215_1304167712626_722571_417) ENABLED START */
		// patterns to avoid false-positve matches 
		Pattern p, pJavaFunction, pStaticText;
		Matcher m, mJavaFunction, mStaticText;
		String match; 
		
		metaType = "";

		// scan parameters
		if(paramDef.length() > 0) {
			String[] tmpParams = paramDef.split(",\\s*");
			// determine the metatype
			metaType = tmpParams[0];
			String[] arMt = metaType.split("\\s");
			metaType = arMt[0];

			// fetches somethin like List[Foo bar]
			p = Pattern.compile("(List|Set|Collection)\\s*\\[(.*?)\\]");
			m = p.matcher(metaType);		
			if(m.find()) {
				metaType = metaType.substring(m.start(2), m.end(2));
			}		
			
			// determine each parameter out of parameter-definition
			for (String typeAndParameter : tmpParams) {
				String[] arParam = typeAndParameter.trim().split("\\s+");
				Parameter param = new Parameter();
				if(arParam.length > 1) {
				param.setMetaType(arParam[0]);
				param.setName(arParam[1]);
				insertInParams(param);
				} else {
					param.setMetaType("Unknown");
					param.setName("param");
					System.err.println("parameter parse error in " + name + ": " + paramDef); 
				}
			}

			// replace the metatype of the first parameter,
			// which is simultaneously the metatype of this function
			// later we replace it with a href link
			paramDef = paramDef.replaceFirst(metaType + "\\s*", "");		
		}

		// scan function codebody
		if(codeBody.length() > 0) {
			/*
			 * 
			 * fetch comments
			 * 
			 */
			
			// fetch multiline comments, used in stats..
			p = Pattern.compile(MULTILINECOMMENT);
			m = p.matcher(codeBody);
			while(m.find()) {
				if (m.start(1) > 1) {
					comments.add(codeBody.substring(m.start(1), m.end(1)));
				}
			}
			
			// fetch singleline comments, used in stats..
			p = Pattern.compile(SINGLELINECOMMENT);
			m = p.matcher(codeBody);
			while(m.find()) {
				if (m.start(1) > 1) {
					comments.add(codeBody.substring(m.start(1), m.end(1)));
				}
			}
			
			/*
			 * 
			 * search the calls
			 * 
			 */
			
			// remove out commented functions
//			String cleanedBody = this.codeBody.replaceAll(OUTCOMMENTEDEXTFUNCTION, "");
			
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
			
			cleanedBody = cleanedBody.replaceAll(STATICANNOTATION + "|" + STATICJAVAFUNCTION, "");
			
//			p = Pattern.compile(ANYSTRING);
//			m = p.matcher(cleanedBody);
//			while(m.find()) {
//				System.out.println("any text: " + m.group());
//			}
//			cleanedBody.replaceAll(ANYSTRING, "\"\"");
			
			p = Pattern.compile(EXTENDFUNCTION);
			m = p.matcher(cleanedBody);	
			pJavaFunction = Pattern.compile(JAVAFUNCTION);	
			mJavaFunction = pJavaFunction.matcher(cleanedBody);
			
			// we dont pay attention to java calls..
			while(m.find() && !mJavaFunction.find()) {
				match = cleanedBody.substring(m.start(1), m.end(1));
				splitNestedFunction(match);
			}
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------

	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_6_2_6340215_1304167512306_299263_406) ENABLED START */
	// TODO: put your own implementation code here	
	// matches xtend function calls in method body
	// TODO avoid function lookalikes inside Strings
	public static final String EXTENDFUNCTION = "(?s)((\\w+)(\\(.*\\))\\s*)";
	// matches java method calls e.g. JAVA org.genesez.platform.common.Conversion.format(java.lang.String);
	public static final String JAVAFUNCTION = "(JAVA)\\s*(\\w+\\.)*(\\w+)\\(.*?\\)\\s*";
	// matches multiline comments
	public static final String MULTILINECOMMENT = "(?s)/\\*(.*)\\*/";
	// matches single line comments
	public static final String SINGLELINECOMMENT = "\\s+//(.*)";
	
	public enum OwnerType {
		GeneratededByEMF, ExternalFunction, BuiltIn, ReExported, OrdinaryOwner; 
	}
	

	private String visibility;
	
	private String retType;
	
	private boolean isCached;
	
	private boolean isCreate;
	
	private OwnerType ownerType;

	public void setVisibility(String vis) {
		this.visibility = vis;
	}

	public String getVisibility() {
		return visibility;
	}
	
	public void setRetType(String rt) {
		this.retType = rt;
	}

	public String getRetType() {
		return retType;
	}
	
	public void setIsCached(boolean c) {
		this.isCached = c;
	}

	public boolean isCached() {
		return isCached;
	}
	
	public void setIsCreate(boolean c) {
		this.isCreate = c;
	}

	public boolean isCreate() {
		return isCreate;
	}
	
	public void setOwnerType(OwnerType ownerType) {
		this.ownerType = ownerType;
	}

	public OwnerType getOwnerType() {
		return ownerType;
	}
	/* PROTECTED REGION END */
}
