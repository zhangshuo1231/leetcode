package answers;
import java.util.PriorityQueue;

public class Solution_324 {
    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums,(nums.length + 1) / 2);
        int small = 1; // 正数第二个
        int big = nums.length % 2 == 0 ? nums.length - 2 : nums.length - 1; // 倒数第二个
        int[] tmpArr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > median){
                tmpArr[small] = nums[i];
                small += 2;
            }
            else if(nums[i] < median){
                tmpArr[big] = nums[i];
                big -= 2;
            }
        }
        while(small < nums.length){
            tmpArr[small] = median;
            small += 2;
        }
        while(big >= 0){
            tmpArr[big] = median;
            big -= 2;
        }
        for(int i = 0;i < nums.length; i++){
            nums[i] = tmpArr[i];
        }
    }

    private int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }
}
