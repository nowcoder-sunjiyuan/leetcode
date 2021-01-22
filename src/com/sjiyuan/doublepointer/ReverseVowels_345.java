package com.sjiyuan.doublepointer;

import java.util.Arrays;
import java.util.List;

/**
 * 反转元音字母
 */
public class ReverseVowels_345 {

    private static final List<Character> vowel = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A','E','I','O','U');

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; ) {
            while (!isVow(chars[i]) && i < j) {
                i++;
            }

            while(!isVow(chars[j]) && i < j){
                j--;
            }

            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }

    /**
     * 这个比 vowel.contains() 的效率高
     * @param c
     * @return
     */
    private boolean isVow(char c) {
        return c == 'a' || c == 'o' || c == 'e' || c == 'i' || c == 'u' ||
                c == 'A' || c == 'O' || c == 'E' || c == 'I' || c == 'U';
    }


    public static void main(String[] args) {
        ReverseVowels_345 reverseVowels_345 = new ReverseVowels_345();
        System.out.println(reverseVowels_345.reverseVowels("leetcode"));
    }
}
