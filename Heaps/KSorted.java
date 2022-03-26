package Heaps;

import java.util.PriorityQueue;

public class KSorted {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 5, 8, 4, 6, 7, 9};
        int k=3;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
        for (int i=0;i<k;i++) pq.add(arr[i]);
        for(int i=k;i<arr.length;i++) {
            System.out.println(pq);
            System.out.println(pq.poll());
            pq.add(arr[i]);
        }
        while(!pq.isEmpty()) System.out.println(pq.poll());
    }
}
