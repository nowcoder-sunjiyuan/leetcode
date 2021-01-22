package com.sjiyuan.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description: 数组中的逆序对
 * @author: 孙济远
 * @create: 2021-01-16 20:10
 */
public class Subject51 {

    private final List<List<Integer>> result = new ArrayList<>();

    /**
     * 用归并排序的方式（分治思想）来实现
     *
     * @param nums
     * @return
     */
    public void reversePairs(int[] nums) {

        reversePairs(nums, 0, nums.length - 1);
        System.out.println("一共" + result.size() + "个逆序对");
        for (List<Integer> temp : result) {
            System.out.print(String.format("(%d,%d) ", temp.get(0), temp.get(1)));
        }
    }


    public void reversePairs(int[] nums, int left, int right) {

        if (left == right) return;
        /**
         * 偶数时，mid取左边那个
         */
        int mid = (left + right) / 2;
        reversePairs(nums, left, mid);
        reversePairs(nums, mid + 1, right);
        /**
         * 在这里，mid左边的都已经排好序了，mid右边也排好序了
         */
        mergeAndCount(nums, left, mid, right);
    }

    /**
     * 排序好的两个
     *
     * @param nums  原数组
     * @param left  左开始
     * @param mid   中间分割
     * @param right 右结束
     */
    public void mergeAndCount(int[] nums, int left, int mid, int right) {

        int[] t = new int[nums.length];

        int lp = left;
        int rp = mid + 1;

        for (int tp = left; tp <= right; tp++) {
            if(lp == mid + 1){
                t[tp] = nums[rp];
                rp++;
            }else if(rp == right + 1){
                t[tp] = nums[lp];
                lp++;
            }else if(nums[lp] <= nums[rp]){
                t[tp] = nums[lp];
                lp++;
            }else{
                //左边大于右边的时候，这时产生逆序对，此时左边的右边全都大
                t[tp] = nums[rp];
                for (int i = lp; i <= mid; i++) {
                    List<Integer> tuple = new ArrayList<>();
                    tuple.add(nums[i]);
                    tuple.add(nums[rp]);
                    result.add(tuple);
                }
                rp++;
            }
        }

        /**
         * 最后把t数组赋值回nums
         */
        System.arraycopy(t, left, nums, left, right + 1 - left);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{11, 0, -14, -7, 17, -2, 16, 22};
        Subject51 subject51 = new Subject51();
        subject51.reversePairs(nums);
    }
}
