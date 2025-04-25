package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ComplexTaskExecutor {

    private final CyclicBarrier barrier;

    private ExecutorService executorService;

    List<ComplexTask> result = new ArrayList<>();


    public ComplexTaskExecutor(int count) {
        this.barrier = new CyclicBarrier(count, ()-> printCompleteTask(result));
    }

    public void executeTasks(int numberOfTasks) {
        executorService = Executors.newFixedThreadPool(numberOfTasks);
        for (int i = 0; i < numberOfTasks; i++) {
            executorService.submit(()->{
               ComplexTask task = new ComplexTask();
               task.execute();
               result.add(task);
                try {
                    System.out.println("ЩЁЛК");
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    private void printCompleteTask(List<ComplexTask> list) {
        List<Integer> completeTask = new ArrayList<>();
        for (ComplexTask task : list) {
            completeTask.addAll(task.getList());
        }
        System.out.println(completeTask);
    }
}
