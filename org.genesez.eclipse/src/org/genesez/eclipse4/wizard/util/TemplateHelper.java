package org.genesez.eclipse4.wizard.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Pattern;
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
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
//

/**
 * A Helper class, which is used to read the information out of the
 * templateConfig.xml which is inside the template zip files and to decompress
 * the chosen zip-file, where necessary things are changed in the project.
 * 
 * @author domwet
 * 
 */
public class TemplateHelper {

	private static final String CONFIG_FILENAME = "templateConfig.xml";
	private static final String TEMPLATE_FOLDER = "/templates/";
	private static final String ARCHIVE_PATTERN = ".*[.]zip$";
	private static final int BUFFER = 4096;
	public static final String REPLACE_FILES = ".*/.*[.]mwe$|.*/MANIFEST[.]MF$|.*/build[.]xml";
	private static final Pattern FILES_WITH_REPLACEMENTS = Pattern.compile(".*/[.]project$|" + REPLACE_FILES);
	public static final String FOLDER_ENDING = "(/$|[.]generator/$)";

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
	public static List<TemplateConfigXml> readTemplateInformation()
			throws FileNotFoundException, IOException, URISyntaxException {
		List<TemplateConfigXml> templates = new ArrayList<TemplateConfigXml>();
		URL url = TemplateHelper.class.getProtectionDomain().getCodeSource()
				.getLocation();
		File folder = new File(url.getPath().concat(TEMPLATE_FOLDER));
		File[] files;
		if (!folder.isDirectory()) {
			throw new FileNotFoundException("Directory " + folder.toString()
					+ "can't be found in the project.");
		}
		files = folder.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				if (pathname.toString().matches(ARCHIVE_PATTERN))
					return true;
				return false;
			}
		});
		for (int i = 0; i < files.length; i++) {
			TemplateConfigXml read = readArchive(files[i]);
			if (read != null)
				templates.add(read);
		}
		return templates;
	}

	/**
	 * Reads the zip file archive and the templateConfig.xml in it. If not found
	 * a warning is shown.
	 * 
	 * @param file
	 *            the archive the should be read
	 * @return the unmarshalled templateConfig.xml
	 */
	private static TemplateConfigXml readArchive(File file) {
		ZipFile zf = null;
		TemplateConfigXml toReturn = null;
		try {
			zf = new ZipFile(file);
			ZipEntry entry = zf.getEntry(CONFIG_FILENAME);
			if (entry == null) {
				JOptionPane.showMessageDialog(null,
						"Couldn't find the templateConfig.xml inside the template file: "
								+ file.getName(),
						"No template config file found",
						JOptionPane.WARNING_MESSAGE);
				return null;
			}
			InputStream stream = zf
					.getInputStream(zf.getEntry(CONFIG_FILENAME));
			toReturn = (TemplateConfigXml) un.unmarshal(stream);
			Enumeration<? extends ZipEntry> entries= zf.entries();
			while(entries.hasMoreElements()){
				ZipEntry z_entry = entries.nextElement();
				if(z_entry.isDirectory())
					toReturn.addInternalFolder(new Path(z_entry.getName()));
				else
					toReturn.addInternalFile(new Path(z_entry.getName()));
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
	 *            the chosen template
	 * @param projectName
	 *            the new Project name
	 * @param destination
	 *            the destination for the files
	 * @throws IOException
	 *             if something went wrong with unzip and/or writing the files
	 */
	public static List<String> decompress(TemplateConfigXml template,
			String projectName, String destination) throws IOException {
		InputStream resStream = TemplateHelper.class
				.getResourceAsStream(TEMPLATE_FOLDER
						+ template.getFile().getName());
		ZipInputStream zis = new ZipInputStream(new BufferedInputStream(
				resStream));
		List<String> projects = new ArrayList<String>();
		ZipEntry entry;
		while ((entry = zis.getNextEntry()) != null) {
			if (entry.getName().equals(CONFIG_FILENAME))
				continue;
			String oldName = template.getInternalProjectName();
			String entryName = entry.getName().replaceFirst(oldName,
					projectName);
			String path = destination + "/" + entryName;
			if (entry.isDirectory()) {
				if (entryName.matches(projectName + FOLDER_ENDING))
					projects.add(entryName);
				new File(path).mkdirs();
			} else {
				File emptyFile = new File(path);
				if (FILES_WITH_REPLACEMENTS.matcher(emptyFile.toString())
						.find()) {
					fillFile(zis, emptyFile, oldName, projectName);
				} else {
					BufferedOutputStream dest = new BufferedOutputStream(
							new FileOutputStream(path), BUFFER);
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
	 * Fills the file with content and make the necessary changes
	 * 
	 * @param istream
	 *            the inputStream that contains the data
	 * @param file
	 *            the file which will be written
	 * @param oldName
	 *            the old project name
	 * @param projectName
	 *            the new project name
	 * @throws IOException
	 *             if something went wrong with the reading and writing
	 */
	public static void fillFile(InputStream istream, File file,
			String oldName, String projectName) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				istream), BUFFER);
		StringBuilder buffer = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			line = line.replaceAll(oldName, projectName);
			buffer.append(line + System.getProperty("line.separator"));
		}
		FileWriter writer = new FileWriter(file);
		writer.write(buffer.toString());
		writer.close();
	}

	/**
	 * Creates the GeneSEZ-Projects
	 * 
	 * @param template
	 * @param projectName
	 * @param workspace
	 * @throws IOException
	 */
	public static boolean createProject(final TemplateConfigXml template,
			final String projectName, final IWorkspaceRoot workspace) {
		Job createJob = new Job("Creating GeneSEZ Project") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask("Create " + projectName
						+ " GeneSEZ projects.", 100);
				List<String> projects = null;
				try {
					projects = decompress(template, projectName, workspace
							.getLocation().toString());
				} catch (Exception e1) {
					JOptionPane
							.showMessageDialog(null,
									"Decompression of the template failed.",
									"Can't create projects.",
									JOptionPane.ERROR_MESSAGE);
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
		if (createJob.getResult() == Status.OK_STATUS) {
			return true;
		}
		return false;
	}
}