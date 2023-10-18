package threads;

import java.util.concurrent.ExecutorService;

public class CounterRunner {
    public static void main(String[] args) {
        //trafik varsa thread kullanirsin cunku cpuyu tutar birakmaz
        ///Atomic eger eger conjectgion olusmayan yerlerde kullanirsaniz cok daha hizlidir
        //private static AtomicInteger counter = new AtomicInteger(0);
        //private static int counter = 0;
        CounterThread counterThread = new CounterThread();
        counterThread.start();
        while (true) {
            System.out.println("CounterRunner");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ExecutorService executorService = null;
            executorService.submit(() -> {
                System.out.println("CounterRunner");
            });
            executorService.shutdown();
        }
    }
}
