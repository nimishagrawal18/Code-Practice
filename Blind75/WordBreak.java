package Blind75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/word-break/
public class WordBreak {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("abc");
        list.add("b");
        list.add("cd");
        System.out.println(wordBreak("abcd", list));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> memo = new HashMap<String, Boolean>();
        return wordBreakRec(s, wordDict, memo);
    }

    private static boolean wordBreakRec(String s, List<String> wordDict, HashMap<String, Boolean> memo) {
        if (memo.containsKey(s))
            return memo.get(s);
        if (s.length() == 0)
            return true;
        // boolean out = false;
        for (String word : wordDict) {
            if (s.startsWith(word) && wordBreakRec(s.substring(word.length()), wordDict, memo)) {
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }
}
