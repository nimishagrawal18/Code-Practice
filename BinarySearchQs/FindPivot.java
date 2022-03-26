package BinarySearchQs;

//Program to find by how many indexes an array is rotated right
public class FindPivot {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,9};
        int ans=searchPivot(arr,0,arr.length-1);
        if(ans==-1) System.out.println("Not Rotated");
        else System.out.println("Rotated by "+(ans+1));

        // checking for non-distinct -
        int arr2[]={2,2,2,2,2,3,9,1,2};
        ans=searchPivot(arr2,0,arr2.length-1);
        if(ans==-1) System.out.println("Not Rotated");
        else System.out.println("Rotated by "+(ans+1));
        // To search in the rotated soreted array, just call the regular Binary Search twice --
        // once for start to pivot, once from pivot+1 to end. 
    }
    public static int searchPivot(int[] arr, int start, int end) {
        int mid;
        while (start<=end) {
            mid=start+(end-start)/2; 
            if(mid<end && arr[mid]>arr[mid+1]) return mid; // found the pivot
            if(mid>start && arr[mid]<arr[mid-1]) return mid-1; // found pivot
            /* Below can be done if the elements are distinct --
            
            if(arr[start]>=arr[mid]) end=mid-1; // means that mid is in the second part of arr
            else start=mid+1; // means mid is in the first part and we need to look beyond it
            */

            // to account for repeating numbers -
            if(arr[mid]==arr[start] && arr[end]==arr[mid]) {
                // this means that the pivot can be anywhere (e.g. - {2,9,2,2,2})
                // in this case we skip the duplicates from either end, 
                // after confirming they are not the pivot or next to it
                if(arr[start]>arr[start+1]) return start; //start is the pivot
                start++;
                if(arr[end]<arr[end-1]) return end-1;
                end--;
            }
            else if (arr[mid]>arr[start] || (arr[start]==arr[mid] && arr[mid]>arr[end])) {
                start=mid+1;
            }
            else end=mid-1;

        }
        return -1; //Not Found
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
