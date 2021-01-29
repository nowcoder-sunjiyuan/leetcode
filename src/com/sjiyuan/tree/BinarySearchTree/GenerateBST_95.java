package com.sjiyuan.tree.BinarySearchTree;

import com.sjiyuan.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 求解n个节点二叉搜索树的数量（产生）
 * @author: 孙济远
 * @create: 2021-01-28 12:02
 */
public class GenerateBST_95 {
    public List<TreeNode> generateTrees(int n) {
        /**
         * 构造二叉搜索树，用递归的方法
         */
        return generate(1, n);
    }

    public List<TreeNode> generate(int start, int end) {

        List<TreeNode> result = new ArrayList<>();
        if(start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {

            //构造左子树
            List<TreeNode> leftTree = generate(start, i - 1);
            //构造右子树
            List<TreeNode> rightTree = generate(i + 1, end);

            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode t = new TreeNode(i);
                    t.left = left;
                    t.right = right;
                    result.add(t);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        GenerateBST_95 generateBST_95 = new GenerateBST_95();
        List<TreeNode> treeNodes = generateBST_95.generateTrees(3);

    }
}
