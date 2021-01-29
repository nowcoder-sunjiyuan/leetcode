package com.sjiyuan.tree.BinarySearchTree;

/**
 * 求解n个节点二叉搜索树的数量
 */
public class NumBST_96 {
    /**
     * 动态规划
     * G(n): n个节点二叉搜索树的数量（最终求解）
     * F(i, n): 以i为根节点n个节点二叉搜索数的数量（n个包括i）
     * <p>
     * G(n) = F(1, n) + F(2, n) + ... + F(n, n)
     * F(i, n)的值是i为根节点后，左子树数量和右子树数量的笛卡尔积
     * <p>
     * F(i, n) = G({i-1}) * G({n-i})xcv
     * 解释：G({i-1})代表i为根节点后，1节点 - i-1节点二叉搜索树数量，是左子树的二叉搜索树的数量，同理有G({n-i})
     * <p>
     * G(2) = F(1, 2) + F(2, 2)
     * = G(0) * G(1) + G(1) * G(0)
     * G(3) = F(1, 3) + F(2, 3) + F(3, 3)
     * = G(0) * G(2) + G(1) * G(1) + G(2) * G(0)
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        //dp数组
        int[] nums = new int[n + 1];

        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            //表示从根节点是j节点，从1加到i
            for (int j = 1; j <= i; j++) {
                // 内循环为了求F，j代表以j为根节点
                nums[i] += (nums[j - 1] * nums[i - j]);
            }
        }
        return nums[n];
    }

    public static void main(String args[]) {
        NumBST_96 numBST_96 = new NumBST_96();
        int i = numBST_96.numTrees(2);
        System.out.println(i);
    }
}
