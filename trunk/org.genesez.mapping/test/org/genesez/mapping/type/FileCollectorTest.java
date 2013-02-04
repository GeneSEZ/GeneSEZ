/**
 * 
 */
package org.genesez.mapping.type;

import java.util.LinkedHashSet;

import org.junit.Assert;

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
	static final String contextPath = "org.genesez.mapping.type.types";
	MappingFileCollector mfc = null;

	@Before
	public void setUp() throws Exception {
		bd = new BindingDelegator(contextPath);
		mfc = new MappingFileCollector(bd);
	}

	/**
	 * Test method for
	 * {@link org.genesez.platform.common.typemapping.MappingFileCollector#getMappingFiles(java.lang.String)}.
	 */
	@Test
	public void noInputFile() {
		Assert.assertEquals(new LinkedHashSet<String>(), mfc
				.getMappingFiles("nofile.xml"));
	}

	@Test
	public void NonInclude() {
		LinkedHashSet<String> set = new LinkedHashSet<String>();
		set.add("org/genesez/mapping/type/testmappings/externalTest.xml");
		Assert.assertEquals(
				set,
				mfc
						.getMappingFiles("org/genesez/mapping/type/testmappings/externalTest.xml"));
	}

	@Test
	public void SingleInclude() {
		LinkedHashSet<String> set = new LinkedHashSet<String>();
		set.add("org/genesez/mapping/type/testmappings/AdditionalMappings.xml");
		Assert.assertEquals(
				set,
				mfc
						.getMappingFiles("org/genesez/mapping/type/testmappings/AdditionalMappings.xml"));
	}

	@Test
	public void MultiInclude() {
		LinkedHashSet<String> set = new LinkedHashSet<String>();
		set.add("org/genesez/mapping/type/testmappings/TestMapping.xml");
		set.add("org/genesez/mapping/type/testmappings/multivaluedTest.xml");
		set.add("org/genesez/mapping/type/testmappings/primitiveTest.xml");
		set.add("org/genesez/mapping/type/testmappings/externalTest.xml");
		Assert.assertEquals(
				set,
				mfc
						.getMappingFiles("org/genesez/mapping/type/testmappings/TestMapping.xml"));
	}
}
