package com.sjiyuan.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: 任务调度器
 * @author: 孙济远
 * @create: 2021-03-27 23:43
 */
public class LeastInterval_621 {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < tasks.length; i++){
            int time = map.getOrDefault(tasks[i], 0) + 1;
            if(time > max) max = time;
            map.put(tasks[i], time);
        }
        int maxTime = 0;
        for(int value : map.values()){
            if(value == max) maxTime++;
        }

        int result = (max - 1) * (n + 1) + maxTime;
        return Math.max(result, tasks.length);

    }
}
