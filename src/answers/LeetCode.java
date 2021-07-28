package answers;
import model.ListNode;
import model.TreeNode;

import java.util.*;

public class LeetCode {
    public static void main(String[] args) {
        Solution_7 solution = new Solution_7();
        System.out.println(solution.reverse(1534236469));
    }

    private static void printBit(int number) {
        System.out.print(Integer.toBinaryString(number) + " => ");
        System.out.println(number);
    }
}
