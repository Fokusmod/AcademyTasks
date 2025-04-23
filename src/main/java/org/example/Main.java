package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        String result = parseDate(localDateTime);
        System.out.println(result);
    }

    public static String parseDate(LocalDateTime localDateTime) {
        StringBuilder stringBuilder = new StringBuilder();
        String delimiter = ":";

        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();

        stringBuilder.append(localDate.toString().replace("-",delimiter));
        stringBuilder.append(delimiter).append(localTime.getHour());
        stringBuilder.append(delimiter).append(localTime.getMinute());
        stringBuilder.append(delimiter).append(localTime.getSecond());
        stringBuilder.append(delimiter).append(localTime.getNano());

        return stringBuilder.toString();
    }

}