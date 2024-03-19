/**
 * This class provides utilities for reading values from properties files.
 */
package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



public class file_prop_utlities{
	 /**
     * Retrieves the value associated with the specified key from the properties file.
     * 
     * @param key The key whose associated value is to be retrieved.
     * @param path The path to the properties file.
     * @return The value associated with the specified key.
     * @throws IOException If an I/O error occurs while reading the properties file.
     */
	public String getValue(String key, String path) throws IOException { 
		
		Properties propfile = new Properties();
		propfile.load(new FileReader(path));
		
		return propfile.getProperty(key);
	}
	
	/**
     * Retrieves all key-value pairs from the properties file.
     * 
     * @param path The path to the properties file.
     * @return A Properties object containing all key-value pairs from the properties file.
     * @throws IOException If an I/O error occurs while reading the properties file.
     */
	public Properties getData(String path) throws IOException { 
		
		Properties propfile = new Properties();
		propfile.load(new FileReader(path));
		
		return propfile;
	}

	
	
}
