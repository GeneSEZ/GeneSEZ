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
public class FileReferencingTest {

	private interface MExternalType {
		String getName();
	}
	
	UnitTypeMapper utm = null;
	MExternalType externalMock = null;
	MExternalType externalMock2 = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		externalMock = EasyMock.createMock(MExternalType.class);
		externalMock2 = EasyMock.createMock(MExternalType.class);
	}

	@Test
	public void NoFileFound() {
		utm = new UnitTypeMapper("nofile.xml");
		Assert.assertEquals("", utm.mapMultiValuedType(true, true, "Implementation"));
	}

	@Test
	public void singleInput() {
		utm = new UnitTypeMapper(
				"org/genesez/mapping/type/testmappings/TestMapping.xml");
		Assert.assertEquals("LinkedHashSet", utm.mapMultiValuedType(true, true, "Implementation"));
	}

	@Test
	public void multipleInput() {
		utm = new UnitTypeMapper(
				"org/genesez/mapping/type/testmappings/multivaluedTest.xml",
				"org/genesez/mapping/type/testmappings/externalTest.xml",
				"org/genesez/mapping/type/testmappings/primitiveTest.xml");
		Assert.assertEquals("LinkedHashSet", utm.mapMultiValuedType(true, true, "Implementation"));
	}

	@Test
	public void appendedMappings() {
		EasyMock.expect(externalMock.getName()).andReturn("umlType");
		EasyMock.replay(externalMock);
		utm = new UnitTypeMapper(
				"org/genesez/mapping/type/testmappings/primitiveTest.xml",
				"org/genesez/mapping/type/testmappings/AdditionalMappings.xml");
		Assert.assertEquals("javaType", utm.mapExternalType(externalMock.getName()));
	}

	@Test
	public void NotOverwriteMappings() {
		EasyMock.expect(externalMock.getName()).andReturn("boolean");
		EasyMock.replay(externalMock);
		utm = new UnitTypeMapper(
				"org/genesez/mapping/type/testmappings/AdditionalMappings.xml",
				"org/genesez/mapping/type/testmappings/primitiveTest.xml");
		Assert.assertEquals("BOOL", utm.mapExternalType(externalMock.getName()));
	}

	@Test
	public void circularMappings() {
		EasyMock.expect(externalMock.getName()).andReturn("circle");
		EasyMock.replay(externalMock);
		EasyMock.expect(externalMock2.getName()).andReturn("cube");
		EasyMock.replay(externalMock2);
		utm = new UnitTypeMapper(
				"org/genesez/mapping/type/testmappings/circularReference1.xml");
		Assert.assertEquals("ellipse", utm.mapExternalType(externalMock.getName()));
		Assert.assertEquals("hypercube", utm.mapExternalType(externalMock2.getName()));
	}
}
