import java.util.Scanner;

public class MaxSumSub {
    //Program to calculate maximum sub-array sum possible in an array of +ve and -ve ints
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
        int maxSum=arr[0],res=arr[0];
        for (int i=0;i<n;i++) {
            maxSum=Math.max(maxSum+arr[i],arr[i]);
            res=res>maxSum?res:maxSum;
        }
        System.out.print(res);
    }
}
