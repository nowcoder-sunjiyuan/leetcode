package com.sjiyuan.tree;


import java.util.Stack;

/**
 * @ClassName IsSubTree_572
 * @Description TODO 另一棵树的子树
 * @Author sjy
 * @Date 2020/1/23 18:20
 * @Version 1.0
 **/
public class IsSubTree_572 {
    /**
     * 先先序遍历，有相等的节点，再判断其子树是否相同
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Stack<TreeNode> stack = new Stack<>();
        SameTree_100 sameTree_100 = new SameTree_100();

        while (s != null || !stack.isEmpty()) {
            if (s != null) {
                stack.push(s);
                if (s.val == t.val) {
                    if (sameTree_100.isSameTree(s, t)) {
                        return true;
                    }
                }
                s = s.left;
            } else {
                TreeNode pop = stack.pop();
                s = pop.right;
            }
        }

        return false;
    }
}
