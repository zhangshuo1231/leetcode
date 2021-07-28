package answers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        List<Character> mag = new ArrayList();
        for (char c : magazine.toCharArray()) {
            mag.add(c);
        }
        for (char c : ransomNote.toCharArray()) {
            if (! mag.remove((Character) c)) {
                return false;
            }
        }
        return true;
    }
}
