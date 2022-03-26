package Heaps;

import java.util.*;

class Pair {
    Integer diff;
    Integer index;
    Pair(Integer diff,Integer index) {
        this.diff=diff;
        this.index=index;
    }
    Integer getDiff() {
        return diff;
    }
}

public class KClosest {
    public static void main(String[] args) {
        int[] arr = {5,15,10,20,8,25,18};
        int k=3,n=12;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                new Comparator<Pair>()
                {
                    public int compare(Pair p1, Pair p2)
                    {
                        return p2.getDiff().compareTo(p1.getDiff());
                    }
                });
        for (int i=0;i<k;i++) pq.add(new Pair(Math.abs(arr[i]-n),i));
        for(int i=k;i<arr.length;i++) {
            if(pq.peek().diff>Math.abs(arr[i]-n)) {
                //Pair t=pq.poll();
                pq.add(new Pair(Math.abs(arr[i]-n),i));
            }
        }
        while(!pq.isEmpty()) System.out.println(arr[pq.poll().index]);
    }
}
