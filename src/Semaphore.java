public class Semaphore {

    protected int counter = 0;

    protected Semaphore() {
        counter = 0;
    }

    protected Semaphore(int initial) {
        counter = initial;
    }

    public synchronized void Wait() {

        while (counter <= 0);
        counter--;
    }

    public synchronized void Signal() {
        counter++;
    }
}
