package Hashing;

import java.util.HashSet;
import java.util.Scanner;

// To find the longest subsequence within an array containing consecutive numbers

public class ConsecSubSeq {
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
        
        HashSet<Integer> hs=new HashSet<Integer>();
        for (int i:arr)
            hs.add(i);
        int ctr=1,max=1;
        for(int i:hs) {
            if(hs.contains(i-1)) continue;
            while (hs.contains(++i)) ctr++;
            max=Math.max(max, ctr);
            ctr=1;
        }
        System.out.print(max);
    }
}
