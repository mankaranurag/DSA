package com.arrays;

/**
 * @author Anurag <br />
 *         <link>https://leetcode.com/problems/best-time-to-buy-and-sell-stock/</link>
 *         LeetCode
 */
public class BestTimeToBuySellStock {
	public int maxProfit(int[] prices) {
        int actualMaxProfit = 0;
        int buyPrice = prices[0];
        for(int i=1;i<prices.length;i++){
            int profitIfSoldToday = prices[i]/*current day price*/ - buyPrice;
            if(prices[i]/*current day price*/ < buyPrice) buyPrice = prices[i]/*current day price*/;
            if(profitIfSoldToday > actualMaxProfit) actualMaxProfit = profitIfSoldToday; 
        }
        return actualMaxProfit;
    }
}
