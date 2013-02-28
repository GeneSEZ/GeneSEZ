package org.genesez.platform.common.typemapping;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324558396939_555275_4743) 
 */

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashSet;

import org.genesez.platform.common.typemapping.types.FileContainer;

import java.util.LinkedList;
/**
 * This class collects the all subtypeMapping files of the specified one in the proper order
 * 
 * @author pethu
 * @date 2009-01-24
 */
public class MappingFileCollector {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** Stores the associated object of association JAXBDELEGATOR to BindingDelegator */
	private BindingDelegator jaxbDelegator;
	
	/**
	 * collects all files referenced or included by the user/typemapping file
	 */
	
	private java.util.Set<String> fileSet = new java.util.LinkedHashSet<String>();
	
	/**
	 * to ensure the proper processing (ordered) of every typemapping file
	 */
	
	private java.util.List<String> workList = new java.util.ArrayList<String>();
	
	// -- generated constructors --------------------------------------------
	/**
	 * initiate the Collections and sets the Delegator 
	 * TODO: or is it better to use static, singleton or factory patterns?
	 * @param	bindingDelegator	the provider of various Binding components
	 */
	public MappingFileCollector(BindingDelegator bindingDelegator) {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1324558716100_95812_4884) ENABLED START */
		fileSet = new LinkedHashSet<String>();
		workList = new LinkedList<String>();
		jaxbDelegator = bindingDelegator;
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * provides the Collection of included files of the specified mapping file
	 * @param	mappingFiles	specific mapping file from which the included mapping files will be gathered
	 * @return	a Set of all referenced typeMapping files (including itself) in the proper order
	 */
	public java.util.Set<String> getMappingFiles(String mappingFiles) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324558740842_928055_4891) ENABLED START */
		fileSet.clear();
		workList.clear();
		if (isExisting(mappingFiles)) {
			fileSet.add(mappingFiles);
			aggregateMappingFiles(mappingFiles);
		}
		return fileSet;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	typeMappingFile	
	 */
	
	private void aggregateMappingFiles(String typeMappingFile) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324558771335_781248_4901) ENABLED START */
		FileContainer fileContainer = jaxbDelegator.getFileContainerByXPath(typeMappingFile, "//tns:include");
		if (fileContainer != null) {
			for (String file : fileContainer.getFileList()) {
				if (!(fileSet.contains(file))) {
					fileSet.add(file);
					// aggregateMappingFiles(file);
					workList.add(file);
				}
			}
		}
		
		if (!workList.isEmpty()) {
			aggregateMappingFiles(workList.remove(0));
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Test if the file is present in the classpath
	 * @param	mappingFile	the mapping file to check
	 * @return	true if the file exists or false if not
	 */
	private boolean isExisting(String mappingFile) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324558815946_23387_4909) ENABLED START */
		// return new File(mappingFile).exists();
		Path path = Paths.get(mappingFile);
		if (path.isAbsolute() && Files.exists(path)) {
			return true;
		}
		if (ClassLoader.getSystemResourceAsStream(mappingFile) != null) {
			return true;
		}
		return false;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324558396939_555275_4743) ENABLED START */
	/* PROTECTED REGION END */
	
}
