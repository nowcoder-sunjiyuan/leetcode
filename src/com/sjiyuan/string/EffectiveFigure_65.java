package com.sjiyuan.string;

/**
 * @ClassName EffectiveFigure_65
 * @Description TODO 有效数字
 * @Author sjy
 * @Date 2020/1/11 20:48
 * @Version 1.0
 **/
public class EffectiveFigure_65 {
    public boolean isNumber(String s) {

        int length = s.length();
        //点的位置
        int spot = -1;

        if (isFigure(s, false)) return true;
        for (int i = 0; i < length; i++) {
            //如果存在点的话
            if (s.charAt(i) == '.') {
                spot = i;
                String integer = s.substring(0, i);
                //如果‘.’的前面，什么都没有，也就算是0，是符合情况的
                if (integer.equals("")) continue;
                //在‘.’的前面，数字可以是0 - 9的
                if (!isFigure(integer, false)) return false;
            }

            if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if (spot == -1) {
                    //如果前面没有点，没点的时候，e前面不是数字，就false
                    String integer = s.substring(0, i);
                    if (!isFigure(integer, true)) return false;

                    //E的后面，如果不是数字，false
                    if(!isFigure(s.substring(i + 1), false)) return false;
                } else {
                    //如果前面有点，点到e之间，需要是无符号数，如果不是，false
                    String integer = s.substring(spot + 1, i);
                    if(!isUnsignedFigure(integer, false)) return false;
                }
            }

        }
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
            if (frontOfE) return (figure.charAt(0) >= '1' && figure.charAt(0) <= '9');
            else return (figure.charAt(0) >= '0' && figure.charAt(0) <= '9');

        }

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                if (!(figure.charAt(i) >= '1' && figure.charAt(i) <= '9')) return false;
            } else {
                if (!(figure.charAt(i) >= '0' && figure.charAt(i) <= '9')) return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        EffectiveFigure_65 e = new EffectiveFigure_65();
        //System.out.println(e.isFigure("0", false));
        System.out.println(e.isNumber("123.45e+6"));
    }

}
