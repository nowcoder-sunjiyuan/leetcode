package com.sjiyuan.hash;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 字母异位词
 * @author: 孙济远
 * @create: 2021-03-23 00:44
 */
public class GroupAnagrams_49 {
    // 用hash表的方法
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }

            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                while (count[i] != 0) {
                    temp.append((char) ('a' + i));
                    count[i]--;
                }

            }
            List<String> list = map.getOrDefault(temp.toString(), new ArrayList<>());
            list.add(str);
            map.put(temp.toString(), list);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams_49 groupAnagrams_49 = new GroupAnagrams_49();
        groupAnagrams_49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
