package de.mwgame.warehouse.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Calendar;

public class Products
{
    private Long id;
    private String sku;
    private Long categoryId;
    private Long supplierId;
    private BigDecimal price;
    private int quantity;
    private int minQuantity;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
