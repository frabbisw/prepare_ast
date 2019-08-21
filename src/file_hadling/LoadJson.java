package file_hadling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.json.*;

public class LoadJson {
	String fileName;
	ArrayList<JSONObject>jsonList;
	ArrayList<String>methodList;
	ArrayList<String>commentList;
	
	public LoadJson(String fileName){
		//wholeJson="";
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
		//wholeJson="";
		System.out.println("preparing whole json");
		for(int i=0; i<asts.size(); i++){
			JSONObject jsonObject = jsonList.get(i);
			jsonObject.put("ast", asts.get(i));
			//wholeJson+=(jsonObject.toString()+"\n");
			
			if(i%(int)(1.0+(double)asts.size()/10.0)==0) {
				System.out.print("\r"+100*i/(double)asts.size()+" %");
			}
		}
		System.out.println("ast added to jsons.");
	}
	
	public void saveJson(String filename) {
		try {
			File fout = new File(filename);
			FileOutputStream fos = new FileOutputStream(fout);
		 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		 
			for (int i = 0; i < jsonList.size(); i++) {
				bw.write(jsonList.get(i).toString());
				bw.newLine();
			}
		 
			bw.close();
			
	        System.out.println("jsons saved.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}