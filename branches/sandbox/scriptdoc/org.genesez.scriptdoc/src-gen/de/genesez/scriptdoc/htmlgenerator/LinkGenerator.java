package de.genesez.scriptdoc.htmlgenerator;

import java.util.*;
import java.io.File;

import de.genesez.scriptdoc.helper.RelativePath;
import de.genesez.scriptdoc.helper.StringHelper;
import de.genesez.scriptdoc.parsing.Executable;
import de.genesez.scriptdoc.parsing.ExtendScript;
import de.genesez.scriptdoc.parsing.Function;
import de.genesez.scriptdoc.parsing.IContent;
import de.genesez.scriptdoc.parsing.ScriptPackage;
import de.genesez.scriptdoc.parsing.SymbolTable;
import de.genesez.scriptdoc.parsing.Script;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337440728163_389260_1787) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class LinkGenerator extends Generator {
	
	// -- generated attribute, constant + association declarations ----------
	
	private File base;
	
	private SymbolTable table;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * generates the links.
	 * @return true if generation failed, false if succeed	
	 */
	public boolean generate() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337518775439_578051_2920) ENABLED START */
		String link, to;
		boolean failed = true;
		
		// generate script links
		generateScriptLinks();

		// generate headextension links
		for (ScriptPackage pack : table.getPackages()) {
			for (Script script : pack.getScripts()) {
				// generate headextension paths
				for (String headExt : script.getHeadExtensions()) {
					// search the extend script that belongs to the headExt
					link = searchExtensionPath(headExt, script);
					// if we dont find that script, because its not scanned,
					if (link == null) {
						// set the link to the not-referenced.html..
						to = NOTREFERENCED;
						File tmp = new File(script.getLink());
						link = RelativePath.getRelativePath(new File(script.getLink().replace(tmp.getName(), ""))
							, new File(NOTREFERENCED));
					}
					script.getHeadExtensionLinks().add(link);
				}
				// generate executable paths
				for (Executable ex : script.getSymbols()) {
					generateExecutableLinks(ex, script.getLink());
				}
			}
		}
		return failed;
		/* PROTECTED REGION END */
	}
	
	/**
	 * generates relative paths for all scripts. We have to generate 'em before generating executables paths,
	 * because we use the script link to create the executable paths. 
	 */
	public void generateScriptLinks() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337518856207_264423_2923) ENABLED START */
		String path;
		System.out.println("generating file links...");
		for (ScriptPackage pack : table.getPackages()) {
			// generate script paths
			for (Script script : pack.getScripts()) {
				path = RelativePath.getRelativePath(this.base, script.getFile())
					.replace("\\", "/") + DOCFILETYPE;
				script.setLink(path);
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * generates relative paths for all executables, callers and called executables too.
	 * @param	ex - the current executable 	
	 * @param	ownerLink - the link of the script that declares the executable ex	
	 */
	public void generateExecutableLinks(Executable ex, String ownerLink) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337518856207_264423_2923) ENABLED START */
		String home, link;
		Function.OwnerType type = null;
		File scriptLink = null;
		File exOwner =  ex.getScript().getFile();
		
		// generate link of executable ex
		link = RelativePath.getRelativePath(this.base, exOwner) + DOCFILETYPE;
		ex.setLink(link);
		
		//generate called paths
		for (Executable called : ex.getCalled()) {
			type = null; // reset the type to distinguish the executables
			if (called instanceof Function) {
				Function calledFunction = (Function) called;
				scriptLink = new File(ownerLink);				
				type = calledFunction.getOwnerType();
			}
			
			if(type != null && 
					!type.equals(Function.OwnerType.ReExported) && 
					!type.equals(Function.OwnerType.OrdinaryOwner)) {
				
				if(type.equals(Function.OwnerType.BuiltIn)) {
					home = ISINTEGRATEDFUNCTION; 
				}else if (type.equals(Function.OwnerType.GeneratededByEMF)) {
					home = ISGENERATEDFUNCTION; 
				}else {// the scan doesnt contains this script
					   // so we refer to the not-referenced.html	
					home = NOTREFERENCED; 
				}
				
				link = RelativePath.getRelativePath(
						new File(ownerLink.replace(scriptLink.getName(), "")), new File(home));	
			}else { // links for templates, validations, and 
					// functions with "ordinary" owners and reexported functions
				home = ex.getScript().getFile().getPath()
					.replace(ex.getScript().getFile().getName(), "");
				link = RelativePath.getRelativePath(new File(home), 
					called.getScript().getFile()) + DOCFILETYPE;		
			}
			
			called.setLink(link);
		}
		File linkTo;
		String suffix; // the filetype
		// generate caller links
		for (Executable caller : ex.getCaller()) {
			File tmp = caller.getScript().getFile();
			if (caller.getScript() != null) {
				home = ex.getScript().getFile().getPath().replace(ex.getScript().getFile().getName(), "");
				linkTo = tmp;
				suffix = DOCFILETYPE;
			} else if (BuiltInLoader.getInstance().isBuiltInFunction(caller.getName())) {
				home = ownerLink.replace(tmp.getName(), "");
				linkTo = new File(ISINTEGRATEDFUNCTION);
				suffix = "";
			} else {
				home = ownerLink.replace(tmp.getName(), "");
				linkTo = new File(NOTREFERENCED);
				suffix = "";
			}
			link = RelativePath.getRelativePath(new File(home), linkTo) + suffix;
			
			caller.setLink(link);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	ext	
	 * @param	extCaller	
	 * @return	
	 */
	public String searchExtensionPath(String ext, Script extCaller) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337519013246_232564_2929) ENABLED START */
		String link;
		
		// look for each scanned extension.. maybe we could reference it
		// otherwise we link to the notReferenced.html
		for (ScriptPackage pack : table.getPackages()) {
			for (Script script : pack.getScripts()) {
				// just look for extend scripts..
				if (script instanceof ExtendScript) {
					String formExtendPath = StringHelper.replaceSlashWithColon(script.getLink(), root);
					if (formExtendPath.contains(StringHelper.removeReExportStatment(ext))) {
						File tmp = new File(extCaller.getLink());
						String extCallerPath = extCaller.getLink().replace(tmp.getName(), "");
						link = RelativePath.getRelativePath(new File(extCallerPath), new File(script.getLink()));
						return link;
					}
				}
			}
		}
		return null;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Gets the value of the attribute '<em><b>base</b></em>'
	 */
	public File getBase() {
		return base;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>base</b></em>'
	 */
	public void setBase(File base) {
		this.base = base;
	}
	
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
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337440728163_389260_1787) ENABLED START */
	public static final String NOTREFERENCED = "external-function.html";
	public static final String ISINTEGRATEDFUNCTION = "integrated-function.html";
	public static final String ISGENERATEDFUNCTION = "generated-function.html";
	public static final String DOCFILETYPE = ".html";
	public static final String FILESEPARATOR = "/";
	public static final String NOTFOUND = "NOT_FOUND(!)";
	public static final String NOTSETTED = "FOR LATER USAGE :)";
	
	/*
	 * produces a relative path, used by wildcard impleme
	 */
	public static String getRelativePath(IContent c, String toFile) {
		Script s = (Script) c;
		String summaryFile = s.getRoot() + "/" + toFile;	
		
		String scriptHome = s.getFile().getPath()
			.replace(s.getRoot().getBase().getPath(), "")
			.replace("\\", "/");
		
		scriptHome = s.getRoot() + scriptHome.replace((new File(scriptHome)).getName(), "");	
		
		return RelativePath.getRelativePath(new File(scriptHome), new File(summaryFile));	
	}
	
	@SuppressWarnings("unused")
	private String printOnConsolePlease(TreeSet<ScriptPackage> symbols) {
		StringBuilder b = new StringBuilder();
		for (ScriptPackage pack : symbols) {
			b.append(pack.getName()).append(":\n");
			for (Script s : pack.getScripts()) {
				b.append(s.getFile().getName()).append(":\n");
				/*
				for (int i = 0; i < s.getHeadExtensions().size(); i++) {
					String ext = s.getHeadExtensions().get(i);
					String link = s.getHeadExtensionLinks().get(i); 
					b.append(ext + " link: " + link + "\n");
				}
				 */
				for (Executable ex : s.getSymbols()) {
					b.append(ex.getName() + " link: " + ex.getLink() + "\n");
					for (Executable called : ex.getCaller()) {
						b.append("called by " + called.getName() + " link: " + called.getLink() + "\n");
					}
				}
			}
		}
		return b.toString();
	}
	/* PROTECTED REGION END */

}
