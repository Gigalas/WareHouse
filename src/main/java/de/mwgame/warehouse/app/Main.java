package de.mwgame.warehouse.app;

import de.mwgame.warehouse.dao.CategoriesDAO;
import de.mwgame.warehouse.dao.ProductsDAO;
import de.mwgame.warehouse.dao.StockMovementsDAO;
import de.mwgame.warehouse.dao.SuppliersDAO;
import de.mwgame.warehouse.model.Categorie;
import de.mwgame.warehouse.model.Product;
import de.mwgame.warehouse.model.StockMovement;
import de.mwgame.warehouse.model.Supplier;

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
            System.out.println(cat.getId() + " - " + cat.getName() + " - " + cat.getActive());
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
    }
}
