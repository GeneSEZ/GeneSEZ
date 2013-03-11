package de.genesez.scriptdoc.htmlgenerator;

import java.util.*;

import de.genesez.scriptdoc.parsing.ExtendScript;
import de.genesez.scriptdoc.parsing.Function;
import de.genesez.scriptdoc.parsing.Script;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337517963731_716922_2791) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class ProvidedFunctionGenerator extends Generator {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static ProvidedFunctionGenerator instance = new ProvidedFunctionGenerator();
	
	public static final String GENERATEDFUNCTIONDIRNAME = "org.genesez.metamodel.core";
	
	private java.util.Set<Script> functionHolder = new java.util.HashSet<Script>();
	
	private File base;
	
	private ClassLoader cl;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>ProvidedFunctionGenerator</b></em>'.
	 */
	public ProvidedFunctionGenerator() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_ce902ca_1337519782831_477050_2991) ENABLED START */
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	public boolean generate() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337519798884_996183_2994) ENABLED START */
		boolean failed = true;
		HashMap<String, File> dirs = new HashMap<String, File>();
		String generatedClassesFolder = base.getPath() + "/" + GENERATEDFUNCTIONDIRNAME + "/bin/";
		File file = new File(generatedClassesFolder);
		URL baseUrl;
		try {
			baseUrl = file.toURL();
			URL[] urls = new URL[] {
				baseUrl
			};
			cl = new URLClassLoader(urls);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		File dir1 = new File(generatedClassesFolder + "org/genesez/metamodel/gcore");
		File dir2 = new File(generatedClassesFolder + "org/genesez/metamodel/gcore/impl");
		File dir3 = new File(generatedClassesFolder + "org/genesez/metamodel/gcore/extension");
		File dir4 = new File(generatedClassesFolder + "org/genesez/metamodel/gcore/util");
		
		dirs.put("org.genesez.metamodel.gcore", dir1);
		dirs.put("org.genesez.metamodel.gcore.impl", dir2);
		dirs.put("org.genesez.metamodel.gcore.extension", dir3);
		dirs.put("org.genesez.metamodel.gcore.util", dir4);
		
		Class<?> c;
		
		for (String p : dirs.keySet()) {
			for (File f : dirs.get(p).listFiles()) {
				if (!f.isDirectory()) {
					c = loadClass(f.getName().replace(".class", ""), p);
					extractFunctions(c);
				}
			}
		}
		return failed;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	className	
	 * @param	pack	
	 * @return	
	 */
	private Class loadClass(String className, String pack) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337519826979_898357_2997) ENABLED START */
		try {
			Class<?> cls = cl.loadClass(pack + "." + className);
			return cls;
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	clazz	
	 */
	private void extractFunctions(Class clazz) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337519941117_558573_3024) ENABLED START */
		String set = "set", get = "get";
		Script s = new ExtendScript();
		s.setFile(new File(clazz.getName()));
		
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			Function setter = new Function(set + field.getName(), "", "");
			Function getter = new Function(get + field.getName(), "", "");
			setter.setScript(s);
			getter.setScript(s);
			s.insertInSymbols(setter);
			s.insertInSymbols(getter);
		}
		
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			Function fu = new Function(method.getName(), "", "");
			fu.setScript(s);
			s.insertInSymbols(fu);
		}
		
		functionHolder.add(s);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	public static ProvidedFunctionGenerator getInstance() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_ce902ca_1337520016840_771923_3027) ENABLED START */
		return instance;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Gets the value of the attribute '<em><b>functionHolder</b></em>'
	 */
	public java.util.Set<Script> getFunctionHolder() {
		return functionHolder;
	}
	
	/**
	 * Gets the value of the attribute '<em><b>base</b></em>'
	 */
	public File getBase() {
		return base;
	}
	
	/**
	 * Sets the value of the attribute '<em><b>base</b></em>'
	 */
	public void setBase(File base) {
		this.base = base;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337517963731_716922_2791) ENABLED START */
	/* PROTECTED REGION END */

}
