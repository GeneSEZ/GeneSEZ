/**
 * 
 */
package de.genesez.platforms.common.typemapping;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import de.genesez.platforms.common.typemapping.types.MultiValuedType;
import de.genesez.platforms.common.typemapping.types.SingleValuedType;

/**
 * @author pethu
 */
public class MappingManagerTest {

	/**
	 * @throws java.lang.Exception
	 */
	ITypeMappingManager<SingleValuedType> tmm = null;
	ITypeMappingManager<MultiValuedType> cmm = null;
	BindingDelegator bd = null;
	static final String contextPath = "de.genesez.platforms.common.typemapping.types";

	@Before
	public void setUp() throws Exception {
		bd = new BindingDelegator(contextPath);
		tmm = new TypeMappingManager<SingleValuedType>();
		cmm = new CollectionMappingManager<MultiValuedType>();
	}

	@Test
	public void getCollectionMapping() {
		cmm.appendMappingMap(bd.getMappingBody(
				"de/genesez/platforms/common/typemapping/testmappings/multivaluedTest.xml")
				.getMultiValuedTypes().getMappingList());
		Assert.assertEquals("Set", cmm.getTypeMapping(Boolean.TRUE.toString()
				+ Boolean.TRUE.toString(), null));
	}

	@Test
	public void getSingleValuedMapping() {
		tmm.appendMappingMap(bd.getMappingBody(
				"de/genesez/platforms/common/typemapping/testmappings/primitiveTest.xml")
				.getPrimitiveTypes().getMappingList());
		Assert.assertEquals("Integer", tmm.getTypeMapping("int", "Wrapper"));
	}

}
