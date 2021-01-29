package com.sjiyuan.search.BFS;

import com.sun.prism.shader.AlphaOne_RadialGradient_AlphaTest_Loader;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @program: LeetCode
 * @description: 单词接龙（BFS，图）
 * @author: 孙济远
 * @create: 2021-01-29 10:11
 */
public class WordChain_127 {

   /* // 每个单词一个标识
    Map<String, Integer> wordId = new HashMap<>();
    //构造图的边
    List<List<Integer>> edge = new ArrayList<List<Integer>>();
*/

    /**
     * 构造图，然后用BFS的方式，找到最短路径
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) return 0;

        int length = wordList.size();
        // 临界矩阵，构造图
        int[][] adjacency = new int[length][length];
        //List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Arrays.fill(adjacency[i], 0);
            for (int j = 0; j < length; j++) {
                if (j == i) continue;
                if (check(wordList.get(i), wordList.get(j))) {
                    adjacency[i][j] = 1;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        // 存距离
        int[] distance = new int[length];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int i = 0; i < length; i++) {
            if (check(wordList.get(i), beginWord)) {
                if (wordList.get(i).equals(endWord)) return 2;
                distance[i] = 2;
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (int i = 0; i < length; i++) {
                /**
                 * 找相连接的节点，并且没访问过的节点
                 */
                if (adjacency[poll][i] == 1 && distance[i] == Integer.MAX_VALUE) {
                    distance[i] = distance[poll] + 1;
                    if (wordList.get(i).equals(endWord)) return distance[i];
                    queue.offer(i);
                }
            }
        }
        return 0;
    }


    /**
     * 检查两个单词是否需要连接
     *
     * @return
     */
    public boolean check(String a, String b) {

        if (a.length() != b.length()) return false;
        else {
            int time = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    time++;
                    if (time > 1) return false;
                }
            }
            return time != 0;
        }
    }

    /**
     * "hit"
     * "cog"
     * ["hot","dot","dog","lot","log","cog"]
     * @param args
     */
    public static void main(String[] args) {
        WordChain_127 wordChain_127 = new WordChain_127();
        List<String> p = new ArrayList<>();
        p.add("hot");
        p.add("dot");
        p.add("dog");
        p.add("lot");
        p.add("log");
        p.add("cog");
        wordChain_127.ladderLength("hit", "cog", p);
    }
}
