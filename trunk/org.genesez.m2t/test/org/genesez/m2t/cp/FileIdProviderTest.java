package org.genesez.m2t.cp;

import java.util.ArrayList;
import java.util.List;

import org.genesez.m2t.FileTreeWalker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the file id provider with the following constraints:
 * - only one file id per file is provided
 * - if a file contains multiple file id's the first found is provided
 * - if a file does not contain any file id, null is provided
 * 
 * @author tobias haubold <toh@fh-zwickau.de>
 */
public class FileIdProviderTest {
	
	private FileTreeWalker ftw;
	private LineContentPreserve lcp;
	private FileIdListProvider fip;
	
	private class FileIdListProvider extends FileIdProvider {
		public List<String> fileIds = new ArrayList<>();
		
		@Override
		public void finished(boolean file) {
			// save file id before
			if (file) {
				fileIds.add(getFileId());
			}
			// delegate to base class
			super.finished(file);
		}
	}
	
	@Before
	public void setUp() throws Exception {
		ftw = new FileTreeWalker();
		
		lcp = new LineContentPreserve();
		ftw.addObserver(lcp);
		
		fip = new FileIdListProvider();
		lcp.preservable().insert(fip);
	}
	
	@Test
	public void testFileIdFound() {
		ftw.setBaseDir("testfiles/fileId/one");
		ftw.walkFileTree();
		
		Assert.assertNotNull( fip.fileIds );
		Assert.assertEquals(1, fip.fileIds.size());
		Assert.assertEquals("_8oUToAm-EeK7rvpt4qDtAg", fip.fileIds.get(0));
	}
	
	@Test
	public void testMultipleFileIds() {
		ftw.setBaseDir("testfiles/fileId/multiple");
		ftw.walkFileTree();
		
		Assert.assertNotNull( fip.fileIds );
		Assert.assertEquals(2, fip.fileIds.size());
		Assert.assertEquals("_8oUToAm-EeK7rvpt4qDtAg", fip.fileIds.get(0));
		Assert.assertEquals("123", fip.fileIds.get(1));
	}
	
	@Test
	public void testFilesWithoutFileId() {
		ftw.setBaseDir("testfiles/fileId/without");
		ftw.walkFileTree();
		
		Assert.assertNotNull( fip.fileIds );
		Assert.assertEquals(3, fip.fileIds.size());
		Assert.assertEquals(null, fip.fileIds.get(0));
		Assert.assertEquals("_8oUToAm-EeK7rvpt4qDtAg", fip.fileIds.get(1));
		Assert.assertEquals("123", fip.fileIds.get(2));
	}
}
