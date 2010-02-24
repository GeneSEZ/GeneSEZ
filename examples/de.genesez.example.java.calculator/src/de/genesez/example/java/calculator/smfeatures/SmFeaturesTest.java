/**
 * 
 */
package de.genesez.example.java.calculator.smfeatures;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.genesez.platforms.java.umlsupport.statemachine.EventQueue;
import de.genesez.platforms.java.umlsupport.statemachine.EventQueue.Event;
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
	
	@Test
	public void testTimerEvents() {
		new TimerTest();
		new TimerTest();
		try {
			Thread.sleep(1300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new TimerTest();
		new TimerTest();
		new TimerTest();
		new TimerTest();
		new TimerTest();
		new TimerTest();
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHistoryStates() {
		EventQueue.cancelTimers();
		EventQueue.waitQEmpty();
		HistoryStateExerciser exerciser = new HistoryStateExerciser();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a1, exerciser.getCurrentState());
		exerciser.takeT1();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a2, exerciser.getCurrentState());
		exerciser.takeT2();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a3, exerciser.getCurrentState());
		exerciser.takeT3();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a1, exerciser.getCurrentState());
		exerciser.takeH4();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1b1, exerciser.getCurrentState());
		exerciser.takeT5();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1b2, exerciser.getCurrentState());
		exerciser.takeT8();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a2, exerciser.getCurrentState());
		exerciser.takeH2();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1b2, exerciser.getCurrentState());
		exerciser.takeT6();
		exerciser.takeT7();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level2b2, exerciser.getCurrentState());
		exerciser.takeH0();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a2, exerciser.getCurrentState());
		exerciser.takeT2();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a3, exerciser.getCurrentState());
		exerciser.takeH2();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level2b2, exerciser.getCurrentState());
		exerciser.takeH0();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a2, exerciser.getCurrentState());
		exerciser.takeT2();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a3, exerciser.getCurrentState());
		exerciser.takeT9();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level2b2, exerciser.getCurrentState());
		exerciser.takeH0();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a2, exerciser.getCurrentState());
		exerciser.takeT2();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a3, exerciser.getCurrentState());
		exerciser.takeT3();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a1, exerciser.getCurrentState());
		exerciser.takeH4();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level2b2, exerciser.getCurrentState());

		exerciser.takeT11();
		exerciser.takeT10();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1b1, exerciser.getCurrentState());
		exerciser.takeT11();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a1, exerciser.getCurrentState());
		exerciser.takeH4();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1b1, exerciser.getCurrentState());
		
		exerciser.takeT5();
		exerciser.takeT11();
		exerciser.takeH4();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1b2, exerciser.getCurrentState());
		
		exerciser.takeT6();
		exerciser.takeT11();
		exerciser.takeH4();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level2b1, exerciser.getCurrentState());
		
		exerciser.takeH0();
		exerciser.takeT10();
		exerciser.takeT11();
		exerciser.takeT1();
		exerciser.takeT2();
		exerciser.takeH2();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1b1, exerciser.getCurrentState());
		
		exerciser.takeT5();
		exerciser.takeT11();
		exerciser.takeT1();
		exerciser.takeT2();
		exerciser.takeH2();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1b2, exerciser.getCurrentState());
		
		exerciser.takeT6();
		exerciser.takeT11();
		exerciser.takeT1();
		exerciser.takeT2();
		exerciser.takeH2();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level2b1, exerciser.getCurrentState());
		
		exerciser.takeT7();
		exerciser.takeH0();
		exerciser.takeT2();
		exerciser.takeH2();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level2b2, exerciser.getCurrentState());
	
		exerciser.takeH0();
		exerciser.takeT2();
		exerciser.takeT3();
		exerciser.takeT10();
		exerciser.takeT11();
		exerciser.takeT1();
		exerciser.takeH2();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1b1, exerciser.getCurrentState());
		
		exerciser.takeT5();
		exerciser.takeT6();
		exerciser.takeT11();
		exerciser.takeT1();
		exerciser.takeH2();
		exerciser.takeH0();
		exerciser.takeH2();
		EventQueue.waitQEmpty();
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
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
		assertNull("unexpected event occurred", EventQueue.getLastErrorEvent());
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level2b2, exerciser.getCurrentState());
		exerciser.takeT1();
		EventQueue.waitQEmpty();
		assertNotNull("unexpected event not detected", EventQueue.getLastErrorEvent());
		EventQueue.resume();
		exerciser.takeT11();
		EventQueue.waitQEmpty();
		assertEquals("not in expected state", HistoryStateExerciser.StateId.level1a1, exerciser.getCurrentState());
		
	}

}
