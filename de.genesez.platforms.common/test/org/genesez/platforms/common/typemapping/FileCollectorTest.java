/**
 * 
 */
package org.genesez.platforms.common.typemapping;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashSet;

import org.genesez.platforms.common.typemapping.BindingDelegator;
import org.genesez.platforms.common.typemapping.MappingFileCollector;
import org.junit.Before;
import org.junit.Test;

/**
 * @author pethu
 */
public class FileCollectorTest {

	/**
	 * @throws java.lang.Exception
	 */
	BindingDelegator bd = null;
	static final String contextPath = "org.genesez.platforms.common.typemapping.types";
	MappingFileCollector mfc = null;

	@Before
	public void setUp() throws Exception {
		bd = new BindingDelegator(contextPath);
		mfc = new MappingFileCollector(bd);
	}

	/**
	 * Test method for
	 * {@link org.genesez.platforms.common.typemapping.MappingFileCollector#getMappingFiles(java.lang.String)}.
	 */
	@Test
	public void noInputFile() {
		assertEquals(new LinkedHashSet<String>(), mfc
				.getMappingFiles("nofile.xml"));
	}

	@Test
	public void NonInclude() {
		LinkedHashSet<String> set = new LinkedHashSet<String>();
		set.add("org/genesez/platforms/common/typemapping/testmappings/externalTest.xml");
		assertEquals(
				set,
				mfc
						.getMappingFiles("org/genesez/platforms/common/typemapping/testmappings/externalTest.xml"));
	}

	@Test
	public void SingleInclude() {
		LinkedHashSet<String> set = new LinkedHashSet<String>();
		set.add("org/genesez/platforms/common/typemapping/testmappings/AdditionalMappings.xml");
		assertEquals(
				set,
				mfc
						.getMappingFiles("org/genesez/platforms/common/typemapping/testmappings/AdditionalMappings.xml"));
	}

	@Test
	public void MultiInclude() {
		LinkedHashSet<String> set = new LinkedHashSet<String>();
		set.add("org/genesez/platforms/common/typemapping/testmappings/TestMapping.xml");
		set.add("org/genesez/platforms/common/typemapping/testmappings/multivaluedTest.xml");
		set.add("org/genesez/platforms/common/typemapping/testmappings/primitiveTest.xml");
		set.add("org/genesez/platforms/common/typemapping/testmappings/externalTest.xml");
		assertEquals(
				set,
				mfc
						.getMappingFiles("org/genesez/platforms/common/typemapping/testmappings/TestMapping.xml"));
	}
}
