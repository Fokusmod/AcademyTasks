package org.example;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {

        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );

        //Группируйте заказы по продуктам.
        Map<String, List<Double>> groupByProduct = orders.stream()
                .collect(Collectors.groupingBy(Order::getProduct,Collectors.mapping(Order::getCost,Collectors.toList())));
        System.out.println("Заказы товаров и их стоимость");
        System.out.println(groupByProduct + "\n");

        //Для каждого продукта найдите общую стоимость всех заказов.
        Map<String, Double> totalCostByProduct = orders.stream()
                        .collect(Collectors.groupingBy(Order::getProduct,Collectors.summingDouble(Order::getCost)));
        System.out.println("Общая стоимость товаров");
        System.out.println(totalCostByProduct + "\n");

        //Отсортируйте продукты по убыванию общей стоимости.
        List<Order> fromLargestToSmallest = orders.stream()
                .sorted((order, orderAnother) -> Double.compare(orderAnother.getCost(), order.getCost()))
                .toList();
        System.out.println("Продукты в порядке убывания");
        System.out.println(fromLargestToSmallest + "\n");

        //Выберите три самых дорогих продукта.
        List<Order> ThreeMaxCostProduct = orders.stream()
                .sorted((order, orderAnother) -> Double.compare(orderAnother.getCost(), order.getCost()))
                .limit(3)
                .toList();
        System.out.println("Три самых дорогих продукта");
        System.out.println(ThreeMaxCostProduct + "\n");

        //Выведите результат: список трех самых дорогих продуктов и их общая стоимость.
        double ThreeMostCostProductTotalCost = orders.stream()
                .sorted((order, orderAnother) -> Double.compare(orderAnother.getCost(), order.getCost()))
                .limit(3)
                .mapToDouble(Order::getCost)
                .sum();
        System.out.println("Cписок трех самых дорогих продуктов и их общая стоимость");
        System.out.println(ThreeMostCostProductTotalCost + "\n");


    }
}