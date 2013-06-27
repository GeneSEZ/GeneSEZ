package de.genesez.platforms.common.statistic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Zeilenparser die die Art der Codezeile ueberprueft
 * 
 * @author T. Hartmann ( tomha@fh-zwickau.de )
 */
public class LineParser implements IParser {

	/** singeltonobjekt */
	private static LineParser reader;

	/**
	 * Singelton
	 * 
	 * @return das singelton(LineParser)-Objekt
	 */
	public static LineParser getReader() {
		if (reader == null) {
			reader = new LineParser();
		}
		return reader;
	}

	/**
	 * parst eine Codezeile und prueft ob die zeile Code,Leerezeile oder eine
	 * geschuetzte Region ist.
	 * 
	 * @param s
	 *            Zeile die untersucht wird
	 * @return int Wert der die Art der Codezeile identifiziert bzw kodiert
	 */
	public int parseLine(String s) {
		return parseLine(s, new CommentSign().getSignsAsArray());
	}

	/**
	 * parst eine Codezeile und prueft ob die zeile Code,Leerezeile oder eine
	 * geschuetzte Region ist.
	 * 
	 * @param s
	 *            Zeile die untersucht wird
	 * @param comSigns
	 *            Array mit den Kommentarzeichen der Programmiersprache
	 * @return int Wert der die Art der Codezeile identifiziert bzw kodiert
	 */
	public int parseLine(String s, String[] comSigns) {
		// regex ParserObjekte
		Pattern pattern;
		Matcher matcher;

		// Protected Regions Anfang?
		pattern = Pattern.compile("(PROTECTED REGION).*(START)");
		matcher = pattern.matcher(s);
		if (matcher.find())
			return protRegStart;

		// Protected Regions Ende?
		pattern = Pattern.compile("(PROTECTED REGION).*(END)");
		matcher = pattern.matcher(s);
		if (matcher.find())
			return protRegEnd;

		// Dokumentation
		pattern = Pattern.compile("^[\\p{Blank}]*(" + "/\\*\\*" + ")");
		matcher = pattern.matcher(s);
		if (matcher.find())
			return docu;

		// Kommenatare
		pattern = Pattern.compile("^[\\p{Blank}]*[(" + comSigns[0] + ")]");
		matcher = pattern.matcher(s);
		if (matcher.find())
			return comment;

		pattern = Pattern.compile("^[\\p{Blank}]*(" + comSigns[1] + ")");
		matcher = pattern.matcher(s);
		if (matcher.find())
			return comment;

		// Mehrzeilenkommentar Ende
		pattern = Pattern.compile("^[\\p{Blank}]*(" + comSigns[2] + ")");
		matcher = pattern.matcher(s);
		if (matcher.find())
			return commentEnd;

		pattern = Pattern.compile("^[\\p{Blank}]*(" + comSigns[3] + ")");
		matcher = pattern.matcher(s);
		if (matcher.find())
			return comment;

		// leere zeilen auslassen
		pattern = Pattern.compile("[ \t]*");
		matcher = pattern.matcher(s);
		if (matcher.matches())
			return space;

		return code;
	}
	
}
