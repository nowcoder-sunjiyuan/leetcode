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
        return isValidBST_recursion(root, 0, 0, false, false);
    }

    public boolean isValidBST_recursion(TreeNode node, int upperLimit, int lowerLimit, boolean hasUpper, boolean hasLower) {

        if (node == null) return true;

        int value = node.val;

        if (hasLower && value <= lowerLimit) return false;
        if (hasUpper && value >= upperLimit) return false;

        if (node.left != null) {
            if (node.left.val >= value) return false;
        }
        if (node.right != null) {
            if (node.right.val <= value) return false;
        }

        return isValidBST_recursion(node.left, value, lowerLimit, true, hasLower)
                && isValidBST_recursion(node.right, upperLimit, value, hasUpper, true);
    }
}