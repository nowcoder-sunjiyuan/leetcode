package com.sjiyuan.offer;

import com.sjiyuan.tree.SameTree_100;
import com.sjiyuan.tree.TreeNode;

import java.util.Stack;

/**
 * 树的子结构
 */
public class Subject26 {

    /**
     * 遍历树，如果某个子节点相等，判断子树是否相同
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //非递归遍历这个树
        Stack<TreeNode> stack = new Stack<>();
        if (B == null) return false;
        TreeNode p = A;

        while (p != null || !stack.empty()) {
            if (p != null) {
                stack.push(p);
                if (p.val == B.val) {
                    if (isSameTreeStructure(p, B)) return true;
                }
                //访问完，向左走
                p = p.left;
            } else {
                //如果左节点走到头，取出栈里面的，向右走
                TreeNode pop = stack.pop();
                p = pop.right;
            }
        }
        //没有一个节点符合情况，就返回false
        return false;
    }

    /**
     * B是A的一部分，从A的头节点开始
     * 遍历B，B怎么走，A就怎么走
     * @param A
     * @param B
     * @return
     */
    public boolean isSameTreeStructure(TreeNode A, TreeNode B) {
        Stack<TreeNode> stackA = new Stack<>();
        Stack<TreeNode> stackB = new Stack<>();

        while (B != null || !stackB.empty()) {
            if (B != null) {
                stackA.push(A);
                stackB.push(B);

                if(A == null || A.val != B.val) return false;
                //访问完，向左走
                A = A.left;
                B = B.left;
            } else {
                //如果左节点走到头，取出栈里面的，向右走
                TreeNode popA = stackA.pop();
                TreeNode popB = stackB.pop();
                A = popA.right;
                B = popB.right;
            }
        }
        return true;
    }
}
