package Hashing;

import java.util.HashMap;
import java.util.Scanner;

public class GivenSSALongest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sum to search");
        int n= sc.nextInt();
        System.out.println("Enter length of array");
        int l= sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements now");
        for (int x=0;x<arr.length;x++) {
            arr[x]=sc.nextInt();
        }
        sc.close();

        HashMap<Integer,Integer> prfx= new HashMap<>();
        int pre_sum=0,ans=0;
        for (int i=0; i<l; i++) {
            pre_sum+=arr[ i];
            if (pre_sum==n) ans=i+1;
            if(!prfx.containsKey(pre_sum-n)) prfx.put(pre_sum,i);
            else ans=Math.max(ans,(i-prfx.get(pre_sum-n)));
        }
        System.out.print("Not Found!");
    }
}
