package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class howSum {
    public static void main(String[] args)
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(25);
        howSum ob = new howSum();
        HashMap<Integer,List<Integer>> memo = new HashMap<Integer,List<Integer>>();
        try {
            System.out.println(ob.getSum(100, list, memo).toString());
            memo = new HashMap<Integer,List<Integer>>();
            System.out.println(ob.bestSum(55, list, memo).toString());
        }
        catch (Exception e) {
            System.out.println("null");
        }
    }
    List<Integer> getSum(int sum, List<Integer> list, HashMap<Integer,List<Integer>> memo) {
        if (memo.containsKey(sum)) return memo.get(sum);
        if (sum==0) {
            return new ArrayList<Integer>();
        }
        else if (sum<0) return null;

        for (int n: list ) {
            // int res =  ;
            List<Integer> al = getSum(sum-n,list,memo);
            if (al!=null) {
                al.add(n);

                memo.put(sum,al);
                return al;
            }
        }
        memo.put(sum,null);
        return null;
    }

    List<Integer> bestSum(int sum, List<Integer> list, HashMap<Integer,List<Integer>> memo) {
        if (memo.containsKey(sum)) return memo.get(sum);
        if (sum==0) return new ArrayList<Integer>();
        if (sum<0) return null;
        List<Integer> shortest = null;
        for (int n: list ) {
            // int res =  ;
            List<Integer> al = bestSum(sum-n,list,memo);
            if (al!=null) {
                al.add(n);

                if (shortest==null || shortest.size()> al.size()) {
                    shortest = al;
                    //memo.replace(sum, shortest);

                    //return shortest;
                }
            }
        }
        if (memo.containsKey(sum)) memo.remove(sum);
        memo.put(sum,shortest);
        return shortest;
    }
}