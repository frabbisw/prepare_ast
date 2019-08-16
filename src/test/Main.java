package test;

import java.util.ArrayList;

import ast_maker.MethodAST;
import file_hadling.LoadJson;

public class Main {
	public static void main(String [] args)
	{
		int choice=34;
		//LoadJson loadJson = new LoadJson("/home/rabbi/Desktop/thesis/pycodes/data/test.json");
		//System.out.println(loadJson.getJsons().size());
		
		//ArrayList<String>aa=loadJson.getMethods();
		//ArrayList<String>bb=loadJson.getComments();
		
		//System.out.println(aa.get(choice));
		//System.out.println(bb.get(choice));
		
		String Hablu = "public String contains(int index){\n" + 
				"String aa = null;" +
				"\tif (3<2) {\n" +
				"\t\taa = getFirst();\n" +
				"\t}\n" +
				"\telse {\n" +
				"\t\taa = getLast();\n" +
				"\t}\n" +
				"\treturn aa;"+
				"\n}";
		
//		System.out.println(Hablu);
//		System.out.println();
//		System.out.println();
		
		//MethodAST methodAST = new MethodAST(aa.get(choice));
		MethodAST methodAST = new MethodAST(Hablu);
		methodAST.printAST();
	}
}