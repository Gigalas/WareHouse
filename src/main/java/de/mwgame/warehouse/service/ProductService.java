package de.mwgame.warehouse.service;

import de.mwgame.warehouse.dao.CategoriesDAO;
import de.mwgame.warehouse.dao.ProductsDAO;
import de.mwgame.warehouse.dto.CreateProductDto;
import de.mwgame.warehouse.dto.UpdateProductDto;
import de.mwgame.warehouse.exception.BusinessException;
import de.mwgame.warehouse.exception.ValidationException;
import de.mwgame.warehouse.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductService
{
    public static Product createProduct(CreateProductDto dto)
    {
        if (dto.sku() == null || dto.sku().isBlank()) {
            throw new ValidationException("SKU is required");
        }

        if (dto.price() == null || dto.price().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("Price must be greater than 0");
        }

        if (ProductsDAO.getInstance().existsBySku(dto.sku())) {
            throw new BusinessException("Product with SKU already exists");
        }

        if (!CategoriesDAO.getInstance().existsById(dto.categoryId())) {
            throw new BusinessException("Category does not exist");
        }

        Product product = new Product(
                dto.sku(),
                dto.name(),
                dto.categoryId(),
                dto.supplierId(),
                dto.price(),
                dto.minQuantity() != null ? dto.minQuantity() : 0
        );

        ProductsDAO.getInstance().save(product);

        return product;
    }

    public void updateProduct(UpdateProductDto dto) {  }

    public void deactivateProduct(long productId) { }

    //public List<Product> getLowStockProducts() {  }

    //public Product getById(long id) {  }

}
