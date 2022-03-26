import java.util.Scanner;

public class QSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array");
        int n= sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements now");
        for (int x=0;x<arr.length;x++) {
            arr[x]=sc.nextInt();
        }
        sc.close();

        qSort(arr,0,arr.length-1);

        System.out.println("The Sorted array is - ");
        for (int x : arr ) {
            System.out.print(x+" ");
        }
    }
    public static void qSort (int[] ar,int l,int h){
        if (l<h) {
        int p=partition(ar, l, h);
        qSort(ar, l, p);
        qSort(ar, p+1, h);
        }
    }
    static int partition(int[] ar,int l, int h) {
        int pivot = ar[l];
        int i=l-1,j=h+1;
        while (true) {
            do {
                i++;
            } while(pivot>ar[i]);
            do {
                j--;
            } while(pivot<ar[j]);
            if(i>=j) break;
            int t = ar[i];
            ar[i]=ar[j];
            ar[j]=t;
        }
        return i;
    }
}
