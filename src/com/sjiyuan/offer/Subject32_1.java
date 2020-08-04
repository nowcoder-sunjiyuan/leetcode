package com.sjiyuan.offer;

import com.sjiyuan.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印二叉树1
 */
public class Subject32_1 {
    /**
     * 这不是层次遍历吗
     *
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        ArrayList<Integer> tempResult = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return new int[0];
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            tempResult.add(poll.val);
            if (poll.left != null) {
                queue.offer(poll.left);
            }

            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        //流操作完成ArrayList转化成
        int[] result = tempResult.stream().mapToInt(Integer::valueOf).toArray();
        return result;
    }
}
