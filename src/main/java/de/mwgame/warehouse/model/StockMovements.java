package de.mwgame.warehouse.model;

import de.mwgame.warehouse.model.enums.MovementType;

import java.time.LocalDateTime;

public class StockMovements
{
    private Long id;
    private Long productId;
    private MovementType type;
    private int quantity;
    private String reference;
    private LocalDateTime createdAt;
}
