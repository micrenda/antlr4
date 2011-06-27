package org.antlr.v4.codegen.model;

import org.antlr.v4.codegen.CoreOutputModelFactory;
import org.antlr.v4.tool.GrammarAST;

import java.util.*;

public class LexerFile extends OutputModelObject {
	public String fileName;

	@ModelElement public Lexer lexer;
	@ModelElement public Map<String, Action> namedActions;

	public LexerFile(CoreOutputModelFactory factory, String fileName) {
		super(factory);
		this.fileName = fileName;
		factory.root = this;
		namedActions = new HashMap<String, Action>();
		for (String name : factory.gen.g.namedActions.keySet()) {
			GrammarAST ast = factory.gen.g.namedActions.get(name);
			namedActions.put(name, new Action(factory, ast));
		}
		lexer = new Lexer(factory, this);
	}
}