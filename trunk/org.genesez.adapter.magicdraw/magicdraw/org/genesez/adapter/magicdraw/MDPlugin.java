package org.genesez.adapter.magicdraw;


import java.io.IOException;
import javax.security.auth.login.LoginException;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.options.ProjectOptions;
import com.nomagic.magicdraw.core.options.ProjectOptionsConfigurator;
import com.nomagic.magicdraw.properties.BooleanProperty;
import com.nomagic.magicdraw.properties.FileProperty;
import com.nomagic.magicdraw.properties.Property;
import com.nomagic.magicdraw.properties.PropertyResourceProvider;


/**
 * Main class of the plugin
 */
public class MDPlugin extends com.nomagic.magicdraw.plugins.Plugin
{
	MDServer mdServer;
	MDClient mdClient;
	
	/**
	 * If MagicDraw is closed
	 */
	@Override
	public boolean close() 
	{
		mdClient.disconnect();
		mdServer.stop();
		return true;
	}
	
	/**
	 * If MagicDraw is started
	 */
	@Override
	public void init() 
	{
		createMenuePoints();
		
		try 
		{
			mdServer = new MDServer();
			mdClient = new MDClient();
		} 
		catch (IOException e){e.printStackTrace();} 
		catch (LoginException e) {e.printStackTrace();}
		
		//add listener
		SaveProjectListener saveProjectListener = new SaveProjectListener(mdClient.getPresentationElementReseter());
		Application.getInstance().getProjectsManager().addProjectListener(saveProjectListener);
	}

	@Override
	public boolean isSupported() 
	{
		return true;
	}
	

	/**
	 * create menuepoints in "Optionen > project > Allgemeine Projektoptionen"
	 */
	private void createMenuePoints()
	{
		//Add menu item for .bat-file
		ProjectOptions.addConfigurator(new ProjectOptionsConfigurator()
		{
			public void configure(ProjectOptions projectOptions)
			{
				com.nomagic.magicdraw.properties.Property property = projectOptions.getProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES,"BatFileID");
				
				if (property == null)
				{
					property = new FileProperty("BatFileID2", "");
					property.setGroup("GeneSEZ-Plugin");
					
					property.setResourceProvider(new PropertyResourceProvider()
					{
						public String getString(String string, Property property)
						{
							if ("BatFileID2".equals(string))
							{
								return "bat Datei speicherort";
							}
							
							if ("BatFileID2_DESCRIPTION".equals(string))
							{
								return "bat Datei Speicherort";
							}
							
							if ("GeneSEZ-Plugin".equals(string))
							{
								return "GeneSEZ-Plugin";
							}
						return string;
						}
					});

		projectOptions.addProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES, property);
		}
		}

		public void afterLoad(ProjectOptions arg0) {}
		});
		
		//Add menu item for .properties file
		ProjectOptions.addConfigurator(new ProjectOptionsConfigurator()
		{
			public void configure(ProjectOptions projectOptions)
			{
				com.nomagic.magicdraw.properties.Property property = projectOptions.getProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES,"PropertyFileID");
				
				if (property == null)
				{
					property = new FileProperty("PropertyFileID", "");
					property.setGroup("GeneSEZ-Plugin");
					
					property.setResourceProvider(new PropertyResourceProvider()
					{
						public String getString(String string, Property property)
						{
							if ("PropertyFileID".equals(string))
							{
								return "Pfad der .properties Datei";
							}
							
							if ("PropertyFileID_DESCRIPTION".equals(string))
							{
								return "Speicherort der .properties Datei";
							}
							
							if ("GeneSEZ-Plugin".equals(string))
							{
								return "GeneSEZ-Plugin";
							}
						return string;
						}
					});

		projectOptions.addProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES, property);
		}
		}

		public void afterLoad(ProjectOptions arg0) {}
		});
		
		//Add menu item for workflow file
		ProjectOptions.addConfigurator(new ProjectOptionsConfigurator()
		{
			public void configure(ProjectOptions projectOptions)
			{
				com.nomagic.magicdraw.properties.Property property = projectOptions.getProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES,"WorkflowFileID");
				
				if (property == null)
				{
					property = new FileProperty("WorkflowFileID", "");
					property.setGroup("GeneSEZ-Plugin");
					
					property.setResourceProvider(new PropertyResourceProvider()
					{
						public String getString(String string, Property property)
						{
							if ("WorkflowFileID".equals(string))
							{
								return "Pfad der workflow Datei";
							}
							
							if ("WorkflowFileID_DESCRIPTION".equals(string))
							{
								return "Speicherort der workflow Datei";
							}
							
							if ("GeneSEZ-Plugin".equals(string))
							{
								return "GeneSEZ-Plugin";
							}
						return string;
						}
					});

		projectOptions.addProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES, property);
		}
		}

		public void afterLoad(ProjectOptions arg0) {}
		});
		
		//Add menu item for .project file
		ProjectOptions.addConfigurator(new ProjectOptionsConfigurator()
		{
			public void configure(ProjectOptions projectOptions)
			{
				com.nomagic.magicdraw.properties.Property property = projectOptions.getProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES,"ProjectFileID");
				
				if (property == null)
				{
					property = new FileProperty("ProjectFileID", "");
					property.setGroup("GeneSEZ-Plugin");
					
					property.setResourceProvider(new PropertyResourceProvider()
					{
						public String getString(String string, Property property)
						{
							if ("ProjectFileID".equals(string))
							{
								return "Pfad der .project Datei";
							}
							
							if ("ProjectFileID_DESCRIPTION".equals(string))
							{
								return "Speicherort der .project Datei";
							}
							
							if ("MD-Plugin".equals(string))
							{
								return "GeneSEZ-Plugin";
							}
						return string;
						}
					});

		projectOptions.addProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES, property);
		}
		}

		public void afterLoad(ProjectOptions arg0) {}
		});
		

		//Add menu item for "Execute workflow when saving magic draw project"
		ProjectOptions.addConfigurator(new ProjectOptionsConfigurator()
		{
			public void configure(ProjectOptions projectOptions)
			{
				com.nomagic.magicdraw.properties.Property property = projectOptions.getProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES,"WorkflowFileID");
				
				if (property == null)
				{
					property = new BooleanProperty("WorkflowActivatedID", false);
					property.setGroup("GeneSEZ-Plugin");
					
					property.setResourceProvider(new PropertyResourceProvider()
					{
						public String getString(String string, Property property)
						{
							if ("WorkflowActivatedID".equals(string))
							{
								return "Beim Speichern Workflow ausf�hren?";
							}
							
							if ("WorkflowActivatedID_DESCRIPTION".equals(string))
							{
								return "Beim Speichern Workflow ausf�hren?";
							}
							
							if ("MD-Plugin".equals(string))
							{
								return "GeneSEZ-Plugin";
							}
						return string;
						}
					});

		projectOptions.addProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES, property);
		}
		}

		public void afterLoad(ProjectOptions arg0) {}
		});
	}
}
