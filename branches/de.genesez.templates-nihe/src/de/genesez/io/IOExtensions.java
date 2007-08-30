package de.genesez.io;

/**
 * Helper Class for debug output. Methods are called from the functions in
 * io.ext
 * 
 * @author geobe, nicher
 */
public class IOExtensions {

	/**
	 * Print a Object by the toString()-method to the system error print stream.
	 * 
	 * @param obj
	 * @return
	 */
	public final static String info(final Object obj) {
		System.err.println(obj);
		return obj.toString();
	}

}