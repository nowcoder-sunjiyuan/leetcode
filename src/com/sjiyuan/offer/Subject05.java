package com.sjiyuan.offer;

/**
 * 替换空格
 */
public class Subject05 {
    /**
     * 方法一：遍历s，新建一个字符串，将需要的字符串拼接进去
     * @param s
     * @return
     */
    public String replaceSpace_1(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
