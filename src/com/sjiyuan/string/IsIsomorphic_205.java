package com.sjiyuan.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 同构字符串
 * @author: 孙济远
 * @create: 2021-02-03 17:34
 */
public class IsIsomorphic_205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> hash = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            if (hash.containsKey(s.charAt(i))) {
                if (hash.get(s.charAt(i)) != t.charAt(i)) return false;
            } else {
                if (hash.containsValue(t.charAt(i))) return false;
                else hash.put(s.charAt(i), t.charAt(i));
            }

        }
        return true;
    }
}
