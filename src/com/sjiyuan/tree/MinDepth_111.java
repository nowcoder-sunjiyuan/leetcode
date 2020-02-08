package com.sjiyuan.tree;

/**
 * @ClassName MinDepth_111
 * @Description TODO 树的最小深度
 * @Author sjy
 * @Date 2020/2/8 22:27
 * @Version 1.0
 **/
public class MinDepth_111 {
    /**
     *
     * 此方法是不能AC的，错误例子，[1,2]最小深度算2，不是1，解释貌似是，根节点不算叶子节点
     * 要注意！！！！！，这个方法是错误的！！！！
     * 只有左孩子与右孩子均为null时，此节点向上贡献的深度才是1，只要存在孩子不为null，就不是1
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        return Math.min(leftDepth, rightDepth) + 1;
    }

    /**
     * 正确做法，递归实现
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if ((root.left == null) && (root.right == null)) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth2(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth2(root.right), min_depth);
        }

        return min_depth + 1;
    }


    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.left.right = new TreeNode(6);

        MinDepth_111 minDepth_111 = new MinDepth_111();
        System.out.println("答案：" + minDepth_111.minDepth(root));
    }
}
