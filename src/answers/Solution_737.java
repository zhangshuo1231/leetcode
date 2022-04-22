package answers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_737 {
    Map<String, String> parents = new HashMap<>();

    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {

        int m = sentence1.length;
        int n = sentence2.length;
        if (m != n) return false;

        for (List<String> list : similarPairs) {
            String word1 = list.get(0);
            String word2 = list.get(1);
            if (!parents.containsKey(word1)) {
                parents.put(word1, word1);
            }
            if (!parents.containsKey(word2)) {
                parents.put(word2, word2);
            }
            union(word1, word2);
        }

        for (int i = 0; i < m; i++) {
            if (!find(sentence1[i]).equals(find(sentence2[i]))) {
                return false;
            }
        }
        return true;
    }

    private String find(String word) {
        if (parents.get(word).equals(word)) {
            return word;
        }
        else {
            String parent = find(parents.get(word));
            parents.put(word, parent);
            return parent;
        }
    }

    private void union(String word1, String word2) {
        String p1 = find(word1);
        String p2 = find(word2);
        if (p1.equals(p2)) {
            return;
        }
        else {
            parents.put(p1, p2);
        }
    }
}
