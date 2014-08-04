package org.genesez.test.vm;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.mwe2.runtime.workflow.Workflow;
import org.eclipse.emf.mwe2.runtime.workflow.WorkflowContextImpl;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Model;
import org.eclipse.xtend.XtendFacade;
import org.eclipse.xtend.typesystem.MetaModel;
import org.eclipse.xtend.typesystem.emf.XmiReader;
import org.eclipse.xtend.typesystem.uml2.Setup;
import org.eclipse.xtend.typesystem.uml2.UML2MetaModel;
import org.genesez.adapter.ea.Model2UML;
import org.genesez.adapter.ea.ProfileReader;
import org.genesez.adapter.ea.RepositoryReader;
import org.genesez.adapter.ea.XmiWriter;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class TransformTest {

	private final Logger LOG = Logger.getLogger(TransformTest.class);

	private static final String TEST_DIRECTORY = "src/test/resources";
	private static final String MODEL_NAME = "Validierungsmodell Radar";
	private final String MODEL_FILE = "VM.EAP";

	public static final String MODEL_FILE_WITH_PATH = TEST_DIRECTORY 
			+ File.separator + MODEL_NAME +  ".export.uml";

	private Workflow workflow = new Workflow();
	private final String MODEL_SLOT = "org_genesez_adapter_ea_ea_model";
	private final String MODEL_UML_SLOT = "org_genesez_adapter_ea_uml_model";

	private File transformedModelFile = null;
	private Model model = null;
	private XtendFacade facade = null;
	private MetaModel metaModel = new UML2MetaModel();

	private static TransformTest instance = new TransformTest();

	private TransformTest() {
		readModel();
		createFacade();
	}

	public static TransformTest getInstance() {
		return instance;
	}

	public Model readModel() {
		// reader
		XmiReader xmiReader = new XmiReader();
		xmiReader.setOutputSlot(MODEL_UML_SLOT);
		xmiReader.setModelFile(TEST_DIRECTORY + "/" + MODEL_NAME
				+ ".export.uml");
		WorkflowContextImpl wc = new WorkflowContextImpl();
		xmiReader.invoke(wc);
		this.model = (Model) wc.get(MODEL_UML_SLOT);
		return model;
	}

	@BeforeTest
	public void beforeTest() {
		// initialize first
		Setup setup = new Setup();
		setup.setStandardUML2Setup(true);
		this.workflow.addBean(setup);

		initializeRepositoryReader();
		initializeProfileReader();
		initializeModel2UML();
		initializeXmiWriter();

		WorkflowContextImpl wc = new WorkflowContextImpl();
		// run workflow
		this.workflow.run(wc);
		this.model = (Model) wc.get(MODEL_UML_SLOT);

		if (this.model == null) {
			throw new RuntimeException("Model is NULL");
		} else {
			LOG.info("name of the model:\t" + model.getName());
		}
		createFacade();
	}

	private void createFacade() {
		// register facade and meta model
		facade = XtendFacade.create("emfSearch");
		facade.registerMetaModel(metaModel);
	}

	private void initializeRepositoryReader() {
		RepositoryReader reader = new RepositoryReader();
		reader.setModelName(MODEL_NAME);
		reader.setRepositoryFile(TEST_DIRECTORY + File.separator + MODEL_FILE);
		reader.setOutputSlot(MODEL_SLOT);
		workflow.addComponent(reader);
	}

	private void initializeProfileReader() {
		ProfileReader reader = new ProfileReader();
		reader.setProfileExtension(".profile.uml");
		reader.setProfileDirectory(TEST_DIRECTORY);
		reader.addProfile("stereotype");
		workflow.addComponent(reader);
	}

	private void initializeModel2UML() {
		Model2UML model2uml = new Model2UML();
		model2uml.setInputSlot(MODEL_SLOT);
		model2uml.setOutputSlot(MODEL_UML_SLOT);
		workflow.addComponent(model2uml);
	}

	private void initializeXmiWriter() {
		XmiWriter writer = new XmiWriter();
		writer.setInputSlot(MODEL_UML_SLOT);
		writer.setResourceSlot(MODEL_SLOT);
		writer.setXmiFile(TEST_DIRECTORY + "/" + MODEL_NAME + ".export.uml");
		workflow.addComponent(writer);
	}

	public List<Component> getAllComponents() {
		Object val[] = new Object[1];
		val[0] = this.model;
		@SuppressWarnings("unchecked")
		List<Component> componentList = (ArrayList<Component>) facade.call(
				"allComponents", val);
		return componentList;
	}

	@Test()
	public void repositoryReaderTest() {
		this.model = readModel();
		Assert.assertNotNull(this.model);
	}

	@Test(groups = { "initial" })
	public void transformCompleteTest() {
		transformedModelFile = new File(MODEL_FILE_WITH_PATH);
		Assert.assertEquals(transformedModelFile.exists(), true);
	}

}
