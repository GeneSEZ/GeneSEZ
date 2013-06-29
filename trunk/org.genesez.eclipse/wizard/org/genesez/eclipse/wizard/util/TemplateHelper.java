/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.wizard.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import javax.swing.JOptionPane;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.genesez.eclipse.wizard.handler.ChangeGeneSEZNatureHandler;
import org.genesez.eclipse.wizard.util.replace.simpel.ReplacerHelper;
import org.genesez.eclipse.wizard.util.replace.simpel.SimpleTextReplacer;

//

/**
 * A Helper class, which is used to read the information out of the templateConfig.xml which is inside the template zip files and
 * to decompress the chosen zip-file, where necessary things are changed in the project.
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * @author tobias haubold <toh@fh-zwickau.de>
 */
public class TemplateHelper {

	private static final String CONFIG_FILENAME = "templateConfig.xml";
	private static final String TEMPLATE_FOLDER = "/templates/";
	private static final String ARCHIVE_PATTERN = ".*[.]zip$";
	private static final int BUFFER = 4096;
	// public static final String REPLACE_FILES =
	// ".*/.*[.]mwe$|.*/MANIFEST[.]MF$|.*/build[.]xml";
	// private static final Pattern FILES_WITH_REPLACEMENTS =
	// Pattern.compile(".*/[.]project$|" + REPLACE_FILES);
	public static final String FOLDER_ENDING = "(/$|[.]generator/$)";
	public static final String GENERATOR_ENDING = ".generator";
	public static Set<SimpleTextReplacer> replacer = ReplacerHelper.getAvailableReplacer();
	public static final String DEFAULT_GEN_TEMPLATE = TEMPLATE_FOLDER + "default/default.zip";
	public static final IPath LOCATION = new Path(TemplateHelper.class.getProtectionDomain().getCodeSource().getLocation()
			.getFile());

	public static Job createJob;

	private static JAXBContext jc = null;
	private static Unmarshaller un = null;

	static {
		try {
			jc = JAXBContext.newInstance(TemplateConfigXml.class);
			un = jc.createUnmarshaller();
		} catch (JAXBException e) {
		}
	}

	/**
	 * Doesn't need to be constructed
	 */
	private TemplateHelper() {
	}

