package com.sjiyuan.string;

import sun.text.normalizer.Trie;

import java.util.ArrayList;
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
     *
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


    /**
     * 构造字典树解析
     *
     * @param dict
     * @param sentence
     * @return
     */
    public String replaceWordsTire(List<String> dict, String sentence) {

        TrieNode trie = new TrieNode();
        /**
         * 构造字典树
         *  遍历字典里每一个字符串，遍历字符串中每个字符，
         */
        for (String root : dict) {
            /**
             * 从trie节点开始，trie节点不放任何数据是空的
             */
            TrieNode cur = trie;
            for (char letter : root.toCharArray()) {
                if (cur.next[letter - 'a'] == null) {
                    cur.next[letter - 'a'] = new TrieNode();
                }
                //让当前节点指向子节点，往下延伸
                cur = cur.next[letter - 'a'];
            }
            //最后的叶子节点记录字符串的值
            cur.word = root;
        }

        /**
         * 替换sentence中的内容
         */
        StringBuilder sb = new StringBuilder();

        for (String word : sentence.split(" ")) {
            //在sb不空时，先加个空格
            if (sb.length() > 0) sb.append(" ");

            TrieNode cur = trie;
            for (char letter : word.toCharArray()) {
                if (cur.next[letter - 'a'] != null) {
                    cur = cur.next[letter - 'a'];
                    /**
                     * 找到最短匹配的时候，就退出去，然后退出去
                     */
                    if (cur.word != null) {
                        break;
                    }
                } else {
                    //只要有开始不匹配的，就退出循环，没有匹配
                    break;
                }
            }
            /**
             * 如果cur.word存在，说明找到匹配的之后，break出去的
             * cur.word不存在，说明字符串不匹配，用原字符串
             */
            if (cur.word != null) {
                sb.append(cur.word);
            } else {
                sb.append(word);
            }


        }

        return sb.toString();
    }

    public static void main(String args[]) {
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        WordSubstitution_648 w = new WordSubstitution_648();
        String s = w.replaceWordsTire(dict, "the cattle was rattled by the battery");
        System.out.println("结果：" + s);
    }

}


class TrieNode {

    public TrieNode[] next;    //该节点的下一个节点
    public String word;        //到叶子节点，这个单词是什么

    public TrieNode() {
        next = new TrieNode[26]; //一共可能有26个节点，只考虑小写字母
    }
}




