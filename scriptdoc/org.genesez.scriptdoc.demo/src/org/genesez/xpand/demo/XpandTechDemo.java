package org.genesez.xpand.demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.mwe.core.monitor.NullProgressMonitor;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.internal.xpand2.XpandUtil;
import org.eclipse.internal.xpand2.ast.Definition;
import org.eclipse.internal.xpand2.ast.ExpandStatement;
import org.eclipse.internal.xpand2.ast.ExtensionImportDeclaration;
import org.eclipse.internal.xpand2.ast.IfStatement;
import org.eclipse.internal.xpand2.ast.ImportDeclaration;
import org.eclipse.internal.xpand2.ast.Statement;
import org.eclipse.internal.xpand2.ast.Template;
import org.eclipse.internal.xpand2.ast.TextStatement;
import org.eclipse.internal.xpand2.model.XpandDefinition;
import org.eclipse.internal.xpand2.parser.XpandLexer;
import org.eclipse.internal.xpand2.parser.XpandParseFacade;
import org.eclipse.internal.xpand2.parser.XpandParser;
import org.eclipse.internal.xpand2.pr.ProtectedRegionResolver;
import org.eclipse.internal.xpand2.pr.ProtectedRegionResolverImpl;
import org.eclipse.internal.xtend.expression.ast.Expression;
import org.eclipse.internal.xtend.expression.ast.SyntaxElement;
import org.eclipse.internal.xtend.xtend.XtendFile;
import org.eclipse.internal.xtend.xtend.ast.Check;
import org.eclipse.internal.xtend.xtend.ast.ExpressionExtensionStatement;
import org.eclipse.internal.xtend.xtend.ast.Extension;
import org.eclipse.internal.xtend.xtend.ast.ExtensionFile;
import org.eclipse.internal.xtend.xtend.ast.ExtensionImportStatement;
import org.eclipse.internal.xtend.xtend.ast.NamespaceImportStatement;
import org.eclipse.internal.xtend.xtend.parser.ErrorHandler;
import org.eclipse.internal.xtend.xtend.parser.ParseException;
import org.eclipse.internal.xtend.xtend.parser.SyntaxError;
import org.eclipse.internal.xtend.xtend.parser.XtendError;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.XpandFacade;
import org.eclipse.xpand2.output.Output;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.check.CheckFacade;
import org.eclipse.xtend.check.CheckUtils;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent;
import org.eclipse.xtend.expression.AnalysationIssue;
import org.eclipse.xtend.expression.ExceptionHandler;
import org.eclipse.xtend.expression.ExceptionRaisingNullEvaluationHandler;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.NullEvaluationHandler;
import org.eclipse.xtend.expression.Resource;
import org.eclipse.xtend.expression.ResourceManager;
import org.eclipse.xtend.expression.ResourceManagerDefaultImpl;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.expression.VetoableCallback;
import org.eclipse.xtend.typesystem.Type;

public class XpandTechDemo {
	
	static XpandExecutionContext xpandExecutionContext = null;
	static ResourceManager resourceManager = null;
	static Set<AnalysationIssue> issues = new LinkedHashSet<>();
	
	static void doFancySetup() {
		resourceManager = new ResourceManagerDefaultImpl();
		Output out = new OutputImpl();
		ProtectedRegionResolver prr = new ProtectedRegionResolverImpl();
		Map<String, Variable> globalVariables = Collections.emptyMap();
		ProgressMonitor pm = new NullProgressMonitor();
		ExceptionHandler eh = new ExceptionHandler() {
			public void handleRuntimeException(RuntimeException ex, SyntaxElement element, ExecutionContext ctx,
					Map<String, Object> additionalContextInfo) {
				ex.printStackTrace();
//				throw ex;
			}
		};
		NullEvaluationHandler neh = new ExceptionRaisingNullEvaluationHandler();
		VetoableCallback vc = new VetoableCallback() {
			@Override
			public boolean pre(SyntaxElement ele, ExecutionContext ctx) {
				// continue processing normally
				return true;
			}
			@Override
			public void post(SyntaxElement ele, ExecutionContext ctx, Object expressionResult) {
			}
		};
		XpandExecutionContextImpl xec = new XpandExecutionContextImpl(
				resourceManager, out, prr, globalVariables, pm, eh, neh, vc
		);
//		xec.registerMetaModel();
		xpandExecutionContext = xec;
	}

