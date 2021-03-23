package com.sjiyuan.concurrent.FooBar_1151;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * @program: LeetCode
 * @description: BlockingQueue来实现线程切换，24ms 时间超过99%
 * @author: 孙济远
 * @create: 2021-03-24 01:40
 */
public class solution_2 {
    private int n;
    // 用两个BlockingQueue来
    private BlockingQueue<Integer> one = new LinkedBlockingQueue<>(1);
    private BlockingQueue<Integer> two = new LinkedBlockingQueue<>(1);
    public solution_2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            one.put(1);
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            two.put(1);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            two.take();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            one.take();
        }
    }
}
