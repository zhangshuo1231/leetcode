package answers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution_299 {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> h = new HashMap<>();
        for (char c : secret.toCharArray()) {
            h.put(c, h.getOrDefault(c, 0) + 1);
        }
        int bulls = 0, cows = 0;
        int n = guess.length();
        List<Character> rem = new ArrayList<>();

        for (int idx = 0; idx < n; ++idx) {
            char ch = guess.charAt(idx);
            if (ch == secret.charAt(idx)) {
                bulls++;
                h.put(ch, h.get(ch) - 1);
            }
            else {
                rem.add(ch);
            }
        }

        for (Character c : rem) {
            if (h.containsKey(c) && h.get(c) > 0) {
                cows++;
                h.put(c, h.get(c) - 1);
            }
        }

        return bulls + "A" + cows + "B";
    }
}
