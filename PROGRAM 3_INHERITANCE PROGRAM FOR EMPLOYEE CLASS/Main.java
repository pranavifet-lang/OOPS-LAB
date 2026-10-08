class Employee {
    String empName;
    int empId;
    String address;
    String mailId;
    String mobileNo;
    double basicPay;

    Employee(String empName, int empId, String address, String mailId, String mobileNo, double basicPay) {
        this.empName = empName;
        this.empId = empId;
        this.address = address;
        this.mailId = mailId;
        this.mobileNo = mobileNo;
        this.basicPay = basicPay;
    }

    double da()  { return 0.97 * basicPay; }
    double hra() { return 0.10 * basicPay; }
    double pf()  { return 0.12 * basicPay; }
    double staffClub() { return 0.001 * basicPay; }
    double gross() { return basicPay + da() + hra(); }
    double net()   { return gross() - pf() - staffClub(); }

    void display() {
        System.out.println("\nID: " + empId + " | Name: " + empName);
        System.out.println("Address: " + address + " | Mail: " + mailId + " | Mobile: " + mobileNo);
        System.out.printf("Gross Pay: %.2f | Net Pay: %.2f%n", gross(), net());
    }
}

class Programmer extends Employee {
    Programmer(String n, int id, String a, String m, String mob, double bp) { super(n, id, a, m, mob, bp); }
    void display() { System.out.println("\n[Programmer]"); super.display(); }
}

class AssistantProfessor extends Employee {
    AssistantProfessor(String n, int id, String a, String m, String mob, double bp) { super(n, id, a, m, mob, bp); }
    void display() { System.out.println("\n[Assistant Professor]"); super.display(); }
}

class AssociateProfessor extends Employee {
    AssociateProfessor(String n, int id, String a, String m, String mob, double bp) { super(n, id, a, m, mob, bp); }
    void display() { System.out.println("\n[Associate Professor]"); super.display(); }
}

class Professor extends Employee {
    Professor(String n, int id, String a, String m, String mob, double bp) { super(n, id, a, m, mob, bp); }
    void display() { System.out.println("\n[Professor]"); super.display(); }
}

public class Main {
    public static void main(String[] args) {
        Employee[] list = {
            new Programmer("Arun", 101, "Chennai", "arun@mail.com", "9000000001", 30000),
            new AssistantProfessor("Divya", 102, "Madurai", "divya@mail.com", "9000000002", 45000),
            new AssociateProfessor("Karthik", 103, "Trichy", "karthik@mail.com", "9000000003", 60000),
            new Professor("Meena", 104, "Coimbatore", "meena@mail.com", "9000000004", 80000)
        };
        for (Employee e : list) e.display();
    }
}
