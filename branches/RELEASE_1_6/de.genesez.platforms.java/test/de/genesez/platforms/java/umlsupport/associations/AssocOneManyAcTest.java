/**
 * 
 */
package de.genesez.platforms.java.umlsupport.associations;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dreamer
 *
 */
public class AssocOneManyAcTest {
	
	private Car car = null;
	private Wheel wheel1 = null;
	private Wheel wheel2 = null;
	private Mileage mileage1 = null;
	private Mileage mileage2 = null;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		car = new Car("car 1");
		wheel1 = new Wheel("wheel 1");
		wheel2 = new Wheel("wheel 2");
		mileage1 = new Mileage(200, new ACLink());
		mileage2 = new Mileage(500, new ACLink());
		
		car.wheel().insert(wheel1, mileage1);
		car.wheel().insert(wheel2, mileage2);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		car = null;
		wheel1 = null;
		wheel2 = null;
		mileage1 = null;
		mileage2 = null;
	}
	
	@Test
	public void testOneToManyWithAC() {
		// get all associated wheels
		List<Wheel> wheels = new ArrayList<Wheel>();
		for (Iterator<Wheel> it = car.wheel().iterator(); it.hasNext();) {
			wheels.add(it.next());
		}
		assertEquals("car 1 hasn't 2 wheels", 2, wheels.size());
		
		// check if wheels are associated with the car
		assertTrue("car is not associated with wheel 1", wheels.contains(wheel1));
		assertTrue("car is not associated with wheel 2", wheels.contains(wheel2));
		
		// check correct mileage
		assertEquals("wheel 1 has not milage 1", mileage1, car.wheel().getAssoc(wheel1));
		assertEquals("wheel 2 has not milage 2", mileage2, car.wheel().getAssoc(wheel2));
		
		// check inverse for wheel 1
		List<Car> cars1 = new ArrayList<Car>();
		for (Iterator<Car> it = wheel1.car().iterator(); it.hasNext();) {
			cars1.add(it.next());
		}
		assertEquals("wheel 1 should have exactly one car", 1, cars1.size());
		
		// check inverse for wheel 2
		List<Car> cars2 = new ArrayList<Car>();
		for (Iterator<Car> it = wheel2.car().iterator(); it.hasNext();) {
			cars2.add(it.next());
		}
		assertEquals("wheel 2 should have exactly one car", 1, cars2.size());
		
		// check inserve for car
		assertEquals("wheel 1 is not associated with the car", car, wheel1.car().get());
		assertEquals("wheel 2 is not associated with the car", car, wheel2.car().get());
		
		// check inverse milage
		assertEquals("wheel 1 is not associated with mileage 1", mileage1, wheel1.car().getAssoc(car));
		assertEquals("wheel 2 is not associated with mileage 2", mileage2, wheel2.car().getAssoc(car));
	}
	
	
	public class Car {
		private String name = null;
		private AssociationAC<Car, Wheel, Mileage> wheel = new ManyAssociationAC<Car, Wheel, Mileage>(
				this, new LinkedHashMap<Wheel, Mileage>(), Wheel.class, "car");
		
		public Car(String name) {
			this.name = name;
		}
		public AssociationAC<Car, Wheel, Mileage> wheel() {
			return wheel;
		}
	}
	
	public class Wheel {
		private String name = null;
		private AssociationAC<Wheel, Car, Mileage> car = new OneAssociationAC<Wheel, Car, Mileage>(
				this, Car.class, "wheel");
		
		public Wheel(String name) {
			this.name = name;
		}
		public AssociationAC<Wheel, Car, Mileage> car() {
			return car;
		}
	}
	
	public class Mileage implements AssociationClass {
		private int duration = 0;
		private ACLink associationClassLink = new ACLink();
		public Mileage(int duration, ACLink link) {
			this.duration = duration;
			this.associationClassLink = link;
		}
		public ACLink getAssociationClassLink() {
			return associationClassLink;
		}
	}
}
