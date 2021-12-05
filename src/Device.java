public class Device implements Runnable{

    @Override
    public void run() { for (int i = 0; i < 1000; i++)
        System.out.println("MyRunnable is running!");
    }

}
