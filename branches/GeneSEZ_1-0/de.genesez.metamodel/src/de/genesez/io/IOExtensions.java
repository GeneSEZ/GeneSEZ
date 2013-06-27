package de.genesez.io;

import java.util.logging.Level;

/**
 * Helper Class (a kind of facade) for debug/logging output.
 * Methods are called from the functions in io.ext and 
 * delegated to the Output Class, which uses java logging API.
 * 
 * @author geobe, nicher, toh
 */
public class IOExtensions {
	
	
//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	-- configuration --
//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	/**
	 * enables logging for the specified level
	 * @param level		the log level to enable
	 */
	public static void enableLogging(String level) {
		if (level == null) {
			Output.enableLogging();
		}
		if (level.equals("finest")) {
			Output.enableLogging(Level.FINEST);
		}
		if (level.equals("finer")) {
			Output.enableLogging(Level.FINER);
		}
		if (level.equals("fine")) {
			Output.enableLogging(Level.FINE);
		}
		if (level.equals("config")) {
			Output.enableLogging(Level.CONFIG);
		}
		if (level.equals("info")) {
			Output.enableLogging(Level.INFO);
		}
		if (level.equals("warning")) {
			Output.enableLogging(Level.WARNING);
		}
		if (level.equals("severe")) {
			Output.enableLogging(Level.SEVERE);
		}
	}
	
	
//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	-- logging --
//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	/**
	 * loggs a string with log level severe
	 * @param s		string to log
	 * @return		logged string
	 */
	public static final String severe(final String s) {
		Output.getLogger().severe(s);
		return s;
	}
	
	/**
	 * loggs an object with log level severe
	 * @param s		object to log
	 * @return		logged object
	 */
	public static final Object severe(final Object obj) {
		Output.getLogger().severe(Output.toDebugString(obj));
		return obj;
	}
	
	/**
	 * loggs a string with log level warning
	 * @param s		string to log
	 * @return		logged string
	 */
	public static final String warning(final String s) {
		Output.getLogger().warning(s);
		return s;
	}
	
	/**
	 * loggs an object with log level warning
	 * @param s		object to log
	 * @return		logged object
	 */
	public static final Object warning(final Object obj) {
		Output.getLogger().warning(Output.toDebugString(obj));
		return obj;
	}
	
	/**
	 * loggs a string with log level info
	 * @param s		string to log
	 * @return		logged string
	 */
	public static final String info(final String s) {
		Output.getLogger().info(s);
		return s;
	}
	
	/**
	 * loggs an object with log level info
	 * @param s		object to log
	 * @return		logged object
	 */
	public static final Object info(final Object obj) {
		Output.getLogger().info(Output.toDebugString(obj));
		return obj;
	}
	
	/**
	 * loggs a string with log level config
	 * @param s		string to log
	 * @return		logged string
	 */
	public static final String config(final String s) {
		Output.getLogger().config(s);
		return s;
	}
	
	/**
	 * loggs an object with log level config
	 * @param s		object to log
	 * @return		logged object
	 */
	public static final Object config(final Object obj) {
		Output.getLogger().config(Output.toDebugString(obj));
		return obj;
	}
	
	/**
	 * loggs a string with log level fine
	 * @param s		string to log
	 * @return		logged string
	 */
	public static final String fine(final String s) {
		Output.getLogger().fine(s);
		return s;
	}
	
	/**
	 * loggs an object with log level fine
	 * @param s		object to log
	 * @return		logged object
	 */
	public static final Object fine(final Object obj) {
		Output.getLogger().fine(Output.toDebugString(obj));
		return obj;
	}
	
	/**
	 * loggs a string with log level finer
	 * @param s		string to log
	 * @return		logged string
	 */
	public static final String finer(final String s) {
		Output.getLogger().finer(s);
		return s;
	}
	
	/**
	 * loggs an object with log level finer
	 * @param s		object to log
	 * @return		logged object
	 */
	public static final Object finer(final Object obj) {
		Output.getLogger().finer(Output.toDebugString(obj));
		return obj;
	}
	
	/**
	 * loggs a string with log level finest
	 * @param s		string to log
	 * @return		logged string
	 */
	public static final String finest(final String s) {
		Output.getLogger().finest(s);
		return s;
	}
	
	/**
	 * loggs an object with log level finest
	 * @param s		object to log
	 * @return		logged object
	 */
	public static final Object finest(final Object obj) {
		Output.getLogger().finest(Output.toDebugString(obj));
		return obj;
	}
}
