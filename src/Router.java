import java.util.ArrayList;
import java.util.List;

public class Router{
    private int numOfConnections;
    public Router(int n){
        this.numOfConnections = n;
    }
    List<Device> connections=new ArrayList<>();
    public void setNumConnection(int n){
        numOfConnections = n;
    }
    public int getNumOfConnections(){
        return numOfConnections;
    }

    public void occupyConnection(Device device){
        connections.add(device);
    }
    public void releaseConnection(Device device){
        connections.remove(device);

    }

}
