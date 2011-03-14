package de.genesez.platforms.cpp.helper;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import de.genesez.metamodel.gcore.MClassifier;
import de.genesez.metamodel.gcore.MDefinitionContext;
import de.genesez.metamodel.gcore.MPackage;

public class IncludeHelper {
	private static List<String> relPath = new LinkedList<String>();
	private static Set<MPackage> visitedPkgs = new HashSet<MPackage>(); 
	
	/**
	 * Returns a string with the realtive path of the packages from start to goal.  
	 * @param start classifier which wants to include the goal
	 * @param goal classifier to be included by start
	 * @return String of the relative path between the packages of both classifiers
	 */
	public static String getRelativePath(MClassifier start, MClassifier goal) {
		relPath.clear();
		visitedPkgs.clear();
		
		isPathElement(AccessHelper.owningPackage(start), AccessHelper.owningPackage(goal), Direction.FIRST);
		
		String finalPath = "";		
		for(String part : relPath) {
			finalPath = part + finalPath;
		}
		
		return finalPath;
	}
	
	/**
	 * Checks, if the aPkg is part of the relative path to the tPkg. It's a recursive
	 * function which calls itself to check the next part. If the call is returning a true
	 * value it is part of the path and so the current part too. 
	 * @param aPkg current examined package
	 * @param tPkg target package to which the path is searched
	 * @param dir the direction in the tree of packages
	 * @return True if part of the path
	 */
	private static boolean isPathElement(MPackage aPkg, MPackage tPkg, Direction dir) {
		visitedPkgs.add(aPkg);
		
		if(aPkg == tPkg) {
			if(dir == Direction.DOWN)
				relPath.add(aPkg.getName() + "/");
			return true;
		} else {
			for(Object cObj :aPkg.getNestedPackage()) {
				MPackage child = (MPackage) cObj;
				if(!visitedPkgs.contains(child)) {				 
					if(isPathElement(child, tPkg, Direction.DOWN)) {
						if(dir != Direction.UP && dir != Direction.FIRST)
							relPath.add(aPkg.getName() + "/");
						return true;
					}
				}				
			}
			
			if(aPkg.getNestingPackage() != null && !visitedPkgs.contains(aPkg.getNestingPackage()) && isPathElement(aPkg.getNestingPackage(), tPkg, Direction.UP)){
				relPath.add("../");
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Enumeration to define the direction in the tree of packages
	 * @author robme
	 *
	 */
	private static enum Direction { UP, DOWN, FIRST };
}
