package LeetDS;

// import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class MaxSubarray {
    
    public static void main(String[] args) {
        MaxSubarray ob = new MaxSubarray();
        int[] x = {1,2,-1,-2,2,1,-2,1,4,-5,4};
        System.out.println(ob.maxSubArray(x));
    }

    public int maxSubArray(int[] nums) {
        int sum;
        int maxArr[] = new int[nums.length];
        maxArr[0]=nums[0];
        sum=maxArr[0];
        for (int i = 1; i < nums.length; i++) {
            maxArr[i]=Math.max(nums[i]+maxArr[i-1],nums[i]);
            sum=Math.max(sum, maxArr[i]);
        }
        for (int i : maxArr) {
            System.out.println(i);
        }
        return sum;
    }
}