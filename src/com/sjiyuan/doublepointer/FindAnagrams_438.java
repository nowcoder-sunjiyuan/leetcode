package com.sjiyuan.doublepointer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: 孙济远
 * @create: 2021-03-22 00:43
 */
public class FindAnagrams_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        for (int start = 0, end = p.length() - 1; end < s.length(); start++, end++) {
            if (check(s, start, end, p)) {
                result.add(start);
                while (end + 1 < s.length() && s.charAt(start++) == s.charAt(++end)) {
                    result.add(start);
                }
            }


        }
        return result;
    }

    public boolean check(String s, int start, int end, String p) {
        int[] hash = new int[26];

        for (int i = 0; i < p.length(); i++) {
            hash[p.charAt(i) - 'a']++;
        }

        for (int i = start; i <= end; i++) {
            hash[s.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        FindAnagrams_438 findAnagrams_438 = new FindAnagrams_438();
        List<Integer> anagrams = findAnagrams_438.findAnagrams("abab", "ab");
        System.out.println(anagrams);

    }


    /**
     * 网上的方法，效率更高
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams2(String s, String p) {
        int n = s.length(), m = p.length();
        List<Integer> res = new ArrayList<>();
        if(n < m) return res;

        int[] pCnt = new int[26];
        int[] sCnt = new int[26];

        for(int i = 0; i < m; i++){
            pCnt[p.charAt(i) - 'a'] ++;
        }

        int left = 0;
        for(int right = 0; right < n; right++){
            int curRight = s.charAt(right) - 'a';
            sCnt[curRight]++;
            while(sCnt[curRight] > pCnt[curRight]){
                int curLeft = s.charAt(left) - 'a';
                sCnt[curLeft]--;
                left++;
            }
            if(right - left + 1 == m){
                res.add(left);
            }
        }
        return res;
    }
}
