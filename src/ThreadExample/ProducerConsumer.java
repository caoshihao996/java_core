package ThreadExample;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class ProducerConsumer {

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    private static class Produce extends Thread{
        @Override
        public void run() {
            try {
                queue.put("product");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("produce..");
        }
    }

    private static class Consume extends Thread{
        @Override
        public void run() {
            try {
                String product = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("consumer..");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Produce producer = new Produce();
            producer.start();
        }
        for (int i = 0; i < 5; i++) {
            Consume consumer = new Consume();
            consumer.start();
        }
        for (int i = 0; i < 3; i++) {
            Produce produce = new Produce();
            produce.start();
        }
    }
}
