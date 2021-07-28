package answers;

import java.util.Arrays;

public class Solution_6 {
    public String convert(String s, int numRows) {
        int len = s.length();
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int count = 0; count < numRows; count++) {
            sbs[count] = new StringBuilder();
        }
        int i = 0;
        while (i < len) {
            for (int j = 0; j < numRows && i < len; j++) {
                sbs[j].append(s.charAt(i++));
            }
            for (int j = numRows - 2; j > 0 && i < len; j--) {
                sbs[j].append(s.charAt(i++));
            }
        }
        StringBuilder res = new StringBuilder();
        for (int k = 0; k < numRows; k++) {
            res.append(sbs[k].toString());
        }
        return res.toString();
    }
}
