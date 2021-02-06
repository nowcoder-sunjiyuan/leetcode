package com.sjiyuan.graph.topological;

import com.sun.jmx.snmp.SnmpUnknownMsgProcModelException;

import java.util.*;

/**
 * @program: LeetCode
 * @description: 课程表2
 * @author: 孙济远
 * @create: 2021-02-04 11:11
 */
public class CanFinish_210 {

    private List<List<Integer>> edges;
    /**
     * 0：代表还未搜索，1：搜索中，2：搜索完成
     */
    private int[] visited;
    private static final Stack<Integer> stack = new Stack<>();

    /**
     * 返回拓扑排序，用栈来实现
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        visited = new int[numCourses];
        Arrays.fill(visited, 0);
        /**
         * 构造图
         */
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[1]).add(prerequisite[0]);
        }


        //深度遍历去访问所有节点
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                boolean dfs = dfs(i);
                if(!dfs) return new int[0];
            }
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = stack.pop();
        }

        return result;

    }

    public boolean dfs(int node) {
        //搜索中
        visited[node] = 1;

        for (int temp : edges.get(node)) {
            if (visited[temp] == 1) {
                //说明存在环
                return false;
            } else if (visited[temp] == 0) {
                //可以深度遍历
                boolean dfs = dfs(temp);
                if(!dfs) return false;
            }
        }
        //它的孩子都遍历完了，将这个节点设置为访问完成，并加入栈中
        visited[node] = 2;
        stack.push(node);
        return true;
    }


    public static void main(String[] args) {
        CanFinish_210 canFinish_210 = new CanFinish_210();
        int[] order = canFinish_210.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}});
        System.out.println(order);

    }
}
