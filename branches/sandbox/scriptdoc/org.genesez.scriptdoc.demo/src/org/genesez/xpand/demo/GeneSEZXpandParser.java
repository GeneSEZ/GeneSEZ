package org.genesez.xpand.demo;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.eclipse.internal.xpand2.ast.Advice;
import org.eclipse.internal.xpand2.ast.Definition;
import org.eclipse.internal.xpand2.ast.ErrorStatement;
import org.eclipse.internal.xpand2.ast.ExpandStatement;
import org.eclipse.internal.xpand2.ast.ExpressionStatement;
import org.eclipse.internal.xpand2.ast.ExtensionImportDeclaration;
import org.eclipse.internal.xpand2.ast.FileStatement;
import org.eclipse.internal.xpand2.ast.ForEachStatement;
import org.eclipse.internal.xpand2.ast.IfStatement;
import org.eclipse.internal.xpand2.ast.ImportDeclaration;
import org.eclipse.internal.xpand2.ast.LetStatement;
import org.eclipse.internal.xpand2.ast.ProtectStatement;
import org.eclipse.internal.xpand2.ast.Statement;
import org.eclipse.internal.xpand2.ast.Template;
import org.eclipse.internal.xpand2.parser.XpandFactory;
import org.eclipse.internal.xpand2.parser.XpandParser;
import org.eclipse.internal.xtend.expression.ast.DeclaredParameter;
import org.eclipse.internal.xtend.expression.ast.Expression;
import org.eclipse.internal.xtend.expression.ast.FeatureCall;
import org.eclipse.internal.xtend.expression.ast.GlobalVarExpression;
import org.eclipse.internal.xtend.expression.ast.SyntaxElement;

public class GeneSEZXpandParser extends XpandParser {
	
	public GeneSEZXpandParser(final TokenStream stream) {
		super(stream, new XpandFactory("nofile"));
	}

	public GeneSEZXpandParser(final TokenStream stream, final String fileName) {
		super(stream, new XpandFactory(fileName));
	}

	private static <T extends SyntaxElement> T addLocation(final int[] startAndLine, final T ele, final int end) {
		if (ele != null) {
			ele.setStart(startAndLine[0]);
			ele.setLine(startAndLine[1]);
			ele.setEnd(end);
		}
		return ele;
	}

	private int[] start() {
		final CommonToken t = (CommonToken) input.LT(1);
		if (t == null)
			return new int[] { 0, 0 };
		return new int[] { t.getStartIndex(), t.getLine() };
	}

	private int end() {
		final CommonToken t = (CommonToken) input.LT(-1);
		if (t == null)
			return -1;
		return t.getStopIndex() + 1;
	}

	@Override
	public void reportError(final RecognitionException e) {
		System.out.println(super.getErrorMessage(e, tokenNames));
		throw new RuntimeException(e);
	}

	@Override
	public Expression additiveExpression() throws RecognitionException {
		return addLocation(start(), super.additiveExpression(), end());
	}

	@Override
	public Expression andExpression() throws RecognitionException {
		return addLocation(start(), super.andExpression(), end());
	}

	@Override
	public ExtensionImportDeclaration anExtensionImport() throws RecognitionException {
		return addLocation(start(), super.anExtensionImport(), end());
	}

	@Override
	public ImportDeclaration anImport() throws RecognitionException {
		return addLocation(start(), super.anImport(), end());
	}

	@Override
	public Advice around() throws RecognitionException {
		return addLocation(start(), super.around(), end());
	}

	@Override
	public Expression booleanLiteral() throws RecognitionException {
		return addLocation(start(), super.booleanLiteral(), end());
	}

	@Override
	public Expression castedExpression() throws RecognitionException {
		return addLocation(start(), super.castedExpression(), end());
	}

	@Override
	public Expression chainExpression() throws RecognitionException {
		return addLocation(start(), super.chainExpression(), end());
	}

	@Override
	public FeatureCall collectionExpression() throws RecognitionException {
		return addLocation(start(), super.collectionExpression(), end());
	}

	@Override
	public org.eclipse.internal.xtend.expression.ast.Identifier collectionType() throws RecognitionException {
		return addLocation(start(), super.collectionType(), end());
	}

	@Override
	public Expression constructorCall() throws RecognitionException {
		return addLocation(start(), super.constructorCall(), end());
	}

