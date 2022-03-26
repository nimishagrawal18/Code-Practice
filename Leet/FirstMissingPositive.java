package Leet;

import java.util.PriorityQueue;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int min = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        
        while (!pq.isEmpty()) {
            int in = pq.remove();
            if(in > 0) {
                if (min<in) return min;
                if (min==in) min++;
            }

        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] {1,1,2,0}));
    }
}
