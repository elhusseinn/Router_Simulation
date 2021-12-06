import java.util.ArrayList;
import java.util.Scanner;

public class Network {
    public static void main(String[] args) {
        boolean flag = true;
        int N, TC;
        ArrayList<Device>threads = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("What is the number of WI-FI Connections?");
        N = scanner.nextInt();
        Semaphore semaphore_live = new Semaphore(N);
        Router router_live = new Router(N);
        System.out.println("What is the number of devices Clients want to connect?");
        TC = scanner.nextInt();
        for(int i =0; i <TC; i++){
            Device TCLine = new Device(scanner.next(), scanner.next(), semaphore_live, router_live);
            threads.add(TCLine);
        }
        for(Device device : threads){
            Thread t = new Thread(device);
            t.start();
        }


    }
}
