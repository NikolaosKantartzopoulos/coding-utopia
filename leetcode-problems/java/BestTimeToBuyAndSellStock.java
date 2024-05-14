package problems;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
// Sliding window
// Space O(1) - Time O(n)
public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return  maxProfit;
    }
}

