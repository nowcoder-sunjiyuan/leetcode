package com.sjiyuan.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FullPermute_46
 * @Description TODO 全排列
 * @Author sjy
 * @Date 2020/1/30 11:43
 * @Version 1.0
 **/
public class FullPermute_46 {
    /**
     * 自己想到的：
     * 循环添加数字，将数字插入所有的已经存在排列中
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        //用temp暂存新的排列
        List<List<Integer>> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 0) return result;
        List<Integer> row = new ArrayList<>();

        row.add(nums[0]);
        result.add(row);
        for (int i = 1; i < nums.length; i++) {
            for (List<Integer> list : result) {
                for (int j = 0; j <= list.size(); j++) {
                    //这里，需要将新元素，添加到j的位置
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(j, nums[i]);
                    //用temp暂存新的排列
                    temp.add(newList);
                }
            }
            //result变成temp，并将temp置空
            result = temp;
            temp = new ArrayList<>();
        }


        return result;
    }

    public static void main(String args[]) {
        int nums[] = {1, 2, 3};

        FullPermute_46 fullPermute_46 = new FullPermute_46();
        List<List<Integer>> permute = fullPermute_46.permute(nums);
    }
}
