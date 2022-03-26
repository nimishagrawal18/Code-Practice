package CycleSort;

// Cycle sort is only helpful for consecutive numbers in the range of 1 to n 
public class CycleSort {
    public static void main(String[] args) {
        int[] arr={6,3,4,1,2,5};
        sort(arr);
        for(int x:arr) System.out.print(x+" ");
    }
    private static void sort(int[] arr) {
        int i=0;
        while (i<arr.length) {
            int place=arr[i]-1;
            if(arr[i]!=(i+1)) {
                int t = arr[place];
                arr[place]=arr[i];
                arr[i]=t;
            }
            else i++;
        }
    }
}
