package answers;

import java.util.ArrayList;
import java.util.List;

public class Solution_389 {
    public char findTheDifference(String s, String t) {
        List<Character> target = new ArrayList();
        for (char c: t.toCharArray()) {
            target.add(c);
        }
        for (char c: s.toCharArray()) {
            target.remove((Character)c);
        }
        return target.get(0);
    }
}
