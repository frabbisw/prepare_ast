package ast_maker;

import java.util.Iterator;
import java.util.List;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ChildListPropertyDescriptor;
import org.eclipse.jdt.core.dom.ChildPropertyDescriptor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SimplePropertyDescriptor;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

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
				print(node, 0);
				return super.visit(node);
			}
		});
	}
	
	private void printTabs(int tabs){
		for (int i=0; i<tabs; i++)
			System.out.print("\t");
	}
	
	private void print(ASTNode node, int tabs) {
		List properties= node.structuralPropertiesForType();
		for (Iterator iterator = properties.iterator(); iterator.hasNext();) {
			Object descriptor = iterator.next();
			if (descriptor instanceof SimplePropertyDescriptor) {
				SimplePropertyDescriptor simple = (SimplePropertyDescriptor) descriptor;
				Object value = node.getStructuralProperty(simple);
				
				printTabs(tabs);
				System.out.println(simple.getId() + " (" + value.toString() + ")");
			} else if (descriptor instanceof ChildPropertyDescriptor) {
				ChildPropertyDescriptor child = (ChildPropertyDescriptor) descriptor;
				ASTNode childNode = (ASTNode) node.getStructuralProperty(child);
				if (childNode != null) {
					printTabs(tabs);
					System.out.println("Child (" + child.getId() + ") {");
					print(childNode,tabs+1);
					printTabs(tabs);
					System.out.println("}");
				}
			} else {
				ChildListPropertyDescriptor list = (ChildListPropertyDescriptor) descriptor;
				printTabs(tabs);
				System.out.println("List (" + list.getId() + "){");
				print((List) node.getStructuralProperty(list), tabs+1);
				printTabs(tabs);
				System.out.println("}");
			}
		}
	}

	private void print(List nodes, int tabs) {
		for (Iterator iterator = nodes.iterator(); iterator.hasNext();) {
			print((ASTNode) iterator.next(), tabs);
		}
	}
}