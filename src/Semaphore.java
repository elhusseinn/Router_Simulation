import java.io.FileWriter;
import java.io.IOException;

public class Semaphore {

    protected int counter = 0;

    protected Semaphore() throws IOException {
        counter = 0;
    }

    protected Semaphore(int initial) throws IOException {
        counter = initial;
    }

    public synchronized void Wait(Device device) {
        counter--;
        if (counter < 0) {
            System.out.println("(" + device.getName() + ")" + "(" + device.getType() + ")" + "arrived and waiting");
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        else{
            System.out.println("(" + device.getName() + ")" + "(" + device.getType() + ")" + "arrived");
        }
    }

    public synchronized void Signal() {
        counter++;
        if (counter >= 0) notify();
    }
    public int getCounter(){
        return counter;
    }

}
