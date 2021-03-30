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
public class Solution_3 {
    Lock lock = new ReentrantLock();
    Condition hCondition = lock.newCondition();
    // 两个H
    volatile int h = 0;
    volatile int o = 0;
    public Solution_3() {
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        try{
            lock.lock();
            while(h == 2) hCondition.await();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            h++;
            if(h == 2 && o == 1) {
                h = 0;
                o = 0;
                hCondition.signalAll();
            }
        }finally {
            lock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        try{
            lock.lock();
            while(o == 1) hCondition.await();
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            o++;
            if(h == 2 && o == 1){
                h = 0;
                o = 0;
                hCondition.signalAll();
            }

        }finally {
            lock.unlock();
        }
    }
}
