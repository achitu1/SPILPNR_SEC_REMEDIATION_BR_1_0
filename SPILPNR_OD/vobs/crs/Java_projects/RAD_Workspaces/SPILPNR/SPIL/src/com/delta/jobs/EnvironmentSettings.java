package com.delta.jobs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentSettings {
	private final static String ENV_DATA = "NWA_DATA"; 

	private EnvironmentSettings() {
	}
	
	public static String getPropertyValueFromFile(String filename,
			String property) throws IOException 
	{
		File propFile  = null;
		
		propFile = new File(getDataDirectory() + File.separator + filename);
		Properties properties = new Properties();
		
			FileInputStream propFileStream = new FileInputStream(propFile); 

			properties.load(propFileStream);
			propFileStream.close();
		
		return properties.getProperty(property);
	}
	
	public static String getDataDirectory() {
		return System.getProperty(ENV_DATA);
	}
}
