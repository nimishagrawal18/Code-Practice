package Blind75;

// https://leetcode.com/problems/climbing-stairs/
public class ClimbStars {
    
    public static void main(String[] args) {
        System.out.println(new ClimbStars().climbStairsRecursive(4));
        System.out.println(new ClimbStars().climbStairs(4));
    }

    public int climbStairsRecursive(int n) {
        if(n<=2) return n;
        int sum=climbStairsRecursive(n-1);
        sum+=climbStairsRecursive(n-2);
        return sum;
    }

    public int climbStairs(int n) {
        if(n<=2) return n;
        /*int dp[] = new int[n+1];
        dp[1]=1;
        dp[2]=2;*/
        int last1 = 1, last2 = 2;
        for (int i = 3; i <= n; i++) {
            //dp[i]=dp[i-1]+dp[i-2];
            int t = last2;
            last2 = last1+last2;
            last1 =t;
        }
        return last2;
    }
}
