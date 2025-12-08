import java.util.Scanner;
import java.util.function.Function;

public class QuadraticSolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = getValidDouble(scanner, false, "Enter coefficient a (not 0): ");
        double b = getValidDouble(scanner, true, "Enter coefficient b: ");
        double c = getValidDouble(scanner, true, "Enter coefficient c: ");

        Function<double[], Double> discriminant = coeffs -> {
            double A = coeffs[0], B = coeffs[1], C = coeffs[2];
            return B * B - 4 * A * C;
        };

        double D = discriminant.apply(new double[]{a, b, c});

        if (D > 0) {
            double x1 = (-b + Math.sqrt(D)) / (2 * a);
            double x2 = (-b - Math.sqrt(D)) / (2 * a);
            System.out.println("Two real roots: x1 = " + x1 + ", x2 = " + x2);
        } else if (D == 0) {
            double x = -b / (2 * a);
            System.out.println("One real root: x = " + x);
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(-D) / (2 * a);
            System.out.println("Two complex roots: " 
                    + realPart + " + " + imaginaryPart + "i, " 
                    + realPart + " - " + imaginaryPart + "i");
        }

        scanner.close();
    }
    
    
    
    
    private static double getValidDouble(Scanner scanner, boolean allowZero, String message) {
        double num;
        boolean valid;

        do {
            valid = true;
            System.out.print(message);
            String input = scanner.nextLine();

            try {
                num = Double.parseDouble(input);

                if (!allowZero && num == 0) {
                    System.out.println("Coefficient 'a' cannot be 0. Try again.");
                    valid = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
                valid = false;
                num = 0;
            }
        } while (!valid);

        return num;
    }
}

