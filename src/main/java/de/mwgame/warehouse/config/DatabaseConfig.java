package de.mwgame.warehouse.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig
{
    private static DatabaseConfig instance;
    private Properties properties;

    private DatabaseConfig() {
        properties = new Properties();
        try (InputStream input = getClass()
                .getClassLoader()
                .getResourceAsStream("database.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find database.properties");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load database configuration", e);
        }
    }

    public static DatabaseConfig getInstance() {
        if (instance == null) {
            synchronized (DatabaseConfig.class) {
                if (instance == null) {
                    instance = new DatabaseConfig();
                }
            }
        }
        return instance;
    }

    public String getUrl() {
        return properties.getProperty("db.url");
    }

    public String getUsername() {
        return properties.getProperty("db.username");
    }

    public String getPassword() {
        return properties.getProperty("db.password");
    }

    public String getDriver() {
        return properties.getProperty("db.driver", "com.mysql.cj.jdbc.Driver");
    }

    public int getMaxPoolSize() {
        return Integer.parseInt(properties.getProperty("db.pool.max", "10"));
    }

    public int getMinPoolSize() {
        return Integer.parseInt(properties.getProperty("db.pool.min", "2"));
    }
}
