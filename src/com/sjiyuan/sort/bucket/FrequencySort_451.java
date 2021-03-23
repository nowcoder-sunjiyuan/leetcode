package com.sjiyuan.sort.bucket;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 根据字符出现的频率排序
 * @author: 孙济远
 * @create: 2021-02-06 22:57
 */
public class FrequencySort_451 {
    public String frequencySort(String s) {
        int[] count = new int[128];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        List<Character>[] bucket = new List[s.length()];
        for (int i = 0; i < count.length; i++) {
            int num = count[i];
            if (bucket[num] == null) {
                bucket[num] = new ArrayList<>();
            }

            bucket[num].add((char) i);
        }
        StringBuilder result = new StringBuilder();
        for (int i = bucket.length - 1; i > 0; i--) {
            for (char c : bucket[i]) {
                result.append(c);
            }
        }
        return result.toString();
    }
}
