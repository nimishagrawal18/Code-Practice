package Blind75;

import java.util.HashMap;

// https://leetcode.com/problems/decode-ways/
public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(numDecodings("12131"));
    }
    public static int numDecodings(String s) {
        if (s.charAt(0)=='0') return 0;
        HashMap<Integer,Integer> memo = new HashMap<>();
        return numDecodings(s, 0, memo);
    }
    public static int numDecodings(String s,int index, HashMap<Integer,Integer> memo) {
        
        if (index == s.length()) return 1;
        if (index > s.length()) return 0;
        
        if (memo.containsKey(index)) return memo.get(index);

        char c = s.charAt(index);
        if (c=='0') {
            memo.put(index, 0);
            return 0;
        }
        
        int res = 0;

        if (c=='1') {
            res += numDecodings(s, index+2,memo);
        }
        else if (c=='2' && index < s.length()-1 && s.charAt(index+1)>='0' && s.charAt(index+1)<='6') {
            res += numDecodings(s, index+2,memo);
        }
        res += numDecodings(s, index+1,memo);

        memo.put(index, res);
        return res;
    }
}
