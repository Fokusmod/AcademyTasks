package org.example;

//Изучите внутреннюю реализацию класса StringBuilder и напишите свою с добавлением дополнительного метода - undo().
//Прежде чем приступать - прочитайте про паттерн snapshot и примените его в своей реализации.
//примечание: полностью переписывать все методы которые есть в StringBuilder не нужно, в задании важно именно понимание
//сути паттерна. В случае, если задание остаётся непонятным, задайте вопрос ментору

public class Main {



    public static void main(String[] args) {

        CustomStringBuilder customStringBuilder = new CustomStringBuilder();
        customStringBuilder.append("abc");
        System.out.println(customStringBuilder);
        customStringBuilder.append("-cba");
        System.out.println(customStringBuilder);
        customStringBuilder.undo();
        System.out.println(customStringBuilder);
        customStringBuilder.undo();
        System.out.println(customStringBuilder);

    }



}