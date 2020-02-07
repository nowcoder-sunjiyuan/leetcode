package com.sjiyuan.tree.BinarySearchTree;

import com.sjiyuan.tree.TreeNode;

/**
 * @ClassName SearchBST_700
 * @Description TODO 二叉搜索树中的搜索
 * @Author sjy
 * @Date 2020/2/7 21:51
 * @Version 1.0
 **/
public class SearchBST_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode result = root;

        while (result != null) {

            if (result.val == val) break;
            else if (result.val > val) {
                result = result.left;
            } else {
                result = result.right;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.right = new TreeNode(7);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);

        SearchBST_700 searchBST_700 = new SearchBST_700();
        System.out.println("答案：" + searchBST_700.searchBST(node, 2));
    }
}
