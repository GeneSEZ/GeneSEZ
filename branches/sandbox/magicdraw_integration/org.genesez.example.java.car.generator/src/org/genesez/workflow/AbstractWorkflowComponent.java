package org.genesez.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_paljEPU8EeGsV8fV-DCYeA) 
 */
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;
import javax.security.auth.login.LoginException;

import net.ser1.stomp.Client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.emf.mwe.core.issues.MWEDiagnostic;
import org.eclipse.emf.mwe.core.lib.Mwe2Bridge;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;
import org.genesez.workflow.profile.WfDefault;
import org.genesez.workflow.profile.WfParameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public abstract class AbstractWorkflowComponent extends org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent implements WorkflowComponent {
	
	/**
	 * Specifies the execution in case of errors.
	 */
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private boolean abortOnError = true;
	
	/**
	 * Invokes the execution of the component.
	 * @param	context	The context of workflow execution.
	 * @param	monitor	Instance to report any activity to.
	 * @param	issues	Instance to collect all problems during execution.
	 */
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor, Issues issues) 
	{
		/* PROTECTED REGION ID(java.implementation._rTW_YPU4EeGsV8fV-DCYeA) ENABLED START */
		WorkflowContextSupport.update(context);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Provides the mwe2 execution wrapper.
	 */
	protected Mwe2Bridge getBridge() 
	{
		/* PROTECTED REGION ID(java.implementation._135mEPVBEeGsV8fV-DCYeA) ENABLED START */
		// @see WorkflowEngine.prepare()
		// @see WorkflowEngine.logIssues()
		// @see Mwe2Bridge.handleIssues()
		return new Mwe2Bridge(this) 
		{
			/*
			 * Overridden to catch any thrown exceptions and log issues first before rethrowing the exception
			 * @see org.eclipse.emf.mwe.core.lib.Mwe2Bridge#invoke(org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext)
			 */
			@Override
			public void invoke(final IWorkflowContext ctx) 
			{
				IssuesImpl issues = new IssuesImpl();
				
				try 
				{
					AbstractWorkflowComponent.this.invoke(new WorkflowContext() 
					{
						public String[] getSlotNames() 
						{
							return ctx.getSlotNames().toArray(new String[0]);
						}
						
						public Object get(String slotName) {
							return ctx.get(slotName);
						}
						
						public void set(String slotName, Object value) {
							ctx.put(slotName, value);
						}
					}, new NullProgressMonitor(), issues);
				} catch (RuntimeException e) {
					throw e;
				} finally {
					handleIssues(issues);
				}
			}
			
			@Override
			protected void handleIssues(IssuesImpl issues) 
			{	
				for (MWEDiagnostic it : issues.getIssues()) 
				{
					// obtain an appropriate log object
					Log log;
					if (it.getContext() != null) {
						log = LogFactory.getLog(it.getContext().getClass());
					} else {
						log = logger;
					}
					
					// log messages
					if (it.getSeverity() == Diagnostic.INFO) 
					{
						log.info(it.getMessage());
					}
					if (it.getSeverity() == Diagnostic.WARNING) 
					{
						log.warn(it.getMessage());
					}
					if (it.getSeverity() == Diagnostic.ERROR) 
					{
						log.error(it.getMessage());
					}	
				}
				
	
				sendIssue(issues);
				
				if (issues.hasErrors()) 
				{
					throw new RuntimeException("Workflow interupted because of " + issues.getErrors().length + " errors.");
				}
			}


		};
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "abortOnError")
	public boolean getDefaultAbortOnError() {
		return true;
	}
	
	/**
	 * Specifies the execution in case of errors.
	 */
	public boolean getAbortOnError() {
		return abortOnError;
	}
	
	/**
	 * Specifies the execution in case of errors.
	 * @param	abortOnError	the value to set.
	 */
	public void setAbortOnError(boolean abortOnError) 
	{
		this.abortOnError = abortOnError;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._paljEPU8EeGsV8fV-DCYeA) ENABLED START */
	protected String listToString(Collection<? extends Object> list) 
	{
		StringBuilder sb = new StringBuilder();
		Iterator<? extends Object> it = list.iterator();
		while (it.hasNext()) {
			String item = it.next().toString();
			if (item.startsWith("'")) {
				item = item.substring(1, item.length() - 1);
			}
			sb.append(item);
			if (it.hasNext()) {
				sb.append(",");
			}
		}
		return sb.toString();
	}
	
	private Log logger = LogFactory.getLog(getClass());
	/* PROTECTED REGION END */
	
	
	/**
	 * 
	 * @param issues
	 */
	private void sendIssue(IssuesImpl issues)
	{
		Properties properties = new Properties();
		StringWriter writer = new StringWriter();
		Client client = null;
		
		try {client = new Client("localhost", 12345, null, null);} 
		catch (LoginException e) {e.printStackTrace();} 
			catch (IOException e) {e.printStackTrace();}
		
		
		for (MWEDiagnostic error : issues.getErrors()) 
		{
			Object object = error.getElement();
			
			if(object instanceof EObject && ((EObject) object).eResource() != null)
			{
				EObject eObject = (EObject) object;
				String xmlGUIID = ((XMLResource) eObject.eResource()).getID(eObject);
				
				properties.put("id", xmlGUIID);
				properties.put("severity", String.valueOf(error.getSeverity()));
				properties.put("message", error.getMessage());
				

				try {properties.store(new PrintWriter(writer), "storeID");} 
					catch (IOException e1) {e1.printStackTrace();}
				
				client.send("/validation", writer.getBuffer().toString());
			}
		}
		client.disconnect();
	}
}