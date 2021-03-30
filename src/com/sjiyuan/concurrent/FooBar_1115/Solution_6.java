package com.sjiyuan.concurrent.FooBar_1115;

/**
 * @program: LeetCode
 * @description: 用自旋CAS，无锁方式实现
 * @author: 孙济远
 * @create: 2021-03-28 00:23
 */
public class Solution_6 {

    private int n;

    public Solution_6(int n) {
        this.n = n;
    }

    volatile boolean flag = false;
    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; ) {
            while(flag){
                Thread.yield();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            i++;
            flag = true;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; ) {
            while(!flag){
                Thread.yield();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            i++;
            flag = false;
        }

    }
}
