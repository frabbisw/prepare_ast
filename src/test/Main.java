package test;

import java.util.ArrayList;

import ast_maker.MethodAST;
import file_hadling.LoadJson;

public class Main {
	public static void main(String [] args)
	{
		int choice=99;
		LoadJson loadJson = new LoadJson("/home/rabbi/Desktop/thesis/pycodes/data/test.json");
		System.out.println(loadJson.getJsons().size());
		
		ArrayList<String>aa=loadJson.getMethods();
		ArrayList<String>bb=loadJson.getComments();
		
		System.out.println(aa.get(choice));
		System.out.println(bb.get(choice));
		
		MethodAST methodAST = new MethodAST(aa.get(choice));
		methodAST.printAST();
	}
}
