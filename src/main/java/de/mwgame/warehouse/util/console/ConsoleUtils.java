package de.mwgame.warehouse.util.console;

import java.util.Scanner;

public class ConsoleUtils
{
    public static int readInt(String prompt, int userChoices, Scanner scanner)
    {
        int input;
        do{
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scanner.next());
                if (input < 0 || input > userChoices){
                    System.out.println("Bitte geben Sie eine richtige Zahl ein!");
                }
            }catch(Exception e){
                input = -1;
                System.out.println("Bitte geben Sie eine ganze Zahl ein!");
            }
        }while(input < 0 || input > userChoices);
        return input;
    }

    public static void clearConsole()
    {
        for(int i = 0; i < 100; i++)
            System.out.println();
    }

    public static void printSeparator(int n)
    {
        for(int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    public static void printHeading(String title)
    {
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    public static void printOption(int number, String text)
    {
        System.out.printf("(%d) %s%n", number, text);
    }

    public static void anythingToContinue(Scanner scanner)
    {
        System.out.println("\nBitte geben Sie etwas ein, um fortzufahren...");
        scanner.next();
    }
}
