/**
 * 
 */
package org.genesez.mapping.type;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * @author pethu
 */
public class BasicMappingTest {
	
	private interface MExternalType {
		public String getName();
	}
	
	MExternalType externalMock;
	Boolean unique, ordered;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		TypeMapper.initTypeMapper("org/genesez/mapping/type/testmappings/TestMapping.xml");
		externalMock = EasyMock.createMock(MExternalType.class);
		// externalMock=GcoreFactory.eINSTANCE.createMExternal();
		//externalMock = EasyMock.createMock(MPrimitiveType.class);
		// externalMock = GcoreFactory.eINSTANCE.createMPrimitiveType();
		unique = true;
		ordered = false;
		// externalMock = createMock(MExternal.class);
		// externalMock = createMock(MPrimitiveType.class);
	}

	/**
	 * Test method for
	 * {@link org.genesez.platform.common.typemapping.TypeMapping#getMapping(org.genesez.metamodel.gcore.MType, java.lang.String)}.
	 */
	@Test
	public void getDefaultMapping() {
		// externalMock.setName("doesnotexist");
		EasyMock.expect(externalMock.getName()).andReturn("doesnotexist");
		EasyMock.replay(externalMock);
		Assert.assertEquals("doesnotexist", TypeMapping.mapExternalType(externalMock.getName()));
	}

	@Test
	public void getPrimitiveMapping() {
		// externalMock.setName("boolean");
		EasyMock.expect(externalMock.getName()).andReturn("boolean");
		EasyMock.replay(externalMock);
		Assert.assertEquals("boolean", TypeMapping.mapExternalType(externalMock.getName()));
	}

	@Test
	public void getPrimitiveContextMapping() {
		// externalMock.setName("int");
		EasyMock.expect(externalMock.getName()).andReturn("int");
		EasyMock.replay(externalMock);
		Assert.assertEquals("Integer", TypeMapping.mapExternalType(externalMock.getName(), "Wrapper"));
	}

	@Test
	public void getPrimitiveDestMapping() {
		// externalMock.setName("Boolean");
		EasyMock.expect(externalMock.getName()).andReturn("Boolean");
		EasyMock.replay(externalMock);
		Assert.assertEquals("boolean", TypeMapping.mapExternalType(externalMock.getName()));
	}

	@Test
	public void getExternalMapping() {
		// externalMock.setSpecification("Association");
		EasyMock.expect(externalMock.getName()).andReturn(
				"Association");
		EasyMock.replay(externalMock);
		Assert.assertEquals("Association", TypeMapping.mapExternalType(externalMock.getName()));
	}

	@Test
	public void getExternalContextMapping() {
		EasyMock.expect(externalMock.getName()).andReturn(
				"Association");
		EasyMock.replay(externalMock);
		Assert.assertEquals(
				"org.genesez.platform.java.umlsupport.associations.Association",
				TypeMapping.mapExternalType(externalMock.getName(), "Import"));
	}

	@Test
	public void getExternalDestMapping() {
		// externalMock.setSpecification("AssociationAC");
		EasyMock.expect(externalMock.getName()).andReturn(
				"AssociationAC");
		EasyMock.replay(externalMock);
		Assert.assertEquals("Assoc", TypeMapping.mapExternalType(externalMock.getName()));
	}

	@Test
	public void getMultiValueMapping() {
		Assert.assertEquals("Set", TypeMapping.mapMultiValuedType(unique, ordered));
	}

	@Test
	public void getMultiValueDefaultMapping() {
		unique = false;
		Assert.assertEquals("HashBag", TypeMapping.mapMultiValuedType(unique, ordered,
				"Implementation"));
	}

	@Test
	public void caseInsensitiveContext() {
		EasyMock.expect(externalMock.getName()).andReturn(
				"Association").times(2);
		EasyMock.replay(externalMock);
		Assert.assertSame(TypeMapping.mapExternalType(externalMock.getName(), "Import"), TypeMapping
				.mapExternalType(externalMock.getName(), "imPORT"));
	}
}
