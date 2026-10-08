import java.util.Scanner;

class Customer {
    private String name;
    private int consumerNo;
    private int units;

    Customer(String name, int consumerNo, int units) {
        this.name = name;
        this.consumerNo = consumerNo;
        this.units = units;
    }

    double calculateBill() {
        double bill = 0;
        if (units <= 100) bill = 0;
        else if (units <= 200) bill = (units - 100) * 2.25;
        else if (units <= 500) bill = 100 * 2.25 + (units - 200) * 4.5;
        else bill = 100 * 2.25 + 300 * 4.5 + (units - 500) * 6.0;
        return bill;
    }

    void display() {
        System.out.println("\n----- ELECTRICITY BILL -----");
        System.out.println("Consumer No : " + consumerNo);
        System.out.println("Name        : " + name);
        System.out.println("Units Used  : " + units);
        System.out.printf("Bill Amount : Rs. %.2f%n", calculateBill());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter consumer number: ");
        int no = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter consumer name: ");
        String name = sc.nextLine();
        System.out.print("Enter units consumed: ");
        int units = sc.nextInt();

        Customer c = new Customer(name, no, units);
        c.display();
        sc.close();
    }
}
