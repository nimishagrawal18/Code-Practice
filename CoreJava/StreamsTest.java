package CoreJava;


// import java.util.AbstractList;
import java.util.ArrayDeque;
// import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
// import java.util.Collections;
import java.util.List;
// import java.util.TreeSet;
import java.util.PriorityQueue;
import java.util.TreeMap;
// import java.util.Random;
import java.util.stream.Collectors;
// import java.util.stream.Stream;

public class StreamsTest {
    public static void main(String[] args) {
        
        // Random rnd = new Random();
        
        // rnd.ints().limit(120).sorted().forEach(num -> System.out.println(num));
        
        List<String> tList = Arrays.asList("-1","-2","0","-4","4","5","8","2","-1");
        List<String> str = tList.stream().limit(12).sorted().distinct().collect(Collectors.toList());
        System.out.println(str);

        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
        ad.offer(1);
        ad.offer(2);
        ad.offer(3);
        ad.offer(4);
        ad.offer(5);
        System.out.println(ad.remove());
        System.out.println(ad);
        System.out.println(ad.peek());
        System.out.println(ad.pollLast());
        System.out.println(ad.pollFirst());

        // TreeSet<Integer> ts = new TreeSet<>();
        
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        tm.put(1, tm.getOrDefault(1, 0)+1);
        tm.put(3, tm.getOrDefault(3, 0)+1);
        tm.put(1, tm.getOrDefault(1, 0)+1);
        tm.put(5, tm.getOrDefault(5, 0)+1);
        tm.put(2, tm.getOrDefault(2, 0)+1);
        tm.put(7, tm.getOrDefault(7, 0)+1);
        tm.put(7, tm.getOrDefault(7, 0)+1);

        ArrayDeque<Integer> Q = new ArrayDeque<>();

    

        // while () {
        //     System.out.println(integer);
        // }

        // ArrayList<Integer> it = new ArrayList<Integer>();
        

        // System.out.println(x);

        // for (int i : lis) {
        //     System.out.println(i);
        // }
        // System.out.println(li);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // Making this a Max heap
        pq.add(2);
        pq.add(4);
        pq.add(1);
        pq.add(6);
        pq.add(8);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }
}