	@Override
	public DeclaredParameter declaredParameter() throws RecognitionException {
		return addLocation(start(), super.declaredParameter(), end());
	}

	@Override
	public Definition define() throws RecognitionException {
		return addLocation(start(), super.define(), end());
	}

	@Override
	public org.eclipse.internal.xtend.expression.ast.Identifier definitionName() throws RecognitionException {
		return addLocation(start(), super.definitionName(), end());
	}

	@Override
	public IfStatement elseIfStatement() throws RecognitionException {
		return addLocation(start(), super.elseIfStatement(), end());
	}

	@Override
	public IfStatement elseStatement() throws RecognitionException {
		return addLocation(start(), super.elseStatement(), end());
	}

	@Override
	public ErrorStatement errorStatement() throws RecognitionException {
		return addLocation(start(), super.errorStatement(), end());
	}

	@Override
	public ExpandStatement expandStatement() throws RecognitionException {
		return addLocation(start(), super.expandStatement(), end());
	}

	@Override
	public Expression expression() throws RecognitionException {
		return addLocation(start(), super.expression(), end());
	}

	@Override
	public ExpressionStatement expressionStmt() throws RecognitionException {
		return addLocation(start(), super.expressionStmt(), end());
	}

	@Override
	public FeatureCall featureCall() throws RecognitionException {
		return addLocation(start(), super.featureCall(), end());
	}

	@Override
	public FileStatement fileStatement() throws RecognitionException {
		return addLocation(start(), super.fileStatement(), end());
	}

	@Override
	public ForEachStatement foreachStatement() throws RecognitionException {
		return addLocation(start(), super.foreachStatement(), end());
	}

	@Override
	public GlobalVarExpression globalVarExpression() throws RecognitionException {
		return addLocation(start(), super.globalVarExpression(), end());
	}

	@Override
	public org.eclipse.internal.xtend.expression.ast.Identifier identifier() throws RecognitionException {
		return addLocation(start(), super.identifier(), end());
	}

	@Override
	public Expression ifExpression() throws RecognitionException {
		return addLocation(start(), super.ifExpression(), end());
	}

	@Override
	public IfStatement ifStatement() throws RecognitionException {
		return addLocation(start(), super.ifStatement(), end());
	}

	@Override
	public Expression impliesExpression() throws RecognitionException {
		return addLocation(start(), super.impliesExpression(), end());
	}

	@Override
	public Expression infixExpression() throws RecognitionException {
		return addLocation(start(), super.infixExpression(), end());
	}

	@Override
	public Expression letExpression() throws RecognitionException {
		return addLocation(start(), super.letExpression(), end());
	}

	@Override
	public LetStatement letStatement() throws RecognitionException {
		return addLocation(start(), super.letStatement(), end());
	}

	@Override
	public Expression listLiteral() throws RecognitionException {
		return addLocation(start(), super.listLiteral(), end());
	}

	@Override
	public Expression multiplicativeExpression() throws RecognitionException {
		return addLocation(start(), super.multiplicativeExpression(), end());
	}

	@Override
	public Expression nullLiteral() throws RecognitionException {
		return addLocation(start(), super.nullLiteral(), end());
	}

	@Override
	public Expression numberLiteral() throws RecognitionException {
		return addLocation(start(), super.numberLiteral(), end());
	}

	@Override
	public Expression orExpression() throws RecognitionException {
		return addLocation(start(), super.orExpression(), end());
	}

	@Override
	public Expression paranthesizedExpression() throws RecognitionException {
		return addLocation(start(), super.paranthesizedExpression(), end());
	}

	@Override
	public org.eclipse.internal.xtend.expression.ast.Identifier pointcut() throws RecognitionException {
		return addLocation(start(), super.pointcut(), end());
	}

	@Override
	public Expression primaryExpression() throws RecognitionException {
		return addLocation(start(), super.primaryExpression(), end());
	}

	@Override
	public ProtectStatement protectStatement() throws RecognitionException {
		return addLocation(start(), super.protectStatement(), end());
	}

	@Override
	public Expression relationalExpression() throws RecognitionException {
		return addLocation(start(), super.relationalExpression(), end());
	}

	@Override
	public Statement simpleStatement() throws RecognitionException {
		return addLocation(start(), super.simpleStatement(), end());
	}

