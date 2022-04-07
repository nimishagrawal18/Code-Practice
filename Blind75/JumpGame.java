package Blind75;

import java.util.ArrayDeque;
import java.util.HashSet;

public class JumpGame {
    public boolean canJump(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        Q.add(nums[0]);
        while (!Q.isEmpty()) {
            int x = Q.poll();
            if (x==nums.length-1) return true;
            int 
        }
        return false;
    }
}
