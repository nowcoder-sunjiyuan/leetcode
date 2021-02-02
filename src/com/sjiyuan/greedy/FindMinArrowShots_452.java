package com.sjiyuan.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: LeetCode
 * @description: 用最少数量的箭引爆气球
 * @author: 孙济远
 * @create: 2021-02-01 11:18
 */
public class FindMinArrowShots_452 {
    /**
     * 与435一样的问题，找不重叠的区间的个数
     * 贪心算法
     *
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        int row = points.length;
        if (row == 0) return 0;

        //先排序
        //这个写法有点高级，回来研究一下
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int result = 1;
        int last = points[0][1];
        for(int i = 1; i < row; i++){
            if(points[i][0] > last) {
                result++;
                last = points[i][1];
            }

        }
        return result;
    }



}
