package com.sjiyuan.hash;

/**
 * @ClassName FirstUniqChar_387
 * @Description TODO 字符串中的第一个唯一字符
 * @Author sjy
 * @Date 2020/2/6 11:34
 * @Version 1.0
 **/
public class FirstUniqChar_387 {
    /**
     * 因为该字符串只包含小写字母，所以，用哈希表范围26个即可
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        char[] hash = new char[26];

        if(s.equals("")) return -1;

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            hash[c - 'a']++;
            i++;
        }
        i = 0;
        while (i < s.length()) {
            if (hash[s.charAt(i) - 'a'] == 1) return i;
            i++;
        }

        return -1;
    }

    public static void main(String args[]) {
        FirstUniqChar_387 firstUniqChar_387 = new FirstUniqChar_387();
        System.out.println(firstUniqChar_387.firstUniqChar("leetcode"));

    }
}
