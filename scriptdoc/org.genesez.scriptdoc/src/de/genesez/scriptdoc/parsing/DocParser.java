package de.genesez.scriptdoc.parsing;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import de.genesez.scriptdoc.helper.ExecutableHelper;
import de.genesez.scriptdoc.htmlgenerator.*;

public class DocParser {

	/**
	 * @param args - Index 0: 1 - stats will be generated, 0 no stats
	 * 			   - Index 1+ - the paths
	 */
	public static void main(String[] args) {
		System.out.println("starting scriptdoc process...");
		long now = System.currentTimeMillis();
		// home of script files
		String base;
		// scriptdoc home
		String scriptDocFolder;
		// the calculation of the statistics takes some time..
		// ..especially for bigger projects!
		boolean withStats  = false;	

		ArrayList<String> paths = new ArrayList<String>();
		Set<File> directories = new LinkedHashSet<File>();

		if(args.length == 0) {
			base = "/home/nicher/workspace/workspace.genesez_scriptdoc";
			scriptDocFolder  = "scriptdoc";
		} else {
			if(args[0] == "1") {
				withStats = true;
			}
			base = args[1];
			scriptDocFolder  = args[2];
		}
		if(args.length > 2) {
			for( int i = 1; i < args.length; i++) {
				paths.add(args[i]);
			}
		} else {
			// some test scripts
			paths.add("org.genesez.util");
			//paths.add("org.genesez.platform.java/java5");
			//paths.add("org.genesez.platform.java/java");

			// complete genesez
			/*
			paths.add("org.eclipse.emf.ecore.adapter.uml");
			paths.add("org.genesez.adapter.ea");
			paths.add("org.genesez.adapter.magicdraw");
			paths.add("org.genesez.adapter.uml2");
			paths.add("org.genesez.build");
			paths.add("org.genesez.feature");
			paths.add("org.genesez.featuregroup");
			paths.add("org.genesez.headless");
			paths.add("org.genesez.metamodel.core");
			paths.add("org.genesez.metamodel.requirements");
			paths.add("org.genesez.metamodel.testing");
			paths.add("org.genesez.metamodel.traceability");
			paths.add("org.genesez.platform.common");
			paths.add("org.genesez.platform.cpp");
			paths.add("org.genesez.platform.dashboard");
			paths.add("org.genesez.platform.documentation");
			paths.add("org.genesez.platform.dotnet");
			paths.add("org.genesez.platform.java");
			paths.add("org.genesez.platform.php");
			paths.add("org.genesez.platform.qftest");
			paths.add("org.genesez.platform.typo3");
			paths.add("org.genesez.platforms.generator");
			paths.add("org.genesez.platforms.generator");
			paths.add("org.genesez.tools");
			*/
		}
		for (String pathName : paths) {
			directories.add(new File(base + "/" + pathName));
		}
		
		/* loading built-in functions */
		BuiltInLoader.getInstance().setRoot(".");
		BuiltInLoader.getInstance().generate();
		
		/* generating the provided function that are provided automatically by EMF */
		ProvidedFunctionGenerator.getInstance().setBase(new File(base));
		ProvidedFunctionGenerator.getInstance().generate();
		ExecutableHelper.getInstance().setGeneratedFunctionHolder(
				ProvidedFunctionGenerator.getInstance().getFunctionHolder());
		
		Roots roots = new Roots();
		roots.setBase(new File(base));
		roots.setPaths(directories);
		roots.parse();
		
		HtmlGenerator gen = new HtmlGenerator();
		gen.setTable(roots.getTable());
		gen.setBase(roots.getBase());
		gen.setRoot(scriptDocFolder);
		gen.setWithStats(withStats);
		gen.generate();

		long elapsed = System.currentTimeMillis();
		System.out.println("scriptdoc process finished in: " + (elapsed - now) + "ms"); 
	}
}
