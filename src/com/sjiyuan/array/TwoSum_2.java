package com.sjiyuan.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 两个数相加
 */
public class TwoSum_2 {
    /**
     * 一次遍历哈希表
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                result[0] = hashMap.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            hashMap.put(nums[i], i);
        }
        return result;
    }

    public static void main(String args[]) {
        int nums[] = {2, 2, 3, 4, 5};
        TwoSum_2 twoSum_2 = new TwoSum_2();
        int[] ints = twoSum_2.twoSum(nums, 4);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
