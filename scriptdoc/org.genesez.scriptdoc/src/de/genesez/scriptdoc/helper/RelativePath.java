package de.genesez.scriptdoc.helper;

import java.io.*;
import java.util.*;

/**
* this class provides functions used to generate a relative path
* from two absolute paths
* @author David M. Howard
* @author Daniel Sander (last)
*/
public class RelativePath {

	private static List<String> getPathList(File f) {
		List<String> l = new ArrayList<String>();
		File r;
		try {
			r = f.getCanonicalFile();
			while(r != null) {
				l.add(r.getName());
				r = r.getParentFile();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
			l = null;
		}
		return l;
	}
	
	/**
	* figure out a string representing the relative path of
	* 'f' with respect to 'r'
	* @param home home path
	* @param pathToSearchedFile path of file
	*/
	private static String matchPathLists(List<String> home, List<String> pathToSearchedFile) {
		int i, j;
		String s = "";
		
		i = home.size()-1;
		j = pathToSearchedFile.size()-1;
		
		while((i >= 0)&&(j >= 0)&&(home.get(i).equals(pathToSearchedFile.get(j)))) {
			i--;
			j--;
		}
		for(;i>=0;i--) {
			s += ".." + File.separator;
		}
		for(;j>=1;j--) {
			s += pathToSearchedFile.get(j) + File.separator;
		}
		s += pathToSearchedFile.get(j);
		return s;
	}
	
	/**
	* get relative path of File 'f' with respect to 'home' directory
	* example : home = /a/b/c
	* f = /a/d/e/x.txt
	* s = getRelativePath(home,f) = ../../d/e/x.txt
	* @param home base path, should be a directory, not a file, or it doesn't
	make sense
	* @param f file to generate path for
	* @return path from home to f as a string
	*/
	public static String getRelativePath(File home,File f){
		List<String> homelist;
		List<String> filelist;

		if(home.getAbsolutePath().equals(f.getAbsolutePath())) {
			return f.getName();
		}
		else {
			homelist = getPathList(home);
			filelist = getPathList(f);
			return matchPathLists(homelist,filelist).replace("\\", "/");
		}
	}
}

