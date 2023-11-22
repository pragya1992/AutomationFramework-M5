package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	public static void main(String[]arg) throws IOException {
		
		
	//1.Open the document in jave readable formate, outputstream for writable 	
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommaData.properties");
		
		
	//2.for applying property logoc need to creat obj prop class from java .util	
		Properties p=new Properties();
		
		
	//3.load the input stream in to prop	
		p.load(fis);
		
	//4.provide the keys to read the value	
		String value=p.getProperty("browser");
		System.out.println(value);
	}

}
