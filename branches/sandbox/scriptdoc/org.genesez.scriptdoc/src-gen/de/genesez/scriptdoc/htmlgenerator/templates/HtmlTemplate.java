package de.genesez.scriptdoc.htmlgenerator.templates;

import java.util.*;
import de.genesez.scriptdoc.parsing.SymbolTable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import de.genesez.scriptdoc.htmlgenerator.wildcards.WildCard;
import de.genesez.scriptdoc.htmlgenerator.wildcards.factory.WildCardFactory;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337441098867_13776_1886) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public abstract class HtmlTemplate {
	
	// -- generated attribute, constant + association declarations ----------
	
	protected SymbolTable table;
	
	protected String content;
	
	protected String templateName;
	
	protected String name;
	
	protected String path;
	
	protected String root;
	
	protected File file;
	
	protected java.util.Set<WildCardFactory> wildcards = new java.util.HashSet<WildCardFactory>();
	
	protected ContentType contentType;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>HtmlTemplate</b></em>'.
	 * @param	templateName	
	 * @param	fileName	
	 * @param	type	
	 */
	public HtmlTemplate(String templateName, String fileName, ContentType type) {
		/* PROTECTED REGION ID(java.constructor._17_0_1_ce902ca_1337547673198_955454_9343) ENABLED START */
		this.templateName = templateName;
		this.name = fileName;
		this.contentType = type;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Constructor for class '<em><b>HtmlTemplate</b></em>'.
	 * @param	templateName	
	 * @param	type	
	 */
	public HtmlTemplate(String templateName, ContentType type) {
		/* PROTECTED REGION ID(java.constructor._17_0_1_ce902ca_1337547710076_382831_9347) ENABLED START */
		this.templateName = templateName;
		this.contentType = type;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Constructor for class '<em><b>HtmlTemplate</b></em>'.
	 */
	public HtmlTemplate() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_ce902ca_1340247106357_764831_1959) ENABLED START */
		/* PROTECTED REGION END */
	}
	
	// -- generated method declarations -------------------------------------
	/**
	 * Method stub for further implementation.
	 */
	public abstract void make();
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public void generate() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337457344774_913643_3279) ENABLED START */
		replaceWildCards();
		createFile(".html");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	type	
	 * @return	
	 */
	public boolean createFile(String type) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337457361482_165389_3281) ENABLED START */
		boolean failed = true;
			String fullpath = (scriptPath + "/" + this.getPath()).replaceAll("//", "/");
			String fullname = (fullpath + "/" + this.getName() + type).replaceAll("//", "/");
			if(fullpath.contains("..") || getName().length() == 0) {
				System.err.println(fullpath);
				return false;
			}
		try {
			File dir = new File(fullpath);
			if(!dir.exists()) {
				dir.mkdirs();
			}
			file = new File(fullname);
			failed = file.createNewFile();
			FileWriter writer = new FileWriter(file);
			
			writer.write(content);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			System.err.println(file.getAbsolutePath() + " error: " + e);
			e.printStackTrace();
		}
		return failed;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	protected void replaceWildCards() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337457449950_693122_3286) ENABLED START */
		// some templates don't includes wildcards..
		if (this.wildcards != null) {
			for (WildCardFactory fac : this.wildcards) {
				for (WildCard wildcard : fac.getWildcards()) {
					content = wildcard.replaceContent(content);
				}
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	fileName	
	 * @param	path	
	 * @param	template	
	 * @param	factories	
	 * @return	
	 */
	protected HtmlTemplate create(String fileName, String path, HtmlTemplate template, java.util.Set<WildCardFactory> factories) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337457478279_806211_3288) ENABLED START */
		template.setContent(this.content);
		template.setWildcards(factories);
		template.setPath(path);
		template.setName(fileName);
		template.generate();
		return template;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	public boolean read() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337457629692_343398_3297) ENABLED START */
		boolean failed = true;
		String dir = "templates";
		StringBuilder sb = new StringBuilder();
		int c;
		try {
			java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(dir + "/" + this.templateName));
			while ((c = reader.read()) != -1) {
				sb.append((char) c);
			}
			reader.close();
			setContent(sb.toString());
		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return failed;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Gets the value of the attribute '<em><b>table</b></em>'
	 */
	public SymbolTable getTable() {
		return table;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>table</b></em>'
	 */
	public void setTable(SymbolTable table) {
		this.table = table;
	}
	
	/**
	 * Gets the value of the attribute '<em><b>content</b></em>'
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>content</b></em>'
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Gets the value of the attribute '<em><b>templateName</b></em>'
	 */
	public String getTemplateName() {
		return templateName;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>templateName</b></em>'
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	
	/**
	 * Gets the value of the attribute '<em><b>name</b></em>'
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>name</b></em>'
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the value of the attribute '<em><b>path</b></em>'
	 */
	public String getPath() {
		return path;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>path</b></em>'
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	/**
	 * Gets the value of the attribute '<em><b>root</b></em>'
	 */
	public String getRoot() {
		return root;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>root</b></em>'
	 */
	public void setRoot(String root) {
		this.root = root;
	}
	
	/**
	 * Gets the value of the attribute '<em><b>file</b></em>'
	 */
	public File getFile() {
		return file;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>file</b></em>'
	 */
	public void setFile(File file) {
		this.file = file;
	}
	
	/**
	 * Gets the value of the attribute '<em><b>wildcards</b></em>'
	 */
	public java.util.Set<WildCardFactory> getWildcards() {
		return wildcards;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>wildcards</b></em>'
	 */
	public void setWildcards(java.util.Set<WildCardFactory> wildcards) {
		this.wildcards = wildcards;
	}
	
	/**
	 * Gets the value of the attribute '<em><b>contentType</b></em>'
	 */
	public ContentType getContentType() {
		return contentType;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>contentType</b></em>'
	 */
	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337441098867_13776_1886) ENABLED START */
	
	private static String scriptPath = "scriptdoc";
	
	public static void setScriptPat(String path) {
		scriptPath = path;
	}
	
	public enum ContentType {
		NAVI,
		OAWSCRIPTHEAD,
		EXPAND,
		EXTEND,
		CHECK,
		SCRIPTSUMMARY,
		SCRIPTSUMMARYFRAME,
		PACKAGE,
		PACKAGESUMMARY,
		METATYPE,
		METATYPESUMMARY,
		STATSSCRIPT,
		STATSSUMMARY,
		STATSSCRIPTSUMMARY,
		EXPANDBUNDLE,
		EXTENDBUNDLE,
		CHECKBUNDLE,
		EXTERNALFUNCTION,
		EXECUTABLEINDEX,
		EXECUTABLEINDEXNAVI,
		NONE;
	}
	/* PROTECTED REGION END */

}
