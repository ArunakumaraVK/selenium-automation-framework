package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import constants.FrameworkConstants;
import exceptions.FrameworkException;

public final class ConfigReader {

    private static final Properties properties = new Properties();

    private ConfigReader() {
    }

    static {
        try (FileInputStream file =
                     new FileInputStream(FrameworkConstants.CONFIG_FILE_PATH)) {

            properties.load(file);

        } catch (IOException e) {
            throw new FrameworkException(
                    "Unable to load config.properties file", e);
        }
    }

    public static String getProperty(String key) {

        String value = properties.getProperty(key);

        if (value == null || value.isBlank()) {
            throw new FrameworkException(
                    "Property not found in config file: " + key);
        }

        return value.trim();
    }
}