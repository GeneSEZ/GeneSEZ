package org.genesez.platform.common.m2t;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.genesez.platform.common.m2t.ImportBeautifier;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ImportBeautifierTest {
	
	private static ImportBeautifier ib;
	private static Path testfile;
	private static Path testfile_copy;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		ib = new ImportBeautifier();
		testfile = Paths.get("").resolve("test/org/genesez/platform/common/m2t/testfile");
		testfile_copy = Paths.get("").resolve("test/org/genesez/platform/common/m2t/testfile_copy");
		Files.copy(testfile, testfile_copy, StandardCopyOption.REPLACE_EXISTING);
	}

	@After
	public void tearDown() throws Exception {
		Files.copy(testfile_copy, testfile, StandardCopyOption.REPLACE_EXISTING);
		Files.deleteIfExists(testfile_copy);
	}

	@Test
	public void testJavaImports() throws IOException {
		assertEquals(prepareJavaTest(),ib.importMap);
	}
	
	private Map<String, Set<String>> prepareJavaTest() throws IOException{
		Map<String, Set<String>> testmap = new HashMap<String, Set<String>>();
		Set<String> set = new HashSet<String>();
		set.add("import java.util.Imports;");
		set.add("import fjg.skdja.lala;");
		testmap.put("123", set);
		ib.setFileExtensions(".java");
		ib.setImportStrings("import");
		Path test = Paths.get("").resolve("test/org/genesez/platform/common/m2t/testfile.java");
		if(!Files.exists(test)){
			test = Files.createLink(Paths.get(testfile.toString().concat(".java")), testfile);
		}
		ib.updateFileVisit(test);
		Files.deleteIfExists(test);
		return testmap;
	}
	
	@Test
	public void testImportDisabled() throws IOException {
		ib.setImportTakeOver(false);
		prepareJavaTest();
		assertTrue(ib.importMap.isEmpty());
	}

	@Test
	public void testSetFileExtensions() {
		ib.setFileExtensions(".java, .php ; .php5, .html; .sh ");
		String regex = ib.getOptions().getProperty("org.genesez.importbeautifier.fileextensions","");
		assertEquals(".*(\\.java|\\.php|\\.php5|\\.html|\\.sh)$",regex);
		assertTrue("hallo.java".matches(regex));
		assertFalse("hallo.java.shk".matches(regex));
		assertFalse("hallo.supperjava".matches(regex));
		assertTrue("hallo.shk.php5".matches(regex));
		assertTrue("hallo.sh".matches(regex));
		assertTrue("java.html".matches(regex));
		assertTrue(".xml.php".matches(regex));
	}
	
	@Test
	public void testSetFileExtensionsFail() {
		ib.setFileExtensions(".jav(<(a, .ph)p ; .php5, .html; .sh ");
		assertNull(ib.getOptions().getProperty("org.genesez.importbeautifier.fileextensions"));
	}

	@Test
	public void testSetImportRegexFail() {
		ib.setImportRegex("((]hdskjd");
		assertNull(ib.getOptions().getProperty("org.genesez.importformatter.regex"));
	}
	
	@Test
	public void testSetImportRegex() {
		String regex = "import .*;$";
		ib.setImportRegex(regex);
		assertEquals(regex, ib.getOptions().getProperty("org.genesez.importformatter.regex",""));
		regex = "(import .*;$|#include)";
		ib.setImportRegex(regex);
		assertEquals(regex, ib.getOptions().getProperty("org.genesez.importformatter.regex",""));
	}
	
	@Test
	public void testSetImportStrings() {
		String imports = "import";
		ib.setImportStrings(imports);
		assertEquals("(import) .*$", ib.getOptions().getProperty("org.genesez.importformatter.regex",""));
		imports = "import, #include; xs:import";
		ib.setImportStrings(imports);
		assertEquals("(import|#include|xs:import) .*$", ib.getOptions().getProperty("org.genesez.importformatter.regex",""));
	}
}
