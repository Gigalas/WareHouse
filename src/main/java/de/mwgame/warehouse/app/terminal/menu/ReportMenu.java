package de.mwgame.warehouse.app.terminal.menu;

import java.util.Scanner;

import static de.mwgame.warehouse.util.console.ConsoleUtils.*;
import static de.mwgame.warehouse.util.console.ConsoleUtils.printOption;
import static de.mwgame.warehouse.util.console.ConsoleUtils.readInt;

public class ReportMenu {
    public static void show(Scanner scanner) {
        clearConsole();
        printHeading("Berichtmenü");

        printOption(1, "Produkte mit niedrigem Bestand");
        printOption(2, "Lagerbewegung-Historie");
        printOption(3, "Gesamtwert des Lagers");
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
