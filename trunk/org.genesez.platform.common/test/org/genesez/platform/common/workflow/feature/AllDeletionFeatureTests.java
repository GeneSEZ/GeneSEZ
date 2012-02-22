package org.genesez.platform.common.workflow.feature;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DeletionFeatureTest.class, FileDeletionFeatureTest.class,
		FolderDeletionFeatureTest.class })
public class AllDeletionFeatureTests {

}
