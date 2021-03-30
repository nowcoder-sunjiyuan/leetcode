package com.sjiyuan;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: LeetCode
 * @description:
 * @author: 孙济远
 * @create: 2021-03-29 20:03
 */
public class Test4 {
    private static Set<String> result = new HashSet<>();

    public static Set<String> showMap(Map<String, Object> map) {
        //TODO your code goes here...

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            recursion(entry.getValue(), entry.getKey());
        }
        return result;
    }

    public static void recursion(Object object, String sb) {
        if (object instanceof Map) {
            Map<String, Object> map = (Map) object;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                recursion(entry.getValue(), sb + "." + entry.getKey());
            }
        } else if (object instanceof Object[]) {
            Object[] temp = (Object[]) object;
            for (int i = 0; i < temp.length; i++) {
                recursion(temp[i], sb + "[" + i + "]");
            }
        } else {
            String s;
            if (object == null) {
                s = sb + " = null";
            } else {
                s = sb + " = " + object.toString();
            }
            result.add(s);
        }
    }

    public static void main(String[] args) {
        Map<String, Object> input = new HashMap<>();
        Map<String, Object> temp = new HashMap<>();
        temp.put("b", 3);
        temp.put("c", "haha");
        input.put("a", new Object[]{1, null, new Object[]{1, 4, temp}});
        input.put("d", temp);
        Set<String> strings = Test4.showMap(input);
        for(String c : strings){
            System.out.println(c);
        }
    }
}
