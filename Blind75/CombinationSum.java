package Blind75;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/
public class CombinationSum {

    public static void main(String[] args) {
        List<List<Integer>> l = combinationSum(new int[] { 2, 3, 5 }, 8);
        for (List<Integer> list : l) {
            for (Integer list2 : list) {
                System.out.print(list2 + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> out = new ArrayList<List<Integer>>();
        combinationSum(0, candidates, target, out, new ArrayList<>());
        return out;

    }

    public static void combinationSum(int index, int[] cand, int target, List<List<Integer>> res, List<Integer> temp) {
        while (index <= cand.length) {
            if (index == cand.length) {

                if (target == 0) {

                    res.add(new ArrayList<>(temp));
                }
                return;
            }
            if (cand[index] <= target) {

                temp.add(cand[index]);
                combinationSum(index, cand, target - cand[index], res, temp);
                temp.remove(temp.size() - 1);
            }
            index++;
        }
    }
}
/*
 * public static void combinationSum(int index, int[] cand, int target,
 * List<List<Integer>> res, List<Integer> temp) {
 * if(index == cand.length) {
 * 
 * if(target == 0) {
 * 
 * res.add(new ArrayList<>(temp));
 * }
 * return;
 * }
 * if(cand[index] <= target) {
 * 
 * temp.add(cand[index]);
 * combinationSum(index, cand, target - cand[index], res, temp);
 * temp.remove(temp.size() - 1);
 * }
 * combinationSum(index+1, cand, target, res, temp);
 * }
 * }
 */
