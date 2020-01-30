package com.sjiyuan.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Combination_77
 * @Description TODO 组合
 * @Author sjy
 * @Date 2020/1/30 16:39
 * @Version 1.0
 **/
public class Combination_77 {
    /**
     * 剑指offer解法（自己实现，花了很久）
     *
     * 计算从start开始，到end数，求其中k个数的组合
     * 求n个数字，的k个数字的组合：
     * 如果包含数字a，则相当于求n-1个数（除去a），的k-1个数的组合
     * 如果不包含数字a，则想当于求n-1个数（除去a），的k个数的组合
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        //数据数量小于需要组合的数据数量，则返回null
        if (n < k) return null;

        List<List<Integer>> result = new ArrayList<>();
        /**
         * k = 1的时候的结果
         */
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                List<Integer> combination = new ArrayList<>();
                combination.add(i);
                result.add(combination);
            }
            return result;
        }

        /**
         * 如果包含数字a，则相当于求n-1个数（除去a），的k-1个数的组合
         * 在此处是n
         */
        List<List<Integer>> combine = combine(n - 1, k - 1);
        if (combine != null) {
            for (List<Integer> temp : combine) {
                temp.add(n);
            }
        }
        /**
         * 不包含数字a，则相当于求n-1个数（除去a），的k个数的组合
         */
        List<List<Integer>> combine1 = combine(n - 1, k);

        /**
         * 需要将两个结果集合放到临时链表上
         */
        if (combine != null) result.addAll(combine);
        if (combine1 != null) result.addAll(combine1);

        return result;
    }

    public static void main(String args[]) {
        Combination_77 combination_77 = new Combination_77();
        List<List<Integer>> combine = combination_77.combine(4, 3);
    }

}
