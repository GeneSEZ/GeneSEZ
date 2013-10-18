package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_1_df50335_1381922309548_908585_3655) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;
import org.genesez.adapter.ea.PostProcessor;
import org.genesez.adapter.ea.ResourceRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author Christian
 */
public class OperationTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(OperationTransformer.class);
	
	public static final OperationTransformer INSTANCE = new OperationTransformer();
	
	private Operation operation;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>OperationTransformer</b></em>'.
	 */
	private OperationTransformer() {
		/* PROTECTED REGION ID(java.constructor._17_0_4_1_df50335_1381924058692_701444_3750) ENABLED START */
		// :)
		
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public Operation transform(org.sparx.Method method) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_1_df50335_1381922317192_445700_3675) ENABLED START */
		LOG.debug("Transforming method " + method.GetName() + ", type: " + method.GetReturnType());
		
		operation = UMLFactory.eINSTANCE.createOperation();
		operation.setName(method.GetName());
		
		// do notes on method
		if (method.GetNotes().length() != 0) {
			operation.createOwnedComment().setBody(method.GetNotes());
		}
		
		// TODO for development
		ElementDebugger.INSTANCE.printMethod(method);
		
		// transform parameters
		for (org.sparx.Parameter parameter : method.GetParameters()) {
			transform(parameter);
		}
		
		// set the return type
		final String returnType = method.GetReturnType();
		if (returnType.length() != 0) {
			if (returnType.equals("Integer") || returnType.equals("Boolean") || returnType.equals("String")) {
				LOG.debug("Creating primitve return type -> " + returnType);
				operation.createReturnResult(null, ResourceRegistry.INSTANCE.importPrimitiveType(returnType));
			} else {
				LOG.debug("return type not known yet type(" + returnType + ") putting to postprocessor elements");
				// TODO implement this
			}
			
		}
		
		// set the visibility
		this.operation.setVisibility(VisibilityTransformer.INSTANCE.getVisibilityKind(method));
		
		return operation;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	private Parameter transform(org.sparx.Parameter parameter) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_1_df50335_1381922555264_212259_3690) ENABLED START */
		Parameter umlParameter = null;
		
		// find classifier id
		final int classiefierId = Integer.valueOf(parameter.GetClassifierID());
		
		// check if parameter is an internal element
		if (classiefierId != 0) {
			LOG.debug("type is an class or element of the model with classifierID -> " + classiefierId + " in operation -> " + this.operation.getName());
			Classifier classifier = (Classifier) ElementRegistry.INSTANCE.getElementById(classiefierId);
			if (classifier != null) {
				this.operation.createOwnedParameter(parameter.GetName(), classifier);
			} else {
				LOG.debug("parameter type not known yet, added to post processor");
				PostProcessor.INSTANCE.addParameter(this.operation, parameter);
			}
		} else {
			
			final String parameterType = parameter.GetType();
			
			// first check if it is an primitive type
			PrimitiveType type = ResourceRegistry.INSTANCE.importPrimitiveType(parameterType);
			
			// if primitive type is found by import
			if (type != null) {
				LOG.debug("PrimitiveType is = " + type.getName());
				umlParameter = this.operation.createOwnedParameter(parameter.GetName(), type);
			} else {
				LOG.error("type is not known! -> " + parameterType);
			}
			
		}
		return umlParameter;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_1_df50335_1381922309548_908585_3655) ENABLED START */
	// :)
	
	public Parameter transform(Operation umlOperation, org.sparx.Parameter eaParameter) {
		this.operation = umlOperation;
		return transform(eaParameter);
	}
	/* PROTECTED REGION END */
}
