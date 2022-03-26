package Blind75;

import java.util.HashMap;

// https://leetcode.com/problems/house-robber/
public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }

    public static int rob(int[] nums) {
        return rob(nums, 0, new HashMap<Integer, Integer>());
    }

    public static int rob(int[] nums, int index, HashMap<Integer, Integer> memo) {
        if (index > nums.length - 1)
            return 0;
        if (memo.containsKey(index))
            return memo.get(index);
        int max = 0;
        for (int i = index; i < nums.length; i++) {
            max = Math.max(rob(nums, i + 2, memo) + nums[i], max);
        }
        memo.put(index, max);
        return max;
    }
}
