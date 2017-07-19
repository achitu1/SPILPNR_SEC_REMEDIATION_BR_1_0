package com.delta.common;


import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.log4j.Logger;


/**
* Simple wrapper around apache commons configurator
* 
 * @author Tim Riley
*
*/
public class SPILPropertyManager
{
      private static final Logger logger = Logger.getLogger(SPILPropertyManager.class);
    private static final CompositeConfiguration CFG = new CompositeConfiguration();
    
    static {
      SPILPropertyManager.init();
    }
    
    public static String getProperty(String property) {
        return CFG.getString(property);
    }
    
    public static void init(String[] configFiles) {
        for (String configFile : configFiles) {
            try {
                  PropertiesConfiguration config = new PropertiesConfiguration(configFile);
                CFG.addConfiguration(config);
                config.setReloadingStrategy(new FileChangedReloadingStrategy());
            } 
            catch (ConfigurationException e) {
                logger.error("Failed to load properties file: " + configFile, e);
            }
        }
    }
    
    public static void init() {
      String defaultConfigFile = System.getProperty("SPIL.configuration");
      init(new String[] {defaultConfigFile});
    }
    
    public static void loadFreshData() {
      SPILPropertyManager.init();
    }
}
