package answers;

import java.util.ArrayList;
import java.util.List;

public class Solution_604 {
    class Unit {
        char c;
        int r;
        public Unit (char c, int r) {
            this.c = c;
            this.r = r;
        }
    }

    private List<Unit> list = new ArrayList<>();

    public Solution_604(String compressedString) {
        int n = compressedString.length();
        int idx = 0;
        char c = '#';
        int r = 0;
        while (idx < n) {
            char curr = compressedString.charAt(idx++);
            if (!Character.isDigit(curr)) {
                if (c != '#') {
                    list.add(new Unit(c, r));
                }
                c = curr;
                r = 0;
            }
            else if (Character.isDigit(curr)) {
                r *= 10;
                r += (curr - '0');
            }
        }
        list.add(new Unit(c, r));
    }

    public char next() {
        if (list.isEmpty()) {
            return ' ';
        }
        Unit u = list.get(0);
        u.r -= 1;
        char c = u.c;
        if (u.r == 0) {
            list.remove(0);
        }
        return c;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}
