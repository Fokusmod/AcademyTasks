package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class ComplexTask {

    private final List<Integer> list = new ArrayList<>();

    public void execute() {
        try {
            Thread.sleep(new Random().nextInt(2000));
            list.add(new Random().nextInt(10));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Integer> getList() {
        return list;
    }
}
