package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.UMLFactory;

import de.genesez.adapter.ea.PostProcessor;
import de.genesez.adapter.ea.XmiFile;

public class ControlFlowTransformer {

	private static final Log log = LogFactory.getLog(ControlFlowTransformer.class);
	private ControlFlow controlFlow;
	
	ControlFlow transform(org.sparx.Connector _c, Activity _parent) {
		log.debug("Creating ControlFlow " + _c.GetName() + ", parent " + _parent.getName());
		this.controlFlow = UMLFactory.eINSTANCE.createControlFlow();
		this.controlFlow.setActivity(_parent);
		this.controlFlow.setName(_c.GetName());
		XmiFile.instance.addElement(this.controlFlow, _c.GetConnectorGUID());
		return this.controlFlow;
	}

}
