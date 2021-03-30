package com.sjiyuan.concurrent.FooBar_1115;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCode
 * @description: 用lock+condition来实现交替输出
 * @author: 孙济远
 * @create: 2021-03-28 00:23
 */
public class Solution_4 {

    private int n;

    public Solution_4(int n) {
        this.n = n;
    }

    // 设置成公平锁
    Lock lock = new ReentrantLock(true);
    Condition condition = lock.newCondition();
    //控制交替
    volatile boolean fin = true;

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                if(!fin){
                    condition.await();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                condition.signalAll();
                fin = false;
            } finally {
                lock.unlock();
            }
        }

    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            try {
                lock.lock();
                if(fin){
                    condition.await();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                condition.signalAll();
                fin = true;
            } finally {
                lock.unlock();
            }

        }
    }
}
