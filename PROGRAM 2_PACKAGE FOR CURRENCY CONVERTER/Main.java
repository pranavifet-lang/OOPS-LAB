import currency.CurrencyConverter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;
        do {
            System.out.println("\n--- CURRENCY CONVERTER ---");
            System.out.println("1. Dollar to Rupee   2. Rupee to Dollar");
            System.out.println("3. Euro to Rupee     4. Rupee to Euro");
            System.out.println("5. Pound to Rupee    6. Rupee to Pound");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            ch = sc.nextInt();
            if (ch == 0) break;
            System.out.print("Enter amount: ");
            double a = sc.nextDouble();
            switch (ch) {
                case 1: System.out.printf("Rs. %.2f%n", CurrencyConverter.dollarToRupee(a)); break;
                case 2: System.out.printf("$ %.2f%n", CurrencyConverter.rupeeToDollar(a)); break;
                case 3: System.out.printf("Rs. %.2f%n", CurrencyConverter.euroToRupee(a)); break;
                case 4: System.out.printf("EUR %.2f%n", CurrencyConverter.rupeeToEuro(a)); break;
                case 5: System.out.printf("Rs. %.2f%n", CurrencyConverter.poundToRupee(a)); break;
                case 6: System.out.printf("GBP %.2f%n", CurrencyConverter.rupeeToPound(a)); break;
                default: System.out.println("Invalid choice");
            }
        } while (true);
        sc.close();
    }
}
