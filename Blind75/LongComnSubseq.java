package Blind75;

// https://leetcode.com/problems/longest-common-subsequence
public class LongComnSubseq {
    public static int longestCommonSubsequence(String text1, String text2) {
        // int[][] dp = new int[text1.length()][text2.length()];
        System.out.println(LCS(text1, text2));
        return LCSRec(text1, text2, 0, 0);
    }
    public static int LCSRec(String s1, String s2, int x, int y) {
        if(x==s1.length() || y==s2.length()) return 0;

        if (s1.charAt(x)==s2.charAt(y)) {
            // dp[x][y]= 
            return 1+ LCSRec(s1, s2, x+1, y+1);
        }
        // dp[x][y] = 
        return Math.max (LCSRec(s1, s2, x+1, y), LCSRec(s1, s2, x, y+1));
    }

    public static int LCS(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        
        for (int x=text1.length()-1;x>=0;x--) {
            for (int y=text2.length()-1; y >= 0; y--) {
                if (text1.charAt(x)==text2.charAt(y)) 
                    dp[x][y] = dp[x+1][y+1] +1;
                else 
                    dp[x][y]= Math.max(dp[x+1][y],dp[x][y+1]); 
            }
        }
        return dp[0][0];
    } 

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }

    // Backup -
    // public static int LCSRec(String s1, String s2, int x, int y, int[][] dp) {
    //     if(x==dp.length || y==dp[0].length) return 0;
        
    //     if (s1.charAt(x)==s2.charAt(y)) {
    //         dp[x][y]= 1+ LCSRec(s1, s2, x+1, y+1, dp);
    //         return dp[x][y];
    //     }
    //     dp[x][y] = Math.max(LCSRec(s1, s2, x+1, y, dp), LCSRec(s1, s2, x, y+1, dp));
    //     return dp[x][y];
    // }
}
