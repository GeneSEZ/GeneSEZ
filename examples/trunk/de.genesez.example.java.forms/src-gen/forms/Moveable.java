package forms;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_14_0_b6f02e1_1214478843156_556754_163) 
 */

import traceability.ScenarioStep;
import static traceability.Requirement.Value.R5;
import de.genesez.platforms.java.umlsupport.associations.*;
import traceability.Requirement;
import traceability.Scenario;

/**
 * describes things which can be <i><b>moved</b></i>
 * @author domwet
 */
@Requirement({
	R5
})
public interface Moveable {
	
	/**
	 * moves the position by the given delta values within a 2-dimensional 
	 * coordinate system
	 * @param	dx	delta value to move in <i><b>x</b></i> direction
	 * @param	dy	delta value to move in <i><b>y</b></i> direction
	 */
	@Requirement({
		R5
	})
	public void move(double dx, double dy);
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.interface.own.code.declaration._14_0_b6f02e1_1214478843156_556754_163) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
