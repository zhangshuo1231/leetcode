package answers;
import model.ListNode;
import model.TreeNode;

import java.util.*;

public class LeetCode {
    public static void main(String[] args) {
        Solution_126 solution = new Solution_126();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(solution.findLadders(beginWord, endWord, wordList));
    }

    private static void printBit(int number) {
        System.out.print(Integer.toBinaryString(number) + " => ");
        System.out.println(number);
    }
}
