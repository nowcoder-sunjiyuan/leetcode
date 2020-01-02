package com.sjiyuan.tree;


import java.util.ArrayList;
import java.util.List;

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
}
