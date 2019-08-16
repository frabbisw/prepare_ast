package ast_maker;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;

public class MethodAST {
	String methodStr;
	String classStr;
	
	public MethodAST(String methodStr) {
		this.methodStr=methodStr;
		this.classStr="public class Tmp {\n+" + methodStr + "\n}";
	}
	
	public void printAST() {
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(classStr.toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);

		final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
				
		cu.accept(new ASTVisitor() {
			@Override
			public boolean visit(MethodDeclaration node) {
				//print(node, 0);
				MyASTVisitor visitor = new MyASTVisitor();
				node.accept(visitor);
				
				return false;
			}
		});
	}
}