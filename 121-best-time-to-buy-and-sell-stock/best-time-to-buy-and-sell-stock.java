class Solution {
    public static int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            int sellPrice = prices[i];
            if (buyPrice < sellPrice) {
                profit = Math.max(profit, (sellPrice - buyPrice));
            }else {
                buyPrice = sellPrice;
            }
        }
        return profit;
    }
}