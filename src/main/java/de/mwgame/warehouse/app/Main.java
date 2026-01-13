package de.mwgame.warehouse.app;

import de.mwgame.warehouse.dao.CategoriesDAO;
import de.mwgame.warehouse.model.Categories;

import java.sql.*;
import java.util.List;

public class Main {
    static void main(String[] args) {

        // 1. Получить все категории
        List<Categories> allCategories = CategoriesDAO.getInstance().findAll();
        System.out.println("Всего категорий: " + allCategories.size());
        for (Categories cat : allCategories) {
            System.out.println(cat.getId() + " - " + cat.getName());
        }
    }
}
