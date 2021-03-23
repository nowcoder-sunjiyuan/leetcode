package com.sjiyuan.sort.bucket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 前k个高频元素
 * @author: 孙济远
 * @create: 2021-01-31 16:47
 */
public class TopKFrequent_347 {
    /**
     * 桶排序实现
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        int length = nums.length;
        //统计每个元素出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // length + 1个桶，下标代表出现的次数，数值是个数组，存储的是多个
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int temp : map.keySet()) {
            //temp这个数的次数count
            Integer count = map.get(temp);
            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(temp);
        }

        int ri = 0;
        int[] result = new int[k];

        for (int i = length; i > 0; i--) {
            if(bucket[i] != null){
                for(int num : bucket[i]){
                    result[ri++] = num;
                    k--;
                    if(k == 0) return result;
                }
            }
        }

        return result;
    }
}
