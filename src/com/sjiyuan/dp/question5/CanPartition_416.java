package com.sjiyuan.dp.question5;

/**
 * @program: LeetCode
 * @description:
 * @author: 孙济远
 * @create: 2021-03-26 01:50
 */
public class CanPartition_416 {
    // 转化为0 - 1背包问题，nums中是否存在一组数加一起是数组和的一半
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int length = nums.length;
        // 非空数组
        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) return false;// 奇数肯定不对
        int target = sum / 2;
        // boolean默认都是false
        boolean[][] dp = new boolean[length][target + 1];

        // 首先，先填写第一行，nums[0]这个数只能填满它自己大小的背包
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < length; i++) {
            //一行一行的填写
            for (int j = 0; j < target + 1; j++) {
                //三种情况
                //最次的情况：看看，i - 1个数能不能填满j,能填满直接就继续了
                dp[i][j] = dp[i - 1][j];
                if (dp[i][j]) continue;

                //如果当前这个数等于j(即可以直接填满要求的背包)，直接符合情况
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                //如果nums[i]小于当前要求的背包，还可以看看dp[i - 1][j - nums[j]]情况，即之前i - 1个数能不能填满 j - nums[j]啊
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j - nums[i]];
                }
                // 剩下的情况，就没办法了，只能为false
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < target + 1; j++) {
                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }

        return dp[length - 1][target];
    }

    public static void main(String[] args) {
        CanPartition_416 canPartition_416 = new CanPartition_416();
        canPartition_416.canPartition(new int[]{1, 5, 11, 5});
    }
}
