/**
 * 
 */
package org.genesez.platforms.common.typemapping;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.genesez.platforms.common.typemapping.BindingDelegator;
import org.genesez.platforms.common.typemapping.types.FileContainer;
import org.junit.Before;
import org.junit.Test;


/**
 * @author pethu
 */
public class BindingDelegatorTest {

	BindingDelegator bd = null;
	static final String contextPath = "de.genesez.platforms.common.typemapping.types";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		bd = new BindingDelegator(contextPath);
	}

	/**
	 * Test method for
	 * {@link org.genesez.platforms.common.typemapping.BindingDelegator#getMappingBody(java.lang.String)}.
	 */
	@Test
	public void getInvalidMappingBody() {
		assertNull(bd
				.getMappingBody("org/genesez/platforms/common/typemapping/testmappings/invalidFile.xml"));
	}

	@Test
	public void getValidMappingBody() {
		assertNotNull(bd
				.getMappingBody("org/genesez/platforms/common/typemapping/testmappings/TestMapping.xml"));
	}

	/**
	 * Test method for
	 * {@link org.genesez.platforms.common.typemapping.BindingDelegator#getFileContainerByXPath(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void getFileContainerViaXPath() {
		assert bd.getFileContainerByXPath(
				"org/genesez/platforms/common/typemapping/testmappings/TestMapping.xml",
				"//tns:include") instanceof FileContainer;
	}

	@Test
	public void getNoFileContainerViaXPath() {
		assertNull(bd.getFileContainerByXPath(
				"org/genesez/platforms/common/typemapping/testmappings/primitiveTest.xml",
				"//tns:include"));
	}

	@Test
	public void useWrongXPath() {
		assertNull(bd.getFileContainerByXPath(
				"org/genesez/platforms/common/typemapping/testmappings/AdditionalMappings.xml",
				"//tns:primitiveTypes"));
	}

	@Test
	public void getFileContainerWithoutNamespace() {
		assertNull(bd.getFileContainerByXPath(
				"org/genesez/platforms/common/typemapping/testmappings/TestMapping.xml",
				"//inlcude"));
	}

}
