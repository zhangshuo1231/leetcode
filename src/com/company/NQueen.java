package com.company;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), n);
        List<List<String>> result = new ArrayList<>();
        for (List<Integer> curr : list) {
            result.add(convert(curr));
        }
        return result;
    }

    // 判断
    // for 各种选择
        // 前进一步
        // backtrack
        // 后退一步
    private static void backtrack(List<List<Integer>> list, List<Integer> temp, int n) {
        if (!isLastPosValid(temp)) {
            return;
        }
        if (temp.size() == n) {
            list.add(new ArrayList<>(temp));
            return;
        }
        else {
            for (int pos = 0; pos < n; pos++) {
                temp.add(pos);
                backtrack(list, temp, n);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private static boolean isLastPosValid(List<Integer> temp) {
        if (temp.size() == 0)
            return true;
        int lastColumnIndex = temp.get(temp.size() - 1);
        int diagonal =  temp.size() - 1 - temp.get(temp.size() - 1);
        int diagonal_rev = temp.size() - 1 + temp.get(temp.size() - 1);
        for (int i = 0; i < temp.size() - 1; i++) {
            if (temp.get(i) == lastColumnIndex) {
                return false;
            }
            else if (i - temp.get(i) == diagonal) {
                return false;
            }
            else if (i + temp.get(i) == diagonal_rev) {
                return false;
            }
        }
        return true;
    }

    private static List<String> convert(List<Integer> orig) {
        int level = orig.size();
        List<String> list = new ArrayList<>();
        for (int i : orig) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < level; j++) {
                if (i == j) {
                    sb.append("Q");
                }
                else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        return list;
    }
}
