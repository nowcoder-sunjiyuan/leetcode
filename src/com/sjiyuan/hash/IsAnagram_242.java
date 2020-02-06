package com.sjiyuan.hash;

/**
 * @ClassName IsAnagram_242
 * @Description TODO 有效的字母异位词
 * @Author sjy
 * @Date 2020/2/6 15:51
 * @Version 1.0
 **/
public class IsAnagram_242 {
    public boolean isAnagram(String s, String t) {
        char[] hash = new char[26];

        if (s.length() != t.length()) return false;


        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) return false;
        }

        return true;
    }

    public static void main(String args[]) {
        IsAnagram_242 isAnagram_242 = new IsAnagram_242();
        isAnagram_242.isAnagram("a", "b");
    }
}
