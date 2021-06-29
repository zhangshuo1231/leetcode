package com.company;

public class Trie {
    private TrieNode root = new TrieNode();
    /** Initialize your data structure here. */
    public Trie() {
        root.val = ' ';
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode(c);
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode last = traceDown(word);
        return last == null? false : last.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return traceDown(prefix) != null;
    }

    private TrieNode traceDown(String str) {
        TrieNode curr = root;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(curr.children[c - 'a'] == null) return null;
            curr = curr.children[c - 'a'];
        }
        return curr;
    }
}

class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
    TrieNode(char c){
        TrieNode node = new TrieNode();
        node.val = c;
    }
}
