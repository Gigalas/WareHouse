package de.mwgame.warehouse.app.terminal.menu;

import java.util.Scanner;

import static de.mwgame.warehouse.util.console.ConsoleUtils.*;

public class MainMenu
{
    public static void show(Scanner scanner){
        boolean running = true;
        while (running)
        {
            clearConsole();
            printHeading("Hauptmenü");

            printOption(1, "Produkte verwalten");
            printOption(2, "Kategorien verwalten");
            printOption(3, "Lieferanten verwalten");
            printOption(4, "Lagerbewegungen");
            printOption(5, "Berichte");
            printOption(0, "Beenden");

            int choice = readInt("-> ", 5, scanner);

            switch (choice)
            {
                case 1 -> ProductMenu.show(scanner);
                case 2 -> CategoryMenu.show(scanner);
                case 3 -> SupplierMenu.show(scanner);
                case 4 -> StockMovementMenu.show(scanner);
                case 5 -> ReportMenu.show(scanner);
                case 0 -> running = false;
            }
        }
    }

}
