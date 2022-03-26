package Hashing;

import java.util.HashSet;
import java.util.Scanner;

//To find the sub array within an array with the given sum

public class GivenSumSubArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter element to search");
        int n= sc.nextInt();
        System.out.println("Enter length of array");
        int l= sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements now");
        for (int x=0;x<arr.length;x++) {
            arr[x]=sc.nextInt();
        }
        sc.close();

        HashSet<Integer> prfx= new HashSet<>();
        int pre_sum=0;
        for (int i=0; i<l; i++) {
            pre_sum+=arr[i];
            if (pre_sum==n || prfx.contains(pre_sum-n)) {
                System.out.print("Found!");
                return;
            }
            prfx.add(pre_sum-n);
        }
        System.out.print("Not Found!");
    }
}
