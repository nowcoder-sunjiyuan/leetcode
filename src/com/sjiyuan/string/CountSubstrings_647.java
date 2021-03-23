package com.sjiyuan.string;

/**
 * @program: LeetCode
 * @description:
 * @author: 孙济远
 * @create: 2021-03-24 01:25
 */
public class CountSubstrings_647 {
    public int countSubstrings(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for(int i = 1; i < s.length(); i++){
            int count = 1;
            for(int j = i - 1; j >= 0; j--){
                if(checkPS(s, j, i)) count++;
            }
            dp[i] = dp[i - 1] + count;
        }
        return dp[s.length() - 1];
    }

    public boolean checkPS(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;

    }
}
