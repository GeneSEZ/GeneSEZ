package org.genesez.metamodel.core.util;

import java.util.List;

import org.genesez.metamodel.gcore.MComment;
import org.genesez.metamodel.gcore.MElement;

/**
 * Utility class for Conversion of model informations
 * 
 * @author	nico herbig
 * @author	tobias haubold (last)
 */
public class CommentProcessing {
	
	/**
	 * Builds the comment text of an element.
	 * 
	 * @param	elem	An element that holds the comments
	 * @param	commentSeparator	string which is used as separator between the comments
	 * @param	nestedCommentsSeparator	string which is used as separator between a comment and it's nested comment
	 * @return	the comment string
	 */
	public static String comment(MElement elem, String commentSeparator, String nestedCommentsSeparator) {
		List<MComment> comments = elem.getOwnedComment();
		return comment(comments, commentSeparator, nestedCommentsSeparator);
	}
	
	/**
	 * Builds the comment text from a list of comments.
	 * 
	 * @param	comments	a list of comments to process (usually associated with an element)
	 * @param	commentSeparator	string which is used as separator between the comments
	 * @param	nestedCommentSeparator	string which is used as separator between a comment and it's nested comment
	 * @return	the comment string
	 */
	private static String comment(java.util.List<MComment> comments, String commentSeparator, String nestedCommentSeparator) {
		StringBuffer result = new StringBuffer();
		for (MComment c : comments) {
			// obtain annotation and only append if it's not null to avoid a NullPointerException
			String annotation = c.getAnnotation();
			if (annotation != null) {
				result.append(org.genesez.util.conversion.CommentProcessing.commentText(annotation));
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
	}
	
}
