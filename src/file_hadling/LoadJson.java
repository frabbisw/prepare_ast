package file_hadling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.*;

public class LoadJson {
	String fileName;
	ArrayList<String>jsonList;
	ArrayList<String>methodList;
	ArrayList<String>commentList;
	public LoadJson(String fileName){
		this.fileName=fileName;
		jsonList=new ArrayList<String>();
		methodList=new ArrayList<String>();
		commentList=new ArrayList<String>();
				
		try (BufferedReader br = new BufferedReader(new FileReader(new File(fileName)))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	JSONObject jObject = new JSONObject(line);
		    	
		    	methodList.add(jObject.get("code").toString());
		    	commentList.add(jObject.get("nl").toString());
		    	jsonList.add(line);
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<String>getJsons(){
		return jsonList;
	}
	public ArrayList<String>getMethods(){
		return methodList;
	}
	public ArrayList<String>getComments(){
		return commentList;
	}
}