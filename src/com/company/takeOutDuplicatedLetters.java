package com.company;

import model.ListNode;
import model.Node;
import model.TreeNode;

import javax.print.DocFlavor;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class takeOutDuplicatedLetters {

    static int times = 0;

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bxshkpdwcsjdbikywvioxrypfzfbppydfilfxxtouzzjxaymjpmdoevv") + ", out of " + times + " valid full length results.");
    }

    public static String removeDuplicateLetters(String s) {
        char[] inputCharArray = s.toCharArray();
        Map<Character, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < inputCharArray.length; i++) {
            if (i != 0 && inputCharArray[i] == inputCharArray[i-1])
                continue;
            map.putIfAbsent(inputCharArray[i], new ArrayList<>());
            map.get(inputCharArray[i]).add(i);
        }
        int finalLength = map.size();
        int inputLength = inputCharArray.length;
        List<Integer> ansList = new ArrayList<>();
        List<Character> lettersList = new ArrayList<>();
        List<List<Integer>> positionList = new ArrayList<>();
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            lettersList.add(entry.getKey());
            positionList.add(entry.getValue());
        }
        backtrack(ansList, new ArrayList<>(), lettersList, positionList, finalLength, inputLength);
        return getString(ansList, lettersList, inputLength);
    }

    private static void backtrack(List<Integer> ansList, List<Integer> tempList, List<Character> lettersList, List<List<Integer>> positionsLists, int finalLength, int inputLength){
        if (tempList.size() == finalLength) {
            times++;
            if (ansList.size() == 0 || win(tempList, ansList, lettersList, inputLength)) {
                ansList.clear();
                ansList.addAll(tempList);
            }
            return;
        }
        int currentNumberOfChars = tempList.size(); // current letter's index in the map equals the length of the tempList
        for (int i : positionsLists.get(currentNumberOfChars)) {
            tempList.add(i);
            backtrack(ansList, tempList, lettersList, positionsLists, finalLength, inputLength);
            tempList.remove(tempList.size() - 1);
        }
    }

    private static boolean win(List<Integer> newList, List<Integer> currList, List<Character> lettersList, int inputLength) {
        String newString = getString(newList, lettersList, inputLength);
        String oldString = getString(currList, lettersList, inputLength);
        return newString.compareTo(oldString) < 0;
    }

    private static String getString(List<Integer> tempList, List<Character> lettersList, int inputLength) {
        char[] sequence = new char[inputLength];
        for (int i = 0; i < tempList.size(); i++) {
            sequence[tempList.get(i)] = lettersList.get(i);
        }
        StringBuilder sb = new StringBuilder();
        for(char c : sequence) {
            if (c >= 'a' && c <= 'z')
                sb.append(c);
        }
        return sb.toString();
    }
}