package com.sjiyuan.tree.recursion;

import com.sjiyuan.tree.TreeNode;

/**
 * 求二叉树的直径
 * 任何两个叶子节点路径均可看作，某一节点到左叶子节点的路径，加上右叶子节点的路径
 */
public class DiameterOfBinaryTree_543 {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        depth(root);
        return max;
    }

    /**
     * 104题，定义高度是，根节点到最远叶子节点的最长路径上的节点数，叶子节点的高度是1
     * 还有定义高度是，根节点到叶子节点的最长简单路径边的条数，那叶子节点的高度为0
     *
     * @return
     */
    public int depth(TreeNode root) {

        if (root == null) return 0;
        /**
         * 求出左右的高度
         */
        int lDepth = depth(root.left);
        int rDepth = depth(root.right);
        /**
         * 求出此节点高度的同时，算出此节点的最大路径，全局变量存储，不断的更新
         * 求直径，左子树高度，加上右子树高度 + 1（本节点） - 1（路径和，节点和-1）
         */
        max = Math.max(lDepth + rDepth + 1 - 1, max);
        return Math.max(lDepth, rDepth) + 1;
    }

}
