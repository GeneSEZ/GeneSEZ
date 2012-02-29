package forms;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_14_0_b6f02e1_1212580097593_990285_125) 
 */

import traceability.ScenarioStep;
import de.genesez.platforms.java.umlsupport.associations.*;
import traceability.Requirement;
import static traceability.Requirement.Value.R4;
import traceability.Scenario;

/**
 * Describes the common behavior of a geometrical forms
 * @author domwet
 */
@Requirement({
	R4
})
public interface Form extends Moveable, Rotateable, Paintable {
	
	/**
	 * determines the center of area of the form
	 * @return	the location of the center of area
	 */
	public Point getCenterOfArea();
	
	/**
	 * determines if the form is crossing another form
	 * @param	form	the form to check for crossing
	 * @return	true, if the specified form crosses this form, otherwise false
	 */
	public boolean isCrossing(Form form);
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.interface.own.code.declaration._14_0_b6f02e1_1212580097593_990285_125) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
