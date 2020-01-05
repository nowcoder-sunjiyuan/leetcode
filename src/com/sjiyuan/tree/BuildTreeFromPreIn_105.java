package com.sjiyuan.tree;


/**
 * @ClassName BuildTreeFromPreIn_105
 * @Description TODO 从前序与中序序列构造二叉树（不会）
 * @Author sjy
 * @Date 2020/1/5 20:58
 * @Version 1.0
 **/
public class BuildTreeFromPreIn_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode treeNode = new TreeNode();
        buildRecursion(treeNode, preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);

        return treeNode;
    }

    public void buildRecursion(TreeNode treeNode, int[] preorder, int[] inorder, int i1, int i2, int j1, int j2) {
        int j;

        treeNode.val = preorder[i1];
        if (i1 == i2) return;
        for (j = j1; j <= j2; j++) {
            if (preorder[i1] == inorder[j]) break;
        }

        //存在左子树
        if (j1 < j) {
            int length = j - j1;
            treeNode.left = new TreeNode();
            buildRecursion(treeNode.left, preorder, inorder, i1 + 1, i1 + length, j1, j1 + length - 1);
        }
        //存在右子树
        if (j < j2) {
            int length = j2 - j;
            treeNode.right = new TreeNode();
            buildRecursion(treeNode.right, preorder, inorder, i2 - length + 1, i2, j + 1, j2);
        }
    }

    public static void main(String args[]) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        BuildTreeFromPreIn_105 b = new BuildTreeFromPreIn_105();
        b.buildTree(preorder, inorder);
    }
}
