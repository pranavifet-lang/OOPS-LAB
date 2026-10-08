import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Wrapper classes
        Integer i = Integer.valueOf(50);
        Double d = Double.valueOf(12.5);
        Character c = Character.valueOf('A');
        Boolean b = Boolean.valueOf(true);
        System.out.println("Wrappers: " + i + ", " + d + ", " + c + ", " + b);

        // Autoboxing (primitive -> object)
        int p = 100;
        Integer boxed = p;
        System.out.println("Autoboxing   : " + boxed);

        // Unboxing (object -> primitive)
        int unboxed = boxed;
        System.out.println("Unboxing     : " + unboxed);

        // Parsing / conversion
        int n = Integer.parseInt("123");
        String s = Integer.toString(456);
        System.out.println("parseInt     : " + (n + 1) + ", toString: " + s + "!");
        System.out.println("Binary of 10 : " + Integer.toBinaryString(10));
        System.out.println("Max / Min int: " + Integer.MAX_VALUE + " / " + Integer.MIN_VALUE);

        // Autoboxing with collections
        ArrayList<Integer> list = new ArrayList<>();
        for (int k = 1; k <= 5; k++) list.add(k * 10);
        int sum = 0;
        for (int v : list) sum += v;
        System.out.println("List: " + list + " Sum: " + sum);
    }
}
