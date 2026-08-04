package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    public ConfigReader() {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file", e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getBrowser() {
        return properties.getProperty("browser");
    }

    public String getBaseUrl() {
        return properties.getProperty("baseUrl");
    }

    public long getImplicitWait() {
        return Long.parseLong(properties.getProperty("implicitWait"));
    }

    public long getExplicitWait() {
        return Long.parseLong(properties.getProperty("explicitWait"));
    }

    public long getPageLoadTimeout() {
        return Long.parseLong(properties.getProperty("pageLoadTimeout"));
    }
}
