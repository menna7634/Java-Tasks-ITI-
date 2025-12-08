package com.menna.university.utils;

import java.util.Scanner;

public class InputUtils {

    public static int readInt(Scanner scanner, int min, int max, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value < min || value > max) {
                    System.out.println("Value must be between " + min + " and " + max);
                } else return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }
    }

    public static double readDouble(Scanner scanner, double min, double max, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value < min || value > max) {
                    System.out.println("Value must be between " + min + " and " + max);
                } else return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }
    }
}
