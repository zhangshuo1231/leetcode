package answers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_239 {
    /*
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.remove(nums[i - k]);
            }
            if (queue.size() == k) {
                res.add(queue.peek());
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
    */

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        int[] result = new int[n - k + 1];
        LinkedList<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.peek() < i - k + 1) { // in this iteration, the first element index should be i - k + 1, discard anyone before that
                dq.poll();
            }
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) { // current element larger than the last one in dq, the current last one becomes no hope. discard
                dq.pollLast();
            }
            dq.offer(i); // add current idx to dq
            if (i - k + 1 >= 0) { // valid to add one item
                result[i - k + 1] = nums[dq.peek()];
            }
        }
        return result;
    }
}
