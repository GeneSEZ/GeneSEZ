package de.genesez.adapter.ea;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * An oAW workflow component to import UML profiles
 * 
 * @author gerbe
 *
 * The profile reader imports a number of UML profiles and make these profiles
 * available for applying them to a transformed UML model.
 */
public class ProfileReader extends AbstractWorkflowComponent {

	private static final Log log = LogFactory.getLog(ProfileReader.class);

	private String profileDirectory = null;
	private String profileExtension = "profile.uml";
	private Map<String, String> profileFiles = new HashMap<String, String>();
	
	public void checkConfiguration(Issues issues) {
		// nothing to do here
	}
	
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		for (String s: this.profileFiles.keySet()) {
			try {
				URI uri = URI.createFileURI(this.profileFiles.get(s));
				log.debug("Profile URI for " + s + ": " + uri.toString());
				log.info("Loading profile " + s);
				Resource resource = ResourceRegistry.instance.load(s, uri);
				Profile profile = (Profile)EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.Literals.PACKAGE);
				ProfileRegistry.instance.register(s, profile);
				//	this is a very ugly hack to transform
				//	./profile/testing.profile.uml into
				//	../profile/testing.profile.uml
				String profileURI = profile.eResource().getURI().toString();
				log.debug("Profile URI: " + profileURI);
				profile.eResource().setURI(
					URI.createURI(
						profileURI.replace(this.profileDirectory+"/", ""))
					);
				log.debug("Profile URI: " + profile.eResource().getURI().toString());
				log.debug("Profile " + s + " successfully loaded");
			} catch (Exception e) {
				issues.addError(e.toString());
			}
		}
	}
	
	/**
	 * Set the directory where to search for the profiles
	 * @param value	the directory path
	 */
	public void  setProfileDirectory(String value) {
		log.debug("Setting profile directory to " + value);
		this.profileDirectory = value;
	}

	/**
	 * Set the extension of UML profile files
	 * @param value	The extension string
	 */
	public void  setProfileExtension(String value) {
		log.debug("Setting profile extension to " + value);
		this.profileExtension = value;
	}

	/**
	 * Add profile names
	 * @param value	Name of a profile to import
	 */
	public void addProfile(String value) {
		String file = this.profileDirectory + "/" + value + this.profileExtension;
		log.debug("Adding profile " + value + " from " + file);
		this.profileFiles.put(value, file);
	}
}
