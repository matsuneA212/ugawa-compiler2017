import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import parser.TinyPiELexer;
import parser.TinyPiEParser;

public class Compiler extends CompilerBase {
	void compileExpr(ASTNode ndx, Environment env) {
		throw new Error("not implemented");
	}
	
	void compile(ASTNode ast) {
		Environment env = new Environment();
		GlobalVariable vx = addGlovalVariable(env, "x");
		GlobalVariable vy = addGlobalVariable(env, "y");
		GlobalVariable vz = addGlobalVariable(env, "z");
		
		System.out.println("\t.section .data");
		System.out.println("\t@ 大域変数の定義");
		emitLabel(vx.getLabel());
		System.out.println("")
		
		throw new Error("not implemented");
	}

	public static void main(String[] args) throws IOException {
		ANTLRInputStream input = new ANTLRInputStream(System.in);
		TinyPiELexer lexer = new TinyPiELexer(input);
		CommonTokenStream token = new CommonTokenStream(lexer);
		TinyPiEParser parser = new TinyPiEParser(token);
		ParseTree tree = parser.expr();
		ASTGenerator astgen = new ASTGenerator();
		ASTNode ast = astgen.translate(tree);
		Compiler compiler = new Compiler();
		compiler.compile(ast);
	}
}
