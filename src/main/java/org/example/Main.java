package org.example;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

//Напишите метод, который получает на вход массив элементов и возвращает Map ключи в котором - элементы, а значения -
// сколько раз встретился этот элемент

public class Main {

    public static void main(String[] args) {
        int[] testArray = {1, 2, 3, 4, 5, 6, 1, 2, 3};
        System.out.println(countOfElements(testArray));
    }

    public static Map<Integer, Integer> countOfElements(int[] array) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int i : array) {
            result.put(i, result.getOrDefault(i, 0) + 1);
        }
        return result;
    }
}