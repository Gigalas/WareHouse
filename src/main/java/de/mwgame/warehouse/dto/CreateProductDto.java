package de.mwgame.warehouse.dto;

import java.math.BigDecimal;

public record CreateProductDto(
        String sku,
        String name,
        Long categoryId,
        Long supplierId,
        BigDecimal price,
        Integer minQuantity
) {}

