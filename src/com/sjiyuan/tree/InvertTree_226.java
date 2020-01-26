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

        while (p != null || !stack.isEmpty()) {
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


    public static void main(String args[]) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        InvertTree_226 invertTree_226 = new InvertTree_226();
        TreeNode treeNode = invertTree_226.invertTree(root);
    }
}
