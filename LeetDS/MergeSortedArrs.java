package LeetDS;



public class MergeSortedArrs {

    public static void main(String[] args) {
        int[] ar1 = { 1, 2, 3, 0, 0, 0 };
        int ar2[] = { 2, 5, 6 };

        // int[] ar1 = { 1, 0 };
        // int ar2[] = { 2 };
        merge(ar1, 3, ar2, 3);
        for (int i : ar1) {
            System.out.println(i);
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // int p1=0,p2=0;

        
    }

    static void shift(int[] ar, int pos) {
        for (int i = ar.length - 1; i>pos && i>0; i--) {
            ar[i] = ar[i - 1];
        }
        // ar[pos]=0;
    }
}