	public static void main(String[] args) {
		doFancySetup();
		
		BufferedReader br;
		
		// one way
//		try {
//			br = new BufferedReader(new FileReader("demo/Test2.xpt"));
//
//			//GeneSEZXpandParser parser = getParser(br, "Test2.xpt");
//			
//			//Template t = parser.template();
//			Template t = XpandParseFacade.file(br, "Test2.xpt");
//			dumpTemplate(t);
//		} catch (FileNotFoundException fnfe) {
//			fnfe.printStackTrace();
//		}
//		
//		System.out.println();
//		System.out.println();
		
		// or the other reading from the classpath
//		try {
//			URL url = XpandTechDemo.class.getClassLoader().getResource("org/genesez/platform/java/m2t/Root.xpt");
//			br = new BufferedReader(
//					new FileReader(
//							url.getFile()
//					)
//			);
//			Template t2 = XpandParseFacade.file(br, url.getFile());
//			dump(t2);
//		} catch (FileNotFoundException fnfe) {
//			fnfe.printStackTrace();
//		}
//		
//		System.out.println();
//		System.out.println();
		
		// xpand way reading from classpath
		Resource r = resourceManager.loadResource("Test2", XpandUtil.TEMPLATE_EXTENSION);
		if (r instanceof Template) {
			dump((Template)r);
		}
		Resource r2 = resourceManager.loadResource("org::genesez::metamodel::core::util::CloneElement", XtendFile.FILE_EXTENSION);
		if (r2 instanceof ExtensionFile) {
			dump((ExtensionFile)r2);
		}
		Resource r3 = resourceManager.loadResource("org::genesez::platform::java::validation::Syntax", CheckUtils.FILE_EXTENSION);
		if (r3 instanceof ExtensionFile) {
			dump((ExtensionFile)r3);
		}
	}
	
	static void dump(Template t) {
		System.out.println(t.getFullyQualifiedName());
		for (ImportDeclaration id : t.getImportsAsList()) {
			dump(id);
		}
		
		for (ExtensionImportDeclaration eid : t.getExtensions()) {
			dump(eid);
		}
		
		for (XpandDefinition xd : t.getDefinitionsAsList()) {
			dump(xd);
		}
	}
	
	static void dump(ExtensionFile ef) {
		System.out.println(ef.getFullyQualifiedName());
		for (NamespaceImportStatement nis : ef.getNsImports()) {
			dump(nis);
		}
		for (ExtensionImportStatement eis : ef.getExtImports()) {
			dump(eis);
		}
		for (Check c : ef.getChecks()) {
			dump(c);
		}
		for (Extension e : ef.getExtensions()) {
			dump(e);
		}
	}
	
	static void dump(ImportDeclaration id) {
		System.out.println("Import @ line " + id.getLine() + " : " + id.getImportString());
	}
	
	static void dump(NamespaceImportStatement nis) {
		System.out.println("Namespace import @ line " + nis.getLine() + " : " + nis.getImportedId());
	}
	
	static void dump(ExtensionImportDeclaration eid) {
		System.out.println("Extension import @ line " + eid.getLine() + " : " + eid.getImportString());
//		eid.analyze(xpandExecutionContext, issues);
	}
	
	static void dump(ExtensionImportStatement eis) {
		System.out.println("Extension import @ line " + eis.getLine() + " : " + eis.getImportedId());
	}
	
	static void dump(XpandDefinition xd) {
		System.out.println("Definition @ line " + xd.getLine() + " for " + xd.getTargetType() + " : " + xd.getName());
		System.out.println("    " + xd.getQualifiedName() + " ( " + xd.getParamString(false) + " ) ");
		if (xd instanceof Definition) {
			Definition d = (Definition)xd;
			for (Statement s : d.getBodyAsList()) {
				System.out.println("    " + s.getLine() + " : " + s.toString());
				if (s instanceof TextStatement) {
					dump((TextStatement)s);
				} else if (s instanceof IfStatement) {
					dump((IfStatement)s);
				} else if (s instanceof ExpandStatement) {
					dump((ExpandStatement)s);
				}
			}
		}
	}
	
