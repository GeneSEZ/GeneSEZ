package org.genesez.xpand.demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.antlr.runtime.ANTLRReaderStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.internal.xpand2.ast.Definition;
import org.eclipse.internal.xpand2.ast.ImportDeclaration;
import org.eclipse.internal.xpand2.ast.Statement;
import org.eclipse.internal.xpand2.ast.Template;
import org.eclipse.internal.xpand2.model.XpandDefinition;
import org.eclipse.internal.xpand2.parser.XpandLexer;
import org.eclipse.internal.xpand2.parser.XpandParseFacade;
import org.eclipse.internal.xpand2.parser.XpandParser;
import org.eclipse.internal.xtend.xtend.parser.ErrorHandler;
import org.eclipse.internal.xtend.xtend.parser.ParseException;
import org.eclipse.internal.xtend.xtend.parser.SyntaxError;
import org.eclipse.internal.xtend.xtend.parser.XtendError;
import org.eclipse.xpand2.XpandFacade;

public class XpandTechDemo {

	public static void main(String[] args) throws FileNotFoundException, RecognitionException {

		BufferedReader br = new BufferedReader(new FileReader("demo/Test2.xpt"));

		//GeneSEZXpandParser parser = getParser(br, "Test2.xpt");
				
		//Template t = parser.template();
		Template t = XpandParseFacade.file(br, "Test2.xpt");
		
		
		System.out.println("All Xpand Imports");
		for (ImportDeclaration id : t.getImportsAsList()) {
			System.out.println(id.getImportString());
		}
		
		System.out.println("All Xtend Extensions");
		for (String ie : t.getImportedExtensionsAsList()) {
			System.out.println(ie.toString());
		}
		
		System.out.println("All Xpand Definitions");
		for (XpandDefinition xd : t.getDefinitionsAsList()) {
			Definition d = ((Definition)xd);
			System.out.println(xd.getQualifiedName() + xd.getParamString(false) + " Start: " + xd.getStart() + " End: " + xd.getEnd() + " Line: " + xd.getLine() + " TargetType: " + xd.getTargetType());
			for (Statement s : d.getBodyAsList()) {
				System.out.println("--" + s.getLine());
			}
		}
		
	}

	// ------------------------------------------------------------------------------------------------------

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
