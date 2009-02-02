/**
 * 
 */
package de.genesez.example.java.calculator.smfeatures;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author georg
 *
 */
public class SmFeaturesTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testTimerEvents() {
		TimerTest timerTest = new TimerTest();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
