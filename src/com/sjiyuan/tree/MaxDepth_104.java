package com.sjiyuan.tree;

/**
 * @ClassName MaxDepth_104
 * @Description TODO 树的最大深度
 * @Author sjy
 * @Date 2020/2/8 22:05
 * @Version 1.0
 **/
public class MaxDepth_104 {
    /**
     * 递归方法，深入一层，深度加一
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.left.right = new TreeNode(6);

        MaxDepth_104 maxDepth_104 = new MaxDepth_104();
        System.out.println("答案：" + maxDepth_104.maxDepth(root));
    }
}
