package de.genesez.scriptdoc.parsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.genesez.scriptdoc.helper.StringHelper;

/* PROTECTED REGION ID(java.type.import._16_6_2_6340215_1304096424508_617312_803) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Ausführbare(s) Template, Skript oder Regel, die in einem Skript enthalten
 * ist. Die parse-Methode analysiert, welche Executables verwendet werden. Wird
 * in Subklassen ausprogrammiert.
 * 
 * @author EmpeROOR
 */
public abstract class Executable implements Comparable<Executable>, IContent {

	// -- generated attribute, constant + association declarations ----------

	/** stores the associated object of association FILE to Script */
	protected Script script;

	/** stores associated objects of association PARAMS to Parameter */
	protected java.util.List<Parameter> params = new java.util.ArrayList<Parameter>();

	/** stores associated objects of association CALLED to Executable */
	protected java.util.Set<Executable> called = new java.util.HashSet<Executable>();

	/** stores associated objects of association CALLER to Executable */
	protected java.util.Set<Executable> caller = new java.util.HashSet<Executable>();

	protected java.util.Set<String> comments = new java.util.HashSet<String>();

	protected String name;

	protected String code;

	protected String codeBody;

	protected String paramDef;

	protected String documentation;

	protected String metaType;

	protected String link;

	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>Executable</b></em>'.
	 * 
	 * @param n
	 *            - the executable name
	 * @param c
	 *            - the codebody
	 * @param p
	 *            - the parameter definition
	 */
	public Executable(String n/*, String m*/, String c, String p) {
		/* PROTECTED REGION ID(java.constructor._16_6_2_6340215_1305364819703_191147_459) ENABLED START */
		name = n;
		// metaType = m;
		codeBody = c;
		paramDef = p;
		/* PROTECTED REGION END */
	}

	/**
	 * Constructor for class '<em><b>Executable</b></em>'.
	 * 
	 * @param n
	 *            the executable name
	 */
	public Executable(String n) {
		/* PROTECTED REGION ID(java.constructor._16_6_2_6340217_1305364819703_191147_460) ENABLED START */
		name = n;
		/* PROTECTED REGION END */
	}

	// -- generated method declarations -------------------------------------
	/**
	 * parses the executable
	 */
	public abstract void parse();

	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Gets the value of the attribute '<em><b>qname</b></em>'
	 */
	public String getQname() {
		/* PROTECTED REGION ID(java.derived.attribute.implementation._16_6_2_6340215_1304167886769_927930_423) ENABLED START */
		// TODO: implementation of derived (calculated) attribute 'QNAME'
		throw new UnsupportedOperationException(
				"The implementation of the derived attribute 'QNAME' is missing!");
		/* PROTECTED REGION END */
	}

	// -- generated association + attribute accessors -----------------------
	/**
	 * Gets the value of the attribute '<em><b>name</b></em>'
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the value of the attribute '<em><b>code</b></em>'
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the value of the attribute '<em><b>code</b></em>'
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the value of the attribute '<em><b>codeBody</b></em>'
	 */
	public String getCodeBody() {
		return codeBody;
	}

	/**
	 * Sets the value of the attribute '<em><b>codeBody</b></em>'
	 */
	public void setCodeBody(String codeBody) {
		this.codeBody = codeBody;
	}

	/**
	 * Gets the value of the attribute '<em><b>paramDef</b></em>'
	 */
	public String getParamDef() {
		return paramDef;
	}

	/**
	 * Sets the value of the attribute '<em><b>paramDef</b></em>'
	 */
	public void setParamDef(String paramDef) {
		this.paramDef = paramDef;
	}

	/**
	 * Gets the value of the attribute '<em><b>documentation</b></em>'
	 */
	public String getDocumentation() {
		return documentation;
	}

	/**
	 * Sets the value of the attribute '<em><b>documentation</b></em>'
	 */
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

	/**
	 * Gets the value of the attribute '<em><b>metaType</b></em>'
	 */
	public String getMetaType() {
		return metaType;
	}

	/**
	 * Sets the value of the attribute '<em><b>metaType</b></em>'
	 */
	public void setMetaType(String metaType) {
		this.metaType = metaType;
	}

	/**
	 * accessor for association to file
	 */
	public Script getScript() {
		return script;
	}

	/**
	 * accessor for association to file
	 */
	public void setScript(Script file) {
		this.script = file;
	}

