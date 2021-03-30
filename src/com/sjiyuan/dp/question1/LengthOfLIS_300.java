package com.sjiyuan.dp.question1;

/**
 * @program: LeetCode
 * @description: 动态规划实现最长递增子序列
 * @author: 孙济远
 * @create: 2021-03-26 17:31
 */
public class LengthOfLIS_300 {
    // 动态规划解决问题
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        // 我怎么就想不到，存以num结尾的最长底层子序列的个数，这种dp数组
        int[] dp = new int[nums.length];
        int result = 1;
        dp[0] = 1;
        for(int i = 1; i < nums.length; i++){
            int max = 1;
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    //此时，第i位可以排在j的后面
                    if(dp[j] + 1 > max) max = dp[j] + 1;
                }
            }
            if(max > result) result = max;
            dp[i] = max;
        }

        return result;
    }

    public static void main(String[] args) {
        LengthOfLIS_300 lengthOfLIS_300 = new LengthOfLIS_300();
        lengthOfLIS_300.lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
    }
}
