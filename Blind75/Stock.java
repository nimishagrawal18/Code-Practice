package Blind75;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class Stock {
    public static void main(String[] args) {
        Stock ob = new Stock();
        int[] ar = new int[]{2,1,2,1,0,1,2};
        System.out.println(ob.maxProfit(ar));
    }
    public int maxProfit(int[] prices) {
        
        int buy=0,sell=0,maxP=0;
        for (int i = 0; i < prices.length; i++) {
            
            maxP=Math.max(prices[sell]-prices[buy],maxP);
            if (prices[buy]>prices[sell]) {
                buy=sell;
            }
            sell++;
        
        }
        return maxP;
    }


}
