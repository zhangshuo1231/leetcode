package answers;

import java.util.*;

class Solution_126 {
    Map<String, List<String>> graph = new HashMap<>();
    List<String> currPath = new ArrayList<>();
    List<List<String>> shortestPaths = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // copying the words into the set for efficient deletion in BFS
        Set<String> copiedWordList = new HashSet<>(wordList);
        // build the DAG using BFS
        bfs(beginWord, copiedWordList);
        // every path will start from the beginWord
        currPath.add(beginWord);
        // traverse the DAG to find all the paths between beginWord and endWord
        backtrack(beginWord, endWord);
        return shortestPaths;
    }

    private void backtrack(String source, String destination) {
        // store the path if we reached the endWord
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
        // remove the root word which is the first layer in the BFS
        if (wordList.contains(beginWord)) {
            wordList.remove(beginWord);
        }
        Set<String> isEnqueued = new HashSet<>();
        isEnqueued.add(beginWord);
        while (q.size() > 0)  {
            // visited will store the words of current layer
            List<String> visited = new ArrayList<>();
            for (int i = q.size() - 1; i >= 0; i--) {
                String currWord = q.poll();
                // findNeighbors will have the adjacent words of the currWord
                List<String> neighbors = findNeighbors(currWord, wordList);
                for (String word : neighbors) {
                    visited.add(word);
                    if (!graph.containsKey(currWord)) {
                        graph.put(currWord, new ArrayList<>());
                    }
                    // add the edge from currWord to word in the list
                    graph.get(currWord).add(word);
                    if (!isEnqueued.contains(word)) {
                        q.add(word);
                        isEnqueued.add(word);
                    }
                }
            }
            // removing the words of the previous layer
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
            // replace the i-th character with all letters from a to z except the original character
            for (char c = 'a'; c <= 'z'; c++) {
                charList[i] = c;
                // skip if the character is same as original or if the word is not present in the wordList
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