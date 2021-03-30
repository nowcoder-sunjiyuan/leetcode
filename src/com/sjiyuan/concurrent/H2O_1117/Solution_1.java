package com.sjiyuan.concurrent.H2O_1117;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCode
 * @description: 信号量实现方式
 * @author: 孙济远
 * @create: 2021-03-26 02:46
 */
public class Solution_1 {
    Semaphore h = new Semaphore(2);
    Semaphore o = new Semaphore(0);
    volatile int num = 0;
    public Solution_1() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        num++;
        if(num == 2){
            num = 0;
            o.release();
        }

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire();
        releaseOxygen.run();
        h.release(2);

    }
}
