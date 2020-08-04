package com.sjiyuan.offer;

/**
 * 判断序列是否是后序遍历序列
 */
public class Subject33 {
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length - 1);
    }

    public boolean verify(int[] postOrder, int start, int end) {
        if (start >= end) return true;
        int root = postOrder[end];
        int left = start;
        for (; postOrder[left] < root && left < end; left++) ;

        int middle = left;

        for (; left < end; left++) {
            if (postOrder[left] < root) return false;
        }
        return verify(postOrder, start, middle - 1) && verify(postOrder, middle, end - 1);
    }

    public static void main(String[] args) {
        int[] postorder = {1, 2, 5, 10, 6, 9, 4, 3};
        Subject33 subject33 = new Subject33();
        boolean b = subject33.verifyPostorder(postorder);
        System.out.println(b);
    }
}
