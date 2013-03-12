package org.genesez.scriptdoc.test;

import java.io.File;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.genesez.scriptdoc.helper.RelativePath;
import org.junit.Test;


public class RelativePathTest extends TestCase{

	public static junit.framework.Test suite() {
		return new TestSuite(RelativePathTest.class);
	}

	@Test	
	public void testGetRelativePath() {		
		File home = new File("/a/b/c");
		File f = new File("/a/d/e/x.txt");
		String expectedPath = "../../d/e/x.txt";
		
		assertEquals("unexpected relative path!", expectedPath, RelativePath.getRelativePath(home, f));	
	}
}
