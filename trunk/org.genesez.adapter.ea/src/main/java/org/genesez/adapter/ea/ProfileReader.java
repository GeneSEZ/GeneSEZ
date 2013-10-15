package org.genesez.adapter.ea;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_12d203c6_1328866934865_740501_2040) 
 */
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
 * The profile reader imports a number of UML profiles and make these profiles
 * available for applying them to a transformed UML model.
 * @author Christian
 */
public class ProfileReader extends AbstractWorkflowComponent {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(ProfileReader.class);
	
	private String profileDirectory = "null";
	
	private String profileExtension = "profile.uml";
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor pm, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363353664639_712434_2442) ENABLED START */
		for (String s : this.profileFiles.keySet()) {
			try {
				URI uri = URI.createFileURI(this.profileFiles.get(s));
				LOG.debug("Profile URI for " + s + ": " + uri.toString());
				LOG.info("Loading profile " + s);
				Resource resource = ResourceRegistry.INSTANCE.load(s, uri);
				Profile profile = (Profile) EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.Literals.PACKAGE);
				ProfileRegistry.INSTANCE.register(s, profile);
				//	this is a very ugly hack to transform
				//	./profile/testing.profile.uml into
				//	../profile/testing.profile.uml
				String profileURI = profile.eResource().getURI().toString();
				LOG.debug("Profile URI: " + profileURI);
				profile.eResource().setURI(URI.createURI(profileURI.replace(this.profileDirectory + "/", "")));
				LOG.debug("Profile URI: " + profile.eResource().getURI().toString());
				LOG.debug("Profile " + s + " successfully loaded");
			} catch (Exception e) {
				issues.addError(e.toString());
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public void checkConfiguration(Issues i) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363353670969_632812_2447) ENABLED START */
		
		// :)
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * Add profile names
	 */
	public void addProfile(String value) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363353990924_467227_2459) ENABLED START */
		String file = this.profileDirectory + "/" + value + this.profileExtension;
		LOG.debug("Adding profile " + value + " from " + file);
		this.profileFiles.put(value, file);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets the value of attribute '<em><b>profileDirectory</b></em>'.
	 * @param	profileDirectory	the value to set.
	 */
	public void setProfileDirectory(String profileDirectory) {
		this.profileDirectory = profileDirectory;
	}
	
	/**
	 * Sets the value of attribute '<em><b>profileExtension</b></em>'.
	 * @param	profileExtension	the value to set.
	 */
	public void setProfileExtension(String profileExtension) {
		this.profileExtension = profileExtension;
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_12d203c6_1328866934865_740501_2040) ENABLED START */
	private Map<String, String> profileFiles = new HashMap<String, String>();
	/* PROTECTED REGION END */
}
