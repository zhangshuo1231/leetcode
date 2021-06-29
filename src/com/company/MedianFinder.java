package com.company;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> high = new PriorityQueue();
    PriorityQueue<Integer> low = new PriorityQueue(1000, Collections.reverseOrder());

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
    }

    public void addNum(int num) {
        low.offer(num);
        high.offer(low.poll());
        if (low.size() < high.size()){
            low.offer(high.poll());
        }
        System.out.println("hig: " + high);
        System.out.println("low: " + low);
        System.out.println("----------");
    }

    // Returns the median of current data stream
    public double findMedian() {
        if (low.size() == high.size()) return (low.peek() + high.peek()) /  2.0;
        else return low.peek();
    }
}
