package com.company;

import java.util.*;

public class RemoveDuplicatedLetters {

    public static void main(String[] args) {
        System.out.println(recursive("bxshkpdwcsjdbikywvioxrypfzfbppydfilfxxtouzzjxaymjpmdoevv"));
    }

    public static String recursive(String s) {
        int[] cnt = new int[26];
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++)
            cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) // find the smallest
                pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0) // if hit one last character
                break;
        }
        return s.length() == 0 ? "" : s.charAt(pos) + recursive(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }

    public static String removeDuplicateLetters(String s) {
        char[] inputCharArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < inputCharArray.length; i++) {
            map.putIfAbsent(inputCharArray[i], 0);
            map.put(inputCharArray[i], map.get(inputCharArray[i]) + 1);
        }
        Stack<Character> result = new Stack<>();
        for (char c: inputCharArray) {
            map.put(c, map.get(c) - 1);
            if (result.contains(c)) {
                continue;
            }
            else {
                while(result.size() > 0 && result.peek() - c > 0 && map.get(result.peek()) > 0) {
                    result.pop();
                }
                result.add(c);
            }
        }
        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        while (result.size() > 0) {
            sb.append(result.pop());
        }
        return sb.toString();
    }
}