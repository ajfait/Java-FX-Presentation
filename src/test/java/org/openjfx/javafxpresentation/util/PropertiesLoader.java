package org.openjfx.javafxpresentation.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

/**
 * The type Properties loader.
 */
public final class PropertiesLoader {

    private static final Logger logger = LogManager.getLogger(PropertiesLoader.class);

    private PropertiesLoader() {
    }

    /**
     * Load properties.
     *
     * @param filePath the file path
     * @return the properties
     */
    public static Properties load(String filePath) {
        Properties properties = new Properties();

        try (InputStream input = PropertiesLoader.class.getResourceAsStream(filePath)) {
            if (input != null) {
                properties.load(input);
            } else {
                logger.warn("Properties file not found: " + filePath);
            }
        } catch (Exception e) {
            logger.error("Failed to load properties file: " + filePath, e);
        }

        return properties;
    }
}