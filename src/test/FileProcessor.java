package test;

import ast_maker.MethodAST;
import file_hadling.LoadJson;

public class FileProcessor {
	String dir="";
	public FileProcessor(String dir)
	{
		this.dir=dir;
	}
	public void loadAndSave(String filename) {
		LoadJson loadJson = new LoadJson(dir+"/"+filename);
		
		MethodAST methodAST = new MethodAST();
		methodAST.prepareASTs(loadJson.getMethods());
		loadJson.addAST(methodAST.getASTList());
		
		loadJson.saveJson(dir+"/"+"out_"+filename);
		
		System.out.println(filename+" ... done!!");
	}
}