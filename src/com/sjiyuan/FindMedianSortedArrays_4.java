package com.sjiyuan;

/**
 * @ClassName FindMedianSortedArrays_4
 * @Description TODO 寻找两个数组的中位数(自己没有思路)(分治法，折半查找)
 * @Author sjy
 * @Date 2019/12/25 21:04
 * @Version 1.0
 **/
public class FindMedianSortedArrays_4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        int all = length1 + length2;
        /**
         * 想要取中位数，不管是奇数还是偶数个数的数组，取(all+1)/2位与(all+2)/2位的和的一半，即为所求
         */
        int data1 = findKth(nums1, 0, nums2, 0, (all + 1) / 2);
        int data2 = findKth(nums1, 0, nums2, 0, (all + 2) / 2);

        return (data1 + data2) / 2.0;
    }


    /**
     * 查找两个有序数组第k小个数字，有序数组从小到大
     *
     * @param nums1  数组1
     * @param start1 数组1开始的位置，从0开始
     * @param nums2  数组2
     * @param start2 数组2开始的位置，从0开始
     * @param k      查找第k位，从1开始
     * @return
     */
    public int findKth(int nums1[], int start1, int nums2[], int start2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        assert k > 0 && k <= length1 + length2;

        //num1中没比较的数据数量必须小于num2中没比较的数据数量
        if (length1 - start1 > length2 - start2) {
            return findKth(nums2, start2, nums1, start1, k);
        }

        /**
         * num1中如果全都被排除出去后，直接取num2的第k位就好了
         */
        //等于1时，是start1取到最后一位的时候，等于0的时候，是数组里没数据的时候（0 - 0）
        if (length1 - start1 == 0) {
            return nums2[start2 + k - 1];
        }

        if (k == 1) {
            return nums1[start1] < nums2[start2] ? nums1[start1] : nums2[start2];
        }

        /**
         * 分治时取的num1与num2的第几位
         * m：第一个数组中第m个
         * n：第一个数组中第n个
         */
        int m = length1 - start1 < (k / 2) ? length1 - start1 : k / 2;
        int n = k - m;

        if (nums1[start1 + m - 1] == nums2[start2 + n - 1]) {
            return nums1[start1 + m - 1];
        } else if (nums1[start1 + m - 1] < nums2[start2 + n - 1]) {
            /**
             * 如果从start1开始，mums1第m项小于num2数组从start2开始第n项，则num1的（start1，start1+m-1）不会是第k项的内容
             * 转而求num1的从start1+m项开始，和mum2从start2开始的第k-m项
             */
            return findKth(nums1, start1 + m, nums2, start2, k - m);
        } else if (nums1[start1 + m - 1] > nums2[start2 + n - 1]) {
            return findKth(nums1, start1, nums2, start2 + n, k - n);
        }
        return 0;
    }

    public static void main(String args[]) {
        int num1[] = {};
        int num2[] = {1};

        FindMedianSortedArrays_4 findMedianSortedArrays_4 = new FindMedianSortedArrays_4();
        /*int kth = findMedianSortedArrays_4.findKth(num1, 0, num2, 0, 6);
        System.out.println("答案：" + kth);*/
        double result = findMedianSortedArrays_4.findMedianSortedArrays(num1, num2);
        System.out.println("答案：" + result);
    }
}
