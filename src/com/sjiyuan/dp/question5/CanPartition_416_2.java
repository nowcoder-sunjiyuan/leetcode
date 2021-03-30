package com.sjiyuan.dp.question5;

/**
 * @program: LeetCode
 * @description: 416把数组改成一维的情况，效率高多了
 * @author: 孙济远
 * @create: 2021-03-26 02:20
 */
public class CanPartition_416_2 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int length = nums.length;
        // 非空数组
        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) return false;// 奇数肯定不对
        int target = sum / 2;
        // boolean默认都是false，压缩到一维数组，代表这一堆数字，能否填到对应位置大小的背包
        boolean[] dp = new boolean[target + 1];
        // 初始状态，第一个数字肯定能填dp[nums[0]]
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        // 一共length个数，遍历一遍，看看都能填到哪些位置
        for (int i = 1; i < length; i++) {
            // 从后往前，如果说当前的数已经大于j了，再往后，肯定都大于j，也就不可能填进去了（太大了）
            for (int j = target; nums[i] < j; j--) {
                // 如果遍历中已经可以填满target，说明直接就符合
                if(dp[target]) return true;
                // 能否填满j，取决于之前能否填满，和（在nums[i]小于j时）能否填满j - nums[i]
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
