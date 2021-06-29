package com.company;

import java.util.Arrays;

public class StringCompress {

    public static void main(String[] args) {

        char[] chars = {'a','a','b','b','c','c','c'};
        int result = compress(chars);
        System.out.println(Arrays.toString(chars));
        System.out.println(result);
    }

    public static int compress(char[] chars) {
        String s = "";
        for (int i = 0; i < chars.length; i++) {
            int count = 1;
            while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
                i++;
                count++;
            }
            s += chars[i];
            if (count > 1) {
                s += count;
            }
        }
        char[] result = s.toCharArray();
        for (int i = 0; i < result.length; i++)
            chars[i] = result[i];
        return result.length;
    }
}
