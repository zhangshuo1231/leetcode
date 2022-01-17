package answers;

public class Solution_233 {
    public int countDigitOne(int n) {
        int res = 0;
        for (int base = 1; n > (base - 1); base *= 10) {
            int preNum = n / (base * 10);
            int currDigit = (n / base) % 10;
            int postNum = n % base;

            System.out.println(preNum + " " + currDigit + " " + postNum);

            if (currDigit > 1) {
                res += (preNum + 1) * base;
                // System.out.println("curr > 1 : " + (preNum + 1) * base);
            }
            else if (currDigit == 1) {
                res += (preNum * base + 1 * (postNum + 1));
                // System.out.println("curr == 1 : " + (preNum * base + 1 * (postNum + 1)));
            }
            else {
                res += (preNum * base);
                // System.out.println("curr == 0 : " + (preNum * base));
            }
        }
        return res;
    }
}
