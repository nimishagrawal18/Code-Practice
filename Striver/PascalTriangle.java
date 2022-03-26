package Striver;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/submissions/
public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> out = new ArrayList<List<Integer>>();  
        ArrayList<Integer> row = new ArrayList<Integer>();
        row.add(1);
        out.add(row);
        for (int i=1;i<numRows;i++) {
            row = new ArrayList<Integer>();
            row.add(1);
            for (int j = 1; j <= i-1 ; j++) {
                row.add(out.get(i-1).get(j-1)+out.get(i-1).get(j));
            }
            row.add(1);
            out.add(row);
        }
        return out;
    }
    public static void main(String[] args) 
    {
        List<List<Integer>> out =generate(8);
        for (List<Integer> list : out) {
            System.out.println(list);    
        }
    }
}
