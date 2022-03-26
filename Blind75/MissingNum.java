package Blind75;

// https://leetcode.com/problems/missing-number/
public class MissingNum {

    public int missingNumber(int[] nums) {
        
        // Sum of numbers 1 to n = n(1+n)/2  
        int expected = ((nums.length+1)*nums.length)/2;

        //int actual = 0;
        for (int i : nums) {
            expected-=i;
        }
        
        return expected;
    }
}
