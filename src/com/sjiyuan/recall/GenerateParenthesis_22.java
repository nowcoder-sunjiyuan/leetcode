package com.sjiyuan.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCode
 * @description:
 * @author: 孙济远
 * @create: 2021-03-22 00:21
 */
public class GenerateParenthesis_22 {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        generate("", n, n);
        return result;

    }

    public void generate(String s, int left, int right){
        if(left == 0){
            for(int i = 0; i < right; i++){
                s = s + ")";
            }
            result.add(s);
            return;
        }
        if(left <= right){
            generate(s + "(", left - 1, right);
            generate(s + ")", left, right - 1);
        }
    }
}
