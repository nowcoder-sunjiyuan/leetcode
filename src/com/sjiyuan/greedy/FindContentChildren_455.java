package com.sjiyuan.greedy;

import java.util.Arrays;

/**
 * 分发饼干
 */
public class FindContentChildren_455 {

    /**
     * 贪心算法
     * 8ms，86.45%
     * @param g 胃口
     * @param s 饼干尺寸
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int result = 0;

        for (int i = 0, j = 0; i < g.length && j < s.length; j++) {
            if (s[j] >= g[i]) {
                result++;
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindContentChildren_455 findContentChildren = new FindContentChildren_455();
        int contentChildren = findContentChildren.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3});
        System.out.println(contentChildren);
    }
}
