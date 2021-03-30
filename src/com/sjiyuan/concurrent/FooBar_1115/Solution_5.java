package com.sjiyuan.concurrent.FooBar_1115;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: LeetCode
 * @description: 用sychornized+notify+wait来实现
 * @author: 孙济远
 * @create: 2021-03-28 00:23
 */
public class Solution_5 {

    private int n;
    final Object object = new Object();
    public Solution_5(int n) {
        this.n = n;
    }

    //控制交替
    volatile boolean fin = true;

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (object){
                // 注意wait要放在循环中
                while(!fin){
                    object.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                object.notifyAll();
                fin = false;
            }
        }

    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized(object) {
                while(fin){
                    object.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                object.notifyAll();
                fin = true;
            }

        }
    }
}
