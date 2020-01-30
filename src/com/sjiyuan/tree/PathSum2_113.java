package com.sjiyuan.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName PathSum2_113
 * @Description TODO 路径总和2
 * @Author sjy
 * @Date 2020/1/26 22:11
 * @Version 1.0
 **/
public class PathSum2_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;
        recursion(root, sum, path, result);

        return result;
    }

    public void recursion(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) {

        list.add(root.val);
        /**
         * 如果，左子树，右子树均为null，说明是叶子节点。
         * 此时如果需要构成sum与root.val相等，则此路径符合条件
         */
        if(root.left == null && root.right == null){
            if (sum == root.val) {
                List<Integer> temp = new ArrayList<>(list);
                result.add(temp);
            }
            return;

        }else if(root.left != null && root.right != null){
            /**
             * 如果左右子树均存在，递归判断是否子树是否符合路径和为 sum-root.val
             * 注意递归出来后，需要删掉list末尾的节点
             */
            recursion(root.left, sum - root.val, list, result);
            list.remove(list.size() - 1);
            recursion(root.right, sum - root.val, list, result);
            list.remove(list.size() - 1);
        }else if(root.left != null){
            recursion(root.left, sum - root.val, list, result);
            list.remove(list.size() - 1);
        }else {
            recursion(root.right, sum - root.val, list, result);
            list.remove(list.size() - 1);
        }

    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(13);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.left = new TreeNode(5);
        root.right.right.right.right = new TreeNode(1);

        PathSum2_113 pathSum2_113 = new PathSum2_113();
        List<List<Integer>> lists = pathSum2_113.pathSum(root, 22);

    }

}
