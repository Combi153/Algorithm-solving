package leetcode.best_time_to_buy_and_sell_stock;

public class Solution {
    public int maxProfit(int[] prices) {
        int buyDay = 0;
        int sellDay = 1;
        int maxProfit = 0;

        while (sellDay < prices.length) {
            int buyPrice = prices[buyDay];
            int sellPrice = prices[sellDay];
            int profit = sellPrice - buyPrice;
            if (profit < 0) {
                buyDay += 1;
            } else if (profit > 0 && profit > maxProfit) {
                maxProfit = profit;
                sellDay += 1;
            } else {
                sellDay += 1;
            }
        }
        return maxProfit;
    }

}
