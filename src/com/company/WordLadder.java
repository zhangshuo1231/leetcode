package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordLadder {

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(findLadders("hit", "cog", wordList));
    }

    // Slow Solution: one directional bfs
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return res;
        Map<String, List<String>> map = new HashMap<>();
        Set<String> startSet = new HashSet<>();
        startSet.add(beginWord);
        bfs(startSet, endWord, map, dict);
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        dfs(res, list, beginWord, endWord, map);
        return res;
    }

    // Backtracking
    private static void dfs(List<List<String>> res, List<String> list, String beginWord, String endWord, Map<String, List<String>> map) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList(list));
            return;
        }
        if (map.get(beginWord) == null) return;
        for (String next : map.get(beginWord)) {
            list.add(next);
            dfs(res, list, next, endWord, map);
            list.remove(list.size() - 1);
        }
    }

    private static void bfs(Set<String> startSet, String endWord, Map<String, List<String>> map, Set<String> dict) {
        System.out.println("startSet: " + startSet + ", endWord: " + endWord + ", map: " + map + ", dict: " + dict);
        if (startSet.size() == 0) return;
        Set<String> nextStartSet = new HashSet<>();
        dict.removeAll(startSet);
        boolean finish = false;
        for (String s : startSet) {
            char[] chs = s.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                char old = chs[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    chs[i] = c;
                    String word = new String(chs);
                    if (dict.contains(word)) {
                        if (word.equals(endWord)) {
                            finish = true;
                        } else {
                            nextStartSet.add(word);
                        }
                        map.putIfAbsent(s, new ArrayList<>());
                        map.get(s).add(word);
                    }
                }
                chs[i] = old;
            }
        }
        if (!finish) {
            bfs(nextStartSet, endWord, map, dict);
        }
    }
}
