package com.sjiyuan.concurrent.FooBar_1115;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @program: LeetCode
 * @description: 用循环栅栏 CyclicBarrier控制，24ms 时间超过99%
 * @author: 孙济远
 * @create: 2021-03-25 01:39
 */
public class Solution_3 {
    private int n;
    public Solution_3(int n) {
        this.n = n;
    }
    // 两个线程的栅栏
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    // 这里为什么要volatile呢
    volatile boolean fin = true;
    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // 自旋，相当于foo其实用自旋的boolean控制，bar用栅栏，等foo到栅栏了，才再一起运行，然后foo就被自旋，等着bar打印后把fin变成true
            // 解决foo的自旋
            while(!fin);
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            fin = false;
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                // 让bar线程来来这里等着
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fin = true;
        }
    }
}