	/**
	 * Gets the value of the attribute '<em><b>headImport</b></em>'
	 */
	public String getLink() {
		return link;
	}

	/**
	 * Sets the value of the attribute '<em><b>headImport</b></em>'
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * accessor for association to caller
	 */
	public java.util.Set<String> getComments() {
		return comments;
	}

	/**
	 * accessor for association to caller
	 */
	public void setComments(java.util.Set<String> comments) {
		this.comments = comments;
	}

	/**
	 * accessor for association to params
	 */
	public java.util.List<Parameter> getParams() {
		return java.util.Collections.unmodifiableList(params);
	}

	/**
	 * accessor for association to params
	 */
	public void insertInParams(Parameter params) {
		if (this.params.contains(params)) {
			return;
		}
		this.params.add(params);
	}

	/**
	 * accessor for association to params
	 */
	public void removeFromParams(Parameter params) {
		if (!this.params.contains(params)) {
			return;
		}
		this.params.remove(params);
	}

	/**
	 * accessor for association to called
	 */
	public java.util.Set<Executable> getCalled() {
		return java.util.Collections.unmodifiableSet(called);
	}

	/**
	 * accessor for association to called
	 */
	public void setCalled(java.util.Set<Executable> sym) {
		this.called = sym;
	}

	/**
	 * accessor for association to called
	 */
	public void insertInCalled(Executable called) {
		if (this.called.contains(called)) {
			return;
		}
		this.called.add(called);
	}

	/**
	 * accessor for association to called
	 */
	public void removeFromCalled(Executable called) {
		if (!this.called.contains(called)) {
			return;
		}
		this.called.remove(called);
		if (called.getCaller().contains(this)) {
			called.removeFromCaller(this);
		}
	}

	/**
	 * accessor for association to caller
	 */
	public java.util.Set<Executable> getCaller() {
		return java.util.Collections.unmodifiableSet(caller);
	}

	/**
	 * accessor for association to caller
	 */
	public void setCaller(java.util.Set<Executable> sym) {
		this.caller = sym;
	}

	/**
	 * accessor for association to caller
	 */
	public void insertInCaller(Executable caller) {
		if (this.caller.contains(caller)) {
			return;
		}
		this.caller.add(caller);
	}

	/**
	 * accessor for association to caller
	 */
	public void removeFromCaller(Executable caller) {
		if (!this.caller.contains(caller)) {
			return;
		}
		this.caller.remove(caller);
		if (caller.getCalled().contains(this)) {
			caller.removeFromCalled(this);
		}
	}

