package answers;

import java.util.List;
import java.util.Stack;

public class Solution_385 {
    int i = 1;
    int start = i;

    /*
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.valueOf(s));
        }
        NestedInteger res = new NestedInteger();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '[') {
                start = ++i;
                NestedInteger ni = deserialize(s);
                res.add(ni);
            }
            else if (c == ']' || c == ',') {
                String num = s.substring(start, i);
                if (!num.equals("")) {
                    int n = Integer.valueOf(num);
                    NestedInteger ni = new NestedInteger(n);
                    res.add(ni);
                }
                start = ++i;
                if (c == ']') break;
            }
            else {
                i++;
            }
        }
        return res;
    }
    */
}