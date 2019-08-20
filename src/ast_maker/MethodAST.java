package ast_maker;

import java.util.ArrayList;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;

public class MethodAST {
	ArrayList<String>asts;
	ArrayList<String>methods;
	
	public MethodAST() {
		asts=new ArrayList<String>();
	}
	
	public void prepareASTs(ArrayList<String>methods) {
		this.methods=methods;
		
		System.out.println("preparing\n");
		
		for(int i=0; i<methods.size(); i++){
			String method = methods.get(i);
			asts.add(getAST(method));
			
			if(i%(int)(1.0+(double)methods.size()/10000.0)==0) {
				System.out.print("\r"+100*i/(double)methods.size()+" %");
			}
		}
		System.out.println("\nast prepared.");
	}
	
	public ArrayList<String>getASTList(){
		return asts;
	}
	
	public String getAST(String methodStr) {
		String classStr="public class Tmp {\n+" + methodStr + "\n}";
		
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(classStr.toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);

		MyASTVisitor visitor = new MyASTVisitor();
		
		final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
				
		cu.accept(new ASTVisitor() {
			@Override
			public boolean visit(MethodDeclaration node) {
				node.accept(visitor);
				return false;
			}
		});
		
		return visitor.getSBT();
	}
}