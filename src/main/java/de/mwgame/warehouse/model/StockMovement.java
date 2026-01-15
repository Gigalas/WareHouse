package de.mwgame.warehouse.model;

import de.mwgame.warehouse.model.enums.MovementType;

import java.time.LocalDateTime;

public class StockMovement
{
    private Long id;
    private Long productId;
    private MovementType type;
    private Integer quantity;
    private String reference;
    private LocalDateTime createdAt;

    public StockMovement(Long id, Long productId, MovementType type, Integer quantity, String reference, LocalDateTime createdAt)
    {
        this.id = id;
        this.productId = productId;
        this.type = type;
        this.quantity = quantity;
        this.reference = reference;
        this.createdAt = createdAt;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getProductId(){
        return productId;
    }

    public void setProductId(Long productId){
        this.productId = productId;
    }

    public MovementType getMovementType(){
        return type;
    }

    public void setMovementType(MovementType type){
        this.type = type;
    }

    public Integer getQuantity(){
        return quantity;
    }

    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }

    public String getReference(){
        return reference;
    }

    public void setReference(String reference){
        this.reference = reference;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }
}
