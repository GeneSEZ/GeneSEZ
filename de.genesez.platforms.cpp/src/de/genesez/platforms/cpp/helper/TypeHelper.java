package de.genesez.platforms.cpp.helper;

import de.genesez.metamodel.gcore.MClass;
import de.genesez.metamodel.gcore.MOperation;
import de.genesez.metamodel.gcore.MParameter;
import de.genesez.metamodel.gcore.MTaggedValue;

public class TypeHelper {
	
	/**
	 * checks if passed MClass has at least one abstract method.
	 * If one MOperation is abstract the MClass object is too. 
	 * @param mClass
	 * @return
	 */	
	public static boolean checkAndSetAbstract(MClass mClass){
		for(Object obj : mClass.getOperation()){
			MOperation op = null;
			if(obj instanceof MOperation){
				op = (MOperation) obj;
				if(op.isAbstract()){
					mClass.setAbstract(true);
					return true;
				}
			}			
		}
		return false;
	}
	
	public static String printStereoTypes(MParameter mParameter){		
		for(Object obj : mParameter.getTaggedValue()){
			if(obj instanceof MTaggedValue){
				MTaggedValue mTaggedValue = (MTaggedValue) obj;
				return "value: " + mTaggedValue.getValue();	
			}
		}
		return "no StereoType";
	}
}
