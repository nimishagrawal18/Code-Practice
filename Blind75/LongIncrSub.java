package Blind75;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/longest-increasing-subsequence/
public class LongIncrSub {

    public static void main(String[] args) {
        System.out.println(lengthOfLIScall(new int [] {0,1,0,3,2,3}));
        System.out.println(lengthOfLIS(new int [] {0,1,0,3,2,3}));
    }

    public static int lengthOfLIScall(int[] nums) {
        if (nums.length==0) return 0;
        HashMap<Integer,Integer> memo = new HashMap<Integer,Integer>();
        //memo.put(nums.length-1,1);
        return lengthOfLISRec(nums,0,memo);
    }

    public static int lengthOfLIS(int[] nums) {
        int ar[] =new int[nums.length];
        Arrays.fill(ar,1);
        int max = 1;
        for (int i = ar.length-1; i >= 0; i--) {
            
            for (int j = i+1; j < ar.length; j++) {
                if (nums[i]<nums[j])
                    ar[i] = Math.max(ar[j]+1,ar[i]);
            }
            max = Math.max(ar[i], max);
        }
        return max;
    }

    // Recursive solution - failing a test case, not sure why
    private static int lengthOfLISRec(int[] nums, int x, HashMap<Integer,Integer> memo) {
        if (x==nums.length-1) return 1;
        if (memo.containsKey(x)) return memo.get(x);
        int max= 1, prev = nums[nums.length-1];
        for (int i=nums.length-1;i>x;i--) {
            if (prev>nums[i])
                max = Math.max(lengthOfLISRec(nums,i,memo)+1,max);

            prev=nums[i];
        }
        memo.put(x, max);
        return max;
    }
}
