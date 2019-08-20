package file_hadling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.json.*;

public class LoadJson {
	String fileName;
	String wholeJson;
	ArrayList<JSONObject>jsonList;
	ArrayList<String>methodList;
	ArrayList<String>commentList;
	
	public LoadJson(String fileName){
		wholeJson="";
		this.fileName=fileName;
		jsonList=new ArrayList<JSONObject>();
		methodList=new ArrayList<String>();
		commentList=new ArrayList<String>();
				
		try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	JSONObject jObject = new JSONObject(line);
		    	
		    	if(jObject.has("code")) {
		    		methodList.add(jObject.get("code").toString());
		    		//wholeJson+=jObject.get("code").toString();
		    	}
		    		
		    	if(jObject.has("nl")) {
		    		commentList.add(jObject.get("nl").toString());
		    		//wholeJson+=jObject.get("nl").toString();
		    	}
			    	
		    	if(jObject.has("ast")) {
		    		commentList.add(jObject.get("ast").toString());
		    		//wholeJson+=jObject.get("ast").toString();
		    	}
		    		
		    	jsonList.add(jObject);
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("jsons loaded.");
	}
	public ArrayList<JSONObject>getJsons(){
		return jsonList;
	}
	public ArrayList<String>getMethods(){
		return methodList;
	}
	public ArrayList<String>getComments(){
		return commentList;
	}
	public void addAST(ArrayList<String> asts) {
		wholeJson="";
		for(int i=0; i<asts.size(); i++){
			JSONObject jsonObject = jsonList.get(i);
			jsonObject.put("ast", asts.get(i));
			wholeJson+=(jsonObject.toString()+"\n");
		}
		System.out.println("ast added to jsons.");
	}
	public String getWholeJsonAsString() {
		return wholeJson;
	}
	public void saveJson(String filename) {
		try {
			FileWriter fw=new FileWriter(filename);
	           fw.write(wholeJson);
	           fw.close();
	           System.out.println("jsons saved.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}