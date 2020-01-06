package com.sjiyuan.array;

/**
 * @ClassName Fibonacci_509
 * @Description TODO 斐波那契数列实现（剑指offer）
 * @Author sjy
 * @Date 2020/1/6 22:53
 * @Version 1.0
 **/
public class Fibonacci_509 {

    public int fib(int N) {
        int fb0 = 0;
        int fb1 = 1;
        if(N == 0) return fb0;
        if(N == 1) return fb1;

        int result = 0;

        for(int i = 2; i <= N; i++){
            result = fb0 + fb1;
            fb0 = fb1;
            fb1 = result;
        }
        return result;
    }
}
