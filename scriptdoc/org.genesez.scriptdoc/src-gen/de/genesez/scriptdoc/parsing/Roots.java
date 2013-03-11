package de.genesez.scriptdoc.parsing;

import java.util.*;
import java.io.File;

import de.genesez.scriptdoc.helper.ExecutableHelper;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337383908346_935331_1965) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class Roots {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** stores the associated object of association TABLE to SymbolTable */
	private SymbolTable table;
	
	private File base;
	
	private java.util.Set<File> paths = new java.util.HashSet<File>();
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>Roots</b></em>'.
	 */
	public Roots() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_ce902ca_1337384605712_566389_2303) ENABLED START */
		table = new SymbolTable();
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public void parse() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337384509881_245091_2295) ENABLED START */
		System.out.println("parsing scripts...");
		for (File directory : paths) {
			System.out.println("current directory:" + directory);
			if (directory.exists() && directory.isDirectory()) {
				descend(directory);
			}
		}
		ExecutableHelper.getInstance().setTable(table);
		ExecutableHelper.getInstance().searchExtendFunctionOwner();
		ExecutableHelper.getInstance().searchCallers();
//		System.out.println(symbolTableDump());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	child	
	 */
	public void descend(File child) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337384524935_423137_2297) ENABLED START */
		for (File file : child.listFiles()) {
			if (file.isDirectory())
				descend(file);
			else
				parseScript(file);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	script	
	 */
	public void parseScript(File script) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337384562500_545262_2300) ENABLED START */
		Script s;
		if (script.getName().endsWith(".xpt")) {
			s = new ExpandScript();
		} else if (script.getName().endsWith(".ext")) {
			s = new ExtendScript();
		} else if (script.getName().endsWith(".chk")) {
			s = new CheckScript();
		} else
			return;
		s.setFile(script);
		s.setRoot(this);
		s.parse();
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
	 * Gets the value of the attribute '<em><b>paths</b></em>'
	 */
	public java.util.Set<File> getPaths() {
		return paths;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>paths</b></em>'
	 */
	public void setPaths(java.util.Set<File> paths) {
		this.paths = paths;
	}
	
	/**
	 * accessor for association to table
	 */
	public SymbolTable getTable() {
		return table;
	}
	
	/**
	 * accessor for association to table
	 */
	public void setTable(SymbolTable table) {
		this.table = table;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337383908346_935331_1965) ENABLED START */
	@SuppressWarnings("unused")
	private String symbolTableDump() {
		StringBuilder builder = new StringBuilder();
		int tabs = 0, tabSize = 8, symSize = 0;
		for (ScriptPackage p : table.getPackages()) {
			builder.append(p.getName());
			builder.append(" includes: ");
			builder.append("\n");
			for (Script s : p.getScripts()) {		
				builder.append(s.getFile().getName());
				builder.append("\n");
			}
			builder.append("\n");
		}
		return builder.toString();
	}
	/* PROTECTED REGION END */

}
