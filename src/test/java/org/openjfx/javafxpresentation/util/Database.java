package org.openjfx.javafxpresentation.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * The type Database.
 */
public class Database {

    private static final Logger logger = LogManager.getLogger(Database.class);

    private static Database instance = new Database();

    private Properties properties;
    private Connection connection;

    /**
     * Instantiates a new Database.
     */
    public Database() {
        init();
    }

    private void init() {
        try {
            properties = PropertiesLoader.load("/database.properties");
        } catch (Exception e) {
            logger.error("Failed to load database properties", e);
        }
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static Database getInstance() {
        return instance;
    }

    /**
     * Gets connection.
     *
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Connect.
     *
     * @throws Exception the exception
     */
    public void connect() throws Exception {
        if (connection != null)
            return;

        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            throw new Exception("Database.connect()... Error: JDBC Driver not found");
        }

        String url = properties.getProperty("url");
        connection = DriverManager.getConnection(
                url,
                properties.getProperty("username"),
                properties.getProperty("password")
        );
    }

    /**
     * Disconnect.
     */
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("Failed to disconnect from database", e);
            }
        }

        connection = null;
    }

    /**
     * Run sql.
     *
     * @param sqlFile the sql file
     */
    public void runSQL(String sqlFile) {
        Statement stmt = null;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(classloader.getResourceAsStream(sqlFile)))) {

            connect();
            stmt = connection.createStatement();

            StringBuilder sql = new StringBuilder();
            int ch;

            while ((ch = br.read()) != -1) {
                if ((char) ch == ';') {
                    stmt.executeUpdate(sql.toString());
                    sql.setLength(0); // Clear the buffer
                } else {
                    sql.append((char) ch);
                }
            }

        } catch (SQLException se) {
            logger.error("SQL error while executing " + sqlFile, se);
        } catch (Exception e) {
            logger.error("Failed to run SQL script: " + sqlFile, e);
        } finally {
            disconnect();
        }
    }
}