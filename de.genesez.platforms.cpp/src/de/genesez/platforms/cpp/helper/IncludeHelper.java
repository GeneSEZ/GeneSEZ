package de.genesez.platforms.cpp.helper;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import de.genesez.metamodel.gcore.MClassifier;
import de.genesez.metamodel.gcore.MElement;
import de.genesez.metamodel.gcore.MGeneric;
import de.genesez.metamodel.gcore.MOperation;
import de.genesez.metamodel.gcore.MParameter;
import de.genesez.metamodel.gcore.MPrimitiveType;
import de.genesez.metamodel.gcore.MProperty;
import de.genesez.metamodel.gcore.MType;

public class IncludeHelper {

	/**
	 * Returns all in the project needed includes.
	 * 
	 * @param mClassifier
	 * @return
	 */
	public static Set<MType> getIncludes(MClassifier mClassifier) {
		Set<MType> mTypes = getTypes(mClassifier);
		mTypes = filterLocalType(mTypes);
		Set<MType> list = new HashSet<MType>();
		Iterator<MType> typeIter = mTypes.iterator();

		while (typeIter.hasNext()) {
			MType t = typeIter.next();
			//System.out.println(mClassifier.getName() + " hat MType: " + t.toString());
			if(t instanceof MClassifier){
				MClassifier temp = (MClassifier) t;
				//filter self include
				if(!temp.getName().equals(mClassifier.getName()))
					list.add(t);
			}else{
				list.add(t);
			}
		}

		return list;
	}
	
	private static Set<MType> getTypes(MClassifier mClassifier) {
		Set<MType> mTypes = new HashSet<MType>();

		for (Object obj : mClassifier.getProperty()) {
			MProperty mProperty = (MProperty) obj;
			mTypes.addAll(getTypes(mProperty));
		}
		for (Object obj : mClassifier.getOperation()) {
			MOperation op = (MOperation) obj;
			mTypes.addAll(getTypes(op));
		}
		for (Object obj : mClassifier.getGeneralization()) {
			mTypes.add((MType) obj);
		}
		for (Object obj : mClassifier.getRealization()) {
			mTypes.add((MType) obj);
		}

		return mTypes;
	}
	
	/**
	 * Returns a set with all type as MType-object of this Element. 
	 * @param element
	 * @return
	 */
	static private Set<MType> getTypes(MElement element) {
		Set<MType> retSet = new HashSet<MType>();
		retSet.clear();

		if (element instanceof MProperty) {
			MProperty prop = (MProperty) element;
			retSet.add(prop.getType());
		} else if (element instanceof MOperation) {
			MOperation op = (MOperation) element;

			MType type = op.getReturnType();
			retSet.add(type);

			for (Object obj : op.getParameter()) {
				MParameter param = (MParameter) obj;
				retSet.add(param.getType());
			}

			for (Object obj : op.getRaisedException()) {
				MType exceptionType = (MType) obj;
				retSet.add(exceptionType);
			}
		}

		return retSet;
	}
	
	static private Set<MType> filterLocalType(Set<MType> typeSet) {
		HashSet<MType> filteredSet = new HashSet<MType>();
		Iterator<MType> typeIter = typeSet.iterator();

		while (typeIter.hasNext()) {
			MType type = typeIter.next();
			if (!(type instanceof MPrimitiveType)
					&& !(type instanceof MGeneric))				
				filteredSet.add(type);
		}

		return filteredSet;
	}
	
	/*
	public static Set<MElement> getSystemIncludes(MClassifier mClassifier) {
		Set<MElement> mElements = getMultiTypes(mClassifier);		
		return mElements;
	}
	
	public static List<MType> getGlobalIncludes(MClassifier mClassifier) {
		Set<MType> mTypes = getTypes(mClassifier);
		LinkedList<MType> list = new LinkedList<MType>();
		Iterator<MType> typeIter = null;

		mTypes = filterExternalType(mTypes);
		typeIter = mTypes.iterator();

		while (typeIter.hasNext()) {
			MType t = typeIter.next();
			list.add(t);
		}

		return list;
	}
	*/

	/**
	 * Returns all in the project needed includes.
	 * 
	 * @param mClassifier
	 * @return
	 */
	/*
	public static List<MType> getLocalIncludes(MClassifier mClassifier) {
		Set<MType> mTypes = filterLocalType(getTypes(mClassifier));
		LinkedList<MType> list = new LinkedList<MType>();
		Iterator<MType> typeIter = mTypes.iterator();

		while (typeIter.hasNext()) {
			MType t = typeIter.next();
			if(t instanceof MClassifier){
				MClassifier temp = (MClassifier) t;
				//filter self include
				if(!temp.getName().equals(mClassifier.getName()))
					list.add(t);
			}			
		}

		return list;
	}
	*/
	
	/*
	private static Set<MElement> getMultiTypes(MClassifier mClassifier) {
		Set<MElement> mElements = new HashSet<MElement>();
		boolean nuo = false;
		boolean u = false;
		boolean o = false;
		boolean uo = false;
				
		for (Object obj : mClassifier.getProperty()) {
			MProperty mProperty = (MProperty) obj;
			if (mProperty.getMultiplicity() != 1 && !mProperty.isDerived()){
				if(!nuo && !mProperty.isUnique() && !mProperty.isOrdered()){
					mElements.add(mProperty);
					nuo = true;
				}
				if(!u && mProperty.isUnique() && !mProperty.isOrdered()){
					mElements.add(mProperty);
					u = true;
				}
				if(!o && !mProperty.isUnique() && mProperty.isOrdered()){
					mElements.add(mProperty);
					o = true;
				}
				if(!uo && mProperty.isUnique() && mProperty.isOrdered()){
					mElements.add(mProperty);
					uo = true;
				}
			}		
		}

		for (Object obj : mClassifier.getOperation()) {
			MOperation op = (MOperation) obj;

			if(op.getMultiplicity() != 1){
				if(!nuo && !op.isUnique() && !op.isOrdered()){
					mElements.add(op);
					nuo = true;
				}
				if(!u && op.isUnique() && !op.isOrdered()){
					mElements.add(op);
					u = true;
				}
				if(!o && !op.isUnique() && op.isOrdered()){
					mElements.add(op);
					o = true;
				}
				if(!uo && op.isUnique() && op.isOrdered()){
					mElements.add(op);
					uo = true;
				}
			}
				
			
			for (Object obj2 : op.getParameter()) {
				MParameter param = (MParameter) obj2;
				if (param.getMultiplicity() != 1){
					if(!nuo && !param.isUnique() && !param.isOrdered()){
						mElements.add(param);
						nuo = true;
					}
					if(!u && param.isUnique() && !param.isOrdered()){
						mElements.add(param);
						u = true;
					}
					if(!o && !param.isUnique() && param.isOrdered()){
						mElements.add(param);
						o = true;
					}
					if(!uo && param.isUnique() && param.isOrdered()){
						mElements.add(param);
						uo = true;
					}
				}
					
			}
		}
		return mElements;
	}
	*/	
	
	/*
	static private Set<MType> filterExternalType(Set<MType> typeSet) {
		HashSet<MType> filteredSet = new HashSet<MType>();
		Iterator<MType> typeIter = typeSet.iterator();

		while (typeIter.hasNext()) {
			MType type = typeIter.next();
			if (type instanceof MExternal)
				filteredSet.add(type);
		}

		return filteredSet;
	}
	*/
}
