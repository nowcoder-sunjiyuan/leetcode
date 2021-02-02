package com.sjiyuan.dp.question1;

/**
 * @program: LeetCode
 * @description: 打家劫舍
 * @author: 孙济远
 * @create: 2021-01-29 18:17
 */
public class Rob_198 {
    /**
     * 如果房屋数量大于两间，应该如何计算能够偷窃到的最高总金额呢？对于第 k~(k>2)k (k>2) 间房屋，有两个选项：
     * 偷窃第 k 间房屋，那么就不能偷窃第 k-1 间房屋，偷窃总金额为前 k-2 间房屋的最高总金额与第 kk 间房屋的金额之和。
     * 不偷窃第 k 间房屋，偷窃总金额为前 k-1 间房屋的最高总金额。
     * 在两个选项中选择偷窃总金额较大的选项，该选项对应的偷窃总金额即为前 kk 间房屋能偷窃到的最高总金额。
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];

        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}
