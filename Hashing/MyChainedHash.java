package Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

// Hashing function based on modulo with the bucket size

// Based on chaining 

public class MyChainedHash {
    int BUCKET;
    ArrayList<LinkedList<Integer>> table;
    public MyChainedHash(int b) {
        BUCKET= b;
        table= new ArrayList<LinkedList<Integer>>();
        for(int i=0;i<b;i++) table.add(new LinkedList<Integer>());
    }
    void insert(int x) {
        int i=x%BUCKET;
        table.get(i).add(x);
    }
    void delete(int x) {
        int i=x%BUCKET;
        table.get(i).remove((Integer)i); 
        // Typecasting to object type to avoid passing it as an index and pass as value of the int
    }
    boolean search(int x) {
        int i=x%BUCKET;
        return table.get(i).contains((Integer)x);
    }
}
