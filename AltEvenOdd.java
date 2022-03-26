import java.util.Scanner;

public class AltEvenOdd {
    // To print the max length of sub-array where even and odd number alternate
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

        int max=1,curr=arr[0]%2,res=1;
        //res is the final result where we put the max value of 'max', which is actually the currnet count
        for (int i=1;i<n;i++) {
            if(arr[i]%2!=curr) max++;
            else max=1;
            curr=arr[i]%2;
            res=Math.max(res, max);
        }

        System.out.print(max);
    }
}
