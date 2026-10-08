class MyThread extends Thread {
    MyThread(String name) { super(name); }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " (extends Thread) -> " + i);
            try { Thread.sleep(300); } catch (InterruptedException e) { System.out.println(e); }
        }
    }
}

class MyRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " (Runnable) -> " + i);
            try { Thread.sleep(300); } catch (InterruptedException e) { System.out.println(e); }
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new MyThread("Thread-A");
        Thread t2 = new Thread(new MyRunnable(), "Thread-B");
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Main thread finished");
    }
}
