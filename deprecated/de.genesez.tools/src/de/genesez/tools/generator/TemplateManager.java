package de.genesez.tools.generator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.osgi.framework.FrameworkUtil;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * <b>Singleton</b>
 * Provides all available templates and their assigned data.
 * @author Marcel Klein
 */
public class TemplateManager {
	/** Singleton instance */
	private static TemplateManager instance;
	/** name of the template configuration XML file */
	private static final String CONFIG_FILENAME = "templateConfig.xml";
	/** pattern for the name of the project */
	private static final String PROJECTNAME_PATTERN = "__GENESEZ.PROJECTNAME__";
	
	/** buffer size for template unzipping */
	private final static int BUFFERSIZE = 4096;
	
	/** list of loaded templates */
	private List<Template> templateList = new ArrayList<Template>();
	/** list of loaded templates sorted by language */
	private Map<String, List<Template>> languageTempleteList = new Hashtable<String, List<Template>>();
	/** list of languages, linked to to languageTempalteList */
	Set<String> languageList = languageTempleteList.keySet();
	/** XML doc builder factory */
	private DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	/** XML doc builder */
	private DocumentBuilder dBuilder;
	
	/** 
	 * @return The Singleton instance of the template manager. 
	 */
	public static TemplateManager getInstance() {
		if(instance == null) {
			instance = new TemplateManager();
		}
		return instance;
	}
	
	/** Hidden Singleton Constructor */
	private TemplateManager() {
		try {
			readTemplates();
		} catch (Exception e) {
			System.err.println("Unexpected problems while reading in templates:");
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads in all template files, respectively there config XML files.
	 * @throws Exception
	 */
	private void readTemplates() throws Exception {
		//TODO: Refactor me please! I'm too long!
		// get all files listed in the templates folder
		URL url = FrameworkUtil.getBundle(this.getClass()).getEntry("templates");
		URI uri = FileLocator.toFileURL(url).toURI();
		String[] templateFilesNames = new File(uri).list();
		StringBuilder xmlText = new StringBuilder();
		// grap the template config from every single template zip file
		if(templateFilesNames != null) {
			for(String templateFileName : templateFilesNames) {
				List<String> projectFolders = new ArrayList<String>();
				boolean foundConfigXML = false;
				boolean emptyOrInvalidZip = true; //ignore non-zip files
				InputStream fs = this.getClass().getResourceAsStream("/templates/"+templateFileName);
				if(fs == null) continue;
				ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fs));
				ZipEntry entry;
				while ((entry = zis.getNextEntry()) != null) {
					emptyOrInvalidZip = false;
					if(entry.getName().equals(CONFIG_FILENAME)) {
						BufferedReader sr = new BufferedReader(new InputStreamReader(zis));
						String line = null;
						xmlText.setLength(0);
						while((line = sr.readLine()) != null) {
							xmlText.append(line);
						}		
						foundConfigXML = true;
					} 
					else if (entry.isDirectory()) {
						String[] folders = entry.getName().split("/", 2);
						// cancel zip reading if we reached in the second folder hierarchy
						if(folders.length > 1 && !folders[1].isEmpty()) break;
						projectFolders.add(folders[0]);
					}
				}
				zis.close();
				fs.close();
				// make it obvious if a dev forgot the config file
				if(!emptyOrInvalidZip && !foundConfigXML) {
					JOptionPane.showMessageDialog(null, 
							"Coudn't find the templateConfig.xml inside the template file: " + templateFileName , 
							"No template config file found", JOptionPane.ERROR_MESSAGE);
				}
				// construct the template definition
				else {
					// read xml content and other values into template
					Template template = readTemplateConfig(xmlText.toString());
					template.templateFileName = templateFileName;
					template.fileSize = new File(uri.getPath() + templateFileName).length();
					template.projectFolders = projectFolders;
					// store the template in our lists
					templateList.add(template);
					if(!languageTempleteList.containsKey(template.language)) {
						languageTempleteList.put(template.language, new ArrayList<Template>());
					}
					languageTempleteList.get(template.language).add(template);
				}
			}
		}
		
	}
	
