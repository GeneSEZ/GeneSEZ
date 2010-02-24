/**
 * 
 */
package de.genesez.example.java.calculator.calculator;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.genesez.platforms.java.umlsupport.statemachine.EventQueue;

/**
 * @author georg beier
 *
 */
public class UmlCalculatorTest {

	public UmlCalculator calculator;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		calculator = new UmlCalculator();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSimpleOperations() {
		calculator.takeDigit(1);
		calculator.takeDigit(7);
		calculator.takeDot();
		calculator.takeDigit(3);
		calculator.takeOperator(Operation.ADD);
		calculator.takeDigit(3);
		calculator.takeDot();
		calculator.takeDigit(7);
		calculator.takeEquals();
		EventQueue.waitQEmpty();
		assertEquals("Add failed", new BigDecimal(21), calculator.getResult());
		calculator.takeClear();
		EventQueue.waitQEmpty();
		assertEquals("Clear failed", new BigDecimal(0), calculator.getResult());
		calculator.takeDigit(1);
		calculator.takeDigit(7);
		calculator.takeOperator(Operation.SUB);
		calculator.takeDigit(4);
		calculator.takeEquals();
		EventQueue.waitQEmpty();
		assertEquals("Sub failed", new BigDecimal(13), calculator.getResult());
		calculator.takeClear();
		calculator.takeDigit(1);
		calculator.takeDigit(7);
		calculator.takeOperator(Operation.MUL);
		calculator.takeDigit(4);
		calculator.takeEquals();
		EventQueue.waitQEmpty();
		assertEquals("Mul failed", new BigDecimal(68), calculator.getResult());
		calculator.takeClear();
		calculator.takeDigit(1);
		calculator.takeDigit(6);
		calculator.takeOperator(Operation.DIV);
		calculator.takeDigit(4);
		calculator.takeEquals();
		EventQueue.waitQEmpty();
		assertEquals("Div failed", new BigDecimal(4), calculator.getResult());
		calculator.takeClear();
	}

	@Test
	public void testChainedOperations() {
		calculator.takeDigit(1);
		calculator.takeDigit(7);
		calculator.takeOperator(Operation.ADD);
		calculator.takeDigit(8);
		calculator.takeOperator(Operation.SUB);
		calculator.takeDigit(4);
		calculator.takeOperator(Operation.DIV);
		calculator.takeDigit(3);
		calculator.takeEquals();
		EventQueue.waitQEmpty();
		assertEquals("Add-Sub-Div failed", new BigDecimal(7), calculator.getResult());
		calculator.takeOperator(Operation.MUL);
		calculator.takeDigit(7);
		calculator.takeEquals();
		EventQueue.waitQEmpty();
		assertEquals("Eval-Mul failed", new BigDecimal(49), calculator.getResult());
	}

	@Test
	public void testClearEntry() {
		calculator.takeDigit(1);
		calculator.takeDigit(7);
		calculator.takeClearEntry();
		calculator.takeOperator(Operation.ADD);
		calculator.takeDigit(8);
		calculator.takeEquals();
		EventQueue.waitQEmpty();
		assertEquals("ClearEntry on Y failed", new BigDecimal(8), calculator.getResult());
	}

	@Test
	public void testOverflow() {
		calculator.takeDigit(0);
		calculator.takeDigit(0);
		calculator.takeDigit(0);
		calculator.takeDigit(0);
		calculator.takeDigit(7);
		calculator.takeDigit(0);
		calculator.takeDigit(0);
		calculator.takeDigit(0);
		calculator.takeDigit(0);
		calculator.takeDigit(0);
		calculator.takeDigit(0);
		calculator.takeDigit(0);
		calculator.takeDigit(0);
		calculator.takeDigit(0);
		calculator.takeDigit(0);
		calculator.takeDigit(0);
		calculator.takeDigit(0);
		calculator.takeOperator(Operation.ADD);
		calculator.takeDigit(8);
		calculator.takeEquals();
		EventQueue.waitQEmpty();
		assertEquals("ClearEntry on Y failed", new BigDecimal("7000000008"), calculator.getResult());
		calculator.takeClearEntry();
		calculator.takeDot();
		calculator.takeDigit(0);
		calculator.takeDigit(0);
		calculator.takeDigit(0);
		calculator.takeDigit(0);
		calculator.takeDigit(0);
		calculator.takeDot();
		calculator.takeDot();
		calculator.takeDot();
		calculator.takeDigit(0);
		calculator.takeDigit(0);
		calculator.takeDigit(0);
		calculator.takeDigit(0);
		calculator.takeDigit(1);
		calculator.takeDot();
		calculator.takeDot();
		calculator.takeDigit(0);
		calculator.takeDigit(0);
		calculator.takeDot();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		calculator.takeOperator(Operation.ADD);
		calculator.takeDigit(7);
		calculator.takeEquals();
		EventQueue.waitQEmpty();
		assertEquals("ClearEntry on Y failed", new BigDecimal("7.0000000001"), calculator.getResult());

	}

}
