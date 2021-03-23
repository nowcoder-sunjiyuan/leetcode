package com.sjiyuan.tree.recursion;

import com.sjiyuan.tree.TreeNode;

/**
 * @program: LeetCode
 * @description: 自己直接就写出来了，还行
 * @author: 孙济远
 * @create: 2021-03-22 01:45
 */
public class LowestCommonAncestor_236 {
    TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        check(root, p, q);
        return result;
    }

    public boolean check(TreeNode node, TreeNode p, TreeNode q){
        if(node == null) return false;
        boolean left = check(node.left, p, q);
        boolean right = check(node.right,p ,q);
        if(left && right || ((left || right) && (node == p || node == q))) {
            result = node;
            return false;
        }
        if(node == p || node == q || left || right) return true;
        return false;
    }
}