	/**
	 * Reads a file stream of a XML config file into a template class.
	 * @param is XML file stream
	 * @param templateFile name of template file
	 * @return constructed template
	 * @throws Exception
	 */
	private Template readTemplateConfig(String xml) throws Exception {
		if(dBuilder == null) 
			dBuilder = dbFactory.newDocumentBuilder();
		else 
			dBuilder.reset();
		StringReader reader = new StringReader( xml );
		InputSource inputSource = new InputSource( reader );
		Document doc = dBuilder.parse(inputSource);
		doc.getDocumentElement().normalize();
		
		Template template = new Template();
		
		// start reading values into template
		template.language = getElementValue(doc,"language");
		template.name = getElementValue(doc,"name");
		template.description = getElementValue(doc,"description");
		NodeList fileNameNodes = doc.getElementsByTagName("filename");
		for(int i = 0; i < fileNameNodes.getLength(); i++) {
			String fileName = fileNameNodes.item(i).getChildNodes().item(0).getNodeValue();
			template.replaceInFiles.add(fileName);
		}
		
		return template;
	}
	
	/**
	 * Extracts an element value out of the XML tree.
	 * @param doc XML document
	 * @param name Name of the element i.e. "foo" for &lt;foo&gt;<i>value</i>&lt;/foo&gt;
	 * @return value of the element
	 */
	private String getElementValue(Document doc, String name) {
		return doc.getElementsByTagName(name).item(0).getChildNodes().item(0).getNodeValue();
	}
	
	/**
	 * @return all current loaded templates
	 */
	public Template[] getTemplates() {
		return templateList.toArray(new Template[0]);
	}
	
	/**
	 * @return all current loaded templates ordered by language
	 */
	public Map<String, List<Template>> getTemplatesByLanguage() {
		return languageTempleteList;
	}
	
	/**
	 * @return all current loaded languages
	 */
	public String[] getLanguages() {
		return languageList.toArray(new String[0]);
	}
	
	/**
	 * Returns the template configuration for the specified 
	 * template file name or <i>null</i> if not found.
	 * @param fileName file name of the template
	 * @return template configuration or <i>null</i> if not found
	 */
	public Template getTemplateByFileName(String fileName) {
		for(Template t : templateList) {
			if(t.templateFileName.equals(fileName))
				return t;
		}
		return null;
	}

	/**
	 * Configuration of a GeneSEZ template.
	 * @author Marcel Klein
	 */
	public class Template {
		/** name of the template */
		public String name;
		/** programming language of the template */
		private String language;
		/** file name of the template file */
		private String templateFileName;
		/** description of the template */
		private String description;
		/** list of files in which patterns should be replaced */
		private List<String> replaceInFiles = new ArrayList<String>();
		/** list of project folders which will be created by the template */
		private List<String> projectFolders;
		/** size of template file */
		private long fileSize;
		
		/** hidden constructor, only the manager can load templates */
		private Template() {
		}	
		/** @return name of the template */
		public String getName() {
			return name;
		}
		/** @return description of the template */
		public String getDescription() {
			return description;
		}
		/** @return programming language of the template */
		public String getLanguage() {
			return language;
		}	
		/** @return path to the template file */
		public String getTemplateFileName() {
			return templateFileName;
		}
		/** @return list of project folders which will be created by the template */
		public String[] getProjectFolders() {
			return projectFolders.toArray(new String[0]);
		}
		
