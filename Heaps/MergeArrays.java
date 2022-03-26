package Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
To merge K number of sorted arrays.
Uses Priority queue (Binary heap).
 */
public class MergeArrays {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> a1 = new ArrayList<Integer>();
       a1.add(10);
        a1.add(20);
        a1.add(30);
        arr.add(a1);

        ArrayList<Integer> a2 = new ArrayList<Integer>();
        a2.add(5);
        a2.add(15);
        arr.add(a2);

        ArrayList<Integer> a3 = new ArrayList<Integer>();
        a3.add(1);
        a3.add(9);
        a3.add(11);
        a3.add(18);
        arr.add(a3);
        // Input data setup ends here

        PriorityQueue<Triple> pq = new PriorityQueue<>();
        int k= arr.size();
        ArrayList<Integer> out = new ArrayList<>();

        for(int i=0;i<k;i++) // initially fill the PQ
        {
            pq.add(new Triple(arr.get(i).get(0),i,0));
        }
        while (!pq.isEmpty()) { // Popping the smallest of the K then add the next one for the same array
            Triple lo=pq.poll();
            out.add(lo.val);
            if(arr.get(lo.array).size()>(lo.index+1)){
                pq.add(new Triple(arr.get(lo.array).get(lo.index+1), lo.array, lo.index+1));
            }
        }

        System.out.println(out);

    }
}
class Triple implements Comparable<Triple>
{
    Integer val,array,index;
    public Triple(Integer val, Integer array, Integer index) {
        this.val = val;
        this.array = array;
        this.index = index;
    }

    @Override
    public int compareTo(Triple o) {
        return (val<=o.val)?-1:1;
    }
}
