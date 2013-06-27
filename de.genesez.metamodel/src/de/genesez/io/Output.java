package de.genesez.io;
/*
 * Output.java
 * 
 * created on 11.08.2005
 * 
 * version history:
 * 2005-08-11	dreamer		inital version
 * 
 */
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
/**
 * Manages all the output and logging stuff.
 * Provides the logger object from the Logging- API with appenders.
 * 
 * @author doreenn, madlen, patrick, tobias
 * @version 2005-04-27
 */
public class Output {
	
	/** the newline character */
	public static final String NEWLINE = System.getProperty("line.separator", "\n");
	
	/** date and time format string */
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z");
	
	/** the logger */
	private static Logger logger = Logger.getLogger("GeneSEZ");
	
	/** some handlers for the logger */
	private static ConsoleHandler ch = null;
	
	/** the output object */
	private static Output output = null;
	
	
	/*-*******************************************************************
	 * static initialization
	 *-*******************************************************************/
	
	/** initialize the logger object */
	static {
		// the logger should process all messages
		logger.setLevel(Level.ALL);
		// disable default console handler
		logger.setUseParentHandlers(false);
		// new console handler with pretty formatter
		ch = new ConsoleHandler();
		ch.setFormatter(Output.getSimpleFormatter());
		ch.setLevel(Level.ALL);
		// append new console handler to logger
		logger.addHandler(ch);
	}
	
	
	/*-*******************************************************************
	 * static getter + setter
	 *-*******************************************************************/
	
	/**
	 * getter for the Logger object
	 * @return		the logger object
	 */
	public static Logger getLogger() {
		return logger;
	}
	
	/**
	 * getter for the Output object
	 * @return		the output object
	 */
	public static Output getOutput() {
		if (output == null) {
			// next line was commented, but why ?
 			output = new Output();
		}
		return output;
	}
	
	
	/*-*******************************************************************
	 * public static functions
	 *-*******************************************************************/
	
	/**
	 * enables logging for all log levels
	 */
	public static void enableLogging() {
		logger.setLevel(Level.ALL);
	}
	
	/**
	 * enables logging for the specified level
	 * @param level		log level to enable
	 */
	public static void enableLogging(Level level) {
		logger.setLevel(level);
	}
	
	/**
	 * disables that logger, but the not output
	 */
	public static void disableLogging() {
		//	more simple posibility
		logger.setLevel(Level.OFF);
//		logger.setFilter(new Filter() {
//
//			/**
//			 * @see java.util.logging.Filter#isLoggable(java.util.logging.LogRecord)
//			 */
//			public boolean isLoggable(LogRecord arg0) {
//				// nothing should be logged
//				return false;
//			}
//		});
	}
	
	/**
	 * converts the given object to a detailed string representation using refelection
	 * 
	 * @param o		object to convert into a string representation
	 * @return		string representation of the given object
	 */
	public static String toDebugString(Object o) {
		if (o == null) {
			return "null";
		}
		ArrayList<String> list = new ArrayList<String>();
		Class clazz = o.getClass();
		convertToString(o, clazz, list);
		return list.toString();
	}
	
	
	/*-*******************************************************************
	 * private static stuff
	 *-*******************************************************************/
	
	/**
	 * getter for a formatter object for simple console output
	 * @return		simple formatter object
	 */
	private static Formatter getSimpleFormatter() {
		return new Formatter() {
			public String format(LogRecord record) {
				StringBuffer msg = new StringBuffer();
				msg.append("#  ");
				msg.append(record.getMessage());
				msg.append(Output.NEWLINE);
				return msg.toString();
			}
		};
	}
	
	/**
	 * getter for a formatter object for a more complex logfile output
	 * @return		a more complex formatter object
	 */
	private static Formatter getFormatter() {
		return new Formatter() {
			public String format(LogRecord record) {
				StringBuffer msg = new StringBuffer();
				msg.append("#  [ ");
				msg.append(record.getSourceClassName());
				msg.append(" ]");
				msg.append(" [ ");
				msg.append(record.getSourceMethodName());
				msg.append(" ]");
				msg.append(" @ [ ");
				msg.append(sdf.format(record.getMillis()));
				msg.append(" ]");
				msg.append(Output.NEWLINE);
				msg.append("   ");
				msg.append(record.getMessage());
				msg.append(Output.NEWLINE);
				// print throwable
				if (record.getThrown() != null) {
					msg.append("   ");
					msg.append(record.getThrown());
					msg.append(Output.NEWLINE);
					msg.append(getStackTrace(record.getThrown()));
				}
				return msg.toString();
			}
		};
	}
	
	/**
	 * getter for a nice formatted stack trace
	 * @param e		a throwable
	 * @return		nice formatted stack trace from given throwable
	 */
	private static String getStackTrace(Throwable e) {
		StringBuffer sb = new StringBuffer();
		StackTraceElement[] stes = e.getStackTrace();
		for (int i=0; i < stes.length; i++) {
			StackTraceElement ste = stes[i];
			sb.append("     at: ");
			sb.append(ste);
			sb.append(Output.NEWLINE);
		}
		return sb.toString();
	}
	
	private static void convertToString(Object o, Class clazz, List<String> list) {
		Field[] fields = clazz.getDeclaredFields();
		// make fields accessible
		AccessibleObject.setAccessible(fields, true);
		for (Field f : fields) {
			try {
				if (f.getType().isArray()) {
//					List<String> arrayList = new ArrayList<String>();
//					Object[] os = (Object[])f.get(o);
//					for (Object obj : os) {
//						arrayList.add(obj.toString());
//					}
//					list.add(f.getName() + " = " + arrayList.toString());
					list.add(f.getName() + " = " + ((Object[])f.get(o)).length);
				} else {
					list.add(f.getName() + " = " + f.get(o));
				}
			} catch (IllegalAccessException e) {
				list.add("-- no access --");
			}
		}
		// check for superclasses
		if (clazz.getSuperclass() != null) {
			convertToString(o, clazz.getSuperclass(), list);
		}
	}
	
	
	/*-*******************************************************************
	 * constructor [ protected ]
	 *-*******************************************************************/
	
	/** protected constructor for the *singleton* object */
	protected Output() {
	}
	
	
	/*-*******************************************************************
	 * methods
	 *-*******************************************************************/
	
	/**
	 * prints the given string on the standart output
	 * 
	 * @param s - String containing the message
	 */
	public void printMessage(String s) {
		StringBuffer sb = new StringBuffer();
		sb.append("#  ");
		sb.append(s);
		System.out.println(sb);
	}
}
