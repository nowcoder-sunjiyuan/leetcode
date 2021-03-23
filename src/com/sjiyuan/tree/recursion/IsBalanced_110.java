package com.sjiyuan.tree.recursion;

import com.sjiyuan.tree.TreeNode;

import java.util.Stack;

/**
 * @ClassName IsBalanced_110
 * @Description TODO 判断是否是平衡树
 * @Author sjy
 * @Date 2020/2/8 22:40
 * @Version 1.0
 **/
public class IsBalanced_110 {

    /**
     * 遍历每一个节点，求左右子树的深度，然后做差，判断是否是平衡树，这种方法麻烦
     */

    /**
     * 递归实现，本来需要返回两个数据，左右子树是否是平衡树，和左右子树的最大深度。
     * 现在返回int值，如果为-1，代表不是平衡树，大于等于零，代表树的深度
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return recursion(root) != -1;
    }

    public int recursion(TreeNode node) {
        if (node == null) return 0;

        int left = recursion(node.left);
        if (left == -1) return -1;

        int right = recursion(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;
        else return Math.max(left, right) + 1;
    }
}
