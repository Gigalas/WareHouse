package de.mwgame.warehouse.app;

import de.mwgame.warehouse.dao.CategoriesDAO;
import de.mwgame.warehouse.dao.ProductsDAO;
import de.mwgame.warehouse.dao.StockMovementsDAO;
import de.mwgame.warehouse.dao.SuppliersDAO;
import de.mwgame.warehouse.dto.CreateProductDto;
import de.mwgame.warehouse.model.Categorie;
import de.mwgame.warehouse.model.Product;
import de.mwgame.warehouse.model.StockMovement;
import de.mwgame.warehouse.model.Supplier;
import de.mwgame.warehouse.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    static void main(String[] args)
    {
        System.out.println("-------------TEST-BASE-DATE--------------");
        System.out.println("-----------------------------------------");

        List<Categorie> allCategories = CategoriesDAO.getInstance().findAll();
        System.out.println("Всего категорий: " + allCategories.size());
        for (Categorie cat : allCategories) {
            System.out.println(cat.getId() + " - " + cat.getName());
        }

        System.out.println("-----------------------------------------");

        List<Product> allProducts = ProductsDAO.getInstance().findAll();
        System.out.println("Всего продуктов: " + allProducts.size());
        for (Product cat : allProducts) {
            System.out.println(cat.getId() + " - " + cat.getSku() + " - " + cat.getActive());
        }

        System.out.println("-----------------------------------------");

        List<StockMovement> stockMovements = StockMovementsDAO.getInstance().findAll();
        System.out.println("Все перемещения по складу: " + stockMovements.size());
        for (StockMovement cat : stockMovements) {
            System.out.println(cat.getProductId() + " - " + cat.getMovementType() + " - " + cat.getQuantity());
        }

        System.out.println("-----------------------------------------");

        List<Supplier> suppliers = SuppliersDAO.getInstance().findAll();
        System.out.println("Все компании поставщиков: " + suppliers.size());
        for (Supplier cat : suppliers) {
            System.out.println(cat.getName() + " - " + cat.getEmail() + " - " + cat.getCreatedAt());
        }


        CreateProductDto dto = new CreateProductDto(
                "SSD-1TB king",
                "SSD Drive 1TB",
                1L,
                1L,
                new BigDecimal("99.99"),
                5
        );

        Product product = ProductService.createProduct(dto);
        System.out.println("Product created: " + product.getSku());
    }
}
