package com.sjiyuan.offer;

/**
 * 打印从1到最大的n位数
 */
public class Subject17 {
    /**
     * 先找到最大数，999999....，然后从小到大赋值到最大数
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            sb.append('9');
        }
        int max = Integer.parseInt(sb.toString());

        int[] result = new int[max];
        for(int i = 0; i < max; i++){
            result[i] = i+1;
        }
        return result;
    }

    public static void main(String[] args) {
        Subject17 subject17 = new Subject17();
        int[] ints = subject17.printNumbers(1);

    }
}
