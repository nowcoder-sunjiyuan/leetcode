package com.sjiyuan.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DuplicateData_442
 * @Description TODO
 * <p>
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 * <p>
 * 找到所有出现两次的元素。
 * <p>
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 * <p>
 * 示例：
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [2,3]
 * @Author sjy
 * @Date 2019/12/31 23:05
 * @Version 1.0
 **/
public class DuplicateData_442 {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;

        List<Integer> result = new ArrayList<>();
        /**
         * 第几位应该放着几的数字，不是的话就交换，找到重复就记录下来，下一个
         * 具体解释，在剑指offer的数组重复部分P40页
         */
        for (int i = 0; i < n; i++) {

            while (nums[i] != i + 1) {

                if (nums[i] == nums[nums[i] - 1]) {
                    if (!result.contains(nums[i])) {
                        result.add(nums[i]);
                    }
                    break;
                }

                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        return result;
    }


    public static void main(String args[]) {
        int nums[] = {2, 3, 1, 1, 2, 5, 3, 6, 7, 8, 6, 9, 7};
        DuplicateData_442 d = new DuplicateData_442();
        System.out.println("结果：" + d.findDuplicates(nums));
    }
}
