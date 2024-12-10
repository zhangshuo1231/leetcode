import amazon.LongestSquare;
import amazon.RectangleAreas;
import answers.*;
import model.TreeNode;

import java.util.Arrays;

public class LeetCode {
    public static void main(String[] args) {
        Solution_901 solution = new Solution_901();
        solution.next(1);
        solution.next(2);
        solution.next(1);
        System.out.println(solution.next(1));
    }

    private static void printBit(int number) {
        System.out.print(Integer.toBinaryString(number) + " => ");
        System.out.println(number);
    }
}