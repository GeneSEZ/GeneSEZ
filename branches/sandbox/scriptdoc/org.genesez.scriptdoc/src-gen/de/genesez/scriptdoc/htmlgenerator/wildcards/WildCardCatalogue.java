package de.genesez.scriptdoc.htmlgenerator.wildcards;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.genesez.scriptdoc.helper.*;
import org.genesez.scriptdoc.parsing.*;

import de.genesez.scriptdoc.parsing.Executable;
import de.genesez.scriptdoc.parsing.Function;
import de.genesez.scriptdoc.parsing.IContent;
import de.genesez.scriptdoc.parsing.Script;
import de.genesez.scriptdoc.parsing.ScriptPackage;
import de.genesez.scriptdoc.parsing.SymbolTable;
import de.genesez.scriptdoc.parsing.Template;
import de.genesez.scriptdoc.parsing.Validation;
import de.genesez.scriptdoc.helper.StatsHelper;
import de.genesez.scriptdoc.helper.StringHelper;
import de.genesez.scriptdoc.htmlgenerator.LinkGenerator;
import de.genesez.scriptdoc.htmlgenerator.templates.ExecutableIndexTemplate;
import de.genesez.scriptdoc.parsing.Function.OwnerType;

/* PROTECTED REGION ID(java.type.import._17_0_1_ce902ca_1337456316761_168907_3188) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author EmpeROOR
 */
public class WildCardCatalogue {
	
	// -- generated attribute, constant + association declarations ----------
	
	public static final String NOHEADCOMMENT = "HEADCOMMENT IS MISSING";
	
	public static final String NOIMPORT = "NO IMPORT";
	
	public static final String NOHEADEXTENSIONS = "NO EXTENSIONS REFERENCED";
	
	public static final String NOCALLS = "NONE";
	
	public static final String NOCALLERS = "NONE";
	
	public static final String NOEXECUTABLECDOCUMENTATION = "";
	
