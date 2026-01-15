package de.mwgame.warehouse.model;

import de.mwgame.warehouse.model.enums.ProductStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Product
{
    private Long id;
    private String sku;
    private String name;
    private Long categoryId;
    private Long supplierId;
    private BigDecimal price;
    private Integer quantity;
    private Integer minQuantity;
    private ProductStatus active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Product(Long id, String sku, String name, Long categoryId, Long supplierId, BigDecimal price, Integer quantity, Integer minQuantity, ProductStatus active, LocalDateTime createdAt, LocalDateTime updatedAt)
    {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
        this.price = price;
        this.quantity = quantity;
        this.minQuantity = minQuantity;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Product(String sku, String name, Long categoryId, Long supplierId, BigDecimal price, Integer minQuantity)
    {
        this.id = null;
        this.sku = sku;
        this.name = name;
        this.categoryId = categoryId;
        this.supplierId = supplierId;
        this.price = price;
        this.quantity = 0;
        this.minQuantity = minQuantity;
        this.active = ProductStatus.ACTIVE;
        this.createdAt = null;
        this.updatedAt = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(Integer minQuantity) {
        this.minQuantity = minQuantity;
    }

    public ProductStatus getActive() {
        return active;
    }

    public void setActive(ProductStatus active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
