package com.sjiyuan.offer;

import com.sjiyuan.tree.TreeNode;

/**
 * 重建二叉树
 * 通过前序和中序创建二叉树
 */
public class Subject07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        TreeNode treeNode = new TreeNode();
        int length = preorder.length;
        if (length == 0) return null;
        buildRecursion(treeNode, preorder, inorder, 0, length - 1, 0, length - 1);

        return treeNode;
    }

    /**
     * 递归在treeNode下创建二叉树
     *
     * @param treeNode
     * @param preorder
     * @param inorder
     * @param i1       前序数组的开头
     * @param i2       前序数组的结尾
     * @param j1       中序数组的开头
     * @param j2       中序数组的结尾
     */
    public void buildRecursion(TreeNode treeNode, int[] preorder, int[] inorder, int i1, int i2, int j1, int j2) {
        int j;
        //前序数组的第一个就是根节点
        treeNode.val = preorder[i1];
        //此时说明没有叶子节点了
        if (i1 == i2) return;
        //找到中序数组中根节点的位置，j的左边在二叉树的左边，j的右边在二叉树的右边
        for (j = j1; j <= j2; j++) {
            if (preorder[i1] == inorder[j]) break;
        }
        /**
         * 前序遍历 preorder = [3,9,20,15,7]
         * 中序遍历 inorder = [9,3,15,20,7]
         */

        //存在左子树
        if (j1 < j) {
            int length = j - j1;
            treeNode.left = new TreeNode();
            //递归建立左子树
            buildRecursion(treeNode.left, preorder, inorder, i1 + 1, i1 + length, j1, j1 + length - 1);
        }
        //存在右子树
        if (j < j2) {
            int length = j2 - j;
            treeNode.right = new TreeNode();
            //递归建立右子树
            buildRecursion(treeNode.right, preorder, inorder, i2 - length + 1, i2, j + 1, j2);
        }
    }
}
