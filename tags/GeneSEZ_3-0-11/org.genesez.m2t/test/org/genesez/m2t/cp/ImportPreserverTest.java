package org.genesez.m2t.cp;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.genesez.m2t.FileTreeWalker;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the import preserver of the content preserve component.
 * - ensures that imports are preserved
 * - ensures that preserved imports are merged with generated
 * - ensures that manual layout and content between imports is preserved
 * - ensures that generated imports are placed on directly after the comment containing the file id
 * 
 * @author tobias haubold <toh@fh-zwickau.de>
 */
public class ImportPreserverTest {
	
	private FileTreeWalker ftw;
	private LineContentPreserving lcp;
	private ImportPreserverAccess ip;
	
	private List<String> filecontents;
	
	private class ImportPreserverAccess extends ImportPreserver {
		
		public Map<String, List<String>> getAllImports() {
			try {
				Field f = ImportPreserver.class.getDeclaredField("allImports");
				f.setAccessible(true);
				return (Map<String, List<String>>)f.get(this);
			} catch (NoSuchFieldException | SecurityException | IllegalAccessException e) {
				e.printStackTrace();
			}
			return new HashMap<String, List<String>>();
		}
		
		public List<String> fileContent;
		
		@Override
		public List<String> includeContent(List<String> input) {
			fileContent = super.includeContent(input);
			return fileContent;
		}
	}
	
	@Before
	public void setUp() throws Exception {
		ftw = new FileTreeWalker();
		
		lcp = new LineContentPreserving();
		ftw.addObserver(lcp);
		
		ip = new ImportPreserverAccess();
		ip.setConfig(new ImportPreserverConfig(".*(\\.java)$", "(import)\\s+.*;$"));
		lcp.preservable().insert(ip);
	}
	
	
	private void preserve(Path file) {
		try {
			filecontents = Files.readAllLines(file, Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void dumpback(Path file) {
		try {
			Files.write(file, filecontents, Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testImportExtraction() {
		ftw.setBaseDir("testfiles/importPreserver/importlist");
		ftw.walkFileTree();
		
		Map<String, List<String>> imports = ip.getAllImports();
		
		Assert.assertNotNull(imports);
		Assert.assertEquals(1, imports.size());
		Assert.assertTrue(imports.containsKey("_Y_wQKQD0EeK7ac-mrkJBDw"));
		
		List<String> imps = imports.get("_Y_wQKQD0EeK7ac-mrkJBDw");
		Assert.assertNotNull(imps);
		Assert.assertEquals(9, imps.size());
	}
	
	@Test
	public void testImportExtractionAndInclusion() {
		// preserve the generated file content (note: will be overridden by 'line content preserve')
		Path file = Paths.get("testfiles/importPreserver/importlistgen/FileTreeWalker.java");
		preserve(file);
		
		testImportExtraction();
		
		// switch base dir to emulate generated file contents
		ftw.setBaseDir("testfiles/importPreserver/importlistgen");
		ftw.walkFileTree();
		
		Assert.assertNotNull(ip.fileContent);
		Assert.assertEquals(252, ip.fileContent.size());
		
		// write original file content back
		dumpback(file);
	}
	
	@Test
	public void testImportExtractionPreservingStyle() {
		ftw.setBaseDir("testfiles/importPreserver/styledimports");
		ftw.walkFileTree();
		
		Map<String, List<String>> imports = ip.getAllImports();
		
		Assert.assertNotNull(imports);
		Assert.assertEquals(1, imports.size());
		Assert.assertTrue(imports.containsKey("_jOF40ATYEeKUpcpqfZ9tsA"));
		
		List<String> imps = imports.get("_jOF40ATYEeKUpcpqfZ9tsA");
		Assert.assertNotNull(imps);
		Assert.assertEquals(11, imps.size());
	}
	
	@Test
	public void testImportExtractionAndInclusionPreservingStyleAndHandleRename() {
		// preserve the generated file content (note: will be overridden by 'line content preserve')
		Path file = Paths.get("testfiles/importPreserver/styledimportsgen/RenamedRevisionControlSystemFinder.java");
		preserve(file);
		
		testImportExtractionPreservingStyle();
		
		// switch base dir to emulate generated file contents
		ftw.setBaseDir("testfiles/importPreserver/styledimportsgen");
		ftw.walkFileTree();
		
		Assert.assertNotNull(ip.fileContent);
		Assert.assertEquals(134, ip.fileContent.size());
		
		// write original file content back
		dumpback(file);
	}
	
	@Test
	public void testNoImportsToPreserveOnlyGeneratedToAdd() {
		ftw.setBaseDir("testfiles/importPreserver/nopreserved");
		ftw.walkFileTree();
		
		Map<String, List<String>> imports = ip.getAllImports();
		
		Assert.assertNotNull(imports);
		Assert.assertEquals(0, imports.size());
		Assert.assertFalse(imports.containsKey("_ZACkSgD0EeK7ac-mrkJBDw"));
	}
	
	@Test
	public void testNoImportsToPreserveOnlyGeneratedToAddInclusion() {
		// preserve the generated file content (note: will be overridden by 'line content preserve')
		Path file = Paths.get("testfiles/importPreserver/nopreserved/FileTreeObserver.java");
		preserve(file);
		
		testNoImportsToPreserveOnlyGeneratedToAdd();
		
		// switch base dir to emulate generated file contents
		ftw.setBaseDir("testfiles/importPreserver/nopreservedgen");
		ftw.walkFileTree();
		
		Assert.assertNotNull(ip.fileContent);
		Assert.assertEquals(54, ip.fileContent.size());
		
		// write original file content back
		dumpback(file);
	}
	
	@Test
	public void testNoGeneratedImportsOnlyPreserved() {
		ftw.setBaseDir("testfiles/importPreserver/nogenerated");
		ftw.walkFileTree();
		
		Map<String, List<String>> imports = ip.getAllImports();
		
		Assert.assertNotNull(imports);
		Assert.assertEquals(1, imports.size());
		Assert.assertTrue(imports.containsKey("_bPxLoAS9EeKUpcpqfZ9tsA"));
		
		List<String> imps = imports.get("_bPxLoAS9EeKUpcpqfZ9tsA");
		Assert.assertNotNull(imps);
		Assert.assertEquals(4, imps.size());
	}
	
	@Test
	public void testNoGeneratedImportsOnlyPreservedInclusion() {
		// preserve the generated file content (note: will be overridden by 'line content preserve')
		Path file = Paths.get("testfiles/importPreserver/nogenerated/GitRcs.java");
		preserve(file);
		
		testNoGeneratedImportsOnlyPreserved();
		
		// switch base dir to emulate generated file contents
		ftw.setBaseDir("testfiles/importPreserver/nogeneratedgen");
		ftw.walkFileTree();
		
		Assert.assertNotNull(ip.fileContent);
		Assert.assertEquals(81, ip.fileContent.size());
		
		// write original file content back
		dumpback(file);
	}
}