	public static final String NOTFOUND = "NOT FOUND (!)";
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_ce902ca_1337456316761_168907_3188) ENABLED START */
	
	/*
	 * builds the content of a bundleframe
	 * @param c - the usefull data
	 * @param suffix - the file extension
	 */
	public static List<String> getBundleFrameReplacement(IContent c, String suffix) {
		List<String> repl = new ArrayList<String>();
		SymbolTable table = (SymbolTable) c;
		StringBuilder builder;
		List<Script> tmpRepl = new ArrayList<Script>();
		
		for (ScriptPackage pack : table.getPackages()) {
			for (Script script : pack.getScripts()) {
				if(script.getFile().getName().endsWith(suffix)) {
					tmpRepl.add(script);
				}
			}	
		}
		
		Collections.sort(tmpRepl);
		
		for (Script script : tmpRepl) {
			builder = new StringBuilder();
			builder.append("<B><A HREF=\"").append(script.getLink())
			.append("\"").append(" title=\"script in ").append(script.getPack().getName())
			.append("\" target=\"detailFrame\">").append(script.getFile().getName());
			repl.add(builder.toString());
		}
		return repl;
	}

	/*
	 * 
	 * wildcards used to insert content, espacially for scripts
	 * 
	 */
	
	/*
	 * inserts the package path of the specified script
	 */
	public static class NameSpaceWildCard extends SingleValueWildCard {

		public NameSpaceWildCard() {
			this.values.add("@@@NameSpace@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			this.replacement = s.getPack().getName() + "::" + s.getFile().getName();		
		}
	}
	
	/*
	 * inserts the dir path of the specified script
	 */
	public static class EclipseProjectPathWildCard extends SingleValueWildCard {

		public EclipseProjectPathWildCard() {
			this.values.add("@@@EclipseProjectPath@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			String root = s.getRoot().getBase().getPath();
			this.replacement = StringHelper.separateEclipsProjectPathOutOfFile(
					s.getFile(), root);		
		}
	}
	
	/*
	 * inserts the project path of the specified script
	 */
	public static class DirectoryPathWildCard extends SingleValueWildCard {

		public DirectoryPathWildCard() {
			this.values.add("@@@DirPath@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			this.replacement = StringHelper.separateDirPathOutOfFile(
					s.getFile(), s.getRoot().getBase().getPath());
		}
	}

	/*
	 * inserts the script title of the specified script
	 */
	public static class ScriptNameWildCard extends SingleValueWildCard {

		public ScriptNameWildCard() {
			this.values.add("@@@ScriptTitle@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			this.replacement = s.getFile().getName();	
		}
	}
	
	/*
	 * inserts the head import of the specified script
	 */
	public static class HeadImportWildCard extends SingleValueWildCard{
		
		public HeadImportWildCard() {
			this.values.add("@@@HeadImport@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			StringBuilder builder = new StringBuilder();
			String impt = s.getHeadImport();
			String symbolsBeforeImportStmt, symbolsAfterImportStmt;
			
			if(impt.equals("")) {
				this.replacement = NOIMPORT;
				return;
			}

			if(s.getFile().getName().endsWith(".xpt")) {
				symbolsBeforeImportStmt = "&laquoImport";
				symbolsAfterImportStmt = "&raquo";
			}else if(s.getFile().getName().endsWith(".ext")) {
				symbolsBeforeImportStmt = "import";
				symbolsAfterImportStmt = ";";
			}else {
				symbolsBeforeImportStmt = "";
				symbolsAfterImportStmt = "";
			}		
			
			builder.append(symbolsBeforeImportStmt).append(" ")
				.append("<b>").append(impt).append("</b>").append(symbolsAfterImportStmt);
			
			this.replacement = builder.toString();
		}
	}
	
	/*
	 * inserts the head extensions of the specified script
	 */
	public static class HeadExtensionsWildCard extends DupeMultiValueWildCard{

		public HeadExtensionsWildCard() {
			this.values.add("@@@HeadExtensions@@@");
		}

		@Override
		public void setupReplacement(IContent c) {		
			StringBuilder builder;
			Script s = (Script) c;
			ArrayList<String> extensions = new ArrayList<String>();
			extensions.addAll(s.getHeadExtensions());
			
			ArrayList<String> extensionLinks = new ArrayList<String>();
			extensionLinks.addAll(s.getHeadExtensionLinks());
			
			String symbolsBeforeExtension, symbolsAfterExtension;
			
			if(extensions.isEmpty()) {
				this.replacement.add(NOHEADEXTENSIONS);
				return;
			}

			symbolsAfterExtension = "";
			String openGuillimet = "&laquo"; 	//left guillimet
			String closedGuillimet = "&raquo";	//right guillimet
			
			if(s.getFile().getName().endsWith(".xpt")) {
				symbolsBeforeExtension = openGuillimet + "EXTENSION"; 	
				symbolsAfterExtension = closedGuillimet; 				
			}else if(s.getFile().getName().endsWith(".ext")) {
				symbolsBeforeExtension = "extension";
			}else {
				symbolsBeforeExtension = "";
			}
			
			for (int i = 0; i < extensions.size(); i++) {
				builder = new StringBuilder();
				String ext = extensions.get(i);//.replaceFirst("\\s+reexport", "");
				if(ext != ""){
					builder.append(symbolsBeforeExtension + " ").append("<A HREF=\"").append(extensionLinks.get(i)).append("\">")
						.append("<B>").append(ext).append("</B>").append("</A>").append(symbolsAfterExtension);
					
				}
				this.replacement.add(builder.toString());
			}
			
			if(this.replacement.isEmpty()) {
				this.replacement.add(NOHEADEXTENSIONS);
			}
		}
	}
	
	/*
	 * inserts the head comment of the specified script
	 */
	public static class HeadCommentWildCard extends SingleValueWildCard{
		
		public HeadCommentWildCard() {
			this.values.add("@@@HeadComment@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			String doc = s.getHeadComment();
			if(doc == null || doc == "") {
				doc = NOHEADCOMMENT;
			}
			this.replacement = doc;
		}
	}
	
	/*
	 * used to insert the template and executable name in the summary
	 */
	public static class ExecutableSummaryWildCard extends DupeMultiValueWildCard {
	
		public ExecutableSummaryWildCard() {
			this.values.add("@@@TemplateSum@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			for (Executable e : s.getSymbols()) {
				this.replacement.add(e.getName());
			}	
		}
	}

	/*
	 * creates the validation summary
	 */
	public static class ValidationSummaryWildCard extends DupeMultiValueWildCard {
		
		public ValidationSummaryWildCard() {
			this.values.add("@@@ValidationSum@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			StringBuilder builder, metaTypehrefBuilder;
			String metaTypeDir = "metatypes";
			
			for (Executable e : s.getSymbols()) {
				builder = new StringBuilder();
				metaTypehrefBuilder = new StringBuilder();		
				
				String path = LinkGenerator.getRelativePath(c, metaTypeDir);
				
				// build the href of teh metatype part .. 
				// produces somthin like <A HREF="../../../../../../../metatypes/MProperty.html">MProperty</A>
				metaTypehrefBuilder.append("<A HREF=\"")
					.append(path).append("/").append(e.getMetaType()).append(".html")
					.append("\">")
					.append(e.getMetaType())
					.append("</A>");
				
				// build the rest
				// build the href out of the params 
				// (params are somethin like "GeneSEZ classifiers cannot be both, 'final' and 'abstract' " + fqn() )
				// so.. just fetch the wordcharacters
				
				String validationName = e.getParamDef();
				String cleaned = "";
				
				Pattern p = Pattern.compile("(\\w*)");
				Matcher m = p.matcher(validationName);
				
				while(m.find()) {
					cleaned = cleaned + validationName.substring(m.start(), m.end());				
				}

				builder.append("<TD>").append(metaTypehrefBuilder.toString()).append("</TD>")
					.append("<TD>").append(" ").append(e.getName()).append("</TD>")
					.append("<TD>").append("<A HREF=\"").append((new File(s.getLink())).getName()).append("#")
					.append(cleaned).append("\">").append(e.getParamDef()).append("</A>").append("</TD>");
				this.replacement.add(builder.toString());
			}	
		}
	}
	
	/*
	 * inserts the parameter definition of an executable
	 */
	public static class ExecutableParamDefWildCard extends MultiValueWildCard {

		public ExecutableParamDefWildCard() {
			this.values.add("@@@TemplateParamDef1@@@");
			this.values.add("@@@TemplateParamDef2@@@");
			this.values.add("@@@TemplateParamDef3@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			for (Executable e : s.getSymbols()) {
				this.replacement.add(e.getParamDef());
			}	
		}
	}
	
	/*
	 * Inserts the executable name
	 */
	public static class ExecutableNameWildCard extends MultiValueWildCard {

		public ExecutableNameWildCard() {
			this.values.add("@@@TemplateName1@@@");
			this.values.add("@@@TemplateName2@@@");
			this.values.add("@@@TemplateName3@@@");
			this.values.add("@@@TemplateName4@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			for (Executable e : s.getSymbols()) {
				this.replacement.add(e.getName());
			}	
		}
	}
	
	/*
	 * Inserts the executable html name.. is the name + metatype
	 * not used
	 */
	public static class ExecutableHtmlNameWildCard extends MultiValueWildCard {

		public ExecutableHtmlNameWildCard() {
			this.values.add("@@@ExecutableHtmlName@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			for (Executable e : s.getSymbols()) {
				this.replacement.add(e.getName() + e.getMetaType());
			}	
		}
	}
	
	public static class ExecutableMetaTypeWildCard extends MultiValueWildCard {

		public ExecutableMetaTypeWildCard() {
			this.values.add("@@@TemplateMetaType1@@@");
			this.values.add("@@@TemplateMetaType2@@@");
			this.values.add("@@@TemplateMetaType3@@@");
			this.values.add("@@@TemplateMetaType4@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			StringBuilder builder;
			String path;
			String metaTypeDir = "metatypes";
			
			for (Executable e : s.getSymbols()) {
				builder = new StringBuilder();
				if(!e.getMetaType().equals("")) {						
					path = LinkGenerator.getRelativePath(c, metaTypeDir);
	
					builder.append("<A HREF=\"")
						.append(path).append("/").append(e.getMetaType()).append(".html")
						.append("\">")
						.append(e.getMetaType())
						.append("</A>");					
				}
				this.replacement.add(builder.toString());
			}	
		}
	}
	
	public static class ExecutableDocuWildCard extends DupeMultiValueWildCard {

		public ExecutableDocuWildCard() {
			this.values.add("@@@ExecutableDocu@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			for (Executable e : s.getSymbols()) {
				String docu = e.getDocumentation();
				if(docu == ""){
					docu = NOEXECUTABLECDOCUMENTATION;
				}
				this.replacement.add(docu);
			}	
		}
	}
	
	/*
	 * 
	 * Special validation wildcards
	 * 
	 */

	/*
	 * inserts the error details
	 */
	public static class CheckErrorsWildCard extends DupeMultiValueWildCard {

		public CheckErrorsWildCard() {
			this.values.add("@@@CheckErrors@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			StringBuilder builder, hrefMetaTypeBuilder;
			String metaTypeDir = "metatypes";
			String path;
			
			for (Executable e : s.getSymbols()) {
				if(e.getName().equals("ERROR")){
					builder = new StringBuilder();
					hrefMetaTypeBuilder = new StringBuilder();

					path = LinkGenerator.getRelativePath(c, metaTypeDir);
	
					hrefMetaTypeBuilder.append("<A HREF=\"")
						.append(path).append("/").append(e.getMetaType()).append(".html")
						.append("\">")
						.append(e.getMetaType())
						.append("</A>");	
					
					String validationName = e.getParamDef();
					String cleaned = "";
					
					Pattern p = Pattern.compile("(\\w*)");
					Matcher m = p.matcher(validationName);
					
					while(m.find()) {
						cleaned = cleaned + validationName.substring(m.start(), m.end());				
					}
					
					builder.append("<A NAME=\"" + cleaned + "\"><!-- --></A>")
						.append("<br><b>").append(e.getParamDef()).append("</b>")
						.append("<PRE>MetaType: <B>").append(hrefMetaTypeBuilder.toString()).append("</B></PRE>")
						.append("<PRE>Constraint type: <B>").append(e.getName()).append("</B></PRE>")
						.append("<PRE>").append(e.getDocumentation()).append("</PRE><hr>");
					this.replacement.add(builder.toString());
				}
			}	
		}
	}
	
	/*
	 * inserts the warning details
	 */
	public static class CheckWarningsWildCard extends DupeMultiValueWildCard {

		public CheckWarningsWildCard() {
			this.values.add("@@@CheckWarnings@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			StringBuilder builder, hrefBuilder;
			String metaTypeDir = "metatypes";
			String path;
			
			for (Executable e : s.getSymbols()) {
				if(e.getName().equals("WARNING")){
					builder = new StringBuilder();
					hrefBuilder = new StringBuilder();	
					
					path = LinkGenerator.getRelativePath(c, metaTypeDir);
	
					hrefBuilder.append("<A HREF=\"")
						.append(path).append("/").append(e.getMetaType()).append(".html")
						.append("\">")
						.append(e.getMetaType())
						.append("</A>");
					
					String validationName = e.getParamDef();
					String cleaned = "";
					
					Pattern p = Pattern.compile("(\\w*)");
					Matcher m = p.matcher(validationName);
					
					while(m.find()) {
						cleaned = cleaned + validationName.substring(m.start(), m.end());				
					}
					
					builder.append("<A NAME=\"" + cleaned + "\"><!-- --></A>")
						.append("<br><b>").append(e.getParamDef()).append("</b>")
						.append("<PRE>MetaType: <B>").append(hrefBuilder.toString()).append("</B></PRE>")
						.append("<PRE>Constraint type: <B>").append(e.getName()).append("</B></PRE>")
						.append("<PRE>").append(e.getDocumentation()).append("</PRE><hr>");
					this.replacement.add(builder.toString());
				}
			}	
		}
	}

	/*
	 * 
	 * WildCards used to insert AllScripts content
	 * 
	 */
	
	/*
	 * inserts the all scripts WITH comments
	 */
	public static class ScriptSummaryWildCard extends DupeMultiValueWildCard {
		
		public ScriptSummaryWildCard() {
			this.values.add("@@@ScriptSummary@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {	
			SymbolTable table = (SymbolTable) c;
			List<Script> tmpRepl = new ArrayList<Script>();
			String doc;
			StringBuilder builder;
			
			for (ScriptPackage pack : table.getPackages()) {
				for (Script s : pack.getScripts()) {
					tmpRepl.add(s);	
				}
			}
			Collections.sort(tmpRepl);
			
			for (Script script : tmpRepl) {
				doc = script.getHeadComment();
				if(doc == null) doc = NOHEADCOMMENT;
				builder = new StringBuilder();;
				builder.append("<B><A HREF=\"").append(script.getLink())
					.append("\"").append(" title=\"script in ").append(script.getPack().getName())
					.append("\" target=\"detailFrame\">").append(script.getFile().getName())
					.append("</A></B></TD><TD>").append(doc);
				this.replacement.add(builder.toString());
			}	
		}
	}
	
	/*
	 * inserts the all scripts WITHOUT comments
	 */
	public static class ScriptSummaryFrameWildCard extends DupeMultiValueWildCard {
		
		public ScriptSummaryFrameWildCard() {
			this.values.add("@@@ScriptSummaryFrame@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {	
			SymbolTable table = (SymbolTable) c;
			List<Script> tmpRepl = new ArrayList<Script>();
			StringBuilder builder;
			
			for (ScriptPackage pack : table.getPackages()) {
				tmpRepl.addAll(pack.getScripts());
			}
			Collections.sort(tmpRepl);
			
			for (Script script : tmpRepl) {
				builder = new StringBuilder();;
				builder.append("<B><A HREF=\"").append(script.getLink())
					.append("\"").append(" title=\"script in ").append(script.getPack().getName())
					.append("\" target=\"detailFrame\">").append(script.getFile().getName());
				this.replacement.add(builder.toString());
			}	
		}
	}
	
	/*
	 * inserts the template calls
	 */
	public static class TemplateCallWildCard extends MultiValueWildCard{
		
		public TemplateCallWildCard() {
			this.values.add("@@@TemplateCall@@@");
		}

		@Override
		public void setupReplacement(IContent c) {		
			Script s = (Script) c;
			StringBuilder builder;
			String scriptName;
			int counter = 0;
			for (Executable ex : s.getSymbols()) {
				builder = new StringBuilder();
				builder.append("\n");
				counter = 0;
				
				List<Executable> tmpCalled = new ArrayList<Executable>(); 
				tmpCalled.addAll(ex.getCalled());
				Collections.sort(tmpCalled);
				
				for (Executable called : tmpCalled) {		
					if(called instanceof Template) {
						counter = 0;
						if(counter > 1 ) {
							builder.append("\t");
						}			
						File tmp = new File(called.getLink());
						if(tmp.getName() == "not-referenced.html") {
							scriptName = NOTFOUND;
						}else {
							scriptName = tmp.getName();
						}
						counter++;			
						builder.append("\t<A HREF=\"").append(called.getLink()).append("\">").append("<B>")
							.append(scriptName.replace(".xpt.html", "")).append("</B>").append("</A> :: <A HREF=\"")
							.append(called.getLink()).append("#").append(called.getName())/*.append(called.getMetaType())*/.append("\">")
							.append("<B>").append(called.getName()).append("</B>").append("</A>").append("<BR>");
					}
				}
				if(counter == 0) {
					this.replacement.add(NOCALLS);
				}else {
					this.replacement.add(builder.toString());
				}	
			}
		}
	}
	
	/*
	 * inserts the function calls
	 */
	public static class FunctionCallWildCard extends MultiValueWildCard{
		
		public FunctionCallWildCard() {
			this.values.add("@@@FunctionCall@@@");
		}

		@Override
		public void setupReplacement(IContent c) {	
			Script s = (Script) c;
			StringBuilder builder;
			int counter;
			
			for (Executable ex : s.getSymbols()) {
				builder = new StringBuilder();
				builder.append("\n");
				counter = 0;
				
				List<Executable> tmpCalled = new ArrayList<Executable>(); 
				tmpCalled.addAll(ex.getCalled());
				Collections.sort(tmpCalled);
				
				for (Executable called : tmpCalled) {
					if(called instanceof Function) {
						Function calledFunction = (Function) called;
						String functionName = calledFunction.getName(), tab = "\t";
						counter = 0;	
						
						if(counter > 1 ) {
							builder.append(tab);
						}

						if(functionName != "") {
							Function.OwnerType type = calledFunction.getOwnerType();
							if(type == OwnerType.OrdinaryOwner || type == OwnerType.ReExported) {
								builder.append(tab)
								.append("<A HREF=\"" + called.getLink() + "\">")
								.append("<B>")
								.append(called.getScript().getFile().getName().replace(".ext", ""))
								.append("</B></A>")	
								.append(" :: ")
								.append("<A HREF=\"").append(called.getLink()).append("#").append(functionName)/*.append(called.getMetaType())*/.append("\">")
								.append("<B>").append(called.getName()).append("</A>").append(called.getParamDef()).append("</B>")
								.append("<BR>");
							} else if(type == OwnerType.BuiltIn 
									|| type == OwnerType.GeneratededByEMF 
									|| type == OwnerType.ExternalFunction){
								builder.append(tab)
								.append("<A HREF=\"").append(called.getLink()).append("\">")
								.append("<B>").append(called.getName()).append("</A>").append(called.getParamDef()).append("</B>")
								.append("<BR>");
							}
					
							counter++;									
						}else {
							builder.append(tab + NOCALLS);
						}
					}
				}
				if(counter == 0) {
					this.replacement.add(NOCALLS);
				}else {
					this.replacement.add(builder.toString());
				}	
			}
		}
	}
	
	/*
	 * inserts the template called by's
	 */
	public static class TemplateCallerWildCard extends MultiValueWildCard{
		
		public TemplateCallerWildCard() {
			this.values.add("@@@TemplateCallerReference@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			StringBuilder builder;
			String scriptName;

			for (Executable ex : s.getSymbols()) {
				builder = new StringBuilder();
				builder.append("\n");			
				
				List<Executable> tmpCaller = new ArrayList<Executable>(); 
				tmpCaller.addAll(ex.getCaller());
				Collections.sort(tmpCaller);
				
				for (Executable caller : tmpCaller) {			
					if(caller.getScript().getFile().getName().endsWith(".xpt")) {		
						File tmp = new File(caller.getLink());
						if(caller.getName() != "") {
							if(tmp.getName().equals("not-referenced.html")) {
								scriptName = NOTFOUND;
							}else {
								scriptName = tmp.getName();
							}
											
						builder.append("\t<A HREF=\"").append(caller.getLink()).append("\">").append("<B>")
							.append(scriptName.replace(".xpt.html", "")).append("</B>").append("</A> :: <A HREF=\"")
							.append(caller.getLink()).append("#").append(caller.getName())/*.append(caller.getMetaType())*/.append("\">")
							.append("<B>").append(caller.getName()).append("</B>").append("</A>").append("<BR>");
						}else {
							builder.append("\t" + NOCALLS);
						}
					}
				}
				if(builder.toString().trim().equals("")) {
					this.replacement.add(NOCALLS);
				}else {
					this.replacement.add(builder.toString());
				}		
			}
		}
	}
	
	/*
	 * inserts the function called by's
	 */
	public static class FunctionCallerWildCard extends MultiValueWildCard{
		
		public FunctionCallerWildCard() {
			this.values.add("@@@FunctionCallerReference@@@");
		}

		@Override
		public void setupReplacement(IContent c) {	
			Script s = (Script) c;
			StringBuilder builder, hrefBuilder;
			String scriptName;
			String metaTypeDir = "metatypes", path, href;
			
			for (Executable ex : s.getSymbols()) {
				builder = new StringBuilder();
				builder.append("\n");
				
				List<Executable> tmpCaller = new ArrayList<Executable>(); 
				tmpCaller.addAll(ex.getCaller());
				Collections.sort(tmpCaller);
				
				for (Executable caller : tmpCaller) {
					if(caller.getScript().getFile().getName().endsWith(".ext")) {				
						File tmp = new File(caller.getLink());
						if(caller.getName() != "") {
							if(tmp.getName().equals("not-referenced.html")) {
								scriptName = NOTFOUND;
							}else {
								scriptName = tmp.getName();
							}

							path = LinkGenerator.getRelativePath(c, metaTypeDir);
			
							hrefBuilder = new StringBuilder();
							
							hrefBuilder.append("<A HREF=\"")
								.append(path).append("/").append(caller.getMetaType()).append(".html")
								.append("\">")
								.append(caller.getMetaType())
								.append("</A>");
							
							href = hrefBuilder.toString();

							builder.append("\t<A HREF=\"").append(caller.getLink()).append("\">").append("<B>")
								.append(scriptName.replace(".ext.html", "")).append("</B>").append("</A> :: <A HREF=\"")
								.append(caller.getLink()).append("#").append(caller.getName())/*.append(caller.getMetaType())*/.append("\">")
								.append("<B>").append(caller.getName()).append("</A>").append("(").append(href + " " + caller.getParamDef())
								.append(")").append("</B>").append("<BR>");
						}else {
							builder.append("\t" + NOCALLS);
						}
					}
				}
				if(builder.toString().trim().equals("")) {
					this.replacement.add(NOCALLS);
				}else {
					this.replacement.add(builder.toString());
				}	
			}
		}
	}
	
	/*
	 * inserts the codebody of the function
	 */
	public static class CodeBodyWildCard extends MultiValueWildCard{
		
		public CodeBodyWildCard() {
			this.values.add("@@@CodeBody@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			String suffix = "";
			int counter = 0;
			
			// we add a ";" at the end of the codebody of extend scripts
			if(s.getFile().getName().endsWith(".ext")) suffix = ";";	
			
			for (Executable e : s.getSymbols()) {
				counter++;
				StringBuilder builder = new StringBuilder();
				builder.append("<a href=\"javascript:;\" onClick=\"toggle('codebody" + counter + "');\">")
					.append("Show Codebody</a>")
					.append("<textarea id=\"" + "codebody" + counter + "\" style=\"display:none; width:100%;\" rows=\"")
					.append(StringHelper.getHeight(e.getCodeBody()) + "\">")
					.append(e.getCodeBody().replaceAll("«", "&#171;").replaceAll("»", "&#187;")).append(suffix)
					.append("</textarea>");
				this.replacement.add(builder.toString());
			}	
		}
	}

	/*
	 * insert the executable html path
	 */
	public static class ExecutableHtmlPathWildCard extends MultiValueWildCard {

		public ExecutableHtmlPathWildCard() {
			this.values.add("@@@TemplatePath@@@");
		}
		
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			File tmp = new File(s.getLink());
			for (Executable ex : s.getSymbols()) {
				this.replacement.add(tmp.getName()+ "#" + ex.getName());/*+ ex.getMetaType());*/
			}	
		}
	}

	/*
	 * 
	 * wildcards used to insert function content
	 * 
	 */
	
	/*
	 * inserts 'cached' or 'create'
	 */
	public static class FunctionTypeWildCard extends MultiValueWildCard {

		public FunctionTypeWildCard() {
			this.values.add("@@@FunctionType1@@@");
			this.values.add("@@@FunctionType2@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			String val;
			for (Executable e : s.getSymbols()) {
				Function f = (Function) e;			
				if(f.isCached()) {
					val = "cached&nbsp;";
				}else if(f.isCreate()) {
					val = "create&nbsp;";
				}else {
					val = "";
				}
				this.replacement.add(val);	
			}	
		}
	}
	
	/*
	 * inserts 'is cached' or 'is create'
	 */
	public static class FunctionIsCachedIsCreatedWildCard extends MultiValueWildCard {

		public FunctionIsCachedIsCreatedWildCard() {
			this.values.add("@@@FunctionIsCachedIsCreated@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			String val;
			for (Executable e : s.getSymbols()) {
				Function f = (Function) e;			
				if(f.isCached()) {
					val = "is cached&nbsp;";
				}else if(f.isCreate()) {
					val = "is create&nbsp;";
				}else {
					val = "";
				}
				this.replacement.add(val);	
			}	
		}
	}
	
	/*
	 * inserts the return type of the function
	 */
	public static class FunctionReturnTypeWildCard extends MultiValueWildCard{
		
		public FunctionReturnTypeWildCard() {
			this.values.add("@@@FunctionReturnType1@@@");
			this.values.add("@@@FunctionReturnType2@@@");
			this.values.add("@@@FunctionReturnType3@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			String mt;
			for (Executable e : s.getSymbols()) {
				Function f = (Function) e;
				mt = f.getRetType();
				this.replacement.add(mt + " ");
				
			}
		}
	}
	
	/*
	 * inserts the visibility of the function
	 */
	public static class FunctionVisibilityWildCard extends MultiValueWildCard{
		
		public FunctionVisibilityWildCard() {
			this.values.add("@@@FunctionVisibility1@@@");
			this.values.add("@@@FunctionVisibility2@@@");
			this.values.add("@@@FunctionVisibility3@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			for (Executable e : s.getSymbols()) {
				Function f = (Function) e;
				this.replacement.add(f.getVisibility() + " ");
			}	
		}
	}
	
	
	/**
	 * 
	 * WildCards used to insert namespace content
	 * 
	 */
	
	/*
	 * inserts the namespace names
	 */
	public static class NamespaceNamesWildCard extends MultiValueWildCard {

		public NamespaceNamesWildCard() {
			this.values.add("@@@Package@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			SymbolTable table = (SymbolTable) c;
			for (ScriptPackage pack : table.getPackages()) {
				insertInReplacement(pack.getName());
			}	
		}
	}
	
	/*
	 * inserts the namespace name
	 */
	public static class NamespaceNameWildCard extends SingleValueWildCard {

		public NamespaceNameWildCard() {
			this.values.add("@@@PackageName@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			ScriptPackage pack =(ScriptPackage) c;
			this.replacement = pack.getName();	
		}
	}
	
	/*
	 * inserts the namespace reference (used in the namespace enum page)
	 */
	public static class NamespaceReferenceWildCard extends DupeMultiValueWildCard {

		public NamespaceReferenceWildCard() {
			this.values.add("@@@PackageReference@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			SymbolTable table = (SymbolTable) c;
			for (ScriptPackage pack : table.getPackages()) {
				insertInReplacement("packages/" + pack.getName().replace("::", ".") + ".html");
			}	
		}
	}
	
	/*
	 * inserts the script reference in the namespace page 
	 */
	public static class NamespaceScriptReferenceWildCard extends MultiValueWildCard {

		public NamespaceScriptReferenceWildCard() {
			this.values.add("@@@PackageScriptReference@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			ScriptPackage pack =(ScriptPackage) c;
			for (Script s : pack.getScripts()) {
				this.replacement.add("../" + s.getLink());
			}	
		}
	}
	
	/*
	 * inserts the script name in the namespace page 
	 */
	public static class NamespaceScriptNameWildCard extends DupeMultiValueWildCard {

		public NamespaceScriptNameWildCard() {
			this.values.add("@@@ScriptName@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			ScriptPackage pack =(ScriptPackage) c;
			for (Script s : pack.getScripts()) {
				this.replacement.add(s.getFile().getName());
			}	
		}
	}
	
	/*
	 * inserts the script comment in the namespace page 
	 */
	public static class NamespaceScriptCommentWildCard extends MultiValueWildCard {

		public NamespaceScriptCommentWildCard() {
			this.values.add("@@@HeadComment@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			ScriptPackage pack =(ScriptPackage) c;
			String doc;
			for (Script s : pack.getScripts()) {
				doc = s.getHeadComment();
				if (doc == null) doc = NOHEADCOMMENT;
				this.replacement.add(doc);
			}
		}
	}
		
	
	/**
	 * 
	 * WildCards used to insert metatype content
	 * 
	 */
	
	/*
	 * used to insert metatype summary content
	 */
	public static class MetaTypeSummaryWildCard extends DupeMultiValueWildCard {

		public MetaTypeSummaryWildCard() {
			this.values.add("@@@MetaTypeSummary@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			SymbolTable table = (SymbolTable) c;
			List<String> allMetaTypes = new ArrayList<String>();
			Set<String> metaTypes = new TreeSet<String>();
			
			for (ScriptPackage pack : table.getPackages()) {
				for (Script s : pack.getScripts()) {
					for (Executable ex : s.getSymbols()) {
						allMetaTypes.add(ex.getMetaType().trim());
					}
				}
			}	
			
			for (String mt : allMetaTypes) {
				if(!metaTypes.contains(mt)) {
					metaTypes.add(mt);
				}
			}
			
			StringBuilder builder;
			for (String mt : metaTypes) {
				builder = new StringBuilder();
				builder.append("<A HREF=\"metatypes/").append(mt).append(".html").append("\">")
					.append(mt).append("</A>");
				this.replacement.add(builder.toString());
			}	
		}
	}
	
	/*
	 * used to insert the scriptname::executablename (used in metatype summary page)
	 */
	public static class ScriptAndExecutableNameWildCard extends MultiValueWildCard {

		public ScriptAndExecutableNameWildCard() {
			this.values.add("@@@ScriptAndExecutableName@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			StringBuilder builder;
			for (Executable ex : s.getSymbols()) {
				builder = new StringBuilder();
				builder.append("<A HREF=\"").append("../" + ex.getLink()).append("\">")
					.append(ex.getScript().getFile().getName().replaceFirst(".chk|.ext|.xpt", "")).append("</A>")
					.append(" :: ").append("<A HREF=\"").append("../" + ex.getLink()).append("#")
					.append(ex.getName())/*.append(ex.getMetaType())*/.append("\">").append(ex.getName()).append("</A>");
				this.replacement.add(builder.toString());
			}	
		}
	}
	
	/*
	 * used to insert the executable reference (used in metatype_template)
	 */
	public static class MetaTypeExecutableReferenceWildCard extends MultiValueWildCard {

		public MetaTypeExecutableReferenceWildCard() {
			this.values.add("@@@MetaTypeExecutableReference@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			for (Executable ex : s.getSymbols()) {
				this.replacement.add("../" + ex.getLink() + "#" + ex.getName() + ex.getMetaType());
			}	
		}
	}
	
	/**
	 * 
	 * WildCards used to insert metrics
	 * 
	 */
	
	/*
	 * wildcard, that used to insert a scriptname and the suitable link to the stats-script-summary.html
	 */
	public static class StatsScriptReferenceWildCard extends DupeMultiValueWildCard {

		public StatsScriptReferenceWildCard() {
			this.values.add("@@@StatsScriptReference@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {
			SymbolTable symbols = (SymbolTable) c;
			List<Script> sorted = new ArrayList<Script>();
			for (ScriptPackage pack : symbols.getPackages()) {
				sorted.addAll(pack.getScripts());
			}
			
			Collections.sort(sorted);
			
			StringBuilder builder;
			for (Script s : sorted) {			
				builder = new StringBuilder();
				builder.append("<A HREF=\"").append(s.getLink()).append("\"><B>").append(s.getFile().getName()).append("</B></A>");
				this.replacement.add(builder.toString());
			}		
		}
	}	
	
	/*
	 * wildcard, that used to insert the number of packages
	 */
	public static class ScanPackageCountWildCard extends SingleValueWildCard {

		public ScanPackageCountWildCard() {
			this.values.add("@@@ScanPackageCount@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {
			SymbolTable symbols = (SymbolTable) c;
			int count = symbols.getPackages().size();
			this.replacement = count+"";
		}
	}
	
	/*
	 * wildcard, that used to insert the number of scripts
	 */
	public static class ScanScriptCountWildCard extends SingleValueWildCard {

		public ScanScriptCountWildCard() {
			this.values.add("@@@ScanScriptCount@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {
			SymbolTable symbols = (SymbolTable) c;
			int count = 0;
			for (ScriptPackage pack : symbols.getPackages()) {
				count = count + pack.getScripts().size();
			}
			this.replacement = count+"";
		}
	}
	
	/*
	 * wildcard, that used to insert the number of templates
	 */
	public static class ScanTemplateCountWildCard extends SingleValueWildCard {

		public ScanTemplateCountWildCard() {
			this.values.add("@@@ScanTemplateCount@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {
			SymbolTable symbols = (SymbolTable) c;
			int count = 0;
			for (ScriptPackage pack : symbols.getPackages()) {
				for (Script s : pack.getScripts()) {
					for (Executable e : s.getSymbols()) {
						if(e instanceof Template) count++;
					}
				}
			}
			this.replacement = count+"";
		}
	}
	
	/*
	 * wildcard, that used to insert the number of functions
	 */
	public static class ScanFunctionCountWildCard extends SingleValueWildCard {

		public ScanFunctionCountWildCard() {
			this.values.add("@@@ScanFunctionCount@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {
			SymbolTable symbols = (SymbolTable) c;
			int count = 0;
			for (ScriptPackage pack : symbols.getPackages()) {
				for (Script s : pack.getScripts()) {
					for (Executable e : s.getSymbols()) {
						if(e instanceof Function) count++;
					}
				}
			}
			this.replacement = count+"";
		}
	}
	
	/*
	 * wildcard, that used to insert the number of validations
	 */
	public static class ScanValidationCountWildCard extends SingleValueWildCard {

		public ScanValidationCountWildCard() {
			this.values.add("@@@ScanValidationCount@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {
			SymbolTable symbols = (SymbolTable) c;
			int count = 0;
			for (ScriptPackage pack : symbols.getPackages()) {
				for (Script s : pack.getScripts()) {
					for (Executable e : s.getSymbols()) {
						if(e instanceof Validation) count++;
					}
				}
			}
			this.replacement = count+"";
		}
	}
	
	/*
	 * wildcard, that used to insert the number of commented executables of the whole scan
	 */
	public static class ScanCommentedExecutableCountWildCard extends SingleValueWildCard {

		public ScanCommentedExecutableCountWildCard() {
			this.values.add("@@@ScanCommentedExecutableCount@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {
			SymbolTable symbols = (SymbolTable) c;
			int count = 0;
			for (ScriptPackage pack : symbols.getPackages()) {
				for (Script script : pack.getScripts()) {
					for (Executable e : script.getSymbols()) {
						if(e.getDocumentation() != "" && e.getDocumentation() != null) {
							count++;
						}
					}
				}
			}
			this.replacement = String.valueOf(count);
		}
	}
	
	/*
	 * wildcard, that used to insert the number of physical lines of a script
	 */
	public static class ScanPhysicalLineCountWildCard extends SingleValueWildCard {

		public ScanPhysicalLineCountWildCard() {
			this.values.add("@@@ScanPhysicalLineCount@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {
			SymbolTable symbols = (SymbolTable) c;
			int count = 0;
			for (ScriptPackage pack : symbols.getPackages()) {
				for (Script script : pack.getScripts()) {
					count += StatsHelper.getLineCount(script.getContent());
				}
			}
			this.replacement = String.valueOf(count);
		}
	}
	
	/*
	 * wildcard, that used to insert the number of comment lines of a script
	 */
	public static class ScanCommentLineCountWildCard extends SingleValueWildCard {

		public ScanCommentLineCountWildCard() {
			this.values.add("@@@ScanCommentLineCount@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {
			SymbolTable symbols = (SymbolTable) c;
			int count = 0;
			for (ScriptPackage pack : symbols.getPackages()) {
				for (Script script : pack.getScripts()) {
					count += StatsHelper.getCommentLineCount(script);
				}
			}
			this.replacement = String.valueOf(count);
		}
	}
	
	/*
	 * wildcard, that used to insert the number of blank lines of a script
	 */
	public static class ScanBlankLineCountWildCard extends SingleValueWildCard {

		public ScanBlankLineCountWildCard() {
			this.values.add("@@@ScanBlankLineCount@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {	
			SymbolTable symbols = (SymbolTable) c;
			int count = 0;
			for (ScriptPackage pack : symbols.getPackages()) {
				for (Script script : pack.getScripts()) {
					count += StatsHelper.getBlankLineCount(script.getContent());
				}
			}
			this.replacement = String.valueOf(count);
		}
	}
	
	/*
	 * used to insert the number of program lines of a script
	 */
	public static class ScanProgramLineCountWildCard extends SingleValueWildCard {

		public ScanProgramLineCountWildCard() {
			this.values.add("@@@ScanProgramLineCount@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {	
			SymbolTable symbols = (SymbolTable) c;
			int count = 0;
			for (ScriptPackage pack : symbols.getPackages()) {
				for (Script script : pack.getScripts()) {
					count += StatsHelper.getProgramLineCount(script);
				}
			}
			this.replacement = String.valueOf(count);
		}
	}
	
	/*
	 * used to insert the cyclomatic number of a script
	 */
	public static class ScanCyclomaticComplexityWildCard extends SingleValueWildCard {

		public ScanCyclomaticComplexityWildCard() {
			this.values.add("@@@ScanCyclomaticComplexity@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {	
			SymbolTable symbols = (SymbolTable) c;
			double count = 0;
			for (ScriptPackage pack : symbols.getPackages()) {
				for (Script script : pack.getScripts()) {
					count += StatsHelper.getCyclomaticComplexity(script.getContent());
				}
			}
			count = StatsHelper.getAverage(count, symbols);
			this.replacement = String.valueOf(count);
		}
	}
	
	/*
	 * used to insert the program length of the scan
	 */
	public static class ScanProgramLengthWildCard extends SingleValueWildCard {

		public ScanProgramLengthWildCard() {
			this.values.add("@@@ScanProgramLength@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {	
			SymbolTable symbols = (SymbolTable) c;
			double count = 0;
			for (ScriptPackage pack : symbols.getPackages()) {
				for (Script script : pack.getScripts()) {
					count += StatsHelper.getProgramLength(script.getContent());
				}
			}
			count = StatsHelper.getAverage(count, symbols);
			this.replacement = String.valueOf(count);
		}
	}
	
	/*
	 * used to insert the vocabulary Size of the scan
	 */
	public static class ScanVocabularySizeWildCard extends SingleValueWildCard {

		public ScanVocabularySizeWildCard() {
			this.values.add("@@@ScanVocabularySize@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {	
			SymbolTable symbols = (SymbolTable) c;
			double count = 0;
			for (ScriptPackage pack : symbols.getPackages()) {
				for (Script script : pack.getScripts()) {
					count += StatsHelper.getVocabularySize(script.getContent());
				}
			}
			count = StatsHelper.getAverage(count, symbols);
			this.replacement = String.valueOf(count);
		}
	}
	
	/*
	 * used to insert the program volume of the scan
	 */
	public static class ScanProgramVolumeWildCard extends SingleValueWildCard {

		public ScanProgramVolumeWildCard() {
			this.values.add("@@@ScanProgramVolume@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {	
			SymbolTable symbols = (SymbolTable) c;
			double count = 0;
			for (ScriptPackage pack : symbols.getPackages()) {
				for (Script script : pack.getScripts()) {
					count += StatsHelper.getProgramVolume(script.getContent());
				}
			}
			count = StatsHelper.getAverage(count, symbols);
			this.replacement = String.valueOf(count);
		}
	}
	
	/*
	 * used to insert the dificulty of the scan
	 */
	public static class ScanDifficultyLvlWildCard extends SingleValueWildCard {

		public ScanDifficultyLvlWildCard() {
			this.values.add("@@@ScanDifficultyLvl@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {	
			SymbolTable symbols = (SymbolTable) c;
			double count = 0;
			for (ScriptPackage pack : symbols.getPackages()) {
				for (Script script : pack.getScripts()) {
					count += StatsHelper.getDifficultyLvl(script.getContent());
				}
			}
			count = StatsHelper.getAverage(count, symbols);
			this.replacement = String.valueOf(count);
		}
	}
	
	/*
	 * used to insert the vocabulary Size of the scan
	 */
	public static class ScanProgramNiveauWildCard extends SingleValueWildCard {

		public ScanProgramNiveauWildCard() {
			this.values.add("@@@ScanProgramNiveau@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {	
			SymbolTable symbols = (SymbolTable) c;
			double count = 0;
			for (ScriptPackage pack : symbols.getPackages()) {
				for (Script script : pack.getScripts()) {
					count += StatsHelper.getProgramNiveau(script.getContent());
				}
			}
			count = StatsHelper.getAverage(count, symbols);
			this.replacement = String.valueOf(count);
		}
	}
	
	/*
	 * used to insert the dificulty of the scan
	 */
	public static class ScanEffortToImplWildCard extends SingleValueWildCard {

		public ScanEffortToImplWildCard() {
			this.values.add("@@@ScanEffortToImpl@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {	
			SymbolTable symbols = (SymbolTable) c;
			double count = 0;
			for (ScriptPackage pack : symbols.getPackages()) {
				for (Script script : pack.getScripts()) {
					count += StatsHelper.getEffortToImplement(script.getContent());
				}
			}
			count = StatsHelper.getAverage(count, symbols);
			this.replacement = String.valueOf(count);
		}
	}
	
	/*
	 * used to insert time to implement of the scan
	 */
	public static class ScanImplTimeWildCard extends SingleValueWildCard {

		public ScanImplTimeWildCard() {
			this.values.add("@@@ScanImplTime@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {	
			SymbolTable symbols = (SymbolTable) c;
			double count = 0;
			for (ScriptPackage pack : symbols.getPackages()) {
				for (Script script : pack.getScripts()) {
					count += StatsHelper.getTimeToImplement(script.getContent());
				}
			}
			count = StatsHelper.getAverage(count, symbols);
			this.replacement = String.valueOf(count);
		}
	}
	
	/*
	 * used to insert time to implement of the scan
	 */
	public static class ScanBugCountWildCard extends SingleValueWildCard {

		public ScanBugCountWildCard() {
			this.values.add("@@@ScanBugCount@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {	
			SymbolTable symbols = (SymbolTable) c;
			double count = 0;
			for (ScriptPackage pack : symbols.getPackages()) {
				for (Script script : pack.getScripts()) {
					count += StatsHelper.getBugCount(script.getContent());
				}
			}
			count = StatsHelper.getAverage(count, symbols);
			this.replacement = String.valueOf(count);
		}
	}
	
	/*
	 * 
	 * Script Stats
	 * 
	 */
	
	
	/*
	 * wildcard, that used to insert the number of executables for a script
	 */
	public static class ScriptExecutableCountWildCard extends SingleValueWildCard {

		public ScriptExecutableCountWildCard() {
			this.values.add("@@@ScriptExecutableCount@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			int count = s.getSymbols().size();
			this.replacement = String.valueOf(count);
		}
	}
	
	/*
	 * wildcard, that used to insert the number of commented executables for a script
	 */
	public static class ScriptCommentedExecutableCountWildCard extends SingleValueWildCard {

		public ScriptCommentedExecutableCountWildCard() {
			this.values.add("@@@ScriptCommentedExecutableCount@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			int count = 0;
			for (Executable e : s.getSymbols()) {
				if(e.getDocumentation() != "" && e.getDocumentation() != null) {
					count++;
				}
			}
			this.replacement = String.valueOf(count);
		}
	}
	
	/*
	 * wildcard, that used to insert the number of physical lines for a script
	 */
	public static class ScriptPhysicalLineCountWildCard extends SingleValueWildCard {

		public ScriptPhysicalLineCountWildCard() {
			this.values.add("@@@ScriptPhysicalLineCount@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			this.replacement = String.valueOf(StatsHelper.getLineCount(s.getContent()));
		}
	}
	
	/*
	 * wildcard, that used to insert the number of comment lines for a script
	 */
	public static class ScriptCommentLineCountWildCard extends SingleValueWildCard {

		public ScriptCommentLineCountWildCard() {
			this.values.add("@@@ScriptCommentLineCount@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			this.replacement =  String.valueOf(StatsHelper.getCommentLineCount(s));
		}
	}
	
	/*
	 * wildcard, that used to insert the number of blank lines for a script
	 */
	public static class ScriptBlankLineCountWildCard extends SingleValueWildCard {

		public ScriptBlankLineCountWildCard() {
			this.values.add("@@@ScriptBlankLineCount@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			this.replacement = String.valueOf(StatsHelper.getBlankLineCount(s.getContent()));
		}
	}
	
	/*
	 * used to insert the number of program lines for a script
	 */
	public static class ScriptProgramLineCountWildCard extends SingleValueWildCard {

		public ScriptProgramLineCountWildCard() {
			this.values.add("@@@ScriptProgramLineCount@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			this.replacement = String.valueOf(StatsHelper.getProgramLineCount(s));
		}
	}
	
	/*
	 * used to insert the cyclomatic number for a script
	 */
	public static class ScriptCyclomaticComplexityWildCard extends SingleValueWildCard {

		public ScriptCyclomaticComplexityWildCard() {
			this.values.add("@@@ScriptCyclomaticComplexity@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			this.replacement = String.valueOf(StatsHelper.getCyclomaticComplexity(s.getContent()));
		}
	}
	
	/*
	 * used to insert the program length of the scan
	 */
	public static class ScriptProgramLengthWildCard extends SingleValueWildCard {

		public ScriptProgramLengthWildCard() {
			this.values.add("@@@ScriptProgramLength@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			this.replacement = String.valueOf(StatsHelper.getProgramLength(s.getContent()));
		}
	}
	
	/*
	 * used to insert the vocabulary Size of the scan
	 */
	public static class ScriptVocabularySizeWildCard extends SingleValueWildCard {

		public ScriptVocabularySizeWildCard() {
			this.values.add("@@@ScriptVocabularySize@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			this.replacement = String.valueOf(StatsHelper.getVocabularySize(s.getContent()));
		}
	}
	
	/*
	 * used to insert the program volume of the scan
	 */
	public static class ScriptProgramVolumeWildCard extends SingleValueWildCard {

		public ScriptProgramVolumeWildCard() {
			this.values.add("@@@ScriptProgramVolume@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			this.replacement = String.valueOf(StatsHelper.getProgramVolume(s.getContent()));
		}
	}
	
	/*
	 * used to insert the dificulty of the scan
	 */
	public static class ScriptDifficultyLvlWildCard extends SingleValueWildCard {

		public ScriptDifficultyLvlWildCard() {
			this.values.add("@@@ScriptDifficultyLvl@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			this.replacement = String.valueOf(StatsHelper.getDifficultyLvl(s.getContent()));
		}
	}
	
	/*
	 * used to insert the vocabulary Size of the scan
	 */
	public static class ScriptProgramNiveauWildCard extends SingleValueWildCard {

		public ScriptProgramNiveauWildCard() {
			this.values.add("@@@ScriptProgramNiveau@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			this.replacement = String.valueOf(StatsHelper.getProgramNiveau(s.getContent()));
		}
	}
	
	/*
	 * used to insert the dificulty of the scan
	 */
	public static class ScriptEffortToImplWildCard extends SingleValueWildCard {

		public ScriptEffortToImplWildCard() {
			this.values.add("@@@ScriptEffortToImpl@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			this.replacement = String.valueOf(StatsHelper.getEffortToImplement(s.getContent()));
		}
	}
	
	/*
	 * used to insert time to implement of the scan
	 */
	public static class ScriptImplTimeWildCard extends SingleValueWildCard {

		public ScriptImplTimeWildCard() {
			this.values.add("@@@ScriptImplTime@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			this.replacement =  String.valueOf(StatsHelper.getTimeToImplement(s.getContent()));
		}
	}
	
	/*
	 * used to insert bug count of the scan
	 */
	public static class ScriptBugCountWildCard extends SingleValueWildCard {

		public ScriptBugCountWildCard() {
			this.values.add("@@@ScriptBugCount@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			this.replacement = String.valueOf(StatsHelper.getBugCount(s.getContent()));
		}
	}
	
	
	/*
	 * 
	 * stats wildcards
	 * 
	 */

	
	/*
	 * wildcard, that used to insert the number of physical lines for a script
	 */
	public static class ExecutablePhysicalLineCountWildCard extends MultiValueWildCard {

		public ExecutablePhysicalLineCountWildCard() {
			this.values.add("@@@ExecutablePhysicalLineCount@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			for (Executable e : s.getSymbols()) {
				this.replacement.add(String.valueOf(StatsHelper.getLineCount(e.getCodeBody())));
			}
		}
	}
	
	/*
	 * wildcard, that used to insert the number of comment lines for a script
	 */
	public static class ExecutableCommentLineCountWildCard extends MultiValueWildCard {

		public ExecutableCommentLineCountWildCard() {
			this.values.add("@@@ExecutableCommentLineCount@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			for (Executable e : s.getSymbols()) {
				this.replacement.add(String.valueOf(StatsHelper.getCommentLineCount(e)));
			}
		}
	}
	
	/*
	 * wildcard, that used to insert the number of blank lines for a script
	 */
	public static class ExecutableBlankLineCountWildCard extends MultiValueWildCard {

		public ExecutableBlankLineCountWildCard() {
			this.values.add("@@@ExecutableBlankLineCount@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			for (Executable e : s.getSymbols()) {
				this.replacement.add(String.valueOf(StatsHelper.getBlankLineCount(e.getCodeBody())));
			}
		}
	}
	
	/*
	 * used to insert the number of program lines for a script
	 */
	public static class ExecutableProgramLineCountWildCard extends MultiValueWildCard {

		public ExecutableProgramLineCountWildCard() {
			this.values.add("@@@ExecutableProgramLineCount@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			for (Executable e : s.getSymbols()) {
				this.replacement.add(String.valueOf(StatsHelper.getProgramLineCount(e)));
			}
		}
	}
	
	/*
	 * used to insert the cyclomatic number for a script
	 */
	public static class ExecutableCyclomaticComplexityWildCard extends MultiValueWildCard {

		public ExecutableCyclomaticComplexityWildCard() {
			this.values.add("@@@ExecutableCyclomaticComplexity@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			for (Executable e : s.getSymbols()) {
				this.replacement.add(String.valueOf(StatsHelper.getCyclomaticComplexity(e.getCodeBody())));
			}
		}
	}
	
	/*
	 * used to insert the program length of the scan
	 */
	public static class ExecutableProgramLengthWildCard extends MultiValueWildCard {

		public ExecutableProgramLengthWildCard() {
			this.values.add("@@@ExecutableProgramLength@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			for (Executable e : s.getSymbols()) {
				this.replacement.add(String.valueOf(StatsHelper.getProgramLength(e.getCodeBody())));
			}
		}
	}
	
	/*
	 * used to insert the vocabulary Size of the scan
	 */
	public static class ExecutableVocabularySizeWildCard extends MultiValueWildCard {

		public ExecutableVocabularySizeWildCard() {
			this.values.add("@@@ExecutableVocabularySize@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			for (Executable e : s.getSymbols()) {
				this.replacement.add(String.valueOf(StatsHelper.getVocabularySize(e.getCodeBody())));
			}
		}
	}
	
	/*
	 * used to insert the program volume of the scan
	 */
	public static class ExecutableProgramVolumeWildCard extends MultiValueWildCard {

		public ExecutableProgramVolumeWildCard() {
			this.values.add("@@@ExecutableProgramVolume@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			for (Executable e : s.getSymbols()) {
				this.replacement.add(String.valueOf(StatsHelper.getProgramVolume(e.getCodeBody())));
			}
		}
	}
	
	/*
	 * used to insert the dificulty of the scan
	 */
	public static class ExecutableDifficultyLvlWildCard extends MultiValueWildCard {

		public ExecutableDifficultyLvlWildCard() {
			this.values.add("@@@ExecutableDifficultyLvl@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			for (Executable e : s.getSymbols()) {
				this.replacement.add(String.valueOf(StatsHelper.getDifficultyLvl(e.getCodeBody())));
			}
		}
	}
	
	/*
	 * used to insert the vocabulary Size of the scan
	 */
	public static class ExecutableProgramNiveauWildCard extends MultiValueWildCard {

		public ExecutableProgramNiveauWildCard() {
			this.values.add("@@@ExecutableProgramNiveau@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			for (Executable e : s.getSymbols()) {
				this.replacement.add(String.valueOf(StatsHelper.getProgramNiveau(e.getCodeBody())));
			}
		}
	}
	
	/*
	 * used to insert the dificulty of the scan
	 */
	public static class ExecutableEffortToImplWildCard extends MultiValueWildCard {

		public ExecutableEffortToImplWildCard() {
			this.values.add("@@@ExecutableEffortToImpl@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			for (Executable e : s.getSymbols()) {
				this.replacement.add(String.valueOf(StatsHelper.getEffortToImplement(e.getCodeBody())));
			}
		}
	}
	
	/*
	 * used to insert time to implement of the scan
	 */
	public static class ExecutableImplTimeWildCard extends MultiValueWildCard {

		public ExecutableImplTimeWildCard() {
			this.values.add("@@@ExecutableImplTime@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			for (Executable e : s.getSymbols()) {
				this.replacement.add(String.valueOf(StatsHelper.getTimeToImplement(e.getCodeBody())));
			}
		}
	}
	
	/*
	 * used to insert time to implement of the scan
	 */
	public static class ExecutableBugCountWildCard extends DupeMultiValueWildCard {

		public ExecutableBugCountWildCard() {
			this.values.add("@@@ExecutableBugCount@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			for (Executable e : s.getSymbols()) {
				this.replacement.add(String.valueOf(StatsHelper.getBugCount(e.getCodeBody())));
			}
		}
	}
	
	/*
	 * 
	 * Bundle wildcards
	 * 
	 */
	
	/*
	 * used to insert references of all scanned xpand scripts
	 */
	public static class BundleExpandFrameWildCard extends DupeMultiValueWildCard {

		public BundleExpandFrameWildCard() {
			this.values.add("@@@BundleExpandFrame@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			this.replacement = getBundleFrameReplacement(c, ".xpt");
		}
	}
	
	/*
	 * used to insert references of all scanned xtend scripts
	 */
	public static class BundleExtendFrameWildCard extends DupeMultiValueWildCard {

		public BundleExtendFrameWildCard() {
			this.values.add("@@@BundleExtendFrame@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {
			this.replacement = getBundleFrameReplacement(c, ".ext");
		}
	}
	
	/*
	 * used to insert references of all scanned xpand scripts
	 */
	public static class BundleCheckFrameWildCard extends DupeMultiValueWildCard {

		public BundleCheckFrameWildCard() {
			this.values.add("@@@BundleCheckFrame@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			this.replacement = getBundleFrameReplacement(c, ".chk");
		}
	}
	
	/*
	 * 
	 * Executable Index Wildcards
	 * 
	 */
	
	/*
	 * used to create index navigator
	 */
	public static class IndexNaviWildCard extends SingleValueWildCard {

		public IndexNaviWildCard() {
			this.values.add("@@@IndexNavi@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			// List to sort the available letters
			List<Script> sorted = new ArrayList<Script>();
			// object to build the string
			StringBuilder builder = new StringBuilder();
			
			ScriptPackage pack = (ScriptPackage) c;
			sorted.addAll(pack.getScripts());

			Collections.sort(sorted);
			
			String indexDoc;
			
			for (int i = 0; i < sorted.size(); i++) {
				String letter = sorted.get(i).getFile().getName();
				int num = ExecutableIndexTemplate.alphabet.indexOf(letter);
				indexDoc = "index-" + num + ".html";
				builder.append("<A HREF=\"").append(indexDoc).append("\">")
					.append(letter).append("</A>").append("&nbsp;|&nbsp;");
			}
			
			this.replacement = builder.toString();
		}
	}
	
	/*
	 * used to insert the executables of the specified letter
	 */
	public static class IndexExecutableWildCard extends DupeMultiValueWildCard {

		public IndexExecutableWildCard() {
			this.values.add("@@@IndexExecutable@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			StringBuilder builder;
			List<Executable> sorted = new ArrayList<Executable>();
			sorted.addAll(s.getSymbols());
			Collections.sort(sorted);
			
			String namespace = s.getPack().getName();

			for (Executable e : sorted) {
				builder = new StringBuilder();					
					
				builder
					.append("<A HREF=\"").append("../" + e.getLink() + "#" + e.getName() /*+ e.getMetaType()*/).append("\">").append(e.getName()).append("</A>")
					.append("(").append(e.getParamDef().replace("(", "").replace(")", "")).append(") ") // in expand files params are in brackets
					.append(" For ")
					.append("<A HREF=\"").append("../metatypes/" + e.getMetaType() + ".html").append("\">").append(e.getMetaType()).append("</A>")
					.append(" in ")
					.append("<A HREF=\"").append("../packages/" + StringHelper.replaceColonsWithDot(namespace) + ".html").append("\">").append(namespace).append("</A>")
					.append("::")
					.append("<A HREF=\"").append("../" + e.getLink()).append("\">").append(e.getScript().getFile().getName()).append("</A>");
					
				this.replacement.add(builder.toString());			
			}
		}
	}
	
	/*
	 * used to insert the executables of the specified letter
	 */
	public static class IndexLetterWildCard extends SingleValueWildCard {

		public IndexLetterWildCard() {
			this.values.add("@@@IndexLetter@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			Script s = (Script) c;
			String letter = s.getFile().getName();
			this.replacement = letter;
		}
	}
	
	/*
	 * used to create the external function page
	 */
	public static class ExternalFunctionWildCard extends DupeMultiValueWildCard{
		
		public ExternalFunctionWildCard() {
			this.values.add("@@@ExternalFunction@@@");
		}
		
		@Override
		public void setupReplacement(IContent c) {
			SymbolTable table = (SymbolTable) c;
			StringBuilder builder;
			String externalFunctionLink = "";
			for (ScriptPackage pack : table.getPackages()) {
				for (Script script : pack.getScripts()) {
					for (Executable ex : script.getSymbols()) {
						
						List<Executable> tmpCalled = new ArrayList<Executable>(); 
						tmpCalled.addAll(ex.getCalled());
						Collections.sort(tmpCalled);
						
						for (Executable called : tmpCalled) {
							if(called instanceof Function) {
								builder = new StringBuilder();
								Function calledFunction = (Function) called;
								String functionName = calledFunction.getName();
		
								if(functionName != "") {
									Function.OwnerType type = calledFunction.getOwnerType();
									if(type == OwnerType.ExternalFunction){
										builder.append("<A HREF=\"").append(externalFunctionLink).append("\">")
										.append("<B>").append(called.getName()).append("</A>").append(called.getParamDef()).append("</B>")
										.append("  called in ").append(pack.getName()).append("::").append(script.getFile().getName())
										.append(" :: ")
										.append("<A HREF=\"").append(ex.getLink()).append("#").append(ex.getName())/*.append(ex.getMetaType())*/.append("\">").append("<B>")
										.append(ex.getName()).append("</A>")
										.append("<BR>");
										this.replacement.add(builder.toString());
									}	
								}
							}
						}							
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * WildCards used to insert navi references
	 * 
	 */
	
	public static class NaviScriptSummaryWildCard extends SingleValueWildCard {

		public final String SUMMARYFILENAME = "allscripts.html";
		
		public NaviScriptSummaryWildCard() {
			this.values.add("@@@ScriptSummary@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			this.replacement = LinkGenerator.getRelativePath(c, SUMMARYFILENAME);	
		}
	}
	
	public static class NaviPackageSummaryWildCard extends SingleValueWildCard {

		public final String SUMMARYFILENAME = "package-summary.html";
		
		public NaviPackageSummaryWildCard() {
			this.values.add("@@@PackageSummary@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			this.replacement = LinkGenerator.getRelativePath(c, SUMMARYFILENAME);
		}
	}
	
	public static class NaviMetaTypeSummaryWildCard extends SingleValueWildCard {

		public final String SUMMARYFILENAME = "metatype-summary.html";
		
		public NaviMetaTypeSummaryWildCard() {
			this.values.add("@@@MetaTypeSummary@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			this.replacement = LinkGenerator.getRelativePath(c, SUMMARYFILENAME);	
		}
	}
	
	public static class NaviIndexWildCard extends SingleValueWildCard {

		public final String SUMMARYFILENAME = "index/index-0.html";
		
		public NaviIndexWildCard() {
			this.values.add("@@@Index@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			this.replacement = LinkGenerator.getRelativePath(c, SUMMARYFILENAME);
		}
	}
	
	public static class NaviStatsWildCard extends SingleValueWildCard {

		public final String SUMMARYFILENAME = "stats-summary.html";
		
		public NaviStatsWildCard() {
			this.values.add("@@@Stats@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			this.replacement = LinkGenerator.getRelativePath(c, SUMMARYFILENAME);	
		}
	}
	
	public static class NaviHelpWildCard extends SingleValueWildCard {

		public final String SUMMARYFILENAME = "help-doc.html";
		
		public NaviHelpWildCard() {
			this.values.add("@@@Help@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			this.replacement = LinkGenerator.getRelativePath(c, SUMMARYFILENAME);	
		}
	}
	
	/*
	 * 
	 * Stats navi 
	 * 
	 */
	
	/*
	 * used to create the navi of the stats page, furthermore it creates the "Overview"-reference
	 */
	public static class StatsNaviScriptSummaryWildCard extends SingleValueWildCard {

		public final String SUMMARYFILENAME = "allscripts.html";
		
		public StatsNaviScriptSummaryWildCard() {
			this.values.add("@@@StatsScriptSummary@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			this.replacement = "../" + LinkGenerator.getRelativePath(c, SUMMARYFILENAME);
		}
	}
	
	/*
	 * used to create the navi of the stats page, furthermore it creates the "Package"-reference
	 */
	public static class StatsNaviPackageSummaryWildCard extends SingleValueWildCard {

		public final String SUMMARYFILENAME = "package-summary.html";
		
		public StatsNaviPackageSummaryWildCard() {
			this.values.add("@@@StatsPackageSummary@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			this.replacement = "../" + LinkGenerator.getRelativePath(c, SUMMARYFILENAME);
		}
	}
	
	/*
	 * used to create the navi of the stats page, furthermore it creates the "Metatype"-reference
	 */
	public static class StatsNaviMetaTypeSummaryWildCard extends SingleValueWildCard {

		public final String SUMMARYFILENAME = "metatype-summary.html";
		
		public StatsNaviMetaTypeSummaryWildCard() {
			this.values.add("@@@StatsMetaTypeSummary@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			this.replacement = "../" + LinkGenerator.getRelativePath(c, SUMMARYFILENAME);	
		}
	}
	
	/*
	 * used to create the navi of the stats page, furthermore it creates the "stats"-reference
	 */
	public static class StatsNaviStatsWildCard extends SingleValueWildCard {

		public final String SUMMARYFILENAME = "stats-summary.html";
		
		public StatsNaviStatsWildCard() {
			this.values.add("@@@StatsStats@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			this.replacement = "../" + LinkGenerator.getRelativePath(c, SUMMARYFILENAME);	
		}
	}
	
	/*
	 * used to create the navi of the stats page, furthermore it creates the "help"-reference
	 */
	public static class StatsNaviHelpWildCard extends SingleValueWildCard {

		public final String SUMMARYFILENAME = "help-doc.html";
		
		public StatsNaviHelpWildCard() {
			this.values.add("@@@StatsHelp@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			this.replacement = "../" + LinkGenerator.getRelativePath(c, SUMMARYFILENAME);	
		}
	}
	
	/*
	 * used to create the navi of the stats page, furthermore it creates the "Index"-reference
	 */
	public static class StatsNaviIndexWildCard extends SingleValueWildCard {

		public final String SUMMARYFILENAME = "index-0.html";
		
		public StatsNaviIndexWildCard() {
			this.values.add("@@@StatsIndex@@@");
		}

		@Override
		public void setupReplacement(IContent c) {
			String path = LinkGenerator.getRelativePath(c, SUMMARYFILENAME);
			path = path.replace(SUMMARYFILENAME, "");
			path = path + "../index/" + SUMMARYFILENAME;
			
			this.replacement = path;	
		}
	}

	/* PROTECTED REGION END */

}
