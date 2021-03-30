package com.sjiyuan.concurrent.FooBar_1115;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: LeetCode
 * @description:
 * @author: 孙济远
 * @create: 2021-03-28 00:54
 */
public class Test {
    public static void main(String[] args) {
        Solution_4 solution_4 = new Solution_4(2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            try {
                solution_4.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                solution_4.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
