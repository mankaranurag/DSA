package com.arrays;

/**
 * @author Anurag <br />
 * <link>https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/</link>
 * LeetCode
 */
public class BestTimeToBuySellStockII {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPriceDay = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[buyPriceDay];
            if (profit > 0) {
                maxProfit += profit;
            }
            buyPriceDay = i;
        }
        return maxProfit;
    }
}
