package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_1_df50335_1381481184548_396733_3683) 
 */
import org.eclipse.uml2.uml.VisibilityKind;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author Christian
 */
public class VisibilityTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	public static final VisibilityTransformer INSTANCE = new VisibilityTransformer();
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public VisibilityKind getVisibilityKind(org.sparx.Element element) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_1_df50335_1381481226808_900425_3703) ENABLED START */
		return getVisibilityKind(element.GetVisibility());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public VisibilityKind getVisibilityKind(org.sparx.Attribute attribute) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_1_df50335_1381481252876_63340_3708) ENABLED START */
		return getVisibilityKind(attribute.GetVisibility());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public VisibilityKind getVisibilityKind(org.sparx.Method method) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_1_df50335_1381481271237_931800_3712) ENABLED START */
		return getVisibilityKind(method.GetVisibility());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public VisibilityKind getVisibilityKind(org.sparx.ConnectorEnd eaConnectorEnd) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_1_df50335_1382082746708_98084_3809) ENABLED START */
		return getVisibilityKind(eaConnectorEnd.GetVisibility());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	private VisibilityKind getVisibilityKind(String visibility) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_1_df50335_1381481290238_787058_3716) ENABLED START */
		if (visibility.equals("Public")) {
			return VisibilityKind.PUBLIC_LITERAL;
		} else if (visibility.equals("Private")) {
			return VisibilityKind.PRIVATE_LITERAL;
		} else if (visibility.equals("Protected")) {
			return VisibilityKind.PROTECTED_LITERAL;
		} else if (visibility.equals("Package")) {
			return VisibilityKind.PACKAGE_LITERAL;
		}
		return null;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_1_df50335_1381481184548_396733_3683) ENABLED START */
	
	// :)
	
	/* PROTECTED REGION END */
}
