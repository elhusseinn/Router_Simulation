public class MyThread extends Thread{
    String name;
    MyThread(String name) { this.name = name;}
    @Override
    public void run() { for (int i = 0; i < 1000; i++)
        System.out.println(name + " is running!");
    }
}