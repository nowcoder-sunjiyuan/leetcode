package com.sjiyuan.array;

/**
 * @ClassName OddANdEvenSortArray_905
 * @Description TODO 按照奇偶排序数组
 * @Author sjy
 * @Date 2020/1/11 22:24
 * @Version 1.0
 **/
public class OddANdEvenSortArray_905 {
    public int[] sortArrayByParity(int[] A) {

        for (int i = 0, j = A.length - 1; i != j; ) {
            //判断奇数，偶数
            if ((A[i] & 1) == 0) {
                i++;
                continue;
            }
            if ((A[j] & 1) == 1) {
                j--;
                continue;
            }

            //此时说明A[i]为奇数，A[j]为偶数
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        return A;
    }

    public static void main(String args[]) {
        int[] A = {4, 1, 1, 3, 2, 6};
        OddANdEvenSortArray_905 o = new OddANdEvenSortArray_905();
        int[] ints = o.sortArrayByParity(A);
        for(int a : ints){
            System.out.println(a);
        }
    }

}
