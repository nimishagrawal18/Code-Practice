package Leet;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int sum=0;
        int[] out=new int[2];
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++) {
            for (int j=i+1;j<nums.length;j++) {
                sum=nums[i]+nums[j];
                if (sum==target) {
                    out[0]=i;
                    out[1]=j;
                    return out;
                }
                if (sum>target) break;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int ar[]={3,2,4};
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(ar[1], 1);
    }
}
