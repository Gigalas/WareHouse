package de.mwgame.warehouse.dao;

import de.mwgame.warehouse.model.Categorie;
import de.mwgame.warehouse.util.db.DataBaseFactory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDAO
{
    private static final String SELECT_CATEGORIES_SQL_QUERY = "SELECT * FROM categories ORDER BY name";
    private static final String SELECT_CATEGORIES_EXISTS_BY_ID = "SELECT * FROM categories WHERE id = ?";

    private static final CategoriesDAO INSTANCE = new CategoriesDAO();

    public static CategoriesDAO getInstance() {
        return INSTANCE;
    }

    public List<Categorie> findAll() {
        List<Categorie> categories = new ArrayList<>();

        Connection conn = null;
        try {
            conn = DataBaseFactory.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_CATEGORIES_SQL_QUERY);

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

    public boolean existsById(long categoryId){
        Connection conn = null;
        try {
            conn = DataBaseFactory.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SELECT_CATEGORIES_EXISTS_BY_ID)) {
                ps.setLong(1, categoryId);

                try (ResultSet rs = ps.executeQuery()) {
                    return rs.next();
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to check SKU existence", e);
        } finally {
            if (conn != null) {
                DataBaseFactory.getInstance().releaseConnection(conn);
            }
        }
    }

    private Categorie mapResultSetToCategory(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        String description = rs.getString("description");

        Timestamp timestamp = rs.getTimestamp("created_at");
        LocalDateTime createdAt = timestamp != null ? timestamp.toLocalDateTime() : null;

        return new Categorie(id, name, description, createdAt);
    }
}
