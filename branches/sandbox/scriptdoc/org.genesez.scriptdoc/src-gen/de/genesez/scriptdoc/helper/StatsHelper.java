package de.genesez.scriptdoc.helper;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.genesez.scriptdoc.parsing.Script;
import de.genesez.scriptdoc.parsing.Executable;
import de.genesez.scriptdoc.parsing.ScriptPackage;
import de.genesez.scriptdoc.parsing.SymbolTable;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337514226112_11017_2508) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class StatsHelper {
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	s	
	 * @return	
	 */
	public static Integer getLineCount(String s) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337514250620_116659_2526) ENABLED START */
		String[] content = s.split(NEWLINE);
		return content.length;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	s	
	 * @return	
	 */
	public static Integer getCommentLineCount(Script s) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337514388911_741003_2530) ENABLED START */
		int count = 0;
		// .. empty comments would produce an increment of count
		if (s.getHeadComment() != null && !s.getHeadComment().equals("")) {
			count = getLineCount(s.getHeadComment());
		}
		
		for (Executable e : s.getSymbols()) {
			count = count + getCommentLineCount(e);
			count = count + getLineCount(e.getDocumentation());
		}
		return count;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	e	
	 * @return	
	 */
	public static Integer getCommentLineCount(Executable e) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337514492917_802101_2535) ENABLED START */
		int count = 0;
		Set<String> comments = e.getComments();
		for (String c : comments) {
			count = count + getLineCount(c);
		}
		return count;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	s	
	 * @return	
	 */
	public static Integer getBlankLineCount(String s) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337514606636_764224_2539) ENABLED START */
		int count = 0;
		String[] content = s.split(NEWLINE);
		for (String part : content) {
			if (part.trim().equals("")) {
				count++;
			}
		}
		return count;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	s	
	 * @return	
	 */
	public static Integer getProgramLineCount(Script s) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337514671094_916887_2543) ENABLED START */
		return getLineCount(s.getContent()) - getCommentLineCount(s) - getBlankLineCount(s.getContent());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	s	
	 * @return	
	 */
	public static Integer getProgramLength(String s) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337514923706_595892_2555) ENABLED START */
		return countOperators(s) + countOperands(s);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	e	
	 * @return	
	 */
	public static Integer getProgramLineCount(Executable e) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337514720952_606124_2547) ENABLED START */
		return getLineCount(e.getCodeBody()) - getCommentLineCount(e) - getBlankLineCount(e.getCodeBody());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	s	
	 * @return	
	 */
	public static Integer getVocabularySize(String s) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337514965888_52518_2559) ENABLED START */
		return countFirstOperators(s) + countFirstOperands(s);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	s	
	 * @return	
	 */
	public static Integer getCyclomaticComplexity(String s) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337514841478_78129_2551) ENABLED START */
		int count = 0;
		String[] req = {
		"if", "for", "while"/*, "\\?.*?:"*/
		}; // ternary operator
		for (String r : req) {
			count = count + countCharSequence(s, r);
		}
		return count;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	s	
	 * @return	
	 */
	public static double getProgramVolume(String s) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337515021877_387493_2564) ENABLED START */
		double progLen = getProgramLength(s);
		double vocSize = getVocabularySize(s);
		if (progLen > 0 && vocSize > 0)
			return progLen * (Math.log(vocSize) / Math.log(2.0));
		else
			return 0.0;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	s	
	 * @return	
	 */
	public static double getDifficultyLvl(String s) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337515066976_191783_2568) ENABLED START */
		double firstOperands = countFirstOperands(s);
		double operands = countOperands(s);
		double firstOperators = countFirstOperators(s);
		
		if (firstOperands > 0)
			return (firstOperators / 2) * (operands / firstOperands);
		else
			return 0.0;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	s	
	 * @return	
	 */
	public static double getProgramNiveau(String s) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337515112248_259156_2572) ENABLED START */
		double difLvl = getDifficultyLvl(s);
		if (difLvl > 0)
			return 1 / getDifficultyLvl(s);
		else
			return 0.0;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	s	
	 * @return	
	 */
	public static double getEffortToImplement(String s) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337515156755_895080_2576) ENABLED START */
		return getDifficultyLvl(s) * getProgramVolume(s);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	s	
	 * @return	
	 */
	public static double getTimeToImplement(String s) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337515210762_967475_2580) ENABLED START */
		return getEffortToImplement(s) / 18;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	s	
	 * @return	
	 */
	public static double getBugCount(String s) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337515247250_787022_2584) ENABLED START */
		double n = 0.666666;
		return Math.pow(getEffortToImplement(s), n) / 3000;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	s	
	 * @return	
	 */
	public static Integer countOperators(String s) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337515289948_859098_2588) ENABLED START */
		int count = 0;
		for (String op : OPERATORS) {
			count = count + countCharSequence(s, op);
		}
		return count;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	s	
	 * @return	
	 */
	public static Integer countOperands(String s) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337515335905_762731_2592) ENABLED START */
		int count = 0;
		for (String op : OPERANDS) {
			count = count + countCharSequence(s, op);
		}
		return count;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	s	
	 * @return	
	 */
	public static Integer countFirstOperators(String s) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337515389913_87732_2596) ENABLED START */
		int count = 0;
		for (String op : OPERATORS) {
			if (findCharSequence(s, op)) {
				count++;
			}
		}
		return count;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	s	
	 * @return	
	 */
	public static Integer countFirstOperands(String s) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337563555178_634805_10071) ENABLED START */
		int count = 0;
		for (String op : OPERANDS) {
			if (findCharSequence(s, op)) {
				count++;
			}
		}
		return count;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	original	
	 * @param	table	
	 * @return	
	 */
	public static double getAverage(double original, SymbolTable table) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337515443717_718907_2600) ENABLED START */
		int count = 0;
		for (ScriptPackage pack : table.getPackages()) {
			count += pack.getScripts().size();
		}
		return original / count;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	content	
	 * @param	searched	
	 * @return	
	 */
	public static Integer countCharSequence(String content, String searched) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337515541826_72850_2605) ENABLED START */
		int count = 0;
		Pattern p = Pattern.compile("(?i)" + "\\s*" + Pattern.quote(searched) + "\\s*");
		Matcher m = p.matcher(content);
		while (m.find()) {
			count++;
		}
		return count;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	content	
	 * @param	searched	
	 * @return	
	 */
	public static boolean findCharSequence(String content, String searched) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337515597050_253897_2610) ENABLED START */
		Pattern p = Pattern.compile("(?i)" + "\\s*" + Pattern.quote(searched) + "\\s*");
		Matcher m = p.matcher(content);
		if (m.find()) {
			return true;
		}
		return false;
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337514226112_11017_2508) ENABLED START */
	public static final String[] OPERATORS = {
	"-", "!", "!=", "%=", "%", "&", "&&", "||", "|=", "=|", "|", "&=", "=", "*", "*=", "+", "++", "+=", "=+", ",", "-", "--", "-=", "=-", "-<", "->", "<", "<<", "<<=", "=<<", ">", ">>", ">>=", "=>>", "?", ":", "^", "^=", "=^", "/", "/=", "=/", "%", ";", "»", "«"
	};
	
	public static final String[] OPERANDS = {
	"«DEFINE", "«EXPAND", "«FOR", "«FOREACH", "«IF", "«ELSE", "«WHILE", "static", "let"
	};
	
	public static final String NEWLINE = "\r\n|\r|\n";
	/* PROTECTED REGION END */

}
