package de.genesez.scriptdoc.parsing;

import java.util.*;
import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.swing.Icon;

import de.genesez.scriptdoc.helper.ExecutableHelper;
import de.genesez.scriptdoc.helper.StringHelper;
import de.genesez.scriptdoc.htmlgenerator.BuiltInLoader;
import de.genesez.scriptdoc.parsing.Function.OwnerType;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337383733767_593203_1955) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public abstract class Script implements IContent, Comparable<Script> {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** stores the associated object of association SCRIPTPACKAGE to ScriptPackage */
	protected ScriptPackage scriptPackage;
	
	/** stores associated objects of association SYMBOLS to Executable */
	protected java.util.Set<Executable> symbols = new java.util.TreeSet<Executable>();
	
	/** stores the associated object of association ROOT to Roots */
	protected Roots root;
	
	protected File file;
	
	protected ScriptPackage pack;
	
	protected String content;
	
	protected String headComment;
	
	protected String headImport;
	
	protected String link;
	
	protected java.util.ArrayList<String> headExtensions = new java.util.ArrayList<String>();
	
	protected Pattern p;
	
	protected Matcher m;
	
	// -- generated method declarations -------------------------------------
	/**
	 * Method stub for further implementation.
	 */
	protected abstract void parse();
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public void read() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337385442450_165935_2664) ENABLED START */
		StringBuilder sb = new StringBuilder();
		int c;
		try {
			java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(file));
			while ((c = reader.read()) != -1) {
				sb.append((char) c);
			}
			reader.close();
			content = sb.toString();
		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public void setupCallers() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337385450547_538050_2666) ENABLED START */
		for (ScriptPackage p : root.getTable().getPackages()) {
			for (Script script : p.getScripts()) {
				for (Executable ex : script.getSymbols()) {
					for (Executable called : ex.getCalled()) {
						for (Executable caller : called.getCaller()) {
							
							for (Executable curex : this.getSymbols()) {
								if (curex.getName().equals(called.getName())
										/*&& curex.getMetaType().equals(called.getMetaType())*/) {
									if (!curex.callerExists(caller)) {
										curex.insertInCaller(caller);
									}
								}
							}
						}
					}
				}
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public void setupCalledFunctionOwner() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337385460905_650335_2668) ENABLED START */
		boolean ownerFound;
		for (Executable owner : symbols) {
			for (Executable called : owner.getCalled()) {
				// called is the Executable whose we search his owner  
				if (called instanceof Function) {
					Function calledFunction = (Function) called;
					ownerFound = false;
					ArrayList<String> tmpHeadExt = headExtensions;
					// we need to add the current script path to the headextensions
					// otherwise it dont finds function that sits in the script "script"
					String sTmpHeadExt = this.getFile().getPath().replace("\\", "::").replace(".ext", "");
					tmpHeadExt.add(sTmpHeadExt);
					// now we search the script which belongs to the HeadExtension
					for (String headExt : tmpHeadExt) {
						for (ScriptPackage p : root.getTable().getPackages()) {
							for (Script extScript : p.getScripts()) {
								if (extScript instanceof ExtendScript) {
									if (extScript.getFile().getPath().replace("\\", "::").replace(".ext", "").contains(StringHelper.removeReExportStatment(headExt))) {
										for (Executable function : extScript.getSymbols()) {
											if (calledFunction.getName().equals(function.getName())
											/*&& function.getFile().getFile().getName().equals(called.getFile().getFile().getName())*/) {
												calledFunction.setScript(extScript);
												calledFunction.setOwnerType(OwnerType.OrdinaryOwner);
												ownerFound = true;
											}
										}
									}
								}
							}
						}
					}
					
					tmpHeadExt.remove(sTmpHeadExt);
					
					// check if the called function is a built-in function 
					// or an automatically gernerated setter/getter
					// or included by reexported script
					// or not found
					if (!ownerFound) {
						
						Script reexported = isIncludedByReExport(calledFunction.getName());
						
						if (reexported != null) {
							calledFunction.setScript(reexported);
							calledFunction.setOwnerType(OwnerType.ReExported);
						} else {
							if (BuiltInLoader.getInstance().isBuiltInFunction(calledFunction.getName())) {
								calledFunction.setOwnerType(OwnerType.BuiltIn);
							} else if (ExecutableHelper.getInstance().isProvidedByEMF(calledFunction, owner)) {
								calledFunction.setOwnerType(OwnerType.GeneratededByEMF);
							} else {
								calledFunction.setOwnerType(OwnerType.ExternalFunction);
							}
						}
					}
				}
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	calledFunctionName	
	 * @return	
	 */
	public Script isIncludedByReExport(String calledFunctionName) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337385522338_406282_2670) ENABLED START */
		ArrayList<String> tmpHeadExt = headExtensions;
		String reexport = "reexport";
		
		for (String extension : tmpHeadExt) {
			// search the script with belongs to this headextension
			// e.g. org::genesez::platform::common::Conversion 
			// - we search the conversation script in org::genesez::platform::common
			// to look in the conversation script for reexports
			
			Script s = root.getTable().getScript(extension);
			
			if (s != null) {
				for (String headExt : s.getHeadExtensions()) {
					// just reexported scripts could contain this called function
					if (headExt.contains(reexport)) {
						Script reexportedScript = root.getTable().getScript(headExt.replaceFirst("\\s+" + reexport, ""));
						
						for (Executable ex : reexportedScript.getSymbols()) {
							if (ex.getName().equals(calledFunctionName)) {
								return reexportedScript;
							}
						}
						
					}
				}
			}
		}
		return null;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	toCompare	
	 * @return	
	 */
	public int compareTo(Script toCompare) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337385547407_504618_2672) ENABLED START */
		int lstComp = this.getFile().getName().compareTo(toCompare.getFile().getName());
		return lstComp;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
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
	 * Gets the value of the attribute '<em><b>pack</b></em>'
	 */
	public ScriptPackage getPack() {
		return pack;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>pack</b></em>'
	 */
	public void setPack(ScriptPackage pack) {
		this.pack = pack;
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
	 * Gets the value of the attribute '<em><b>headComment</b></em>'
	 */
	public String getHeadComment() {
		return headComment;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>headComment</b></em>'
	 */
	public void setHeadComment(String headComment) {
		this.headComment = headComment;
	}
	
	/**
	 * Gets the value of the attribute '<em><b>headImport</b></em>'
	 */
	public String getHeadImport() {
		return headImport;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>headImport</b></em>'
	 */
	public void setHeadImport(String headImport) {
		this.headImport = headImport;
	}
	
	/**
	 * Gets the value of the attribute '<em><b>link</b></em>'
	 */
	public String getLink() {
		return link;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>link</b></em>'
	 */
	public void setLink(String link) {
		this.link = link;
	}
	
	/**
	 * Gets the value of the attribute '<em><b>headExtensions</b></em>'
	 */
	public java.util.List<String> getHeadExtensions() {
		return headExtensions;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>headExtensions</b></em>'
	 */
	public void setHeadExtensions(java.util.ArrayList<String> headExtensions) {
		this.headExtensions = headExtensions;
	}
	
	/**
	 * accessor for association to symbols
	 */
	public java.util.Set<Executable> getSymbols() {
		return java.util.Collections.unmodifiableSet(symbols);
	}
	
	/**
	 * accessor for association to symbols
	 */
	public void insertInSymbols(Executable symbols) {
		if (this.symbols.contains(symbols)) {
			return;
		}
		this.symbols.add(symbols);
		symbols.setScript(this);
	}
	
	/**
	 * accessor for association to symbols
	 */
	public void removeFromSymbols(Executable symbols) {
		if (!this.symbols.contains(symbols)) {
			return;
		}
		this.symbols.remove(symbols);
	}
	
	/**
	 * accessor for association to root
	 */
//	public Roots getRoot() {
//		return root;
//	}
	
	/**
	 * accessor for association to root
	 */
	public void setRoot(Roots root) {
		this.root = root;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337383733767_593203_1955) ENABLED START */
	protected java.util.ArrayList<String> headExtensionLinks = new java.util.ArrayList<String>();
	
	/**
	 * Gets the value of the attribute '<em><b>headExtensions</b></em>'
	 */
	public java.util.ArrayList<String> getHeadExtensionLinks() {
		return headExtensionLinks;
	}
	/**
	 * Sets the value of the attribute '<em><b>headExtensions</b></em>'
	 */
	public void setHeadExtensionLinks(java.util.ArrayList<String> headExtensions) {
		this.headExtensions = headExtensionLinks;
	}
	
	/**
	 * path to base directory of scripts
	 */
	private String rootPath;
	
	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	
	/**
	 * accessor for association to symbols
	 */
	public void insert(Executable symbols) {
		if (this.symbols.contains(symbols)) {
			return;
		}
		this.symbols.add(symbols);
	}
	
	/* PROTECTED REGION END */

}
