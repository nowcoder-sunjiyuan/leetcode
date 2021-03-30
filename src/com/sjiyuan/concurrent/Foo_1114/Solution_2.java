package com.sjiyuan.concurrent.Foo_1114;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @program: LeetCode
 * @description: 按顺序执行方法，用countDownLatch来实现
 * @author: 孙济远
 * @create: 2021-03-23 01:54
 */
public class Solution_2 {

    private final CountDownLatch first = new CountDownLatch(1);
    private final CountDownLatch second = new CountDownLatch(1);

    public Solution_2() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        // 减1后，让所有的阻塞的一起工作
        first.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // 阻塞在这个上面
        first.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        second.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        second.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
