package com.menna.Library.utils;

import java.util.Scanner;

public class ConsoleUI {

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String CYAN = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";

    public static void title(String msg) {
        System.out.println("\n" + CYAN + "===== " + msg + " =====" + RESET);
    }

    public static void success(String msg) {
        System.out.println(GREEN + "[SUCCESS] " + msg + RESET);
    }

    public static void info(String msg) {
        System.out.println(BLUE + "[INFO] " + msg + RESET);
    }

    public static void error(String msg) {
        System.out.println(RED + "[ERROR] " + msg + RESET);
    }

    public static int readInt(String prompt, Scanner scanner) {
        System.out.print(YELLOW + prompt + RESET);
        while (!scanner.hasNextInt()) {
            error("Please enter a valid number.");
            scanner.next();
            System.out.print(YELLOW + prompt + RESET);
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }
}
