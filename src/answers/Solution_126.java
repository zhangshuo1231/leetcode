package answers;

import java.util.*;

class Solution_126 {
    Map<String, List<String>> graph = new HashMap<>();
    List<String> currPath = new ArrayList<>();
    List<List<String>> shortestPaths = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> copiedWordList = new HashSet<>(wordList);
        bfs(beginWord, copiedWordList);
        currPath.add(beginWord);
        backtrack(beginWord, endWord);
        return shortestPaths;
    }

    private void backtrack(String source, String destination) {
        if (source.equals(destination)) {
            List<String> tempPath = new ArrayList<>(currPath);
            shortestPaths.add(tempPath);
        }
        if (!graph.containsKey(source)) {
            return;
        }
        for (int i = 0; i < graph.get(source).size(); i++) {
            currPath.add(graph.get(source).get(i));
            backtrack(graph.get(source).get(i), destination);
            currPath.remove(currPath.size() - 1);
        }
    }

    // draw the graph
    private void bfs(String beginWord, Set<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        if (wordList.contains(beginWord)) {
            wordList.remove(beginWord);
        }
        Set<String> enqueued = new HashSet<>();
        enqueued.add(beginWord);
        while (q.size() > 0)  {
            List<String> visited = new ArrayList<>();
            for (int i = q.size() - 1; i >= 0; i--) {
                String currWord = q.poll();
                List<String> neighbors = findNeighbors(currWord, wordList);
                for (String word : neighbors) {
                    visited.add(word);
                    graph.putIfAbsent(currWord, new ArrayList<>());
                    // add the edge from currWord to word in the list
                    graph.get(currWord).add(word);
                    if (!enqueued.contains(word)) {
                        q.add(word);
                        enqueued.add(word);
                    }
                }
            }
            for (int i = 0; i < visited.size(); i++) {
                if (wordList.contains(visited.get(i))) {
                    wordList.remove(visited.get(i));
                }
            }
        }
    }

    private List<String> findNeighbors(String word, Set<String> wordList) {
        List<String> neighbors = new ArrayList<>();
        char charList[] = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char oldChar = charList[i];
            for (char c = 'a'; c <= 'z'; c++) {
                charList[i] = c;
                if (c == oldChar || !wordList.contains(String.valueOf(charList))) {
                    continue;
                }
                neighbors.add(String.valueOf(charList));
            }
            charList[i] = oldChar;
        }
        return neighbors;
    }
}