package com.sjiyuan.array;

import java.util.*;

/**
 * 三数之和
 */
public class ThreeSum_15 {
    /**
     * 本质上还是三重循环遍历（看算法自己写的版本）
     * 第一层循环定一个数，第二层循环两个指针（一个从第一个数开始，一个从末尾向前开始）
     * 中间前两次循环是需要去除重复，第三次的从末尾开始的指针不需要
     * <p>
     * 结果：超时
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = nums.length - 1;
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        result.add(list);
                        //如果说找到了，左边都比nums[k]小，相加已经不可能等于0，跳出循环
                        break;
                    }
                    k--;
                }
            }

        }

        return result;
    }

    /**
     * 上面方法更好的优化
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        /**
         * study:
         * Collections.emptyList()返回空集合，如果这个集合保证永远是空
         * new完不加，还会有初始内存，效率略微低
         * 此方法add抛异常
         */
        if (nums.length < 3) return Collections.emptyList();
        ArrayList<List<Integer>> result = new ArrayList<>();
        //从小到大排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //如果大于0，排序数组后面都比它大，相加不可能为0
            if (nums[i] > 0) return result;
            //重复的元素就不考虑了
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            /**
             * 接下来的问题变成了，排序数组，两个数相加为某数的情况
             */
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int temp = nums[i] + nums[j] + nums[k];
                if (temp == 0) {

                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    //找到了以后，j的左边和k的右边都不可能，往中间去，看是否有其他的符合情况的
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (temp > 0) {
                    //结果大于0，说明太大了，需要把数变小，即移动k，把k位数变小
                    k--;
                } else {
                    //结果小于0 ，说明太小了，需要把数变大，移动j
                    j++;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        ThreeSum_15 threeSum_15 = new ThreeSum_15();
        List<List<Integer>> lists = threeSum_15.threeSum2(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }

}
