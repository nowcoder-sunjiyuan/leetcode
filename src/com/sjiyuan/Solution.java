package com.sjiyuan;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (stack.peek() != null) {
            if (stack.peek().left != null) {
                stack.add(stack.peek().left);
                continue;
            } else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                if (pop.right != null) {
                    stack.add(pop.right);
                    continue;
                } else {
                    if (!stack.isEmpty()) {
                        stack.peek().left = null;
                    }
                    continue;
                }
            }
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val , TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}