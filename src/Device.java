import java.util.concurrent.TimeUnit;

public class Device implements Runnable {

    String name;
    String type;
    Semaphore semaphore;
    Router router;

    public Device(String name, String type, Semaphore semaphore, Router router) {
        this.name = name;
        this.type = type;
        this.semaphore = semaphore;
        this.router = router;
    }
    public Device(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void connect() {
        System.out.println(this.name + " Login");
    }

    public void logout() {
        System.out.println(this.name + " Logged out");
    }

    public void performOnlineActivity() {
        System.out.println(this.name + " performs online activity");
    }

    @Override
    public void run() {
        if(semaphore.getCounter()<=0) {
            System.out.println("(" + getName() + ")" + "(" + getType() + ")" + "arrived and waiting");
        }
        else{
            System.out.println("(" + getName() + ")" + "(" + getType() + ")" + "arrived");
        }
        semaphore.Wait();
        router.occupyConnection(this);
        connect();
        performOnlineActivity();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {

        }
        logout();
        semaphore.Signal();
        router.releaseConnection(this);
    }
}
