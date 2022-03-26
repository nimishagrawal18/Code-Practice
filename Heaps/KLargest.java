package Heaps;

import java.util.PriorityQueue;

public class KLargest {
    public static void main(String[] args) {
        int arr[]= {5,15,10,20,8,25,18};
        int k=3;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
        for (int i=0;i<k;i++) pq.add(arr[i]);
        for(int i=k;i<arr.length;i++) {
            if(pq.peek()<arr[i]) {
                //int t=pq.poll();
                pq.add(arr[i]);
            }
        }
        while(!pq.isEmpty()) System.out.println(pq.poll());
    }
}
