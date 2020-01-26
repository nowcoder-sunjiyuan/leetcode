package com.sjiyuan.tree;

import com.sjiyuan.list.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName PostorderTraversal_145
 * @Description TODO 二叉树后序遍历
 * @Author sjy
 * @Date 2020/1/3 19:48
 * @Version 1.0
 **/
public class PostorderTraversal_145 {
    public List<Integer> postorderRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursion(root, list);
        return list;
    }

    public void recursion(TreeNode node, List<Integer> list) {
        if (node == null) return;
        recursion(node.left, list);
        recursion(node.right, list);
        list.add(node.val);
    }

    /**
     * 后序遍历的非递归算法
     * @param root
     * @return
     */
    public List<Integer> postorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        TreeNode p = root;
        /**
         * 上一个访问的节点，判断栈里的最上面节点是左节点回来的，还是右节点访问完回来的
         */
        TreeNode pre = null;

        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                /**
                 * 思想：
                 * 先看看栈顶的节点，如果这个节点的右节点存在，并且没被访问过，需要向右走
                 * 如果这个节点没右节点，或者，右节点访问过了，就访问此节点
                 */
                p = stack.peek();
                if (p.right != null && p.right != pre) {
                    p = p.right;
                    stack.push(p);
                    p = p.left;
                } else {
                    /**
                     * 此节点右节点不存在，可以访问此节点
                     * 右节点存在且访问过，也可以访问此节点
                     */
                    TreeNode pop = stack.pop();
                    result.add(pop.val);

                    pre = pop;
                    p = null;
                }
            }
        }
        return result;
    }
}
