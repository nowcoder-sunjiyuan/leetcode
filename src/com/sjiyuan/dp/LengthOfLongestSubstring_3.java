package com.sjiyuan.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName LengthOfLongestSubstring_3
 * @Description TODO 无重复字符的最长子串
 * @Author sjy
 * @Date 2018/10/24 21:23
 * @Version 1.0
 **/

public class LengthOfLongestSubstring_3 {

    /**
     * 检查每一位开始的字符串，看是否是最长的子串
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {

        char[] array = s.toCharArray();
        int length = 0, temp = 0;
        int i, j, k;

        for (i = 0; i < array.length; i++) {
            if (i == 0) length = 1;
            temp = 1;

            for (j = i + 1; j < array.length; j++) {
                for (k = i; k < j; k++) {
                    if (array[k] == array[j]) {
                        break;
                    }
                }
                if (k != j) {     //说明此时中间有与新位相同的，直接break出去，后一位开始
                    break;
                } else {
                    temp++;
                    if (length < temp) {
                        length = temp;
                    }
                    continue;
                }

            }
        }

        return length;
    }

    public static void main(String args[]) {
        lengthOfLongestSubstring_2("haha");
    }

    /**
     * 教程的滑动窗口(真的很巧妙)
     * 因为要求是连续的字符串，可以用一个窗口，左边是i，右边是j。如果右边一直没有重复，j++。当出现重复时，i不断的增长，直到不重复
     * 这样遍历一遍便找到最长的不重复子串
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring_1(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;

        while(i < n && j < n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j - i);
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return 1;
    }

    /**
     * 改进的滑动窗口
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring_2(String s) {

        Map<Character,Integer> test = new HashMap<>();
        test.put('c',5);

        System.out.println(test.get('c'));
        return 0;
    }



}
