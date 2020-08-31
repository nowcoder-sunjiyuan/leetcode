package com.sjiyuan.tree;

import java.util.*;

/**
 * 二叉树展开成单链表（看教程）
 * 右子树展开（这道题有点歧义）
 */
public class Flatten_114 {
    public void flatten(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return;

        Deque<TreeNode> stack = new LinkedList<>();
        //上一个访问的前节点
        TreeNode pre = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            /**
             * 对于已经访问过的节点，可以改变他的左右子树了
             */
            if(pre != null){
                pre.left = null;
                pre.right = curr;
            }

            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
            //这里访问
            result.add(curr.val);
            pre = curr;
        }
        return;
    }
}
