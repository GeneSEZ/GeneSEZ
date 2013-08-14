
package org.genesez.util.comment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Provides utilitiy methods to process text and html comments.
 * 
 * @author tobias haubold <toh@fh-zwickau.de>
 */
public class CommentProcessing {
	
	private static Log logger = LogFactory.getLog(CommentProcessing.class);
	
	/**
	 * Extracts the comment text of a comment annotation. If it's an HTML comment, the body content is returned.
	 * 
	 * @param	annotation	the annotation of a comment
	 * @return	the content of the annotation
	 */
	public static String commentText(String annotation) {
		// matches the entire '<html>...</html>' stuff
		Pattern p = Pattern.compile("<html>((\\s|\\w|.)+)</html>\\s*");
		Matcher m = p.matcher(annotation);
		if (m.matches()) {
			// html comment found
			// match the body content, non-capturing '<body>' start, non-capturing '</body>' end
			Pattern cp = Pattern.compile("(?<=<body>)((\\s|\\w|.)+)(?=</body>)");
			Matcher cm = cp.matcher(annotation);
			if (cm.find()) {
				// body content found, it's on capturing group 1
				String content = cm.group(1);
				// try to determine the trailing whitespace (but without beginning newlines)
				Pattern wsp = Pattern.compile("(?<=\\n*+)(\\s+)");
				Matcher wsm = wsp.matcher(content);
				if (wsm.find()) {
					// trailing whitespace found, try to remove them from all lines
					String prefix = wsm.group(1);
					StringBuffer result = new StringBuffer();
					for (String line : content.trim().split("\n")) {
						if (line.startsWith(prefix)) {
							result.append(line.substring(prefix.length()) + "\n");
						} else {
							result.append(line + "\n");
						}
					}
					return result.toString();
				}
				return content;
			} else {
				// it seams to be an HTML comment, but there is no body ???
				logger.fatal("can't get content of html comment!");
			}
		}
		// default return, no HTML comment
		return annotation;
	}
	
	/**
	 * Formats a string by adding a prefix + suffix to each line of the string.
	 * 
	 * @param	s	the string to format
	 * @param	linePrefix	the prefix prepended to each line
	 * @param	lineSuffix	the suffix appended to each line
	 * @return	the formatted string
	 */
	public static String formatComment(String s, String linePrefix, String lineSuffix) {
		StringBuffer result = new StringBuffer();
		for (String line : s.split("\n")) {
			result.append(linePrefix + line + lineSuffix);
		}
		return result.toString();
	}
}
