package ast_maker;

import java.util.ArrayList;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;

public class MethodAST {
	ArrayList<String>sbts;
	ArrayList<String>methods;
	
	public MethodAST() {
		sbts=new ArrayList<String>();
	}
	
	public void prepareASTs(ArrayList<String>methods) {
		this.methods=methods;
		
		for(int i=0; i<methods.size(); i++){
			
			if((i+1)%(int)((double)methods.size()/1000)==0)
			{
				System.out.print("\r");
				System.out.print(((double)i/(double)methods.size())*100+" %");
			}
			
			String method = methods.get(i);
			sbts.add(getAST(method));
		}
		
		System.out.println();
	}
	
	public ArrayList<String>getASTList(){
		return sbts;
	}
	
	public static String getAST(String methodStr) {
		String classStr="public class Tmp {\n+" + methodStr + "\n}";
		
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setSource(classStr.toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);

		MyASTVisitor visitor = new MyASTVisitor();
		
		final CompilationUnit cu = (CompilationUnit) parser.createAST(null);
				
		cu.accept(new ASTVisitor() {
			@Override
			public boolean visit(MethodDeclaration node) {
				//print(node, 0);
				
				node.accept(visitor);
				
				//System.out.println(visitor.getSBT());
				
				return false;
			}
		});
		
		return visitor.getSBT();
	}
}