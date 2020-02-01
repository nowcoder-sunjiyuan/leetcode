package com.sjiyuan.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName NQueens_51
 * @Description TODO N皇后问题
 * @Author sjy
 * @Date 2020/1/30 23:07
 * @Version 1.0
 **/
public class NQueens_51 {
    /**
     * 剑指offer的解法，其实是全排列的问题
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        /**
         * n皇后，数据0 - n-1的全排列，代表每一行皇后的位置（因为皇后必不在同列），
         * 比如，1234，表示四皇后中，第一行皇后在1的位置，第二行的皇后在2的位置，等等等等
         * 所以问题转化为先求n个数的全排列
         */
        List<List<Integer>> permute = new ArrayList<>();
        /**
         * 此处用回溯法
         */
        //记载点是否使用过了
        boolean[] used = new boolean[n];
        List<Integer> path = new ArrayList<>();


        dfs(n, used, 0, path, permute);

        return check(permute, n);
    }

    /**
     * @param n       n个数全排列
     * @param used    0 - n-1 是否使用
     * @param depth   递归的深度（从0开始），当深度为n时，说明所有的数均排列完成
     * @param path    其中的一条路径，代表一种排列，当回溯时，需要将路径回到之前的状态
     * @param permute 最终全排列的结果
     */
    public void dfs(int n, boolean[] used, int depth, List<Integer> path, List<List<Integer>> permute) {

        //退出条件：n个数全部排完后，就退出
        if (depth == n) {
            permute.add(path);
            return;
        }

        for (int i = 0; i < n; i++) {
            //如果没有使用过，就添加进去，使用过的，向后循环
            if (!used[i]) {
                path.add(i);
                used[i] = true;
                //当选定一个数字在当前位置后，需要递归后面的数字，生成路径，直到第n层，完整路径
                dfs(n, used, depth + 1, path, permute);

                //当本次递归选数完成后，退出去前，需要回到递归前的状态
                used[i] = false;
                path.remove(path.size() - 1);

            }

        }

    }

    /**
     * 对全排列，看什么排列符合要求
     *
     * @param permute
     * @param n
     * @return
     */
    public List<List<String>> check(List<List<Integer>> permute, int n) {

        List<List<String>> result = new ArrayList<>();
        for (List<Integer> list : permute) {
            boolean is = true;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    //不符合要求时，就退出循环
                    if ((j - i) == Math.abs(list.get(j) - list.get(i))) {
                        is = false;
                        break;
                    }
                }
                if (!is) break;
            }
            //不符合要求，开始下一个循环
            if (!is) continue;

            List<String> row = new ArrayList<>();
            //将符合要求的排列转换成最终结果
            for (int i = 0; i < n; i++) {
                int index = list.get(i);
                //List<String> row = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == index) sb.append("Q");
                    else sb.append(".");
                }
                row.add(sb.toString());
            }
            result.add(row);
        }
        return result;
    }

    public static void main(String args[]) {
        NQueens_51 queens_51 = new NQueens_51();
        System.out.println(queens_51.solveNQueens(4));
    }


}
