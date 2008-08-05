package de.genesez.platforms.qftest;

public class Helper {

	private static int id = 0;
	
	public static String getId() {
		String id = "_" + Helper.id;
		Helper.id++;
		return id;
	}
}
