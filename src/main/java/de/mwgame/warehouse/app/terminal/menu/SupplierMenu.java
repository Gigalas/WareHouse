package de.mwgame.warehouse.app.terminal.menu;

import java.util.Scanner;

import static de.mwgame.warehouse.util.console.ConsoleUtils.*;
import static de.mwgame.warehouse.util.console.ConsoleUtils.printOption;
import static de.mwgame.warehouse.util.console.ConsoleUtils.readInt;

public class SupplierMenu
{
    public static void show(Scanner scanner) {
        clearConsole();
        printHeading("Lieferantmenü");

        printOption(1, "Lieferant anlegen");
        printOption(2, "Lieferant bearbeiten");
        printOption(3, "Lieferant deaktivieren");
        printOption(4, "Lieferanten anzeigen");
        printOption(0, "Zurück");

        int choice = readInt("-> ", 4, scanner);

        switch (choice)
        {
            //case 1 -> ProductMenu.show(scanner);
            //case 2 -> KategorieMenu.show(scanner);
            //case 3 -> LieferantenMenu.show(scanner);
            //case 4 -> LagerbewegungMenu.show(scanner);
            //case 5 -> LagerbewegungMenu.show(scanner);
            case 0 -> {return;}
        }
    }
}
