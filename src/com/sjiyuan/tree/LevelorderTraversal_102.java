package com.sjiyuan.tree;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @ClassName LevelorderTraversal_102
 * @Description TODO 层次遍历（队列）
 * @Author sjy
 * @Date 2020/1/3 20:00
 * @Version 1.0
 **/
public class LevelorderTraversal_102 {

    /**
     * 用队列实现层次遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return list;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int rowLength = queue.size();
            List<Integer> row = new ArrayList<>();
            //跟不分行的区别，其实就是提前统计好每一行的个数，用循环控制
            while (rowLength > 0) {
                TreeNode poll = queue.poll();
                row.add(poll.val);
                if(poll.left != null) queue.offer(poll.left);
                if(poll.right != null) queue.offer(poll.right);
                rowLength--;
            }
            list.add(row);

        }

        return list;
    }

    public static void main(String args[]) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        LevelorderTraversal_102 l = new LevelorderTraversal_102();
        System.out.println("输出：" + l.levelOrder(null));
    }
}
