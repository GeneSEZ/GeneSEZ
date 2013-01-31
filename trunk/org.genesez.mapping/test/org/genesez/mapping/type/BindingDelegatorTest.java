/**
 * 
 */
package org.genesez.mapping.type;

import org.genesez.mapping.type.types.FileContainer;


/**
 * @author pethu
 */
public class BindingDelegatorTest {

	BindingDelegator bd = null;
	static final String contextPath = "org.genesez.platform.common.typemapping.types";

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
		assertNull(bd
				.getMappingBody("org/genesez/platform/common/typemapping/testmappings/invalidFile.xml"));
	}

	@Test
	public void getValidMappingBody() {
		assertNotNull(bd
				.getMappingBody("org/genesez/platform/common/typemapping/testmappings/TestMapping.xml"));
	}

	/**
	 * Test method for
	 * {@link org.genesez.platform.common.typemapping.BindingDelegator#getFileContainerByXPath(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void getFileContainerViaXPath() {
		assert bd.getFileContainerByXPath(
				"org/genesez/platform/common/typemapping/testmappings/TestMapping.xml",
				"//tns:include") instanceof FileContainer;
	}

	@Test
	public void getNoFileContainerViaXPath() {
		assertNull(bd.getFileContainerByXPath(
				"org/genesez/platform/common/typemapping/testmappings/primitiveTest.xml",
				"//tns:include"));
	}

	@Test
	public void useWrongXPath() {
		assertNull(bd.getFileContainerByXPath(
				"org/genesez/platform/common/typemapping/testmappings/AdditionalMappings.xml",
				"//tns:primitiveTypes"));
	}

	@Test
	public void getFileContainerWithoutNamespace() {
		assertNull(bd.getFileContainerByXPath(
				"org/genesez/platform/common/typemapping/testmappings/TestMapping.xml",
				"//inlcude"));
	}

}
