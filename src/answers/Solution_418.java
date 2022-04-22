package answers;

public class Solution_418 {
    public int wordsTyping(String[] sentence, int rows, int cols) { // sentence = "a_bcd_e_"; rows = 3, cols = 6
        String sent = String.join(" ", sentence) + " ";
        int pos = 0, len = sent.length(); // pos: 有效字符数
        for (int i = 0; i < rows; i++) {
            pos += cols;
            while (pos >= 0 && sent.charAt(pos % len) != ' '){
                pos--;
            }
            pos++;
        }
        return pos / len;
    }
}
