package com.sjiyuan.dp.question3;

import javafx.util.Pair;

import java.util.HashMap;

public class NumArray_303_2 {

    private int[] dp;

    public NumArray_303_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        dp = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            dp[i] = sum;
        }
    }

    public int sumRange(int i, int j) {
        if (i != 0) return dp[j] - dp[i - 1];
        else return dp[j];
    }
}
