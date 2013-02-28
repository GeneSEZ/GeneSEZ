/**
 * 
 */
package de.genesez.platforms.common.typemapping;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import de.genesez.metamodel.gcore.MPrimitiveType;

/**
 * @author pethu
 */
public class FileReferencingTest {

	UnitTypeMapper utm = null;
	MPrimitiveType primitiveMock = null;
	MPrimitiveType primitiveMock2 = null;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		primitiveMock = EasyMock.createMock(MPrimitiveType.class);
		primitiveMock2 = EasyMock.createMock(MPrimitiveType.class);
	}

	@Test
	public void NoFileFound() {
		utm = new UnitTypeMapper("nofile.xml");
		assertEquals("", utm.getMappingType(true, true, "Implementation"));
	}

	@Test
	public void singleInput() {
		utm = new UnitTypeMapper(
				"de/genesez/platforms/common/typemapping/testmappings/TestMapping.xml");
		assertEquals("LinkedHashSet", utm.getMappingType(true, true,
				"Implementation"));
	}

	@Test
	public void multipleInput() {
		utm = new UnitTypeMapper(
				"de/genesez/platforms/common/typemapping/testmappings/multivaluedTest.xml",
				"de/genesez/platforms/common/typemapping/testmappings/externalTest.xml",
				"de/genesez/platforms/common/typemapping/testmappings/primitiveTest.xml");
		assertEquals("LinkedHashSet", utm.getMappingType(true, true,
				"Implementation"));
	}

	@Test
	public void appendedMappings() {
		EasyMock.expect(primitiveMock.getName()).andReturn("umlType");
		EasyMock.replay(primitiveMock);
		utm = new UnitTypeMapper(
				"de/genesez/platforms/common/typemapping/testmappings/primitiveTest.xml",
				"de/genesez/platforms/common/typemapping/testmappings/AdditionalMappings.xml");
		assertEquals("javaType", utm.getMappingName(primitiveMock));
	}

	@Test
	public void NotOverwriteMappings() {
		EasyMock.expect(primitiveMock.getName()).andReturn("boolean");
		EasyMock.replay(primitiveMock);
		utm = new UnitTypeMapper(
				"de/genesez/platforms/common/typemapping/testmappings/AdditionalMappings.xml",
				"de/genesez/platforms/common/typemapping/testmappings/primitiveTest.xml");
		assertEquals("BOOL", utm.getMappingName(primitiveMock));
	}

	@Test
	public void circularMappings() {
		EasyMock.expect(primitiveMock.getName()).andReturn("circle");
		EasyMock.replay(primitiveMock);
		EasyMock.expect(primitiveMock2.getName()).andReturn("cube");
		EasyMock.replay(primitiveMock2);
		utm = new UnitTypeMapper(
				"de/genesez/platforms/common/typemapping/testmappings/circularReference1.xml");
		assertEquals("ellipse", utm.getMappingName(primitiveMock));
		assertEquals("hypercube", utm.getMappingName(primitiveMock2));
	}
}
