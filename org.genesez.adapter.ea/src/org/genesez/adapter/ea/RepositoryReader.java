package org.genesez.adapter.ea;

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
 * @author gerbe
 *
 * The RepositoryReader fetches an Enterprise Architect model by its name
 * from a repository and set the model to the output slot.
 */
public class RepositoryReader extends AbstractWorkflowComponent {

	private final static Log log = LogFactory.getLog(RepositoryReader.class);
	
	private String repositoryFile = null;
	private String modelName = null;
	private String outputSlot = null;
	
	public void checkConfiguration(Issues issues) {
		// nothing to do here
	}
	
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		try {
			Package model = this.readModel();
			ctx.set(outputSlot, model);
		} catch (FileNotFoundException e) {
			issues.addError(e.toString());
		} catch (Exception e) {
			issues.addError(e.toString());
		}
	}

	/**
	 * Set the filename of the Enterprise Architect repository
	 * @param value	filename of the Enterprise Architect repository
	 */
	public void setRepositoryFile(String value) {
		log.debug("Setting repository to " + value);
		this.repositoryFile = value;
	}
	
	/**
	 * Set the name of the model to transform
	 * @param value	the name of the model
	 */
	public void setModelName(String value) {
		log.debug("Setting modelName to " + value);
		this.modelName = value;
	}
	
	/**
	 * Set the name of the output slot of the model
	 * @param value	the name of the output slot
	 */
	public void setOutputSlot(String value) {
		log.debug("Setting outputSlot to " + value);
		this.outputSlot = value;
	}
	
	/**
	 * Reads the repository and extracts the model to transform
	 * @return the model to transform
	 * @throws FileNotFoundException
	 * @throws Exception
	 */
	private Package readModel() throws FileNotFoundException, Exception {
		File file = new File(this.repositoryFile);
		if ( ! file.exists() ) {
			throw new FileNotFoundException("File not found: " + this.repositoryFile);
		}

		log.info("Reading Model: " + this.repositoryFile);

		Repository repository = new Repository();
		if ( ! repository.OpenFile(file.getAbsolutePath()) ) {
			throw new Exception("Cannot read Enterprise Architect repository: " + file.getAbsolutePath());
		}

		Collection<Package> pkgs = repository.GetModels();

		log.info("Repository " + this.repositoryFile + " contains " + pkgs.GetCount() + " models");
		
		Package model = null;
		
		for ( Package m : pkgs ) {
			log.info("Found model: " + m.GetName());
			if ( m.GetName().equals(this.modelName) ) {
				model = m;
				break;
			}
		}
		
		if ( model == null ) {
			throw new Exception("Model " + this.modelName + " not found in repository");
		}
		
		repository.CloseFile();
		repository.Exit();
		
		return model;
	}
}
