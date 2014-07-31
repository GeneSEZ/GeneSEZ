/**
 * 
 */
package org.genesez.mapping.type;

import org.junit.Assert;

import org.genesez.mapping.type.types.FileContainer;
import org.junit.Before;
import org.junit.Test;


/**
 * @author pethu
 */
public class BindingDelegatorTest {

	BindingDelegator bd = null;
	static final String contextPath = "org.genesez.mapping.type.types";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		bd = new BindingDelegator(contextPath);
	}

	/**
	 * Test method for
	 * {@link org.genesez.platform.common.typemapping.BindingDelegator#getMappingBody(java.lang.String)}.
	 */
	@Test
	public void getInvalidMappingBody() {
		Assert.assertNull(bd
				.getMappingBody("org/genesez/mapping/type/testmappings/invalidFile.xml"));
	}

	@Test
	public void getValidMappingBody() {
		Assert.assertNotNull(bd
				.getMappingBody("org/genesez/mapping/type/testmappings/TestMapping.xml"));
	}

	/**
	 * Test method for
	 * {@link org.genesez.platform.common.typemapping.BindingDelegator#getFileContainerByXPath(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void getFileContainerViaXPath() {
		assert bd.getFileContainerByXPath(
				"org/genesez/mapping/type/testmappings/TestMapping.xml",
				"//tns:include") instanceof FileContainer;
	}

	@Test
	public void getNoFileContainerViaXPath() {
		Assert.assertNull(bd.getFileContainerByXPath(
				"org/genesez/mapping/type/testmappings/primitiveTest.xml",
				"//tns:include"));
	}

	@Test
	public void useWrongXPath() {
		Assert.assertNull(bd.getFileContainerByXPath(
				"org/genesez/mapping/type/testmappings/AdditionalMappings.xml",
				"//tns:primitiveTypes"));
	}

	@Test
	public void getFileContainerWithoutNamespace() {
		Assert.assertNull(bd.getFileContainerByXPath(
				"org/genesez/mapping/type/testmappings/TestMapping.xml",
				"//inlcude"));
	}
}
