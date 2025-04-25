package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class BlockingQueue<T>{

    private final Queue<T> blockingQueue;

    private final int capacity;

    public BlockingQueue(int capasity) {
        this.capacity = capasity;
        this.blockingQueue = new LinkedList<>();
    }

    public synchronized void enqueue(T element)  {
        if (blockingQueue.size() == capacity) {
            try {
                System.out.println(Thread.currentThread().getName()+" Queue is full, i'm go wait");
                wait();
            } catch (InterruptedException e) {
                System.out.println("Поток был прерван.");
            }
        }
        try {
            Thread.sleep(new Random().nextInt(2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        blockingQueue.add(element);
        notifyAll();
    }

    public synchronized void dequeue() {
        if (blockingQueue.isEmpty()) {
            try {
                System.out.println(Thread.currentThread().getName()+" Queue is empty, i'm go wait");
                wait();
            } catch (InterruptedException e) {
                System.out.println("Поток был прерван.");
            }
        }
        try {
            Thread.sleep(new Random().nextInt(2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        blockingQueue.poll();
        notifyAll();
    }
}
