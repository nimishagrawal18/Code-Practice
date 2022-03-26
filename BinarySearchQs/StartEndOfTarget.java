package BinarySearchQs;

public class StartEndOfTarget {
    public static void main(String[] args) {
        int arr[]={1,2,3,7,7,7,7,8,9,15};
        int start=FirstOccurence(arr,7,0,arr.length-1);
        if(start==-1) {
            System.out.println("Not found");
            return;
        }
        int end=LastOccurence(arr,7,0,arr.length-1);
        System.out.println("Found between index "+start+" and "+end);
    }
    public static int FirstOccurence(int[] arr, int target, int start, int end) {
        int mid,ans=-1;
        if (arr[0]==target) return 0;
        while (start<=end) {
            mid=start+(end-start)/2; 
            if(arr[mid]==target) {
                ans=mid;
                end=mid-1;
            }
            else if(arr[mid]>target) end=mid-1;
            else start=mid+1;
        }
        return ans; //Not Found
    }
    public static int LastOccurence(int[] arr, int target, int start, int end) {
        int mid,ans=-1;
        if (arr[arr.length-1]==target) return arr.length-1;
        while (start<=end) {
            mid=start+(end-start)/2; 
            if(arr[mid]==target) { 
                ans=mid;
                start=mid+1;
            }
            else if(arr[mid]>target) end=mid-1;
            else start=mid+1;
        }
        return ans; //Not Found 
    }
}
