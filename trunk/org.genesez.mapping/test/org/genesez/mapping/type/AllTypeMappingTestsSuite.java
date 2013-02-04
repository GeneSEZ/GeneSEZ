
package org.genesez.mapping.type;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author pethu
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( { BasicMappingTest.class, FileCollectorTest.class,
		FileReferencingTest.class, BindingDelegatorTest.class,
		MappingManagerTest.class })
public class AllTypeMappingTestsSuite {

}
