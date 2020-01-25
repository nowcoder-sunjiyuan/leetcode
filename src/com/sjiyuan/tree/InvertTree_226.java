package com.sjiyuan.tree;

import java.util.Stack;

/**
 * @ClassName InvertTree_226
 * @Description TODO 翻转二叉树
 * @Author sjy
 * @Date 2020/1/23 19:23
 * @Version 1.0
 **/
public class InvertTree_226 {
    public TreeNode invertTree(TreeNode root) {

        TreeNode p = root;
        TreeNode pre = null;

        Stack<TreeNode> stack = new Stack<>();

        while (p != null || stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right != null && peek.right != pre) {
                    p = peek.right;
                    stack.push(p);
                    p = p.left;
                } else {
                    TreeNode pop = stack.pop();

                    TreeNode temp = pop.left;
                    pop.left = pop.right;
                    pop.right = temp;

                    pre = pop;
                    p = null;
                }
            }
        }
        return root;
    }
}
