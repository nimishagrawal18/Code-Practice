package Hashing;

import java.util.*;

// to find if we have a subarray which has sum=0
public class ZeroSubarray {
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

        HashSet<Integer> prfx= new HashSet<>();
        int pre_sum=0;
        for (int i=0; i<n;i++) {
            pre_sum+=arr[i];
            if (pre_sum==0 || prfx.contains(pre_sum)) {
                System.out.print("Found!");
                return;
            } else {
                prfx.add(pre_sum);
            }
        }
        System.out.print("Not Found!");
    }
}
