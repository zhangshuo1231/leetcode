package answers;
import com.sun.source.tree.Tree;
import model.ListNode;
import model.TreeNode;
import java.util.*;

public class LeetCode {
    public static void main(String[] args) {
        Solution_1326 solution = new Solution_1326();
        System.out.println(solution.minTaps(7, new int[]{1, 2, 1, 0, 2, 1, 0, 1}));
    }

    private static void printBit(int number) {
        System.out.print(Integer.toBinaryString(number) + " => ");
        System.out.println(number);
    }
}
