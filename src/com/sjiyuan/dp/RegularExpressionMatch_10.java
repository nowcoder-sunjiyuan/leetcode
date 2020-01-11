package com.sjiyuan.dp;

/**
 * @ClassName RegularExpressionMatch_10
 * @Description TODO 正则表达式匹配（递归法，动态规划）
 * @Author sjy
 * @Date 2019/12/27 20:10
 * @Version 1.0
 **/
public class RegularExpressionMatch_10 {

    public boolean isMatch_Recursion(String s, String p) {

        int sLength = s.length();
        int pLength = p.length();


        /**
         * 退出递归条件
         * s的长度为0时，p的形式必须是偶数位（包含0位），且a*b*c*的形式，即2,4,6...位必须是*，匹配，否则不匹配
         * s的长度不为0时，p长度为0则不匹配
         */
        if (sLength == 0) {
            if (pLength % 2 == 1) return false;
            for (int i = 1; i < pLength; i = i + 2) {
                if (p.charAt(i) != '*') return false;
            }
            return true;
        }
        if (pLength == 0) return false;

        if (p.charAt(pLength - 1) == '.' || p.charAt(pLength - 1) == s.charAt(sLength - 1)) {
            /**
             * 如果p的最后一位，和s的最后一位相等，或者p的最后一位为'.',直接比较s除去最后一位和p除去最后一位是否匹配
             */
            return isMatch_Recursion(s.substring(0, sLength - 1), p.substring(0, pLength - 1));
        } else if (p.charAt(pLength - 1) == '*') {
            /**
             * 如果p的最后一位是*，并且p的倒数第二位与s的最后一位相等，或者p的倒数第二位为'.'，分三种情况
             * 1.看s除去最后一位，和p是否匹配，即最后的X*依然有用
             * 2.看s除去最后一位，和p除去后两位后是否匹配，即X*没用了
             * 3.看s，和p除去后两位后是否匹配，即X*虽然有用，但没用
             */
            if (s.charAt(sLength - 1) == p.charAt(pLength - 2) || p.charAt(pLength - 2) == '.') {

                return isMatch_Recursion(s.substring(0, sLength - 1), p)
                        || isMatch_Recursion(s.substring(0, sLength - 1), p.substring(0, pLength - 2))
                        || isMatch_Recursion(s, p.substring(0, pLength - 2));
            } else {
                /**
                 * p的最后一位是*，倒数第二位不与最后一位相等，此时看p除去后两位（X*），是否与s匹配
                 */
                return isMatch_Recursion(s, p.substring(0, pLength - 2));
            }
        }
        //此时代表没有匹配的可能
        return false;
    }


    public boolean isMatch_dp(String s, String p) {

        int sLength = s.length();
        int pLength = p.length();

        /**
         * match[i][j]代表s的0 - i-1与p的0 - j-1位匹配的情况
         * java数组中boolean数组默认全false
         */
        boolean[][] match = new boolean[sLength + 1][pLength + 1];

        /**
         * match[0][0]代表s字符串与p字符串为空的情况
         */
        match[0][0] = true;
        /**
         * 如果s的字符串不为空，但是p为空的时候，均不匹配
         */
        /*for (int i = 1; i < sLength + 1; i++) {
            match[i][0] = false;
        }*/
        /**
         * 在s字符串为空时，p的长度为奇数个数的，均不匹配
         */
        /*for (int j = 1; j < pLength + 1; j = j + 2) {
            match[0][j] = false;
        }*/

        for (int i = 0; i < sLength + 1; i++) {
            for (int j = 1; j < pLength + 1; j++) {

                /**
                 * 如果s不是空串，而且p的第j位是‘.’或者与s的第i位相等，此时
                 * s的i位 与 p的j位匹配情况与
                 * s的j-1位 与 p的j-1位匹配情况相同
                 */
                if (i > 0 && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1))) {
                    match[i][j] = match[i - 1][j - 1];
                }

                /**
                 * p的j位为*，分情况
                 * 1.s为空串时，匹配情况与p-2位匹配情况相同（主要是矩阵的第一行）
                 * 2.如果s的i位与p的j-1位不相同，且p的j-1位不为'.'
                 *      此时s的第i位与p的j位匹配情况 与 s的i位与p的j-2位匹配情况相同
                 * 3.如果s的i位与p的j-1位相同，或者p的j-1位为'.'
                 *      1.s的i位，与p的j-1位的匹配情况
                 *      2.s的i位，与p的j-2位的匹配情况
                 *      3.s的i-1位，与p的j位的匹配情况
                 *      以上三种情况，有一种情况匹配，结果就匹配
                 */
                if (p.charAt(j - 1) == '*') {

                    if (i == 0 || (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.')) {
                        match[i][j] = match[i][j - 2];
                    } else if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        match[i][j] = match[i][j - 1] || match[i][j - 2] || match[i - 1][j];
                    }
                }


            }
        }
        return match[sLength][pLength];
    }


    public static void main(String args[]) {
        RegularExpressionMatch_10 r = new RegularExpressionMatch_10();
        System.out.println("是否匹配：" + r.isMatch_dp("", "aa*"));
    }
}
