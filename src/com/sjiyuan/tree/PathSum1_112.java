package com.sjiyuan.tree;

import java.util.List;

/**
 * @ClassName PathSum1_112
 * @Description TODO 路径总和1
 * @Author sjy
 * @Date 2020/1/26 22:02
 * @Version 1.0
 **/
public class PathSum1_112 {
    /**
     * 只是判断是否存在路径总和是sum的路径
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(13);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.left = new TreeNode(5);
        root.right.right.right.right = new TreeNode(1);

        PathSum1_112 pathSum1_112 = new PathSum1_112();
        boolean b = pathSum1_112.hasPathSum(root, 22);

    }


}
