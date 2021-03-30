package com.sjiyuan.concurrent.FooBar_1115;

import java.util.concurrent.Semaphore;

/**
 * @program: LeetCode
 * @description: 用信号量解决，信号量控制线程的顺序（自己写的方法），27ms 时间超过34%
 * @author: 孙济远
 * @create: 2021-03-24 01:38
 */
public class Solution_1 {
    private int n;
    private Semaphore one = new Semaphore(1);
    private Semaphore two = new Semaphore(0);
    public Solution_1(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            one.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            two.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            two.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            one.release();
        }
    }
}
