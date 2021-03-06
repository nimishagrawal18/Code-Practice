package Blind75;

import java.util.HashMap;

// https://leetcode.com/problems/climbing-stairs/
public class ClimbStairs {
    
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(new ClimbStairs().climbStairsRecursive(50));
        System.out.println("Time = "+(System.currentTimeMillis()-startTime));
        startTime = System.currentTimeMillis();
        System.out.println(new ClimbStairs().climbStairs(50));
        HashMap<Integer,Integer> hm = new HashMap<>();
        System.out.println("Time = "+(System.currentTimeMillis()-startTime));
        // startTime = System.currentTimeMillis();
        System.out.println(new ClimbStairs().climbRec(50,0,hm));
        System.out.println("Time = "+(System.currentTimeMillis()-startTime));
        startTime = System.currentTimeMillis();
    }

    public int climbRec(int n,int pos,HashMap<Integer,Integer> hm) {
		if(hm.containsKey(pos)) return hm.get(pos);
		if (pos==n) return 1;
		if (pos>=n) return 0;
		int ans = climbRec(n,pos+1,hm)+climbRec(n,pos+2,hm);
		hm.put(pos,ans);
		return ans;
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
