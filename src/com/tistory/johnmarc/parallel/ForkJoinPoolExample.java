package com.tistory.johnmarc;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;


public class ForkJoinPoolExample {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        List<Integer> dealmaxList = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8
        );
        ForkJoinPool forkJoinPool = new ForkJoinPool(5);
        forkJoinPool.submit(() -> {
            dealmaxList.parallelStream().forEach(index -> {
                System.out.println("Thread: " + Thread.currentThread().getName()
                        + ", index=" + index + ", " + LocalDateTime.now());
                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }).get();
    }
}
