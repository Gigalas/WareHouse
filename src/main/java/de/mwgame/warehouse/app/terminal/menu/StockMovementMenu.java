package de.mwgame.warehouse.app.terminal.menu;

import java.util.Scanner;

import static de.mwgame.warehouse.util.console.ConsoleUtils.*;
import static de.mwgame.warehouse.util.console.ConsoleUtils.printOption;
import static de.mwgame.warehouse.util.console.ConsoleUtils.readInt;

public class StockMovementMenu {
    public static void show(Scanner scanner) {
        clearConsole();
        printHeading("Lagerbewegungmenü");

        printOption(1, "Wareneingang buchen");
        printOption(2, "Warenausgang buchen");
        printOption(3, "Lagerbestand anzeigen");
        printOption(0, "Zurück");

        int choice = readInt("-> ", 3, scanner);

        switch (choice)
        {
            //case 1 -> ProductMenu.show(scanner);
            //case 2 -> KategorieMenu.show(scanner);
            //case 3 -> LieferantenMenu.show(scanner);
            case 0 -> {return;}
        }
    }
}
