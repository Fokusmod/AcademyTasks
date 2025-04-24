package org.example;

public class IntegerFilter implements Filter<Integer>{

    @Override
    public Integer apply(Integer o) {
        return o + 10;
    }
}
