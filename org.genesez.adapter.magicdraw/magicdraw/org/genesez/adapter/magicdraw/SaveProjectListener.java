package org.genesez.adapter.magicdraw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.apache.tools.ant.launch.Launcher;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.Project;
import com.nomagic.magicdraw.core.options.ProjectOptions;
import com.nomagic.magicdraw.core.project.ProjectEventListener;
import com.nomagic.magicdraw.properties.Property;
import com.nomagic.magicdraw.ui.notification.Notification;
import com.nomagic.magicdraw.ui.notification.NotificationManager;

public class SaveProjectListener implements ProjectEventListener {
	
	//indicates if an error occurred while preparing to run the workflow (wrong path, wrong file)
	private Boolean initialisationError = false;
	private PresentationElementReseter presentationElementReseter;
	private GeneSezProjectOptions options;
	private MessageServiceClass messageServiceClass;
	
	public SaveProjectListener(PresentationElementReseter presentationElementReseter, GeneSezProjectOptions options, MessageServiceClass messageService)
	{
		this.presentationElementReseter = presentationElementReseter;
		this.options = options;
		this.messageServiceClass = messageService;
	}
	
	/**
	 * Loads the paths, check the paths, changes the properties file and starts the workflow
	 */
	public void projectSaved(Project arg0, boolean arg1) {
		Property property = Application.getInstance().getProject().getOptions().getProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES, "WorkflowActivatedID");
		boolean workflowActivated = false;
		
		if (property != null) {
			workflowActivated = Boolean.parseBoolean(property.getValue().toString());
		}
		if (!workflowActivated) {
			return;
		}
		
		// ask to execute transformation
		boolean executeWorkflow = false;
		int result = JOptionPane.showConfirmDialog(null, "Möchten Sie den Workflow ausführen?");
		if (result == JOptionPane.OK_OPTION) {
			executeWorkflow = true;
		}
		if (!executeWorkflow) {
			return;
		}
		
		// prepare execution of workflow
//		String propertiesFilePath = getPath("PropertyFileID", ".properties");
//		String projectFilePath = getPath("ProjectFileID", ".project");
//		projectFilePath = projectFilePath.replace(".project", "");
//		String batFilePath = getPath("BatFileID2", ".bat");
//		String workflowFilePath = getPath("WorkflowFileID", ".mwe2");
//		
//		if (!initialisationError) {
//			updatePropertiesFile(propertiesFilePath, projectFilePath, workflowFilePath);
//		}
		
		if (!options.isEclipseHomeDirSet() || !options.isWorkflowFileSet() || !options.isAntBuildFileSet()) {
			initialisationError = true;
		}
		
		String eclipseHomeDir = options.getEclipseHomeDir();
		String antBuildFile = options.getAntBuildFile();
		String workflowFile = options.getWorkflowFile();
		String projectDir = deriveProjectPath(workflowFile);
		
