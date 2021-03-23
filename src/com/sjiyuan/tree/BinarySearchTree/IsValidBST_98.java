package com.sjiyuan.tree.BinarySearchTree;

import com.sjiyuan.tree.TreeNode;

/**
 * @ClassName IsValidBST_98
 * @Description TODO 验证二叉搜索树
 * @Author sjy
 * @Date 2020/2/7 22:16
 * @Version 1.0
 **/
public class IsValidBST_98 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST_recursion(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean isValidBST_recursion(TreeNode node, long upperLimit, long lowerLimit) {

        if (node == null) return true;

        int value = node.val;

        if (value <= lowerLimit) return false;
        if (value >= upperLimit) return false;

        if (node.left != null) {
            if (node.left.val >= value) return false;
        }
        if (node.right != null) {
            if (node.right.val <= value) return false;
        }

        return isValidBST_recursion(node.left, value, lowerLimit)
                && isValidBST_recursion(node.right, upperLimit, value);
    }
}