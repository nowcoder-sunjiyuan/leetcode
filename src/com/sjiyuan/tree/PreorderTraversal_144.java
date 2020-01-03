package com.sjiyuan.tree;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName PreorderTraversal_144
 * @Description TODO 树的先序遍历
 * @Author sjy
 * @Date 2020/1/2 17:09
 * @Version 1.0
 **/
public class PreorderTraversal_144 {
    /**
     * 递归解法
     * @param root
     * @return
     */
    public List<Integer> preorderRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        recursion(root, result);
        return result;
    }

    public void recursion(TreeNode root, List<Integer> result) {
        if(root == null) return;
        result.add(root.val);
        recursion(root.left, result);
        recursion(root.right, result);
    }


    /**
     * 非递归解法，借用栈来实现
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        /**
         * 节点不为null，并且栈非空的时候循环
         */
        while (root != null || !stack.empty()) {
            if (root != null) {
                /**
                 * 如果节点不为null，进栈，向左走
                 */
                stack.push(root);
                result.add(root.val);
                root = root.left;
            } else {
                /**
                 * 节点为null，提取栈顶的节点，栈顶的节点可能是多种情况（p节点）（画图是不是更好理解？）
                 * 1.null为p的左孩子节点
                 * 2.null为p的孩子的右节点
                 */
                TreeNode pop = stack.pop();
                root = pop.right;
            }
        }
        return result;
    }



}
