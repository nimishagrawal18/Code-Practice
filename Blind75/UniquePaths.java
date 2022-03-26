package Blind75;


// https://leetcode.com/problems/unique-paths/
public class UniquePaths {
    public static int uniquePathsOld(int m, int n) {
        
        // if (m>n){
        // int t = m;
        // m=n;
        //     n=t;
        // }
        if (n<2 || m<2) return 1;

        int[][] memo = new int[m][n];
        for (int i = 0; i < memo.length; i++) memo[i][memo[0].length-1]=1;
        for (int j = 0; j < memo[0].length; j++) memo[memo.length-1][j]=1;
        // System.out.println(memo.length + " "+ memo[0].length);
        uniquePaths(m-2, n-2, memo);
        return memo[0][0];
    }

    public int uniquePathsNew(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i<m; i++)
            for(int j = 0; j<n; j++)
                dp[i][j] +=(i==0 || j==0)?1:dp[i-1][j]+dp[i][j-1];
        return dp[m-1][n-1];
    }

    private static void uniquePaths(int m, int n, int[][] memo) {
        int res = 0;
        if (n<memo[0].length-1) res+=memo[m][n+1];
        if (m<memo.length-1) res+=memo[m+1][n];
        memo[m][n]=res;

        if (m>0) uniquePaths(m-1, n, memo);
        if (n>0) uniquePaths(m, n-1, memo);


        // return memo[m][n];
    }
    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i<m; i++)
            for(int j = 0; j<n; j++)
                dp[i][j] +=(i==0 || j==0)?1:dp[i-1][j]+dp[i][j-1];
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        
        System.out.println(uniquePaths(51,9));
    }

}
