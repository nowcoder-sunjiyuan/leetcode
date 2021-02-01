package com.sjiyuan.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 课程表
 * @author: 孙济远
 * @create: 2021-01-31 11:34
 */
public class CanFinish_207 {
    // 表示图
    List<List<Integer>> edges;
    /**
     * 图中节点的状态
     * 0：代表还未访问，1：访问过程中，2：代表访问过了
     */
    int[] visited;


    /**
     * 算法
     *
     * 对于图中的任意一个节点，它在搜索的过程中有三种状态，即：
     * 「未搜索」：我们还没有搜索到这个节点；
     * 「搜索中」：我们搜索过这个节点，但还没有回溯到该节点，即该节点还没有入栈，还有相邻的节点没有搜索完成）；
     * 「已完成」：我们搜索过并且回溯过这个节点，即该节点已经入栈，并且所有该节点的相邻节点都出现在栈的更底部的位置，满足拓扑排序的要求。
     * 通过上述的三种状态，我们就可以给出使用深度优先搜索得到拓扑排序的算法流程，在每一轮的搜索搜索开始时，我们任取一个「未搜索」的节点开始进行深度优先搜索。
     *
     * 我们将当前搜索的节点 u 标记为「搜索中」，遍历该节点的每一个相邻节点v：
     * 如果 v 为「未搜索」，那么我们开始搜索 v，待搜索完成回溯到 u；
     * 如果 v 为「搜索中」，那么我们就找到了图中的一个环，因此是不存在拓扑排序的；
     * 如果 v 为「已完成」，那么说明 v 已经在栈中了，而 u 还不在栈中，因此 u 无论何时入栈都不会影响到 (u, v)(u,v) 之前的拓扑关系，以及不用进行任何操作。
     * 当 u 的所有相邻节点都为「已完成」时，我们将 u 放入栈中，并将其标记为「已完成」。
     *
     * 在整个深度优先搜索的过程结束后，如果我们没有找到图中的环，那么栈中存储这所有的 n 个节点，从栈顶到栈底的顺序即为一种拓扑排序。
     */


    /**
     * 拓扑排序类题目
     * 此处是判断这个图中是否有环
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        visited = new int[numCourses];
        for (int[] val : prerequisites) {
            //给图设置边
            edges.get(val[1]).add(val[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            boolean dfs = dfs(i);
            if (!dfs) return false;
        }

        return true;
    }

    /**
     * 深度优先访问
     *
     * @param node
     * @return
     */
    public boolean dfs(int node) {
        visited[node] = 1;
        //遍历连接的节点
        for (int v : edges.get(node)) {

            if (visited[v] == 0) {
                boolean dfs = dfs(v);
                if (!dfs) return false;
            } else if (visited[v] == 1) {
                //说明存在环
                return false;
            }
        }
        visited[node] = 2;
        return true;
    }

    public static void main(String[] args) {
        CanFinish_207 canFinish_207 = new CanFinish_207();
        int[][] temp = {{0, 1}};
        System.out.println(canFinish_207.canFinish(2, temp));

    }
}
