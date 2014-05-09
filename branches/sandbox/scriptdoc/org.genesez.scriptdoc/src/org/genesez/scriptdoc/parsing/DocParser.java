package org.genesez.scriptdoc.parsing;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import de.genesez.scriptdoc.helper.ExecutableHelper;
import de.genesez.scriptdoc.htmlgenerator.*;
import de.genesez.scriptdoc.htmlgenerator.templates.HtmlTemplate;
import de.genesez.scriptdoc.parsing.Roots;

public class DocParser {

	/**
	 * @param args
	 *            - Index 0: 1 - stats will be generated, 0 no stats 
	 */
	public static void main(String[] args) {
		System.out.println("starting scriptdoc process...");
		long now = System.currentTimeMillis();

		String metamodelCore = "T:/IDEs/eclipse-java-kepler-64/eclipseGeneSEZ/plugins/"
				+ "org.genesez.metamodel.core_3.0.0.v20140325-1531.jar";
		String scriptDocFolder = /*"T:/workspaces/swt.master.2014/org.genesez.scriptdoc/*/"/scriptdoc2";

		ParseHelper parseHelper = new ParseHelper();

		parseHelper.initialize(metamodelCore);

		parseHelper.parseBaseWithPaths(
				"T:/IDEs/eclipse-java-kepler-64/eclipseGeneSEZ/plugins/"
						+ "org.genesez.platform.java_3.0.2.v20140325-1531",
				"jpa", "cdi", "di4java", "ejb3", "ejb3_1", "java", "jbv",
				"jpa", "jws", "seam2");
		parseHelper.parseBaseWithPaths(
				"T:/IDEs/eclipse-java-kepler-64/eclipseGeneSEZ/plugins/"
						+ "org.genesez.util_1.0.1.v20140325-1531",
				"filesystem", "logging", "sysenv", "util");
		parseHelper
				.parseBaseWithPaths(
						"T:/IDEs/eclipse-java-kepler-64/eclipseGeneSEZ/plugins/"
								+ "org.genesez.mapping_1.0.0.v20140325-1531",
						"mapping");
		parseHelper
				.parseBaseWithPaths(
						"T:/IDEs/eclipse-java-kepler-64/eclipseGeneSEZ/plugins/"
								+ "org.genesez.metamodel.core.util_1.0.3.v20140325-1531",
						"m2m", "mapping", "profile", "util", "validation");
		parseHelper
				.parseBaseWithPaths(
						"T:/IDEs/eclipse-java-kepler-64/eclipseGeneSEZ/plugins/"
								+ "org.genesez.metamodel.traceability.util_1.0.0.v20140325-1531",
						"dashboard", "java", "navigation");
		parseHelper.parseBaseWithPaths(
				"T:/IDEs/eclipse-java-kepler-64/eclipseGeneSEZ/plugins/"
						+ "org.genesez.statistic_1.0.0.v20140325-1531",
				"statistic");
		parseHelper.parseBaseWithPaths(
				"T:/IDEs/eclipse-java-kepler-64/eclipseGeneSEZ/plugins/"
						+ "org.genesez.adapter.uml2_3.0.8.v20140325-1531",
				"gcore", "gpresentation", "uml2");

		parseHelper.generateHtml(false, scriptDocFolder);

		long elapsed = System.currentTimeMillis();
		System.out.println("scriptdoc process finished in: " + (elapsed - now)
				+ "ms");
	}

	private static class ParseHelper {
		HtmlGenerator gen = new HtmlGenerator();
		Roots roots = new Roots();
		ArrayList<File> bases = new ArrayList<>();
		// home of script files
		String base;
		// scriptdoc home
		String scriptDocFolder;

		/**
		 * initialize doc generator with built-in functions and EMF provided
		 * functions
		 * 
		 * @param pathToMetamodelCore
		 *            path to the GeneSEZ Metamodel Core jar file
		 */
		public void initialize(String pathToMetamodelCore) {
			/* loading built-in functions */
			BuiltInLoader.getInstance().setRoot(".");
			BuiltInLoader.getInstance().generate();
			/* generating the functions that are provided automatically by EMF */
			ProvidedFunctionGenerator.getInstance().setBase(
					new File(pathToMetamodelCore));
			ProvidedFunctionGenerator.getInstance().generate();
			ExecutableHelper.getInstance()
					.setGeneratedFunctionHolder(
							ProvidedFunctionGenerator.getInstance()
									.getFunctionHolder());
		}

		/**
		 * parse genesez scripts; must be called for every base folder before
		 * generating html documentation
		 * 
		 * @param base
		 *            common base folder of scripts, typically an eclipse plugin
		 *            folder or a user supplied customisation folder
		 * @param paths
		 *            folders directly under base that contain scripts
		 */
		public void parseBaseWithPaths(String base, String... paths) {
			Set<File> directories = new LinkedHashSet<File>();
			bases.add(new File(base));
			for (String path : paths) {
				directories.add(new File(base + "/" + path));
			}
			roots.setBase(new File(base));
			roots.setPaths(directories);
			roots.parse();
		}

		/**
		 * generate html docomentation. must be called after parsing
		 * <em>all</em> script folders
		 * 
		 * @param withStats
		 *            generate statistics - might take quite a while
		 * @param scriptPath
		 *            output folder for generated documentation
		 */
		public void generateHtml(boolean withStats, String scriptPath) {
			gen = new HtmlGenerator();
			HtmlTemplate.setScriptPat(scriptPath);
			gen.setTable(roots.getTable());
			gen.setBases(bases);
			gen.setBase(roots.getBase());
			gen.setRoot(scriptDocFolder);
			gen.setWithStats(withStats);
			gen.generate();
		}

	}
}
