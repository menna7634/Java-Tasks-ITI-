import java.util.function.Function;
import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        
        Function<Double, Double> celsiusToFahrenheit = new Function<Double, Double>() {
    @Override
    public Double apply(Double c) {
        return c * 9 / 5 + 32;
    }
};
        Scanner scanner = new Scanner(System.in);
        double celsius = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Enter temperature in Celsius: ");
            try {
                celsius = scanner.nextDouble(); 
                if (celsius < -273.15) {
                    System.out.println("Temperature cannot be below absolute zero (-273.15°C). Try again.");
                    continue;
                }

                validInput = true; 
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
                scanner.next(); 
            }
        }
        double fahrenheit = celsiusToFahrenheit.apply(celsius);

        System.out.printf("%.2f°C = %.2f°F%n", celsius, fahrenheit);
    }
}
