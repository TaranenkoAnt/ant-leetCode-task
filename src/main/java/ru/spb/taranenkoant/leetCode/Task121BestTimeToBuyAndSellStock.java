package ru.spb.taranenkoant.leetCode;


/**
 * {@code @author:} TaranenkoAnt
 * {@code @createDate:} 10.11.2025
 */
public class Task121BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                if (prices[i] - min > maxProfit) {
                    maxProfit = prices[i] - min;
                }
            }
        }
        return maxProfit;
    }
}
