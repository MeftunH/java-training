package collection;

import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.*;

public class QueueRunner {
    public static void main(String[] args) {
        //Queue
        //FIFO
        //PriorityQueue
        //Deque
        //LinkedList
        //ArrayDeque
        //nullsa hata vberir
        //threadi birakmiyor bundan dolayi cpuyu tavana vburur
        Queue<String> stringQueue;
        //threadi bekler eger queue doluysa
        //bossa threadi uyandirir
        BlockingQueue<String> stringBlockingQueue;
        //add first add last bunlar var ekstradan
        Deque<String> stringDeque;
        BlockingDeque<String> stringBlockingDeque;

        Queue<String> stringQueue2 = new ArrayBlockingQueue<>(1_000);
        BlockingQueue<String> stringBlockingQueue2 = new ArrayBlockingQueue<>(1_000);
        Deque<String> stringDeque2;
        BlockingDeque<String> stringBlockingDeque2;

        stringQueue2.add("A");
        stringQueue2.add("B");
        stringQueue2.add("C");
        stringQueue2.add("D");
        String poll = stringQueue2.poll();
        try {
            //threadi bekler eger queue bosysa
            String take = stringBlockingQueue2.take();
            String poll2 = stringBlockingQueue2.poll(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DelayQueue<MyDelayed> stringDelayQueue = new DelayQueue<>();
        stringDelayQueue.add(new MyDelayed(1000));
        PriorityQueue<String> stringPriorityQueue = new PriorityQueue<>();
    }

    public static class MyDelayed implements Delayed {
        private final long delay;
        private final long expire;

        public MyDelayed(long delay) {
            this.delay = delay;
            this.expire = System.currentTimeMillis() + delay;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return Long.compare(this.expire, ((MyDelayed) o).expire);
        }
    }
}
