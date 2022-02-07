package answers;
import com.sun.source.tree.Tree;
import model.ListNode;
import model.TreeNode;
import java.util.*;

public class LeetCode {
    public static void main(String[] args) {
        Solution_648 solution = new Solution_648();
        System.out.println(solution.replaceWords(Arrays.asList("cat","bat","rat"), "the cattle was rattled by the battery"));
    }

    private static void printBit(int number) {
        System.out.print(Integer.toBinaryString(number) + " => ");
        System.out.println(number);
    }
}
