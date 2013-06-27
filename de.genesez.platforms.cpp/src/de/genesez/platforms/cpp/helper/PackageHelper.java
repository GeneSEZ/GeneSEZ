package de.genesez.platforms.cpp.helper;

import java.util.LinkedList;
import java.util.List;

import de.genesez.metamodel.gcore.MClassifier;
import de.genesez.metamodel.gcore.MModel;
import de.genesez.metamodel.gcore.MPackage;

public class PackageHelper {
	
	private static String getPackagePath(MClassifier mClassifier, String delim){
		StringBuffer buffer = new StringBuffer();
		for( MPackage mPackage = AccessHelper.owningPackage(mClassifier); mPackage != null; mPackage = mPackage.getNestingPackage()){
			if(!(mPackage instanceof MModel))
				buffer.insert(0, mPackage.getName());
			if((mPackage.getNestingPackage() != null)){
				buffer.insert(0, delim);
			}
		}
				
		return buffer.toString();
	}
	
	private static List<String> getPackageList(MClassifier mClassifier){		
		List<String> packageList = new LinkedList<String>();
		for( MPackage mPackage = AccessHelper.owningPackage(mClassifier); mPackage != null; mPackage = mPackage.getNestingPackage()){
			if(!(mPackage instanceof MModel))				
				packageList.add(0, mPackage.getName());			
		}		
		
		return packageList;
	}
	
	public static String getFQPackagePath(MClassifier mClassifier){		
		return 	getPackagePath(mClassifier, System.getProperty("file.separator")) + 
				System.getProperty("file.separator");
	}
	
	public static String getFQPackageNamespace(MClassifier mClassifier){
		List<String> packageList = getPackageList(mClassifier);
		StringBuffer namespace = new StringBuffer();
		for(String pack : packageList){			
			namespace.append(pack);	
			namespace.append("::");
		}

		return namespace.toString().trim();
	}
	
	public static List<String> getNSList(MClassifier mClassifier){
		return getPackageList(mClassifier);
	}
	
	public static String getFQNS(MClassifier mClassifier){		
		return getFQPackageNamespace(mClassifier);
	}
}
