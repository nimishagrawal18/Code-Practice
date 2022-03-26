package Hashing;

import java.util.*;

public class CountFreq {
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
        // End input code

        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i : arr) {
            if (hm.containsKey(i))
                hm.put(i,hm.get(i)+1);
            else {
                hm.put(i, 1);
            }
        }

        System.out.println("The freqs are - "+hm);
    }
}
