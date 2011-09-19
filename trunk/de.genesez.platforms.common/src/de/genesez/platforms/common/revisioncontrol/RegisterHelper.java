package de.genesez.platforms.common.revisioncontrol;

import java.util.LinkedList;
import java.util.List;

/**
 * Helper class, that keeps all available RCS implementations in a list.
 * 
 * @author Dominik Wetzel
 * @date 2011-09-15
 */
public class RegisterHelper {
	
	private static List<RevisionControlSystem> availableImpls = new LinkedList<RevisionControlSystem>();

	static{
		availableImpls.add(new SubversionImpl());
		availableImpls.add(new GitImpl());
	}
	
	/**
	 * gets available Implementations of RevisionControlSystem
	 * @return a List with available Implementations
	 */
	public static List<RevisionControlSystem> getAvailableRepositoryImpls(){
		return availableImpls;
	}
}
