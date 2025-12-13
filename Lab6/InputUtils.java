import java.util.Scanner;

public class InputUtils {

    private static Scanner sc = new Scanner(System.in);

    public static int readMenuChoice(int min, int max) {
        int choice = -1;
        boolean valid = false;
        while (!valid) {
            String input = sc.nextLine().trim();
            try {
                choice = Integer.parseInt(input);
                if (choice >= min && choice <= max) valid = true;
                else System.out.print("Invalid input. Enter a number (" + min + "-" + max + "): ");
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number (" + min + "-" + max + "): ");
            }
        }
        return choice;
    }

    public static char readLetter(String prompt) {
        char letter = ' ';
        boolean valid = false;
        while (!valid) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (!input.isEmpty() && Character.isLetter(input.charAt(0))) {
                letter = Character.toUpperCase(input.charAt(0));
                valid = true;
            } else {
                System.out.println("Invalid letter. Enter A-Z.");
            }
        }
        return letter;
    }

    public static String readWord(String prompt) {
        String word = "";
        boolean valid = false;
        while (!valid) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (!input.isEmpty() && Character.isLetter(input.charAt(0))) {
                word = input;
                valid = true;
            } else {
                System.out.println("Invalid input. Must start with a letter and not empty.");
            }
        }
        return word;
    }
}
