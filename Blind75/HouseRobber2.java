package Blind75;

import java.util.HashMap;

// https://leetcode.com/problems/house-robber-ii/
public class HouseRobber2 {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }

    public static int rob(int[] nums) {
        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        if (nums.length<=3) return nums.length==2?Math.max(nums[0],nums[1]):Math.max(Math.max(nums[0],nums[1]),nums[2]);
        int x = rob(nums, 0, new HashMap<Integer, Integer>(),nums.length-2);
        return Math.max(rob(nums, 1, new HashMap<Integer, Integer>(),nums.length-1),x);
    }

    public static int rob(int[] nums, int index, HashMap<Integer, Integer> memo, int limit) {
        if (index > limit)
            return 0;
        if (memo.containsKey(index))
            return memo.get(index);
        int max = 0;
        for (int i = index; i <= limit; i++) {
            max = Math.max(rob(nums, i + 2, memo,limit) + nums[i], max);
        }
        memo.put(index, max);
        return max;
    }
}
