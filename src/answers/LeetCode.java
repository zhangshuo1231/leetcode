package answers;
import model.ListNode;
import model.TreeNode;

import java.util.*;

public class LeetCode {
    public static void main(String[] args) {
        Solution_48 solution = new Solution_48();
        int[][] nums = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(nums);
        System.out.println(Arrays.deepToString(nums));
    }

    private static void printBit(int number) {
        System.out.print(Integer.toBinaryString(number) + " => ");
        System.out.println(number);
    }
}
