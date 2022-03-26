package BinarySearchQs;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9,15};
        int ans=search(arr,11,0,arr.length-1);
        if(ans==-1) System.out.println("Not found");
        else System.out.println("Found at index "+ans);
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
