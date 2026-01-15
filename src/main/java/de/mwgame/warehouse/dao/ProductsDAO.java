package de.mwgame.warehouse.dao;

import de.mwgame.warehouse.model.Product;
import de.mwgame.warehouse.model.enums.ProductStatus;
import de.mwgame.warehouse.util.db.DataBaseFactory;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProductsDAO
{
    private static final String SELECT_PRODUCTS_SQL_QUERY = "SELECT * FROM products ORDER BY sku";
    private static final String SELECT_PRODUCTS_EXISTS_BY_SKU = "SELECT * FROM products WHERE sku = ?";
    private static final String INSERT_PRODUCTS = "INSERT INTO products (sku, name, category_id, supplier_id, price, quantity, min_quantity, active) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final ProductsDAO INSTANCE = new ProductsDAO();

    public static ProductsDAO getInstance() {
        return INSTANCE;
    }

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();

        Connection conn = null;
        try {
            conn = DataBaseFactory.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_PRODUCTS_SQL_QUERY);

            while (rs.next()) {

                products.add(mapResultSetToProduct(rs));
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

        return products;
    }

    public boolean existsBySku(String sku) {
        Connection conn = null;
        try {
            conn = DataBaseFactory.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(SELECT_PRODUCTS_EXISTS_BY_SKU)) {
                ps.setString(1, sku);

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

    public void save(Product product) {
        Connection conn = null;
        try {
            conn = DataBaseFactory.getInstance().getConnection();

            try (PreparedStatement ps = conn.prepareStatement(INSERT_PRODUCTS)) {
                ps.setString(1, product.getSku());
                ps.setString(2, product.getName());
                ps.setObject(3, product.getCategoryId());
                ps.setObject(4, product.getSupplierId());
                ps.setBigDecimal(5, product.getPrice());
                ps.setInt(6, product.getQuantity());
                ps.setInt(7, product.getMinQuantity());
                ps.setString(8, product.getActive().name());
                ps.executeUpdate();

                /*try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        product.setId(rs.getLong(1));
                    }
                }*/
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                DataBaseFactory.getInstance().releaseConnection(conn);
            }
        }
    }

    private Product mapResultSetToProduct(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String sku = rs.getString("sku");
        String name = rs.getString("name");
        Long categoryId = rs.getLong("category_id");
        Long supplierId = rs.getLong("supplier_id");
        BigDecimal price = rs.getBigDecimal("price");
        Integer quantity = rs.getInt("quantity");
        Integer minQuantity = rs.getInt("min_quantity");

        String activeStr = rs.getString("active");
        ProductStatus active = ProductStatus.valueOf(activeStr);

        Timestamp created = rs.getTimestamp("created_at");
        LocalDateTime createdAt = created != null ? created.toLocalDateTime() : null;

        Timestamp timestamp = rs.getTimestamp("updated_at");
        LocalDateTime updateAt = timestamp != null ? timestamp.toLocalDateTime() : null;

        return new Product(id, sku, name, categoryId, supplierId, price, quantity, minQuantity, active, createdAt, updateAt);
    }
}
