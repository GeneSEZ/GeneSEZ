package org.genesez.xpand.demo;

import java.util.Arrays;
import java.util.List;

import org.eclipse.internal.xpand2.ast.Statement;
import org.eclipse.internal.xpand2.ast.Template;
import org.eclipse.internal.xpand2.model.XpandResource;
import org.eclipse.internal.xtend.expression.ast.DeclaredParameter;
import org.eclipse.internal.xtend.expression.ast.Identifier;
import org.eclipse.internal.xtend.expression.ast.SyntaxElement;

public class Comment extends SyntaxElement {

	private Template owner = null;

	private DeclaredParameter[] params;

	private Identifier name;

	private Identifier type;

	private Statement[] body;

	protected String _stringRepresentation = null;

	protected boolean wildParams = false;

	public Comment(final Identifier name, final Identifier type, final DeclaredParameter[] params, final Statement[] body) {
		this.name = name;
		this.type = type;
		this.params = params;
		this.body = body;
	}

	public XpandResource getOwner() {
		return owner;
	}

	public void setOwner(final Template owner) {
		this.owner = owner;
	}

	public DeclaredParameter[] getParams() {
		return params;
	}

	public List<DeclaredParameter> getParamsAsList() {
		return Arrays.asList(params);
	}

	public Identifier getType() {
		return type;
	}

	public String getTargetType() {
		return type.getValue();
	}

	public Identifier getDefName() {
		return name;
	}

	public String getName() {
		return name.getValue();
	}

}
