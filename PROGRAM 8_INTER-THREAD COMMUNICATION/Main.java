class Buffer {
    private int item;
    private boolean available = false;

    synchronized void put(int value) {
        while (available) {
            try { wait(); } catch (InterruptedException e) { }
        }
        item = value;
        available = true;
        System.out.println("Produced: " + value);
        notify();
    }

    synchronized int get() {
        while (!available) {
            try { wait(); } catch (InterruptedException e) { }
        }
        available = false;
        System.out.println("Consumed: " + item);
        notify();
        return item;
    }
}

class Producer extends Thread {
    Buffer buf;
    Producer(Buffer b) { buf = b; }
    public void run() { for (int i = 1; i <= 5; i++) buf.put(i); }
}

class Consumer extends Thread {
    Buffer buf;
    Consumer(Buffer b) { buf = b; }
    public void run() { for (int i = 1; i <= 5; i++) buf.get(); }
}

public class Main {
    public static void main(String[] args) {
        Buffer b = new Buffer();
        new Producer(b).start();
        new Consumer(b).start();
    }
}
