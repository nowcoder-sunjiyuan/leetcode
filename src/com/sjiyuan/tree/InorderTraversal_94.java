package com.sjiyuan.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName InorderTraversal_94
 * @Description TODO 二叉树的中序遍历
 * @Author sjy
 * @Date 2020/1/2 18:03
 * @Version 1.0
 **/
public class InorderTraversal_94 {
    /**
     * 递归解法
     * @param root
     * @return
     */
    public List<Integer> inorderRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        recursion(root, result);
        return result;
    }

    public void recursion(TreeNode root, List<Integer> result) {
        if(root == null) return;
        recursion(root.left, result);
        result.add(root.val);
        recursion(root.right, result);
    }
}

