package answers;

import java.util.Arrays;
import java.util.Stack;

public class Solution_331 {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node: nodes) {
            diff -= 1;
            if (diff < 0)
                return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }
}
