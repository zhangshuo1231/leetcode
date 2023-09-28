package answers;

public class Solution_2423 {
    public boolean equalFrequency(String word) {
        int[] rec = new int[26];
        for (char c : word.toCharArray()) {
            rec[c - 'a']++;
        }
        int min = 101;
        int chars = 0;
        for (int i : rec) {
            if (i == 0) continue;
            min = Math.min(min, i);
            chars++;
        }

        if (chars == 1) return true;
        boolean found = false;

        for (int i : rec) {
            if (i == 0) continue;
            if (i != min) {
                if (found) return false;
                else {
                    found = true;
                    if (min + 1 != i) return false;
                }
            }
        }

        if (min == 1 && !found) return true;

        return found;
    }
}