	/**
	 * Reads the Information from the Zip-Files in the Template directory
	 * 
	 * @return List with needed Information from the templateConfig.xml
	 * @throws FileNotFoundException
	 *             if the template folder couldn't be found in the project
	 */
	public static List<TemplateConfigXml> readTemplateInformation() throws FileNotFoundException, IOException, URISyntaxException {
		List<TemplateConfigXml> templates = new ArrayList<TemplateConfigXml>();
		URL url = TemplateHelper.class.getProtectionDomain().getCodeSource().getLocation();
		File folder = new File(url.getPath().concat(TEMPLATE_FOLDER));
		File[] files;
		if (!folder.isDirectory()) {
			throw new FileNotFoundException("Directory " + folder.toString() + "can't be found in the project.");
		}
		files = folder.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				if (pathname.toString().matches(ARCHIVE_PATTERN)) {
					return true;
				}
				return false;
			}
		});
		for (int i = 0; i < files.length; i++) {
			TemplateConfigXml read = readArchive(files[i]);
			if (read != null) {
				templates.add(read);
			}
		}
		return templates;
	}

	/**
	 * Reads the zip file archive and the templateConfig.xml in it. If not found a warning is shown.
	 * 
	 * @param file
	 *            the archive the should be read
	 * @return the unmarshalled templateConfig.xml
	 */
	public static TemplateConfigXml readArchive(File file) {
		ZipFile zf = null;
		TemplateConfigXml toReturn = null;
		try {
			zf = new ZipFile(file);
			ZipEntry entry = zf.getEntry(CONFIG_FILENAME);
			if (entry == null) {
				// TODO: SWT Klasse benutzen.
				JOptionPane.showMessageDialog(null,
						"Couldn't find the templateConfig.xml inside the template file: " + file.getName(),
						"No template config file found", JOptionPane.WARNING_MESSAGE);
				return null;
			}
			InputStream stream = zf.getInputStream(zf.getEntry(CONFIG_FILENAME));
			toReturn = (TemplateConfigXml) un.unmarshal(stream);
			Enumeration<? extends ZipEntry> entries = zf.entries();
			while (entries.hasMoreElements()) {
				ZipEntry z_entry = entries.nextElement();
				if (z_entry.isDirectory()) {
					toReturn.addInternalFolder(new Path(z_entry.getName()));
				} else {
					toReturn.addInternalFile(new Path(z_entry.getName()));
				}
			}
			toReturn.setFile(file);
		} catch (ZipException e) {
		} catch (IOException e) {
		} catch (JAXBException e) {
		} finally {
			try {
				if (zf != null) {
					zf.close();
				}
			} catch (IOException e) {
			}
		}
		return toReturn;
	}

	/**
	 * Decompress the zip-file and changes the necessary files
	 * 
	 * @param template
	 *            the template from the zip file.
	 * @param appProjectName
	 *            the application project name.
	 * @param genProjectName
	 *            the generator project name.
	 * @param destination
	 *            the destination path.
	 * @param appFromZip
	 *            true if application project should be used from template.
	 * @param genFromZip
	 *            true if generator project should be used from template.
	 * @param monitor
	 *            the progress monitor.
	 * @return a List with projects decompressed from the zip file.
	 * @throws IOException
	 *             if something went wrong with unzipping.
	 */
	public static List<String> decompress(TemplateConfigXml template, String appProjectName, String genProjectName,
			String destination, boolean appFromZip, boolean genFromZip, IProgressMonitor monitor) throws IOException {
		// ZipInputstream der TemplateDatei erzeugen
		monitor.subTask("Prepare template file for reading.");
		// toh: just use file input stream with the file available, the old way results always in a null input stream
//		IPath templatePath = new Path(template.getFile().getPath());
//		InputStream resStream = TemplateHelper.class.getResourceAsStream(IPath.SEPARATOR
//				+ templatePath.makeRelativeTo(LOCATION).toOSString());
		InputStream resStream = new FileInputStream(template.getFile());
		ZipInputStream zis = new ZipInputStream(new BufferedInputStream(resStream));
		List<String> projects = new ArrayList<String>();
		ZipEntry entry;
		monitor.worked(10);
		monitor.subTask("Decompress template file");
		// einzelnen Entries lesen
		while ((entry = zis.getNextEntry()) != null) {
			if (monitor.isCanceled()) {
				return null;
			}
			String entryName = entry.getName();
			String oldName = template.getInternalProjectName();
			String oldGenName = oldName.concat(GENERATOR_ENDING);
			// überprüfen was aus Template verwendet werden soll
			if (entryName.equals(CONFIG_FILENAME)
					|| (!genFromZip && entryName.startsWith(oldGenName + File.separator) || (!appFromZip && entryName
							.startsWith(oldName + File.separator)))) {
				continue;
			}
			boolean isGenProject;
			if (entryName.startsWith(oldGenName)) {
				entryName = entry.getName().replaceFirst(oldGenName, genProjectName);
				isGenProject = true;
			} else {
				entryName = entry.getName().replaceFirst(oldName, appProjectName);
				isGenProject = false;
			}
			
			String path = destination + File.separator + entryName;
			if (entry.isDirectory()) {
				// toh: need to change regexp for file separator, now both \ and / are optionally allowed
				if (entryName.matches(appProjectName + "(\\\\|/)?$")
						|| entryName.matches(genProjectName + "(\\\\|/)?$")) {
					projects.add(entryName);
				}
				new File(path).mkdirs();
			} else {
				File emptyFile = new File(path);
				boolean fileExistend = false;
				// Datei anlegen und währenddessen einiges ersetzen
				// TODO: hier anderen Algorithmus wählen
				Dictionary<String, Object> properties = new Hashtable<String, Object>();
				properties.put(WizardConstants.TEMPLATE, template);
				for (SimpleTextReplacer repl : replacer) {
					if (repl.fillAndReplace(emptyFile, zis, oldName, oldGenName, appProjectName, genProjectName, isGenProject,
							properties)) {
						fileExistend = true;
					}
				}
				if (!fileExistend) {
					// file anlegen, wenn sie zuvor nicht angelegt wurde
					BufferedOutputStream dest = new BufferedOutputStream(new FileOutputStream(path), BUFFER);
					int count = 0;
					byte[] data = new byte[BUFFER];
					while ((count = zis.read(data, 0, BUFFER)) != -1) {
						dest.write(data, 0, count);
					}
					dest.flush();
					dest.close();
				}
			}
		}
		zis.close();
		return projects;
	}

	/**
	 * Creates the GeneSEZ projects.
	 * 
	 * @param template
	 *            the template from the zip file.
	 * @param appProjectName
	 *            the application project name.
	 * @param genProjectName
	 *            the generator project name.
	 * @param workspace
	 *            the current workspace.
	 * @param appFromZip
	 *            true if application project should be used from template.
	 * @param genFromZip
	 *            true if generator project should be used from template.
	 * @return true if everything works.
	 */
	public static void createProject(final TemplateConfigXml template, final String appProjectName, final String genProjectName,
			final IWorkspaceRoot workspace, final boolean appFromZip, final boolean genFromZip) {
		createJob = new Job("Creating GeneSEZ Project") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask("Create " + appProjectName + " GeneSEZ projects.", 100);
				List<String> projects = null;
				try {
					projects = decompress(template, appProjectName, genProjectName, workspace.getLocationURI().getPath(),
							appFromZip, genFromZip, monitor);
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Decompression of the template failed.", "Can't create projects.",
							JOptionPane.ERROR_MESSAGE);
					return Status.CANCEL_STATUS;
				}
				if (projects == null) {
					return Status.CANCEL_STATUS;
				}
				monitor.worked(60);
				// import the created project folders to eclipse workspace
				for (String folder : projects) {
					IProject project = workspace.getProject(folder);
					try {
						project.create(monitor);
						monitor.worked(80);
						project.open(monitor);
						if (project.getName().equals(genProjectName)) {
							ChangeGeneSEZNatureHandler.addNature(project);
						}
					} catch (Exception e) {
						e.printStackTrace();
						return Status.CANCEL_STATUS;
					}
				}
				monitor.worked(100);
				monitor.done();
				return Status.OK_STATUS;
			}
		};
		createJob.setUser(true);
		createJob.schedule();
	}
}