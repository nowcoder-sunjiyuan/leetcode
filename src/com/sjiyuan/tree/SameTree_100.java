package com.sjiyuan.tree;

import java.util.Stack;

/**
 * @ClassName SameTree_100
 * @Description TODO 相同的树
 * @Author sjy
 * @Date 2020/1/19 22:36
 * @Version 1.0
 **/
public class SameTree_100 {
    /**
     * 判断两个树相等递归实现
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;

        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else return false;
    }

    /**
     * 判断两个树是否相同，非递归代码
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        Stack<TreeNode> stackP = new Stack<>();
        Stack<TreeNode> stackQ = new Stack<>();

        if (p == null && q != null) return false;
        if (q == null && p != null) return false;

        while (p != null || !stackP.isEmpty()){
            if(p != null){
                if(q == null) return false;
                if(p.val != q.val) return false;
                stackP.push(p);
                stackQ.push(q);
                p = p.left;
                q = q.left;
            }else{
                if(q != null) return false;

                p = stackP.pop();
                q = stackQ.pop();

                p = p.right;
                q = q.right;
            }
        }

        return true;
    }

}
