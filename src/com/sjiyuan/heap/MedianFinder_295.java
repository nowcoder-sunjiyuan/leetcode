package com.sjiyuan.heap;

/**
 * @ClassName MedianFinder_295
 * @Description TODO 数据流的中位数
 * @Author sjy
 * @Date 2020/2/2 21:01
 * @Version 1.0
 **/
public class MedianFinder_295 {

    private MaxHeap<Integer> maxHeap;
    private MinHeap<Integer> minHeap;

    /**
     * 用大顶堆和小顶堆，来实现，整个数据左半边用大顶堆。右半边用小顶堆。时刻保证小顶堆最小的比左边的大顶堆最大值还大
     */
    public MedianFinder_295() {
        maxHeap = new MaxHeap<>();
        minHeap = new MinHeap<>();
    }

    public void addNum(int num) {
        if (minHeap.isEmpty()) {
            minHeap.add(num);
            return;
        }

        int insert = num;
        if (maxHeap.size() < minHeap.size()) {
            //大顶堆数据少，就添加大顶堆

            //如果插入的数据（需要插入大顶堆，却比小顶堆里最小的还大），需要插进大顶堆的是现在小顶堆的最小值
            if (num > minHeap.findMin()) {
                insert = minHeap.getMin();
                minHeap.add(num);
            }
            maxHeap.add(insert);

        } else if (maxHeap.size() >= minHeap.size()) {
            //小顶堆数据少，或者，相同的数量，就添加大顶堆

            //如果插入的数据（需要插入小顶堆，却比大顶堆里最大的还小），需要插入小顶堆的是现在大顶堆的最大值
            if (num < maxHeap.findMax()) {
                insert = maxHeap.getMax();
                maxHeap.add(num);
            }
            minHeap.add(insert);
        }
    }

    public double findMedian() {
        if (minHeap.size() == 0) throw new IllegalArgumentException();

        if (maxHeap.size() < minHeap.size()) return minHeap.findMin();
        else if (maxHeap.size() == minHeap.size()) return ((double) minHeap.findMin() + (double) maxHeap.findMax()) / 2;
        else return maxHeap.findMax();
    }

    public static void main(String args[]) {
        MedianFinder_295 medianFinder_295 = new MedianFinder_295();
        medianFinder_295.addNum(1);
        medianFinder_295.addNum(3);
        medianFinder_295.addNum(4);
        medianFinder_295.addNum(6);
        medianFinder_295.addNum(9);
        medianFinder_295.addNum(10);
        medianFinder_295.addNum(12);
        medianFinder_295.addNum(13);
        System.out.println("答案：" + medianFinder_295.findMedian());

    }
}
