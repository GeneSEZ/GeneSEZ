
import org.junit.Assert;
import org.junit.Test;

import org.genesez.example.java.car.base.Car;
import org.genesez.example.java.car.base.Wheel;

/**
 * Demonstrates the use of the association handling library.
 * @author dreamer
 */
public class WorkingWithAssociations {
	
	@Test
	public void testing() {
		// construct a car
		Car c = new Car(300, "Lotus Elise");
		
		// construct a wheel
		Wheel frontLeft = new Wheel();
		
		// add the wheel to the car
		c.wheels().insert(frontLeft);
		
		Assert.assertSame("the car has now a wheel", frontLeft, c.wheels().get());
		
		// the inverse of the association is set automatically
		Assert.assertSame("the inverse is set automatically", c, frontLeft.mycar().get());
		
		c.wheels().remove(frontLeft);
	}
}
