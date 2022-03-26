package Leet;

// https://leetcode.com/problems/three-consecutive-odds/submissions/

public class consecOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 1; i < arr.length-1; i++) 
            if ((arr[i]&1)==1 && arr[i-1]==arr[i] && arr[i+1]==arr[i]) 
                return true;
        return false;
        
    }
}
