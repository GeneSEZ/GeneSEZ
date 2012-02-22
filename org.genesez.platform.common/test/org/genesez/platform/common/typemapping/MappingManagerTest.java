/**
 * 
 */
package org.genesez.platform.common.typemapping;

import junit.framework.Assert;

import org.genesez.platform.common.typemapping.BindingDelegator;
import org.genesez.platform.common.typemapping.CollectionMappingManager;
import org.genesez.platform.common.typemapping.ITypeMappingManager;
import org.genesez.platform.common.typemapping.TypeMappingManager;
import org.genesez.platform.common.typemapping.types.MultiValuedType;
import org.genesez.platform.common.typemapping.types.SingleValuedType;
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
	static final String contextPath = "org.genesez.platform.common.typemapping.types";

	@Before
	public void setUp() throws Exception {
		bd = new BindingDelegator(contextPath);
		tmm = new TypeMappingManager<SingleValuedType>();
		cmm = new CollectionMappingManager<MultiValuedType>();
	}

	@Test
	public void getCollectionMapping() {
		cmm.appendMappingMap(bd.getMappingBody(
				"org/genesez/platform/common/typemapping/testmappings/multivaluedTest.xml")
				.getMultiValuedTypes().getMappingList());
		Assert.assertEquals("Set", cmm.getTypeMapping(Boolean.TRUE.toString()
				+ Boolean.TRUE.toString(), null));
	}

	@Test
	public void getSingleValuedMapping() {
		tmm.appendMappingMap(bd.getMappingBody(
				"org/genesez/platform/common/typemapping/testmappings/primitiveTest.xml")
				.getPrimitiveTypes().getMappingList());
		Assert.assertEquals("Integer", tmm.getTypeMapping("int", "Wrapper"));
	}

}