		if (!initialisationError) {
			executeAnt(eclipseHomeDir, antBuildFile, projectDir, workflowFile);
		}
	}
	
	
	public void projectActivated(Project arg0) {}

	public void projectActivatedFromGUI(Project arg0) {}

	public void projectClosed(Project arg0) {}

	public void projectCreated(Project arg0) {}

	public void projectDeActivated(Project arg0){}

	public void projectOpened(Project arg0) {}

	public void projectOpenedFromGUI(Project arg0) {}

	public void projectPreActivated(Project arg0) {}

	public void projectPreClosed(Project arg0) {}

	public void projectPreClosedFinal(Project arg0) {}

	public void projectPreDeActivated(Project arg0) {}

	public void projectPreReplaced(Project arg0, Project arg1) {}

	public void projectPreSaved(Project arg0, boolean arg1) 
	{
		presentationElementReseter.resetDiagram();
	}

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
	
	private boolean updatePropertiesFile(String propertiesFilePath, String projectDir, String workflowFile) {
		try {
			FileInputStream inputStream = new FileInputStream(propertiesFilePath);;
			Properties properties = new Properties();
			properties.load(inputStream);
			inputStream.close();
			
			FileOutputStream out = new FileOutputStream(propertiesFilePath);
			properties.setProperty("project.dir", projectDir);
			properties.setProperty("workflow.file", workflowFile);
			properties.store(out, null);
			out.close();
			return true;
		} catch (Exception e) {
			initialisationError = true;
			JOptionPane.showMessageDialog(null, "Error storing the .properties file! (" + e.getMessage() + ")");
			return false;
		}
	}
	
	private boolean executeAnt(String eclipseHomeDir, String antBuildFile, String projectDir, String workflowFile) {
		// start launcher in separate process
		Path base = Paths.get(System.getProperty("user.dir"));
		Path classpath = base.resolve("plugins/org.genesez.adapter.magicdraw/ant-launcher.jar");
		if (!Files.exists(classpath)) {
			// fall back when debugging magic draw
			classpath = base.resolve("lib/ant-launcher.jar");
		}
		ProcessBuilder pb = new ProcessBuilder(
				"java", 
				"-classpath", 
				classpath.toString(), 
				"org.apache.tools.ant.launch.Launcher", 
//				"-diagnostics"
				"-f", antBuildFile, 
//				"-v", 
				"-DECLIPSE_HOME=" + eclipseHomeDir,
				"-Dproject.dir=" + projectDir, 
				"-Dworkflow.file=" + workflowFile
		);
		pb.redirectErrorStream(true);
		Runnable antrun = getAntRunnable(pb);
		Thread antrunner = new Thread(antrun);
		antrunner.start();
		return true;
	}
	
	private Runnable getAntRunnable(final ProcessBuilder pb) {
		return new Runnable() {
			
			public void run() {
				messageServiceClass.transformationStarts();
				StringBuilder output = new StringBuilder();
				try {
					Process p = pb.start();
					InputStream is = p.getInputStream();
					BufferedReader br = new BufferedReader(new InputStreamReader(is));
					while (isRunning(p)) {
						try {
							while (br.ready()) {
								output.append(br.readLine() + "<br>");
							}
						} catch (IOException ioe) {
							// ignore it
						}
					}
					int result = 0;
					try {
						result = p.exitValue();
					} catch (IllegalThreadStateException itse) {
						result = -1;
					}
					messageServiceClass.transformationFinishes(result, output.toString());
				} catch (IOException ioe) {
					// report transformation error
					messageServiceClass.transformationError(ioe, output.toString());
				}
			}
		};
	}
	
	private boolean isRunning(Process p) {
		boolean result = true;
		try {
			int r = p.exitValue();
			result = false;
		} catch (IllegalThreadStateException itse) {
			result = true;
		}
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
//			e.printStackTrace();
		}
		return result;
	}
	
	private String toString(InputStream is) {
		StringBuilder output = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		try {
			while (br.ready()) {
				output.append(br.readLine() + System.lineSeparator());
			}
		} catch (IOException e) {
			// what to do?
		}
		return output.toString();
	}
	
	private String deriveProjectPath(String workflowFile) {
		String id = ".project";
		Path p = Paths.get(workflowFile);
		boolean isRoot = false;
		boolean found = false;
		Path projectDir = null;
		while (!isRoot && !found) {
			// go one level up
			p = p.getParent();
			// check .project file existence
			projectDir = p.resolve(id);
			if (Files.exists(projectDir)) {
				found = true;
			}
			// check for file system root
			if (p.getParent() == null) {
				isRoot = true;
			}
		}
		if (!found) {
			return null;
		}
		return p.toString();
	}
	
	private boolean executeAntByBatch(String batFilePath) {
		// it seams that batch files are only runnable by using cmd.exe
		ProcessBuilder pb = new ProcessBuilder(
				"cmd.exe", "/c", "start", "/B", batFilePath
		);
		try {
			Process p = pb.start();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, 
					"Error during execution of batch file:" + System.lineSeparator() +
					batFilePath + System.lineSeparator() +
					e.getMessage()
			);
		}
		return true;
	}
}
