package de.genesez.core;

import java.util.Map;
import java.util.Set;

public interface IPlatformWizard {

	String getName();
	
	Set<String> getBundles();
	
	Set<String> getGeneratorDirectories();
	
	Set<String> getProjectDirectories();
	
	Map<String, String> getGeneratorFiles();
	
	Map<String, String> getProjectFiles();
}
