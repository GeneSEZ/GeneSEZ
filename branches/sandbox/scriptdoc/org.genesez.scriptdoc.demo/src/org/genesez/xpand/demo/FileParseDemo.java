package org.genesez.xpand.demo;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

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
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xpand2.XpandExecutionContextImpl;
import org.eclipse.xpand2.output.Output;
import org.eclipse.xpand2.output.OutputImpl;
import org.eclipse.xtend.check.CheckUtils;
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

/**
 * Tech-demo showing how to parse XPand related files: templates (*.xpt), scripts (*.ext) and validation scripts (*.chk).
 */
public class FileParseDemo {
	
	static XpandExecutionContext xpandExecutionContext = null;
	static ResourceManager resourceManager = null;
	static Set<AnalysationIssue> issues = new LinkedHashSet<>();
	
	public static void main(String[] args) {
		doFancySetup();
		
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
	
	/**
	 * Does some initialization of XPand related stuff.
	 */
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
	
	/**
	 * Dumps some information about a template (*.xpt file).
	 */
	static void dump(Template t) {
		System.out.println(t.getFullyQualifiedName());
		// imports
		for (ImportDeclaration id : t.getImportsAsList()) {
			dump(id);
		}
		
		// imported extension files
		for (ExtensionImportDeclaration eid : t.getExtensions()) {
			dump(eid);
		}
		
		// define blocks
		for (XpandDefinition xd : t.getDefinitionsAsList()) {
			dump(xd);
		}
	}
	
	/**
	 * Dumps some information about an extension file, which is either a script (*.ext) or validation script (*.chk).
	 */
	static void dump(ExtensionFile ef) {
		System.out.println(ef.getFullyQualifiedName());
		// import ...
		for (NamespaceImportStatement nis : ef.getNsImports()) {
			dump(nis);
		}
		// extension ...
		for (ExtensionImportStatement eis : ef.getExtImports()) {
			dump(eis);
		}
		// validation scripts (*.chk) contain checks
		for (Check c : ef.getChecks()) {
			dump(c);
		}
		// scripts (*.ext) contain extension functions
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
}
