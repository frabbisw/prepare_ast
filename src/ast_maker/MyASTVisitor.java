package ast_maker;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
public class MyASTVisitor extends ASTVisitor{
	@Override
	public boolean visit(MethodDeclaration node) {
		// TODO Auto-generated method stub
		System.out.print("( MethodDeclaration ");
		return super.visit(node);
	}
	@Override
	public void endVisit(MethodDeclaration node) {
		// TODO Auto-generated method stub
		System.out.print(") MethodDeclaration ");
		super.endVisit(node);
	}
	
	@Override
	public boolean visit(Block node) {
		// TODO Auto-generated method stub
		System.out.print("( Block ");
		return super.visit(node);
	}
	@Override
	public void endVisit(Block node) {
		// TODO Auto-generated method stub
		System.out.print(") Block ");
		super.endVisit(node);
	}
	
	@Override
	public boolean visit(IfStatement node) {
		System.out.print("( If ");
		return super.visit(node);
	}
	@Override
	public void endVisit(IfStatement node) {
		System.out.print(") If ");
		super.endVisit(node);
	}
	
	@Override
	public boolean visit(MethodInvocation node) {
		// TODO Auto-generated method stub
		System.out.print("( MethodInvocation ");
		return super.visit(node);
	}
	@Override
	public void endVisit(MethodInvocation node) {
		// TODO Auto-generated method stub
		System.out.print(") MethodInvocation ");
		super.endVisit(node);
	}
	
	@Override
	public boolean visit(SimpleName node) {
		// TODO Auto-generated method stub
		System.out.print("( SimpleName_"+node.getFullyQualifiedName()+" ");
		return super.visit(node);
	}
	@Override
	public void endVisit(SimpleName node) {
		// TODO Auto-generated method stub
		System.out.print(") SimpleName_"+node.getFullyQualifiedName()+" ");
		super.endVisit(node);
	}
	
	@Override
	public boolean visit(SimpleType node) {
		// TODO Auto-generated method stub
		System.out.print("( SimpleType ");
		return super.visit(node);
	}
	@Override
	public void endVisit(SimpleType node) {
		// TODO Auto-generated method stub
		System.out.print(") SimpleType ");
		super.endVisit(node);
	}
}
