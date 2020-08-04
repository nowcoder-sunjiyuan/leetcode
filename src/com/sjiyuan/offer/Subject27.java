package com.sjiyuan.offer;

import com.sjiyuan.tree.TreeNode;

/**
 * 二叉树镜像
 */
public class Subject27 {

    public TreeNode mirrorTree(TreeNode root) {

        if(root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }
}
