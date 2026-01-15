package de.mwgame.warehouse.util.db;

import de.mwgame.warehouse.config.DatabaseConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseFactory
{
    private static DataBaseFactory instance;
    private List<Connection> connectionPool;
    private List<Connection> usedConnections = new ArrayList<>();
    private final int MAX_POOL_SIZE;

    private DataBaseFactory() {
        MAX_POOL_SIZE = DatabaseConfig.getInstance().getMaxPoolSize();
        connectionPool = new ArrayList<>(MAX_POOL_SIZE);

        try {
            Class.forName(DatabaseConfig.getInstance().getDriver());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL Driver not found", e);
        }
    }

    /**
     * Получить экземпляр фабрики (Singleton)
     *
     * Get an instance of the factory (Singleton)
     */
    public static DataBaseFactory getInstance() {
        if (instance == null) {
            synchronized (DataBaseFactory.class) {
                if (instance == null) {
                    instance = new DataBaseFactory();
                }
            }
        }
        return instance;
    }

    /**
     * Получить соединение из пула
     * ВАЖНО: После использования вызвать releaseConnection(conn)
     *
     * Get a connection from the pool
     * IMPORTANT: After use, call releaseConnection(conn)
     */
    public synchronized Connection getConnection() throws SQLException {
        if (connectionPool.isEmpty()) {
            if (usedConnections.size() < MAX_POOL_SIZE) {
                connectionPool.add(createConnection());
            } else {
                throw new SQLException("Maximum pool size reached, no available connections!");
            }
        }

        Connection connection = connectionPool.remove(connectionPool.size() - 1);

        if (!connection.isValid(2)) {
            connection = createConnection();
        }

        usedConnections.add(connection);
        return connection;
    }

    /**
     * Вернуть соединение обратно в пул
     * ОБЯЗАТЕЛЬНО вызывать после использования!
     *
     * Return the connection back to the pool
     * MUST be called after use!
     */
    public synchronized void releaseConnection(Connection connection) {
        if (connection != null) {
            usedConnections.remove(connection);
            connectionPool.add(connection);
        }
    }

    /**
     * Создать новое соединение
     *
     * Create a new connection
     */
    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(
                DatabaseConfig.getInstance().getUrl(),
                DatabaseConfig.getInstance().getUsername(),
                DatabaseConfig.getInstance().getPassword()
        );
    }

    /**
     * Закрыть все соединения (вызывать при завершении приложения)
     *
     * Close all connections (call when the application is shutting down)
     */
    public synchronized void shutdown() {
        for (Connection conn : usedConnections) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        usedConnections.clear();

        for (Connection conn : connectionPool) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        connectionPool.clear();

        System.out.println("✓ Database connection pool closed");
    }

    /**
     * Получить информацию о состоянии пула
     *
     * Get information about the pool status
     */
    public void printPoolStats() {
        System.out.println("=== Connection Pool Stats ===");
        System.out.println("Available connections: " + connectionPool.size());
        System.out.println("Used connections: " + usedConnections.size());
        System.out.println("Max pool size: " + MAX_POOL_SIZE);
    }
}
