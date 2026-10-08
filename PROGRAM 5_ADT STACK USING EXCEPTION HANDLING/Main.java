import java.util.Scanner;

class StackOverflowException extends Exception {
    StackOverflowException(String msg) { super(msg); }
}

class StackUnderflowException extends Exception {
    StackUnderflowException(String msg) { super(msg); }
}

class Stack {
    private int[] data;
    private int top = -1;

    Stack(int size) { data = new int[size]; }

    void push(int x) throws StackOverflowException {
        if (top == data.length - 1) throw new StackOverflowException("Stack is full!");
        data[++top] = x;
    }

    int pop() throws StackUnderflowException {
        if (top == -1) throw new StackUnderflowException("Stack is empty!");
        return data[top--];
    }

    void display() {
        if (top == -1) { System.out.println("Stack is empty"); return; }
        System.out.print("Stack: ");
        for (int i = top; i >= 0; i--) System.out.print(data[i] + " ");
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack st = new Stack(5);
        int ch;
        do {
            System.out.println("\n1.Push 2.Pop 3.Display 4.Exit");
            System.out.print("Choice: ");
            ch = sc.nextInt();
            try {
                switch (ch) {
                    case 1: System.out.print("Value: "); st.push(sc.nextInt()); break;
                    case 2: System.out.println("Popped: " + st.pop()); break;
                    case 3: st.display(); break;
                    case 4: System.out.println("Bye"); break;
                    default: System.out.println("Invalid choice");
                }
            } catch (StackOverflowException | StackUnderflowException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (ch != 4);
        sc.close();
    }
}