	// -- generated code of other cartridges --------------------------------

	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_6_2_6340215_1304096424508_617312_803) ENABLED START */
	protected final String OUTCOMMENTEDEXTFUNCTION = "(?s)/\\*\\*?(.*?)\\*/";// "(?m)^\\s*/?\\*\\s*(.*)";
																				// //"(?s)/\\*\\*?(.*?)\\*/";
																				// (?s)/\*\*?(.*?)\*/
	protected final String OUTCOMMENTEDEXPFUNCTION = "(?s)(«REM»\\s*(.*?)\\s*«ENDREM-?»)+?";
	protected final String STATICANNOTATION = "(?s)@\\w+\\s*(\\\"?.*?\\\"?\\))";// "(?s)@\\w+\\s*(.*)";//"(?s)@\\w+\\(\".*?\"\\)";
	protected final String STATICTEXT = "(?m)^\\s*/?\\*\\s*(.*)";
	protected final String ANYSTRING = "(?s)\"[^\"\\n]+\"{1}?";
	protected final String STATICJAVAFUNCTION = "(?m)(?s)\\s*new\\s+\\w+\\s*\\(.*?\\)";

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if (name != null && metaType != null && script != null)
			return name + "(" + paramDef + ") MetaType: " + metaType + " @ "
					+ script.getFile().getName();
		else
			return "";
	}

	public int compareTo(Executable toCompare) {

		if (!this.getName().equals(toCompare.getName())) {
			return this.getName().compareTo(toCompare.getName());
		}

		if (toCompare.getMetaType() != null) {
			if (this.getMetaType() != null) {
				if (toCompare.getMetaType() != null) {
					if (!this.getMetaType().equals(toCompare.getMetaType())) {
						return this.getMetaType().compareTo(
								toCompare.getMetaType());
					}
				}
			}
		}

		if (this.getParamDef() != null) {
			if (!this.getParamDef().equals(toCompare.getParamDef())) {
				return this.getParamDef().compareTo(toCompare.getParamDef());
			}
		}

		if (!this.getCodeBody().equals(toCompare.getCodeBody())) {
			return this.getCodeBody().compareTo(toCompare.getCodeBody());
		}

		return -1;
	}

	protected boolean callerExists(Executable caller) {
		for (Executable e : this.getCaller()) {
			if (e.getName().equals(caller.getName())
					&& e.getScript().getFile().getName()
							.equals(caller.getScript().getFile().getName())
			/*&& e.getMetaType().equals(caller.getMetaType())*/) {
				return true;
			}
		}
		return false;
	}

	protected boolean calledExists(Executable searched) {
		for (Executable e : this.getCalled()) {
			if (e instanceof Template) {
				if (e.getName().equals(searched.getName())
						&& searched.getScript().getFile()
								.equals(e.getScript().getFile())) {
					return true;
				}
			} else if (e instanceof Function) {
				// the file isnt setted here.. we set it up later
				if (e.getName().equals(searched.getName())
						&& e.getParamDef().equals(searched.getParamDef())) {
					return true;
				}
			}
		}
		return false;
	}

	protected void splitNestedFunction(String nested) {
		char[] arNested = nested.toCharArray();
		while (buildFunction(arNested)) {
		}
	}

	protected boolean buildFunction(char[] chars) {
		String functionName = "", params = "";
		// if any char of pCrap is located, the function name will be resetted
		// to empty string
		Pattern pCrap = Pattern
				.compile("!|\\.|&|:|\\)|\\?|/|\\*|\\||=|\r\n|\r|\n|\\s");
		Matcher mCrap;
		for (int j = 0; j < chars.length - 1; j++) {
			mCrap = pCrap.matcher(chars[j] + "");

			if (StringHelper.isWordChar(chars[j]) && chars[j + 1] == '(') {
				functionName = functionName + chars[j];
				// thers an error with checking the bracket count.. dunno why..
				// so just check it too times and ok ^^
				// TODO
				params = checkBracketCount(checkBracketCount(findParams(j + 1,
						chars)));

				Function called = new Function(functionName, "", "");
				called.setMetaType(this.metaType);
				called.setParamDef(params);

				if (!calledExists(called))
					insertInCalled(called);

				// need a new function with the same atributes
				// otherwise we got some problems wit setting up the link
				Function tmp = new Function(this.name, this.code, this.paramDef);
				tmp.setMetaType(this.metaType);
				tmp.setDocumentation(this.documentation);
				tmp.setScript(this.getScript());
				tmp.setCalled(this.called);
				tmp.setCaller(this.caller);

				called.insertInCaller(tmp);

				functionName = "";
			} else if (StringHelper.isWordChar(chars[j])) {
				functionName = functionName + chars[j];
			} else if (mCrap.find()) {
				functionName = "";
			}
		}
		return false;
	}

	/*
	 * returns the parameters with brackets
	 */
	protected String findParams(int start, char[] chars) {
		String params = "";
		int openBracketCounter = 0;

		for (int j = start; j < chars.length; j++) {
			if (chars[j] == '(') {
				params = params + chars[j];
				openBracketCounter++;
			} else if (chars[j] == ')' && openBracketCounter == 1) {
				params = params + chars[j];
				return params;
			} else if (chars[j] == ')') {
				params = params + chars[j];
				openBracketCounter--;
			} else {
				params = params + chars[j];
			}
		}
		return params;
	}

	/*
	 * sometimes, parsed functions misses some brackets
	 * @return a formatted function with correct open and closed bracket count
	 */
	protected String checkBracketCount(String params) {
		Pattern pOpenBracket = Pattern.compile("\\(");
		Pattern pClosedBracket = Pattern.compile("\\)");
		Matcher mOpenBracket, mClosedBracket;
		int openBracketCounter = 0, closedBracketCounter = 0;

		mOpenBracket = pOpenBracket.matcher(params);
		while (mOpenBracket.find()) {
			openBracketCounter++;
		}

		mClosedBracket = pClosedBracket.matcher(params);
		while (mClosedBracket.find()) {
			closedBracketCounter++;
		}

		if (openBracketCounter > closedBracketCounter) {
			params = params + ")";
			checkBracketCount(params);
		}
		return params;
	}

	/* PROTECTED REGION END */
}
