import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        int ch;
        do {
            System.out.println("\n1.Append  2.Insert at index  3.Search  4.List strings starting with a letter");
            System.out.println("5.Delete  6.Sort  7.Display   8.Exit");
            System.out.print("Choice: ");
            ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 1:
                    System.out.print("String: ");
                    list.add(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Index: ");
                    int idx = sc.nextInt(); sc.nextLine();
                    System.out.print("String: ");
                    String s = sc.nextLine();
                    if (idx >= 0 && idx <= list.size()) list.add(idx, s);
                    else System.out.println("Invalid index");
                    break;
                case 3:
                    System.out.print("Search for: ");
                    String key = sc.nextLine();
                    System.out.println(list.contains(key) ? "Found at index " + list.indexOf(key) : "Not found");
                    break;
                case 4:
                    System.out.print("Starting letter: ");
                    String pre = sc.nextLine();
                    for (String x : list) if (x.toLowerCase().startsWith(pre.toLowerCase())) System.out.println(x);
                    break;
                case 5:
                    System.out.print("String to delete: ");
                    System.out.println(list.remove(sc.nextLine()) ? "Deleted" : "Not found");
                    break;
                case 6:
                    Collections.sort(list);
                    System.out.println("Sorted.");
                    break;
                case 7:
                    System.out.println(list);
                    break;
                case 8:
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (ch != 8);
        sc.close();
    }
}
