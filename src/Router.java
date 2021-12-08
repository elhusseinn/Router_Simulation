import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Router{
    private int numOfConnections;
    Semaphore semaphore = new Semaphore();
    public Router(int n) throws IOException {
        this.numOfConnections = n;
    }

    List<Device> connections=new ArrayList<>();
    int i = 0;

    public int getI() {
        return i;
    }

    public void setNumConnection(int n){
        numOfConnections = n;
    }
    public int getNumOfConnections(){
        return numOfConnections;
    }

    public synchronized void occupyConnection(Device device) throws IOException {
        device.semaphore = this.semaphore;
        connections.add(device);
        i++;
        device.setConnectionNumber(i);
        System.out.println("-Connection "+device.getConnectionNumber()+": "+device.getName() + " Occupied");
    }
    public void releaseConnection(Device device){
        connections.remove(device);
        i--;
    }

}
