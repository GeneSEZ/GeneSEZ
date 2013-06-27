package de.genesez.java.helper;

import java.util.ArrayList;
import java.util.List;

import genesezMM.MModel;

public class GlobalStore {

	private static MModel model;
	
	private static List<String> hibernateClasses = new ArrayList<String>();
	
	public static MModel getModel() {
		return model;
	}
	
	public static void setModel(MModel mod) {
		model = mod;
	}

	public static List<String> getHibernateClasses() {
		return hibernateClasses;
	}

	public static void clearHibernateClasses() {
		hibernateClasses.clear();
	}

	public static void addHibernateClass(String hibernateClass) {
		GlobalStore.hibernateClasses.add(hibernateClass);
	}
}
