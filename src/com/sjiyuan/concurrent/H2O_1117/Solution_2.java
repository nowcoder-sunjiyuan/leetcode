package com.sjiyuan.concurrent.H2O_1117;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCode
 * @description: Lock+condition
 * @author: 孙济远
 * @create: 2021-03-26 02:46
 */
public class Solution_2 {
    Lock lock = new ReentrantLock();
    Condition hCondition = lock.newCondition();
    Condition oCondition = lock.newCondition();
    // 两个H，一个o
    volatile int h = 2;
    volatile int o = 1;

    public Solution_2() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        try{
            lock.lock();
            if(h <= 0) hCondition.await();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            h--;
            if(h == 0 && o == 0) {
                // 一轮结束了
                h = 2;
                o = 1;
                hCondition.signalAll();
                oCondition.signalAll();
            }
        }finally {
            lock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        try{
            lock.lock();
            if(o <= 0) oCondition.await();
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            o--;
            if(h == 0 && o == 0) {
                // 一轮结束了
                h = 2;
                o = 1;
                hCondition.signalAll();
                oCondition.signalAll();
            }
        }finally {
            lock.unlock();
        }
    }
}
