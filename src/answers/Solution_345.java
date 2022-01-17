package answers;

public class Solution_345 {
    public String reverseVowels(String s) {
        char[] array = s.toCharArray();
        int i = 0, j = array.length - 1;
        while (i < j) {
            while (i < j && !isVowel(array[i])) {
                i++;
            }
            while (i < j && !isVowel(array[j])) {
                j--;
            }
            if (i != j) {
                swap(array, i++, j--);
            }
        }
        return new String(array);
    }

    private void swap(char[] s, int m, int n) {
        char temp = s[n];
        s[n] = s[m];
        s[m] = temp;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
