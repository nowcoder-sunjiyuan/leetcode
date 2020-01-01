package com.sjiyuan;

/**
 * @ClassName LongestPalindrome_5
 * @Description TODO
 * @Author sjy
 * @Date 2018/10/25 21:24
 * @Version 1.0
 **/
public class LongestPalindrome_5 {
    public static String longestPalindrome(String s) {

        char[] SChars = s.toCharArray();
        int i,j;
        int longLength = 1,length;
        int start = 0,end = 0;
        String newString;


        for(i = 0; i < SChars.length-2; i++){
            if(SChars[i] == SChars[i+2]){
                length = 3;
                j = 1;
                while(i-j >= 0 && i+2+j < SChars.length && SChars[i-j] == SChars[i+2+j]){
                    j++;
                    length = length + 2;
                }
                if(longLength < length){
                    longLength = length;
                    start = i-j+1;
                    end = i+j+1;
                }
            }
        }

        for(i = 0; i < SChars.length-1; i++){
            if(SChars[i] == SChars[i+1]){
                length = 2;
                j = 1;
                while(i-j >= 0 && i+1+j < SChars.length && SChars[i-j] == SChars[i+1+j]){
                    j++;
                    length = length + 2;
                }
                if(longLength < length){
                    longLength = length;
                    start = i-j+1;
                    end = i+j;
                }
            }
        }

        if(s.trim().equals("")){
            newString = "";
        }else{
            newString = s.substring(start, end+1);
        }



        //newString = String.valueOf(newChars);
        return newString;
    }

    /**
     * 此方法判断chars是否是回文子串
     * @param
     * @return
     */
    /*public boolean checkPalindrome(char[] chars, int start, int end){
        while(chars[start] == chars[end]){
            start--;
            end--;
            if(start == end || end < start){
                return true;
            }
        }
        return false;
    }*/

    public static void main(String args[]){
        String s = "aaaa";
        System.out.println(longestPalindrome(s));
    }
}
