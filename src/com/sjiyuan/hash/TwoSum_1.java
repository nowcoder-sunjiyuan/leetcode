package com.sjiyuan.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 两数之和
 * @author: 孙济远
 * @create: 2021-01-24 11:38
 */
public class TwoSum_1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(target - nums[i])) return new int[]{i, hash.get(target - nums[i])};
            hash.put(nums[i], i);
        }
        return null;
    }
}
