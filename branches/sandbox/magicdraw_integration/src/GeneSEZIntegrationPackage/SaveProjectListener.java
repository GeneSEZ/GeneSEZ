package GeneSEZIntegrationPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.core.options.ProjectOptions;
import com.nomagic.magicdraw.core.project.ProjectEventListener;
import com.nomagic.magicdraw.properties.Property;


public class SaveProjectListener implements ProjectEventListener
{
	//indicates if an error occurred while preparing to run the workflow (wrong path, wrong file)
	private Boolean initialisationError = false;
	private PresentationElementReseter presentationElementReseter;
	
	public SaveProjectListener(PresentationElementReseter presentationElementReseter)
	{
		this.presentationElementReseter = presentationElementReseter;
	}
	
	/**
	 * Loads the paths, check the paths, changes the properties file and starts the workflow
	 */
	@Override
	public void projectSaved(Project arg0, boolean arg1) 
	{
    	Property property = Application.getInstance().getProject().getOptions().getProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES, "WorkflowActivatedID");
    	Boolean workflowActivated = false;
			
    	if(property != null)
    	{
    		workflowActivated = (Boolean) property.getValue();
    	}

    	
        if(workflowActivated)
        {
        	int antwort = JOptionPane.showConfirmDialog(null, "Möchten Sie den Workflow ausführen?");
            boolean executeWorkflow = false;

            if (antwort == JOptionPane.OK_OPTION) 
            {
            	executeWorkflow = true;
            } 

        	if(executeWorkflow)
        	{
        		String propertiesFilePath, projectFilePath, workflowFilePath, batFilePath;
		
        		propertiesFilePath = getPath("PropertyFileID", ".properties");
        		projectFilePath = getPath("ProjectFileID", ".project");
        		projectFilePath = projectFilePath.replace(".project", "");
        		batFilePath = getPath("BatFileID2", ".bat");
        		workflowFilePath = getPath("WorkflowFileID", ".mwe2");
		
        		if(!initialisationError)
        		{
        			try
        			{
        				FileInputStream inputStream = new FileInputStream(propertiesFilePath);;
        				Properties properties = new Properties();
        				properties.load(inputStream);
        				inputStream.close();

        				FileOutputStream out = new FileOutputStream(propertiesFilePath);
        				properties.setProperty("project.dir", projectFilePath);
        				properties.setProperty("workflow.file", workflowFilePath);
        				properties.store(out, null);
        				out.close();
        			}
        			catch(Exception e)
        			{
        				initialisationError = true;
        				javax.swing.JOptionPane.showMessageDialog(null, "Fehler beim schreiben der .properties Datei");
        			}
			
        			if(!initialisationError)
        			{
        				try {Runtime.getRuntime().exec("cmd /c start /B " + batFilePath);} 
        				catch (IOException e1) 
        				{
						javax.swing.JOptionPane.showMessageDialog(null, "Fehler beim Ausführen von " + batFilePath);
        				}
        			}
        		}
			}
		}
	}

	
	@Override
	public void projectActivated(Project arg0) {}

	@Override
	public void projectActivatedFromGUI(Project arg0) {}

	@Override
	public void projectClosed(Project arg0) {}

	@Override
	public void projectCreated(Project arg0) {}

	@Override
	public void projectDeActivated(Project arg0){}

	@Override
	public void projectOpened(Project arg0) {}

	@Override
	public void projectOpenedFromGUI(Project arg0) {}

	@Override
	public void projectPreActivated(Project arg0) {}

	@Override
	public void projectPreClosed(Project arg0) {}

	@Override
	public void projectPreClosedFinal(Project arg0) {}

	@Override
	public void projectPreDeActivated(Project arg0) {}

	@Override
	public void projectPreReplaced(Project arg0, Project arg1) {}

	@Override
	public void projectPreSaved(Project arg0, boolean arg1) 
	{
		presentationElementReseter.resetDiagram();
	}

	@Override
	public void projectReplaced(Project arg0, Project arg1) {}


	private String getPath(String propertyID, String fileEnding) 
	{
		String path = "";
		
		Property property = Application.getInstance().getProject().getOptions().getProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES,propertyID);

		if(property != null)
		{
			path = property.getValueStringRepresentation();
			
			if(!path.contains(fileEnding))
			{
				initialisationError = true;
				
				javax.swing.JOptionPane.showMessageDialog(null, "Unter \"" + property.getName() + "\" konnte keine Datei mit der Endung "+ fileEnding + " gefunden werden");
			}
			else
			{
				path = path.replace("\\", "\\");
			}
		}

		return path;
	}
}
