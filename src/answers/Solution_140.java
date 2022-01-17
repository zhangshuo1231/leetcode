package answers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_140 {
    List<String> res = new ArrayList<>();
    Set<String> wordSet;
    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>(wordDict);
        dfs(s, 0, new StringBuilder());
        return res;
    }

    private void dfs(String s, int index, StringBuilder cur) {
        int n = s.length();
        if (index == n) {
            res.add(cur.toString());
            return;
        }
        for (int i = index; i < n; i++) {
            if (wordSet.contains(s.substring(index, i + 1))) {
                int beforeAdding = cur.length();
                if (beforeAdding == 0) {
                    cur.append(s, index, i + 1);
                }
                else {
                    cur.append(" ").append(s, index, i + 1);
                }
                dfs(s, i + 1, cur);
                cur.delete(beforeAdding, cur.length());
            }
        }
    }
}
