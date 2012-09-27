package org.genesez.platform.common;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324547014257_541733_2294) 
 */

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.genesez.metamodel.gcore.MModel;
import java.util.regex.Matcher;
import org.genesez.metamodel.gcore.MPackage;
import java.util.regex.Pattern;
import org.genesez.metamodel.gcore.MComment;
import org.genesez.metamodel.gcore.MElement;

/**
 * Utility class for Conversion of model informations
 * 
 * @author	nico herbig
 * @author	georg beier
 * @author	tobias haubold (last)
 * @date	2008-04-18
 */
public class Conversion {
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * getter for the full qualified name of a package
	 * @param	pkg	a package
	 * @param	separator	a separator used for the full qualified name
	 * @return	the full qualified name of the package
	 */
	public static String getFullQualifiedName(MPackage pkg, String separator) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324547062596_652786_2326) ENABLED START */
		StringBuffer fqn = new StringBuffer();
		MPackage p = pkg;
		while (!(p instanceof MModel) && p != null) {
			fqn.insert(0, p.getName());
			p = p.getNestingPackage();
			if (!(p instanceof MModel) && p != null) {
				fqn.insert(0, separator);
			}
		}
		return fqn.toString();
		/* PROTECTED REGION END */
	}
	
	/**
	 * builds the comment text of an element
	 * @param	elem	An element that holds the comments
	 * @param	commentSeparator	string which is used as separator between the comments
	 * @param	nestedCommentsSeparator	string which is used as separator between a comment and it's nested comment
	 * @return	the comment string
	 */
	public static String comment(MElement elem, String commentSeparator, String nestedCommentsSeparator) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324547157084_946788_2349) ENABLED START */
		List<MComment> comments = elem.getOwnedComment();
		return comment(comments, commentSeparator, nestedCommentsSeparator);
		/* PROTECTED REGION END */
	}
	
	/**
	 * builds the comment text from a list of comments
	 * @param	comments	a list of comments to process (usually associated with an element)
	 * @param	commentSeparator	string which is used as separator between the comments
	 * @param	nestedCommentSeparator	string which is used as separator between a comment and it's nested comment
	 * @return	the comment string
	 */
	private static String comment(java.util.List<MComment> comments, String commentSeparator, String nestedCommentSeparator) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324547604850_712262_2369) ENABLED START */
		StringBuffer result = new StringBuffer();
		for (MComment c : comments) {
			// obtain annotation and only append if it's not null to avoid a NullPointerException
			String annotation = c.getAnnotation();
			if (annotation != null) {
				result.append(commentText(annotation));
			}
			// check for nested comments and append them
			if (!c.getNestedComment().isEmpty()) {
				result.append(nestedCommentSeparator);
				result.append(comment(c.getNestedComment(), commentSeparator, nestedCommentSeparator));
			}
			// check if's the last comment in list
			if (c != comments.get(comments.size() - 1)) {
				result.append(commentSeparator);
			}
		}
		return result.toString();
		/* PROTECTED REGION END */
	}
	
	/**
	 * extracts the comment text of a comment annotation if it's an HTML comment, the body content is returned
	 * @param	annotation	the annotation of a comment
	 * @return	the content of the annotation
	 */
	private static String commentText(String annotation) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324547753427_37431_2387) ENABLED START */
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
		/* PROTECTED REGION END */
	}
	
	/**
	 * formats a string by adding a prefix + suffix to each line of the string
	 * @param	s	the string to format
	 * @param	linePrefix	the prefix prepended to each line
	 * @param	lineSuffix	the suffix appended to each line
	 * @return	the formatted string
	 */
	public static String format(String s, String linePrefix, String lineSuffix) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324548134778_86167_2394) ENABLED START */
		StringBuffer result = new StringBuffer();
		for (String line : s.split("\n")) {
			result.append(linePrefix + line + lineSuffix);
		}
		return result.toString();
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324547014257_541733_2294) ENABLED START */
	private static Log logger = LogFactory.getLog(Conversion.class);
	/* PROTECTED REGION END */
	
}
