package answers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution_336 {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int wordIndex = -1;
        List<Integer> restIsPalindrome;
        TrieNode() {
            restIsPalindrome = new ArrayList<>();
        }
    }

    TrieNode root = new TrieNode();
    int n;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> palindromePairs(String[] words) {
        n = words.length;
        for (int i = 0; i < n; i++) {
            add(words[i], i);
        }
        for (int i = 0; i < n; i++) {
            search(words[i], i);
        }
        return res;
    }

    private void add(String word, int wordIndex) {
        TrieNode cur = root;
        char[] chs = word.toCharArray();
        for (int i = chs.length - 1; i >= 0; i--) {
            int j = chs[i] - 'a';
            if (isPalindrome(chs, 0, i)) {
                cur.restIsPalindrome.add(wordIndex);
            }

            if (cur.children[j] == null) {
                cur.children[j] = new TrieNode();
            }
            cur = cur.children[j];
        }
        cur.wordIndex = wordIndex;
    }

    private void search(String word, int wordIndex) {
        TrieNode cur = root;
        char[] chs = word.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            int j = chs[i] - 'a';
            if (cur.wordIndex != -1 && isPalindrome(chs, i, chs.length - 1)) {
                res.add(Arrays.asList(wordIndex, cur.wordIndex));
            }
            if (cur.children[j] == null) {
                return;
            }
            cur = cur.children[j];
        }

        // aaaa
        if (cur.wordIndex != -1 && cur.wordIndex != wordIndex) {
            res.add(Arrays.asList(wordIndex, cur.wordIndex));
        }

        for (int j : cur.restIsPalindrome) {
            res.add(Arrays.asList(wordIndex, j));
        }
    }

    private boolean isPalindrome(char[] chs, int i, int j) {
        while (i < j) {
            if (chs[i++] != chs[j--]) return false;
        }
        return true;
    }
}