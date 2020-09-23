package com.testingshatra.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {
	public static void main(String[] args) {
		getProperty();
		
	}
	private static String getProperty() {
		String value=null;
		String dir=System.getProperty("user.dir");
		System.out.println(dir);
		
		try {
			//FileInputStream file=new FileInputStream(path+"//Image/[@src='https://ijmeet.com/images/LOGO-F@2x.png']");
			FileInputStream fis=new FileInputStream(dir+"src/test/resources/ObjectRepostory.properties");
			Properties prop=new Properties();
			prop.load(fis);
			value=prop.getProperty("logoImage");
			return value;
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
			
		}

	}

}
