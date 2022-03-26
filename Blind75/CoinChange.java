package Blind75;

import java.util.HashMap;

// https://leetcode.com/problems/coin-change/
public class CoinChange {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[] { 1, 2, 3, 5, 7 }, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
        return coinChangeDP(coins, amount, memo);
    }

    public static int coinChangeDP(int[] coins, int amount, HashMap<Integer, Integer> memo) { // remove static for
                                                                                              // LeetCode
        if (memo.containsKey(amount))
            return memo.get(amount);
        if (amount < 0)
            return -1;
        if (amount == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int i : coins) {
            if (amount >= i) {
                int res = coinChangeDP(coins, amount - i, memo);
                if (res != -1) {
                    min = Math.min(min, res + 1);
                    // memo.put(amount, min);
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            memo.put(amount, -1);
            return -1;
        }
        memo.put(amount, min);
        return min;
    }

    public static int coinChangeNonDP(int[] coins, int amount) {
        if (amount <= 0)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int i : coins) {
            int res = coinChangeNonDP(coins, amount - i);
            if (amount >= i && res != -1)
                min = Math.min(min, res + 1);
        }
        if (min == Integer.MAX_VALUE)
            return -1;
        return min;
    }
}
