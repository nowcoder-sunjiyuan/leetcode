package com.sjiyuan;

/**
 * @ClassName MostArea_11
 * @Description TODO 盛最多的水（数组）
 * @Author sjy
 * @Date 2019/12/29 19:44
 * @Version 1.0
 **/
public class MostArea_11 {
    /**
     * 双指针法
     * 最初两个指针指向开头和结尾，指针向内移动时，如果想要面积更大，只能移动长度短的那个指针，只有这样，在x轴缩短时，
     * 才有可能面积在增大，找到最大的x1，x2就好了
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int front = 0;
        int tail = height.length - 1;

        int maxArea = (height[front] < height[tail] ? height[front] : height[tail]) * (tail - front);

        while(front < tail){
            if (height[front] < height[tail]) {
                front = front + 1;
            }else{
                tail = tail - 1;
            }
            if((height[front] < height[tail] ? height[front] : height[tail]) * (tail - front) > maxArea){
                maxArea = (height[front] < height[tail] ? height[front] : height[tail]) * (tail - front);
            }
        }

        return maxArea;
    }

    public static void main(String args[]){
        int test[] = {1,8,6,2,5,4,8,3,7};
        MostArea_11 m = new MostArea_11();
        System.out.println("结果：" + m.maxArea(test));
    }
}
