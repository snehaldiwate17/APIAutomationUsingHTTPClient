package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class TestBase {

	public Properties prop;
	
	//public static void main(String[] args) throws IOException {
	public TestBase() {
		try {
			prop = new Properties();
			//String currentDir = System.getProperty("user.dir");
			//String dir = currentDir+"\\src\\main\\java\\com\\qa\\config";
			//FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties");
			//System.out.println(currentDir);
			//System.out.println(dir);
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(ip);
			System.out.println("Property file loaded successfully");
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
