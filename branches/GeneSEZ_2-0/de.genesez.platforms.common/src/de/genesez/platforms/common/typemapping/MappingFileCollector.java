package de.genesez.platforms.common.typemapping;

import java.util.LinkedHashSet;
import java.util.LinkedList;

import de.genesez.platforms.common.typemapping.types.FileContainer;

/**
 * This class collects the all subtypeMapping files of the specified one in the
 * proper order
 * 
 * @author pethu
 * @date 2009-01-24
 */
public class MappingFileCollector {
	
	/**
	 * collects all files referenced or included by the user/typemapping file
	 */
	private LinkedHashSet<String> fileSet;

	/**
	 * to ensure the proper processing (ordered) of every typemapping file
	 */
	private LinkedList<String> workList;
	/**
	 * BindingDelegator to unmarshall each include Node TODO maybe the
	 * BindingDelegator could be refactored to work more specific for the
	 * MappingFileCollector
	 */
	private BindingDelegator jaxbDelegator;

	/**
	 * initiate the Collections and sets the Delegator TODO or is it better to
	 * use static, singleton or factory patterns?
	 * 
	 * @param bindingDelegator
	 *            the provider of various Binding components
	 */
	public MappingFileCollector(BindingDelegator bindingDelegator) {
		fileSet = new LinkedHashSet<String>();
		workList = new LinkedList<String>();
		jaxbDelegator = bindingDelegator;
	}

	/**
	 * provides the Collection of included files of the specified mapping file
	 * 
	 * @param mappingFile
	 *            specific mapping file from which the included mapping files
	 *            will be gathered
	 * @return a LinkeHashset of all referenced typeMapping files (including
	 *         itself) in the proper order
	 */
	public LinkedHashSet<String> getMappingFiles(String mappingFile) {

		fileSet.clear();
		workList.clear();
		if (isExisting(mappingFile)) {
			fileSet.add(mappingFile);
			aggregateMappingFiles(mappingFile);
		}
		return fileSet;
	}

	/**
	 * recursive method to gather all Mappingfiles in the correct order files
	 * the fileSet containing all unique references to the typemapping files
	 * first come first serve priority of the File Strings in the LinkedHashSet
	 * Realization of a bread-first parsing, commented part realizes the
	 * bread-first approach
	 * 
	 * @param typeMappingFile
	 *            the specified typeMapping file
	 */
	private void aggregateMappingFiles(String typeMappingFile) {
		FileContainer fileContainer = jaxbDelegator.getFileContainerByXPath(
				typeMappingFile, "//tns:include");
		if (fileContainer != null) {
			for (String file : fileContainer.getFileList()) {
				if (!(fileSet.contains(file))) {
					fileSet.add(file);
					// aggregateMappingFiles(file);
					workList.addLast(file);
				}
			}
		}

		if (!workList.isEmpty()) {
			aggregateMappingFiles(workList.removeFirst());
		}

	}

	/**
	 * Test if the file is present in the classpath
	 * 
	 * @param mappingFile
	 * @return true if the file exists or false if not
	 */
	private boolean isExisting(String mappingFile) {
		// return new File(mappingFile).exists();
		if (ClassLoader.getSystemResourceAsStream(mappingFile) != null) {
			return true;
		}
		return false;
	}
}
