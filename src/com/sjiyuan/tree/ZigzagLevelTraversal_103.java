package com.sjiyuan.tree;

import java.util.*;

/**
 * @ClassName ZigzagLevelTraversal_103
 * @Description TODO 之字形访问树
 * @Author sjy
 * @Date 2020/1/26 17:00
 * @Version 1.0
 **/
public class ZigzagLevelTraversal_103 {

    /**
     * 双栈实现之字访问树
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        //代表访问的顺序，从左到右是true，从右到左是false。最开始，是从第二行开始，是false
        boolean order = false;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        while (true) {
            List<Integer> row = new ArrayList<>();
            while (!stack1.empty()) {
                TreeNode pop = stack1.pop();
                row.add(pop.val);

                if (order) {
                    //奇数行的时候，上一行访问是从右向左的，先把上一行右边的元素的右孩子添加，再左孩子添加，访问时就是先左后右
                    if (pop.right != null) stack2.push(pop.right);
                    if (pop.left != null) stack2.push(pop.left);

                } else {
                    //偶数行的时候，先添加左，再右，访问时先右再左
                    if (pop.left != null) stack2.push(pop.left);
                    if (pop.right != null) stack2.push(pop.right);
                }
            }
            result.add(row);
            order = !order;
            if(stack2.empty()) return result;

            Stack<TreeNode> stack = stack1;
            stack1 = stack2;
            stack2 = stack;
        }
    }
}
