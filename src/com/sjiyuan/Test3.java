package com.sjiyuan;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeetCode
 * @description:
 * @author: 孙济远
 * @create: 2021-03-29 13:32
 */
public class Test3 {
    public int getMex(int[] A, int n) {
        //boolean[] array  = new boolean[Integer.MAX_VALUE];
        Set<Integer> set = new HashSet<>();
        for(int num : A){
            set.add(num);
        }
        for(int i = 1; i < Integer.MAX_VALUE; i++){
            if(!set.contains(i)) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        int mex = test3.getMex(new int[]{1, 2, 3, 5, 6, 3, 2}, 7);
        System.out.println(mex);
    }
}
