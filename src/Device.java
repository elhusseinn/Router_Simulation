public class Device implements Runnable {

    String name;
    String type;
    Semaphore semaphore;

    public Device(String name, String type, Semaphore semaphore) {
        this.name = name;
        this.type = type;
        this.semaphore = semaphore;
    }

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
        System.out.println(this.name + "Connected");
    }

    public void logout() {
        System.out.println(this.name + " Disconnected");
    }

    public void performOnlineActivity() {
        System.out.println(this.name + " performs online activity");
    }

    @Override
    public void run() {
        semaphore.Wait();
        connect();
        performOnlineActivity();
        try {
            wait(2);
        } catch (InterruptedException e) {

        }
        logout();
        semaphore.Signal();
    }
}
