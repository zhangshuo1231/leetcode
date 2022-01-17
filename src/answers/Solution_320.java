package answers;

import java.util.ArrayList;
import java.util.List;

public class Solution_320 {
    private boolean[] abbrI = new boolean[]{true, false};

    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", word, 0, 0);
        return ans;
    }

    /*
    private void backtrack(List<String> ans, StringBuilder builder, String word, int i, int k) {
        int len = builder.length();
        if (i == word.length()) {
            if (k != 0) {
                builder.append(k);
            }
            ans.add(builder.toString());
        }
        else {
            backtrack(ans, builder, word, i + 1, k + 1); // abbr word[i]

            if (k != 0) {
                builder.append(k);
            }
            builder.append(word.charAt(i));
            backtrack(ans, builder, word, i + 1, 0); // not abbr word[i]
        }
        builder.setLength(len);
    }
    */

    private void backtrack(List<String> ans, String temp, String word, int i, int k) {
        if (i == word.length()) {
            if (k != 0) {
                temp += k;
            }
            ans.add(temp);
            return;
        }

        for (boolean b : abbrI) {
            String curr = temp;
            if (b) {
                backtrack(ans, temp, word, i + 1, k + 1);
            }
            else {
                if (k != 0) {
                    temp += k;
                }
                temp += word.charAt(i);
                backtrack(ans, temp, word, i + 1, 0); // not abbr word[i]
            }
        }
    }
}
