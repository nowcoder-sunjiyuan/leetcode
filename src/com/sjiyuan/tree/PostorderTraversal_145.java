package com.sjiyuan.tree;

import java.util.ArrayList;
import java.util.List;

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

    public void recursion(TreeNode node, List<Integer> list){
        if(node == null) return;
        recursion(node.left, list);
        recursion(node.right, list);
        list.add(node.val);
    }
}
