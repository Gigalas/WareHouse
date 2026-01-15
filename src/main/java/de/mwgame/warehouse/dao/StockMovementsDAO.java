package de.mwgame.warehouse.dao;

import de.mwgame.warehouse.model.StockMovement;
import de.mwgame.warehouse.model.enums.MovementType;
import de.mwgame.warehouse.util.db.DataBaseFactory;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class StockMovementsDAO
{
    private static final String SELECT_STOCK_MOVEMENTS_SQL_QUERY = "SELECT * FROM stock_movements ORDER BY product_id";

    private static final StockMovementsDAO INSTANCE = new StockMovementsDAO();

    public static StockMovementsDAO getInstance() {
        return INSTANCE;
    }

    public List<StockMovement> findAll() {
        List<StockMovement> stockMovements = new ArrayList<>();

        Connection conn = null;
        try {
            conn = DataBaseFactory.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_STOCK_MOVEMENTS_SQL_QUERY);

            while (rs.next()) {

                stockMovements.add(mapResultSetToStockMovement(rs));
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

        return stockMovements;
    }

    private StockMovement mapResultSetToStockMovement(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        Long productId = rs.getLong("product_id");
        MovementType type = MovementType.valueOf(rs.getString("type"));
        Integer quantity = rs.getInt("quantity");
        String reference = rs.getString("reference");

        Timestamp timestamp = rs.getTimestamp("created_at");
        LocalDateTime createdAt = timestamp != null ? timestamp.toLocalDateTime() : null;

        return new StockMovement(id, productId, type, quantity, reference, createdAt);
    }
}
