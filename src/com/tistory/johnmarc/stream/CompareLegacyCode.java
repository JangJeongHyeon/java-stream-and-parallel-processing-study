package com.tistory.johnmarc.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CompareLegacyCode {
    public static void legacyIteration1() {
        List<String> data = Arrays.asList("아메리카노", "카페라떼", "바닐라라뗴", "콜드브루");
        Iterator<String> iterator = data.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println("Menu is => " + name);
        }
    }

    public static void legacyIteration2() {
        List<String> data = Arrays.asList("아메리카노", "카페라떼", "바닐라라뗴", "콜드브루");
        for (String name : data) {
            System.out.println("Menu is => " + name);
        }
    }

    public static void usingStreamClass() {
        List<String> data = Arrays.asList("아메리카노", "카페라떼", "바닐라라뗴", "콜드브루");
        data.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        System.out.println("Start => Legacy Iteration Example 1");
        legacyIteration1();
        System.out.println("End.");
        System.out.println("Start => Legacy Iteration Example 2");
        legacyIteration2();
        System.out.println("End.");
        System.out.println("Start => Stream Class");
        usingStreamClass();
        System.out.println("End.");
    }
}
