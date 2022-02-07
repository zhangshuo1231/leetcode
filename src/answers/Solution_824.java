package answers;

public class Solution_824 {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            StringBuilder curr = new StringBuilder(words[i]);
            if (!(words[i].startsWith("a") || words[i].startsWith("e") || words[i].startsWith("i") || words[i].startsWith("o") || words[i].startsWith("u")
                    || words[i].startsWith("A") || words[i].startsWith("E") || words[i].startsWith("I") || words[i].startsWith("O") || words[i].startsWith("U"))) {
                char c = curr.charAt(0);
                curr.deleteCharAt(0);
                curr.append(c);
            }
            curr.append("ma");
            for (int j = 1; j <= i + 1; j++) {
                curr.append('a');
            }
            words[i] = curr.toString();
        }
        StringBuilder sb = new StringBuilder();
        for (String s : words) {
            sb.append(s);
            sb.append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
