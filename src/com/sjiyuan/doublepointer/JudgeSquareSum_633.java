package com.sjiyuan.doublepointer;

/**
 * 平方数之和
 */
public class JudgeSquareSum_633 {
    /**
     * 我的想法：
     * 双指针，一大一小，平方和大了，大的向小的移动，平方和小了，小的向大的移动
     * 结果：超时
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        int start = 0;
        int end = (int) Math.sqrt(c);
        while (start <= end) {
            int result = start * start + end * end;
            if(result == c) return true;
            else if(result < c) start++;
            else end--;
        }

        return false;
    }




    public static void main(String[] args) {
        JudgeSquareSum_633 judgeSquareSum_633 = new JudgeSquareSum_633();
        System.out.println(judgeSquareSum_633.judgeSquareSum(3));
    }
}
