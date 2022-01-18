package answers;
import com.sun.source.tree.Tree;
import model.ListNode;
import model.TreeNode;
import java.util.*;

public class LeetCode {
    public static void main(String[] args) {
        Solution_987 solution = new Solution_987();
        TreeNode root = TreeNode.deserialize("[3,1,4,0,2,2]");
        System.out.println(solution.verticalTraversal(root));
    }

    private static void printBit(int number) {
        System.out.print(Integer.toBinaryString(number) + " => ");
        System.out.println(number);
    }
}
