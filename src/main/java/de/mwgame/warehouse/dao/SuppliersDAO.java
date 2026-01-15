package de.mwgame.warehouse.dao;

import de.mwgame.warehouse.model.Supplier;
import de.mwgame.warehouse.util.db.DataBaseFactory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SuppliersDAO
{
    private static final String SELECT_SUPPLIERS_SQL_QUERY = "SELECT * FROM suppliers ORDER BY name";

    private static final SuppliersDAO INSTANCE = new SuppliersDAO();

    public static SuppliersDAO getInstance() {
        return INSTANCE;
    }

    public List<Supplier> findAll() {
        List<Supplier> suppliers = new ArrayList<>();

        Connection conn = null;
        try {
            conn = DataBaseFactory.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_SUPPLIERS_SQL_QUERY);

            while (rs.next()) {

                suppliers.add(mapResultSetToSupplier(rs));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                DataBaseFactory.getInstance().releaseConnection(conn);
            }
        }

        return suppliers;
    }

    private Supplier mapResultSetToSupplier(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        String email = rs.getString("email");
        String phone = rs.getString("phone");

        Timestamp timestamp = rs.getTimestamp("created_at");
        LocalDateTime createdAt = timestamp != null ? timestamp.toLocalDateTime() : null;

        return new Supplier(id, name, email, phone, createdAt);
    }
}
