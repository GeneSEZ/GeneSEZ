package de.genesez.scriptdoc.helper;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337515662172_619361_2617) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class StringHelper {
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	content	
	 * @param	searchedValue	
	 * @param	lineSeparator	
	 * @return	
	 */
	public static String duplicateLine(String content, String searchedValue, String lineSeparator) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337515679036_503425_2635) ENABLED START */
		String[] parts = content.split(lineSeparator);
		String[] tmpparts = new String[parts.length + 1];
		boolean found = false;
		for (int i = 0; i < parts.length; i++) {
			if (found) {
				tmpparts[i + 1] = parts[i];
			} else {
				tmpparts[i] = parts[i];
			}
			if (parts[i].contains(searchedValue)) {
				String lineToCopy = parts[i];
				tmpparts[i + 1] = lineToCopy;
				found = true;
			}
		}
		return StringHelper.arrayToString(tmpparts, lineSeparator);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	content	
	 * @param	lineSeparator	
	 * @param	searchedValue	
	 * @param	replacement	
	 * @return	
	 */
	public static String replaceFirstLine(String content, String lineSeparator, String searchedValue, String replacement) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337515768471_398827_2641) ENABLED START */
		String[] parts = content.split(lineSeparator);
		boolean found = false;
		for (int i = 0; i < parts.length; i++) {
			if (parts[i].contains(searchedValue) && !found) {
				parts[i] = parts[i].replace(searchedValue, replacement);
				found = true;
			}
		}
		return StringHelper.arrayToString(parts, lineSeparator);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	parts	
	 * @param	separator	
	 * @return	
	 */
	public static String arrayToString(String[] parts, String separator) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337515943706_24995_2648) ENABLED START */
		StringBuffer result = new StringBuffer();
		for (String part : parts) {
			if (part != null) {
				result.append(part);
				result.append(separator);
			}
		}
		return result.toString();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	text	
	 * @return	
	 */
	public static Integer getHeight(String text) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337516226027_764036_2655) ENABLED START */
		String newline = "\r\n|\r|\n";
		String[] arText = text.split(newline);
		return arText.length + 1;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	f	
	 * @param	root	
	 * @return	
	 */
	public static String separateEclipsProjectPathOutOfFile(File f, String root) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337516444910_862200_2665) ENABLED START */
		String delimeter = "::", tmp;
		tmp = formatPath(f, root);
		
		String[] arNamespace = tmp.split(delimeter);
		return arNamespace[0];
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	f	
	 * @param	root	
	 * @param	removeFileName	
	 * @return	
	 */
	public static String separateNamespaceOutOfFile(File f, String root, boolean removeFileName) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337516536054_494274_2670) ENABLED START */
		String namespace = "", delimeter = "::", tmp;
		
		if (removeFileName) {
			tmp = formatPath(f, root);
		} else {
			tmp = removeRootFromPath(f.getPath(), root).replace("\\", delimeter);
		}
		
		String[] arNamespace = tmp.split(delimeter);
		
		for (int i = 2; i < arNamespace.length; i++) {
			// we dont want the delimeter at the end of our namespace string
			if (i == arNamespace.length - 1) {
				delimeter = "";
			}
			namespace = namespace + arNamespace[i] + delimeter;
		}
		return namespace;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	f	
	 * @param	root	
	 * @return	
	 */
	public static String separateDirPathOutOfFile(File f, String root) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337516361872_530055_2660) ENABLED START */
		return getUnixConformPath(removeRootFromPath((getPathWithoutFileName(f)), root)).replace(separateEclipsProjectPathOutOfFile(f, root) + "/", "");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	f	
	 * @param	root	
	 * @return	
	 */
	public static String formatPath(File f, String root) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337516627501_241953_2676) ENABLED START */
		return removeRootFromPath(getPathWithoutFileName(f), root).replace("\\", "::");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	path	
	 * @param	root	
	 * @return	
	 */
	public static String removeRootFromPath(String path, String root) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337516684691_401815_2681) ENABLED START */
		String separator = "\\";
		return path.replace(root + separator, "");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	f	
	 * @return	
	 */
	public static String getPathWithoutFileName(File f) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337516756170_95582_2686) ENABLED START */
		return f.getPath().replace("\\" + f.getName(), "");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	originPath	
	 * @param	root	
	 * @return	
	 */
	public static String transformPath(String originPath, String root) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337516793532_476046_2690) ENABLED START */
		return originPath.replace(root + "/", "").replace("/", "::");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	originPath	
	 * @param	root	
	 * @return	
	 */
	public static String replaceSlashWithColon(String originPath, String root) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337516842891_805863_2695) ENABLED START */
		return originPath.replace(root + "/", "").replace("/", "::");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	origin	
	 * @return	
	 */
	public static String replaceColonWithSlash(String origin) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337516949501_536633_2700) ENABLED START */
		return origin.replace("::", "/");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	path	
	 * @return	
	 */
	public static String getUnixConformPath(String path) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337517104394_113102_2704) ENABLED START */
		return path.replace("\\", "/");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	ext	
	 * @return	
	 */
	public static String removeReExportStatment(String ext) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337517165858_918804_2708) ENABLED START */
		return ext.replace("reexport", "").trim();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	charToCheck	
	 * @return	
	 */
	public static boolean isWordChar(char charToCheck) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337517227332_906358_2712) ENABLED START */
		Pattern pWordChar = Pattern.compile("\\w");
		Matcher mWordChar;
		
		String wordchar = charToCheck + "";
		mWordChar = pWordChar.matcher(wordchar);
		return mWordChar.find();
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337515662172_619361_2617) ENABLED START */
	public static String replaceColonsWithDot(String s) {
		return s.replace("::", ".").trim();
	}
	/* PROTECTED REGION END */

}
