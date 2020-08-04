package com.sjiyuan.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SymmetricTree_101
 * @Description TODO 对称的二叉树
 * @Author sjy
 * @Date 2020/1/25 18:12
 * @Version 1.0
 **/
public class SymmetricTree_101 {
    /**
     * 前序先左后右，前序先右后左。两个序列相同
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> left = new ArrayList<>();
        List<TreeNode> right = new ArrayList<>();
        preorderTraversalLeft(root, left);
        preorderTraversalRight(root, right);
        if(left.size() != right.size()) return false;

        /**
         * 两个序列完全相同才是对称的
         */
        for(int i = 0; i < left.size(); i++){
            if(left.get(i) == null){
                if(right.get(i) != null) return false;
            }else{
                if(right.get(i) == null || right.get(i).val != left.get(i).val) return false;
            }
        }
        return true;
    }

    public void preorderTraversalLeft(TreeNode root, List<TreeNode> result){
        result.add(root);
        if(root == null) return;
        preorderTraversalLeft(root.left, result);
        preorderTraversalLeft(root.right,result);
    }

    public void preorderTraversalRight(TreeNode root, List<TreeNode> result){
        result.add(root);
        if(root == null) return;
        preorderTraversalRight(root.right, result);
        preorderTraversalRight(root.left, result);
    }
}
