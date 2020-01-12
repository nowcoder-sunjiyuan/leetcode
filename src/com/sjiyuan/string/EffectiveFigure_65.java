package com.sjiyuan.string;

import java.lang.ref.SoftReference;

/**
 * @ClassName EffectiveFigure_65
 * @Description TODO 有效数字，注意容易出错的案例：(未完成)
 * true: '1.'，'.1'，'0e1'，'01.'
 * false: '.0e','.1e'
 * @Author sjy
 * @Date 2020/1/11 20:48
 * @Version 1.0
 **/
public class EffectiveFigure_65 {
    public boolean isNumber(String s) {
        //点的位置
        int spot = -1;
        //是否存在E
        boolean existE = false;
        boolean existUnsigined = false;

        String sTrim = s.trim();
        int length = sTrim.length();


        if (isFigure(sTrim, false)) return true;
        if (sTrim.equals(".")) return false;
        //如果字符串中含有不是数字的字符，不符合要求
        if (!checkNumber(sTrim)) return false;

        if(sTrim.charAt(0) == '+' || sTrim.charAt(0) == '-') existUnsigined = true;

        for (int i = 0; i < length; i++) {
            if(i != 0 && (sTrim.charAt(i) == '+' || sTrim.charAt(i) == '-')) return false;

            //如果存在点的话
            if (sTrim.charAt(i) == '.') {
                //已经存在.错误
                if(spot != -1) return false;
                spot = i;
                String integer = sTrim.substring(0, i);

                //在‘.’的前面，数字可以是0 - 9的,‘.’前什么都没有的话，也符合情况
                //则不为数字，也不为""时，返回false
                if (!isFigure(integer, false) && !integer.equals("")){
                    //如果.的前面是正负号，且.的后面什么都没有，返回false
                    if(!((integer.equals("+") || integer.equals("-")) && spot == sTrim.length() -1)) continue;
                    return false;
                }
            }

            if (sTrim.charAt(i) == 'e' || sTrim.charAt(i) == 'E') {
                //如果已经存在e，错误
                if(existE) return false;
                existE = true;
                if (spot == -1) {
                    //如果前面没有点，没点的时候，e前面不是数字，就false
                    String integer = sTrim.substring(0, i);
                    if (!isFigure(integer, true)) return false;
                } else {
                    //如果前面有点，点到e之间，需要是无符号数，如果不是，false
                    String integer = sTrim.substring(spot + 1, i);
                    //！！！也可以是""
                    if (!isUnsignedFigure(integer, true) && !integer.equals("")) return false;

                    /*String beforeSpot = sTrim.substring(0, spot);
                    if (beforeSpot.equals("")) return false;*/
                }
                //E的后面，如果不是数字，false
                if (!isFigure(sTrim.substring(i + 1), false)) return false;
            }
        }


        //如果存在‘.’，不存在E
        if (spot != -1 && !existE) {
            String integer = sTrim.substring(spot + 1);
            if(integer.equals("")) return true;
            return isUnsignedFigure(integer, false);
        }

        //不存在‘.’也不存在e，还走到这个地方，返回false
        if (spot == -1 && !existE) return false;

        return true;
    }

    /**
     * 判断字符串是否是带符号，或不带符号纯数字
     *
     * @return
     */
    public boolean isFigure(String figure, boolean frontOfE) {

        if (figure.length() == 0) return false;

        if (figure.charAt(0) == '-' || figure.charAt(0) == '+') return isUnsignedFigure(figure.substring(1), frontOfE);
        else return isUnsignedFigure(figure, frontOfE);
    }

    /**
     * 判断是不是不带符号的纯数字
     *
     * @param figure
     * @param frontOfE 是否是在E前面数字的判断
     * @return
     */
    public boolean isUnsignedFigure(String figure, boolean frontOfE) {
        int length = figure.length();
        if (length == 0) return false;
        /**
         * 如果数字长度为1，这个字符范围是0 - 9，如果不是，返回false
         */
        if (length == 1) {
            //e的前面只能是1 - 9
           /* if (frontOfE) return (figure.charAt(0) >= '1' && figure.charAt(0) <= '9');
            else return (figure.charAt(0) >= '0' && figure.charAt(0) <= '9');*/
            return (figure.charAt(0) >= '0' && figure.charAt(0) <= '9');

        }

        for (int i = 0; i < length; i++) {
            /*if (i == 0) {
                if (!(figure.charAt(i) >= '1' && figure.charAt(i) <= '9')) return false;
            } else {
                if (!(figure.charAt(i) >= '0' && figure.charAt(i) <= '9')) return false;
            }*/
            if (!(figure.charAt(i) >= '0' && figure.charAt(i) <= '9')) return false;
        }
        return true;
    }

    /**
     * 检测字符串中是否只含有数字，e，E，正负号，点
     *
     * @param s
     * @return
     */
    public boolean checkNumber(String s) {
        if (s.equals("")) return false;
        for (char c : s.toCharArray()) {
            if (!((c >= '0' && c <= '9') || c == '.' || c == 'e' || c == 'E' || c == '+' || c == '-')) {
                return false;
            }
        }
        return true;
    }


    public static void main(String args[]) {
        EffectiveFigure_65 e = new EffectiveFigure_65();
        //System.out.println(e.isFigure("0", false));
        System.out.println("1. : " + e.isNumber("1."));
        System.out.println(".1 : " + e.isNumber(".1"));
        System.out.println("0e1 : " + e.isNumber("0e1"));
        System.out.println("01. : " + e.isNumber("01."));
        System.out.println("+.8 : " + e.isNumber("+.8"));
        System.out.println("-1. : " + e.isNumber("-1."));
        System.out.println("46.e3 : " + e.isNumber("46.e3"));
        System.out.println(".2e81 : " + e.isNumber(".2e81"));
        System.out.println("---------------------------------------------");
        System.out.println(".0e : " + e.isNumber(".0e"));
        System.out.println(".1e : " + e.isNumber(".1e"));
        System.out.println("-. : " + e.isNumber("-."));
        System.out.println(".. : " + e.isNumber(".."));
        System.out.println("+-. : " + e.isNumber("+-."));
        System.out.println("  : " + e.isNumber(" "));
        System.out.println(" -. : " + e.isNumber(" -."));
        System.out.println("0+. : " + e.isNumber("0+."));
        System.out.println("0+. : " + e.isNumber("0+."));
        System.out.println(".e : " + e.isNumber(".e"));
        System.out.println(".e1 : " + e.isNumber(".e1"));


    }

}
