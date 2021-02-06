package com.sjiyuan.doublepointer;

/**
 * @program: LeetCode
 * @description: 验证回文字符串
 * @author: 孙济远
 * @create: 2021-02-04 14:16
 */
public class ValidPalindrome_680 {
    public boolean validPalindrome(String s) {
        char[] st = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (st[i] != st[j]) {
                return check(st, i, j - 1) || check(st, i + 1, j);
            }
        }
        return true;
    }

    public boolean check(char[] s, int start, int end) {
        while (start < end) {
            if (s[start] != s[end]) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome_680 validPalindrome_680 = new ValidPalindrome_680();
        validPalindrome_680.validPalindrome("abc");
    }
}
