import java.util.Scanner;

public class Network {
    public static void main(String[] args) {
        boolean flag =true;
        int N,TC;
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        String TCline;
        System.out.println("What is the number of WI-FI Connections?");
        N = scanner.nextInt();
        System.out.println("What is the number of devices Clients want to connect?");
        TC = scanner.nextInt();
        Semaphore semaphore_live = new Semaphore(N);
        Router router_live;
        int devices=0;
        while (flag){
            while (devices>=TC)
            String line = scanner.nextLine();
            



        }
    }
}
