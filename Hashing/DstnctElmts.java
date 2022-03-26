package Hashing;


import java.util.*;

// Class to Count the number of distinct elements in a array. 
// (Can be modified slightly to print all distinct elements)

public class DstnctElmts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of array");
        int n= sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter elements now");
        for (int x=0;x<arr.length;x++) {
            arr[x]=sc.nextInt();
        }
        System.out.println("Enter size of window (k)");
        int k = sc.nextInt();
        sc.close();
        
        Map<Integer,Integer> hs=new HashMap<>();

        for (int i=0;i<k;i++) {
            if(!hs.containsKey(arr[i])) hs.put(arr[i],1);
            else hs.put(arr[i],hs.get(arr[i])+1);
        }
        for (int i=1;i<n-k;i++) {
            
        }
        System.out.print("There are "+hs.size()+" unique values ");
        
        System.out.println(hs);

    }    
}
