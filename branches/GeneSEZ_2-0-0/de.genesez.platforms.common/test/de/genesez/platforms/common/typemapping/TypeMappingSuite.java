/**
 * 
 */
package de.genesez.platforms.common.typemapping;

/**
 * @author pethu
 */
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses( { BasicMappingTest.class, FileCollectorTest.class,
		FileReferencingTest.class, BindingDelegatorTest.class,
		MappingManagerTest.class })
public class TypeMappingSuite {

}
