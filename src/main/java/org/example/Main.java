package org.example;

//Напишите метод filter, который принимает на вход массив любого типа, вторым арументом метод должен принимать клас,
//реализующий интерфейс Filter, в котором один метод - T apply(T o) (параметризованный).
//Метод должен быть реализован так чтобы возращать новый масив, к каждому элементу которого была применена функция apply

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Filter<Integer> filter1 = new IntegerFilter();
        Integer[] integers = {1, 2, 3, 4, 5, 6, 7};

        Filter<String> filter2 = new StringFilter();
        String[] strings = {"a", "b", "c"};

        System.out.println(Arrays.toString(filter(integers,filter1)));
        System.out.println(Arrays.toString(filter(strings,filter2)));

    }

    public static <T> T[] filter(T[] array, Filter<T> filterClass) {
        List<T> filteredArr = new ArrayList<>();
        for (T t : array) {
            filteredArr.add(filterClass.apply(t));
        }
        return (T[]) filteredArr.toArray();
    }
}