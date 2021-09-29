package answers;

public class Solution_67 {
    public String addBinary(String a, String b) {
        int n = a.length(), m = b.length();
        if (n < m) {
            return addBinary(b, a);
        }
        int L = Math.max(m, n);

        StringBuilder sb = new StringBuilder();
        int carry = 0, j = m - 1;
        for (int i = L - 1; i >= 0; --i) {
            if (a.charAt(i) == '1') {
                carry++;
            }
            if (j >= 0 && b.charAt(j--) == '1') {
                carry++;
            }
            if (carry == 0) {
                sb.append('0');
            }
            else if (carry == 1) {
                sb.append('1');
            }
            else if (carry == 2){
                sb.append(0);
                carry = 1;
            }
            else {
                sb.append(1);
                carry = 1;
            }
        }
        if (carry == 1) {
            sb.append('1');
        }
        sb.reverse();

        return sb.toString();
    }
}
