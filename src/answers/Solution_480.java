package answers;

import java.util.PriorityQueue;

public class Solution_480 {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        double[] res = new double[n];

        int start = 0, end = 0;
        for (; end < nums.length; end++) {
            add(nums[end]);
            balance();
            if (end - start + 1 == k) {
                res[start] = median(minHeap.peek(), maxHeap.isEmpty() ? 0 : maxHeap.peek(), k);
                remove(nums[start++]);
                balance();
            }
        }
        return res;
    }

    private void add(int a) {
        if (minHeap.isEmpty() || a >= minHeap.peek()) {
            minHeap.offer(a);
        }
        else {
            maxHeap.offer(a);
        }
    }

    private void balance() {
        while (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
        while (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }

    private void remove(int a) {
        if (a >= minHeap.peek()) {
            minHeap.remove(a);
        }
        else {
            maxHeap.remove(a);
        }
    }

    private double median(long a, long b, int k) {
        if (k % 2 == 1) {
            return a;
        }
        else {
            return (a + b) / 2.0d;
        }
    }
}
