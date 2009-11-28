package de.genesez.platforms.common;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.genesez.metamodel.gcore.MComment;
import de.genesez.metamodel.gcore.MElement;
import de.genesez.metamodel.gcore.MModel;
import de.genesez.metamodel.gcore.MPackage;
import de.genesez.platforms.common.log.GenesezLogger;

/**
 * Utility class for Conversion of model informations
 * 
 * @author	nico herbig
 * @author	georg beier
 * @author	tobias haubold (last)
 * @date	2008-04-18
 */
public class Conversion {
	
	/**
	 * getter for the full qualified name of a package
	 * @param	pkg			a package
	 * @param	separator	a separator used for the full qualified name
	 * @return	the full qualified name of the package
	 */
	public static String getFullQualifiedName(MPackage pkg, String separator) {
		StringBuffer fqn = new StringBuffer();
		MPackage p = pkg;
		while (!(p instanceof MModel)) {
			fqn.insert(0, p.getName());
			p = p.getNestingPackage();
			if (!(p instanceof MModel)) {
				fqn.insert(0, separator);
			}
		}
		return fqn.toString();
	}

	/**
	 * builds the comment text of an element
	 * @param	comments				a list of comments to process (usually associated with an element)
	 * @param	commentSeparator		string which is used as separator between the comments
	 * @param	nestedCommentSeparator	string which is used as separator between a comment and it's nested comment
	 * @return	the comment string
	 */
	public static String comment(MElement elem, String commentSeparator, String nestedCommentSeparator) {
		List<MComment> comments = elem.getOwnedComment();
		return comment(comments, commentSeparator, nestedCommentSeparator);
	}

	/**
	 * builds the comment text from a list of comments
	 * @param	comments				a list of comments to process (usually associated with an element)
	 * @param	commentSeparator		string which is used as separator between the comments
	 * @param	nestedCommentSeparator	string which is used as separator between a comment and it's nested comment
	 * @return	the comment string
	 */
	private static String comment(List<MComment> comments, String commentSeparator, String nestedCommentSeparator) {
		StringBuffer result = new StringBuffer();
		for (MComment c : comments) {
			// obtain annotation and only append if it's not null to avoid a NullPointerException
			String annotation = c.getAnnotation();
			if (annotation != null) {
				result.append( commentText(annotation) );
			}
			// check for nested comments and append them
			if ( !c.getNestedComment().isEmpty() ) {
				result.append( nestedCommentSeparator );
				result.append( comment(c.getNestedComment(), commentSeparator, nestedCommentSeparator) );
			}
			// check if's the last comment in list
			if (c != comments.get(comments.size() -1)) {
				result.append( commentSeparator );
			}
		}
		return result.toString();
	}
	
	/**
	 * extracts the comment text of a comment annotation
	 * if it's an HTML comment, the body content is returned
	 * @param	annotation	the annotation of a comment
	 * @return	the content of the annotation
	 */
	private static String commentText(String annotation) {
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
							result.append( line.substring(prefix.length()) + "\n" );
						} else {
							result.append( line + "\n");
						}
					}
					return result.toString();
				}
				return content;
			} else {
				// it seams to be an HTML comment, but there is no body ???
				GenesezLogger.fatal("can't get content of html comment!");
			}
		}
		// default return, no HTML comment
		return annotation;
	}
	
	/**
	 * formats a string by adding a prefix + suffix to each line of the string
	 * @param	s			the string to format
	 * @param	linePrefix	the prefix prepended to each line
	 * @param	lineSuffix	the suffix appended to each line
	 * @return	the formatted string
	 */
	public static String format(String s, String linePrefix, String lineSuffix) {
		StringBuffer result = new StringBuffer();
		for (String line : s.split("\n")) {
			result.append(linePrefix + line + lineSuffix);
		}
		// don't use tokenizer here - it doesn't return empty tokens (e.g. between '\n\n')
//		StringTokenizer tokenizer = new StringTokenizer(comment, "\r\n");
//		while (tokenizer.hasMoreTokens()) {
//			String token = tokenizer.nextToken();
//			result.append(linePrefix + token + lineSuffix);
//		}
		return result.toString();
	}
}
