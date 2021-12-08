import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Network {
    public static void main(String[] args) throws IOException {
        int N, TC;
        ArrayList<Device>threads = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the number of WI-FI Connections?");
        N = scanner.nextInt();
        Router router_live = new Router(N);
        router_live.semaphore.counter = N;
        System.out.println("What is the number of devices Clients want to connect?");
        TC = scanner.nextInt();
        for(int i =0; i <TC; i++){
            Device TCLine = new Device(scanner.next(), scanner.next(), router_live);
            threads.add(TCLine);
        }
        PrintStream ps
                = new PrintStream(new File("Log2.txt"));
        System.setOut(ps);
        for(Device device : threads){
            Thread t = new Thread(device);
            t.start();
        }


    }
}
