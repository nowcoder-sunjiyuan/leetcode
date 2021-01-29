package com.sjiyuan.dichotomy;

/**
 * @program: LeetCode
 * @description: 寻找比目标字母大的最小字母
 * @author: 孙济远
 * @create: 2021-01-28 10:41
 */
public class NextGreatestLetter_744 {
    public char nextGreatestLetter(char[] letters, char target) {

        if (letters[0] > target || letters[letters.length - 1] <= target) return letters[0];
        /**
         * 1，3，2
         * 1，2，1
         */
        int start = 0, end = letters.length - 1;
        while (start + 1 < end) {

            int mid = (start + end) / 2;
            if (letters[mid] > target) end = mid;
            else start = mid;
        }
        return letters[end];
    }

    public static void main(String[] args) {
        char[] letters = {'e','e','e','e','e','e','n','n','n','n'};
        NextGreatestLetter_744 nextGreatestLetter_744 = new NextGreatestLetter_744();
        char c = nextGreatestLetter_744.nextGreatestLetter(letters, 'e');
        System.out.println(c);
    }
}
