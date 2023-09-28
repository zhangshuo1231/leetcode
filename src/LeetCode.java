import amazon.LongestSquare;
import amazon.RectangleAreas;
import answers.*;
import model.TreeNode;

import java.util.Arrays;

public class LeetCode {
    public static void main(String[] args) {
        Solution_2423 solution = new Solution_2423();
        System.out.println(solution.equalFrequency("bac"));
    }

    private static void printBit(int number) {
        System.out.print(Integer.toBinaryString(number) + " => ");
        System.out.println(number);
    }
}