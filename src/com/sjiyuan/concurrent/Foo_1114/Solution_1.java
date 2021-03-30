package com.sjiyuan.concurrent.Foo_1114;

import java.util.concurrent.Semaphore;

/**
 * @program: LeetCode
 * @description: 按顺序执行方法(信号量)
 * @author: 孙济远
 * @create: 2021-03-23 01:54
 */
public class Solution_1 {
    Semaphore two = new Semaphore(0);
    Semaphore three = new Semaphore(0);

    public Solution_1() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        two.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        two.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        three.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        three.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }}
