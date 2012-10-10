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

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author dreamer
 */
public class Model2TextComposite<T extends Model2Text> extends CompositeComponent<T> {
	
	// -- generated attribute, constant + association declarations ----------
	
	public final Log logger = LogFactory.getLog(getClass());
	
	private FileTreeWalker preFileTreeWalker;
	
	private FileTreeWalker postFileTreeWalker;
	
	private RevisionControlSystemFinder revisionControlSystemFinder;
	
	private FileDeletion fileDeletion;
	
	private FolderDeletion folderDeletion;
	
	private XPandLineContentPreserving contentPreserve;
	
	private ImportPreserver importPreserver;
	
	// -- generated method stubs for implementations + derived attributes ---
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
			Model2Text m2t = getComponent().iterator().next();
			defaultOutputDir = m2t.getOutputDir();
			
			// create import preserver if config available
			if (m2t.getImportPreserverConfig() != null && importPreserver == null) {
				importPreserver = new ImportPreserver();
				importPreserver.setConfig(m2t.getImportPreserverConfig());
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
			for (Model2Text m2t : getComponent()) {
				m2t.addPostProcessor(contentPreserve);
			}
		}
		
		super.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>preFileTreeWalker</b></em>'
	 */
	public FileTreeWalker getPreFileTreeWalker() {
		return preFileTreeWalker;
	}
	
	/**
	 * Sets the value of attribute '<em><b>preFileTreeWalker</b></em>'
	 */
	public void setPreFileTreeWalker(FileTreeWalker preFileTreeWalker) {
		this.preFileTreeWalker = preFileTreeWalker;
	}
	
	/**
	 * Returns the value of attribute '<em><b>postFileTreeWalker</b></em>'
	 */
	public FileTreeWalker getPostFileTreeWalker() {
		return postFileTreeWalker;
	}
	
	/**
	 * Sets the value of attribute '<em><b>postFileTreeWalker</b></em>'
	 */
	public void setPostFileTreeWalker(FileTreeWalker postFileTreeWalker) {
		this.postFileTreeWalker = postFileTreeWalker;
	}
	
	/**
	 * Returns the value of attribute '<em><b>revisionControlSystemFinder</b></em>'
	 */
	public RevisionControlSystemFinder getRevisionControlSystemFinder() {
		return revisionControlSystemFinder;
	}
	
	/**
	 * Sets the value of attribute '<em><b>revisionControlSystemFinder</b></em>'
	 */
	public void setRevisionControlSystemFinder(RevisionControlSystemFinder revisionControlSystemFinder) {
		this.revisionControlSystemFinder = revisionControlSystemFinder;
	}
	
	/**
	 * Returns the value of attribute '<em><b>fileDeletion</b></em>'
	 */
	public FileDeletion getFileDeletion() {
		return fileDeletion;
	}
	
	/**
	 * Sets the value of attribute '<em><b>fileDeletion</b></em>'
	 */
	public void setFileDeletion(FileDeletion fileDeletion) {
		this.fileDeletion = fileDeletion;
	}
	
	/**
	 * Returns the value of attribute '<em><b>folderDeletion</b></em>'
	 */
	public FolderDeletion getFolderDeletion() {
		return folderDeletion;
	}
	
	/**
	 * Sets the value of attribute '<em><b>folderDeletion</b></em>'
	 */
	public void setFolderDeletion(FolderDeletion folderDeletion) {
		this.folderDeletion = folderDeletion;
	}
	
	/**
	 * Returns the value of attribute '<em><b>contentPreserve</b></em>'
	 */
	public XPandLineContentPreserving getContentPreserve() {
		return contentPreserve;
	}
	
	/**
	 * Sets the value of attribute '<em><b>contentPreserve</b></em>'
	 */
	public void setContentPreserve(XPandLineContentPreserving contentPreserve) {
		this.contentPreserve = contentPreserve;
	}
	
	/**
	 * Returns the value of attribute '<em><b>importPreserver</b></em>'
	 */
	public ImportPreserver getImportPreserver() {
		return importPreserver;
	}
	
	/**
	 * Sets the value of attribute '<em><b>importPreserver</b></em>'
	 */
	public void setImportPreserver(ImportPreserver importPreserver) {
		this.importPreserver = importPreserver;
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._T90ZMAWHEeKiOsNmFSLL5Q) ENABLED START */
	/* PROTECTED REGION END */
	
}
