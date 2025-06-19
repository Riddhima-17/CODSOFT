import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Exchange rates (hardcoded)
        double usdToInr = 83.2;
        double eurToInr = 89.15;
        double usdToEur = 0.93;
        System.out.println("----- Currency Converter -----");

        // Ask user for base currency
        System.out.println("Select base currency:");
        System.out.println("1. USD");
        System.out.println("2. EUR");
        System.out.println("3. INR");
        System.out.print("Enter option (1-3): ");
        int base = sc.nextInt();

        // Ask user for target currency
        System.out.println("Select target currency:");
        System.out.println("1. USD");
        System.out.println("2. EUR");
        System.out.println("3. INR");
        System.out.print("Enter option (1-3): ");
        int target = sc.nextInt();

        // Ask user for amount
        System.out.print("Enter amount to convert: ");
        double amt = sc.nextDouble();

        double result = 0;

        // Conversion logic
        if (base == target) {
            result = amt;
        } else if (base == 1 && target == 3) {
            result = amt * usdToInr;
        } else if (base == 3 && target == 1) {
            result = amt / usdToInr;
        } else if (base == 2 && target == 3) {
            result = amt * eurToInr;
        } else if (base == 3 && target == 2) {
            result = amt / eurToInr;
        } else if (base == 1 && target == 2) {
            result = amt * usdToEur;
        } else if (base == 2 && target == 1) {
            result = amt / usdToEur;
        } else {
            System.out.println("Invalid selection.");
            return;
        }

        // Show result
        System.out.printf("Converted amount: %.2f\n", result);
        sc.close();
    }
}

