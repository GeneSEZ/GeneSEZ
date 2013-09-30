package org.genesez.workflow.xpand;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_kHHrACmuEeOSCvB50Wk7Pw) 
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.internal.xpand2.pr.ProtectedRegion;
import org.eclipse.internal.xpand2.pr.ProtectedRegionSyntaxException;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xpand2.Generator;

/**
 * Provides access to XPand generator internals especially the protected regions.
 */
public class XpandGenerator extends Generator {
	
	private static XpandGenerator current;
	
	/**
	 * Invokes the execution of the component.
	 * @param	context	The context of workflow execution.
	 * @param	monitor	Instance to report any activity to.
	 * @param	issues	Instance to collect all problems during execution.
	 */
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._p5hckCmwEeOSCvB50Wk7Pw) ENABLED START */
		current = this;
		super.invokeInternal(context, monitor, issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public static ProtectedRegion getProtectedRegion(String id) {
		/* PROTECTED REGION ID(java.implementation._7lonECmyEeOSCvB50Wk7Pw) ENABLED START */
		if (current == null) {
			throw new IllegalStateException("There is no currently no Generator component running!");
		}
		return current.getProtectedRegionResolver().getProtectedRegion(id);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the protected content of the given protected region id with the given start and end comment.
	 * @throws	ProtectedRegionSyntaxException
	 */
	public static String getProtecedContent(String id, String startComment, String endComment) throws ProtectedRegionSyntaxException {
		/* PROTECTED REGION ID(java.implementation._QlJt8CmzEeOSCvB50Wk7Pw) ENABLED START */
		return getProtectedRegion(id).getBody(startComment, endComment);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the protected content with first and last line removed.
	 * In case these lines could not be removed the whole protected content is returned (the same as {@link #getProtectedContent(id, "", ""}).
	 * @see #getProtectedContent(String, String, String)
	 * @throws	ProtectedRegionSyntaxException
	 */
	public static String getProtecedContent(String id) throws ProtectedRegionSyntaxException {
		/* PROTECTED REGION ID(java.implementation._xB0_MCm0EeOSCvB50Wk7Pw) ENABLED START */
		String content = getProtecedContent(id, "", "");
		Pattern p = Pattern.compile("[\r\n]+");
		Matcher m = p.matcher(content);
		try {
			m.find();
			int start = m.end();
			int end = 0;
			while (m.find()) {
				end = m.start();
			}
			content = content.substring(start, end);
		} catch (Exception e) {
			//			e.printStackTrace();
		}
		return content;
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._kHHrACmuEeOSCvB50Wk7Pw) ENABLED START */
	/* PROTECTED REGION END */
}
