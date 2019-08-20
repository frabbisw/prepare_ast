package test;

public class Main {
	public static void main(String [] args)
	{
		FileProcessor fileProcessor = new FileProcessor("/home/iit/bin/DeepCom-master/data");
		fileProcessor.loadAndSave("tmp.json");
		fileProcessor.loadAndSave("test.json");
		fileProcessor.loadAndSave("train.json");
		fileProcessor.loadAndSave("valid.json");
	}
}