	@Override
	public org.eclipse.internal.xtend.expression.ast.Identifier simpleType() throws RecognitionException {
		return addLocation(start(), super.simpleType(), end());
	}

	@Override
	public Statement statement() throws RecognitionException {
		return addLocation(start(), super.statement(), end());
	}

	@Override
	public Expression switchExpression() throws RecognitionException {
		return addLocation(start(), super.switchExpression(), end());
	}

	@Override
	public Template template() throws RecognitionException {
		return addLocation(start(), super.template(), end());
	}
	
	
	// $ANTLR start template
    // src/org/eclipse/internal/xpand2/parser/Xpand.g:44:1: template returns [Template t] : ( LG ( COMMENT TEXT )* ( (imp= anImport | extimp= anExtensionImport ) TEXT ( COMMENT TEXT )* )* ( (d= define | a= around ) TEXT ( COMMENT TEXT )* )* | );
    public Template templates() throws RecognitionException {
        Template t = null;

        ImportDeclaration imp = null;

        ExtensionImportDeclaration extimp = null;

        Definition d = null;

        Advice a = null;


        List imports = new ArrayList(),extensions = new ArrayList(), defines = new ArrayList(), advices = new ArrayList();
        try {
            // src/org/eclipse/internal/xpand2/parser/Xpand.g:45:123: ( LG ( COMMENT TEXT )* ( (imp= anImport | extimp= anExtensionImport ) TEXT ( COMMENT TEXT )* )* ( (d= define | a= around ) TEXT ( COMMENT TEXT )* )* | )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==LG) ) {
                alt8=1;
            }
            else if ( (LA8_0==EOF) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return t;}
                NoViableAltException nvae =
                    new NoViableAltException("44:1: template returns [Template t] : ( LG ( COMMENT TEXT )* ( (imp= anImport | extimp= anExtensionImport ) TEXT ( COMMENT TEXT )* )* ( (d= define | a= around ) TEXT ( COMMENT TEXT )* )* | );", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // src/org/eclipse/internal/xpand2/parser/Xpand.g:46:2: LG ( COMMENT TEXT )* ( (imp= anImport | extimp= anExtensionImport ) TEXT ( COMMENT TEXT )* )* ( (d= define | a= around ) TEXT ( COMMENT TEXT )* )*
                    {
                    match(input,LG,FOLLOW_LG_in_template47); if (state.failed) return t;
                    // src/org/eclipse/internal/xpand2/parser/Xpand.g:47:3: ( COMMENT TEXT )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==COMMENT) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // src/org/eclipse/internal/xpand2/parser/Xpand.g:47:4: COMMENT TEXT
                    	    {
                    	    match(input,COMMENT,FOLLOW_COMMENT_in_template52); if (state.failed) return t;
                    	    match(input,TEXT,FOLLOW_TEXT_in_template54); if (state.failed) return t;

                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    // src/org/eclipse/internal/xpand2/parser/Xpand.g:48:3: ( (imp= anImport | extimp= anExtensionImport ) TEXT ( COMMENT TEXT )* )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>=21 && LA4_0<=22)) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // src/org/eclipse/internal/xpand2/parser/Xpand.g:48:4: (imp= anImport | extimp= anExtensionImport ) TEXT ( COMMENT TEXT )*
                    	    {
                    	    // src/org/eclipse/internal/xpand2/parser/Xpand.g:48:4: (imp= anImport | extimp= anExtensionImport )
                    	    int alt2=2;
                    	    int LA2_0 = input.LA(1);

                    	    if ( (LA2_0==21) ) {
                    	        alt2=1;
                    	    }
                    	    else if ( (LA2_0==22) ) {
                    	        alt2=2;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return t;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("48:4: (imp= anImport | extimp= anExtensionImport )", 2, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt2) {
                    	        case 1 :
                    	            // src/org/eclipse/internal/xpand2/parser/Xpand.g:48:5: imp= anImport
                    	            {
                    	            pushFollow(FOLLOW_anImport_in_template64);
                    	            imp=anImport();
                    	            state._fsp--;
                    	            if (state.failed) return t;
                    	            if ( state.backtracking==0 ) {
                    	              imports.add(imp);
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // src/org/eclipse/internal/xpand2/parser/Xpand.g:48:41: extimp= anExtensionImport
                    	            {
                    	            pushFollow(FOLLOW_anExtensionImport_in_template73);
                    	            extimp=anExtensionImport();
                    	            state._fsp--;
                    	            if (state.failed) return t;
                    	            if ( state.backtracking==0 ) {
                    	              extensions.add(extimp);
                    	            }

                    	            }
                    	            break;

                    	    }

                    	    match(input,TEXT,FOLLOW_TEXT_in_template78); if (state.failed) return t;
                    	    // src/org/eclipse/internal/xpand2/parser/Xpand.g:48:98: ( COMMENT TEXT )*
                    	    loop3:
                    	    do {
                    	        int alt3=2;
                    	        int LA3_0 = input.LA(1);

                    	        if ( (LA3_0==COMMENT) ) {
                    	            alt3=1;
                    	        }


                    	        switch (alt3) {
                    	    	case 1 :
                    	    	    // src/org/eclipse/internal/xpand2/parser/Xpand.g:48:99: COMMENT TEXT
                    	    	    {
                    	    	    match(input,COMMENT,FOLLOW_COMMENT_in_template81); if (state.failed) return t;
                    	    	    match(input,TEXT,FOLLOW_TEXT_in_template83); if (state.failed) return t;

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop3;
                    	        }
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    // src/org/eclipse/internal/xpand2/parser/Xpand.g:49:3: ( (d= define | a= around ) TEXT ( COMMENT TEXT )* )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==23||LA7_0==31) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // src/org/eclipse/internal/xpand2/parser/Xpand.g:49:4: (d= define | a= around ) TEXT ( COMMENT TEXT )*
                    	    {
                    	    // src/org/eclipse/internal/xpand2/parser/Xpand.g:49:4: (d= define | a= around )
                    	    int alt5=2;
                    	    int LA5_0 = input.LA(1);

                    	    if ( (LA5_0==31) ) {
                    	        alt5=1;
                    	    }
                    	    else if ( (LA5_0==23) ) {
                    	        alt5=2;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return t;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("49:4: (d= define | a= around )", 5, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt5) {
                    	        case 1 :
                    	            // src/org/eclipse/internal/xpand2/parser/Xpand.g:49:5: d= define
                    	            {
                    	            pushFollow(FOLLOW_define_in_template95);
                    	            d=define();
                    	            state._fsp--;
                    	            if (state.failed) return t;
                    	            if ( state.backtracking==0 ) {
                    	              defines.add(d);
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // src/org/eclipse/internal/xpand2/parser/Xpand.g:49:33: a= around
                    	            {
                    	            pushFollow(FOLLOW_around_in_template102);
                    	            a=around();
                    	            state._fsp--;
                    	            if (state.failed) return t;
                    	            if ( state.backtracking==0 ) {
                    	              advices.add(a);
                    	            }

                    	            }
                    	            break;

                    	    }

                    	    match(input,TEXT,FOLLOW_TEXT_in_template106); if (state.failed) return t;
                    	    // src/org/eclipse/internal/xpand2/parser/Xpand.g:49:65: ( COMMENT TEXT )*
                    	    loop6:
                    	    do {
                    	        int alt6=2;
                    	        int LA6_0 = input.LA(1);

                    	        if ( (LA6_0==COMMENT) ) {
                    	            alt6=1;
                    	        }


                    	        switch (alt6) {
                    	    	case 1 :
                    	    	    // src/org/eclipse/internal/xpand2/parser/Xpand.g:49:66: COMMENT TEXT
                    	    	    {
                    	    	    match(input,COMMENT,FOLLOW_COMMENT_in_template109); if (state.failed) return t;
                    	    	    match(input,TEXT,FOLLOW_TEXT_in_template111); if (state.failed) return t;

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop6;
                    	        }
                    	    } while (true);


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    //if ( state.backtracking==0 ) {
                    //  t = factory.createTemplate(imports,extensions,defines,advices);
                    //}

                    }
                    break;
                case 2 :
                    // src/org/eclipse/internal/xpand2/parser/Xpand.g:52:1: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return t;
    }
    // $ANTLR end template
    

	@Override
	public Statement text() throws RecognitionException {
		return addLocation(start(), super.text(), end());
	}

	@Override
	public org.eclipse.internal.xtend.expression.ast.Identifier type() throws RecognitionException {
		return addLocation(start(), super.type(), end());
	}

	@Override
	public Expression unaryExpression() throws RecognitionException {
		return addLocation(start(), super.unaryExpression(), end());
	}

}
