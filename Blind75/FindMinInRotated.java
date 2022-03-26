package Blind75;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/
public class FindMinInRotated {

    public static void main(String[] args) {
        FindMinInRotated ob = new FindMinInRotated();
        int[] ar = new int[] { 3, 4, 5, 1, 2 };
        System.out.println(ob.findMin(ar));
    }

    public int findMin(int[] nums) {
        return nums[searchPivot(nums, 0, nums.length - 1)+1];
    }

    public static int searchPivot(int[] arr, int start, int end) {
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1])
                return mid; 
            if (mid > start && arr[mid] < arr[mid - 1])
                return mid - 1; 

            if (arr[start] >= arr[mid])
                end = mid - 1; 
            else
                start = mid + 1; 

        }
        return -1; // Not Found
    }
}
