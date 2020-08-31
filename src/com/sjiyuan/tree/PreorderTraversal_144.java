package com.sjiyuan.tree;


import java.util.*;

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
     *
     * @param root
     * @return
     */
    public List<Integer> preorderRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        recursion(root, result);
        return result;
    }

    public void recursion(TreeNode root, List<Integer> result) {
        if (root == null) return;
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

    /**
     * 非递归方法，第二种实现方式
     * @param root
     * @return
     */
    public List<Integer> preorder2(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) return null;

        Deque<TreeNode> stack = new LinkedList<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
            //这里访问
            result.add(curr.val);
        }
        return result;
    }

    public static void main(String args[]) {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);

        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;

        PreorderTraversal_144 preorderTraversal_144 = new PreorderTraversal_144();
        System.out.println("输出：" + preorderTraversal_144.preorder2(a));
    }


}
