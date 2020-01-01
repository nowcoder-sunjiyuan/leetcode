package com.sjiyuan;

/**
 * @ClassName Covert_6
 * @Description TODO 进行Z字的变换
 * @Author sjy
 * @Date 2018/10/29 21:31
 * @Version 1.0
 **/
public class Covert_6 {

    public String convert(String s, int numRows){

        if(numRows == 1){
            return s;
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i,k,space = (2 * numRows) - 3;  //space是第一行和最后一行的的相隔个数
        int temp = space;
        int tag = 0;                //非首尾行的0与1切换

        for(i = 0; i < numRows; i++){
            for(k = i; k < chars.length;){
                //System.out.print(chars[k]);
                sb.append(chars[k]);
                if(i == 0 || i == numRows-1){
                    k = k + space;
                }else{
                    if(tag == 0){
                        k = k + temp;
                        tag = 1;
                    }else{
                        k = k + space-1-temp;
                        tag = 0;
                    }
                }
                k++;
            }
            tag = 0;
            temp = temp -2;
        }

        return sb.toString();
    }
}
