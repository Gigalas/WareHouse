package de.mwgame.warehouse.dto;

import de.mwgame.warehouse.model.enums.ProductStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record UpdateProductDto(
        Long id,
        Long categoryId,
        Long supplierId,
        BigDecimal price,
        Integer quantity,
        Integer minQuantity,
        ProductStatus active,
        LocalDateTime updatedAt
) {}
