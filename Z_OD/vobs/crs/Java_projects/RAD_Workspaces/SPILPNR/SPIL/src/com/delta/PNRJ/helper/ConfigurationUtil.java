/**
 * 
 */
package com.delta.PNRJ.helper;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.MissingResourceException;
import java.util.Properties;

import com.nwa.PRA.environment.EnvironmentSettings;
import com.nwa.PRA.logger.Logger;

/**
 * @author f77219
 * 
 */
public class ConfigurationUtil {

	public static final String DELTA_SERVICE_FOLDER = "deltaservice";
	public static final String DELTA_SOA_SERVICE_PROPERTIES = "deltasoaservice.properties";
	public static final String SERVICE_URL = "endpoint.url";

	public static Properties getPropertiesFromFile(String fileName)
			throws Exception {

		DeltaAssert.isNotNull(fileName, "PropertyFileName can not be null");
		DataInputStream in = null;
		Properties properties = new Properties();
		try {

			File myFile = new File(fileName);
			FileInputStream fstream = new FileInputStream(myFile);
			in = new DataInputStream(fstream);
			properties.load(in);

			in.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			Logger.log(ConfigurationUtil.class, Logger.LEVEL_DEBUG, e
					.getMessage());
			throw e;
		}
		return properties;
	}

	public static Properties getPropertiesFromEnvironmentSettings() {
		Properties properties = EnvironmentSettings.getInstance()
				.getPropertiesFromFile(DELTA_SERVICE_FOLDER,
						DELTA_SOA_SERVICE_PROPERTIES);
		return properties;
	}
	
	public static Properties getPropertiesFromEnvironmentSettings(String folderName,String fileName) {
		Properties properties = EnvironmentSettings.getInstance()
				.getPropertiesFromFile(folderName,fileName);
		return properties;
	}

	public static Properties getPropertiesFromEnvironmentSettings(
			String fileName) {
		Properties properties = EnvironmentSettings.getInstance()
				.getPropertiesFromFile(DELTA_SERVICE_FOLDER,
						fileName);
		return properties;
	}
	public static String getPropertyValueFromEnvironmentSettings(
			String property) throws Exception {
		String propertyValue = null;
		DeltaAssert.isNotNull(property, "property can not be null");
		try {
			Properties properties = ConfigurationUtil
					.getPropertiesFromEnvironmentSettings();
			propertyValue = properties.getProperty(property);
			if(propertyValue == null){
				throw new MissingResourceException("Property not found in the Property file.",
						"ConfigurationUtil",DELTA_SOA_SERVICE_PROPERTIES);
			}
		} catch (MissingResourceException e) {
			System.out.println(e.getMessage());
			Logger.log(ConfigurationUtil.class, Logger.LEVEL_DEBUG,
					"Property not found in the Property file.");
			throw e;
		}
		return propertyValue;
	}

}
