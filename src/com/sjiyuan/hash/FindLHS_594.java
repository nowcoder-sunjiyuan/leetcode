package com.sjiyuan.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 最长和谐子序列
 * @author: 孙济远
 * @create: 2021-02-03 17:07
 */
public class FindLHS_594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int value : nums) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        for (Integer num : map.keySet()) {
            if (map.containsKey(num + 1)) {
                result = Math.max(map.get(num) + map.get(num + 1), result);
            }
        }
        return result;
    }
}
