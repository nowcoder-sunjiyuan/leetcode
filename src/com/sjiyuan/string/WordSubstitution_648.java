package com.sjiyuan.string;

import java.util.List;

/**
 * @ClassName WordSubstitution_648
 * @Description TODO 单词替换（字符串）
 * @Author sjy
 * @Date 2020/1/2 16:22
 * @Version 1.0
 **/
public class WordSubstitution_648 {
    /**
     * 普通的遍历解法
     * @param dict
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dict, String sentence) {
        String[] temp = sentence.split(" ");
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < temp.length; i++) {
            //词根长度小于100
            int length = 101;
            String newWord = temp[i];
            for (String d : dict) {
                if (temp[i].startsWith(d)) {
                    if (d.length() < length) {
                        newWord = d;
                        length = d.length();
                    }
                }
            }
            sb.append(newWord);
            if (i != temp.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        WordSubstitution_648 w = new WordSubstitution_648();

    }
}
