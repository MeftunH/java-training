package threads;

public class CounterThread extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("CounterThread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
