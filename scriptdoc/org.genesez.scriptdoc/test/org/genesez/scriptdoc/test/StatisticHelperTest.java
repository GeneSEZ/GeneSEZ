package org.genesez.scriptdoc.test;

import java.util.HashSet;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.Test;

import de.genesez.scriptdoc.helper.StatsHelper;
import de.genesez.scriptdoc.parsing.Executable;
import de.genesez.scriptdoc.parsing.ExtendScript;
import de.genesez.scriptdoc.parsing.Function;
import de.genesez.scriptdoc.parsing.Script;

public class StatisticHelperTest extends TestCase{
	
	private String testString = "Test \r Test \r\n test \n";
	
	private static java.util.Set<String> testComments = new HashSet<String>();
	
	private static String testCodebody = 
								  "Void createSetterOperation(MAttribute this, MClassifier container) : " +StatsHelper.NEWLINE +
								  "«IF this.generateSetter() " + StatsHelper.NEWLINE + 
								  "//this.setTaggedValue(\"accessor\", \"setter\", \"false\");" + StatsHelper.NEWLINE;
	
	private static String testParamDef = "(TypeA a, Type B b)";

	
	private static Executable testFunction = new Function("test", testCodebody, testParamDef);
	
	private static Script testScript = new ExtendScript();
	
	public static junit.framework.Test suite() {
		testComments.add("/* test1 ");
		testComments.add("* test2 ");
		testComments.add("* test3 ");
		testComments.add("* test4 \r\n Test");
		testFunction.setComments(testComments);
		testScript = new ExtendScript();
		testScript.insertInSymbols(testFunction);
		return new TestSuite(StatisticHelperTest.class);
	}

	@Test	
	public void testGetLineCount() {		
		assertEquals("unexpected line count!", Integer.valueOf(3), StatsHelper.getLineCount(testString));	
		assertEquals("expected wrong line count!", Integer.valueOf(4), StatsHelper.getLineCount(testString));	
	}
	
	@Test	
	public void testGetCommentLineCount() {		
		assertEquals("unexpected count!", Integer.valueOf(5), StatsHelper.getCommentLineCount(testFunction));		
	}
	
	@Test	
	public void testGetBlankLineCount() {		
		assertEquals("unexpected count!", Integer.valueOf(0), StatsHelper.getBlankLineCount(testFunction.getCodeBody()));		
	}
	
	@Test	
	public void testGetProgrammLineCount() {		
		assertEquals("unexpected count!", Integer.valueOf(4), StatsHelper.getProgramLineCount(testFunction));		
	}
	
	@Test	
	public void testGetVocabularySize() {		
		assertEquals("unexpected count!", Integer.valueOf(7), StatsHelper.getVocabularySize(testCodebody));		
	}
	
	@Test	
	public void testGetCyclomatic() {		
		assertEquals("unexpected count!", Integer.valueOf(2), StatsHelper.getCyclomaticComplexity(testCodebody));		
	}
	
	@Test	
	public void testGetDifficultyLvl() {		
		assertEquals("unexpected count!", Double.valueOf(3), StatsHelper.getDifficultyLvl(testCodebody));		
	}
	
	@Test	
	public void testGetProgramVolume() {		
		assertEquals("unexpected count!", Double.valueOf(42.11032383086406), StatsHelper.getProgramVolume(testCodebody));		
	}
	
	@Test	
	public void testGetProgramNiveau() {		
		assertEquals("unexpected count!", Double.valueOf(0.3333333333333333), StatsHelper.getProgramNiveau(testCodebody));		
	}
	
	@Test	
	public void testGetEffortToImpl() {		
		assertEquals("unexpected count!", Double.valueOf(126.33097149259218), StatsHelper.getEffortToImplement(testCodebody));		
	}
	
	@Test	
	public void testGetTimeToImpl() {		
		assertEquals("unexpected count!", Double.valueOf(7.01838730514401), StatsHelper.getTimeToImplement(testCodebody));		
	}
	
	@Test	
	public void testGetBugCount() {		
		assertEquals("unexpected count!", Double.valueOf(0.00839235606546606), StatsHelper.getBugCount(testCodebody));		
	}
	
	@Test	
	public void testCountOperators() {		
		assertEquals("unexpected count!", Integer.valueOf(14), StatsHelper.countOperators(testCodebody));		
	}
}
