package com.menna.Library.utils;
import java.util.Scanner;

public class LibraryItemValidator {

 

    public static String readTitle(String prompt, Scanner scanner) {
        String title;
        do {
            System.out.print(prompt);
            title = scanner.nextLine().trim();
            if (title.isEmpty()) ConsoleUI.error("Title cannot be empty. Try again.");
        } while (title.isEmpty());
        return title;
    }


    public static int readStock(String prompt, Scanner scanner) {
        int stock=-1;
        boolean valid;
        do {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                stock = scanner.nextInt();
                scanner.nextLine();
                valid = stock >= 0;
            } else {
                scanner.next();
                valid = false;
            }
            if (!valid) ConsoleUI.error("Stock must be a non-negative integer.");
        } while (!valid);
        return stock;
    }
}
