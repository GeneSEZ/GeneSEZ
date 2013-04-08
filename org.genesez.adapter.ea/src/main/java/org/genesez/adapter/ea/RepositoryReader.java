package org.genesez.adapter.ea;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_12d203c6_1328866954886_446698_2086) 
 */

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.sparx.Collection;
import org.sparx.Package;
import org.sparx.Repository;

/**
 * An oAW workflow component to read a model from an Enterprise Architect repository
 * 
 * The RepositoryReader fetches an Enterprise Architect model by its name
 * from a repository and set the model to the output slot.
 * 
 * @author gerbe
 * @author christian
 */

public class RepositoryReader extends AbstractWorkflowComponent {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(RepositoryReader.class);
	
	private static Repository repository = null;
	
	private String repositoryFile = null;
	
	private String modelName = null;
	
	private String outputSlot = null;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	i	
	 */
	
	public void checkConfiguration(Issues i) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363096603380_494420_2122) ENABLED START */
		// :)
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	ctx	
	 * @param	pm	
	 * @param	issues	
	 */
	
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor pm, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363355541021_453032_2540) ENABLED START */
		try {
			Package model = this.readModel();
			ctx.set(outputSlot, model);
		} catch (FileNotFoundException e) {
			issues.addError(e.toString());
		} catch (Exception e) {
			issues.addError(e.toString());
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Reads the repository and extracts the model to transform
	 * @return	
	 * @throws	Exception
	 * @throws	FileNotFoundException
	 */
	
	private org.sparx.Package readModel() throws Exception, FileNotFoundException {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363355721609_465892_2794) ENABLED START */
		File file = new File(this.repositoryFile);
		if (!file.exists()) {
			throw new FileNotFoundException("File not found: " + this.repositoryFile);
		}
		
		LOG.info("Reading Model: " + this.repositoryFile);
		
		// new repository
		repository = new Repository();
		if (!repository.OpenFile(file.getAbsolutePath())) {
			throw new Exception("Cannot read Enterprise Architect repository: " + file.getAbsolutePath());
		}
		
		Collection<Package> pkgs = repository.GetModels();
		
		LOG.info("Repository " + this.repositoryFile + " contains " + pkgs.GetCount() + " models");
		
		Package model = null;
		
		for (Package m : pkgs) {
			LOG.info("Found model: " + m.GetName());
			if (m.GetName().equals(this.modelName)) {
				model = m;
				break;
			}
		}
		
		if (model == null) {
			throw new Exception("Model " + this.modelName + " not found in repository");
		}
		
		return model;
		/* PROTECTED REGION END */
	}
	
	/**
	 * closes the repository
	 */
	
	public static void closeRepository() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363356134923_625218_2804) ENABLED START */
		if (repository != null) {
			repository.CloseFile();
			repository.Exit();
		}
		LOG.info("repository has been closed successfully");
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Sets the value of attribute '<em><b>repositoryFile</b></em>'
	 */
	public void setRepositoryFile(String repositoryFile) {
		this.repositoryFile = repositoryFile;
	}
	
	/**
	 * Sets the value of attribute '<em><b>modelName</b></em>'
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	/**
	 * Sets the value of attribute '<em><b>outputSlot</b></em>'
	 */
	public void setOutputSlot(String outputSlot) {
		this.outputSlot = outputSlot;
	}
	
	/**
	 * Returns the value of attribute '<em><b>repository</b></em>'
	 */
	public static Repository getRepository() {
		return repository;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_12d203c6_1328866954886_446698_2086) ENABLED START */
	
	/* PROTECTED REGION END */
	
}
