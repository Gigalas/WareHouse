package de.mwgame.warehouse.dao;

import de.mwgame.warehouse.model.Categories;
import de.mwgame.warehouse.util.db.DataBaseFactory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAO
{
    private static final CategoriesDAO INSTANCE = new CategoriesDAO();

    public static CategoriesDAO getInstance() {
        return INSTANCE;
    }

    public List<Categories> findAll() {
        List<Categories> categories = new ArrayList<>();
        String sql = "SELECT * FROM categories ORDER BY name";

        Connection conn = null;
        try {
            conn = DataBaseFactory.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                categories.add(mapResultSetToCategory(rs));
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

        return categories;
    }

    private Categories mapResultSetToCategory(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        String description = rs.getString("description");

        Timestamp timestamp = rs.getTimestamp("created_at");
        LocalDateTime createdAt = timestamp != null ? timestamp.toLocalDateTime() : null;

        return new Categories(id, name, description, createdAt);
    }
}
