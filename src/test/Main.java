package test;

import java.util.ArrayList;

import file_hadling.LoadJson;

public class Main {
	public static void main(String [] args)
	{
		LoadJson loadJson = new LoadJson("/home/rabbi/Desktop/thesis/pycodes/data/test.json");
		System.out.println(loadJson.getJsons().size());
		
		ArrayList<String>aa=loadJson.getMethods();
		ArrayList<String>bb=loadJson.getComments();
		
		System.out.println(aa.get(99));
		System.out.println(bb.get(99));
	}
}
