package com.sjiyuan.dp.question1;

import com.sjiyuan.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description:
 * @author: 孙济远
 * @create: 2021-03-24 01:15
 */
public class Rob_337 {
    // 保存当前节点，不在偷盗里，最高的金额
    Map<TreeNode, Integer> f = new HashMap<>();
    // 保存当前节点，在偷盗里，最高的金额
    Map<TreeNode, Integer> g = new HashMap<>();
    // 深度遍历
    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.get(root), g.get(root));
    }

    public void dfs(TreeNode node){
        if(node == null) return;
        dfs(node.left);
        dfs(node.right);

        /**
         * 下面用这两行就能实现
         * getOrDefault来给left和right是null时的默认值
         * f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
         * g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
         *
         */
        // 存f,左右节点的最大值
        if(node.left == null) {
            if(node.right == null){
                f.put(node, 0);
                g.put(node, node.val);
            }
            else f.put(node, Math.max(f.get(node.right), g.get(node.right)));
        }else{
            if(node.right == null) {
                f.put(node, Math.max(f.get(node.left), g.get(node.left)));
                g.put(node, node.val + f.get(node.left));
            }
            else {
                f.put(node, Math.max(f.get(node.left), g.get(node.left))
                        + Math.max(f.get(node.right), g.get(node.right)));
                g.put(node, node.val + f.get(node.left) + f.get(node.right));
            }
        }
    }

    public static void main(String[] args) {
        Rob_337 rob_337 = new Rob_337();
    }
}
