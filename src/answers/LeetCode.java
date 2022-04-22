package answers;
import meta.LongestPath;
import meta.MinimumDeleteParentheses;

public class LeetCode {
    public static void main(String[] args) {
        // Solution_720 solution = new Solution_720();
        MinimumDeleteParentheses minimumDeleteParentheses = new MinimumDeleteParentheses();
        System.out.println(minimumDeleteParentheses.deleteParen("a(jdsfs))(ad12)((()"));
    }

    private static void printBit(int number) {
        System.out.print(Integer.toBinaryString(number) + " => ");
        System.out.println(number);
    }
}
