package com.sjiyuan.concurrent.ZeroEvenOdd_1116;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @program: LeetCode
 * @description: 信号量解决
 * @author: 孙济远
 * @create: 2021-03-25 01:36
 */
public class Solution_1 {
    private int n;
    //三个信号量控制三个线程的先后
    Semaphore zero = new Semaphore(1);
    Semaphore even = new Semaphore(0);
    Semaphore odd = new Semaphore(0);

    public Solution_1(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n; i++){
            zero.acquire();
            printNumber.accept(0);
            if(i % 2 == 0){
                // 说明是偶数
                even.release();
            }else{
                odd.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2; i <= n; i = i + 2){
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n; i = i + 2){
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }
}
