package com.sjiyuan.dp.question1;

/**
 * @program: LeetCode
 * @description: 打家劫舍2
 * @author: 孙济远
 * @create: 2021-02-02 15:29
 */
public class Rob_213 {
    /**
     * 将问题划分为两个单列：
     * <p>
     * 问题转化不太严谨的，因为对于一个环来说，如果求最大值，存在首尾两个节点都不取的情况；
     * 但为什么问题可以转化为求两个队列呢？
     * 因为对于上述情况，即首尾都不取时，它的最大值肯定小于等于只去掉首或者只去掉尾的队列。
     * 即 f(n1,n2,n3) <= f(n1,n2,n3,n4)
     * <p>
     * 思路是没问题的，可能是楼主解释的不是很清楚。
     * 对于第一个房间来说，存在偷与不偷的情况，如果偷，则最后一家一定不能偷，将其置为0即可，以此数组为基准运行198题的代码得到一个结果。
     * 如果不偷，那么把第一家置为0，最后一家无所谓，运行198题代码，又得到一个结果。返回两个结果较大的一个即可。
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];
        //将数组转化为两个单列
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];

        dp1[0] = 0;
        dp1[1] = nums[1];

        dp2[0] = nums[0];
        dp2[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
        }

        for (int i = 2; i < length - 1; i++) {
            dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
        }
        return Math.max(dp1[length - 1], dp2[length - 2]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        Rob_213 rob_213 = new Rob_213();
        int rob = rob_213.rob(nums);
        System.out.println(rob);
    }
}
