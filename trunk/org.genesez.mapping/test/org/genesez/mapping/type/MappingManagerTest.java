/**
 * 
 */
package org.genesez.mapping.type;

import org.genesez.mapping.type.types.MultiValuedType;
import org.genesez.mapping.type.types.SingleValuedType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
	static final String contextPath = "org.genesez.mapping.type.types";

	@Before
	public void setUp() throws Exception {
		bd = new BindingDelegator(contextPath);
		tmm = new TypeMappingManager<SingleValuedType>();
		cmm = new CollectionMappingManager<MultiValuedType>();
	}

	@Test
	public void getCollectionMapping() {
		cmm.appendTypeMappingMap(bd.getMappingBody(
				"org/genesez/mapping/type/testmappings/multivaluedTest.xml")
				.getMultiValuedTypes().getMappingList());
		Assert.assertEquals("Set", cmm.getTypeMapping(Boolean.TRUE.toString()
				+ Boolean.TRUE.toString(), null));
	}

	@Test
	public void getSingleValuedMapping() {
		tmm.appendTypeMappingMap(bd.getMappingBody(
				"org/genesez/mapping/type/testmappings/primitiveTest.xml")
				.getExternalTypes().getMappingList());
		Assert.assertEquals("Integer", tmm.getTypeMapping("int", "Wrapper"));
	}
}
