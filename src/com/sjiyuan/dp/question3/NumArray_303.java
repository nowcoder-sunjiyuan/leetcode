package com.sjiyuan.dp.question3;


import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 区域和检索
 * 方法一：暴力，每次求和都循环遍历，时间超了
 * 方法二：用二维数组存dp[i][j]代表，i-j的和，内存超了（亲测）
 * 方法三：将方法二的二维数组换成HashMap，map实质是一个数组，数组节点加链表（空间比二位数组少很多）
 * 方法四：一个数组dp，存0 - i的和，求 i - j的和等于，0 - j的和减去0 - i-1的和
 */
public class NumArray_303 {
    //Pair代表一对值
    private HashMap<Pair<Integer, Integer>, Integer> map = new HashMap<>();

    public NumArray_303(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //从每一个开头，计算和
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                //Pair重写了hashCode和equals方法
                map.put(new Pair<>(i, j), sum);
            }
        }
    }

    public int sumRange(int i, int j) {
        return map.get(new Pair<>(i, j));
    }
}
