import amazon.LongestSquare;
import amazon.RectangleAreas;
import answers.Solution_1405;
import model.TreeNode;

import java.util.Arrays;

public class LeetCode {
    public static void main(String[] args) {
        Solution_1405 solution = new Solution_1405();
        System.out.println(solution.longestDiverseString(1, 0, 3));
    }

    private static void printBit(int number) {
        System.out.print(Integer.toBinaryString(number) + " => ");
        System.out.println(number);
    }
}