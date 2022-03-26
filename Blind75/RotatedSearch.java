package Blind75;

// https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/
public class RotatedSearch {
    
    public static void main(String[] args) {
        RotatedSearch ob = new RotatedSearch();
        int[] ar = new int[] { 1,3,5 };
        System.out.println(ob.search(ar,0));
    }

    public int search(int[] nums, int target) {
        
        if (nums.length==1) return nums[0]==target?0:-1;

        int pivot = searchPivot(nums, 0, nums.length-1);
        if(pivot==-1) return search(nums, target, 0, nums.length-1);

        int ans = search(nums, target, 0, pivot);
        if (ans!=-1) return ans;
        return search(nums, target, pivot+1, nums.length-1);

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
    public static int search(int[] arr, int target, int start, int end) {
        int mid;
        while (start<=end) {
            mid=start+(end-start)/2; 
            if(arr[mid]==target) return mid;
            if(arr[mid]>target) end=mid-1;
            else start=mid+1;
        }
        return -1; //Not Found
    }
}
