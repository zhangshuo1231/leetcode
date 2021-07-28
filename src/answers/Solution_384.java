package answers;

import java.util.Arrays;
import java.util.Random;

public class Solution_384 {
    private int[] nums;
    private int[] view;
    private Random random = new Random();

    public Solution_384(int[] nums) {
        this.nums = nums;
        this.view = Arrays.copyOf(this.nums, this.nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        this.view = Arrays.copyOf(this.nums, this.nums.length);
        return this.view;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < view.length; i++) {
            int idx = random.nextInt(view.length);
            swapViewElements(i, idx);
        }
        return view;
    }

    private void swapViewElements(int x, int y) {
        int temp = view[x];
        view[x] = view[y];
        view[y] = temp;
    }
}
