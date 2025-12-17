
package com.crm.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {

public static String path=".\\src\\test\\resources\\PropertiesFile\\Configuration.properties";
	
	public static String propertiesFile(String key) throws IOException {
		Properties prop= new Properties();
		FileInputStream instr= new FileInputStream(path);
		prop.load(instr);
		String data = prop.getProperty(key);
		return data;
	}
}
