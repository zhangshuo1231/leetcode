package answers;

public class Solution_345 {
    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        for (int i = 0, j = charArray.length - 1; i < j;) {
            if (!(isVowel(charArray[i]) && isVowel(charArray[j]))) {
                if (!isVowel(charArray[i])) {
                    i++;
                }
                else if (!isVowel(charArray[j])) {
                    j--;
                }
                else {
                    i++;
                    j--;
                }
            }
            else {
                swap(charArray, i, j);
                i++;
                j--;
            }
        }
        return String.valueOf(charArray);
    }

    private void swap(char[] s, int m, int n) {
        char x = s[m];
        s[m] = s[n];
        s[n] = x;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
