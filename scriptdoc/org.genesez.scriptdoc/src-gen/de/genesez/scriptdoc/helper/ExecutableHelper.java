package de.genesez.scriptdoc.helper;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.genesez.scriptdoc.parsing.ScriptPackage;
import de.genesez.scriptdoc.parsing.SymbolTable;
import de.genesez.scriptdoc.parsing.Script;
import de.genesez.scriptdoc.parsing.Executable;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337513740116_55517_2457) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class ExecutableHelper {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static ExecutableHelper instance = new ExecutableHelper();
	
	private static SymbolTable table;
	
	private java.util.Set<Script> generatedFunctionHolder = new java.util.HashSet<Script>();
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>ExecutableHelper</b></em>'.
	 */
	private ExecutableHelper() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_ce902ca_1337514100821_672425_2494) ENABLED START */
		table = new SymbolTable();
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public void searchExtendFunctionOwner() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337514129088_832790_2497) ENABLED START */
		for (ScriptPackage p : table.getPackages()) {
			for (Script script : p.getScripts()) {
				script.setupCalledFunctionOwner();
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public void searchCallers() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337514139259_235081_2499) ENABLED START */
		for (ScriptPackage p : table.getPackages()) {
			for (Script script : p.getScripts()) {
				script.setupCallers();
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	called	
	 * @param	owner	
	 * @return	
	 */
	public boolean isProvidedByEMF(Executable called, Executable owner) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337514149696_369934_2501) ENABLED START */
		for (Script s : generatedFunctionHolder) {
			for (Executable e : s.getSymbols()) {
				if (e.getName().trim().toLowerCase().equals(called.getName().trim().toLowerCase())) {
					return true;
				}
			}
		}
		return false;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Gets the value of the attribute '<em><b>instance</b></em>'
	 */
	public static ExecutableHelper getInstance() {
		return instance;
	}
	
	/**
	 * Gets the value of the attribute '<em><b>table</b></em>'
	 */
	public static SymbolTable getTable() {
		return table;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>table</b></em>'
	 */
	public static void setTable(SymbolTable _table) {
		table = _table;
	}
	
	/**
	 * Gets the value of the attribute '<em><b>generatedFunctionHolder</b></em>'
	 */
	public java.util.Set<Script> getGeneratedFunctionHolder() {
		return generatedFunctionHolder;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>generatedFunctionHolder</b></em>'
	 */
	public void setGeneratedFunctionHolder(java.util.Set<Script> generatedFunctionHolder) {
		this.generatedFunctionHolder = generatedFunctionHolder;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337513740116_55517_2457) ENABLED START */
	/*
	 * returns the parameters with brackets
	 */
	public static String findParams(int start, char[] chars) {
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
	public static String checkBracketCount(String params) {
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
