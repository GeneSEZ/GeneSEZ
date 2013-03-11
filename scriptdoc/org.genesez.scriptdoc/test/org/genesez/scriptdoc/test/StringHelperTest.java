package org.genesez.scriptdoc.test;

import java.io.File;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.Test;

import de.genesez.scriptdoc.helper.StringHelper;

public class StringHelperTest extends TestCase{
	
	private String sample = "testtesttest \r @@@Test@@@ \r";
	
	private String searchedValue = "@@@Test@@@";
	
	File testFile = new File("C:\\_BA\\GeneSEZ_WS\\RELEASE_2_1\\org.genesez.platform.java\\java5\\org\\genesez\\platform\\java\\java5\\templates");
	
	String testRoot = "C:\\_BA\\GeneSEZ_WS\\RELEASE_2_1";
	
	public static junit.framework.Test suite() {
		return new TestSuite(StringHelperTest.class);
	}

	@Test	
	public void testDuplicateLine() {			
		assertEquals("unexpected duplication!", "testtesttest \r @@@Test@@@ \r @@@Test@@@ \r", StringHelper.duplicateLine(sample, searchedValue, "\r"));		
	}
	
	@Test	
	public void testReplaceFirstLine() {			
		String replacement = "FooBar";
		assertEquals("unexpected replacement!", "testtesttest \r FooBar \r", StringHelper.replaceFirstLine(sample, "\r", searchedValue, replacement));		
	}
	
	@Test	
	public void testArrayToString() {			
		String[] parts = {"B", "e", "s", "t", "_", "o", "A", "W", "_", "D", "o", "c", "u", "_", "e", "v", "e", "r", "^", "^"};
		assertEquals("unexpected String!", "Best_oAW_Docu_ever^^", StringHelper.arrayToString(parts, ""));		
	}
	
	@Test	
	public void testSeparateEclipsProjectPathOutOfFile() {			
		String expected = "org.genesez.platform.java";
		assertEquals("unexpected String!", expected, StringHelper.separateEclipsProjectPathOutOfFile(testFile, testRoot));		
	}
	
	@Test	
	public void testSeparateNamespaceOutOfFile() {			
		String expected = "org::genesez::platform::java::java5";
		assertEquals("unexpected String!", expected, StringHelper.separateNamespaceOutOfFile(testFile, testRoot, true));		
	}
	
	@Test	
	public void testSeparateDirPathOutOfFile() {			
		String expected = "java5/org/genesez/platform/java/java5";
		assertEquals("unexpected String!", expected, StringHelper.separateDirPathOutOfFile(testFile, testRoot));		
	}
}
