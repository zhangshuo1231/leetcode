package answers;

import java.util.HashMap;
import java.util.Map;

public class Solution_720 {
    class TrieNode {
        Map<Character, TrieNode> map = new HashMap<>();
        String word = null;
    }

    class Trie {
        TrieNode root = new TrieNode();
        Trie(){}
        public void insert(String word){
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!curr.map.containsKey(c)) {
                    curr.map.put(c, new TrieNode());
                }
                curr = curr.map.get(c);
            }
            curr.word = word;
        }
    }

    public String longestWord(String[] words) {
        Trie trie = new Trie();
        trie.root.word = "";
        for (String s : words) {
            trie.insert(s);
        }
        String[] res = new String[]{""};
        dfs(trie.root, res);
        return res[0];
    }

    private void dfs(TrieNode node, String[] s) {
        if (betterThan(node.word, s[0])) {
            s[0] = node.word;
        }
        if (node.word == null) {
            return;
        }
        if (node.map.isEmpty()) {
            return;
        }
        for (char c : node.map.keySet()) {
            dfs(node.map.get(c), s);
        }
    }

    private boolean betterThan(String t, String s) {
        return t != null && (t.length() > s.length() || (t.length() == s.length() && (t.compareTo(s) < 0)));
    }
}
