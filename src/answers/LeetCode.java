package answers;

import amazon.LongestSquare;
import model.TreeNode;

import java.util.Arrays;

public class LeetCode {
    public static void main(String[] args) {
        LongestSquare solution = new LongestSquare();
        System.out.println(solution.longest(new int[]{2, 8, 9, 16, 4, 3}));
    }

    private static void printBit(int number) {
        System.out.print(Integer.toBinaryString(number) + " => ");
        System.out.println(number);
    }
}
