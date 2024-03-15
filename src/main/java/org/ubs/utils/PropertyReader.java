package org.ubs.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    private static Properties properties = null;

    /**
     * Load the properties from config file
     */
    private static void loadProperties() {
        properties = new Properties();
        InputStream input;
        try {
            input = PropertyReader.class.getResourceAsStream("/config.properties");
            properties.load(input);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        if (properties == null)
            loadProperties();

        String p = System.getProperty(key);
        return p != null ? p : properties.getProperty(key);
    }
}
