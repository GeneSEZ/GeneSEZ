package forms;

import java.util.*;
import de.genesez.platforms.java.umlsupport.associations.*;

/* PROTECTED REGION ID(java.type.import._14_0_b6f02e1_1212580097593_990285_125) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */
/**
 * Describes the common behavior of a geometrical forms
 * @author	dreamer
 */
public interface Form extends Moveable, Rotateable, Paintable {
	
	/**
	 * determines the center of area of the form
	 * @return	determines the center of area of the form
	 */
	public Point getCenterOfArea();
	
	/**
	 * determines if the form is crossing another form
	 * @param	form	the form to check for crossing
	 * @return	determines if the form is crossing another form
	 */
	public boolean isCrossing(Form form);
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.interface.own.code.declaration._14_0_b6f02e1_1212580097593_990285_125) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
