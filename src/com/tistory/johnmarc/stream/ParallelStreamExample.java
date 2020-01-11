package com.tistory.johnmarc.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<String> data = Arrays.asList(
                "아메리카노", "카페라떼", "바닐라 라떼", "콜드브루"
        );

        System.out.println("------------------------");
        System.out.println("Normal Stream Start");
        System.out.println("------------------------");

        Stream<String> stream = data.stream();
        stream.forEach(ParallelStreamExample::print);

        System.out.println("------------------------");
        System.out.println("Parallel Stream Start");
        System.out.println("------------------------");

        Stream<String> parallelStream = data.parallelStream();
        parallelStream.forEach(ParallelStreamExample::print);
    }

    private static void print(String s) {
        System.out.println(s + " -> " + Thread.currentThread().getName());
    }
}
