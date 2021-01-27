package com.sjiyuan.graph;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: 判断二分图
 * @author: 孙济远
 * @create: 2021-01-24 16:45
 */
public class IsBipartite_785 {
    private static final int unstained = 0;
    private static final int red = 1;
    private static final int green = 2;
    private int[] colors = null;

    /**
     * 我的想法：深度遍历，不断的染色
     *
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        //代表每个节点的颜色
        colors = new int[graph.length];
        Arrays.fill(colors, unstained);

        /**
         * 这个循环为了防止不是连通图
         */
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == unstained) {
                boolean temp = dfs(i, red, graph);
                if (!temp) return false;
            }
        }
        return true;
    }

    /**
     * @param node  从此节点开始
     * @param color node节点需要的染色
     * @param graph 邻接表矩阵
     * @return
     */
    public boolean dfs(int node, int color, int[][] graph) {


        colors[node] = color;
        int other = color == red ? green : red;

        //遍历node节点连接的节点
        for (int i = 0; i < graph[node].length; i++) {
            //未遍历的（未染色的）才需要遍历
            if (colors[graph[node][i]] == unstained) {
                boolean temp = dfs(graph[node][i], other, graph);
                if (!temp) return false;
            } else if (colors[graph[node][i]] != other) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        IsBipartite_785 isBipartite_785 = new IsBipartite_785();
        System.out.println(isBipartite_785.isBipartite(graph));
    }
}
