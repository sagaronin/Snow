public class BuySellStock {
    // question
    /*
     * You are given an array prices where prices[i] is the price of a given stock
     * on the ith day.
     * 
     * You want to maximize your profit by choosing a single day to buy one stock
     * and choosing a different day in the future to sell that stock.
     * 
     * Return the maximum profit you can achieve from this transaction. If you
     * cannot achieve any profit, return 0.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit =
     * 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you
     * must buy before you sell.
     */
    public static void main(String[] args) {
        int prices[]={7,2,8,1,3,4,3};
        System.out.println("Max Profit: "+maxProfit(prices));

    }

    public static int maxProfit(int prices[]){
        //you have to always buy first hence buying on day 1
        int buy = prices[0];
        int profit=0;

        for (int i = 1; i < prices.length; i++) {
            //always check if current price is less that what you bought for
            //cuz there will definitely be no profit if price is less on ith day.
            if(prices[i]<buy){
                buy = prices[i];
            }else if(prices[i]-buy>profit){
                profit = prices[i]-buy;
            }
        }
        return profit;
    }
}
