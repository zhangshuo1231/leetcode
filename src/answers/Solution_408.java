package answers;

public class Solution_408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < abbr.length()) {
            sb.setLength(0);
            if (Character.isDigit(abbr.charAt(idx))) {
                if (abbr.charAt(idx) == '0') {
                    return false;
                }
                while (idx < abbr.length() && Character.isDigit(abbr.charAt(idx))) {
                    sb.append(abbr.charAt(idx++));
                }
                int num = Integer.valueOf(sb.toString());
                if (word.length() < num) {
                    return false;
                }
                word = word.substring(num);
            }
            else {
                while (idx < abbr.length() && !Character.isDigit(abbr.charAt(idx))) {
                    sb.append(abbr.charAt(idx++));
                }
                if (!word.startsWith(sb.toString())) {
                    return false;
                }
                word = word.substring(sb.length());
            }
        }
        return word.equals("");
    }
}
