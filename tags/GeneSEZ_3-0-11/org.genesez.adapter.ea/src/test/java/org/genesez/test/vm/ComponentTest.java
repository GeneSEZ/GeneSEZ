package org.genesez.test.vm;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.uml2.uml.Component;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ComponentTest {
	
	private final int COMPONENT_COUNT = 23;
	private final int COMPONENT_INSTANCE_COUNT = 9;
	
	private List<Component> componentList = null;
	private List<Component> componentInstanceList = new ArrayList<Component>();
	
	@BeforeTest
	public void readModel(){
		this.componentList = TransformTest.getInstance().getAllComponents();
	}	
	
	@Test(groups = { "initial" })
	public void modelFileExistsTest() {
		File transformedModelFile = new File(TransformTest.MODEL_FILE_WITH_PATH);
		Assert.assertEquals(transformedModelFile.exists(), true);
	}

	@Test(dependsOnMethods = { "modelFileExistsTest" })
	public void countComponentsTest() {
		Assert.assertEquals(componentList.size(), COMPONENT_COUNT);
	}

	@Test(dependsOnMethods = { "modelFileExistsTest" })
	public void countComponentInstancesTest() {
		for (Component c : componentList) {
			if (!c.isIndirectlyInstantiated()) {
				componentInstanceList.add(c);
			}
		}
		Assert.assertEquals(componentInstanceList.size(), COMPONENT_INSTANCE_COUNT);
	}
	
	@Test(dependsOnMethods={"countComponentInstancesTest"})
	public void checkComponentName(){
		for(Component c: componentInstanceList){
			Assert.assertEquals(c.getName().contains(c.getName()), true);
		}
	}
	
}
