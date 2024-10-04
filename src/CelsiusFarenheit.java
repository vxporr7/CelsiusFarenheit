import java.util.Scanner;
public class CelsiusFarenheit {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean validInput = false;
        double temperature = 0;
        char scale = ' ';

        // Input loop
        do {
            System.out.print("Enter temperature (e.g., 100C or 212F): ");
            String input;
            input = in.nextLine();

            if (input.length() > 1) {
                try {
                    temperature = Double.parseDouble(input.substring(0, input.length() - 1));
                    scale = Character.toUpperCase(input.charAt(input.length() - 1));

                    if (scale == 'C' || scale == 'F') {
                        validInput = true;
                    } else {
                        System.out.println("Invalid scale. Please enter 'C' for Celsius or 'F' for Fahrenheit.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid temperature format. Please enter a valid number followed by 'C' or 'F'.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid temperature.");
            }
        } while (!validInput);

        // Conversion
        if (scale == 'C') {
            double fahrenheit = celsiusToFahrenheit(temperature);
            System.out.printf("%.2fC is %.2fF%n", temperature, fahrenheit);
        } else {
            double celsius = fahrenheitToCelsius(temperature);
            System.out.printf("%.2fF is %.2fC%n", temperature, celsius);
        }

        // Tests
        System.out.println("\nRunning tests...");
        runTests();
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static void runTests() {
        // Test freeze and boil points
        System.out.printf("0C should be 32F: %.2fF%n", celsiusToFahrenheit(0));
        System.out.printf("100C should be 212F: %.2fF%n", celsiusToFahrenheit(100));
        System.out.printf("32F should be 0C: %.2fC%n", fahrenheitToCelsius(32));
        System.out.printf("212F should be 100C: %.2fC%n", fahrenheitToCelsius(212));

        // Test bad input
        try {
            System.out.println("Testing bad input...");
            celsiusToFahrenheit(Double.parseDouble("bad input"));
        } catch (NumberFormatException e) {
            System.out.println("Caught bad input as expected.");
        }
    }
}
