package org.example;


import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new BlockingQueue<>(5);

        Thread producer = new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(new Random().nextInt(100));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                queue.enqueue(i);
                System.out.println("Producer: " + Thread.currentThread().getName() + " complete work");
            }
        });

        Thread consumer = new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                queue.dequeue();
                System.out.println("Consumer: " + Thread.currentThread().getName() + " complete work");
            }
        });

        producer.start();
        consumer.start();

    }
}