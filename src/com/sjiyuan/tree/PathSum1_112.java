package com.sjiyuan.tree;

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
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            if(sum == 0) return true;
            else return false;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.left, sum - root.val);
    }
}