	static void dump(ExpressionExtensionStatement e) {
		System.out.println("Extension @ line " + e.getLine() + " : " + e.getName());
	}
	
	static void dump(Extension e) {
		System.out.println("Extension @ line " + e.getLine() + " : " + e.getName());
	}
	
	static void dump(Check c) {
		System.out.println("Check @ line " + c.getLine() + (c.isErrorCheck() ? " [error]" : " [warning]") + " for " + c.getType());
	}
	
	static void dump(TextStatement ts) {
		if (ts.isDeleteLine()) {
			System.out.println("        delete line text statement @ line " + ts.getLine());
		} else {
			System.out.println("        text statement @ line " + ts.getLine());
//			if (ts.getContainingDefinition() instanceof XpandDefinition) {
//				XpandDefinition xd = (XpandDefinition)ts.getContainingDefinition();
//				System.out.println("        -> " + xd.getQualifiedName() + " ( " + xd.getParamString(false) + " ) ");
//			}
		}
	}
	
	static void dump(IfStatement is) {
		String name = is.isElse() ? "else" : is.isElseIf() ? "else if" : "if";
		System.out.println("        " + name + " @ line " + is.getLine() + " : " + is.getCondition());
		for (Statement s : is.getBodyAsList()) {
			if (s instanceof ExpandStatement) {
				dump((ExpandStatement)s);
			}
		}
	}
	
	static void dump(ExpandStatement es) {
		System.out.println("        -> " + name(es));
		tryResolveDefinition(es.getDefinition().toString());
	}
	
	
	static String name(ExpandStatement es) {
		StringBuilder sb = new StringBuilder();
		sb.append(es.getDefinition());
		sb.append(" ( ");
		for (Expression e : es.getParametersAsList()) {
			sb.append(e);
		}
		sb.append(" ) ");
		if (es.getTarget() != null) {
			sb.append(" for " + es.getTarget());
		}
		if (es.getSeparator() != null) {
			sb.append(" with separator " + es.getSeparator());
		}
		return sb.toString();
	}
	
	
	static void dumpAnalyzationIssues() {
		for (AnalysationIssue ai : issues) {
			System.out.println(ai.toString());
		}
	}
	
	
	
	static void tryResolveDefinition(String name) {
		Type t = null;
		Type[] params = new Type[0];
		
		XpandDefinition xd = xpandExecutionContext.findDefinition(name, t, params);
		
		int i = 42;
	}
	
	
	
	// ------------------------------------------------------------------------------------------------------

	/**
	 * @deprecated currently not needed, check if its useful
	 */
	private static GeneSEZXpandParser getParser(final Reader reader, final String fileName) {
		ANTLRReaderStream readerStream;

		try {
			readerStream = new ANTLRReaderStream(reader);
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}

		final ErrorHandler errorHandler = getErrorHandler();

		final XpandLexer lex = new XpandLexer(readerStream) {
			@Override
			public void reportError(final RecognitionException e) {
				errorHandler.handleError(createError(e, getErrorMessage(e, getTokenNames())));
			}
		};

		final CommonTokenStream str = new CommonTokenStream();
		str.setTokenSource(lex);

		final GeneSEZXpandParser parser = new GeneSEZXpandParser(str, fileName) {
			@Override
			public void reportError(final RecognitionException e) {
				errorHandler.handleError(createError(e, getErrorMessage(e, getTokenNames())));
			}
		};
		return parser;
	}

	private static ErrorHandler getErrorHandler() {
		final ErrorHandler handler = new ErrorHandler() {
			public void handleError(final XtendError e) {
				throw new ParseException(e);
			}
		};
		return handler;
	}

	private static XtendError createError(final RecognitionException e, final String string) {
		if (e.token == null)
			return new SyntaxError(e.index, e.line, e.index + 1, string);
		else {
			final CommonToken t = (CommonToken) e.token;
			return new SyntaxError(t.getStartIndex(), t.getStopIndex(), t.getLine(), string);
		}
	}

}
