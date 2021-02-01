package com.sjiyuan.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeetCode
 * @description:
 * @author: 孙济远
 * @create: 2021-01-30 11:56
 */
public class ContainsDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            if(set.contains(i)) return true;
            else set.add(i);
        }
        return false;
    }
}
