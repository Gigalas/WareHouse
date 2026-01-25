package de.mwgame.warehouse.app.terminal.menu;

import java.util.Scanner;

import static de.mwgame.warehouse.util.console.ConsoleUtils.*;
import static de.mwgame.warehouse.util.console.ConsoleUtils.printOption;
import static de.mwgame.warehouse.util.console.ConsoleUtils.readInt;

public class ProductMenu
{
    public static void show(Scanner scanner) {
        clearConsole();
        printHeading("Produktmenü");

        printOption(1, "Produkt anlegen");
        printOption(2, "Produkt bearbeiten");
        printOption(3, "Produkt deaktivieren");
        printOption(4, "Alle Produkte anzeigen");
        printOption(0, "Zurück");

        int choice = readInt("-> ", 4, scanner);

        switch (choice)
        {
            //case 1 -> ProductMenu.show(scanner);
            //case 2 -> KategorieMenu.show(scanner);
            //case 3 -> LieferantenMenu.show(scanner);
            //case 4 -> LagerbewegungMenu.show(scanner);
            case 0 -> {return;}
        }
    }
}
