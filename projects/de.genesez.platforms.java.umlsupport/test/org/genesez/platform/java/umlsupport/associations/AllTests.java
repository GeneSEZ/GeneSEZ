package org.genesez.platform.java.umlsupport.associations;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for de.genesez.assoctest");
		//$JUnit-BEGIN$
		JUnit4TestAdapter adapter = new JUnit4TestAdapter(AssocOneTest.class);
		suite.addTest(adapter);
		adapter = new JUnit4TestAdapter(AssocManyTest.class);
		suite.addTest(adapter);
		adapter = new JUnit4TestAdapter(AssocOneACTest.class);
		suite.addTest(adapter);
		adapter = new JUnit4TestAdapter(AssocManyACTest.class);
		suite.addTest(adapter);
		//$JUnit-END$
		return suite;
	}

}
