public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new MyThread("A");
        Thread t3 = new MyThread("B");
        t1.start(); t2.start(); t3.start();
        System.out.println("In main thread!");
    }
}