		/**
		 * Extracts the template into the workspace of the project and replaces all patterns in
		 * file names and inside the files as specified in the template and the project.
		 * @param project target project of this template 
		 * @param monitor progress reporting monitor
		 * @return the names of created project folders
		 */
		public String[] extractAndReplace(Project project, IProgressMonitor monitor) {
			monitor.beginTask("Creating project(s) out of the template...", 100);
			
			// set up a new replacer for our project patterns
			ReplaceUtil replacer = new ReplaceUtil();
			replacer.addPattern(PROJECTNAME_PATTERN, project.getProjectName());
			
			// extract template content and replace all patterns
			unzip(replacer, project.getWorkspacePath(), new SubProgressMonitor(monitor,50));
			replacePatternInFiles(replacer, project.getWorkspacePath(), new SubProgressMonitor(monitor,50));
			
			// finally return the generated project folders names
			String[] replacedFolderNames = new String[projectFolders.size()];
			for(int i=0;i<replacedFolderNames.length;i++) {
				replacedFolderNames[i] = replacer.replace(projectFolders.get(i));
			}
			
			monitor.done();
			return replacedFolderNames;
			
		}
		
		/**
		 * Unzips the template content into the desired destination i.e. the workspace.
		 * Patterns in the names of the files will be replaced on the fly.
		 * @param destination target folder i.e. workspace
		 * @param monitor 
		 */
		private void unzip(ReplaceUtil replacer, String destination, IProgressMonitor monitor) {
			monitor.beginTask("unzip template", (int) this.fileSize);
			try {
				InputStream resStream = this.getClass().getResourceAsStream("/templates/" + templateFileName);
				BufferedOutputStream dest = null;
				ZipInputStream zis = new ZipInputStream(new BufferedInputStream(resStream));
				ZipEntry entry;
				while ((entry = zis.getNextEntry()) != null) {
					// skip config file
					if(entry.getName().equals(TemplateManager.CONFIG_FILENAME)) continue;
					
					String entryName = replacer.replace(entry.getName());
					String fullpath = destination + "/" + entryName;
					int count;
					byte data[] = new byte[BUFFERSIZE];
					// write the files to the disk
					if(entry.isDirectory()) {
						new File(fullpath).mkdir();
					}
					else {
						FileOutputStream fos = new FileOutputStream(fullpath);
						dest = new BufferedOutputStream(fos, BUFFERSIZE);
						while ((count = zis.read(data, 0, BUFFERSIZE)) != -1) {
							dest.write(data, 0, count);
						}
						dest.flush();
						dest.close();
					}
					monitor.worked((int)entry.getCompressedSize());
				}
				zis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			monitor.done();
		}
		
		/**
		 * Replace the patterns inside the specified files.
		 * Call after extraction of the template.
		 * @param destination target folder i.e. workspace
		 * @param monitor progress reporting monitor
		 */
		private void replacePatternInFiles(ReplaceUtil replacer, String destination, IProgressMonitor monitor) {
			monitor.beginTask("replace pattern", replaceInFiles.size());
			
			for(String fileName : replaceInFiles) {
				String fullPath = destination + "/" + replacer.replace(fileName);
				try {
					replacer.replaceInFile(fullPath);
				}
				catch(IOException e) {
					// help the dev if he made a mistake in the config file
					JOptionPane.showMessageDialog(null, 
							"Coudn't find the file " + fullPath + 
							"\nwhich is defind in the template config " + 
							CONFIG_FILENAME + " of " + fileName +
							".\nPlease check that entry.",
							"File not found for pattern replacement", JOptionPane.ERROR_MESSAGE);
				}
				monitor.worked(1);
			}
			
			monitor.done();
		}
		
		/**
		 * Delivers the pattern replaced versions of the all project names that
		 * will be created by this template.
		 * @param projectName Desired project name.
		 * @return all project names
		 */
		public String[] getReplacedProjectNames(String projectName) {
			// set up a new replacer only for the project names
			ReplaceUtil replacer = new ReplaceUtil();
			replacer.addPattern(PROJECTNAME_PATTERN, projectName);
			// replace all pattern in the project names
			String[] replacedProjectNames = new String[projectFolders.size()];
			for(int i=0; i<replacedProjectNames.length; i++) {
				replacedProjectNames[i] = replacer.replace(projectFolders.get(i));
			}
			return replacedProjectNames;
		}
	}
}
