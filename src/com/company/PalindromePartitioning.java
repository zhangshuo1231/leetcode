package com.company;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }
    static List<List<String>> resultLst;
    static ArrayList<String> currLst;

    public static List<List<String>> partition(String s) {
        resultLst = new ArrayList<>();
        currLst = new ArrayList<>();
        backTrack(s,0);
        return resultLst;
    }

    private static void backTrack(String s, int l){
        if(currLst.size()>0 && l==s.length()){
            List<String> r = (ArrayList<String>) currLst.clone();
            resultLst.add(r);
        }
        for(int i=l;i<s.length();i++){
            if(isPalindrome(s,l,i)){
                currLst.add(s.substring(l,i+1));
                backTrack(s,i+1);
                currLst.remove(currLst.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String str, int l, int r){
        if(l==r) return true;
        while(l<r){
            if(str.charAt(l++)!=str.charAt(r--))
                return false;
        }
        return true;
    }
}
