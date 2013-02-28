/**
 * 
 */
package org.genesez.platform.common.typemapping;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.easymock.EasyMock;
import org.genesez.platform.common.typemapping.TypeMapper;
import org.genesez.platform.common.typemapping.TypeMapping;
import org.junit.Before;
import org.junit.Test;

import org.genesez.metamodel.gcore.MExternal;
import org.genesez.metamodel.gcore.MPrimitiveType;

/**
 * @author pethu
 */
public class BasicMappingTest {
	MExternal externalMock;
	MPrimitiveType primitiveMock;
	Boolean unique, ordered;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		TypeMapper.initTypeMapper("org/genesez/platform/common/typemapping/testmappings/TestMapping.xml");
		externalMock = EasyMock.createMock(MExternal.class);
		// externalMock=GcoreFactory.eINSTANCE.createMExternal();
		primitiveMock = EasyMock.createMock(MPrimitiveType.class);
		// primitiveMock = GcoreFactory.eINSTANCE.createMPrimitiveType();
		unique = true;
		ordered = false;
		// externalMock = createMock(MExternal.class);
		// primitiveMock = createMock(MPrimitiveType.class);
	}

	/**
	 * Test method for
	 * {@link org.genesez.platform.common.typemapping.TypeMapping#getMapping(org.genesez.metamodel.gcore.MType, java.lang.String)}.
	 */
	@Test
	public void getDefaultMapping() {
		// primitiveMock.setName("doesnotexist");
		EasyMock.expect(primitiveMock.getName()).andReturn("doesnotexist");
		EasyMock.replay(primitiveMock);
		assertEquals("doesnotexist", TypeMapping.mappingName(primitiveMock));
	}

	@Test
	public void getPrimitiveMapping() {
		// primitiveMock.setName("boolean");
		EasyMock.expect(primitiveMock.getName()).andReturn("boolean");
		EasyMock.replay(primitiveMock);
		assertEquals("boolean", TypeMapping.mappingName(primitiveMock));
	}

	@Test
	public void getPrimitiveContextMapping() {
		// primitiveMock.setName("int");
		EasyMock.expect(primitiveMock.getName()).andReturn("int");
		EasyMock.replay(primitiveMock);
		assertEquals("Integer", TypeMapping.mappingName(primitiveMock,
				"Wrapper"));
	}

	@Test
	public void getPrimitiveDestMapping() {
		// primitiveMock.setName("Boolean");
		EasyMock.expect(primitiveMock.getName()).andReturn("Boolean");
		EasyMock.replay(primitiveMock);
		assertEquals("boolean", TypeMapping.mappingName(primitiveMock));
	}

	@Test
	public void getExternalMapping() {
		// externalMock.setSpecification("Association");
		EasyMock.expect(externalMock.getSpecification()).andReturn(
				"Association");
		EasyMock.replay(externalMock);
		assertEquals("Association", TypeMapping.mappingName(externalMock));
	}

	@Test
	public void getExternalContextMapping() {
		EasyMock.expect(externalMock.getSpecification()).andReturn(
				"Association");
		EasyMock.replay(externalMock);
		assertEquals(
				"org.genesez.platform.java.umlsupport.associations.Association",
				TypeMapping.mappingName(externalMock, "Import"));
	}

	@Test
	public void getExternalDestMapping() {
		// externalMock.setSpecification("AssociationAC");
		EasyMock.expect(externalMock.getSpecification()).andReturn(
				"AssociationAC");
		EasyMock.replay(externalMock);
		assertEquals("Assoc", TypeMapping.mappingName(externalMock));
	}

	@Test
	public void getMultiValueMapping() {
		assertEquals("Set", TypeMapping.mappingType(unique, ordered));
	}

	@Test
	public void getMultiValueDefaultMapping() {
		unique = false;
		assertEquals("HashBag", TypeMapping.mappingType(unique, ordered,
				"Implementation"));
	}

	@Test
	public void caseInsensitiveContext() {
		EasyMock.expect(externalMock.getSpecification()).andReturn(
				"Association").times(2);
		EasyMock.replay(externalMock);
		assertSame(TypeMapping.mappingName(externalMock, "Import"), TypeMapping
				.mappingName(externalMock, "imPORT"));
	}

}
