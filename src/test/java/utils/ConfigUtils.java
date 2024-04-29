package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigUtils {
    private static final Properties configProperties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("config.properties");
            configProperties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getBaseUrl() {
        return configProperties.getProperty("base_url");
    }

    public static String getProperties(String keyName) {
        return configProperties.getProperty(keyName);
    }
}
