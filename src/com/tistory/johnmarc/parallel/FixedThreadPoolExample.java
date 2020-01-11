package com.tistory.johnmarc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {
    public static void main(String[] args) {
        List<Integer> dealmaxList = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8
        );
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < dealmaxList.size(); i++) {
            final int index = i;
            executor.submit(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()
                        + ", index = " + index + ", ended at " + LocalDateTime.now());
            });
        }
        executor.shutdown();
    }
}
