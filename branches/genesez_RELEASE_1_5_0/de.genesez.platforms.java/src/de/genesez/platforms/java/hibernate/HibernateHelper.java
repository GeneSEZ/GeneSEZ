package de.genesez.platforms.java.hibernate;

import java.util.ArrayList;
import java.util.List;

public class HibernateHelper {
	
	/**
	 * holds a list with class names that should be persisted with hibernate
	 */
	private static List<String> hibernateClasses = new ArrayList<String>();
	
	/**
	 * getter for all class names that should be persisted with hibernate
	 * @return	list with names of classes to persist
	 */
	public static List<String> getHibernateClasses() {
		return HibernateHelper.hibernateClasses;
	}
	
	/**
	 * clears all stored hibernate classes
	 */
	public static void clearHibernateClasses() {
		HibernateHelper.hibernateClasses.clear();
	}
	
	/**
	 * adder for classes to persist with hibernate
	 * @param hibernateClass	name of the class to persist
	 */
	public static void addHibernateClass(String hibernateClass) {
		HibernateHelper.hibernateClasses.add(hibernateClass);
	}
}
