package de.genesez.adapter.ea;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.AbstractWorkflowComponent;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;

public class ProfileReader extends AbstractWorkflowComponent {

	private static final ResourceSetImpl RESOURCE_SET = new ResourceSetImpl();
	private static final Log log = LogFactory.getLog(RepositoryReader.class);

	private String profileDirectory = null;
	private String profileExtension = "profile.uml";
	private Map<String, String> profileFiles = new HashMap<String, String>();
	
	public void checkConfiguration(Issues issues) {
		// nothing to do here
	}
	
	public void invoke(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		for (String s: this.profileFiles.keySet()) {
			try {
				URI uri = URI.createFileURI(this.profileFiles.get(s));
				log.debug("Profile URI for " + s + ": " + uri.toString());
				log.info("Loading profile " + s);
				Resource resource = RESOURCE_SET.getResource(uri, true);
				Profile profile = (Profile)EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.Literals.PACKAGE);
				ProfileRegistry.instance.register(s, profile);
				//	this is a very ugly hack to transform
				//	./profile/testing.profile.uml into
				//	../profile/testing.profile.uml
				profile.eResource().setURI(
						URI.createURI("." + profile.eResource().getURI().toString())
						);
				log.debug(profile.eResource().getURI().toString());
				log.debug("Profile " + s + " successfully loaded");
			} catch (Exception e) {
				issues.addError(e.toString());
			}
		}
	}
	
	/**
	 * 
	 * @param value
	 */
	public void  setProfileDirectory(String value) {
		log.debug("Setting profile directory to " + value);
		this.profileDirectory = value;
	}

	/**
	 * 
	 * @param value
	 */
	public void  setProfileExtension(String value) {
		log.debug("Setting profile extension to " + value);
		this.profileExtension = value;
	}

	/**
	 * 
	 * @param value
	 */
	public void addProfile(String value) {
		String file = this.profileDirectory + "/" + value + this.profileExtension;
		log.info("Adding profile " + value + " from " + file);
		this.profileFiles.put(value, file);
	}
}
