package org.genesez.platform.documentation.docbook;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Provides formatting conversions.
 * 
 * @author tobias haubold <toh@fh-zwickau.de>
 * @date 2011-02-27
 */
public class Conversion {

	private interface Replaceable {
		public Pattern getPattern();
		public String getReplacement(Matcher m);
	}
	
	/**
	 * Regular expression which matches links encoded as [<url> <text>].
	 * Escaping is only implemented for starting, i.e. \[<url> <text>] does not match.
	 * Therefor it assumes for simplicity that the <url> or <text> does not contain [ or ].
	 */
	private static Pattern LINKS = Pattern.compile("(?<!\\\\)\\[(\\S+)\\s+(.+?)\\]");
	
	private static Replaceable links = new Replaceable() {
		
		public String getReplacement(Matcher m) {
			String link = m.group(1);
			String text = m.group(2);
			if (link.startsWith("http")) {
				return "<ulink url=\"" + link + "\">" + text + "</ulink>";
			} else {
				return "<link linkend=\"" + link + "\">" + text + "</link>";
			}
		}
		
		public Pattern getPattern() {
			return Pattern.compile("(?<!\\\\)\\[(\\S+)\\s+(.+?)\\]");
		}
	};
	
	/**
	 * Regular expression which matches source formatting encoded as |<text>|.
	 * Escaping is implemented for starting and within the <text>, i.e. \| should not match and
	 * |<text> \|| should match.
	 */
	private static Pattern FORMAT_AS_SOURCE_CODE = Pattern.compile("(?<!\\\\)\\|(.+?)(?<!\\\\)\\|");
	
	private static Replaceable sourceCode = new Replaceable() {
		
		public String getReplacement(Matcher m) {
			return "<literal>" + m.group(1) + "</literal>";
		}
		
		public Pattern getPattern() {
			return Pattern.compile("(?<!\\\\)\\|(.+?)(?<!\\\\)\\|");
		}
	};
	
	private static Pattern FORMAT_AS_BOLD = Pattern.compile("(?<!\\\\)\\*(.+?)(?<!\\\\)\\*");
	
	private static Replaceable bold = new Replaceable() {
		
		public String getReplacement(Matcher m) {
			return "<emphasis role=\"bold\">" + m.group(1) + "</emphasis>";
		}
		
		public Pattern getPattern() {
			return Pattern.compile("(?<!\\\\)\\*(.+?)(?<!\\\\)\\*");
		}
	};
	
	private static Pattern FORMAT_AS_ITALIC = Pattern.compile("(?<!\\\\)_(.+?)(?<!\\\\)_");
	
	private static Replaceable italic = new Replaceable() {
		
		public String getReplacement(Matcher m) {
			return "<emphasis>" + m.group(1) + "</emphasis>";
		}
		
		public Pattern getPattern() {
			return Pattern.compile("(?<!\\\\)_(.+?)(?<!\\\\)_");
		}
	};
	
	
	/**
	 * Processes simple text formatting for docbook. Currently it supports:
	 * - html links (<ulink>) and links (<link>)
	 * - source code formatting with <literal>
	 * 
	 * @param comment
	 * @return
	 */
	public static String format(String comment) {
//		return processFormatting( processLinks(comment) );
		// plain text formatting
		String s = process(process(process(process(comment, links), sourceCode), italic), bold);
		// html formatting
		// throw <p> and </p> away
		s = s.replaceAll("</?p>", "");
		s = s.replaceAll("<i>(.+?)</i>", "<emphasis>$1</emphasis>");
		s = s.replaceAll("<b>(.+?)</b>", "<emphasis role=\"bold\">$1</emphasis>");
		return s;
	}
	
	public static String process(String input, String regexp, String replacement) {
		return null;
	}
	
	public static String process(String input, Replaceable replaceable) {
		StringBuilder result = new StringBuilder(input);
		Matcher m = replaceable.getPattern().matcher(input);
		int offset = 0;
		while (m.find()) {
			String tag = replaceable.getReplacement(m);
			result.replace(offset + m.start(), offset + m.end(), tag);
			offset += tag.length() - m.end() + m.start();
		}
		return result.toString();
	}
	
	// -- old stuff
	
	public static String processFormatting(String comment) {
		StringBuilder result = new StringBuilder(comment);
		Matcher m = FORMAT_AS_SOURCE_CODE.matcher(comment);
		int offset = 0;
		while (m.find()) {
			String tag = "<literal>" + m.group(1) + "</literal>";
			result.replace(offset + m.start(), offset + m.end(), tag);
			offset += tag.length() - m.end() + m.start();
		}
		return result.toString();
	}
	
	public static String processLinks(String comment) {
		StringBuilder result = new StringBuilder(comment);
		Matcher m = LINKS.matcher(comment);
		int offset = 0;
		while (m.find()) {
			String link = buildLink(m.group(1), m.group(2));
			result.replace(offset + m.start(), offset + m.end(), link);
			offset += link.length() - m.end() + m.start();
		}
		return result.toString();
	}
	
	public static String buildLink(String link, String text) {
		if (link.startsWith("http")) {
			return "<ulink url=\"" + link + "\">" + text + "</ulink>";
		} else {
			return "<link linkend=\"" + link + "\">" + text + "</link>";
		}
	}
}
