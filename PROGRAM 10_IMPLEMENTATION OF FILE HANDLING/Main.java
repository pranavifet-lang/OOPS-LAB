import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String name = sc.nextLine();
        File f = new File(name);

        try {
            if (f.createNewFile()) System.out.println("File created: " + f.getName());
            else System.out.println("File already exists");

            System.out.println("Absolute path : " + f.getAbsolutePath());
            System.out.println("Readable      : " + f.canRead());
            System.out.println("Writable      : " + f.canWrite());
            System.out.println("Size (bytes)  : " + f.length());

            System.out.print("Enter text to write: ");
            String text = sc.nextLine();
            try (FileWriter fw = new FileWriter(f, true)) {
                fw.write(text + System.lineSeparator());
            }

            System.out.println("\n--- File contents ---");
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                String line;
                int lines = 0, words = 0, chars = 0;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    lines++;
                    chars += line.length();
                    if (!line.trim().isEmpty()) words += line.trim().split("\\s+").length;
                }
                System.out.println("\nLines: " + lines + " | Words: " + words + " | Characters: " + chars);
            }
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
        sc.close();
    }
}
