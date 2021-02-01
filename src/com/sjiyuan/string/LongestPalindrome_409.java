package com.sjiyuan.string;

import com.sjiyuan.dp.LongestCommonSubsequence_1143;

import java.util.HashMap;

/**
 * @program: LeetCode
 * @description: 最长回文串
 * @author: 孙济远
 * @create: 2021-01-30 12:13
 */
public class LongestPalindrome_409 {
    public int longestPalindrome(String s) {
        /**
         * 大写英文字母，小写英文字母，ascall码里 0 - 128之内
         */
        int[] count = new int[128];
        for(char c : s.toCharArray()){
            count[c]++;
        }

        int result = 0;
        boolean tag = true;
        for(int i = 0; i < 128; i++){
            if(count[i] % 2 == 1 && tag) {
                result++;
                tag = false;
            }
            result += count[i] / 2 * 2;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        LongestPalindrome_409 longestPalindrome_409 = new LongestPalindrome_409();
        int i = longestPalindrome_409.longestPalindrome(s);

    }
}
