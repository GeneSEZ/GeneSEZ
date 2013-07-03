package forms;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_b6f02e1_1249543362015_69354_283) 
 */
import java.awt.Color;
import java.util.LinkedHashMap;
import java.util.Map;

import org.genesez.platform.java.umlsupport.associations.Association;
import org.genesez.platform.java.umlsupport.associations.AssociationRole;
import org.genesez.platform.java.umlsupport.associations.ManyAssociation;
import org.genesez.platform.java.umlsupport.associations.RelatedAssociationRole;

/**
 * <p>
 *   describes a complex <b>figure</b> by a composition of forms
 * </p>
 */
public class Figure extends AbstractForm implements Form, AssociationRole {
	
	/** Defines an identifier for each association, used by the association handling library */
	public enum Associations implements RelatedAssociationRole {
		FORMS
	}
	
	/** Stores the association management objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	
	/** Stores all linked objects of association '<em><b>forms</b></em>' */
	private java.util.Set<Form> forms = new java.util.HashSet<Form>();
	
	private boolean solid;
	
	/**
	 * Returns the value of attribute '<em><b>solid</b></em>'.
	 */
	public boolean getSolid() {
		return solid;
	}
	
	/**
	 * Sets the value of attribute '<em><b>solid</b></em>'.
	 * @param	solid	the value to set.
	 */
	public void setSolid(boolean solid) {
		this.solid = solid;
	}
	
	/**
	 * moves the position by the given delta values within a 2-dimensional 
	 * coordinate system
	 * @param	dx	delta value to move in <i><b>x</b></i> direction
	 * @param	dy	delta value to move in <i><b>y</b></i> direction
	 */
	public void move(double dx, double dy) {
		/* PROTECTED REGION ID(java.implementation._16_0_b6f02e1_1249543362015_69354_283__14_0_b6f02e1_1214478865734_965960_209) ENABLED START */
		for (Form f : forms) {
			f.move(dx, dy);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * performs a rotation by the specified angle
	 * @param	phi	the angle in degrees
	 */
	public void rotate(double phi) {
		/* PROTECTED REGION ID(java.implementation._16_0_b6f02e1_1249543362015_69354_283__14_0_b6f02e1_1212580097609_734698_127) ENABLED START */
		for (Form f : forms) {
			f.rotate(phi);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * performs a rotations around the specified point by the specified angle
	 * @param	center	the center of the rotation
	 * @param	phi	the angle in degrees
	 */
	public void rotate(Point center, double phi) {
		/* PROTECTED REGION ID(java.implementation._16_0_b6f02e1_1249543362015_69354_283__14_0_b6f02e1_1214478889937_90346_236) ENABLED START */
		for (Form f : forms) {
			f.rotate(center, phi);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * changes the color by repainting using the specified color
	 * @param	color	the color to use for repainting
	 */
	public void repaint(Color color, boolean solid) {
		/* PROTECTED REGION ID(java.implementation._16_0_b6f02e1_1249543362015_69354_283__16_0_b6f02e1_1249464738828_388422_1023) ENABLED START */
		for (Form f : forms) {
			f.repaint(color, solid);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * determines the center of area of the form
	 * @return	the location of the center of area
	 */
	public Point getCenterOfArea() {
		/* PROTECTED REGION ID(java.implementation._16_0_b6f02e1_1249543362015_69354_283__16_0_b6f02e1_1249464477484_822826_834) ENABLED START */
		//TODO: Theoretisch müsste man hier den Mittelpunkt aller Forms holen, und aus dem wiederum den Mittelpunkt
		return null;
		/* PROTECTED REGION END */
	}
	
	/**
	 * determines if the form is crossing another form
	 * @param	form	the form to check for crossing
	 * @return	true, if the specified form crosses this form, otherwise false
	 */
	public boolean isCrossing(Form form) {
		/* PROTECTED REGION ID(java.implementation._16_0_b6f02e1_1249543362015_69354_283__16_0_b6f02e1_1249464485156_784670_838) ENABLED START */
		for (Form f : forms) {
			if (f.isCrossing(form)) {
				return true;
			}
		}
		return false;
		/* PROTECTED REGION END */
	}
	
	// initialization block for association management objects
	{
		association.put(Associations.FORMS, new ManyAssociation<Figure, Form>(this, forms));
	}
	
	/**
	 * Provides generic access to association objects, used by the association handling library
	 * @see org.genesez.platform.java.umlsupport.associations.AssociationRole#getAssociation(org.genesez.platform.java.umlsupport.associations.modified.RelatedAssociationRole)
	 */
	public Association<? extends Object, ? extends Object> getAssociation(RelatedAssociationRole role) {
		if (association.containsKey(role))
			return association.get(role);
		throw new RuntimeException("the class doesn't have the association you specified!");
	}
	
	/**
	 * the form objects this figure consists of
	 */
	@SuppressWarnings("unchecked")
	public Association<Figure, Form> forms() {
		return (Association<Figure, Form>) association.get(Associations.FORMS);
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_b6f02e1_1249543362015_69354_283) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
