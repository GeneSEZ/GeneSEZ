/**
 * 
 */
package de.genesez.example.java.calculator.smfeatures;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.genesez.platforms.java.umlsupport.statechart.EventQueue;
import static org.junit.Assert.*;

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
	
//	@Test
	public void testTimerEvents() {
		TimerTest timerTest = new TimerTest();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHistoryStates() {
		HistoryStateExerciser exerciser = new HistoryStateExerciser();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a1, exerciser.getCurrentState());
		exerciser.takeT1();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a2, exerciser.getCurrentState());
		exerciser.takeT2();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a3, exerciser.getCurrentState());
		exerciser.takeT3();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a1, exerciser.getCurrentState());
		exerciser.takeH4();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1b1, exerciser.getCurrentState());
		exerciser.takeT5();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1b2, exerciser.getCurrentState());
		exerciser.takeT8();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a2, exerciser.getCurrentState());
		exerciser.takeH2();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1b2, exerciser.getCurrentState());
		exerciser.takeT6();
		exerciser.takeT7();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level2b2, exerciser.getCurrentState());
		exerciser.takeH0();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a2, exerciser.getCurrentState());
		exerciser.takeT2();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a3, exerciser.getCurrentState());
		exerciser.takeH2();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level2b2, exerciser.getCurrentState());
		exerciser.takeH0();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a2, exerciser.getCurrentState());
		exerciser.takeT2();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a3, exerciser.getCurrentState());
		exerciser.takeT9();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level2b2, exerciser.getCurrentState());
		exerciser.takeH0();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a2, exerciser.getCurrentState());
		exerciser.takeT2();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a3, exerciser.getCurrentState());
		exerciser.takeT3();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a1, exerciser.getCurrentState());
		exerciser.takeH4();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level2b2, exerciser.getCurrentState());

		exerciser.takeT11();
		exerciser.takeT10();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1b1, exerciser.getCurrentState());
		exerciser.takeT11();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a1, exerciser.getCurrentState());
		exerciser.takeH4();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1b1, exerciser.getCurrentState());
		
		exerciser.takeT5();
		exerciser.takeT11();
		exerciser.takeH4();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1b2, exerciser.getCurrentState());
		
		exerciser.takeT6();
		exerciser.takeT11();
		exerciser.takeH4();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level2b1, exerciser.getCurrentState());
		
		exerciser.takeH0();
		exerciser.takeT10();
		exerciser.takeT11();
		exerciser.takeT1();
		exerciser.takeT2();
		exerciser.takeH2();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1b1, exerciser.getCurrentState());
		
		exerciser.takeT5();
		exerciser.takeT11();
		exerciser.takeT1();
		exerciser.takeT2();
		exerciser.takeH2();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1b2, exerciser.getCurrentState());
		
		exerciser.takeT6();
		exerciser.takeT11();
		exerciser.takeT1();
		exerciser.takeT2();
		exerciser.takeH2();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level2b1, exerciser.getCurrentState());
		
		exerciser.takeT7();
		exerciser.takeH0();
		exerciser.takeT2();
		exerciser.takeH2();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level2b2, exerciser.getCurrentState());
	
		exerciser.takeH0();
		exerciser.takeT2();
		exerciser.takeT3();
		exerciser.takeT10();
		exerciser.takeT11();
		exerciser.takeT1();
		exerciser.takeH2();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1b1, exerciser.getCurrentState());
		
		exerciser.takeT5();
		exerciser.takeT6();
		exerciser.takeT11();
		exerciser.takeT1();
		exerciser.takeH2();
		exerciser.takeH0();
		exerciser.takeH2();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level2b1, exerciser.getCurrentState());
		
		exerciser.takeT7();
		exerciser.takeT11();
		exerciser.takeT1();
		exerciser.takeH2();
		exerciser.takeT11();
		exerciser.takeH4();
		exerciser.takeH0();
		exerciser.takeH4();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level2b2, exerciser.getCurrentState());
		
	}

}
