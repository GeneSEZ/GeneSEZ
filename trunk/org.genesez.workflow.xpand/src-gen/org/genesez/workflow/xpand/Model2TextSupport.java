package org.genesez.workflow.xpand;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_T90ZMAWHEeKiOsNmFSLL5Q) 
 */
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.genesez.m2t.FileTreeObserver;
import org.genesez.m2t.FileTreeWalker;
import org.genesez.m2t.cp.ImportPreserver;
import org.genesez.m2t.cp.xpand.XPandLineContentPreserving;
import org.genesez.m2t.deletion.FileDeletion;
import org.genesez.m2t.deletion.FolderDeletion;
import org.genesez.m2t.deletion.RevisionControlSystemFinder;
import org.genesez.workflow.CompositeComponent;
import org.genesez.workflow.WorkflowComponent;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Model2TextSupport<T extends Model2TextComponent> extends CompositeComponent<T> {
	
	public final Log logger = LogFactory.getLog(getClass());
	
	private FileTreeWalker preFileTreeWalker;
	
	private FileTreeWalker postFileTreeWalker;
	
	private RevisionControlSystemFinder revisionControlSystemFinder;
	
	private FileDeletion fileDeletion;
	
	private FolderDeletion folderDeletion;
	
	private XPandLineContentPreserving contentPreserve;
	
	private ImportPreserver importPreserver;
	
	/**
	 * Invokes the execution of the component.
	 * @param	context	The context of workflow execution.
	 * @param	monitor	Instance to report any activity to.
	 * @param	issues	Instance to collect all problems during execution.
	 */
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._ylbdEAXGEeKdMrzRF_vTbg) ENABLED START */
		preFileTreeWalker.walkFileTree();
		super.invokeInternal(context, monitor, issues);
		fileDeletion.delete();
		postFileTreeWalker.walkFileTree();
		folderDeletion.delete();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._wstA4AXGEeKdMrzRF_vTbg) ENABLED START */
		// the default output directory from the first model2text component
		String defaultOutputDir = null;
		if (!getComponent().isEmpty()) {
			WorkflowComponent wc = getComponent().iterator().next();
			if (wc instanceof Model2TextComponent) {
				Model2TextComponent m2t = (Model2TextComponent) getComponent().iterator().next();
				defaultOutputDir = m2t.getOutputDir();
				
				// create import preserver if config available
				if (m2t.getImportPreserverConfig() != null && importPreserver == null) {
					importPreserver = new ImportPreserver();
					importPreserver.setConfig(m2t.getImportPreserverConfig());
				}
			} else {
				issues.addError(this, "The 'component' must be of type 'Model2TextComponent'", wc);
			}
		}
		
		// check configuration
		if (fileDeletion == null) {
			if (logger.isDebugEnabled()) {
				logger.debug("Use default file deletion configuration.");
			}
			fileDeletion = new FileDeletion();
		}
		if (folderDeletion == null) {
			if (logger.isDebugEnabled()) {
				logger.debug("Use default folder deletion configuration.");
			}
			folderDeletion = new FolderDeletion();
		}
		if (revisionControlSystemFinder == null) {
			if (logger.isDebugEnabled()) {
				logger.debug("Use default revision control system finder.");
			}
			revisionControlSystemFinder = new RevisionControlSystemFinder();
			revisionControlSystemFinder.setBaseDir(defaultOutputDir);
		}
		if (contentPreserve == null && importPreserver != null) {
			if (logger.isDebugEnabled()) {
				logger.debug("Use default content preserve.");
			}
			contentPreserve = new XPandLineContentPreserving();
			contentPreserve.preservable().insert(importPreserver);
		}
		if (preFileTreeWalker == null) {
			if (logger.isDebugEnabled()) {
				logger.debug("Use default pre file tree walker configuration.");
			}
			preFileTreeWalker = new FileTreeWalker();
			preFileTreeWalker.setBaseDir(defaultOutputDir);
			preFileTreeWalker.addObserver(revisionControlSystemFinder);
			preFileTreeWalker.addObserver(fileDeletion);
			if (contentPreserve != null)
				preFileTreeWalker.addObserver(contentPreserve);
		} else {
			Set<FileTreeObserver> obs = preFileTreeWalker.getObserver();
			if (!obs.contains(revisionControlSystemFinder))
				obs.add(revisionControlSystemFinder);
			if (!obs.contains(folderDeletion))
				obs.add(folderDeletion);
			if (contentPreserve != null && !obs.contains(contentPreserve))
				obs.add(contentPreserve);
		}
		if (postFileTreeWalker == null) {
			if (logger.isDebugEnabled()) {
				logger.debug("Use default post file tree walker configuration.");
			}
			postFileTreeWalker = new FileTreeWalker();
			postFileTreeWalker.setBaseDir(defaultOutputDir);
			postFileTreeWalker.addObserver(folderDeletion);
		} else {
			Set<FileTreeObserver> obs = postFileTreeWalker.getObserver();
			if (!obs.contains(folderDeletion))
				obs.add(folderDeletion);
		}
		
		// add import preserver as post processor
		if (contentPreserve != null) {
			for (WorkflowComponent wc : getComponent()) {
				if (wc instanceof Model2TextComponent) {
					Model2TextComponent m2t = (Model2TextComponent) wc;
					m2t.addPostProcessor(contentPreserve);
				}
			}
		}
		
		super.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>preFileTreeWalker</b></em>'.
	 */
	public FileTreeWalker getPreFileTreeWalker() {
		return this.preFileTreeWalker;
	}
	
	/**
	 * Sets the value of attribute '<em><b>preFileTreeWalker</b></em>'.
	 * @param	preFileTreeWalker	the value to set.
	 */
	public void setPreFileTreeWalker(FileTreeWalker preFileTreeWalker) {
		this.preFileTreeWalker = preFileTreeWalker;
	}
	
	/**
	 * Returns the value of attribute '<em><b>postFileTreeWalker</b></em>'.
	 */
	public FileTreeWalker getPostFileTreeWalker() {
		return this.postFileTreeWalker;
	}
	
	/**
	 * Sets the value of attribute '<em><b>postFileTreeWalker</b></em>'.
	 * @param	postFileTreeWalker	the value to set.
	 */
	public void setPostFileTreeWalker(FileTreeWalker postFileTreeWalker) {
		this.postFileTreeWalker = postFileTreeWalker;
	}
	
	/**
	 * Returns the value of attribute '<em><b>revisionControlSystemFinder</b></em>'.
	 */
	public RevisionControlSystemFinder getRevisionControlSystemFinder() {
		return this.revisionControlSystemFinder;
	}
	
	/**
	 * Sets the value of attribute '<em><b>revisionControlSystemFinder</b></em>'.
	 * @param	revisionControlSystemFinder	the value to set.
	 */
	public void setRevisionControlSystemFinder(RevisionControlSystemFinder revisionControlSystemFinder) {
		this.revisionControlSystemFinder = revisionControlSystemFinder;
	}
	
	/**
	 * Returns the value of attribute '<em><b>fileDeletion</b></em>'.
	 */
	public FileDeletion getFileDeletion() {
		return this.fileDeletion;
	}
	
	/**
	 * Sets the value of attribute '<em><b>fileDeletion</b></em>'.
	 * @param	fileDeletion	the value to set.
	 */
	public void setFileDeletion(FileDeletion fileDeletion) {
		this.fileDeletion = fileDeletion;
	}
	
	/**
	 * Returns the value of attribute '<em><b>folderDeletion</b></em>'.
	 */
	public FolderDeletion getFolderDeletion() {
		return this.folderDeletion;
	}
	
	/**
	 * Sets the value of attribute '<em><b>folderDeletion</b></em>'.
	 * @param	folderDeletion	the value to set.
	 */
	public void setFolderDeletion(FolderDeletion folderDeletion) {
		this.folderDeletion = folderDeletion;
	}
	
	/**
	 * Returns the value of attribute '<em><b>contentPreserve</b></em>'.
	 */
	public XPandLineContentPreserving getContentPreserve() {
		return this.contentPreserve;
	}
	
	/**
	 * Sets the value of attribute '<em><b>contentPreserve</b></em>'.
	 * @param	contentPreserve	the value to set.
	 */
	public void setContentPreserve(XPandLineContentPreserving contentPreserve) {
		this.contentPreserve = contentPreserve;
	}
	
	/**
	 * Returns the value of attribute '<em><b>importPreserver</b></em>'.
	 */
	public ImportPreserver getImportPreserver() {
		return this.importPreserver;
	}
	
	/**
	 * Sets the value of attribute '<em><b>importPreserver</b></em>'.
	 * @param	importPreserver	the value to set.
	 */
	public void setImportPreserver(ImportPreserver importPreserver) {
		this.importPreserver = importPreserver;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._T90ZMAWHEeKiOsNmFSLL5Q) ENABLED START */
	/* PROTECTED REGION END */
}
