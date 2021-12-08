import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Device implements Runnable {

    String name;
    String type;
    Semaphore semaphore;
    Router router;
    int connectionNumber;

    public int getConnectionNumber() {
        return connectionNumber;
    }

    public void setConnectionNumber(int connectionNumber) {
        this.connectionNumber = connectionNumber;
    }


    public Device(String name, String type, Router router) throws IOException {
        this.name = name;
        this.type = type;
        this.semaphore = router.semaphore;
        this.router = router;
    }

    public String getName() {
        return name;
    }


    public String getType() {
        return type;
    }

    public void connect() throws IOException {
        System.out.println("-Connection "+this.getConnectionNumber()+": "+this.getName() + " Login");

    }

    public void logout() throws IOException {
        System.out.println("-Connection "+this.getConnectionNumber()+": "+this.getName() + " Logged Out");
    }

    public void performOnlineActivity() throws IOException {
        System.out.println("-Connection "+this.getConnectionNumber()+": "+this.getName() + " performs online activity");
    }

    @Override
    public void run() {
        //semaphore.outPut(router, this);
        router.semaphore.Wait(this);
        try {
            router.occupyConnection(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            performOnlineActivity();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {

        }
        try {
            logout();
        } catch (IOException e) {
            e.printStackTrace();
        }
        router.semaphore.Signal();
        router.releaseConnection(this);
    }
}
