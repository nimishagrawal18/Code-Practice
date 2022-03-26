package Blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/word-break/
public class ThreeSum {
    
    public static void main(String[] args) {
        // System.out.println(threeSum(new int[]{3,-1,0,1,2,-1,-4}));
        // System.out.println(threeSum(new int[]{0,0,0}));
        System.out.println(threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> out=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if (nums.length<3) return out;
        
        int prevI = nums[0];
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i]==prevI && i!=0) {
                prevI = nums[i];
                continue;
            }
            int pL = nums[i+1],l=i+1,r=nums.length-1;
            while (l<r) {
                if(pL==nums[l] && l!=i+1) l++;
                
                else {
                    
                    int s = nums[l]+nums[r]+nums[i];
                    if (s==0) {
                        ArrayList<Integer> al = new ArrayList<Integer>();
                        al.add(nums[i]);
                        al.add(nums[l]);
                        al.add(nums[r]);
                        out.add(al);
                        pL = nums[l];
                        l++;
                        r--;
                    }
                    else if (s<0)
                    {
                        pL = nums[l];
                        l++;
                    }
                    else
                    r--;
                }
                
            }
            prevI = nums[i];
        }

        return out;
    }
}
