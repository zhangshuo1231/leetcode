package answers;
import model.ListNode;

public class LeetCode {
    public static void main(String[] args) {
        Solution_329 solution = new Solution_329();
        int[][] matrix = new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}};

        System.out.println(solution.longestIncreasingPath(matrix));
    }
}
