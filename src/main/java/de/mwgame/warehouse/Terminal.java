package de.mwgame.warehouse;

import de.mwgame.warehouse.app.terminal.menu.MainMenu;

import java.util.Scanner;

import static de.mwgame.warehouse.util.console.ConsoleUtils.*;

public class Terminal
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        printHeading("Willkommen in \"WareHouse\"");
        anythingToContinue(scanner);

        MainMenu.show(scanner);
    }
}
